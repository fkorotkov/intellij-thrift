package com.intellij.plugins.thrift.config.facet.options;

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

  public GoOptionPane() {
    super(new BorderLayout());

    final JLabel packagePrefixLabel = new JLabel("package_prefix");
    final JLabel thriftImportLabel = new JLabel("thrift_import");
    myPackagePrefix = new JTextField();
    myThriftImport = new JTextField();

    final JPanel labels = new JPanel(new GridLayout(0, 1));
    labels.add(packagePrefixLabel);
    labels.add(thriftImportLabel);

    add(labels, BorderLayout.WEST);

    final JPanel fields = new JPanel(new GridLayout(0, 1));
    fields.add(myPackagePrefix);
    fields.add(myThriftImport);

    add(fields, BorderLayout.CENTER);
  }

  @Override
  public void setValues(Go go) {
    myPackagePrefix.setText(go.getPackagePrefix());
    myThriftImport.setText(go.getThriftImport());
  }

  @Override
  public void readValuesTo(Go go) {
    go.setPackagePrefix(StringUtils.trimToNull(myPackagePrefix.getText()));
    go.setThriftImport(StringUtils.trimToNull(myThriftImport.getText()));
  }
}
