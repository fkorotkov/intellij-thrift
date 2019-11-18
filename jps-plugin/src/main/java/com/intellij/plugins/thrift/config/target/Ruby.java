package com.intellij.plugins.thrift.config.target;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 24.06.2014 12:10
 *
 * @author xBlackCat
 */ //Ruby
public class Ruby extends Generator {
  /**
   * Add a "require 'rubygems'" line to the top of each generated file.
   */
  private boolean rubygems;
  /**
   * Generate files in idiomatic namespaced directories.
   */
  private boolean namespaced;

  protected Ruby() {
    super(GeneratorType.Ruby);
  }

  public void setRubygems(boolean rubygems) {
    this.rubygems = rubygems;
  }

  public void setNamespaced(boolean namespaced) {
    this.namespaced = namespaced;
  }

  public boolean isRubygems() {
    return rubygems;
  }

  public boolean isNamespaced() {
    return namespaced;
  }

  @Override
  protected Collection<String> getOptions() {
    ArrayList<String> line = new ArrayList<String>();
    if (rubygems) {
      line.add("rubygems");
    }
    if (namespaced) {
      line.add("namespaced");
    }

    return line;
  }
}
