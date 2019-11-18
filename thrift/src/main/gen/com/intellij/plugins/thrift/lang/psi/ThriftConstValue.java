// This is a generated file. Not intended for manual editing.
package com.intellij.plugins.thrift.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ThriftConstValue extends ThriftPsiCompositeElement {

  @Nullable
  ThriftConstList getConstList();

  @Nullable
  ThriftConstMap getConstMap();

  @Nullable
  ThriftDoubleConstant getDoubleConstant();

  @Nullable
  ThriftIntConstant getIntConstant();

  @Nullable
  PsiElement getIdentifier();

  @Nullable
  PsiElement getLiteral();

}
