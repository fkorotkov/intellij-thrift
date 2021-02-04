// This is a generated file. Not intended for manual editing.
package com.intellij.plugins.thrift.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.navigation.NavigationItem;
import com.intellij.psi.PsiNameIdentifierOwner;

public interface ThriftDefinitionName extends PsiNamedElement, NavigationItem, PsiNameIdentifierOwner {

  @NotNull
  PsiElement getIdentifier();

  @NotNull PsiElement setName(String name);

  @NonNls
  @Nullable String getName();

  @NotNull PsiElement getNameIdentifier();

}
