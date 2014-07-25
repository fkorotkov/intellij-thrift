package com.intellij.plugins.thrift.config.target;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 24.06.2014 12:09
 *
 * @author xBlackCat
 */ //delphi
public class Delphi extends Generator {
  private static final Arg[] ARGS = new Arg[]{Arg.bool("ansistr_binary"), Arg.bool("register_types")};
  /**
   * Use AnsiString for binary datatype (default is TBytes).
   */
  private boolean ansiStrBinary;
  /**
   * Enable TypeRegistry, allows for creation of struct, union and container instances by interface or TypeInfo()
   */
  private boolean registerTypes;

  protected Delphi() {
    super(GeneratorType.Delphi);
  }

  public boolean isAnsiStrBinary() {
    return ansiStrBinary;
  }

  public boolean isRegisterTypes() {
    return registerTypes;
  }

  public void setAnsiStrBinary(boolean ansiStrBinary) {
    this.ansiStrBinary = ansiStrBinary;
  }

  public void setRegisterTypes(boolean registerTypes) {
    this.registerTypes = registerTypes;
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
    return line;
  }
}
