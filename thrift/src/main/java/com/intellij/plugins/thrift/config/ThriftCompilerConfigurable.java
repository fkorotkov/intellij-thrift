package com.intellij.plugins.thrift.config;

import com.intellij.ide.ui.UISettings;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.options.BaseConfigurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.ui.TextBrowseFolderListener;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.plugins.thrift.ThriftBundle;
import com.intellij.ui.IdeBorderFactory;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.JBInsets;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.InputStream;

/**
 * 27.06.2014 10:44
 *
 * @author xBlackCat
 */
public class ThriftCompilerConfigurable extends BaseConfigurable implements SearchableConfigurable {
  public static final String DEFAULT_COMPILER_NAME = "thriftc";
  private final Project project;
  private ThriftConfigForm configForm;

  public ThriftCompilerConfigurable(Project project) {
    this.project = project;
  }

  @NotNull
  @Override
  public String getId() {
    return "intellij-thrift";
  }

  @Nullable
  @Override
  public Runnable enableSearch(String option) {
    return null;
  }

  @Nls
  @Override
  public String getDisplayName() {
    return ThriftBundle.message("thrift.compiler.page.title");
  }

  @Nullable
  @Override
  public String getHelpTopic() {
    return null;
  }

  @Nullable
  @Override
  public JComponent createComponent() {
    if (configForm == null) {
      ThriftPlugin plugin = project.getComponent(ThriftPlugin.class);
      configForm = new ThriftConfigForm(plugin);
    }
    return configForm;
  }

  @Override
  public void apply() throws ConfigurationException {
    if (configForm != null) {
      configForm.apply();
    }
  }

  @Override
  public void reset() {
    if (configForm != null) {
      configForm.reset();
    }
  }

  @Override
  public void disposeUIResources() {
    configForm = null;
  }

  private class ThriftConfigForm extends JPanel {
    private final ThriftPlugin plugin;

    private final TextFieldWithBrowseButton tfThriftCompiler;
    private final JCheckBox cbNoWarn = new JCheckBox(ThriftBundle.message("thrift.compiler.option.nowarn"));
    private final JCheckBox cbStrict = new JCheckBox(ThriftBundle.message("thrift.compiler.option.strict"));
    private final JCheckBox cbVerbose = new JCheckBox(ThriftBundle.message("thrift.compiler.option.verbose"));
    private final JCheckBox cbRecurse = new JCheckBox(ThriftBundle.message("thrift.compiler.option.recurse"));
    private final JCheckBox cbDebug = new JCheckBox(ThriftBundle.message("thrift.compiler.option.debug"));
    private final JCheckBox cbAllowNegKeys = new JCheckBox(ThriftBundle.message("thrift.compiler.option.allow-neg-keys"));
    private final JCheckBox cbAllow64bitConsts = new JCheckBox(ThriftBundle.message("thrift.compiler.option.allow-64bit-consts"));

    private final JButton bCheckVersion = new JButton();
    private VirtualFile lastSelectedFile;


    private ThriftConfigForm(ThriftPlugin plugin) {
      super(new BorderLayout());

      this.plugin = plugin;

      setBorder(IdeBorderFactory.createTitledBorder("Thrift compiler", false));

      tfThriftCompiler = new TextFieldWithBrowseButton(new JBTextField());
      tfThriftCompiler.addBrowseFolderListener(
        new TextBrowseFolderListener(FileChooserDescriptorFactory.createSingleFileNoJarsDescriptor(), project) {
          @Nullable
          @Override
          protected VirtualFile getInitialFile() {
            return lastSelectedFile;
          }

          @Override
          protected void onFileChosen(@NotNull VirtualFile chosenFile) {
            lastSelectedFile = chosenFile;
            final String absolutePath = VfsUtil.virtualToIoFile(lastSelectedFile).getAbsolutePath();
            tfThriftCompiler.setText(absolutePath);
            final Task.Modal checkTask = new ThriftVersionChecker(absolutePath);

            checkTask.queue();
          }
        }
      );

      bCheckVersion.setText("Test");
      bCheckVersion.setMargin(new JBInsets(0, 3, 0, 3));
      bCheckVersion.addActionListener(new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
          final Task.Modal checkTask = new ThriftVersionChecker(tfThriftCompiler.getText());

          checkTask.queue();
        }
      });

      final JPanel topPane = new JPanel(new BorderLayout(5, 0));
      topPane.add(new JBLabel(ThriftBundle.message("thrift.compiler.page.exec.label")), BorderLayout.WEST);
      topPane.add(tfThriftCompiler, BorderLayout.CENTER);
      topPane.add(bCheckVersion, BorderLayout.EAST);

      add(topPane, BorderLayout.NORTH);

      final JPanel optionsCover = new JPanel(new BorderLayout());
      final JPanel options = new JPanel(new GridLayout(-1, 1));
      optionsCover.setBorder(IdeBorderFactory.createTitledBorder(ThriftBundle.message("thrift.compiler.page.options.title"), true));

      options.add(cbNoWarn);
      options.add(cbStrict);
      options.add(cbVerbose);
      options.add(cbRecurse);
      options.add(cbDebug);
      options.add(cbAllowNegKeys);
      options.add(cbAllow64bitConsts);

      final ChangeListener modifyListener = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
          setModified(true);
        }
      };
      cbNoWarn.addChangeListener(modifyListener);
      cbStrict.addChangeListener(modifyListener);
      cbVerbose.addChangeListener(modifyListener);
      cbRecurse.addChangeListener(modifyListener);
      cbDebug.addChangeListener(modifyListener);
      cbAllowNegKeys.addChangeListener(modifyListener);
      cbAllow64bitConsts.addChangeListener(modifyListener);

      optionsCover.add(options, BorderLayout.NORTH);
      add(optionsCover, BorderLayout.CENTER);
    }

    void reset() {
      ThriftConfig config = plugin.getConfig();

      if (config != null) {
        final String path = StringUtils.defaultIfEmpty(config.getCompilerPath(), DEFAULT_COMPILER_NAME);

        tfThriftCompiler.setText(path);
        lastSelectedFile = LocalFileSystem.getInstance().findFileByPath(path);
        cbNoWarn.setSelected(config.isNoWarn());
        cbStrict.setSelected(config.isStrict());
        cbVerbose.setSelected(config.isVerbose());
        cbRecurse.setSelected(config.isRecurse());
        cbDebug.setSelected(config.isDebug());
        cbAllowNegKeys.setSelected(config.isAllowNegKeys());
        cbAllow64bitConsts.setSelected(config.isAllow64bitConsts());
      }
      else {
        tfThriftCompiler.setText(DEFAULT_COMPILER_NAME);
      }

      setModified(false);
    }

    void apply() {
      final ThriftConfig config = new ThriftConfig(
        StringUtils.trimToNull(tfThriftCompiler.getText()),
        cbNoWarn.isSelected(),
        cbStrict.isSelected(),
        cbVerbose.isSelected(),
        cbRecurse.isSelected(),
        cbDebug.isSelected(),
        cbAllowNegKeys.isSelected(),
        cbAllow64bitConsts.isSelected()
      );

      plugin.setConfig(config);
      setModified(false);

      UISettings.getInstance().fireUISettingsChanged();
    }

    private class ThriftVersionChecker extends Task.Modal {
      private String thriftCmd;
      private String version;

      public ThriftVersionChecker(String folder) {
        super(project, ThriftBundle.message("thrift.compiler.check.progress.title"), true);
        thriftCmd = folder;
      }

      @Override
      public void run(@NotNull ProgressIndicator indicator) {
        indicator.setIndeterminate(true);

        if (thriftCmd == null) {
          return;
        }
        version = readVersion();
        if (version == null) {
          thriftCmd = null;
        }
      }

      public String readVersion() {
        // check file version
        try {
          Process process = new ProcessBuilder(thriftCmd, "--version").start();
          process.waitFor();

          byte[] stdOut;
          try (InputStream stdOutIS = process.getInputStream()) {
            stdOut = FileUtil.loadBytes(stdOutIS);
            if (stdOut.length == 0) {
              return null;
            }
          }

          return new String(stdOut);
        }
        catch (Exception e1) {
          // Ignore
        }

        return null;
      }

      @Override
      public void onSuccess() {
        if (thriftCmd != null) {
          if (version != null) {
            Messages.showInfoMessage(
              project,
              ThriftBundle.message("thrift.compiler.check.success", version),
              ThriftBundle.message("thrift.compiler.check.success.title")
            );
          }

          setModified(true);
        }
        else {
          Messages.showWarningDialog(
            project,
            ThriftBundle.message("thrift.compiler.check.not-found"),
            ThriftBundle.message("thrift.compiler.check.not-found.title")
          );
        }
      }
    }
  }
}
