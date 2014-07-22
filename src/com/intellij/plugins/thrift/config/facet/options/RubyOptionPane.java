package com.intellij.plugins.thrift.config.facet.options;

import com.intellij.plugins.thrift.config.target.Ruby;

import javax.swing.*;
import java.awt.*;

/**
 * 16.07.2014 18:21
 *
 * @author xBlackCat
 */
class RubyOptionPane extends AOptionPane<Ruby> {

  private final JCheckBox myRubygems;

  public RubyOptionPane() {
    super(new GridLayout(0, 1));

    myRubygems = new JCheckBox("rubygems");

    add(myRubygems);
  }

  @Override
  public void setValues(Ruby ruby) {
    myRubygems.setSelected(myRubygems.isSelected());
  }

  @Override
  public void readValuesTo(Ruby ruby) {
    ruby.setRubygems(myRubygems.isSelected());
  }
}
