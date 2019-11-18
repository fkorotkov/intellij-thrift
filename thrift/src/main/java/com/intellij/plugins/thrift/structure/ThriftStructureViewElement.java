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

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.NavigationItem;
import com.intellij.plugins.thrift.lang.psi.ThriftDeclaration;
import com.intellij.plugins.thrift.lang.psi.ThriftFile;
import com.intellij.plugins.thrift.lang.psi.ThriftTopLevelDeclaration;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Fedor.Korotkov
 */
public class ThriftStructureViewElement implements StructureViewTreeElement, SortableTreeElement {
  private final PsiElement myElement;

  public ThriftStructureViewElement(final PsiElement element) {
    myElement = element;
  }

  @Override
  public Object getValue() {
    return myElement;
  }

  @Override
  public void navigate(boolean requestFocus) {
    if (myElement instanceof NavigationItem) {
      ((NavigationItem)myElement).navigate(requestFocus);
    }
  }

  @Override
  public boolean canNavigate() {
    return myElement instanceof NavigationItem && ((NavigationItem)myElement).canNavigate();
  }

  @Override
  public boolean canNavigateToSource() {
    return myElement instanceof NavigationItem && ((NavigationItem)myElement).canNavigateToSource();
  }

  @Nullable
  @Override
  public ItemPresentation getPresentation() {
    return myElement instanceof NavigationItem ? ((NavigationItem)myElement).getPresentation() : null;
  }

  @Override
  public TreeElement[] getChildren() {
    if (!myElement.isValid()) {
      return new TreeElement[0];
    }
    final List<TreeElement> result = new ArrayList<TreeElement>();
    if (myElement instanceof ThriftFile) {
      ThriftTopLevelDeclaration[] topLevelDeclarations = PsiTreeUtil.getChildrenOfType(myElement, ThriftTopLevelDeclaration.class);
      if (topLevelDeclarations != null) {
        for (ThriftTopLevelDeclaration subNamedComponent : topLevelDeclarations) {
          result.add(new ThriftStructureViewElement(subNamedComponent));
        }
      }
    }
    else if (myElement instanceof ThriftTopLevelDeclaration) {
      for (ThriftDeclaration subDeclaration : ((ThriftTopLevelDeclaration)myElement).findSubDeclarations()) {
        result.add(new ThriftStructureViewElement(subDeclaration));
      }
    }
    return result.toArray(new TreeElement[result.size()]);
  }

  @Override
  public String getAlphaSortKey() {
    final String result = myElement instanceof NavigationItem ? ((NavigationItem)myElement).getName() : null;
    return result == null ? "" : result;
  }

  public PsiElement getRealElement() {
    return myElement;
  }
}
