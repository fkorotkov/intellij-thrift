package com.intellij.plugins.thrift.inspections;

import com.intellij.codeInspection.InspectionManager;
import com.intellij.codeInspection.LocalInspectionTool;
import com.intellij.codeInspection.ProblemDescriptor;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.plugins.thrift.ThriftBundle;
import com.intellij.plugins.thrift.lang.psi.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.ArrayUtil;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThriftDuplicatesInspection extends LocalInspectionTool {
  @NotNull
  public String getGroupDisplayName() {
    return ThriftBundle.message("inspections.group.name");
  }

  @Nls
  @NotNull
  @Override
  public String getDisplayName() {
    return ThriftBundle.message("thrift.inspection.duplicates");
  }

  @Override
  public boolean isEnabledByDefault() {
    return true;
  }

  @NotNull
  @Override
  public String getShortName() {
    return "ThriftDuplicates";
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
                  getDisplayName(),
                  true,
                  ProblemHighlightType.ERROR,
                  isOnTheFly
          ));
        }

        if (o instanceof ThriftService) {
          ThriftService service = (ThriftService) o;
          ThriftServiceBody body = service.getServiceBody();

          if (body != null) {
            Set<String> methodNames = new HashSet<String>();

            for (ThriftFunction f : body.getFunctionList()) {
              String methodName = f.getDefinitionName().getName();

              if(!methodNames.add(methodName)){
                result.add(manager.createProblemDescriptor(
                        f.getIdentifier(),
                        String.format("multiple methods with name '%s'", methodName),
                        true,
                        ProblemHighlightType.ERROR,
                        isOnTheFly
                ));
              }

              result.addAll(checkFieldList(manager, isOnTheFly, f.getFieldList(), "args"));
              ThriftThrows t = f.getThrows();
              if (t != null) {
                result.addAll(checkFieldList(manager, isOnTheFly, t.getFieldList(), "throws"));
              }
            }
          }
        }

        if (o instanceof ThriftStruct) {
          ThriftFields fields = ((ThriftStruct) o).getFields();
          if (fields != null) {
            result.addAll(checkFieldList(manager, isOnTheFly, fields.getFieldList(), "fields"));
          }
        }
      }

      public void visitElement(@NotNull PsiElement element) {
        super.visitElement(element);
        element.acceptChildren(this);
      }
    }.visitFile(file);
    return ArrayUtil.toObjectArray(result, ProblemDescriptor.class);
  }

  private List<ProblemDescriptor> checkFieldList(
          @NotNull final InspectionManager manager,
          final boolean isOnTheFly,
          List<ThriftField> fields,
          String part
  ) {
    Set<String> names = new HashSet<String>();
    Set<String> ids = new HashSet<String>();
    final List<ProblemDescriptor> result = new ArrayList<ProblemDescriptor>();

    for (ThriftField field : fields) {
      ThriftFieldID id = field.getFieldID();
      ThriftDefinitionName name = field.getDefinitionName();

      if (id != null && !ids.add(id.getText())) {
        result.add(manager.createProblemDescriptor(
                field.getIdentifier(),
                String.format("multiple %s with id %s", part, id.getIntConstant().getText()),
                true,
                ProblemHighlightType.ERROR,
                isOnTheFly
        ));
      }

      if (name != null && !names.add(name.getText())) {
        result.add(manager.createProblemDescriptor(
                field.getIdentifier(),
                String.format("multiple %s with name '%s'", part, name.getText()),
                true,
                ProblemHighlightType.ERROR,
                isOnTheFly
        ));
      }
    }

    return result;
  }
}
