package com.intellij.plugins.thrift.lang.psi;

import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.ItemPresentationProvider;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by fkorotkov.
 */
public class ThriftDeclarationPresentationProvider implements ItemPresentationProvider<ThriftDeclaration> {
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
        return item.getContainingFile().getName();
      }

      @Nullable
      @Override
      public Icon getIcon(boolean unused) {
        return null;
      }
    };
  }
}
