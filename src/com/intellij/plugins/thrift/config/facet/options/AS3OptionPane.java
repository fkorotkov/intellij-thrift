package com.intellij.plugins.thrift.config.facet.options;

import com.intellij.plugins.thrift.ThriftBundle;
import com.intellij.plugins.thrift.config.target.AS3;

import javax.swing.*;
import java.awt.*;

/**
 * 16.07.2014 17:35
 *
 * @author xBlackCat
 */
class AS3OptionPane extends AOptionPane<AS3> {
  private final JCheckBox myBindable;

  public AS3OptionPane() {
    super(new GridLayout(0, 1));

    myBindable = new JCheckBox(ThriftBundle.message("thrift.gen.option.bindable"));

    add(myBindable);
  }

  @Override
  public void setValues(AS3 g) {
    myBindable.setSelected(g.isBindable());
  }

  @Override
  public void readValuesTo(AS3 g) {
    g.setBindable(myBindable.isSelected());
  }
}
