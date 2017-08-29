package com.intellij.plugins.thrift.lang.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.intellij.plugins.thrift.lang.lexer.ThriftTokenTypes.*;

%%

%{
  public _ThriftLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _ThriftLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

COMMENT=#[^\r\n]*
BLOCKCOMMENT=\"/"\* .* \*\"/"
LITERAL=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")
IDENTIFIER=([:letter:] | \_)([a-zA-Z_0-9] | \\.)*
STIDENTIFIER=([:letter:] | \_)([a-zA-Z_0-9] | \. | -)*
NUMBER=[0-9]+(\.[0-9]*)?
INTEGER=[0-9]+
MULTIPLY=\*

%%
<YYINITIAL> {
  {WHITE_SPACE}       { return WHITE_SPACE; }

  "{"                 { return LEFTCURLYBRACE; }
  "}"                 { return RIGHTCURLYBRACE; }
  "["                 { return LEFTBRACKET; }
  "]"                 { return RIGHTBRACKET; }
  "("                 { return LEFTBRACE; }
  ")"                 { return RIGHTBRACE; }
  "="                 { return EQUALS; }
  ";"                 { return SEMICOLON; }
  ":"                 { return COLON; }
  "<"                 { return LT; }
  ">"                 { return GT; }
  ","                 { return COMMA; }
  "+"                 { return PLUS; }
  "-"                 { return MINUS; }

  {COMMENT}           { return COMMENT; }
  {BLOCKCOMMENT}      { return BLOCKCOMMENT; }
  {LITERAL}           { return LITERAL; }
  {IDENTIFIER}        { return IDENTIFIER; }
  {STIDENTIFIER}      { return STIDENTIFIER; }
  {NUMBER}            { return NUMBER; }
  {INTEGER}           { return INTEGER; }
  {MULTIPLY}          { return MULTIPLY; }

}

[^] { return BAD_CHARACTER; }
