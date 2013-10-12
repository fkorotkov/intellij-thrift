// This is a generated file. Not intended for manual editing.
package com.intellij.plugins.thrift.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ThriftField extends ThriftPsiCompositeElement {

  @Nullable
  ThriftConstValue getConstValue();

  @Nullable
  ThriftFieldID getFieldID();

  @Nullable
  ThriftFieldReq getFieldReq();

  @NotNull
  ThriftFieldType getFieldType();

  @Nullable
  ThriftListSeparator getListSeparator();

  @NotNull
  ThriftXsdFieldOptions getXsdFieldOptions();

}
