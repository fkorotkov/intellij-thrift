package com.intellij.plugins.thrift.lang.psi;

import com.intellij.openapi.util.TextRange;
import com.intellij.plugins.thrift.util.ThriftPsiUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReferenceBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by fkorotkov.
 */
public class ThriftTypeReference extends PsiReferenceBase<ThriftCustomType> {
  public ThriftTypeReference(@NotNull ThriftCustomType element) {
    super(element, TextRange.from(0, element.getTextLength()));
  }

  @Nullable
  @Override
  public PsiElement resolve() {
    final String name = getElement().getText();
    int index = name.lastIndexOf(".");
    if (index != -1) {
      String fileName = name.substring(0, index);
      String componentName = name.substring(index + 1);
      ThriftInclude include = ThriftPsiUtil.findImportByPrefix(getElement().getContainingFile(), fileName);
      PsiFile includedFile = ThriftPsiUtil.resolveInclude(include);
      return includedFile != null ? ThriftPsiUtil.findDeclaration(componentName, includedFile) : null;
    }
    else {
      return ThriftPsiUtil.findDeclaration(name, getElement().getContainingFile());
    }
  }

  @NotNull
  @Override
  public Object[] getVariants() {
    return PsiElement.EMPTY_ARRAY;
  }
}
