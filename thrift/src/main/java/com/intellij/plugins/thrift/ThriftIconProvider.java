package com.intellij.plugins.thrift;

import com.intellij.icons.AllIcons;
import com.intellij.ide.IconProvider;
import com.intellij.openapi.util.Iconable;
import com.intellij.plugins.thrift.lang.psi.*;
import com.intellij.psi.PsiElement;
import icons.ThriftIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ThriftIconProvider extends IconProvider {
  @Nullable
  @Override
  public Icon getIcon(@NotNull PsiElement element, @Iconable.IconFlags int flags) {
    if (element instanceof ThriftConst) {
      return ThriftIcons.CONST;
    }
    if (element instanceof ThriftEnum) {
      return ThriftIcons.ENUM;
    }
    if (element instanceof ThriftException) {
      return ThriftIcons.EXCEPTION;
    }
    if (element instanceof ThriftService) {
      return ThriftIcons.SERVICE;
    }
    if (element instanceof ThriftStruct) {
      return ThriftIcons.STRUCT;
    }
    if (element instanceof ThriftTypedef) {
      return ThriftIcons.TYPEDEF;
    }
    if (element instanceof ThriftUnion) {
      return ThriftIcons.UNION;
    }
    if (element instanceof ThriftField) {
      return AllIcons.Nodes.Field;
    }
    if (element instanceof ThriftFunction) {
      return AllIcons.Nodes.Method;
    }
    return null;
  }
}
