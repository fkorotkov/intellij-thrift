package com.intellij.plugins.thrift.config.facet.options;

import com.intellij.plugins.thrift.config.target.Javascript;

import javax.swing.*;
import java.awt.*;

/**
 * 16.07.2014 18:08
 *
 * @author xBlackCat
 */
class JavaScriptOptionPane extends AOptionPane<Javascript> {
  private final JCheckBox myJquery;
  private final JCheckBox myNode;

  public JavaScriptOptionPane() {
    super(new GridLayout(0, 1));
    myJquery = new JCheckBox("jquery");
    myNode = new JCheckBox("node");

    add(myJquery);
    add(myNode);
  }

  @Override
  public void setValues(Javascript javascript) {
    myJquery.setSelected(javascript.isJquery());
    myNode.setSelected(javascript.isNode());
  }

  @Override
  public void readValuesTo(Javascript javascript) {
    javascript.setJquery(myJquery.isSelected());
    javascript.setNode(myNode.isSelected());
  }
}
