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
    int level_ = 0;
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, null);
    if (root_ == BASE_TYPE) {
      result_ = BaseType(builder_, level_ + 1);
    }
    else if (root_ == CONST) {
      result_ = Const(builder_, level_ + 1);
    }
    else if (root_ == CONST_LIST) {
      result_ = ConstList(builder_, level_ + 1);
    }
    else if (root_ == CONST_MAP) {
      result_ = ConstMap(builder_, level_ + 1);
    }
    else if (root_ == CONST_VALUE) {
      result_ = ConstValue(builder_, level_ + 1);
    }
    else if (root_ == CPP_INCLUDE) {
      result_ = CppInclude(builder_, level_ + 1);
    }
    else if (root_ == CPP_TYPE) {
      result_ = CppType(builder_, level_ + 1);
    }
    else if (root_ == DOUBLE_CONSTANT) {
      result_ = DoubleConstant(builder_, level_ + 1);
    }
    else if (root_ == ENUM) {
      result_ = Enum(builder_, level_ + 1);
    }
    else if (root_ == EXCEPTION) {
      result_ = Exception(builder_, level_ + 1);
    }
    else if (root_ == FIELD) {
      result_ = Field(builder_, level_ + 1);
    }
    else if (root_ == FIELD_ID) {
      result_ = FieldID(builder_, level_ + 1);
    }
    else if (root_ == FIELD_REQ) {
      result_ = FieldReq(builder_, level_ + 1);
    }
    else if (root_ == FIELD_TYPE) {
      result_ = FieldType(builder_, level_ + 1);
    }
    else if (root_ == FUNCTION) {
      result_ = Function(builder_, level_ + 1);
    }
    else if (root_ == FUNCTION_TYPE) {
      result_ = FunctionType(builder_, level_ + 1);
    }
    else if (root_ == INCLUDE) {
      result_ = Include(builder_, level_ + 1);
    }
    else if (root_ == INT_CONSTANT) {
      result_ = IntConstant(builder_, level_ + 1);
    }
    else if (root_ == LIST_SEPARATOR) {
      result_ = ListSeparator(builder_, level_ + 1);
    }
    else if (root_ == LIST_TYPE) {
      result_ = ListType(builder_, level_ + 1);
    }
    else if (root_ == MAP_TYPE) {
      result_ = MapType(builder_, level_ + 1);
    }
    else if (root_ == NAMESPACE) {
      result_ = Namespace(builder_, level_ + 1);
    }
    else if (root_ == NAMESPACE_SCOPE) {
      result_ = NamespaceScope(builder_, level_ + 1);
    }
    else if (root_ == SENUM) {
      result_ = Senum(builder_, level_ + 1);
    }
    else if (root_ == SERVICE) {
      result_ = Service(builder_, level_ + 1);
    }
    else if (root_ == SET_TYPE) {
      result_ = SetType(builder_, level_ + 1);
    }
    else if (root_ == STRUCT) {
      result_ = Struct(builder_, level_ + 1);
    }
    else if (root_ == THROWS) {
      result_ = Throws(builder_, level_ + 1);
    }
    else if (root_ == TYPEDEF) {
      result_ = Typedef(builder_, level_ + 1);
    }
    else if (root_ == UNION) {
      result_ = Union(builder_, level_ + 1);
    }
    else if (root_ == XSD_ATTRS) {
      result_ = XsdAttrs(builder_, level_ + 1);
    }
    else if (root_ == XSD_FIELD_OPTIONS) {
      result_ = XsdFieldOptions(builder_, level_ + 1);
    }
    else {
      Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
      result_ = parse_root_(root_, builder_, level_);
      exit_section_(builder_, level_, marker_, root_, result_, true, TOKEN_ADVANCER);
    }
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
  // 'const' FieldType Identifier '=' ConstValue ListSeparator?
  public static boolean Const(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Const")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<const>");
    result_ = consumeToken(builder_, "const");
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, FieldType(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, IDENTIFIER)) && result_;
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
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!ConstList_1_0(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "ConstList_1");
        break;
      }
      offset_ = next_offset_;
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
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!ConstMap_1_0(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "ConstMap_1");
        break;
      }
      offset_ = next_offset_;
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
  // 'cpp_include' Literal
  public static boolean CppInclude(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "CppInclude")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<cpp include>");
    result_ = consumeToken(builder_, "cpp_include");
    pinned_ = result_; // pin = 1
    result_ = result_ && consumeToken(builder_, LITERAL);
    exit_section_(builder_, level_, marker_, CPP_INCLUDE, result_, pinned_, null);
    return result_ || pinned_;
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
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!topLevelElement(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "Document");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  /* ********************************************************** */
  // ('+' | '-')? Number ('.' Number)? ( ('E' | 'e') IntConstant )?
  public static boolean DoubleConstant(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "DoubleConstant")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<double constant>");
    result_ = DoubleConstant_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, NUMBER);
    result_ = result_ && DoubleConstant_2(builder_, level_ + 1);
    result_ = result_ && DoubleConstant_3(builder_, level_ + 1);
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

  // ('.' Number)?
  private static boolean DoubleConstant_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "DoubleConstant_2")) return false;
    DoubleConstant_2_0(builder_, level_ + 1);
    return true;
  }

  // '.' Number
  private static boolean DoubleConstant_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "DoubleConstant_2_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ".");
    result_ = result_ && consumeToken(builder_, NUMBER);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ( ('E' | 'e') IntConstant )?
  private static boolean DoubleConstant_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "DoubleConstant_3")) return false;
    DoubleConstant_3_0(builder_, level_ + 1);
    return true;
  }

  // ('E' | 'e') IntConstant
  private static boolean DoubleConstant_3_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "DoubleConstant_3_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = DoubleConstant_3_0_0(builder_, level_ + 1);
    result_ = result_ && IntConstant(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // 'E' | 'e'
  private static boolean DoubleConstant_3_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "DoubleConstant_3_0_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, "E");
    if (!result_) result_ = consumeToken(builder_, "e");
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // 'enum' Identifier '{' (Identifier ('=' IntConstant)? ListSeparator?)* '}'
  public static boolean Enum(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Enum")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<enum>");
    result_ = consumeToken(builder_, "enum");
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, consumeToken(builder_, IDENTIFIER));
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, LEFTCURLYBRACE)) && result_;
    result_ = pinned_ && report_error_(builder_, Enum_3(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, RIGHTCURLYBRACE) && result_;
    exit_section_(builder_, level_, marker_, ENUM, result_, pinned_, null);
    return result_ || pinned_;
  }

  // (Identifier ('=' IntConstant)? ListSeparator?)*
  private static boolean Enum_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Enum_3")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!Enum_3_0(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "Enum_3");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  // Identifier ('=' IntConstant)? ListSeparator?
  private static boolean Enum_3_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Enum_3_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IDENTIFIER);
    result_ = result_ && Enum_3_0_1(builder_, level_ + 1);
    result_ = result_ && Enum_3_0_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ('=' IntConstant)?
  private static boolean Enum_3_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Enum_3_0_1")) return false;
    Enum_3_0_1_0(builder_, level_ + 1);
    return true;
  }

  // '=' IntConstant
  private static boolean Enum_3_0_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Enum_3_0_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, EQUALS);
    result_ = result_ && IntConstant(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ListSeparator?
  private static boolean Enum_3_0_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Enum_3_0_2")) return false;
    ListSeparator(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // 'exception' Identifier '{' fieldsWithCurlyRecovery '}'
  public static boolean Exception(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Exception")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<exception>");
    result_ = consumeToken(builder_, "exception");
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, consumeToken(builder_, IDENTIFIER));
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, LEFTCURLYBRACE)) && result_;
    result_ = pinned_ && report_error_(builder_, fieldsWithCurlyRecovery(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, RIGHTCURLYBRACE) && result_;
    exit_section_(builder_, level_, marker_, EXCEPTION, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // FieldID? FieldReq? FieldType Identifier ('=' ConstValue)? XsdFieldOptions ListSeparator?
  public static boolean Field(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Field")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<field>");
    result_ = Field_0(builder_, level_ + 1);
    result_ = result_ && Field_1(builder_, level_ + 1);
    result_ = result_ && FieldType(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
    result_ = result_ && Field_4(builder_, level_ + 1);
    result_ = result_ && XsdFieldOptions(builder_, level_ + 1);
    result_ = result_ && Field_6(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, FIELD, result_, false, fieldRecovery_parser_);
    return result_;
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

  // ListSeparator?
  private static boolean Field_6(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Field_6")) return false;
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
  // BaseType | ContainerType | Identifier
  public static boolean FieldType(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "FieldType")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<field type>");
    result_ = BaseType(builder_, level_ + 1);
    if (!result_) result_ = ContainerType(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, level_, marker_, FIELD_TYPE, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // 'oneway'? FunctionType Identifier '(' fieldsWithBraceRecovery ')' Throws?
  public static boolean Function(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Function")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<function>");
    result_ = Function_0(builder_, level_ + 1);
    result_ = result_ && FunctionType(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
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
  // FieldType | 'void'
  public static boolean FunctionType(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "FunctionType")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<function type>");
    result_ = FieldType(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, "void");
    exit_section_(builder_, level_, marker_, FUNCTION_TYPE, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // 'include' Literal
  public static boolean Include(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Include")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<include>");
    result_ = consumeToken(builder_, "include");
    pinned_ = result_; // pin = 1
    result_ = result_ && consumeToken(builder_, LITERAL);
    exit_section_(builder_, level_, marker_, INCLUDE, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // ('+' | '-')? Number
  public static boolean IntConstant(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "IntConstant")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<int constant>");
    result_ = IntConstant_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, NUMBER);
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
    if (!nextTokenIs(builder_, COMMA) && !nextTokenIs(builder_, SEMICOLON)
        && replaceVariants(builder_, 2, "<list separator>")) return false;
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
  // 'senum' Identifier '{' (Literal ListSeparator?)* '}'
  public static boolean Senum(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Senum")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<senum>");
    result_ = consumeToken(builder_, "senum");
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, consumeToken(builder_, IDENTIFIER));
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, LEFTCURLYBRACE)) && result_;
    result_ = pinned_ && report_error_(builder_, Senum_3(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, RIGHTCURLYBRACE) && result_;
    exit_section_(builder_, level_, marker_, SENUM, result_, pinned_, null);
    return result_ || pinned_;
  }

  // (Literal ListSeparator?)*
  private static boolean Senum_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Senum_3")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!Senum_3_0(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "Senum_3");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  // Literal ListSeparator?
  private static boolean Senum_3_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Senum_3_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LITERAL);
    result_ = result_ && Senum_3_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ListSeparator?
  private static boolean Senum_3_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Senum_3_0_1")) return false;
    ListSeparator(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // 'service' Identifier ( 'extends' Identifier )? '{' functions '}'
  public static boolean Service(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Service")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<service>");
    result_ = consumeToken(builder_, "service");
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, consumeToken(builder_, IDENTIFIER));
    result_ = pinned_ && report_error_(builder_, Service_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, LEFTCURLYBRACE)) && result_;
    result_ = pinned_ && report_error_(builder_, functions(builder_, level_ + 1)) && result_;
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
  // 'struct' Identifier 'xsd_all'? '{' fieldsWithCurlyRecovery '}'
  public static boolean Struct(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Struct")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<struct>");
    result_ = consumeToken(builder_, "struct");
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, consumeToken(builder_, IDENTIFIER));
    result_ = pinned_ && report_error_(builder_, Struct_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, LEFTCURLYBRACE)) && result_;
    result_ = pinned_ && report_error_(builder_, fieldsWithCurlyRecovery(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, RIGHTCURLYBRACE) && result_;
    exit_section_(builder_, level_, marker_, STRUCT, result_, pinned_, null);
    return result_ || pinned_;
  }

  // 'xsd_all'?
  private static boolean Struct_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Struct_2")) return false;
    consumeToken(builder_, "xsd_all");
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
  // 'typedef' DefinitionType Identifier
  public static boolean Typedef(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Typedef")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<typedef>");
    result_ = consumeToken(builder_, "typedef");
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, DefinitionType(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, IDENTIFIER) && result_;
    exit_section_(builder_, level_, marker_, TYPEDEF, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // 'union' Identifier 'xsd_all'? '{' fieldsWithCurlyRecovery '}'
  public static boolean Union(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Union")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<union>");
    result_ = consumeToken(builder_, "union");
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, consumeToken(builder_, IDENTIFIER));
    result_ = pinned_ && report_error_(builder_, Union_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, LEFTCURLYBRACE)) && result_;
    result_ = pinned_ && report_error_(builder_, fieldsWithCurlyRecovery(builder_, level_ + 1)) && result_;
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
  // 'xsd_attrs' '{' fieldsWithCurlyRecovery '}'
  public static boolean XsdAttrs(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "XsdAttrs")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<xsd attrs>");
    result_ = consumeToken(builder_, "xsd_attrs");
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, consumeToken(builder_, LEFTCURLYBRACE));
    result_ = pinned_ && report_error_(builder_, fieldsWithCurlyRecovery(builder_, level_ + 1)) && result_;
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
  // !(')' | '+' | '-' | 'binary' | 'bool' | 'byte' | 'double' | 'i16' | 'i32' | 'i64' | 'list' |
  //                             'map' | 'optional' | 'required' | 'set' | 'slist' | 'string' | '}' | Identifier | Number)
  static boolean fieldRecovery(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "fieldRecovery")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NOT_, null);
    result_ = !fieldRecovery_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, null, result_, false, null);
    return result_;
  }

  // ')' | '+' | '-' | 'binary' | 'bool' | 'byte' | 'double' | 'i16' | 'i32' | 'i64' | 'list' |
  //                             'map' | 'optional' | 'required' | 'set' | 'slist' | 'string' | '}' | Identifier | Number
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
    if (!result_) result_ = consumeToken(builder_, IDENTIFIER);
    if (!result_) result_ = consumeToken(builder_, NUMBER);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // Field*
  static boolean fieldsWithBraceRecovery(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "fieldsWithBraceRecovery")) return false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!Field(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "fieldsWithBraceRecovery");
        break;
      }
      offset_ = next_offset_;
    }
    exit_section_(builder_, level_, marker_, null, true, false, braceRecovery_parser_);
    return true;
  }

  /* ********************************************************** */
  // Field*
  static boolean fieldsWithCurlyRecovery(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "fieldsWithCurlyRecovery")) return false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!Field(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "fieldsWithCurlyRecovery");
        break;
      }
      offset_ = next_offset_;
    }
    exit_section_(builder_, level_, marker_, null, true, false, curlyBraceRecovery_parser_);
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
  // (Function ListSeparator?)*
  static boolean functions(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "functions")) return false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!functions_0(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "functions");
        break;
      }
      offset_ = next_offset_;
    }
    exit_section_(builder_, level_, marker_, null, true, false, functionsRecovery_parser_);
    return true;
  }

  // Function ListSeparator?
  private static boolean functions_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "functions_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = Function(builder_, level_ + 1);
    result_ = result_ && functions_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ListSeparator?
  private static boolean functions_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "functions_0_1")) return false;
    ListSeparator(builder_, level_ + 1);
    return true;
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
  // Include | CppInclude | Namespace |
  //                              Const | Typedef | Enum | Senum | Struct | Union | Exception | Service
  static boolean topLevelElement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "topLevelElement")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = Include(builder_, level_ + 1);
    if (!result_) result_ = CppInclude(builder_, level_ + 1);
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
  final static Parser topLevelRecover_parser_ = new Parser() {
    public boolean parse(PsiBuilder builder_, int level_) {
      return topLevelRecover(builder_, level_ + 1);
    }
  };
}
