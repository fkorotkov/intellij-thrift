package com.intellij.plugins.thrift.config.facet.options;

import com.intellij.plugins.thrift.ThriftBundle;
import com.intellij.plugins.thrift.config.target.Java;

import javax.swing.*;
import java.awt.*;

/**
 * 16.07.2014 18:04
 *
 * @author xBlackCat
 */
class JavaOptionPane extends AOptionPane<Java> {

  private final JCheckBox myBeans;
  private final JCheckBox myPrivateMembers;
  private final JCheckBox myNocamel;
  private final JCheckBox myHashcode;
  private final JCheckBox myAndroidLegacy;
  private final JCheckBox myJava5;
  private final JCheckBox mySortedContainers;
  private final JCheckBox myFullcamel;
  private final JCheckBox myAndroid;
  private final JCheckBox myReuseObjects;
  private final JCheckBox myUndatedAnnotations;

  public JavaOptionPane() {
    super(new GridLayout(0, 1));

    myBeans = new JCheckBox(ThriftBundle.message("thrift.gen.option.beans"));
    myPrivateMembers = new JCheckBox(ThriftBundle.message("thrift.gen.option.private-members"));
    myNocamel = new JCheckBox(ThriftBundle.message("thrift.gen.option.nocamel"));
    myHashcode = new JCheckBox(ThriftBundle.message("thrift.gen.option.java-hashcode"));
    myAndroidLegacy = new JCheckBox(ThriftBundle.message("thrift.gen.option.android_legacy"));
    myJava5 = new JCheckBox(ThriftBundle.message("thrift.gen.option.java5"));
    mySortedContainers = new JCheckBox(ThriftBundle.message("thrift.gen.option.sorted_containers"));
    myFullcamel = new JCheckBox(ThriftBundle.message("thrift.gen.option.fullcamel"));
    myAndroid = new JCheckBox(ThriftBundle.message("thrift.gen.option.android"));
    myReuseObjects = new JCheckBox(ThriftBundle.message("thrift.gen.option.reuse-objects"));
    myUndatedAnnotations = new JCheckBox(ThriftBundle.message("thrift.gen.option.undated-annotations"));

    add(myBeans);
    add(myPrivateMembers);
    add(myNocamel);
    add(myHashcode);
    add(myAndroidLegacy);
    add(myJava5);
    add(mySortedContainers);
    add(myFullcamel);
    add(myAndroid);
    add(myReuseObjects);
    add(myUndatedAnnotations);
  }

  @Override
  public void setValues(Java java) {
    myBeans.setSelected(java.isBeans());
    myPrivateMembers.setSelected(java.isPrivateMembers());
    myNocamel.setSelected(java.isNoCamel());
    myHashcode.setSelected(java.isHashCode());
    myAndroidLegacy.setSelected(java.isAndroidLegacy());
    myJava5.setSelected(java.isJava5());
    mySortedContainers.setSelected(java.isSortedContainers());
    myFullcamel.setSelected(java.isFullcamel());
    myAndroid.setSelected(java.isAndroid());
    myReuseObjects.setSelected(java.isReuseObjects());
    myUndatedAnnotations.setSelected(java.isUndatedAnnotations());
  }

  @Override
  public void readValuesTo(Java java) {
    java.setBeans(myBeans.isSelected());
    java.setPrivateMembers(myPrivateMembers.isSelected());
    java.setNoCamel(myNocamel.isSelected());
    java.setHashCode(myHashcode.isSelected());
    java.setAndroidLegacy(myAndroidLegacy.isSelected());
    java.setJava5(myJava5.isSelected());
    java.setSortedContainers(mySortedContainers.isSelected());
    java.setFullcamel(myFullcamel.isSelected());
    java.setAndroid(myAndroid.isSelected());
    java.setReuseObjects(myReuseObjects.isSelected());
    java.setUndatedAnnotations(myUndatedAnnotations.isSelected());
  }
}
