package com.intellij.plugins.thrift.config.facet.options;

import com.intellij.plugins.thrift.ThriftBundle;
import com.intellij.plugins.thrift.config.target.HTML;

import javax.swing.*;
import java.awt.*;

/**
 * 16.07.2014 18:03
 *
 * @author xBlackCat
 */
class HTMLOptionPane extends AOptionPane<HTML> {

  private final JCheckBox myStandalone;

  public HTMLOptionPane() {
    super(new GridLayout(0, 1));

    myStandalone = new JCheckBox(ThriftBundle.message("thrift.gen.option.standalone"));

    add(myStandalone);
  }

  @Override
  public void setValues(HTML html) {
    myStandalone.setSelected(html.isStandalone());
  }

  @Override
  public void readValuesTo(HTML html) {
    html.setStandalone(myStandalone.isSelected());
  }
}
