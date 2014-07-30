package com.intellij.plugins.thrift.config.facet.options;

import com.intellij.plugins.thrift.ThriftBundle;
import com.intellij.plugins.thrift.config.target.CSharp;

import javax.swing.*;
import java.awt.*;

/**
 * 16.07.2014 17:49
 *
 * @author xBlackCat
 */
class CSharpOptionPane extends AOptionPane<CSharp> {

  private final JCheckBox myAsync;
  private final JCheckBox myAsyncctp;
  private final JCheckBox myWcf;
  private final JCheckBox mySerial;
  private final JCheckBox myNullable;
  private final JCheckBox myHashcode;
  private final JCheckBox myUnion;

  public CSharpOptionPane() {
    super(new GridLayout(0, 1));

    myAsync = new JCheckBox(ThriftBundle.message("thrift.gen.option.async"));
    myAsyncctp = new JCheckBox(ThriftBundle.message("thrift.gen.option.asyncctp"));
    myWcf = new JCheckBox(ThriftBundle.message("thrift.gen.option.wcf"));
    mySerial = new JCheckBox(ThriftBundle.message("thrift.gen.option.serial"));
    myNullable = new JCheckBox(ThriftBundle.message("thrift.gen.option.nullable"));
    myHashcode = new JCheckBox(ThriftBundle.message("thrift.gen.option.cs-hashcode"));
    myUnion = new JCheckBox(ThriftBundle.message("thrift.gen.option.union"));

    add(myAsync);
    add(myAsyncctp);
    add(myWcf);
    add(mySerial);
    add(myNullable);
    add(myHashcode);
    add(myUnion);
  }

  @Override
  public void setValues(CSharp sharp) {
    myAsync.setSelected(sharp.isAsync());
    myAsyncctp.setSelected(sharp.isAsyncctp());
    myWcf.setSelected(sharp.isWcf());
    mySerial.setSelected(sharp.isSerial());
    myNullable.setSelected(sharp.isNullable());
    myHashcode.setSelected(sharp.isHashcode());
    myUnion.setSelected(sharp.isUnion());
  }

  @Override
  public void readValuesTo(CSharp sharp) {
    sharp.setAsync(myAsync.isSelected());
    sharp.setAsyncctp(myAsyncctp.isSelected());
    sharp.setWcf(myWcf.isSelected());
    sharp.setSerial(mySerial.isSelected());
    sharp.setNullable(myNullable.isSelected());
    sharp.setHashcode(myHashcode.isSelected());
    sharp.setUnion(myUnion.isSelected());
  }
}
