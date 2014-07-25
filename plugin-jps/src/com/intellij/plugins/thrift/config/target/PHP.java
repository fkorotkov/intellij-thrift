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
  private static final Arg[] ARGS = new Arg[]{Arg.bool("inlined"), Arg.bool("server"), Arg.bool("oop"), Arg.bool("rest")};
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
    return line;
  }
}
