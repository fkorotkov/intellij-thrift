package com.intellij.plugins.thrift.config.facet.options;

import com.intellij.plugins.thrift.config.target.Cpp;

import javax.swing.*;
import java.awt.*;

/**
 * 16.07.2014 17:44
 *
 * @author xBlackCat
 */
class CppOptionPane extends AOptionPane<Cpp> {
  private final JCheckBox myCobStyle;
  private final JCheckBox myNoClientCompletion;
  private final JCheckBox myTemplates;
  private final JCheckBox myPureEnums;
  private final JCheckBox myDense;
  private final JCheckBox myIncludePrefix;

  public CppOptionPane() {
    super(new GridLayout(0, 1));

    myCobStyle = new JCheckBox("cob_style");
    myNoClientCompletion = new JCheckBox("no_client_completion");
    myTemplates = new JCheckBox("templates");
    myPureEnums = new JCheckBox("pure_enums");
    myDense = new JCheckBox("dense");
    myIncludePrefix = new JCheckBox("include_prefix");

    add(myCobStyle);
    add(myNoClientCompletion);
    add(myTemplates);
    add(myPureEnums);
    add(myDense);
    add(myIncludePrefix);
  }

  @Override
  public void setValues(Cpp cpp) {
    myCobStyle.setSelected(cpp.isCobStyle());
    myNoClientCompletion.setSelected(cpp.isNoClientCompletion());
    myTemplates.setSelected(cpp.isTemplates());
    myPureEnums.setSelected(cpp.isPureEnums());
    myDense.setSelected(cpp.isDense());
    myIncludePrefix.setSelected(cpp.isIncludePrefix());
  }

  @Override
  public void readValuesTo(Cpp cpp) {
    cpp.setCobStyle(myCobStyle.isSelected());
    cpp.setNoClientCompletion(myNoClientCompletion.isSelected());
    cpp.setTemplates(myTemplates.isSelected());
    cpp.setPureEnums(myPureEnums.isSelected());
    cpp.setDense(myDense.isSelected());
    cpp.setIncludePrefix(myIncludePrefix.isSelected());
  }
}
