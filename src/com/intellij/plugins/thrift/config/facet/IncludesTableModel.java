package com.intellij.plugins.thrift.config.facet;

import com.intellij.ui.AddEditRemovePanel;
import org.jetbrains.annotations.Nullable;

/**
* 15.07.2014 15:52
*
* @author xBlackCat
*/
class IncludesTableModel extends AddEditRemovePanel.TableModel<String> {
  @Override
  public int getColumnCount() {
    return 1;
  }

  @Nullable
  @Override
  public String getColumnName(int columnIndex) {
    return "Path";
  }

  @Override
  public Object getField(String o, int columnIndex) {
    return o;
  }
}
