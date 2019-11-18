package com.intellij.plugins.thrift.lang.lexer;

import com.intellij.plugins.thrift.ThriftLanguage;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;

public interface ThriftTokenTypeSets {
  IFileElementType THRIFT_FILE = new IFileElementType("THRIFT_FILE", ThriftLanguage.INSTANCE);

  TokenSet WHITESPACES = TokenSet.create(
    TokenType.WHITE_SPACE
  );
  TokenSet COMMENTS = TokenSet.create(
    ThriftTokenTypes.COMMENT,
    ThriftTokenTypes.BLOCKCOMMENT
  );
  TokenSet STRINGS = TokenSet.create(
    ThriftTokenTypes.LITERAL
  );
  TokenSet OPERATORS = TokenSet.create(
    ThriftTokenTypes.PLUS,
    ThriftTokenTypes.MULTIPLY, ThriftTokenTypes.MINUS
  );

  TokenSet BAD_TOKENS = TokenSet.create(
    TokenType.BAD_CHARACTER
  );
}

