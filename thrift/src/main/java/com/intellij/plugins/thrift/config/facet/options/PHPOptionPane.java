package com.intellij.plugins.thrift.config.facet.options;

import com.intellij.plugins.thrift.ThriftBundle;
import com.intellij.plugins.thrift.config.target.PHP;
import org.apache.commons.lang.StringUtils;

import javax.swing.*;
import java.awt.*;

/**
 * 16.07.2014 18:10
 *
 * @author xBlackCat
 */
class PHPOptionPane extends AOptionPane<PHP> {
  private final JCheckBox myInlined;
  private final JCheckBox myServer;
  private final JCheckBox myOop;
  private final JCheckBox myRest;
  private final JTextField myNsglobal;
  private final JCheckBox myValidate;
  private final JCheckBox myJson;

  public PHPOptionPane() {
    super(new GridLayout(0, 1));

    myInlined = new JCheckBox(ThriftBundle.message("thrift.gen.option.inlined"));
    myServer = new JCheckBox(ThriftBundle.message("thrift.gen.option.server"));
    myOop = new JCheckBox(ThriftBundle.message("thrift.gen.option.oop"));
    myRest = new JCheckBox(ThriftBundle.message("thrift.gen.option.rest"));
    final JLabel myNsglobalLabel = new JLabel(ThriftBundle.message("thrift.gen.option.nsglobal"));
    myNsglobal = new JTextField();
    myValidate = new JCheckBox(ThriftBundle.message("thrift.gen.option.validate"));
    myJson = new JCheckBox(ThriftBundle.message("thrift.gen.option.json"));

    add(myInlined);
    add(myServer);
    add(myOop);
    add(myRest);
    add(myNsglobalLabel);
    add(myNsglobal);
    add(myValidate);
    add(myJson);
  }

  @Override
  public void setValues(PHP php) {
    myInlined.setSelected(php.isInlined());
    myServer.setSelected(php.isServer());
    myOop.setSelected(php.isOop());
    myRest.setSelected(php.isRest());
    myNsglobal.setText(php.getNsglobal());
    myValidate.setSelected(php.isValidate());
    myJson.setSelected(php.isJson());
  }

  @Override
  public void readValuesTo(PHP php) {
    php.setInlined(myInlined.isSelected());
    php.setServer(myServer.isSelected());
    php.setOop(myOop.isSelected());
    php.setRest(myRest.isSelected());
    php.setNsglobal(StringUtils.trimToNull(myNsglobal.getText()));
    php.setValidate(myValidate.isSelected());
    php.setJson(myJson.isSelected());
  }
}
