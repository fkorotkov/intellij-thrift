package com.intellij.plugins.thrift.config.facet.options;

import com.intellij.plugins.thrift.ThriftBundle;
import com.intellij.plugins.thrift.config.target.Python;
import org.apache.commons.lang.StringUtils;

import javax.swing.*;
import java.awt.*;

/**
 * 16.07.2014 18:13
 *
 * @author xBlackCat
 */
class PythonOptionPane extends AOptionPane<Python> {

  private final JCheckBox myNewStyle;
  private final JCheckBox myTwisted;
  private final JCheckBox myTornado;
  private final JCheckBox myUtf8strings;
  private final JCheckBox mySlots;
  private final JCheckBox myDynamic;
  private final JTextField myDynbase;
  private final JTextField myDynexc;
  private final JTextField myDynimport;

  public PythonOptionPane() {
    super(new GridLayout(0, 1));

    myNewStyle = new JCheckBox(ThriftBundle.message("thrift.gen.option.new_style"));
    myTwisted = new JCheckBox(ThriftBundle.message("thrift.gen.option.twisted"));
    myTornado = new JCheckBox(ThriftBundle.message("thrift.gen.option.tornado"));
    myUtf8strings = new JCheckBox(ThriftBundle.message("thrift.gen.option.utf8strings"));
    mySlots = new JCheckBox(ThriftBundle.message("thrift.gen.option.slots"));
    myDynamic = new JCheckBox(ThriftBundle.message("thrift.gen.option.dynamic"));

    add(myNewStyle);
    add(myTwisted);
    add(myTornado);
    add(myUtf8strings);
    add(mySlots);
    add(myDynamic);

    final JLabel dynbase = new JLabel(ThriftBundle.message("thrift.gen.option.dynbase"));
    final JLabel dynexc = new JLabel(ThriftBundle.message("thrift.gen.option.dynexc"));
    final JLabel dynimport = new JLabel(ThriftBundle.message("thrift.gen.option.dynimport"));
    myDynbase = new JTextField("dynbase");
    myDynexc = new JTextField("dynexc");
    myDynimport = new JTextField("dynimport");

    add(dynbase);
    add(myDynbase);
    add(dynexc);
    add(myDynexc);
    add(dynimport);
    add(myDynimport);
  }

  @Override
  public void setValues(Python python) {
    myNewStyle.setSelected(python.isNewStyle());
    myTwisted.setSelected(python.isTwisted());
    myTornado.setSelected(python.isTornado());
    myUtf8strings.setSelected(python.isUtf8strings());
    mySlots.setSelected(python.isSlots());
    myDynamic.setSelected(python.isDynamic());

    myDynbase.setText(python.getDynbase());
    myDynexc.setText(python.getDynexc());
    myDynimport.setText(python.getDynimport());
  }

  @Override
  public void readValuesTo(Python python) {
    python.setNewStyle(myNewStyle.isSelected());
    python.setTwisted(myTwisted.isSelected());
    python.setTornado(myTornado.isSelected());
    python.setUtf8strings(myUtf8strings.isSelected());
    python.setSlots(mySlots.isSelected());
    python.setDynamic(myDynamic.isSelected());

    python.setDynbase(StringUtils.trimToNull(myDynbase.getText()));
    python.setDynexc(StringUtils.trimToNull(myDynexc.getText()));
    python.setDynimport(StringUtils.trimToNull(myDynimport.getText()));
  }
}
