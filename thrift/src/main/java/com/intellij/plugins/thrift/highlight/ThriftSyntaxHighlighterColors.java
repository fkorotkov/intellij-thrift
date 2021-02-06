package com.intellij.plugins.thrift.highlight;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

/**
 * Created by fkorotkov.
 */
public class ThriftSyntaxHighlighterColors {
  public static final String THRIFT_KEYWORD = "THRIFT_KEYWORD";

  public static final TextAttributesKey LINE_COMMENT =
    createTextAttributesKey("THRIFT_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
  public static final TextAttributesKey BLOCK_COMMENT =
    createTextAttributesKey("THRIFT_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);
  public static final TextAttributesKey DOC_COMMENT =
    createTextAttributesKey("THRIFT_DOC_COMMENT", DefaultLanguageHighlighterColors.DOC_COMMENT);

  public static final TextAttributesKey THRIFT_PREFIX =
    createTextAttributesKey("PREFIX", DefaultLanguageHighlighterColors.IDENTIFIER);
  public static final TextAttributesKey THRIFT_IMPORTED_TYPE =
    createTextAttributesKey("THRIFT_IMPORTED_TYPE", DefaultLanguageHighlighterColors.GLOBAL_VARIABLE);
  public static final TextAttributesKey THRIFT_LOCAL_TYPE =
          createTextAttributesKey("THRIFT_LOCAL_TYPE", DefaultLanguageHighlighterColors.LOCAL_VARIABLE);
  public static final TextAttributesKey THRIFT_METHOD =
          createTextAttributesKey("THRIFT_METHOD", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);

  public static final TextAttributesKey KEYWORD =
    createTextAttributesKey("THRIFT_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
  public static final TextAttributesKey NUMBER =
    createTextAttributesKey("THRIFT_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
  public static final TextAttributesKey STRING =
    createTextAttributesKey("THRIFT_STRING", DefaultLanguageHighlighterColors.STRING);
  public static final TextAttributesKey OPERATION_SIGN =
    createTextAttributesKey("THRIFT_OPERATION_SIGN", DefaultLanguageHighlighterColors.OPERATION_SIGN);
  public static final TextAttributesKey PARENTHS =
    createTextAttributesKey("THRIFT_PARENTH", DefaultLanguageHighlighterColors.PARENTHESES);
  public static final TextAttributesKey BRACKETS =
    createTextAttributesKey("THRIFT_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS);
  public static final TextAttributesKey BRACES =
    createTextAttributesKey("THRIFT_BRACES", DefaultLanguageHighlighterColors.BRACES);
  public static final TextAttributesKey COMMA = createTextAttributesKey("THRIFT_COMMA", DefaultLanguageHighlighterColors.COMMA);
  public static final TextAttributesKey DOT = createTextAttributesKey("THRIFT_DOT", DefaultLanguageHighlighterColors.DOT);
  public static final TextAttributesKey SEMICOLON =
    createTextAttributesKey("THRIFT_SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON);
  public static final TextAttributesKey BAD_CHARACTER =
    createTextAttributesKey("THRIFT_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);
}
