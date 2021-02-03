// This is a generated file. Not intended for manual editing.
package com.intellij.plugins.thrift.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.intellij.plugins.thrift.lang.lexer.ThriftTokenTypes.*;
import com.intellij.plugins.thrift.lang.psi.*;
import com.intellij.plugins.thrift.util.ThriftPsiUtil;
import com.intellij.psi.PsiReference;

public class ThriftCustomTypeImpl extends ThriftPsiCompositeElementImpl implements ThriftCustomType {

  public ThriftCustomTypeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ThriftVisitor visitor) {
    visitor.visitCustomType(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ThriftVisitor) accept((ThriftVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getIdentifier() {
    return findNotNullChildByType(IDENTIFIER);
  }

  @Override
  public @NotNull PsiReference[] getReferences() {
    return ThriftPsiUtil.getReferences(this);
  }

}
