package com.intellij.plugins.thrift.config.facet.options;

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
    super(new BorderLayout());

    final JPanel bools = new JPanel(new GridLayout(0, 1));
    myNewStyle = new JCheckBox("new_style");
    myTwisted = new JCheckBox("twisted");
    myTornado = new JCheckBox("tornado");
    myUtf8strings = new JCheckBox("utf8strings");
    mySlots = new JCheckBox("slots");
    myDynamic = new JCheckBox("dynamic");

    bools.add(myNewStyle);
    bools.add(myTwisted);
    bools.add(myTornado);
    bools.add(myUtf8strings);
    bools.add(mySlots);
    bools.add(myDynamic);

    add(bools, BorderLayout.NORTH);

    final JLabel dynbase = new JLabel("dynbase");
    final JLabel dynexc = new JLabel("dynexc");
    final JLabel dynimport = new JLabel("dynimport");

    final JPanel labels = new JPanel(new GridLayout(0, 1));
    labels.add(dynbase);
    labels.add(dynexc);
    labels.add(dynimport);

    add(labels, BorderLayout.WEST);

    myDynbase = new JTextField("dynbase");
    myDynexc = new JTextField("dynexc");
    myDynimport = new JTextField("dynimport");

    final JPanel fields = new JPanel(new GridLayout(0, 1));
    fields.add(myDynbase);
    fields.add(myDynexc);
    fields.add(myDynimport);

    add(fields, BorderLayout.CENTER);
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
