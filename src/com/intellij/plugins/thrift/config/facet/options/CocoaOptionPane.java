package com.intellij.plugins.thrift.config.facet.options;

import com.intellij.plugins.thrift.ThriftBundle;
import com.intellij.plugins.thrift.config.target.Cocoa;

import javax.swing.*;
import java.awt.*;

/**
 * 16.07.2014 17:35
 *
 * @author xBlackCat
 */
class CocoaOptionPane extends AOptionPane<Cocoa> {
  private final JCheckBox myLogUnexpected;
  private final JCheckBox myValidateRequired;

  public CocoaOptionPane() {
    super(new GridLayout(0, 1));

    myLogUnexpected = new JCheckBox(ThriftBundle.message("thrift.gen.option.log_unexpected"));
    myValidateRequired = new JCheckBox(ThriftBundle.message("thrift.gen.option.validate_required"));

    add(myLogUnexpected);
    add(myValidateRequired);
  }

  @Override
  public void setValues(Cocoa g) {
    myLogUnexpected.setSelected(g.isLogUnexpected());
    myValidateRequired.setSelected(g.isValidateRequired());
  }

  @Override
  public void readValuesTo(Cocoa g) {
    g.setLogUnexpected(myLogUnexpected.isSelected());
    g.setValidateRequired(myValidateRequired.isSelected());
  }
}
