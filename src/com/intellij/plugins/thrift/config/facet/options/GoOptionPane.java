package com.intellij.plugins.thrift.config.facet.options;

import com.intellij.plugins.thrift.ThriftBundle;
import com.intellij.plugins.thrift.config.target.Go;
import org.apache.commons.lang.StringUtils;

import javax.swing.*;
import java.awt.*;

/**
 * 16.07.2014 17:55
 *
 * @author xBlackCat
 */
class GoOptionPane extends AOptionPane<Go> {

  private final JTextField myPackagePrefix;
  private final JTextField myThriftImport;
  private final JTextField myPackage;

  public GoOptionPane() {
    super(new GridLayout(0, 1));

    final JLabel packagePrefixLabel = new JLabel(ThriftBundle.message("thrift.gen.option.package_prefix"));
    final JLabel thriftImportLabel = new JLabel(ThriftBundle.message("thrift.gen.option.thrift_import"));
    final JLabel packageLabel = new JLabel(ThriftBundle.message("thrift.gen.option.package"));
    myPackagePrefix = new JTextField();
    myThriftImport = new JTextField();
    myPackage = new JTextField();

    add(packagePrefixLabel);
    add(myPackagePrefix);
    add(thriftImportLabel);
    add(myThriftImport);
    add(packageLabel);
    add(myPackage);
  }

  @Override
  public void setValues(Go go) {
    myPackagePrefix.setText(go.getPackagePrefix());
    myThriftImport.setText(go.getThriftImport());
    myPackage.setText(go.getPackageName());
  }

  @Override
  public void readValuesTo(Go go) {
    go.setPackagePrefix(StringUtils.trimToNull(myPackagePrefix.getText()));
    go.setThriftImport(StringUtils.trimToNull(myThriftImport.getText()));
    go.setPackage(StringUtils.trimToNull(myPackage.getText()));
  }
}
