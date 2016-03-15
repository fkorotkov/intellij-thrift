package com.intellij.plugins.thrift.config.facet.options;

import com.intellij.plugins.thrift.ThriftBundle;
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
  private final JCheckBox myTs;

  public JavaScriptOptionPane() {
    super(new GridLayout(0, 1));
    myJquery = new JCheckBox(ThriftBundle.message("thrift.gen.option.jquery"));
    myNode = new JCheckBox(ThriftBundle.message("thrift.gen.option.node"));
    myTs = new JCheckBox(ThriftBundle.message("thrift.gen.option.ts"));

    add(myJquery);
    add(myNode);
    add(myTs);
  }

  @Override
  public void setValues(Javascript javascript) {
    myJquery.setSelected(javascript.isJquery());
    myNode.setSelected(javascript.isNode());
    myTs.setSelected(javascript.isTs());
  }

  @Override
  public void readValuesTo(Javascript javascript) {
    javascript.setJquery(myJquery.isSelected());
    javascript.setNode(myNode.isSelected());
    javascript.setTs(myTs.isSelected());
  }
}
