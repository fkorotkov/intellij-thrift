package com.intellij.plugins.thrift;

import com.intellij.lang.Language;

/**
 * Created by fkorotkov.
 */
public class ThriftLanguage extends Language {
  public static ThriftLanguage INSTANCE = new ThriftLanguage();

  protected ThriftLanguage() {
    super("thrift");
  }
}
