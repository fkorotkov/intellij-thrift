package com.intellij.plugins.thrift.editor;

import com.google.common.base.Stopwatch;
import com.intellij.codeInsight.daemon.impl.PsiElementListNavigator;
import com.intellij.ide.util.PsiElementListCellRenderer;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.JBPopup;
import com.intellij.plugins.thrift.ThriftBundle;
import com.intellij.plugins.thrift.index.ThriftDeclarationIndex;
import com.intellij.plugins.thrift.lang.psi.ThriftDeclaration;
import com.intellij.plugins.thrift.lang.psi.ThriftStruct;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.search.GlobalSearchScope;
import org.apache.commons.compress.utils.Lists;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

public class GoToThriftDefinition extends AnAction {
  static Logger logger = Logger.getInstance(GoToThriftDefinition.class);

  @Override
  public void actionPerformed(@NotNull AnActionEvent event) {
    PsiElement psiElement = event.getData(CommonDataKeys.PSI_ELEMENT);
    List<ThriftDeclaration> thriftMatches = getThriftDeclarations(psiElement, event.getProject());
    if (thriftMatches.size() > 0) {
      PsiElementListCellRenderer<PsiElement> renderer = new PsiElementListCellRenderer<PsiElement>() {
        @Override
        public String getElementText(PsiElement element) {
          if (element instanceof ThriftStruct) {
            return ((ThriftStruct) element).getName();
          } else {
            return element.getText().substring(0, 20);
          }
        }

        @NotNull
        public Path commonRoot(@NotNull Path pathA, @NotNull Path pathB) {
          Path rootCandidate = pathA;
          while (rootCandidate.getParent() != null && rootCandidate.relativize(pathB).startsWith("..")) {
            rootCandidate = rootCandidate.getParent();
          }
          return rootCandidate;
        }

        @Override
        protected @Nullable String getContainerText(PsiElement element, String name) {
          Project project = event.getProject();
          Path containingFilePath = Paths.get(element.getContainingFile().getVirtualFile().getPath());
          if (project != null && project.getBasePath() != null) {
            Path projectBasePath = Paths.get(project.getBasePath()).normalize();
            return commonRoot(projectBasePath, containingFilePath).relativize(containingFilePath).toString();
          } else {
            return containingFilePath.toString();
          }
        }

        @Override
        protected int getIconFlags() {
          return 0;
        }
      };
      @Nullable JBPopup popup = PsiElementListNavigator.navigateOrCreatePopup(
          thriftMatches.toArray(new ThriftDeclaration[0]),
          ThriftBundle.message("thrift.goto.source"),
          ThriftBundle.message("thrift.goto.source"),
          renderer,
          null
      );
      if (popup != null) {
        popup.showInBestPositionFor(event.getDataContext());
      }
    }
  }

  @NotNull
  private List<ThriftDeclaration> getThriftDeclarations(PsiElement psiElement, Project project) {
    // FIXME: The PsiClass might not valid in Non-Java editors such as GoLand
    try {
      if (psiElement instanceof PsiClass) {
        PsiClass psiClassElement = (PsiClass) psiElement;
        String name = psiClassElement.getName();
        if (name != null) { // todo - handle multiple matches
          return ThriftDeclarationIndex.findDeclaration(name, project, GlobalSearchScope.allScope(project));
        }
      }
    } catch (NoClassDefFoundError e) {
      logger.warn("NoClassDefFoundError at GoToThriftDefinition.java:90");
    }
    return Lists.newArrayList();
  }

  @Override
  public void update(@NotNull AnActionEvent e) {
    PsiElement psiElement = e.getData(CommonDataKeys.PSI_ELEMENT);
    Presentation p = e.getPresentation();
    Stopwatch stopWatch = Stopwatch.createStarted();
    boolean enabled = !getThriftDeclarations(psiElement, e.getProject()).isEmpty();
    Duration time = stopWatch.elapsed();
    if (time.toMillis() > 20) {
      logger.warn("GoToThriftDefinition action update took " + time.toMillis() + "ms");
    }
    p.setEnabledAndVisible(enabled);
  }
}
