package com.intellij.plugins.thrift.editor;

import com.intellij.codeHighlighting.Pass;
import com.intellij.codeInsight.daemon.DaemonBundle;
import com.intellij.codeInsight.daemon.GutterIconNavigationHandler;
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
import com.intellij.util.Function;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.List;

/**
 * Created by fkorotkov.
 */
public class ThriftLineMarkerProvider implements LineMarkerProvider {
  @Override
  public void collectSlowLineMarkers(@NotNull List<PsiElement> elements, @NotNull Collection<LineMarkerInfo> result) {

  }

  @Nullable
  @Override
  public LineMarkerInfo getLineMarkerInfo(@NotNull PsiElement element) {
    if (element instanceof ThriftDefinitionName) {
      return findImplementationsAndCreateMarker((ThriftDefinitionName)element);
    }
    return null;
  }

  @Nullable
  private LineMarkerInfo findImplementationsAndCreateMarker(final ThriftDefinitionName definitionName) {
    final List<NavigatablePsiElement> implementations = ThriftPsiUtil.findImplementations(definitionName);
    if (implementations.isEmpty()) {
      return null;
    }
    return new LineMarkerInfo<PsiElement>(
      definitionName,
      definitionName.getTextRange(),
      AllIcons.Gutter.ImplementedMethod,
      Pass.UPDATE_ALL,
      new Function<PsiElement, String>() {
        @Override
        public String fun(PsiElement element) {
          return DaemonBundle.message("interface.is.implemented.too.many");
        }
      },
      new GutterIconNavigationHandler<PsiElement>() {
        @Override
        public void navigate(MouseEvent e, PsiElement elt) {
          PsiElementListNavigator.openTargets(
            e,
            implementations.toArray(new NavigatablePsiElement[implementations.size()]),
            DaemonBundle.message("navigation.title.implementation.method", definitionName.getText(), implementations.size()),
            "Implementations of " + definitionName.getText(),
            new DefaultPsiElementCellRenderer()
          );
        }
      },
      GutterIconRenderer.Alignment.RIGHT
    );
  }
}
