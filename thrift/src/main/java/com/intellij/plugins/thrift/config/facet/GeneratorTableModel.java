package com.intellij.plugins.thrift.config.facet;

import com.intellij.plugins.thrift.config.target.Generator;
import com.intellij.ui.AddEditRemovePanel;
import org.jetbrains.annotations.Nullable;

/**
 * 15.07.2014 15:52
 *
 * @author xBlackCat
 */
class GeneratorTableModel extends AddEditRemovePanel.TableModel<Generator> {
  @Override
  public int getColumnCount() {
    return 2;
  }

  @Nullable
  @Override
  public String getColumnName(int columnIndex) {
    return columnIndex == 0 ? "Target" : "Output path";
  }

  @Override
  public Object getField(Generator o, int columnIndex) {
    return columnIndex == 0 ? o.getType() : o.getOutputDir();
  }
}
