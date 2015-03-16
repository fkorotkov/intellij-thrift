package com.intellij.plugins.thrift.lang.psi;

import com.intellij.openapi.util.TextRange;
import com.intellij.plugins.thrift.util.ThriftPsiUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ThriftIncludeReference extends PsiReferenceBase<ThriftInclude> {
  public ThriftIncludeReference(@NotNull ThriftInclude element) {
    // 8 = start of name in quotes, after 'include '. Hack to avoid negative length range during autocomplete
    super(element, new TextRange(element.getTextLength() < 8 ? 0 : 8, element.getTextLength()));
  }

  @Nullable
  @Override
  public PsiElement resolve() {
    return ThriftPsiUtil.resolveInclude(getElement());
  }

  @NotNull
  @Override
  public Object[] getVariants() {
    return PsiElement.EMPTY_ARRAY;
  }
}