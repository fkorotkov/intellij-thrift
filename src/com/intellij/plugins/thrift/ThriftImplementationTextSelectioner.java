package com.intellij.plugins.thrift;

import com.intellij.codeInsight.hint.ImplementationTextSelectioner;
import com.intellij.openapi.util.TextRange;
import com.intellij.plugins.thrift.lang.psi.ThriftDefinitionName;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public class ThriftImplementationTextSelectioner implements ImplementationTextSelectioner {
  @Override
  public int getTextStartOffset(@NotNull PsiElement element) {
    if (element instanceof ThriftDefinitionName) {
      element = element.getParent();
    }

    final TextRange textRange = element.getTextRange();
    return textRange.getStartOffset();
  }

  @Override
  public int getTextEndOffset(@NotNull PsiElement element) {
    if (element instanceof ThriftDefinitionName) {
      element = element.getParent();
    }

    final TextRange textRange = element.getTextRange();
    return textRange.getEndOffset();
  }
}
