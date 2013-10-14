package com.intellij.plugins.thrift;

import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler;
import com.intellij.plugins.thrift.lang.lexer.ThriftTokenTypeSets;
import com.intellij.psi.TokenType;
import com.intellij.util.ArrayUtil;

/**
 * Created by fkorotkov.
 */
public class ThriftQuoteHandler extends SimpleTokenSetQuoteHandler {
  public ThriftQuoteHandler() {
    super(ArrayUtil.append(ThriftTokenTypeSets.STRINGS.getTypes(), TokenType.BAD_CHARACTER));
  }
}
