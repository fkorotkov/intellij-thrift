package com.intellij.plugins.thrift.config.facet;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.AddEditRemovePanel;
import org.jetbrains.annotations.Nullable;

/**
* 15.07.2014 15:52
*
* @author xBlackCat
*/
class IncludesTableModel extends AddEditRemovePanel.TableModel<VirtualFile> {
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
  public Object getField(VirtualFile o, int columnIndex) {
    return o;
  }
}
