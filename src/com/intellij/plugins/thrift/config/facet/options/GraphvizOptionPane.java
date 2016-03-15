package com.intellij.plugins.thrift.config.facet.options;

import com.intellij.plugins.thrift.ThriftBundle;
import com.intellij.plugins.thrift.config.target.Graphviz;

import javax.swing.*;
import java.awt.*;

/**
 * 16.07.2014 18:02
 *
 * @author xBlackCat
 */
class GraphvizOptionPane extends AOptionPane<Graphviz> {

  private final JCheckBox myExceptions;

  public GraphvizOptionPane() {
    super(new GridLayout(0, 1));

    myExceptions = new JCheckBox(ThriftBundle.message("thrift.gen.option.exceptions"));

    add(myExceptions);
  }

  @Override
  public void setValues(Graphviz graphviz) {
    myExceptions.setSelected(graphviz.isExceptions());
  }

  @Override
  public void readValuesTo(Graphviz graphviz) {
    graphviz.setExceptions(myExceptions.isSelected());
  }
}
