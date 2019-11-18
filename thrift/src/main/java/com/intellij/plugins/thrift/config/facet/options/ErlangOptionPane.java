package com.intellij.plugins.thrift.config.facet.options;

import com.intellij.plugins.thrift.ThriftBundle;
import com.intellij.plugins.thrift.config.target.Erlang;

import javax.swing.*;
import java.awt.*;

/**
 * 16.07.2014 17:35
 *
 * @author xBlackCat
 */
class ErlangOptionPane extends AOptionPane<Erlang> {
  private final JCheckBox myLegacynames;

  public ErlangOptionPane() {
    super(new GridLayout(0, 1));

    myLegacynames = new JCheckBox(ThriftBundle.message("thrift.gen.option.bindable"));

    add(myLegacynames);
  }

  @Override
  public void setValues(Erlang e) {
    myLegacynames.setSelected(e.isLegacynames());
  }

  @Override
  public void readValuesTo(Erlang e) {
    e.setLegacynames(myLegacynames.isSelected());
  }
}
