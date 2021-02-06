package com.intellij.plugins.thrift.lang.psi.manipulator;

import com.intellij.openapi.util.TextRange;
import com.intellij.plugins.thrift.lang.psi.ThriftInclude;
import com.intellij.psi.AbstractElementManipulator;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;

public class ThriftIncludeManipulator extends AbstractElementManipulator<ThriftInclude> {
  @Override
  public ThriftInclude handleContentChange(ThriftInclude element, TextRange range, String newContent)
    throws IncorrectOperationException {
    PsiElement child = element.getLastChild();
    if (child instanceof LeafPsiElement) {
      ((LeafPsiElement)child).replaceWithText("\""+newContent+"\"");
      return element;
    }
    throw new IncorrectOperationException("bad PSI");
  }

  @Override
  @NotNull
  public TextRange getRangeInElement(@NotNull final ThriftInclude element) {
    TextRange range =  element.getLastChild().getTextRangeInParent();

    return TextRange.create(range.getStartOffset()+1, range.getEndOffset()-1);
  }

}
