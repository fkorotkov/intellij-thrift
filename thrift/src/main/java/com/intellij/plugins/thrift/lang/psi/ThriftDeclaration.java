package com.intellij.plugins.thrift.lang.psi;

import com.intellij.navigation.NavigationItem;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiNamedElement;

/**
 * Created by fkorotkov.
 */
public interface ThriftDeclaration extends ThriftPsiCompositeElement, PsiNamedElement, NavigationItem, NavigatablePsiElement {
  ThriftDefinitionName getIdentifier();
}
