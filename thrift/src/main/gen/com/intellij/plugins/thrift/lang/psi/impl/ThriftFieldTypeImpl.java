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

public class ThriftFieldTypeImpl extends ThriftPsiCompositeElementImpl implements ThriftFieldType {

  public ThriftFieldTypeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ThriftVisitor visitor) {
    visitor.visitFieldType(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ThriftVisitor) accept((ThriftVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ThriftBaseType getBaseType() {
    return findChildByClass(ThriftBaseType.class);
  }

  @Override
  @Nullable
  public ThriftContainerType getContainerType() {
    return findChildByClass(ThriftContainerType.class);
  }

  @Override
  @Nullable
  public ThriftCustomType getCustomType() {
    return findChildByClass(ThriftCustomType.class);
  }

}
