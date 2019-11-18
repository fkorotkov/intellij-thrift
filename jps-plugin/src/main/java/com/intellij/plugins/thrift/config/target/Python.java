package com.intellij.plugins.thrift.config.target;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 24.06.2014 12:10
 *
 * @author xBlackCat
 */ //Python
public class Python extends Generator {
  /**
   * Generate new-style classes.
   */
  private boolean newStyle;
  /**
   * Generate Twisted-friendly RPC services.
   */
  private boolean twisted;
  /**
   * Generate code for use with Tornado.
   */
  private boolean tornado;
  /**
   * Encode/decode strings using utf8 in the generated code.
   */
  private boolean utf8strings;
  /**
   * Generate code using slots for instance members.
   */
  private boolean slots;
  /**
   * Generate dynamic code, less code generated but slower.
   */
  private boolean dynamic;
  /**
   * Derive generated classes from class CLS instead of TBase.
   */
  private String dynbase;
  /**
   * Derive generated exceptions from CLS instead of TExceptionBase.
   */
  private String dynexc;
  /**
   * Add an import line to generated code to find the dynbase class.
   */
  private String dynimport;

  protected Python() {
    super(GeneratorType.Python);
  }

  public void setNewStyle(boolean newStyle) {
    this.newStyle = newStyle;
  }

  public void setTwisted(boolean twisted) {
    this.twisted = twisted;
  }

  public void setTornado(boolean tornado) {
    this.tornado = tornado;
  }

  public void setUtf8strings(boolean utf8strings) {
    this.utf8strings = utf8strings;
  }

  public void setSlots(boolean slots) {
    this.slots = slots;
  }

  public void setDynamic(boolean dynamic) {
    this.dynamic = dynamic;
  }


  public void setDynbase(String dynbase) {
    this.dynbase = dynbase;
  }

  public void setDynexc(String dynexc) {
    this.dynexc = dynexc;
  }


  public void setDynimport(String dynimport) {
    this.dynimport = dynimport;
  }

  public boolean isNewStyle() {
    return newStyle;
  }

  public boolean isTwisted() {
    return twisted;
  }

  public boolean isTornado() {
    return tornado;
  }

  public boolean isUtf8strings() {
    return utf8strings;
  }

  public boolean isSlots() {
    return slots;
  }

  public boolean isDynamic() {
    return dynamic;
  }

  public String getDynbase() {
    return dynbase;
  }

  public String getDynexc() {
    return dynexc;
  }

  public String getDynimport() {
    return dynimport;
  }

  @Override
  protected Collection<String> getOptions() {
    ArrayList<String> line = new ArrayList<String>();
    if (newStyle) {
      line.add("new_style");
    }
    if (twisted) {
      line.add("twisted");
    }
    if (tornado) {
      line.add("tornado");
    }
    if (utf8strings) {
      line.add("utf8strings");
    }
    if (slots) {
      line.add("slots");
    }
    if (dynamic) {
      line.add("dynamic");
    }
    if (dynbase != null) {
      line.add("dynbase=" + dynbase);
    }
    if (dynexc != null) {
      line.add("dynexc=" + dynexc);
    }
    if (dynimport != null) {
      line.add("dynimport='" + dynimport + "'");
    }
    return line;
  }
}
