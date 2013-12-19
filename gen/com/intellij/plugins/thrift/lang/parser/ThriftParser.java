// This is a generated file. Not intended for manual editing.
package com.intellij.plugins.thrift.lang.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.openapi.diagnostic.Logger;
import static com.intellij.plugins.thrift.lang.lexer.ThriftTokenTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ThriftParser implements PsiParser {

  public static final Logger LOG_ = Logger.getInstance("com.intellij.plugins.thrift.lang.parser.ThriftParser");

  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, null);
    Marker marker_ = enter_section_(builder_, 0, _COLLAPSE_, null);
    if (root_ == BASE_TYPE) {
      result_ = BaseType(builder_, 0);
    }
    else if (root_ == CONST) {
      result_ = Const(builder_, 0);
    }
    else if (root_ == CONST_LIST) {
      result_ = ConstList(builder_, 0);
    }
    else if (root_ == CONST_MAP) {
      result_ = ConstMap(builder_, 0);
    }
    else if (root_ == CONST_VALUE) {
      result_ = ConstValue(builder_, 0);
    }
    else if (root_ == CPP_TYPE) {
      result_ = CppType(builder_, 0);
    }
    else if (root_ == CUSTOM_TYPE) {
      result_ = CustomType(builder_, 0);
    }
    else if (root_ == DEFINITION_NAME) {
      result_ = DefinitionName(builder_, 0);
    }
    else if (root_ == DOUBLE_CONSTANT) {
      result_ = DoubleConstant(builder_, 0);
    }
    else if (root_ == ENUM) {
      result_ = Enum(builder_, 0);
    }
    else if (root_ == EXCEPTION) {
      result_ = Exception(builder_, 0);
    }
    else if (root_ == FIELD) {
      result_ = Field(builder_, 0);
    }
    else if (root_ == FIELD_ID) {
      result_ = FieldID(builder_, 0);
    }
    else if (root_ == FIELD_REQ) {
      result_ = FieldReq(builder_, 0);
    }
    else if (root_ == FIELD_TYPE) {
      result_ = FieldType(builder_, 0);
    }
    else if (root_ == FUNCTION) {
      result_ = Function(builder_, 0);
    }
    else if (root_ == FUNCTION_TYPE) {
      result_ = FunctionType(builder_, 0);
    }
    else if (root_ == INCLUDE) {
      result_ = Include(builder_, 0);
    }
    else if (root_ == INT_CONSTANT) {
      result_ = IntConstant(builder_, 0);
    }
    else if (root_ == LIST_SEPARATOR) {
      result_ = ListSeparator(builder_, 0);
    }
    else if (root_ == LIST_TYPE) {
      result_ = ListType(builder_, 0);
    }
    else if (root_ == MAP_TYPE) {
      result_ = MapType(builder_, 0);
    }
    else if (root_ == NAMESPACE) {
      result_ = Namespace(builder_, 0);
    }
    else if (root_ == NAMESPACE_SCOPE) {
      result_ = NamespaceScope(builder_, 0);
    }
    else if (root_ == SENUM) {
      result_ = Senum(builder_, 0);
    }
    else if (root_ == SERVICE) {
      result_ = Service(builder_, 0);
    }
    else if (root_ == SET_TYPE) {
      result_ = SetType(builder_, 0);
    }
    else if (root_ == STRUCT) {
      result_ = Struct(builder_, 0);
    }
    else if (root_ == THROWS) {
      result_ = Throws(builder_, 0);
    }
    else if (root_ == TYPE_ANNOTATION) {
      result_ = TypeAnnotation(builder_, 0);
    }
    else if (root_ == TYPE_ANNOTATION_LIST) {
      result_ = TypeAnnotationList(builder_, 0);
    }
    else if (root_ == TYPE_ANNOTATIONS) {
      result_ = TypeAnnotations(builder_, 0);
    }
    else if (root_ == TYPEDEF) {
      result_ = Typedef(builder_, 0);
    }
    else if (root_ == UNION) {
      result_ = Union(builder_, 0);
    }
    else if (root_ == XSD_ATTRS) {
      result_ = XsdAttrs(builder_, 0);
    }
    else if (root_ == XSD_FIELD_OPTIONS) {
      result_ = XsdFieldOptions(builder_, 0);
    }
    else if (root_ == ENUM_FIELD) {
      result_ = enumField(builder_, 0);
    }
    else if (root_ == ENUM_FIELDS) {
      result_ = enumFields(builder_, 0);
    }
    else if (root_ == FIELDS) {
      result_ = fields(builder_, 0);
    }
    else if (root_ == SEMUN_FIELD) {
      result_ = semunField(builder_, 0);
    }
    else if (root_ == SENUM_BODY) {
      result_ = senumBody(builder_, 0);
    }
    else if (root_ == SERVICE_BODY) {
      result_ = serviceBody(builder_, 0);
    }
    else {
      result_ = parse_root_(root_, builder_, 0);
    }
    exit_section_(builder_, 0, marker_, root_, result_, true, TRUE_CONDITION);
    return builder_.getTreeBuilt();
  }

  protected boolean parse_root_(final IElementType root_, final PsiBuilder builder_, final int level_) {
    return Document(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // 'bool' | 'byte' | 'i16' | 'i32' | 'i64' | 'double' | 'string' | 'binary' | 'slist'
  public static boolean BaseType(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "BaseType")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<base type>");
    result_ = consumeToken(builder_, "bool");
    if (!result_) result_ = consumeToken(builder_, "byte");
    if (!result_) result_ = consumeToken(builder_, "i16");
    if (!result_) result_ = consumeToken(builder_, "i32");
    if (!result_) result_ = consumeToken(builder_, "i64");
    if (!result_) result_ = consumeToken(builder_, "double");
    if (!result_) result_ = consumeToken(builder_, "string");
    if (!result_) result_ = consumeToken(builder_, "binary");
    if (!result_) result_ = consumeToken(builder_, "slist");
    exit_section_(builder_, level_, marker_, BASE_TYPE, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // 'const' FieldType DefinitionName '=' ConstValue ListSeparator?
  public static boolean Const(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Const")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<const>");
    result_ = consumeToken(builder_, "const");
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, FieldType(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, DefinitionName(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, EQUALS)) && result_;
    result_ = pinned_ && report_error_(builder_, ConstValue(builder_, level_ + 1)) && result_;
    result_ = pinned_ && Const_5(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, CONST, result_, pinned_, null);
    return result_ || pinned_;
  }

  // ListSeparator?
  private static boolean Const_5(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Const_5")) return false;
    ListSeparator(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // '[' (ConstValue ListSeparator?)* ']'
  public static boolean ConstList(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ConstList")) return false;
    if (!nextTokenIs(builder_, LEFTBRACKET)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LEFTBRACKET);
    result_ = result_ && ConstList_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RIGHTBRACKET);
    exit_section_(builder_, marker_, CONST_LIST, result_);
    return result_;
  }

  // (ConstValue ListSeparator?)*
  private static boolean ConstList_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ConstList_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!ConstList_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "ConstList_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // ConstValue ListSeparator?
  private static boolean ConstList_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ConstList_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = ConstValue(builder_, level_ + 1);
    result_ = result_ && ConstList_1_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ListSeparator?
  private static boolean ConstList_1_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ConstList_1_0_1")) return false;
    ListSeparator(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // '{' (ConstValue ':' ConstValue ListSeparator?)* '}'
  public static boolean ConstMap(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ConstMap")) return false;
    if (!nextTokenIs(builder_, LEFTCURLYBRACE)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LEFTCURLYBRACE);
    result_ = result_ && ConstMap_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RIGHTCURLYBRACE);
    exit_section_(builder_, marker_, CONST_MAP, result_);
    return result_;
  }

  // (ConstValue ':' ConstValue ListSeparator?)*
  private static boolean ConstMap_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ConstMap_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!ConstMap_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "ConstMap_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // ConstValue ':' ConstValue ListSeparator?
  private static boolean ConstMap_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ConstMap_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = ConstValue(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLON);
    result_ = result_ && ConstValue(builder_, level_ + 1);
    result_ = result_ && ConstMap_1_0_3(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ListSeparator?
  private static boolean ConstMap_1_0_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ConstMap_1_0_3")) return false;
    ListSeparator(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // IntConstant | DoubleConstant | Literal | Identifier | ConstList | ConstMap
  public static boolean ConstValue(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ConstValue")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<const value>");
    result_ = IntConstant(builder_, level_ + 1);
    if (!result_) result_ = DoubleConstant(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, LITERAL);
    if (!result_) result_ = consumeToken(builder_, IDENTIFIER);
    if (!result_) result_ = ConstList(builder_, level_ + 1);
    if (!result_) result_ = ConstMap(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, CONST_VALUE, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // MapType | SetType | ListType
  static boolean ContainerType(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ContainerType")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = MapType(builder_, level_ + 1);
    if (!result_) result_ = SetType(builder_, level_ + 1);
    if (!result_) result_ = ListType(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // 'cpp_type' Literal
  public static boolean CppType(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "CppType")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<cpp type>");
    result_ = consumeToken(builder_, "cpp_type");
    pinned_ = result_; // pin = 1
    result_ = result_ && consumeToken(builder_, LITERAL);
    exit_section_(builder_, level_, marker_, CPP_TYPE, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // Identifier
  public static boolean CustomType(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "CustomType")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, marker_, CUSTOM_TYPE, result_);
    return result_;
  }

  /* ********************************************************** */
  // Identifier
  public static boolean DefinitionName(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "DefinitionName")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, marker_, DEFINITION_NAME, result_);
    return result_;
  }

  /* ********************************************************** */
  // BaseType | ContainerType
  static boolean DefinitionType(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "DefinitionType")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = BaseType(builder_, level_ + 1);
    if (!result_) result_ = ContainerType(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // topLevelElement*
  static boolean Document(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Document")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!topLevelElement(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "Document", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  /* ********************************************************** */
  // ('+' | '-')? Number
  public static boolean DoubleConstant(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "DoubleConstant")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<double constant>");
    result_ = DoubleConstant_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, NUMBER);
    exit_section_(builder_, level_, marker_, DOUBLE_CONSTANT, result_, false, null);
    return result_;
  }

  // ('+' | '-')?
  private static boolean DoubleConstant_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "DoubleConstant_0")) return false;
    DoubleConstant_0_0(builder_, level_ + 1);
    return true;
  }

  // '+' | '-'
  private static boolean DoubleConstant_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "DoubleConstant_0_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, PLUS);
    if (!result_) result_ = consumeToken(builder_, MINUS);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // 'enum' DefinitionName '{' enumFields '}'
  public static boolean Enum(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Enum")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<enum>");
    result_ = consumeToken(builder_, "enum");
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, DefinitionName(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, LEFTCURLYBRACE)) && result_;
    result_ = pinned_ && report_error_(builder_, enumFields(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, RIGHTCURLYBRACE) && result_;
    exit_section_(builder_, level_, marker_, ENUM, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // 'exception' DefinitionName '{' fields '}'
  public static boolean Exception(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Exception")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<exception>");
    result_ = consumeToken(builder_, "exception");
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, DefinitionName(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, LEFTCURLYBRACE)) && result_;
    result_ = pinned_ && report_error_(builder_, fields(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, RIGHTCURLYBRACE) && result_;
    exit_section_(builder_, level_, marker_, EXCEPTION, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // FieldID? FieldReq? FieldType DefinitionName ('=' ConstValue)? XsdFieldOptions TypeAnnotations? ListSeparator?
  public static boolean Field(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Field")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<field>");
    result_ = Field_0(builder_, level_ + 1);
    result_ = result_ && Field_1(builder_, level_ + 1);
    result_ = result_ && FieldType(builder_, level_ + 1);
    pinned_ = result_; // pin = 3
    result_ = result_ && report_error_(builder_, DefinitionName(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, Field_4(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, XsdFieldOptions(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, Field_6(builder_, level_ + 1)) && result_;
    result_ = pinned_ && Field_7(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, FIELD, result_, pinned_, fieldRecovery_parser_);
    return result_ || pinned_;
  }

  // FieldID?
  private static boolean Field_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Field_0")) return false;
    FieldID(builder_, level_ + 1);
    return true;
  }

  // FieldReq?
  private static boolean Field_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Field_1")) return false;
    FieldReq(builder_, level_ + 1);
    return true;
  }

  // ('=' ConstValue)?
  private static boolean Field_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Field_4")) return false;
    Field_4_0(builder_, level_ + 1);
    return true;
  }

  // '=' ConstValue
  private static boolean Field_4_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Field_4_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, EQUALS);
    result_ = result_ && ConstValue(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // TypeAnnotations?
  private static boolean Field_6(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Field_6")) return false;
    TypeAnnotations(builder_, level_ + 1);
    return true;
  }

  // ListSeparator?
  private static boolean Field_7(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Field_7")) return false;
    ListSeparator(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // IntConstant ':'
  public static boolean FieldID(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "FieldID")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<field id>");
    result_ = IntConstant(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLON);
    exit_section_(builder_, level_, marker_, FIELD_ID, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // 'required' | 'optional'
  public static boolean FieldReq(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "FieldReq")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<field req>");
    result_ = consumeToken(builder_, "required");
    if (!result_) result_ = consumeToken(builder_, "optional");
    exit_section_(builder_, level_, marker_, FIELD_REQ, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // BaseType | ContainerType | CustomType
  public static boolean FieldType(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "FieldType")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<field type>");
    result_ = BaseType(builder_, level_ + 1);
    if (!result_) result_ = ContainerType(builder_, level_ + 1);
    if (!result_) result_ = CustomType(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, FIELD_TYPE, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // 'oneway'? FunctionType DefinitionName '(' fieldsWithBraceRecovery ')' Throws?
  public static boolean Function(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Function")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<function>");
    result_ = Function_0(builder_, level_ + 1);
    result_ = result_ && FunctionType(builder_, level_ + 1);
    result_ = result_ && DefinitionName(builder_, level_ + 1);
    pinned_ = result_; // pin = 3
    result_ = result_ && report_error_(builder_, consumeToken(builder_, LEFTBRACE));
    result_ = pinned_ && report_error_(builder_, fieldsWithBraceRecovery(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, RIGHTBRACE)) && result_;
    result_ = pinned_ && Function_6(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, FUNCTION, result_, pinned_, functionRecovery_parser_);
    return result_ || pinned_;
  }

  // 'oneway'?
  private static boolean Function_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Function_0")) return false;
    consumeToken(builder_, "oneway");
    return true;
  }

  // Throws?
  private static boolean Function_6(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Function_6")) return false;
    Throws(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // 'void' | FieldType
  public static boolean FunctionType(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "FunctionType")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<function type>");
    result_ = consumeToken(builder_, "void");
    if (!result_) result_ = FieldType(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, FUNCTION_TYPE, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // ('include' | 'cpp_include') Literal
  public static boolean Include(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Include")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<include>");
    result_ = Include_0(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && consumeToken(builder_, LITERAL);
    exit_section_(builder_, level_, marker_, INCLUDE, result_, pinned_, null);
    return result_ || pinned_;
  }

  // 'include' | 'cpp_include'
  private static boolean Include_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Include_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, "include");
    if (!result_) result_ = consumeToken(builder_, "cpp_include");
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // ('+' | '-')? Integer
  public static boolean IntConstant(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "IntConstant")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<int constant>");
    result_ = IntConstant_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, INTEGER);
    exit_section_(builder_, level_, marker_, INT_CONSTANT, result_, false, null);
    return result_;
  }

  // ('+' | '-')?
  private static boolean IntConstant_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "IntConstant_0")) return false;
    IntConstant_0_0(builder_, level_ + 1);
    return true;
  }

  // '+' | '-'
  private static boolean IntConstant_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "IntConstant_0_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, PLUS);
    if (!result_) result_ = consumeToken(builder_, MINUS);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // ',' | ';'
  public static boolean ListSeparator(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ListSeparator")) return false;
    if (!nextTokenIs(builder_, "<list separator>", COMMA, SEMICOLON)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<list separator>");
    result_ = consumeToken(builder_, COMMA);
    if (!result_) result_ = consumeToken(builder_, SEMICOLON);
    exit_section_(builder_, level_, marker_, LIST_SEPARATOR, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // 'list' '<' FieldType '>' CppType?
  public static boolean ListType(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ListType")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<list type>");
    result_ = consumeToken(builder_, "list");
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, consumeToken(builder_, LT));
    result_ = pinned_ && report_error_(builder_, FieldType(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, GT)) && result_;
    result_ = pinned_ && ListType_4(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, LIST_TYPE, result_, pinned_, null);
    return result_ || pinned_;
  }

  // CppType?
  private static boolean ListType_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ListType_4")) return false;
    CppType(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // 'map' CppType? '<' FieldType ',' FieldType '>'
  public static boolean MapType(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "MapType")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<map type>");
    result_ = consumeToken(builder_, "map");
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, MapType_1(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, LT)) && result_;
    result_ = pinned_ && report_error_(builder_, FieldType(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, COMMA)) && result_;
    result_ = pinned_ && report_error_(builder_, FieldType(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, GT) && result_;
    exit_section_(builder_, level_, marker_, MAP_TYPE, result_, pinned_, null);
    return result_ || pinned_;
  }

  // CppType?
  private static boolean MapType_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "MapType_1")) return false;
    CppType(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // std_namespace | php_namespace | xsd_namespace
  public static boolean Namespace(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Namespace")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<namespace>");
    result_ = std_namespace(builder_, level_ + 1);
    if (!result_) result_ = php_namespace(builder_, level_ + 1);
    if (!result_) result_ = xsd_namespace(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, NAMESPACE, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // Multiply | 'cpp' | 'java' | 'py' | 'py.twisted' | 'perl' | 'rb' | 'js' | 'st' |
  //                      'cocoa' | 'csharp' | 'c_glib' | 'go' | 'php' | 'delphi'
  public static boolean NamespaceScope(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "NamespaceScope")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<namespace scope>");
    result_ = consumeToken(builder_, MULTIPLY);
    if (!result_) result_ = consumeToken(builder_, "cpp");
    if (!result_) result_ = consumeToken(builder_, "java");
    if (!result_) result_ = consumeToken(builder_, "py");
    if (!result_) result_ = consumeToken(builder_, "py.twisted");
    if (!result_) result_ = consumeToken(builder_, "perl");
    if (!result_) result_ = consumeToken(builder_, "rb");
    if (!result_) result_ = consumeToken(builder_, "js");
    if (!result_) result_ = consumeToken(builder_, "st");
    if (!result_) result_ = consumeToken(builder_, "cocoa");
    if (!result_) result_ = consumeToken(builder_, "csharp");
    if (!result_) result_ = consumeToken(builder_, "c_glib");
    if (!result_) result_ = consumeToken(builder_, "go");
    if (!result_) result_ = consumeToken(builder_, "php");
    if (!result_) result_ = consumeToken(builder_, "delphi");
    exit_section_(builder_, level_, marker_, NAMESPACE_SCOPE, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // 'senum' DefinitionName '{' senumBody '}'
  public static boolean Senum(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Senum")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<senum>");
    result_ = consumeToken(builder_, "senum");
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, DefinitionName(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, LEFTCURLYBRACE)) && result_;
    result_ = pinned_ && report_error_(builder_, senumBody(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, RIGHTCURLYBRACE) && result_;
    exit_section_(builder_, level_, marker_, SENUM, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // 'service' DefinitionName ( 'extends' Identifier )? '{' serviceBody '}'
  public static boolean Service(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Service")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<service>");
    result_ = consumeToken(builder_, "service");
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, DefinitionName(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, Service_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, LEFTCURLYBRACE)) && result_;
    result_ = pinned_ && report_error_(builder_, serviceBody(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, RIGHTCURLYBRACE) && result_;
    exit_section_(builder_, level_, marker_, SERVICE, result_, pinned_, null);
    return result_ || pinned_;
  }

  // ( 'extends' Identifier )?
  private static boolean Service_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Service_2")) return false;
    Service_2_0(builder_, level_ + 1);
    return true;
  }

  // 'extends' Identifier
  private static boolean Service_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Service_2_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, "extends");
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // 'set' CppType? '<' FieldType '>'
  public static boolean SetType(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SetType")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<set type>");
    result_ = consumeToken(builder_, "set");
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, SetType_1(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, LT)) && result_;
    result_ = pinned_ && report_error_(builder_, FieldType(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, GT) && result_;
    exit_section_(builder_, level_, marker_, SET_TYPE, result_, pinned_, null);
    return result_ || pinned_;
  }

  // CppType?
  private static boolean SetType_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SetType_1")) return false;
    CppType(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // 'struct' DefinitionName 'xsd_all'? '{' fields '}' TypeAnnotations?
  public static boolean Struct(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Struct")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<struct>");
    result_ = consumeToken(builder_, "struct");
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, DefinitionName(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, Struct_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, LEFTCURLYBRACE)) && result_;
    result_ = pinned_ && report_error_(builder_, fields(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, RIGHTCURLYBRACE)) && result_;
    result_ = pinned_ && Struct_6(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, STRUCT, result_, pinned_, null);
    return result_ || pinned_;
  }

  // 'xsd_all'?
  private static boolean Struct_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Struct_2")) return false;
    consumeToken(builder_, "xsd_all");
    return true;
  }

  // TypeAnnotations?
  private static boolean Struct_6(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Struct_6")) return false;
    TypeAnnotations(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // 'throws' '(' fieldsWithBraceRecovery ')'
  public static boolean Throws(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Throws")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<throws>");
    result_ = consumeToken(builder_, "throws");
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, consumeToken(builder_, LEFTBRACE));
    result_ = pinned_ && report_error_(builder_, fieldsWithBraceRecovery(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, RIGHTBRACE) && result_;
    exit_section_(builder_, level_, marker_, THROWS, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // Identifier '=' Literal ListSeparator?
  public static boolean TypeAnnotation(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TypeAnnotation")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IDENTIFIER);
    result_ = result_ && consumeToken(builder_, EQUALS);
    result_ = result_ && consumeToken(builder_, LITERAL);
    result_ = result_ && TypeAnnotation_3(builder_, level_ + 1);
    exit_section_(builder_, marker_, TYPE_ANNOTATION, result_);
    return result_;
  }

  // ListSeparator?
  private static boolean TypeAnnotation_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TypeAnnotation_3")) return false;
    ListSeparator(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // TypeAnnotation*
  public static boolean TypeAnnotationList(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TypeAnnotationList")) return false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<type annotation list>");
    int pos_ = current_position_(builder_);
    while (true) {
      if (!TypeAnnotation(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "TypeAnnotationList", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, level_, marker_, TYPE_ANNOTATION_LIST, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // '(' TypeAnnotationList ')'
  public static boolean TypeAnnotations(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TypeAnnotations")) return false;
    if (!nextTokenIs(builder_, LEFTBRACE)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LEFTBRACE);
    result_ = result_ && TypeAnnotationList(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RIGHTBRACE);
    exit_section_(builder_, marker_, TYPE_ANNOTATIONS, result_);
    return result_;
  }

  /* ********************************************************** */
  // 'typedef' FieldType DefinitionName
  public static boolean Typedef(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Typedef")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<typedef>");
    result_ = consumeToken(builder_, "typedef");
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, FieldType(builder_, level_ + 1));
    result_ = pinned_ && DefinitionName(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, TYPEDEF, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // 'union' DefinitionName 'xsd_all'? '{' fields '}'
  public static boolean Union(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Union")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<union>");
    result_ = consumeToken(builder_, "union");
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, DefinitionName(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, Union_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, LEFTCURLYBRACE)) && result_;
    result_ = pinned_ && report_error_(builder_, fields(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, RIGHTCURLYBRACE) && result_;
    exit_section_(builder_, level_, marker_, UNION, result_, pinned_, null);
    return result_ || pinned_;
  }

  // 'xsd_all'?
  private static boolean Union_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Union_2")) return false;
    consumeToken(builder_, "xsd_all");
    return true;
  }

  /* ********************************************************** */
  // 'xsd_attrs' '{' fields '}'
  public static boolean XsdAttrs(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "XsdAttrs")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<xsd attrs>");
    result_ = consumeToken(builder_, "xsd_attrs");
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, consumeToken(builder_, LEFTCURLYBRACE));
    result_ = pinned_ && report_error_(builder_, fields(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, RIGHTCURLYBRACE) && result_;
    exit_section_(builder_, level_, marker_, XSD_ATTRS, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // 'xsd_optional'? 'xsd_nillable'? XsdAttrs?
  public static boolean XsdFieldOptions(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "XsdFieldOptions")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<xsd field options>");
    result_ = XsdFieldOptions_0(builder_, level_ + 1);
    result_ = result_ && XsdFieldOptions_1(builder_, level_ + 1);
    result_ = result_ && XsdFieldOptions_2(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, XSD_FIELD_OPTIONS, result_, false, null);
    return result_;
  }

  // 'xsd_optional'?
  private static boolean XsdFieldOptions_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "XsdFieldOptions_0")) return false;
    consumeToken(builder_, "xsd_optional");
    return true;
  }

  // 'xsd_nillable'?
  private static boolean XsdFieldOptions_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "XsdFieldOptions_1")) return false;
    consumeToken(builder_, "xsd_nillable");
    return true;
  }

  // XsdAttrs?
  private static boolean XsdFieldOptions_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "XsdFieldOptions_2")) return false;
    XsdAttrs(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // !(')')
  static boolean braceRecovery(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "braceRecovery")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NOT_, null);
    result_ = !braceRecovery_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, null, result_, false, null);
    return result_;
  }

  // (')')
  private static boolean braceRecovery_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "braceRecovery_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, RIGHTBRACE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // !('}')
  static boolean curlyBraceRecovery(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "curlyBraceRecovery")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NOT_, null);
    result_ = !curlyBraceRecovery_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, null, result_, false, null);
    return result_;
  }

  // ('}')
  private static boolean curlyBraceRecovery_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "curlyBraceRecovery_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, RIGHTCURLYBRACE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // Identifier ('=' IntConstant)? ListSeparator?
  public static boolean enumField(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enumField")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<enum field>");
    result_ = consumeToken(builder_, IDENTIFIER);
    result_ = result_ && enumField_1(builder_, level_ + 1);
    result_ = result_ && enumField_2(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, ENUM_FIELD, result_, false, enumFieldRecovery_parser_);
    return result_;
  }

  // ('=' IntConstant)?
  private static boolean enumField_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enumField_1")) return false;
    enumField_1_0(builder_, level_ + 1);
    return true;
  }

  // '=' IntConstant
  private static boolean enumField_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enumField_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, EQUALS);
    result_ = result_ && IntConstant(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ListSeparator?
  private static boolean enumField_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enumField_2")) return false;
    ListSeparator(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // !('}' | Identifier)
  static boolean enumFieldRecovery(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enumFieldRecovery")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NOT_, null);
    result_ = !enumFieldRecovery_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, null, result_, false, null);
    return result_;
  }

  // '}' | Identifier
  private static boolean enumFieldRecovery_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enumFieldRecovery_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, RIGHTCURLYBRACE);
    if (!result_) result_ = consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // enumField*
  public static boolean enumFields(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enumFields")) return false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<enum fields>");
    int pos_ = current_position_(builder_);
    while (true) {
      if (!enumField(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "enumFields", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, level_, marker_, ENUM_FIELDS, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // !(')' | '+' | '-' | 'binary' | 'bool' | 'byte' | 'double' | 'i16' | 'i32' | 'i64' | 'list' |
  //                             'map' | 'optional' | 'required' | 'set' | 'slist' | 'string' | '}'| Integer | Identifier | Number )
  static boolean fieldRecovery(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "fieldRecovery")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NOT_, null);
    result_ = !fieldRecovery_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, null, result_, false, null);
    return result_;
  }

  // ')' | '+' | '-' | 'binary' | 'bool' | 'byte' | 'double' | 'i16' | 'i32' | 'i64' | 'list' |
  //                             'map' | 'optional' | 'required' | 'set' | 'slist' | 'string' | '}'| Integer | Identifier | Number
  private static boolean fieldRecovery_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "fieldRecovery_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, RIGHTBRACE);
    if (!result_) result_ = consumeToken(builder_, PLUS);
    if (!result_) result_ = consumeToken(builder_, MINUS);
    if (!result_) result_ = consumeToken(builder_, "binary");
    if (!result_) result_ = consumeToken(builder_, "bool");
    if (!result_) result_ = consumeToken(builder_, "byte");
    if (!result_) result_ = consumeToken(builder_, "double");
    if (!result_) result_ = consumeToken(builder_, "i16");
    if (!result_) result_ = consumeToken(builder_, "i32");
    if (!result_) result_ = consumeToken(builder_, "i64");
    if (!result_) result_ = consumeToken(builder_, "list");
    if (!result_) result_ = consumeToken(builder_, "map");
    if (!result_) result_ = consumeToken(builder_, "optional");
    if (!result_) result_ = consumeToken(builder_, "required");
    if (!result_) result_ = consumeToken(builder_, "set");
    if (!result_) result_ = consumeToken(builder_, "slist");
    if (!result_) result_ = consumeToken(builder_, "string");
    if (!result_) result_ = consumeToken(builder_, RIGHTCURLYBRACE);
    if (!result_) result_ = consumeToken(builder_, INTEGER);
    if (!result_) result_ = consumeToken(builder_, IDENTIFIER);
    if (!result_) result_ = consumeToken(builder_, NUMBER);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // Field*
  public static boolean fields(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "fields")) return false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<fields>");
    int pos_ = current_position_(builder_);
    while (true) {
      if (!Field(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "fields", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, level_, marker_, FIELDS, true, false, curlyBraceRecovery_parser_);
    return true;
  }

  /* ********************************************************** */
  // Field*
  static boolean fieldsWithBraceRecovery(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "fieldsWithBraceRecovery")) return false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    int pos_ = current_position_(builder_);
    while (true) {
      if (!Field(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "fieldsWithBraceRecovery", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, level_, marker_, null, true, false, braceRecovery_parser_);
    return true;
  }

  /* ********************************************************** */
  // !('binary' | 'bool' | 'byte' | 'double' | 'i16' | 'i32' | 'i64' | 'list' | 'map' |
  //                                'oneway' | 'set' | 'slist' | 'string' | 'void' | '}' | Identifier | ListSeparator)
  static boolean functionRecovery(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "functionRecovery")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NOT_, null);
    result_ = !functionRecovery_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, null, result_, false, null);
    return result_;
  }

  // 'binary' | 'bool' | 'byte' | 'double' | 'i16' | 'i32' | 'i64' | 'list' | 'map' |
  //                                'oneway' | 'set' | 'slist' | 'string' | 'void' | '}' | Identifier | ListSeparator
  private static boolean functionRecovery_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "functionRecovery_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, "binary");
    if (!result_) result_ = consumeToken(builder_, "bool");
    if (!result_) result_ = consumeToken(builder_, "byte");
    if (!result_) result_ = consumeToken(builder_, "double");
    if (!result_) result_ = consumeToken(builder_, "i16");
    if (!result_) result_ = consumeToken(builder_, "i32");
    if (!result_) result_ = consumeToken(builder_, "i64");
    if (!result_) result_ = consumeToken(builder_, "list");
    if (!result_) result_ = consumeToken(builder_, "map");
    if (!result_) result_ = consumeToken(builder_, "oneway");
    if (!result_) result_ = consumeToken(builder_, "set");
    if (!result_) result_ = consumeToken(builder_, "slist");
    if (!result_) result_ = consumeToken(builder_, "string");
    if (!result_) result_ = consumeToken(builder_, "void");
    if (!result_) result_ = consumeToken(builder_, RIGHTCURLYBRACE);
    if (!result_) result_ = consumeToken(builder_, IDENTIFIER);
    if (!result_) result_ = ListSeparator(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // !('}')
  static boolean functionsRecovery(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "functionsRecovery")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NOT_, null);
    result_ = !functionsRecovery_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, null, result_, false, null);
    return result_;
  }

  // ('}')
  private static boolean functionsRecovery_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "functionsRecovery_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, RIGHTCURLYBRACE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // 'php_namespace' Literal
  static boolean php_namespace(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "php_namespace")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, "php_namespace");
    pinned_ = result_; // pin = 1
    result_ = result_ && consumeToken(builder_, LITERAL);
    exit_section_(builder_, level_, marker_, null, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // Literal ListSeparator?
  public static boolean semunField(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "semunField")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<semun field>");
    result_ = consumeToken(builder_, LITERAL);
    result_ = result_ && semunField_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, SEMUN_FIELD, result_, false, semunFieldRecovery_parser_);
    return result_;
  }

  // ListSeparator?
  private static boolean semunField_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "semunField_1")) return false;
    ListSeparator(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // !('}' | Literal)
  static boolean semunFieldRecovery(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "semunFieldRecovery")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NOT_, null);
    result_ = !semunFieldRecovery_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, null, result_, false, null);
    return result_;
  }

  // '}' | Literal
  private static boolean semunFieldRecovery_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "semunFieldRecovery_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, RIGHTCURLYBRACE);
    if (!result_) result_ = consumeToken(builder_, LITERAL);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // semunField*
  public static boolean senumBody(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "senumBody")) return false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<senum body>");
    int pos_ = current_position_(builder_);
    while (true) {
      if (!semunField(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "senumBody", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, level_, marker_, SENUM_BODY, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // (Function ListSeparator?)*
  public static boolean serviceBody(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "serviceBody")) return false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<service body>");
    int pos_ = current_position_(builder_);
    while (true) {
      if (!serviceBody_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "serviceBody", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, level_, marker_, SERVICE_BODY, true, false, functionsRecovery_parser_);
    return true;
  }

  // Function ListSeparator?
  private static boolean serviceBody_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "serviceBody_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = Function(builder_, level_ + 1);
    result_ = result_ && serviceBody_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ListSeparator?
  private static boolean serviceBody_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "serviceBody_0_1")) return false;
    ListSeparator(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // 'namespace' (
  //     ( NamespaceScope Identifier ) |
  //     ( 'smalltalk.category' STIdentifier ) |
  //     ( 'smalltalk.prefix' Identifier )
  // )
  static boolean std_namespace(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "std_namespace")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, "namespace");
    pinned_ = result_; // pin = 1
    result_ = result_ && std_namespace_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, null, result_, pinned_, null);
    return result_ || pinned_;
  }

  // ( NamespaceScope Identifier ) |
  //     ( 'smalltalk.category' STIdentifier ) |
  //     ( 'smalltalk.prefix' Identifier )
  private static boolean std_namespace_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "std_namespace_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = std_namespace_1_0(builder_, level_ + 1);
    if (!result_) result_ = std_namespace_1_1(builder_, level_ + 1);
    if (!result_) result_ = std_namespace_1_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // NamespaceScope Identifier
  private static boolean std_namespace_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "std_namespace_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = NamespaceScope(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // 'smalltalk.category' STIdentifier
  private static boolean std_namespace_1_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "std_namespace_1_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, "smalltalk.category");
    result_ = result_ && consumeToken(builder_, STIDENTIFIER);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // 'smalltalk.prefix' Identifier
  private static boolean std_namespace_1_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "std_namespace_1_2")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, "smalltalk.prefix");
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // Include | Namespace |
  //                              Const | Typedef | Enum | Senum | Struct | Union | Exception | Service
  static boolean topLevelElement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "topLevelElement")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = Include(builder_, level_ + 1);
    if (!result_) result_ = Namespace(builder_, level_ + 1);
    if (!result_) result_ = Const(builder_, level_ + 1);
    if (!result_) result_ = Typedef(builder_, level_ + 1);
    if (!result_) result_ = Enum(builder_, level_ + 1);
    if (!result_) result_ = Senum(builder_, level_ + 1);
    if (!result_) result_ = Struct(builder_, level_ + 1);
    if (!result_) result_ = Union(builder_, level_ + 1);
    if (!result_) result_ = Exception(builder_, level_ + 1);
    if (!result_) result_ = Service(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, null, result_, false, topLevelRecover_parser_);
    return result_;
  }

  /* ********************************************************** */
  // !('const' | 'cpp_include' | 'enum' | 'exception' | 'include' | 'namespace' |
  //                               'php_namespace' | 'senum' | 'service' | 'struct' | 'typedef' | 'union' |
  //                               'xsd_namespace' )
  static boolean topLevelRecover(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "topLevelRecover")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NOT_, null);
    result_ = !topLevelRecover_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, null, result_, false, null);
    return result_;
  }

  // 'const' | 'cpp_include' | 'enum' | 'exception' | 'include' | 'namespace' |
  //                               'php_namespace' | 'senum' | 'service' | 'struct' | 'typedef' | 'union' |
  //                               'xsd_namespace'
  private static boolean topLevelRecover_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "topLevelRecover_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, "const");
    if (!result_) result_ = consumeToken(builder_, "cpp_include");
    if (!result_) result_ = consumeToken(builder_, "enum");
    if (!result_) result_ = consumeToken(builder_, "exception");
    if (!result_) result_ = consumeToken(builder_, "include");
    if (!result_) result_ = consumeToken(builder_, "namespace");
    if (!result_) result_ = consumeToken(builder_, "php_namespace");
    if (!result_) result_ = consumeToken(builder_, "senum");
    if (!result_) result_ = consumeToken(builder_, "service");
    if (!result_) result_ = consumeToken(builder_, "struct");
    if (!result_) result_ = consumeToken(builder_, "typedef");
    if (!result_) result_ = consumeToken(builder_, "union");
    if (!result_) result_ = consumeToken(builder_, "xsd_namespace");
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // 'xsd_namespace' Literal
  static boolean xsd_namespace(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "xsd_namespace")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, "xsd_namespace");
    pinned_ = result_; // pin = 1
    result_ = result_ && consumeToken(builder_, LITERAL);
    exit_section_(builder_, level_, marker_, null, result_, pinned_, null);
    return result_ || pinned_;
  }

  final static Parser braceRecovery_parser_ = new Parser() {
    public boolean parse(PsiBuilder builder_, int level_) {
      return braceRecovery(builder_, level_ + 1);
    }
  };
  final static Parser curlyBraceRecovery_parser_ = new Parser() {
    public boolean parse(PsiBuilder builder_, int level_) {
      return curlyBraceRecovery(builder_, level_ + 1);
    }
  };
  final static Parser enumFieldRecovery_parser_ = new Parser() {
    public boolean parse(PsiBuilder builder_, int level_) {
      return enumFieldRecovery(builder_, level_ + 1);
    }
  };
  final static Parser fieldRecovery_parser_ = new Parser() {
    public boolean parse(PsiBuilder builder_, int level_) {
      return fieldRecovery(builder_, level_ + 1);
    }
  };
  final static Parser functionRecovery_parser_ = new Parser() {
    public boolean parse(PsiBuilder builder_, int level_) {
      return functionRecovery(builder_, level_ + 1);
    }
  };
  final static Parser functionsRecovery_parser_ = new Parser() {
    public boolean parse(PsiBuilder builder_, int level_) {
      return functionsRecovery(builder_, level_ + 1);
    }
  };
  final static Parser semunFieldRecovery_parser_ = new Parser() {
    public boolean parse(PsiBuilder builder_, int level_) {
      return semunFieldRecovery(builder_, level_ + 1);
    }
  };
  final static Parser topLevelRecover_parser_ = new Parser() {
    public boolean parse(PsiBuilder builder_, int level_) {
      return topLevelRecover(builder_, level_ + 1);
    }
  };
}
