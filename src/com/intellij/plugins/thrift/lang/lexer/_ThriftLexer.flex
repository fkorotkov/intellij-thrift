package com.intellij.plugins.thrift.lang.lexer;
import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;
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

EOL="\r"|"\n"|"\r\n"
LINE_WS=[\ \t\f]
WHITE_SPACE=({LINE_WS}|{EOL})+

C_STYLE_COMMENT=("/*"[^"*"]{COMMENT_TAIL})|"/*"
DOC_COMMENT="/*""*"+("/"|([^"/""*"]{COMMENT_TAIL}))?
COMMENT_TAIL=([^"*"]*("*"+[^"*""/"])?)*("*"+"/")?
END_OF_LINE_COMMENT=("/""/" | "#")[^\r\n]*

LITERAL=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")
IDENTIFIER=([:letter:] | \_)([a-zA-Z_0-9] | \.)*
STIDENTIFIER=([:letter:] | \_)([a-zA-Z_0-9] | \. | \-)*
MULTIPLY=\*

DIGIT = [:digit:]

HEX_DIGIT = [0-9A-Fa-f]
INT_DIGIT = [0-9]
OCT_DIGIT = [0-7]

NUM_INT = {INT_DIGIT}+
NUM_HEX = ("0x" | "0X") {HEX_DIGIT}+

FLOAT_EXPONENT = [eE] [+-]? {DIGIT}+
NUM_FLOAT = ( (({DIGIT}* "." {DIGIT}+) | ({DIGIT}+ "." {DIGIT}*)) {FLOAT_EXPONENT}?) | ({DIGIT}+ {FLOAT_EXPONENT})

%%
<YYINITIAL> {
  {WHITE_SPACE}       { return com.intellij.psi.TokenType.WHITE_SPACE; }

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

  {NUM_INT}                                {  return INTEGER; }
  {NUM_HEX}                                {  return INTEGER; }
  {NUM_FLOAT} / [^"."]                     {  return NUMBER; }

  {END_OF_LINE_COMMENT}           { return COMMENT; }
  {C_STYLE_COMMENT}      { return BLOCKCOMMENT; }
  {DOC_COMMENT}      { return BLOCKCOMMENT; }
  {LITERAL}           { return LITERAL; }
  {IDENTIFIER}        { return IDENTIFIER; }
  {STIDENTIFIER}      { return STIDENTIFIER; }
  {MULTIPLY}          { return MULTIPLY; }

  [^] { return com.intellij.psi.TokenType.BAD_CHARACTER; }
}
