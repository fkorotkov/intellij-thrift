package com.intellij.plugins.thrift.annotator;

import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.plugins.thrift.lang.psi.ThriftCustomType;
import com.intellij.plugins.thrift.lang.psi.ThriftThrows;
import com.intellij.plugins.thrift.quickfix.ThriftCreateCustomTypeQuickFix;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

public class UnresolvedReferenceAnnotator implements Annotator {
  @Override
  public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
    // Ensure the Psi Element is a CustomType
    if (!(element instanceof ThriftCustomType)) {
      return;
    }

    ThriftCustomType customType = (ThriftCustomType) element;

    PsiReference[] references = customType.getReferences();

    if (references.length == 2) {
      String importName = references[0].getRangeInElement().substring(element.getText());
      String typeName = references[1].getRangeInElement().substring(element.getText());
      if (references[0].resolve() == null) {
        holder.newAnnotation(HighlightSeverity.ERROR, String.format("unresolved import: '%s'", importName))
                .highlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL)
//                .withFix(new ThriftCreateCustomTypeQuickFix(customType)) TODO: propose import
                .range(references[0].getAbsoluteRange())
                .create();
        holder.newSilentAnnotation(HighlightSeverity.ERROR)
                .highlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL)
                .range(references[1].getAbsoluteRange())
                .create();
      } else {
        if (references[1].resolve() == null) {
          holder.newAnnotation(HighlightSeverity.ERROR, String.format("unresolved reference '%s'", typeName))
                  .highlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL)
                  .range(references[1].getAbsoluteRange())
                  .withFix(new ThriftCreateCustomTypeQuickFix(customType))
                  .create();
        }
      }
    } else {
      if (references[0].resolve() == null) {
        holder.newAnnotation(HighlightSeverity.ERROR, String.format("unresolved reference '%s'", element.getText()))
                .highlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL)
                .range(references[0].getAbsoluteRange())
                .withFix(new ThriftCreateCustomTypeQuickFix(customType))
                .create();
      }
    }

  }

}
