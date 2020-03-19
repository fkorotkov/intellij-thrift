package com.intellij.plugins.thrift.jps;

import com.intellij.execution.process.BaseOSProcessHandler;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.CharsetToolkit;
import com.intellij.plugins.thrift.config.ThriftCompilerOptions;
import com.intellij.plugins.thrift.config.ThriftConfig;
import com.intellij.plugins.thrift.config.target.Generator;
import com.intellij.plugins.thrift.config.target.IGenerator;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.jps.ModuleChunk;
import org.jetbrains.jps.builders.DirtyFilesHolder;
import org.jetbrains.jps.builders.FileProcessor;
import org.jetbrains.jps.builders.java.JavaSourceRootDescriptor;
import org.jetbrains.jps.incremental.*;
import org.jetbrains.jps.incremental.messages.BuildMessage;
import org.jetbrains.jps.incremental.messages.CompilerMessage;
import org.jetbrains.jps.model.module.JpsModule;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 26.06.2014 12:10
 *
 * @author xBlackCat
 */
public class ThriftBuilder extends ModuleLevelBuilder {
  protected static final String BUILDER_NAME = "Thrift compiler";

  protected ThriftBuilder() {
    super(BuilderCategory.SOURCE_GENERATOR);
  }

  @NotNull
  @Override
  public List<String> getCompilableFileExtensions() {
    return Collections.singletonList("thrift");
  }

  @Override
  public ExitCode build(CompileContext context,
                        ModuleChunk chunk,
                        DirtyFilesHolder<JavaSourceRootDescriptor, ModuleBuildTarget> dirtyFilesHolder,
                        ModuleLevelBuilder.OutputConsumer outputConsumer) throws ProjectBuildException, IOException {
    ThriftConfig thriftConfig = ThriftConfig.getSettings(context.getProjectDescriptor().getProject());

    final String compiler = thriftConfig.getCompilerPath();

    final Map<ModuleBuildTarget, List<File>> toCompile = collectChangedFiles(dirtyFilesHolder);

    List<String> cmdLine = new ArrayList<String>();
    cmdLine.add(compiler);

    if (thriftConfig.isNoWarn()) {
      cmdLine.add("-nowarn");
    }
    if (thriftConfig.isStrict()) {
      cmdLine.add("-strict");
    }
    if (thriftConfig.isVerbose()) {
      cmdLine.add("-verbose");
    }
    if (thriftConfig.isRecurse()) {
      cmdLine.add("-recurse");
    }
    if (thriftConfig.isDebug()) {
      cmdLine.add("-debug");
    }
    if (thriftConfig.isAllowNegKeys()) {
      cmdLine.add("--allow-neg-keys");
    }
    if (thriftConfig.isAllow64bitConsts()) {
      cmdLine.add("--allow-64bit-consts");
    }

    for (Map.Entry<ModuleBuildTarget, List<File>> e : toCompile.entrySet()) {
      final ModuleBuildTarget target = e.getKey();
      final JpsModule module = target.getModule();
      ThriftCompilerOptions options = ThriftCompilerOptions.getSettings(module);
      final List<File> sourceFiles = e.getValue();

      final List<Generator> generators = options.getGenerators();
      if (generators.isEmpty()) {
        context.processMessage(
          new CompilerMessage(
            getPresentableName(),
            BuildMessage.Kind.WARNING,
            "No valid translators found for module " + module.getName() + ". Check facet configuration."
          )
        );

        continue;
      }

      List<String> moduleCmdLine = new ArrayList<String>(cmdLine);
      for (String include : options.getIncludes()) {
        moduleCmdLine.add("-I");
        moduleCmdLine.add(include);
      }

      for (IGenerator g : generators) {
        List<String> genCmdLine = new ArrayList<String>(moduleCmdLine);
        genCmdLine.add("--gen");
        genCmdLine.add(g.getOptionsString());
        genCmdLine.add("-out");

        final String path = new URL(g.getOutputDir()).getPath();
        genCmdLine.add(path);
        final File targetDir = new File(path);

        if (options.isCleanOutput()) {
          try {
            FileUtils.cleanDirectory(targetDir);
          }
          catch (IOException ex) {
            context.processMessage(
              new CompilerMessage(getPresentableName(), BuildMessage.Kind.ERROR,
                                  "Failed to empty target directory: " + path + " . Error: " + ex.getMessage())
            );
            return ExitCode.ABORT;
          }
        }

        for (File source : sourceFiles) {
          compileFile(context, target, genCmdLine, source, targetDir);
        }
      }
    }

    return ExitCode.OK;
  }

  private void compileFile(final CompileContext context, ModuleBuildTarget target, List<String> line, File source, File dir)
    throws StopBuildException {
    final JpsModule module = target.getModule();
    List<String> cmdLine = new ArrayList<String>(line);
    cmdLine.add(source.getAbsolutePath());

    StringBuilder cmdMessage = new StringBuilder();
    for (String cmdPart : cmdLine) {
      cmdMessage.append(cmdPart).append(' ');
    }

    context.processMessage(
      new CompilerMessage(getPresentableName(), BuildMessage.Kind.INFO, cmdMessage.toString())
    );

    try {
      Process process = new ProcessBuilder()
        .command(cmdLine)
        .start();


      BaseOSProcessHandler handler = new BaseOSProcessHandler(process, StringUtil.join(cmdLine, " "), CharsetToolkit.UTF8_CHARSET);

      final AtomicBoolean hasErrors = new AtomicBoolean();
      handler.addProcessListener(new ThriftOutputConsumer(source.getAbsolutePath(), context, hasErrors, module, dir));
      handler.startNotify();
      handler.waitFor();
      if (hasErrors.get()) {
        throw new StopBuildException();
      }
    }
    catch (IOException e) {
      context.processMessage(
        new CompilerMessage(getPresentableName(), BuildMessage.Kind.ERROR, "Failed to translate files . Error: " + e.getMessage())
      );
    }
  }


  @NotNull
  @Override
  public String getPresentableName() {
    return BUILDER_NAME;
  }

  private Map<ModuleBuildTarget, List<File>> collectChangedFiles(
    DirtyFilesHolder<JavaSourceRootDescriptor, ModuleBuildTarget> dirtyFilesHolder
  ) throws IOException {
    final Map<ModuleBuildTarget, List<File>> toCompile = new HashMap<ModuleBuildTarget, List<File>>();
    dirtyFilesHolder.processDirtyFiles(
      new ThriftFilter(toCompile)
    );
    return toCompile;
  }

  private static class ThriftFilter implements FileProcessor<JavaSourceRootDescriptor, ModuleBuildTarget> {
    private final Map<ModuleBuildTarget, List<File>> myToCompile;

    public ThriftFilter(Map<ModuleBuildTarget, List<File>> toCompile) {
      myToCompile = toCompile;
    }

    public boolean apply(
      ModuleBuildTarget target,
      File file,
      JavaSourceRootDescriptor sourceRoot
    ) throws IOException {
      if (file.getName().endsWith(".thrift")) {
        List<File> files = myToCompile.get(target);
        if (files == null) {
          files = new ArrayList<File>();
          myToCompile.put(target, files);
        }
        files.add(file);
      }
      return true;
    }
  }
}
