// This is a generated file. Not intended for manual editing.
package com.intellij.plugins.thrift.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ThriftFunction extends ThriftSubDeclaration {

  @NotNull
  ThriftDefinitionName getDefinitionName();

  @NotNull
  List<ThriftField> getFieldList();

  @NotNull
  ThriftFunctionType getFunctionType();

  @Nullable
  ThriftThrows getThrows();

  @Nullable
  ThriftTypeAnnotations getTypeAnnotations();

}
