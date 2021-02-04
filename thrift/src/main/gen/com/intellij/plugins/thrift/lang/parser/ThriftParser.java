// This is a generated file. Not intended for manual editing.
package com.intellij.plugins.thrift.lang.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.intellij.plugins.thrift.lang.lexer.ThriftTokenTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ThriftParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return Document(b, l + 1);
  }

  /* ********************************************************** */
  // SimpleBaseType TypeAnnotations?
  public static boolean BaseType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BaseType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BASE_TYPE, "<base type>");
    r = SimpleBaseType(b, l + 1);
    r = r && BaseType_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // TypeAnnotations?
  private static boolean BaseType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BaseType_1")) return false;
    TypeAnnotations(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'const' FieldType DefinitionName '=' ConstValue ListSeparator?
  public static boolean Const(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Const")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONST, "<const>");
    r = consumeToken(b, "const");
    p = r; // pin = 1
    r = r && report_error_(b, FieldType(b, l + 1));
    r = p && report_error_(b, DefinitionName(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, EQUALS)) && r;
    r = p && report_error_(b, ConstValue(b, l + 1)) && r;
    r = p && Const_5(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ListSeparator?
  private static boolean Const_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Const_5")) return false;
    ListSeparator(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '[' (ConstValue ListSeparator?)* ']'
  public static boolean ConstList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstList")) return false;
    if (!nextTokenIs(b, LEFTBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFTBRACKET);
    r = r && ConstList_1(b, l + 1);
    r = r && consumeToken(b, RIGHTBRACKET);
    exit_section_(b, m, CONST_LIST, r);
    return r;
  }

  // (ConstValue ListSeparator?)*
  private static boolean ConstList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ConstList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ConstList_1", c)) break;
    }
    return true;
  }

  // ConstValue ListSeparator?
  private static boolean ConstList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ConstValue(b, l + 1);
    r = r && ConstList_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ListSeparator?
  private static boolean ConstList_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstList_1_0_1")) return false;
    ListSeparator(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '{' (ConstValue ':' ConstValue ListSeparator?)* '}'
  public static boolean ConstMap(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstMap")) return false;
    if (!nextTokenIs(b, LEFTCURLYBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFTCURLYBRACE);
    r = r && ConstMap_1(b, l + 1);
    r = r && consumeToken(b, RIGHTCURLYBRACE);
    exit_section_(b, m, CONST_MAP, r);
    return r;
  }

  // (ConstValue ':' ConstValue ListSeparator?)*
  private static boolean ConstMap_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstMap_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ConstMap_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ConstMap_1", c)) break;
    }
    return true;
  }

  // ConstValue ':' ConstValue ListSeparator?
  private static boolean ConstMap_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstMap_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ConstValue(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && ConstValue(b, l + 1);
    r = r && ConstMap_1_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ListSeparator?
  private static boolean ConstMap_1_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstMap_1_0_3")) return false;
    ListSeparator(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IntConstant | DoubleConstant | Literal | Identifier | ConstList | ConstMap
  public static boolean ConstValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONST_VALUE, "<const value>");
    r = IntConstant(b, l + 1);
    if (!r) r = DoubleConstant(b, l + 1);
    if (!r) r = consumeToken(b, LITERAL);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = ConstList(b, l + 1);
    if (!r) r = ConstMap(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // SimpleContainerType TypeAnnotations?
  public static boolean ContainerType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTAINER_TYPE, "<container type>");
    r = SimpleContainerType(b, l + 1);
    r = r && ContainerType_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // TypeAnnotations?
  private static boolean ContainerType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerType_1")) return false;
    TypeAnnotations(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'cpp_type' Literal
  public static boolean CppType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CppType")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CPP_TYPE, "<cpp type>");
    r = consumeToken(b, "cpp_type");
    p = r; // pin = 1
    r = r && consumeToken(b, LITERAL);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // Identifier
  public static boolean CustomType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CustomType")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, CUSTOM_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // Identifier
  public static boolean DefinitionName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DefinitionName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, DEFINITION_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // topLevelElement*
  static boolean Document(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Document")) return false;
    while (true) {
      int c = current_position_(b);
      if (!topLevelElement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Document", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ('+' | '-')? Number
  public static boolean DoubleConstant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DoubleConstant")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DOUBLE_CONSTANT, "<double constant>");
    r = DoubleConstant_0(b, l + 1);
    r = r && consumeToken(b, NUMBER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('+' | '-')?
  private static boolean DoubleConstant_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DoubleConstant_0")) return false;
    DoubleConstant_0_0(b, l + 1);
    return true;
  }

  // '+' | '-'
  private static boolean DoubleConstant_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DoubleConstant_0_0")) return false;
    boolean r;
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    return r;
  }

  /* ********************************************************** */
  // 'enum' DefinitionName '{' enumFields '}' TypeAnnotations?
  public static boolean Enum(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Enum")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ENUM, "<enum>");
    r = consumeToken(b, "enum");
    p = r; // pin = 1
    r = r && report_error_(b, DefinitionName(b, l + 1));
    r = p && report_error_(b, consumeToken(b, LEFTCURLYBRACE)) && r;
    r = p && report_error_(b, enumFields(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, RIGHTCURLYBRACE)) && r;
    r = p && Enum_5(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // TypeAnnotations?
  private static boolean Enum_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Enum_5")) return false;
    TypeAnnotations(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'exception' DefinitionName '{' fields '}' TypeAnnotations?
  public static boolean Exception(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Exception")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, EXCEPTION, "<exception>");
    r = consumeToken(b, "exception");
    p = r; // pin = 1
    r = r && report_error_(b, DefinitionName(b, l + 1));
    r = p && report_error_(b, consumeToken(b, LEFTCURLYBRACE)) && r;
    r = p && report_error_(b, fields(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, RIGHTCURLYBRACE)) && r;
    r = p && Exception_5(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // TypeAnnotations?
  private static boolean Exception_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Exception_5")) return false;
    TypeAnnotations(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // FieldID? FieldReq? FieldType DefinitionName ('=' ConstValue)? XsdFieldOptions TypeAnnotations? ListSeparator?
  public static boolean Field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Field")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FIELD, "<field>");
    r = Field_0(b, l + 1);
    r = r && Field_1(b, l + 1);
    r = r && FieldType(b, l + 1);
    p = r; // pin = 3
    r = r && report_error_(b, DefinitionName(b, l + 1));
    r = p && report_error_(b, Field_4(b, l + 1)) && r;
    r = p && report_error_(b, XsdFieldOptions(b, l + 1)) && r;
    r = p && report_error_(b, Field_6(b, l + 1)) && r;
    r = p && Field_7(b, l + 1) && r;
    exit_section_(b, l, m, r, p, ThriftParser::fieldRecovery);
    return r || p;
  }

  // FieldID?
  private static boolean Field_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Field_0")) return false;
    FieldID(b, l + 1);
    return true;
  }

  // FieldReq?
  private static boolean Field_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Field_1")) return false;
    FieldReq(b, l + 1);
    return true;
  }

  // ('=' ConstValue)?
  private static boolean Field_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Field_4")) return false;
    Field_4_0(b, l + 1);
    return true;
  }

  // '=' ConstValue
  private static boolean Field_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Field_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUALS);
    r = r && ConstValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // TypeAnnotations?
  private static boolean Field_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Field_6")) return false;
    TypeAnnotations(b, l + 1);
    return true;
  }

  // ListSeparator?
  private static boolean Field_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Field_7")) return false;
    ListSeparator(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IntConstant ':'
  public static boolean FieldID(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldID")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_ID, "<field id>");
    r = IntConstant(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'required' | 'optional'
  public static boolean FieldReq(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldReq")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_REQ, "<field req>");
    r = consumeToken(b, "required");
    if (!r) r = consumeToken(b, "optional");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // BaseType | ContainerType | CustomType
  public static boolean FieldType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_TYPE, "<field type>");
    r = BaseType(b, l + 1);
    if (!r) r = ContainerType(b, l + 1);
    if (!r) r = CustomType(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'oneway'? FunctionType DefinitionName '(' fieldsWithBraceRecovery ')' Throws? TypeAnnotations?
  public static boolean Function(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Function")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION, "<function>");
    r = Function_0(b, l + 1);
    r = r && FunctionType(b, l + 1);
    r = r && DefinitionName(b, l + 1);
    p = r; // pin = 3
    r = r && report_error_(b, consumeToken(b, LEFTBRACE));
    r = p && report_error_(b, fieldsWithBraceRecovery(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, RIGHTBRACE)) && r;
    r = p && report_error_(b, Function_6(b, l + 1)) && r;
    r = p && Function_7(b, l + 1) && r;
    exit_section_(b, l, m, r, p, ThriftParser::functionRecovery);
    return r || p;
  }

  // 'oneway'?
  private static boolean Function_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Function_0")) return false;
    consumeToken(b, "oneway");
    return true;
  }

  // Throws?
  private static boolean Function_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Function_6")) return false;
    Throws(b, l + 1);
    return true;
  }

  // TypeAnnotations?
  private static boolean Function_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Function_7")) return false;
    TypeAnnotations(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'void' | FieldType
  public static boolean FunctionType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_TYPE, "<function type>");
    r = consumeToken(b, "void");
    if (!r) r = FieldType(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '<' FieldType (',' FieldType)* '>'
  public static boolean GenericType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericType")) return false;
    if (!nextTokenIs(b, LT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, GENERIC_TYPE, null);
    r = consumeToken(b, LT);
    p = r; // pin = 1
    r = r && report_error_(b, FieldType(b, l + 1));
    r = p && report_error_(b, GenericType_2(b, l + 1)) && r;
    r = p && consumeToken(b, GT) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (',' FieldType)*
  private static boolean GenericType_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericType_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!GenericType_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "GenericType_2", c)) break;
    }
    return true;
  }

  // ',' FieldType
  private static boolean GenericType_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericType_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && FieldType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ('include' | 'cpp_include') Literal
  public static boolean Include(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Include")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, INCLUDE, "<include>");
    r = Include_0(b, l + 1);
    p = r; // pin = 1
    r = r && consumeToken(b, LITERAL);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // 'include' | 'cpp_include'
  private static boolean Include_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Include_0")) return false;
    boolean r;
    r = consumeToken(b, "include");
    if (!r) r = consumeToken(b, "cpp_include");
    return r;
  }

  /* ********************************************************** */
  // ('+' | '-')? Integer
  public static boolean IntConstant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IntConstant")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INT_CONSTANT, "<int constant>");
    r = IntConstant_0(b, l + 1);
    r = r && consumeToken(b, INTEGER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('+' | '-')?
  private static boolean IntConstant_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IntConstant_0")) return false;
    IntConstant_0_0(b, l + 1);
    return true;
  }

  // '+' | '-'
  private static boolean IntConstant_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IntConstant_0_0")) return false;
    boolean r;
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    return r;
  }

  /* ********************************************************** */
  // ',' | ';'
  public static boolean ListSeparator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ListSeparator")) return false;
    if (!nextTokenIs(b, "<list separator>", COMMA, SEMICOLON)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LIST_SEPARATOR, "<list separator>");
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'list' GenericType CppType?
  public static boolean ListType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ListType")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, LIST_TYPE, "<list type>");
    r = consumeToken(b, "list");
    p = r; // pin = 1
    r = r && report_error_(b, GenericType(b, l + 1));
    r = p && ListType_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // CppType?
  private static boolean ListType_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ListType_2")) return false;
    CppType(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'map' CppType? GenericType
  public static boolean MapType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MapType")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MAP_TYPE, "<map type>");
    r = consumeToken(b, "map");
    p = r; // pin = 1
    r = r && report_error_(b, MapType_1(b, l + 1));
    r = p && GenericType(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // CppType?
  private static boolean MapType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MapType_1")) return false;
    CppType(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // std_namespace | php_namespace | xsd_namespace
  public static boolean Namespace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Namespace")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NAMESPACE, "<namespace>");
    r = std_namespace(b, l + 1);
    if (!r) r = php_namespace(b, l + 1);
    if (!r) r = xsd_namespace(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Multiply | 'cpp' | 'java' | 'py' | 'py.twisted' | 'perl' | 'rb' | 'js' | 'st' |
  //                      'cocoa' | 'csharp' | 'c_glib' | 'go' | 'php' |  'd' | 'delphi' | 'xsd' | 'lua' |
  //                      'netcore' | 'rs' | 'as3' | 'cl' | 'dart' | 'erl' | 'haxe' | 'hs'  |
  //                      'javame' | 'json'  | 'netstd' | 'nodejs' | 'nodets' | 'ocaml'  | 'swift' | 'ts' | 'xml'
  public static boolean NamespaceScope(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NamespaceScope")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NAMESPACE_SCOPE, "<namespace scope>");
    r = consumeToken(b, MULTIPLY);
    if (!r) r = consumeToken(b, "cpp");
    if (!r) r = consumeToken(b, "java");
    if (!r) r = consumeToken(b, "py");
    if (!r) r = consumeToken(b, "py.twisted");
    if (!r) r = consumeToken(b, "perl");
    if (!r) r = consumeToken(b, "rb");
    if (!r) r = consumeToken(b, "js");
    if (!r) r = consumeToken(b, "st");
    if (!r) r = consumeToken(b, "cocoa");
    if (!r) r = consumeToken(b, "csharp");
    if (!r) r = consumeToken(b, "c_glib");
    if (!r) r = consumeToken(b, "go");
    if (!r) r = consumeToken(b, "php");
    if (!r) r = consumeToken(b, "d");
    if (!r) r = consumeToken(b, "delphi");
    if (!r) r = consumeToken(b, "xsd");
    if (!r) r = consumeToken(b, "lua");
    if (!r) r = consumeToken(b, "netcore");
    if (!r) r = consumeToken(b, "rs");
    if (!r) r = consumeToken(b, "as3");
    if (!r) r = consumeToken(b, "cl");
    if (!r) r = consumeToken(b, "dart");
    if (!r) r = consumeToken(b, "erl");
    if (!r) r = consumeToken(b, "haxe");
    if (!r) r = consumeToken(b, "hs");
    if (!r) r = consumeToken(b, "javame");
    if (!r) r = consumeToken(b, "json");
    if (!r) r = consumeToken(b, "netstd");
    if (!r) r = consumeToken(b, "nodejs");
    if (!r) r = consumeToken(b, "nodets");
    if (!r) r = consumeToken(b, "ocaml");
    if (!r) r = consumeToken(b, "swift");
    if (!r) r = consumeToken(b, "ts");
    if (!r) r = consumeToken(b, "xml");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'senum' DefinitionName '{' senumBody '}' TypeAnnotations?
  public static boolean Senum(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Senum")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SENUM, "<senum>");
    r = consumeToken(b, "senum");
    p = r; // pin = 1
    r = r && report_error_(b, DefinitionName(b, l + 1));
    r = p && report_error_(b, consumeToken(b, LEFTCURLYBRACE)) && r;
    r = p && report_error_(b, senumBody(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, RIGHTCURLYBRACE)) && r;
    r = p && Senum_5(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // TypeAnnotations?
  private static boolean Senum_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Senum_5")) return false;
    TypeAnnotations(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'service' DefinitionName ( 'extends' ServiceSuperName )? '{' serviceBody '}' TypeAnnotations?
  public static boolean Service(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Service")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SERVICE, "<service>");
    r = consumeToken(b, "service");
    p = r; // pin = 1
    r = r && report_error_(b, DefinitionName(b, l + 1));
    r = p && report_error_(b, Service_2(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, LEFTCURLYBRACE)) && r;
    r = p && report_error_(b, serviceBody(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, RIGHTCURLYBRACE)) && r;
    r = p && Service_6(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ( 'extends' ServiceSuperName )?
  private static boolean Service_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Service_2")) return false;
    Service_2_0(b, l + 1);
    return true;
  }

  // 'extends' ServiceSuperName
  private static boolean Service_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Service_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "extends");
    r = r && ServiceSuperName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // TypeAnnotations?
  private static boolean Service_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Service_6")) return false;
    TypeAnnotations(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // CustomType
  public static boolean ServiceSuperName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ServiceSuperName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = CustomType(b, l + 1);
    exit_section_(b, m, SERVICE_SUPER_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // 'set' CppType? GenericType
  public static boolean SetType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SetType")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SET_TYPE, "<set type>");
    r = consumeToken(b, "set");
    p = r; // pin = 1
    r = r && report_error_(b, SetType_1(b, l + 1));
    r = p && GenericType(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // CppType?
  private static boolean SetType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SetType_1")) return false;
    CppType(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'bool' | 'byte' | 'i8' | 'i16' | 'i32' | 'i64' | 'double' | 'string' | 'binary' | 'slist'
  public static boolean SimpleBaseType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleBaseType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SIMPLE_BASE_TYPE, "<simple base type>");
    r = consumeToken(b, "bool");
    if (!r) r = consumeToken(b, "byte");
    if (!r) r = consumeToken(b, "i8");
    if (!r) r = consumeToken(b, "i16");
    if (!r) r = consumeToken(b, "i32");
    if (!r) r = consumeToken(b, "i64");
    if (!r) r = consumeToken(b, "double");
    if (!r) r = consumeToken(b, "string");
    if (!r) r = consumeToken(b, "binary");
    if (!r) r = consumeToken(b, "slist");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // MapType | SetType | ListType
  static boolean SimpleContainerType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleContainerType")) return false;
    boolean r;
    r = MapType(b, l + 1);
    if (!r) r = SetType(b, l + 1);
    if (!r) r = ListType(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // 'struct' DefinitionName 'xsd_all'? '{' fields '}' TypeAnnotations?
  public static boolean Struct(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Struct")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, STRUCT, "<struct>");
    r = consumeToken(b, "struct");
    p = r; // pin = 1
    r = r && report_error_(b, DefinitionName(b, l + 1));
    r = p && report_error_(b, Struct_2(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, LEFTCURLYBRACE)) && r;
    r = p && report_error_(b, fields(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, RIGHTCURLYBRACE)) && r;
    r = p && Struct_6(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // 'xsd_all'?
  private static boolean Struct_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Struct_2")) return false;
    consumeToken(b, "xsd_all");
    return true;
  }

  // TypeAnnotations?
  private static boolean Struct_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Struct_6")) return false;
    TypeAnnotations(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'throws' '(' fieldsWithBraceRecovery ')'
  public static boolean Throws(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Throws")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, THROWS, "<throws>");
    r = consumeToken(b, "throws");
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, LEFTBRACE));
    r = p && report_error_(b, fieldsWithBraceRecovery(b, l + 1)) && r;
    r = p && consumeToken(b, RIGHTBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // Identifier ('=' Literal ListSeparator?)?
  public static boolean TypeAnnotation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeAnnotation")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && TypeAnnotation_1(b, l + 1);
    exit_section_(b, m, TYPE_ANNOTATION, r);
    return r;
  }

  // ('=' Literal ListSeparator?)?
  private static boolean TypeAnnotation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeAnnotation_1")) return false;
    TypeAnnotation_1_0(b, l + 1);
    return true;
  }

  // '=' Literal ListSeparator?
  private static boolean TypeAnnotation_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeAnnotation_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, EQUALS, LITERAL);
    r = r && TypeAnnotation_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ListSeparator?
  private static boolean TypeAnnotation_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeAnnotation_1_0_2")) return false;
    ListSeparator(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // TypeAnnotation*
  public static boolean TypeAnnotationList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeAnnotationList")) return false;
    Marker m = enter_section_(b, l, _NONE_, TYPE_ANNOTATION_LIST, "<type annotation list>");
    while (true) {
      int c = current_position_(b);
      if (!TypeAnnotation(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "TypeAnnotationList", c)) break;
    }
    exit_section_(b, l, m, true, false, ThriftParser::braceRecovery);
    return true;
  }

  /* ********************************************************** */
  // '(' TypeAnnotationList ')'
  public static boolean TypeAnnotations(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeAnnotations")) return false;
    if (!nextTokenIs(b, LEFTBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFTBRACE);
    r = r && TypeAnnotationList(b, l + 1);
    r = r && consumeToken(b, RIGHTBRACE);
    exit_section_(b, m, TYPE_ANNOTATIONS, r);
    return r;
  }

  /* ********************************************************** */
  // 'typedef' FieldType DefinitionName TypeAnnotations?
  public static boolean Typedef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Typedef")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TYPEDEF, "<typedef>");
    r = consumeToken(b, "typedef");
    p = r; // pin = 1
    r = r && report_error_(b, FieldType(b, l + 1));
    r = p && report_error_(b, DefinitionName(b, l + 1)) && r;
    r = p && Typedef_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // TypeAnnotations?
  private static boolean Typedef_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Typedef_3")) return false;
    TypeAnnotations(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'union' DefinitionName 'xsd_all'? '{' fields '}' TypeAnnotations?
  public static boolean Union(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Union")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, UNION, "<union>");
    r = consumeToken(b, "union");
    p = r; // pin = 1
    r = r && report_error_(b, DefinitionName(b, l + 1));
    r = p && report_error_(b, Union_2(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, LEFTCURLYBRACE)) && r;
    r = p && report_error_(b, fields(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, RIGHTCURLYBRACE)) && r;
    r = p && Union_6(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // 'xsd_all'?
  private static boolean Union_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Union_2")) return false;
    consumeToken(b, "xsd_all");
    return true;
  }

  // TypeAnnotations?
  private static boolean Union_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Union_6")) return false;
    TypeAnnotations(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'xsd_attrs' '{' fields '}'
  public static boolean XsdAttrs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "XsdAttrs")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, XSD_ATTRS, "<xsd attrs>");
    r = consumeToken(b, "xsd_attrs");
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, LEFTCURLYBRACE));
    r = p && report_error_(b, fields(b, l + 1)) && r;
    r = p && consumeToken(b, RIGHTCURLYBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'xsd_optional'? 'xsd_nillable'? XsdAttrs?
  public static boolean XsdFieldOptions(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "XsdFieldOptions")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, XSD_FIELD_OPTIONS, "<xsd field options>");
    r = XsdFieldOptions_0(b, l + 1);
    r = r && XsdFieldOptions_1(b, l + 1);
    r = r && XsdFieldOptions_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'xsd_optional'?
  private static boolean XsdFieldOptions_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "XsdFieldOptions_0")) return false;
    consumeToken(b, "xsd_optional");
    return true;
  }

  // 'xsd_nillable'?
  private static boolean XsdFieldOptions_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "XsdFieldOptions_1")) return false;
    consumeToken(b, "xsd_nillable");
    return true;
  }

  // XsdAttrs?
  private static boolean XsdFieldOptions_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "XsdFieldOptions_2")) return false;
    XsdAttrs(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // !(')')
  static boolean braceRecovery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "braceRecovery")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, RIGHTBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // !('}')
  static boolean curlyBraceRecovery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "curlyBraceRecovery")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, RIGHTCURLYBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Identifier ('=' IntConstant)? TypeAnnotations? ListSeparator?
  public static boolean enumField(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumField")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENUM_FIELD, "<enum field>");
    r = consumeToken(b, IDENTIFIER);
    r = r && enumField_1(b, l + 1);
    r = r && enumField_2(b, l + 1);
    r = r && enumField_3(b, l + 1);
    exit_section_(b, l, m, r, false, ThriftParser::enumFieldRecovery);
    return r;
  }

  // ('=' IntConstant)?
  private static boolean enumField_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumField_1")) return false;
    enumField_1_0(b, l + 1);
    return true;
  }

  // '=' IntConstant
  private static boolean enumField_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumField_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUALS);
    r = r && IntConstant(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // TypeAnnotations?
  private static boolean enumField_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumField_2")) return false;
    TypeAnnotations(b, l + 1);
    return true;
  }

  // ListSeparator?
  private static boolean enumField_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumField_3")) return false;
    ListSeparator(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // !('}' | Identifier)
  static boolean enumFieldRecovery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumFieldRecovery")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !enumFieldRecovery_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '}' | Identifier
  private static boolean enumFieldRecovery_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumFieldRecovery_0")) return false;
    boolean r;
    r = consumeToken(b, RIGHTCURLYBRACE);
    if (!r) r = consumeToken(b, IDENTIFIER);
    return r;
  }

  /* ********************************************************** */
  // enumField*
  public static boolean enumFields(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumFields")) return false;
    Marker m = enter_section_(b, l, _NONE_, ENUM_FIELDS, "<enum fields>");
    while (true) {
      int c = current_position_(b);
      if (!enumField(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "enumFields", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // !(')' | '+' | '-' | 'binary' | 'bool' | 'byte' | 'double' | 'i8' | 'i16' | 'i32' | 'i64' | 'list' |
  //                             'map' | 'optional' | 'required' | 'set' | 'slist' | 'string' | '}'| Integer | Identifier | Number )
  static boolean fieldRecovery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fieldRecovery")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !fieldRecovery_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ')' | '+' | '-' | 'binary' | 'bool' | 'byte' | 'double' | 'i8' | 'i16' | 'i32' | 'i64' | 'list' |
  //                             'map' | 'optional' | 'required' | 'set' | 'slist' | 'string' | '}'| Integer | Identifier | Number
  private static boolean fieldRecovery_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fieldRecovery_0")) return false;
    boolean r;
    r = consumeToken(b, RIGHTBRACE);
    if (!r) r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, "binary");
    if (!r) r = consumeToken(b, "bool");
    if (!r) r = consumeToken(b, "byte");
    if (!r) r = consumeToken(b, "double");
    if (!r) r = consumeToken(b, "i8");
    if (!r) r = consumeToken(b, "i16");
    if (!r) r = consumeToken(b, "i32");
    if (!r) r = consumeToken(b, "i64");
    if (!r) r = consumeToken(b, "list");
    if (!r) r = consumeToken(b, "map");
    if (!r) r = consumeToken(b, "optional");
    if (!r) r = consumeToken(b, "required");
    if (!r) r = consumeToken(b, "set");
    if (!r) r = consumeToken(b, "slist");
    if (!r) r = consumeToken(b, "string");
    if (!r) r = consumeToken(b, RIGHTCURLYBRACE);
    if (!r) r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, NUMBER);
    return r;
  }

  /* ********************************************************** */
  // Field*
  public static boolean fields(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fields")) return false;
    Marker m = enter_section_(b, l, _NONE_, FIELDS, "<fields>");
    while (true) {
      int c = current_position_(b);
      if (!Field(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "fields", c)) break;
    }
    exit_section_(b, l, m, true, false, ThriftParser::curlyBraceRecovery);
    return true;
  }

  /* ********************************************************** */
  // Field*
  static boolean fieldsWithBraceRecovery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fieldsWithBraceRecovery")) return false;
    Marker m = enter_section_(b, l, _NONE_);
    while (true) {
      int c = current_position_(b);
      if (!Field(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "fieldsWithBraceRecovery", c)) break;
    }
    exit_section_(b, l, m, true, false, ThriftParser::braceRecovery);
    return true;
  }

  /* ********************************************************** */
  // !('binary' | 'bool' | 'byte' | 'double' |'i8' | 'i16' | 'i32' | 'i64' | 'list' | 'map' |
  //                                'oneway' | 'set' | 'slist' | 'string' | 'void' | '}' | Identifier | ListSeparator)
  static boolean functionRecovery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionRecovery")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !functionRecovery_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'binary' | 'bool' | 'byte' | 'double' |'i8' | 'i16' | 'i32' | 'i64' | 'list' | 'map' |
  //                                'oneway' | 'set' | 'slist' | 'string' | 'void' | '}' | Identifier | ListSeparator
  private static boolean functionRecovery_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionRecovery_0")) return false;
    boolean r;
    r = consumeToken(b, "binary");
    if (!r) r = consumeToken(b, "bool");
    if (!r) r = consumeToken(b, "byte");
    if (!r) r = consumeToken(b, "double");
    if (!r) r = consumeToken(b, "i8");
    if (!r) r = consumeToken(b, "i16");
    if (!r) r = consumeToken(b, "i32");
    if (!r) r = consumeToken(b, "i64");
    if (!r) r = consumeToken(b, "list");
    if (!r) r = consumeToken(b, "map");
    if (!r) r = consumeToken(b, "oneway");
    if (!r) r = consumeToken(b, "set");
    if (!r) r = consumeToken(b, "slist");
    if (!r) r = consumeToken(b, "string");
    if (!r) r = consumeToken(b, "void");
    if (!r) r = consumeToken(b, RIGHTCURLYBRACE);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = ListSeparator(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // !('}')
  static boolean functionsRecovery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionsRecovery")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, RIGHTCURLYBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'php_namespace' Literal
  static boolean php_namespace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "php_namespace")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, "php_namespace");
    p = r; // pin = 1
    r = r && consumeToken(b, LITERAL);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // senumField*
  public static boolean senumBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "senumBody")) return false;
    Marker m = enter_section_(b, l, _NONE_, SENUM_BODY, "<senum body>");
    while (true) {
      int c = current_position_(b);
      if (!senumField(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "senumBody", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // Literal ListSeparator?
  public static boolean senumField(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "senumField")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SENUM_FIELD, "<senum field>");
    r = consumeToken(b, LITERAL);
    r = r && senumField_1(b, l + 1);
    exit_section_(b, l, m, r, false, ThriftParser::senumFieldRecovery);
    return r;
  }

  // ListSeparator?
  private static boolean senumField_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "senumField_1")) return false;
    ListSeparator(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // !('}' | Literal)
  static boolean senumFieldRecovery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "senumFieldRecovery")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !senumFieldRecovery_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '}' | Literal
  private static boolean senumFieldRecovery_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "senumFieldRecovery_0")) return false;
    boolean r;
    r = consumeToken(b, RIGHTCURLYBRACE);
    if (!r) r = consumeToken(b, LITERAL);
    return r;
  }

  /* ********************************************************** */
  // (Function ListSeparator?)*
  public static boolean serviceBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "serviceBody")) return false;
    Marker m = enter_section_(b, l, _NONE_, SERVICE_BODY, "<service body>");
    while (true) {
      int c = current_position_(b);
      if (!serviceBody_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "serviceBody", c)) break;
    }
    exit_section_(b, l, m, true, false, ThriftParser::functionsRecovery);
    return true;
  }

  // Function ListSeparator?
  private static boolean serviceBody_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "serviceBody_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Function(b, l + 1);
    r = r && serviceBody_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ListSeparator?
  private static boolean serviceBody_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "serviceBody_0_1")) return false;
    ListSeparator(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'namespace' (
  //     ( NamespaceScope Identifier ) |
  //     ( 'smalltalk.category' STIdentifier ) |
  //     ( 'smalltalk.prefix' Identifier )
  // )
  static boolean std_namespace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "std_namespace")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, "namespace");
    p = r; // pin = 1
    r = r && std_namespace_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ( NamespaceScope Identifier ) |
  //     ( 'smalltalk.category' STIdentifier ) |
  //     ( 'smalltalk.prefix' Identifier )
  private static boolean std_namespace_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "std_namespace_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = std_namespace_1_0(b, l + 1);
    if (!r) r = std_namespace_1_1(b, l + 1);
    if (!r) r = std_namespace_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NamespaceScope Identifier
  private static boolean std_namespace_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "std_namespace_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = NamespaceScope(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'smalltalk.category' STIdentifier
  private static boolean std_namespace_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "std_namespace_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "smalltalk.category");
    r = r && consumeToken(b, STIDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'smalltalk.prefix' Identifier
  private static boolean std_namespace_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "std_namespace_1_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "smalltalk.prefix");
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Include | Namespace |
  //                              Const | Typedef | Enum | Senum | Struct | Union | Exception | Service
  static boolean topLevelElement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "topLevelElement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = Include(b, l + 1);
    if (!r) r = Namespace(b, l + 1);
    if (!r) r = Const(b, l + 1);
    if (!r) r = Typedef(b, l + 1);
    if (!r) r = Enum(b, l + 1);
    if (!r) r = Senum(b, l + 1);
    if (!r) r = Struct(b, l + 1);
    if (!r) r = Union(b, l + 1);
    if (!r) r = Exception(b, l + 1);
    if (!r) r = Service(b, l + 1);
    exit_section_(b, l, m, r, false, ThriftParser::topLevelRecover);
    return r;
  }

  /* ********************************************************** */
  // !('const' | 'cpp_include' | 'enum' | 'exception' | 'include' | 'namespace' |
  //                               'php_namespace' | 'senum' | 'service' | 'struct' | 'typedef' | 'union' |
  //                               'xsd_namespace' )
  static boolean topLevelRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "topLevelRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !topLevelRecover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'const' | 'cpp_include' | 'enum' | 'exception' | 'include' | 'namespace' |
  //                               'php_namespace' | 'senum' | 'service' | 'struct' | 'typedef' | 'union' |
  //                               'xsd_namespace'
  private static boolean topLevelRecover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "topLevelRecover_0")) return false;
    boolean r;
    r = consumeToken(b, "const");
    if (!r) r = consumeToken(b, "cpp_include");
    if (!r) r = consumeToken(b, "enum");
    if (!r) r = consumeToken(b, "exception");
    if (!r) r = consumeToken(b, "include");
    if (!r) r = consumeToken(b, "namespace");
    if (!r) r = consumeToken(b, "php_namespace");
    if (!r) r = consumeToken(b, "senum");
    if (!r) r = consumeToken(b, "service");
    if (!r) r = consumeToken(b, "struct");
    if (!r) r = consumeToken(b, "typedef");
    if (!r) r = consumeToken(b, "union");
    if (!r) r = consumeToken(b, "xsd_namespace");
    return r;
  }

  /* ********************************************************** */
  // 'xsd_namespace' Literal
  static boolean xsd_namespace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xsd_namespace")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, "xsd_namespace");
    p = r; // pin = 1
    r = r && consumeToken(b, LITERAL);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

}
