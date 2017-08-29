package com.intellij.plugins.thrift.jps;

import com.intellij.execution.process.ProcessAdapter;
import com.intellij.execution.process.ProcessEvent;
import com.intellij.execution.process.ProcessOutputTypes;
import com.intellij.openapi.util.Key;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.jetbrains.jps.builders.java.JavaModuleBuildTargetType;
import org.jetbrains.jps.incremental.CompileContext;
import org.jetbrains.jps.incremental.ModuleBuildTarget;
import org.jetbrains.jps.incremental.messages.BuildMessage;
import org.jetbrains.jps.incremental.messages.CompilerMessage;
import org.jetbrains.jps.incremental.messages.FileGeneratedEvent;
import org.jetbrains.jps.model.module.JpsModule;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 10.07.2014 18:36
 *
 * @author xBlackCat
 */
class ThriftOutputConsumer extends ProcessAdapter {
  final StringBuilder errOutput;
  final StringBuilder stdOutput;
  private final String fileName;
  private final CompileContext myContext;
  private final AtomicBoolean myHasErrors;
  private final JpsModule myModule;
  private final File myTargetDir;

  public ThriftOutputConsumer(String fileName, CompileContext context, AtomicBoolean hasErrors, JpsModule module, File targetDir) {
    this.fileName = fileName;
    myContext = context;
    myHasErrors = hasErrors;
    myModule = module;
    stdOutput = new StringBuilder();
    errOutput = new StringBuilder();
    myTargetDir = targetDir;
  }

  @Override
  public void onTextAvailable(ProcessEvent event, Key outputType) {
    if (outputType == ProcessOutputTypes.STDERR) {
      stdOutput.append(event.getText());
    }
    else if (outputType == ProcessOutputTypes.STDOUT) {
      stdOutput.append(event.getText());
    }
  }

  @Override
  public void processTerminated(ProcessEvent event) {
    try {
      final String[] lines = stdOutput.append(errOutput).toString().split("\n\\s*");
      for (String line : lines) {
        final BuildMessage.Kind kind;
        final long lineNum;
        final String path;

        if (line.startsWith("[PARSE:")) {
          kind = BuildMessage.Kind.INFO;

          lineNum = Long.parseLong(line.substring(7, line.indexOf(']')));
          path = fileName;
        }
        else if (line.startsWith("[WARNING:") || line.startsWith("[FAILURE:") || line.startsWith("[ERROR:")) {
          if (line.charAt(1) == 'W') {
            kind = BuildMessage.Kind.WARNING;
          }
          else {
            kind = BuildMessage.Kind.ERROR;
            myHasErrors.set(true);
          }

          int infoClose = line.indexOf(']');
          if (infoClose == -1) {
            lineNum = -1L;
            path = fileName;
          }
          else {
            final int rowNumPos = line.lastIndexOf(':', infoClose);
            lineNum = Long.parseLong(line.substring(rowNumPos + 1, infoClose));
            path = line.substring(line.indexOf(':') + 1, rowNumPos);
          }
        }
        else {
          kind = BuildMessage.Kind.INFO;
          lineNum = -1L;
          path = fileName;
        }

        myContext.processMessage(
          new CompilerMessage(ThriftBuilder.BUILDER_NAME, kind, line, path, -1L, -1L, -1L, lineNum, -1L)
        );
      }
    }
    catch (RuntimeException e) {
      myContext.processMessage(
        new CompilerMessage(
          ThriftBuilder.BUILDER_NAME,
          BuildMessage.Kind.ERROR,
          "Can't process compiler output: " + stdOutput
        )
      );
      myHasErrors.set(true);
      return;
    }

    int exitCode = event.getExitCode();
    if (exitCode == 0) {
      try {
        final FileGeneratedEvent msg = new FileGeneratedEvent(new ModuleBuildTarget(myModule, JavaModuleBuildTargetType.PRODUCTION));

        collectNewFiles(msg);

        myContext.processMessage(msg);
      }
      catch (IOException e) {
        myContext.processMessage(
          new CompilerMessage(
            ThriftBuilder.BUILDER_NAME,
            BuildMessage.Kind.ERROR,
            "Failed to collect generated files: " + stdOutput
          )
        );
        myHasErrors.set(true);
      }
    }
    else {
      myContext.processMessage(
        new CompilerMessage(
          ThriftBuilder.BUILDER_NAME,
          BuildMessage.Kind.ERROR,
          "Thrift translator for '" + myModule.getName() + "' finished with exit code " + exitCode
        )
      );
      myHasErrors.set(true);
    }
  }

  private void collectNewFiles(final FileGeneratedEvent msg) throws IOException {
    final Collection<File> files = FileUtils.listFiles(myTargetDir, FileFilterUtils.trueFileFilter(), FileFilterUtils.trueFileFilter());
    final URI baseUri = myTargetDir.toURI();
    for (File f : files) {
      msg.add(myTargetDir.toString(), baseUri.relativize(f.toURI()).getPath());
    }
  }
}
