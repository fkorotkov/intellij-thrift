package com.intellij.plugins.thrift.lang.psi.presentation;

import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.ItemPresentationProvider;
import com.intellij.openapi.util.Iconable;
import com.intellij.plugins.thrift.lang.psi.ThriftDeclaration;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by fkorotkov.
 */
public class ThriftTopLevelDeclarationPresentationProvider implements ItemPresentationProvider<ThriftDeclaration> {
  @Override
  public ItemPresentation getPresentation(final ThriftDeclaration item) {
    return new ItemPresentation() {
      @Nullable
      @Override
      public String getPresentableText() {
        return item.getName();
      }

      @Nullable
      @Override
      public String getLocationString() {
        PsiFile containingFile = item.getContainingFile();
        return containingFile == null ? null : containingFile.getName();
      }

      @Nullable
      @Override
      public Icon getIcon(boolean unused) {
        return item.getIcon(Iconable.ICON_FLAG_VISIBILITY);
      }
    };
  }
}
