package com.intellij.plugins.thrift.lang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.ItemPresentationProviders;
import com.intellij.plugins.thrift.lang.psi.ThriftDeclaration;
import com.intellij.plugins.thrift.lang.psi.ThriftDefinitionName;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by fkorotkov.
 */
public class AbstractThriftDeclaration extends ThriftPsiCompositeElementImpl implements ThriftDeclaration {
  public AbstractThriftDeclaration(@NotNull ASTNode node) {
    super(node);
  }

  @Nullable
  public ThriftDefinitionName getIdentifier() {
    return PsiTreeUtil.getChildOfType(this, ThriftDefinitionName.class);
  }

  @Override
  public String getName() {
    PsiElement identifier = getIdentifier();
    return identifier != null ? identifier.getText() : super.getName();
  }

  @Override
  public PsiElement setName(@NonNls @NotNull String name) throws IncorrectOperationException {
    ThriftDefinitionName definitionName = getIdentifier();
    PsiElement id = definitionName != null ? definitionName.getFirstChild() : null;
    if (id instanceof LeafPsiElement) {
      ((LeafPsiElement)id).replaceWithText(name);
    }
    return this;
  }

  @Override
  public ItemPresentation getPresentation() {
    return ItemPresentationProviders.getItemPresentation(this);
  }

  @NotNull
  @Override
  public PsiElement getNavigationElement() {
    ThriftDefinitionName name = getIdentifier();
    return name != null ? name : super.getNavigationElement();
  }
}
