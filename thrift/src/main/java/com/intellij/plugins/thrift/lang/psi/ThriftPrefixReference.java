package com.intellij.plugins.thrift.lang.psi;

import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.plugins.thrift.lang.ThriftElementFactory;
import com.intellij.plugins.thrift.util.ThriftPsiUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

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

  @Override
  public PsiElement handleElementRename(@NotNull String newElementName) throws IncorrectOperationException {
    ThriftCustomType element = this.getElement();
    String currentText = element.getIdentifier().getText();
    String newPrefix = FileUtil.getNameWithoutExtension(newElementName);
    String newText = TextRange.create(0, currentText.indexOf(".")).replace(currentText, newPrefix);

    element.getIdentifier().replace(ThriftElementFactory.createCustomTypeFromText(element.getProject(), newText));
    return element;
  }
}
