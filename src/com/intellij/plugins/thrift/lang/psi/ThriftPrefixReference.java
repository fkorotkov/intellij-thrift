package com.intellij.plugins.thrift.lang.psi;

import com.intellij.openapi.util.TextRange;
import com.intellij.plugins.thrift.util.ThriftPsiUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by fkorotkov.
 */
public class ThriftPrefixReference extends PsiReferenceBase<ThriftCustomType> {
  public ThriftPrefixReference(@NotNull ThriftCustomType element, int offset) {
    super(element, TextRange.create(0, offset));
  }

  @Nullable
  @Override
  public PsiElement resolve() {
    String fileName = getRangeInElement().substring(getElement().getText());
    ThriftInclude include = ThriftPsiUtil.findImportByPrefix(getElement().getContainingFile(), fileName);
    return ThriftPsiUtil.resolveInclude(include);
  }

  @NotNull
  @Override
  public Object[] getVariants() {
    return PsiElement.EMPTY_ARRAY;
  }
}
