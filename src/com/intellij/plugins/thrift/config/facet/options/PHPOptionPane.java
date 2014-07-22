package com.intellij.plugins.thrift.config.facet.options;

import com.intellij.plugins.thrift.ThriftBundle;
import com.intellij.plugins.thrift.config.target.PHP;

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

  public PHPOptionPane() {
    super(new GridLayout(0, 1));

    myInlined = new JCheckBox(ThriftBundle.message("thrift.gen.option.inlined"));
    myServer = new JCheckBox(ThriftBundle.message("thrift.gen.option.server"));
    myOop = new JCheckBox(ThriftBundle.message("thrift.gen.option.oop"));
    myRest = new JCheckBox(ThriftBundle.message("thrift.gen.option.rest"));

    add(myInlined);
    add(myServer);
    add(myOop);
    add(myRest);
  }

  @Override
  public void setValues(PHP php) {
    myInlined.setSelected(php.isInlined());
    myServer.setSelected(php.isServer());
    myOop.setSelected(php.isOop());
    myRest.setSelected(php.isRest());
  }

  @Override
  public void readValuesTo(PHP php) {
    php.setInlined(myInlined.isSelected());
    php.setServer(myServer.isSelected());
    php.setOop(myOop.isSelected());
    php.setRest(myRest.isSelected());
  }
}
