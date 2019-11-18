package com.intellij.plugins.thrift.lang.lexer;

import com.intellij.lexer.FlexAdapter;

/**
 * Created by fkorotkov.
 */
public class ThriftLexer extends FlexAdapter {
  public ThriftLexer() {
    super(new _ThriftLexer());
  }
}
