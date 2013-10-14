package com.intellij.plugins.thrift.lang.psi;

import com.intellij.navigation.NavigationItem;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;

/**
 * Created by fkorotkov.
 */
public interface ThriftDeclaration extends ThriftPsiCompositeElement, PsiNamedElement, NavigationItem {
  ThriftDefinitionName getIdentifier();
}
