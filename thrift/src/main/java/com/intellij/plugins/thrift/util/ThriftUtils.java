package com.intellij.plugins.thrift.util;

import com.intellij.util.containers.ContainerUtil;

import java.util.Set;

/**
 * Created by fkorotkov.
 */
public class ThriftUtils {
  private static final Set<String> keywords = ContainerUtil.immutableSet(
          "const", "cpp_include", "enum", "exception", "include", "namespace",
          "php_namespace", "senum", "service", "struct", "typedef", "union",
          "xsd_namespace", "cpp", "java", "py", "py.twisted", "perl", "rb", "js", "st",
          "cocoa", "csharp", "c_glib", "go", "php", "delphi", "const", "enum", "exception",
          "senum", "service", "struct", "typedef", "union", "required", "optional", "xsd_optional",
          "xsd_nillable", "oneway", "throws", "bool", "byte", "i8", "i16", "i32", "i64", "double",
          "string", "binary", "slist", "list", "map", "set", "cpp_type", "void", "true", "false",
          "xsd", "lua", "netcore", "rs", "as3", "cl", "dart", "erl", "haxe", "hs",
          "javame", "json", "netstd", "nodejs", "nodets", "ocaml", "swift", "ts", "xml"
  );

  public static Set<String> getKeywords() {
    return keywords;
  }
}
