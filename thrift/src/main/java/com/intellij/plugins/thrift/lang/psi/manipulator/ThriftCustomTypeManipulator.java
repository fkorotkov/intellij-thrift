package com.intellij.plugins.thrift.lang.psi.manipulator;

import com.intellij.openapi.util.TextRange;
import com.intellij.plugins.thrift.lang.psi.ThriftCustomType;
import com.intellij.psi.AbstractElementManipulator;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.util.IncorrectOperationException;

public class ThriftCustomTypeManipulator extends AbstractElementManipulator<ThriftCustomType> {
  @Override
  public ThriftCustomType handleContentChange(ThriftCustomType element, TextRange range, String newContent)
    throws IncorrectOperationException {
    String oldText = element.getText();
    String newText = oldText.substring(0, range.getStartOffset()) + newContent + oldText.substring(range.getEndOffset());
    PsiElement child = element.getFirstChild();
    if (child instanceof LeafPsiElement) {
      ((LeafPsiElement)child).replaceWithText(newText);
      return element;
    }
    throw new IncorrectOperationException("bad PSI");
  }
}
