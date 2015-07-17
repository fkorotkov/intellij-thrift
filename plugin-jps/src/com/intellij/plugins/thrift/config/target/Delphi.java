package com.intellij.plugins.thrift.config.target;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 24.06.2014 12:09
 *
 * @author xBlackCat
 */ //delphi
public class Delphi extends Generator {
  /**
   * Use AnsiString for binary datatype (default is TBytes).
   */
  private boolean ansiStrBinary;
  /**
   * Enable TypeRegistry, allows for creation of struct, union and container instances by interface or TypeInfo()
   */
  private boolean registerTypes;
  /**
   * Name TConstants classes after IDL to reduce ambiguities
   */
  private boolean constprefix;
  /**
   * Enable and use processing events in the generated code.
   */
  private boolean events;
  /**
   * Enable XMLDoc comments for Help Insight etc.
   */
  private boolean xmldoc;

  protected Delphi() {
    super(GeneratorType.Delphi);
  }

  public boolean isAnsiStrBinary() {
    return ansiStrBinary;
  }

  public boolean isRegisterTypes() {
    return registerTypes;
  }

  public boolean isConstprefix() {
    return constprefix;
  }

  public boolean isEvents() {
    return events;
  }

  public boolean isXmldoc() {
    return xmldoc;
  }

  public void setAnsiStrBinary(boolean ansiStrBinary) {
    this.ansiStrBinary = ansiStrBinary;
  }

  public void setRegisterTypes(boolean registerTypes) {
    this.registerTypes = registerTypes;
  }

  public void setConstprefix(boolean constprefix) {
    this.constprefix = constprefix;
  }

  public void setEvents(boolean events) {
    this.events = events;
  }

  public void setXmldoc(boolean xmldoc) {
    this.xmldoc = xmldoc;
  }

  @Override
  protected Collection<String> getOptions() {
    ArrayList<String> line = new ArrayList<String>();
    if (ansiStrBinary) {
      line.add("ansistr_binary");
    }
    if (registerTypes) {
      line.add("register_types");
    }
    if (constprefix) {
      line.add("constprefix");
    }
    if (events) {
      line.add("events");
    }
    if (xmldoc) {
      line.add("xmldoc");
    }
    return line;
  }
}
