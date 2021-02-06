package com.intellij.plugins.thrift.annotator;

import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.plugins.thrift.lang.psi.ThriftCustomType;
import com.intellij.plugins.thrift.lang.psi.ThriftException;
import com.intellij.plugins.thrift.lang.psi.ThriftField;
import com.intellij.plugins.thrift.lang.psi.ThriftTypeReference;
import com.intellij.plugins.thrift.lang.psi.impl.ThriftThrowsImpl;
import com.intellij.plugins.thrift.util.ThriftPsiUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import org.jetbrains.annotations.NotNull;

public class ThrowsAnnotator implements Annotator {
  @Override
  public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
    // Ensure the Psi Element is a CustomType
    if (!(element instanceof ThriftThrowsImpl)) {
      return;
    }

    for (ThriftField field : ((ThriftThrowsImpl) element).getFieldList()) {
      ThriftCustomType fieldType = field.getFieldType().getCustomType();
      if (fieldType == null) {
        continue;
      }

      for (PsiReference reference : ThriftPsiUtil.getReferences(fieldType)) {
        if (!(reference instanceof ThriftTypeReference)) {
          continue;
        }

        PsiElement resolvedReference = reference.resolve();
        if (resolvedReference == null) {
          continue;
        }

        if (!(resolvedReference.getParent() instanceof ThriftException)) {
          String typeName = reference.getRangeInElement().substring(fieldType.getText());
          holder.newAnnotation(HighlightSeverity.ERROR, String.format("type %s is not an exception", typeName))
                  .highlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL)
                  .range(reference.getAbsoluteRange())
                  .create();
        }
      }

    }
  }

}
