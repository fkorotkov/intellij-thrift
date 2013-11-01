package com.intellij.plugins.thrift.lang.psi;

import java.util.List;

/**
 * Created by fkorotkov.
 */
public interface ThriftTopLevelDeclaration extends ThriftDeclaration {
  List<ThriftDeclaration> findSubDeclarations();
}
