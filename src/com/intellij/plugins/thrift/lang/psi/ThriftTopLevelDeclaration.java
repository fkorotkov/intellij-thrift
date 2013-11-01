package com.intellij.plugins.thrift.lang.psi;

import com.intellij.navigation.NavigationItem;
import com.intellij.psi.PsiNamedElement;

import java.util.List;

/**
 * Created by fkorotkov.
 */
public interface ThriftTopLevelDeclaration extends ThriftDeclaration {
  List<ThriftDeclaration> findSubDeclarations();
}
