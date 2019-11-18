// This is a generated file. Not intended for manual editing.
package com.intellij.plugins.thrift.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ThriftField extends ThriftSubDeclaration {

  @Nullable
  ThriftConstValue getConstValue();

  @Nullable
  ThriftDefinitionName getDefinitionName();

  @Nullable
  ThriftFieldID getFieldID();

  @Nullable
  ThriftFieldReq getFieldReq();

  @NotNull
  ThriftFieldType getFieldType();

  @Nullable
  ThriftListSeparator getListSeparator();

  @Nullable
  ThriftTypeAnnotations getTypeAnnotations();

  @Nullable
  ThriftXsdFieldOptions getXsdFieldOptions();

}
