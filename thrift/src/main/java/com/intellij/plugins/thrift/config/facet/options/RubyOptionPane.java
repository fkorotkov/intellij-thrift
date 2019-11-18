package com.intellij.plugins.thrift.config.facet.options;

import com.intellij.plugins.thrift.ThriftBundle;
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
  private final JCheckBox myNamespaced;

  public RubyOptionPane() {
    super(new GridLayout(0, 1));

    myRubygems = new JCheckBox(ThriftBundle.message("thrift.gen.option.rubygems"));
    myNamespaced = new JCheckBox(ThriftBundle.message("thrift.gen.option.namespaced"));

    add(myRubygems);
    add(myNamespaced);
  }

  @Override
  public void setValues(Ruby ruby) {
    myRubygems.setSelected(ruby.isRubygems());
    myNamespaced.setSelected(ruby.isNamespaced());
  }

  @Override
  public void readValuesTo(Ruby ruby) {
    ruby.setRubygems(myRubygems.isSelected());
    ruby.setNamespaced(myNamespaced.isSelected());
  }
}
