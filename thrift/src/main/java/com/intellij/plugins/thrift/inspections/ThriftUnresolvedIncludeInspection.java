package com.intellij.plugins.thrift.inspections;

import com.intellij.codeInspection.InspectionManager;
import com.intellij.codeInspection.LocalInspectionTool;
import com.intellij.codeInspection.ProblemDescriptor;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.openapi.util.TextRange;
import com.intellij.plugins.thrift.ThriftBundle;
import com.intellij.plugins.thrift.lang.psi.ThriftInclude;
import com.intellij.plugins.thrift.lang.psi.ThriftVisitor;
import com.intellij.plugins.thrift.util.ThriftPsiUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.util.ArrayUtil;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ThriftUnresolvedIncludeInspection extends LocalInspectionTool {

  @NotNull
  public String getGroupDisplayName() {
    return ThriftBundle.message("inspections.group.name");
  }

  @Nls
  @NotNull
  @Override
  public String getDisplayName() {
    return ThriftBundle.message("thrift.inspection.unresolved.include");
  }

  @Override
  public boolean isEnabledByDefault() {
    return true;
  }

  @NotNull
  @Override
  public String getShortName() {
    return "ThriftUnresolvedInclude";
  }

  @Nullable
  @Override
  public ProblemDescriptor[] checkFile(@NotNull PsiFile file, @NotNull final InspectionManager manager, final boolean isOnTheFly) {
    final List<ProblemDescriptor> result = new ArrayList<ProblemDescriptor>();
    new ThriftVisitor() {

      @Override
      public void visitInclude(@NotNull ThriftInclude include) {
        if (ThriftPsiUtil.resolveInclude(include) == null) {
          PsiElement lastChild = include.getLastChild();
          result.add(manager.createProblemDescriptor(
            lastChild,
            TextRange.from(0, lastChild.getTextLength()),
            getDisplayName(),
            ProblemHighlightType.GENERIC_ERROR_OR_WARNING,
            isOnTheFly
          ));
        }
      }

      public void visitElement(PsiElement element) {
        super.visitElement(element);
        element.acceptChildren(this);
      }
    }.visitFile(file);
    return ArrayUtil.toObjectArray(result, ProblemDescriptor.class);
  }
}
