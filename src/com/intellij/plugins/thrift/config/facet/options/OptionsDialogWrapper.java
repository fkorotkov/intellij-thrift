package com.intellij.plugins.thrift.config.facet.options;

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.TextBrowseFolderListener;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.openapi.ui.ValidationInfo;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.plugins.thrift.config.target.Generator;
import com.intellij.ui.IdeBorderFactory;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.io.LocalFileFinder;

import javax.swing.*;
import java.awt.*;

/**
 * 17.07.2014 09:43
 *
 * @author xBlackCat
 */
public class OptionsDialogWrapper extends DialogWrapper {
  private final Project myProject;
  private final Generator myGenerator;
  private final TextFieldWithBrowseButton myOutputFolderChooser;
  private AOptionPane<Generator> myPane;

  public OptionsDialogWrapper(Project project, Generator generator) {
    super(project, false, IdeModalityType.IDE);
    myProject = project;
    myGenerator = generator;
    myOutputFolderChooser = new TextFieldWithBrowseButton(new JBTextField());
    setTitle("Generator configuration");
    getPeer().getWindow().setMinimumSize(new Dimension(400, 40));
    setResizable(false);
    init();
  }

  @Nullable
  @Override
  public JComponent getPreferredFocusedComponent() {
    return myOutputFolderChooser;
  }

  @Nullable
  @Override
  protected JComponent createCenterPanel() {
    final JPanel content = new JPanel(new BorderLayout());

    final JPanel topLine = new JPanel(new BorderLayout());
    content.setBorder(IdeBorderFactory.createTitledBorder("Thrift compiler " + myGenerator.getType().name(), false));
    myOutputFolderChooser.addBrowseFolderListener(
      new TextBrowseFolderListener(FileChooserDescriptorFactory.createSingleFolderDescriptor(), myProject) {
        @Nullable
        @Override
        protected VirtualFile getInitialFile() {
          if (myGenerator.getOutputDir() != null) {
            return LocalFileFinder.findFile(myGenerator.getOutputDir());
          }
          else {
            return null;
          }
        }

        @Override
        protected void onFileChosen(@NotNull VirtualFile chosenFile) {
          final String absolutePath = VfsUtil.virtualToIoFile(chosenFile).getAbsolutePath();
          myOutputFolderChooser.setText(absolutePath);
        }
      }
    );

    topLine.add(new JBLabel("Output folder:"), BorderLayout.WEST);
    topLine.add(myOutputFolderChooser, BorderLayout.CENTER);

    content.add(topLine, BorderLayout.NORTH);

    final JPanel options = new JPanel(new BorderLayout());
    content.add(options, BorderLayout.CENTER);

    myPane = AOptionPane.get(myGenerator.getType());
    if (myPane != null) {
      options.setBorder(IdeBorderFactory.createTitledBorder("Additional options"));
      options.add(myPane.getPanel());
      myPane.setValues(myGenerator);
    }
    else {
      options.setBorder(null);
    }

    final String url = myGenerator.getOutputDir();
    final VirtualFile file = url == null ? null : VirtualFileManager.getInstance().findFileByUrl(url);
    myOutputFolderChooser.setText(file == null ? VfsUtil.urlToPath(url) : file.getPath());

    return content;
  }

  @Nullable
  @Override
  protected ValidationInfo doValidate() {
    if (StringUtils.isBlank(myOutputFolderChooser.getText())) {
      return new ValidationInfo("Target path can't be blank", myOutputFolderChooser.getTextField());
    }

    return null;
  }

  public Generator getModifiedObject() {
    if (isOK()) {
      if (myPane != null) {
        myPane.readValuesTo(myGenerator);
      }
      final String dir = StringUtils.trimToNull(myOutputFolderChooser.getText());
      assert dir != null;

      final String url = VfsUtil.pathToUrl(dir);
      final VirtualFile file = VirtualFileManager.getInstance().findFileByUrl(url);

      myGenerator.setOutputDir(file == null ? url : file.getUrl());
      return myGenerator;
    }
    else {
      return null;
    }
  }
}
