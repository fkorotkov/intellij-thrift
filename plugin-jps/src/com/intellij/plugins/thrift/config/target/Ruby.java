package com.intellij.plugins.thrift.config.target;

import java.util.Collection;
import java.util.Collections;

/**
 * 24.06.2014 12:10
 *
 * @author xBlackCat
 */ //Ruby
public class Ruby extends Generator {
  private static final Arg[] ARGS = new Arg[]{Arg.bool("rubygems")};
  /**
   * Add a "require 'rubygems'" line to the top of each generated file.
   */
  private boolean rubygems;

  protected Ruby() {
    super(GeneratorType.Ruby);
  }

  public void setRubygems(boolean rubygems) {
    this.rubygems = rubygems;
  }

  @Override
  protected Collection<String> getOptions() {
    if (rubygems) {
      return Collections.singleton("rubygems");
    }

    return null;
  }
}
