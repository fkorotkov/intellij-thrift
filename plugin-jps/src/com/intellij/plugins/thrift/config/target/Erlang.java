package com.intellij.plugins.thrift.config.target;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 17.07.2015 16:32
 *
 * @author xBlackCat
 */
public class Erlang extends Generator {
  protected Erlang() {
    super(GeneratorType.Erlang);
  }

  /**
   * Output files retain naming conventions of Thrift 0.9.1 and earlier.
   */
  private boolean legacynames;

  public void setLegacynames(boolean legacynames) {
    this.legacynames = legacynames;
  }

  public boolean isLegacynames() {
    return legacynames;
  }

  @Override
  protected Collection<String> getOptions() {
    ArrayList<String> line = new ArrayList<String>();
    if (legacynames) {
      line.add("legacynames");
    }
    return line;
  }
}
