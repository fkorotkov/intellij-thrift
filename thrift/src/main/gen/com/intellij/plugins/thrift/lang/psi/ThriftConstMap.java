// This is a generated file. Not intended for manual editing.
package com.intellij.plugins.thrift.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ThriftConstMap extends ThriftPsiCompositeElement {

  @NotNull
  List<ThriftConstValue> getConstValueList();

  @NotNull
  List<ThriftListSeparator> getListSeparatorList();

}
