/*
 * Copyright 2000-2013 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intellij.plugins.thrift.structure;

import com.intellij.ide.IdeBundle;
import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.StructureViewModelBase;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.*;
import com.intellij.plugins.thrift.lang.psi.ThriftDeclaration;
import com.intellij.plugins.thrift.lang.psi.ThriftSubDeclaration;
import com.intellij.plugins.thrift.lang.psi.ThriftTopLevelDeclaration;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.util.PlatformIcons;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * @author: Fedor.Korotkov
 */
public class ThriftStructureViewModel extends StructureViewModelBase implements StructureViewModel.ElementInfoProvider {
  public ThriftStructureViewModel(@NotNull PsiFile psiFile) {
    super(psiFile, new ThriftStructureViewElement(psiFile));
    withSorters(Sorter.ALPHA_SORTER);
    withSuitableClasses(ThriftDeclaration.class);
  }

  @Override
  public boolean isAlwaysShowsPlus(StructureViewTreeElement element) {
    return false;
  }

  @NotNull
  @Override
  public Filter[] getFilters() {
    return new Filter[]{ourFieldsFilter};
  }

  @Override
  public boolean isAlwaysLeaf(StructureViewTreeElement element) {
    final Object value = element.getValue();
    return value instanceof ThriftSubDeclaration;
  }

  @Override
  public boolean shouldEnterElement(Object element) {
    return element instanceof ThriftTopLevelDeclaration;
  }


  private static final Filter ourFieldsFilter = new Filter() {
    @NonNls public static final String ID = "SHOW_FIELDS";

    public boolean isVisible(TreeElement treeNode) {
      if (!(treeNode instanceof ThriftStructureViewElement)) return true;
      final PsiElement element = ((ThriftStructureViewElement)treeNode).getRealElement();

      return !(element instanceof ThriftSubDeclaration);
    }

    public boolean isReverted() {
      return true;
    }

    @NotNull
    public ActionPresentation getPresentation() {
      return new ActionPresentationData(
        IdeBundle.message("action.structureview.show.fields"),
        null,
        PlatformIcons.FIELD_ICON
      );
    }

    @NotNull
    public String getName() {
      return ID;
    }
  };
}
