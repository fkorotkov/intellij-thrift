package com.intellij.plugins.thrift.config.target;

import java.util.Collection;
import java.util.Collections;

/**
 * 24.06.2014 12:09
 *
 * @author xBlackCat
 */ //AS3
public class AS3 extends Generator {
  /**
   * Add [bindable] metadata to all the struct classes.
   */
  private boolean bindable;

  protected AS3() {
    super(GeneratorType.AS3);
  }

  public void setBindable(boolean bindable) {
    this.bindable = bindable;
  }

  public boolean isBindable() {
    return bindable;
  }

  @Override
  protected Collection<String> getOptions() {
    if (bindable) {
      return Collections.singleton("bindable");
    }

    return null;
  }
}
