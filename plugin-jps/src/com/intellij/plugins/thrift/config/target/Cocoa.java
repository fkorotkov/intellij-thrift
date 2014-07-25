package com.intellij.plugins.thrift.config.target;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 24.06.2014 12:09
 *
 * @author xBlackCat
 */ //Cocoa
public class Cocoa extends Generator {
  /**
   * Log every time an unexpected field ID or type is encountered.
   */
  private boolean logUnexpected;
  /**
   * Throws exception if any required field is not set.
   */
  private boolean validateRequired;

  protected Cocoa() {
    super(GeneratorType.Cocoa);
  }

  public void setLogUnexpected(boolean logUnexpected) {
    this.logUnexpected = logUnexpected;
  }

  public void setValidateRequired(boolean validateRequired) {
    this.validateRequired = validateRequired;
  }

  public boolean isLogUnexpected() {
    return logUnexpected;
  }

  public boolean isValidateRequired() {
    return validateRequired;
  }

  @Override
  protected Collection<String> getOptions() {
    ArrayList<String> list = new ArrayList<String>();

    if (logUnexpected) {
      list.add("log_unexpected");
    }
    if (validateRequired) {
      list.add("validate_required");
    }

    return list;
  }
}
