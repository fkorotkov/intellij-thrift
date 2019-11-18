// This is a generated file. Not intended for manual editing.
package com.intellij.plugins.thrift.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ThriftEnumField extends ThriftPsiCompositeElement {

  @Nullable
  ThriftIntConstant getIntConstant();

  @Nullable
  ThriftListSeparator getListSeparator();

  @Nullable
  ThriftTypeAnnotations getTypeAnnotations();

  @NotNull
  PsiElement getIdentifier();

}
