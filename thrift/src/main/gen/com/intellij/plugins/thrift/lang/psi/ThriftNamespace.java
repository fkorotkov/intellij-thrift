// This is a generated file. Not intended for manual editing.
package com.intellij.plugins.thrift.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ThriftNamespace extends ThriftPsiCompositeElement {

  @Nullable
  ThriftNamespaceScope getNamespaceScope();

  @Nullable
  PsiElement getIdentifier();

  @Nullable
  PsiElement getLiteral();

  @Nullable
  PsiElement getSTIdentifier();

}
