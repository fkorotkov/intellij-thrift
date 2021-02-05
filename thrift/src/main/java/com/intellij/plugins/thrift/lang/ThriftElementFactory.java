package com.intellij.plugins.thrift.lang;

import com.intellij.openapi.project.Project;
import com.intellij.plugins.thrift.ThriftLanguage;
import com.intellij.plugins.thrift.lang.psi.ThriftCustomType;
import com.intellij.plugins.thrift.lang.psi.ThriftFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

public class ThriftElementFactory {
  private ThriftElementFactory() {
  }

  @NotNull
  private static ThriftFile createFileFromText(@NotNull Project project, @NotNull String text) {
    return (ThriftFile)PsiFileFactory.getInstance(project).createFileFromText("a.thrift", ThriftLanguage.INSTANCE, text);
  }

  @NotNull
  public static ThriftCustomType createCustomTypeFromText(@NotNull Project project, @NotNull String text) {
    ThriftFile file = createFileFromText(project, "struct{ 1: "+text+" a }");

    return PsiTreeUtil.findChildOfType(file, ThriftCustomType.class);
  }
}
