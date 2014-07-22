package com.intellij.plugins.thrift.config.facet.options;

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

  public JavaOptionPane() {
    super(new GridLayout(0, 1));

    myBeans = new JCheckBox("beans");
    myPrivateMembers = new JCheckBox("private-members");
    myNocamel = new JCheckBox("nocamel");
    myHashcode = new JCheckBox("hashcode");
    myAndroidLegacy = new JCheckBox("android_legacy");
    myJava5 = new JCheckBox("java5");
    mySortedContainers = new JCheckBox("sorted_containers");

    add(myBeans);
    add(myPrivateMembers);
    add(myNocamel);
    add(myHashcode);
    add(myAndroidLegacy);
    add(myJava5);
    add(mySortedContainers);
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
  }
}
