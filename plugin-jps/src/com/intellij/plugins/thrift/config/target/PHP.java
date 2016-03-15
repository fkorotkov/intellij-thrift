package com.intellij.plugins.thrift.config.target;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 24.06.2014 12:10
 *
 * @author xBlackCat
 */ //PHP
public class PHP extends Generator {
  /**
   * Generate PHP inlined files
   */
  private boolean inlined;
  /**
   * Generate PHP server stubs
   */
  private boolean server;
  /**
   * Generate PHP with object oriented subclasses
   */
  private boolean oop;
  /**
   * Generate PHP REST processors
   */
  private boolean rest;
  /**
   * Set global namespace
   */
  private String nsglobal;
  /**
   * Generate PHP validator methods
   */
  private boolean validate;
  /**
   * Generate JsonSerializable classes (requires PHP >= 5.4)
   */
  private boolean json;

  protected PHP() {
    super(GeneratorType.PHP);
  }

  public void setInlined(boolean inlined) {
    this.inlined = inlined;
  }

  public void setServer(boolean server) {
    this.server = server;
  }

  public void setOop(boolean oop) {
    this.oop = oop;
  }

  public void setRest(boolean rest) {
    this.rest = rest;
  }

  public void setNsglobal(String nsglobal) {
    this.nsglobal = nsglobal;
  }

  public void setValidate(boolean validate) {
    this.validate = validate;
  }

  public void setJson(boolean json) {
    this.json = json;
  }

  public boolean isInlined() {
    return inlined;
  }

  public boolean isServer() {
    return server;
  }

  public boolean isOop() {
    return oop;
  }

  public boolean isRest() {
    return rest;
  }

  public String getNsglobal() {
    return nsglobal;
  }

  public boolean isValidate() {
    return validate;
  }

  public boolean isJson() {
    return json;
  }

  @Override
  protected Collection<String> getOptions() {
    List<String> line = new ArrayList<String>();
    if (inlined) {
      line.add("inlined");
    }
    if (server) {
      line.add("server");
    }
    if (oop) {
      line.add("oop");
    }
    if (rest) {
      line.add("rest");
    }
    if (nsglobal != null) {
      line.add("nsglobal=" + nsglobal);
    }
    if (validate) {
      line.add("validate");
    }
    if (json) {
      line.add("json");
    }
    return line;
  }
}
