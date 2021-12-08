package com.intellij.plugins.thrift.editor;

import com.intellij.codeInsight.daemon.DaemonBundle;
import com.intellij.codeInsight.daemon.LineMarkerInfo;
import com.intellij.codeInsight.daemon.LineMarkerProvider;
import com.intellij.codeInsight.daemon.impl.PsiElementListNavigator;
import com.intellij.icons.AllIcons;
import com.intellij.ide.util.DefaultPsiElementCellRenderer;
import com.intellij.openapi.editor.markup.GutterIconRenderer;
import com.intellij.plugins.thrift.lang.psi.ThriftDefinitionName;
import com.intellij.plugins.thrift.util.ThriftPsiUtil;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by fkorotkov.
 */
public class ThriftLineMarkerProvider implements LineMarkerProvider {
  @Nullable
  @Override
  public LineMarkerInfo<PsiElement> getLineMarkerInfo(@NotNull PsiElement element) {
    if (element instanceof ThriftDefinitionName) {
      return findImplementationsAndCreateMarker((ThriftDefinitionName)element);
    }
    return null;
  }

  @Nullable
  private LineMarkerInfo<PsiElement> findImplementationsAndCreateMarker(final ThriftDefinitionName definitionName) {
    final List<NavigatablePsiElement> implementations = ThriftPsiUtil.findImplementations(definitionName);
    if (implementations.isEmpty()) {
      return null;
    }
    return new LineMarkerInfo<>(
      definitionName,
      definitionName.getTextRange(),
      AllIcons.Gutter.ImplementedMethod,
      element -> DaemonBundle.message("interface.is.implemented.too.many"),
        (e, elt) -> PsiElementListNavigator.openTargets(
          e,
          implementations.toArray(new NavigatablePsiElement[0]),
          DaemonBundle.message("navigation.title.implementation.method", definitionName.getText(), implementations.size()),
          "Implementations of " + definitionName.getText(),
          new DefaultPsiElementCellRenderer()
        ),
      GutterIconRenderer.Alignment.RIGHT,
      () -> DaemonBundle.message("interface.is.implemented.too.many")
    );
  }
}
