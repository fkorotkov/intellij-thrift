package com.intellij.plugins.thrift.config.facet.options;

import com.intellij.plugins.thrift.ThriftBundle;
import com.intellij.plugins.thrift.config.target.Delphi;

import javax.swing.*;
import java.awt.*;

/**
 * 16.07.2014 17:52
 *
 * @author xBlackCat
 */
class DelphiOptionPane extends AOptionPane<Delphi> {

  private final JCheckBox myAnsistrBinary;
  private final JCheckBox myRegisterTypes;
  private final JCheckBox myConstprefix;
  private final JCheckBox myEvents;
  private final JCheckBox myXmldoc;

  public DelphiOptionPane() {
    super(new GridLayout(0, 1));

    myAnsistrBinary = new JCheckBox(ThriftBundle.message("thrift.gen.option.ansistr_binary"));
    myRegisterTypes = new JCheckBox(ThriftBundle.message("thrift.gen.option.register_types"));
    myConstprefix = new JCheckBox(ThriftBundle.message("thrift.gen.option.constprefix"));
    myEvents = new JCheckBox(ThriftBundle.message("thrift.gen.option.events"));
    myXmldoc = new JCheckBox(ThriftBundle.message("thrift.gen.option.xmldoc"));

    add(myAnsistrBinary);
    add(myRegisterTypes);
    add(myConstprefix);
    add(myEvents);
    add(myXmldoc);
  }

  @Override
  public void setValues(Delphi delphi) {
    myAnsistrBinary.setSelected(delphi.isAnsiStrBinary());
    myRegisterTypes.setSelected(delphi.isRegisterTypes());
    myConstprefix.setSelected(delphi.isConstprefix());
    myEvents.setSelected(delphi.isEvents());
    myXmldoc.setSelected(delphi.isXmldoc());
  }

  @Override
  public void readValuesTo(Delphi delphi) {
    delphi.setAnsiStrBinary(myAnsistrBinary.isSelected());
    delphi.setRegisterTypes(myRegisterTypes.isSelected());
    delphi.setConstprefix(myConstprefix.isSelected());
    delphi.setEvents(myEvents.isSelected());
    delphi.setXmldoc(myXmldoc.isSelected());
  }
}
