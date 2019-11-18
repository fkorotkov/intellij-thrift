package com.intellij.plugins.thrift;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by fkorotkov.
 */
public class ThriftFileType extends LanguageFileType {
  public static final ThriftFileType INSTANCE = new ThriftFileType();

  @NonNls
  public static final String DEFAULT_EXTENSION = "thrift";

  protected ThriftFileType() {
    super(ThriftLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public String getName() {
    return ThriftBundle.message("thrift.name");
  }

  @NotNull
  @Override
  public String getDescription() {
    return ThriftBundle.message("thrift.description");
  }

  @NotNull
  @Override
  public String getDefaultExtension() {
    return DEFAULT_EXTENSION;
  }

  @Nullable
  @Override
  public Icon getIcon() {
    return AllIcons.FileTypes.Custom;
  }
}
