package com.intellij.plugins.thrift.inspections;

import com.intellij.codeInspection.InspectionManager;
import com.intellij.codeInspection.LocalInspectionTool;
import com.intellij.codeInspection.ProblemDescriptor;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.plugins.thrift.ThriftBundle;
import com.intellij.plugins.thrift.lang.psi.*;
import com.intellij.plugins.thrift.util.ThriftPsiUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.util.ArrayUtil;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThriftTopLevelDeclarationDuplicatesInspection extends LocalInspectionTool {
  @NotNull
  public String getGroupDisplayName() {
    return ThriftBundle.message("inspections.group.name");
  }

  @Nls
  @NotNull
  @Override
  public String getDisplayName() {
    return ThriftBundle.message("thrift.inspection.duplicates.top_level_declaration");
  }

  @Override
  public boolean isEnabledByDefault() {
    return true;
  }

  @NotNull
  @Override
  public String getShortName() {
    return "ThriftTopLevelDeclarationDuplicates";
  }

  @Nullable
  @Override
  public ProblemDescriptor[] checkFile(@NotNull PsiFile file, @NotNull final InspectionManager manager, final boolean isOnTheFly) {
    final List<ProblemDescriptor> result = new ArrayList<ProblemDescriptor>();
    final Set<String> topLevelNames = new HashSet<String>();
    new ThriftVisitor() {
      @Override
      public void visitTopLevelDeclaration(@NotNull ThriftTopLevelDeclaration o) {
        ThriftDefinitionName topIdentifier = o.getIdentifier();
        if (topIdentifier != null && !topLevelNames.add(topIdentifier.getText())) {
          // Repeated top level names
          result.add(manager.createProblemDescriptor(
                  topIdentifier,
                  String.format("multiple declarations '%s'", topIdentifier.getName()),
                  true,
                  ProblemHighlightType.ERROR,
                  isOnTheFly
          ));
        }
      }

      public void visitElement(@NotNull PsiElement element) {
        super.visitElement(element);
        element.acceptChildren(this);
      }
    }.visitFile(file);
    return ArrayUtil.toObjectArray(result, ProblemDescriptor.class);
  }
}
