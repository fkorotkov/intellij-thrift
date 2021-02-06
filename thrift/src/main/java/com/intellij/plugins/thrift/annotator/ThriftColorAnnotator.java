package com.intellij.plugins.thrift.annotator;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.util.TextRange;
import com.intellij.plugins.thrift.highlight.ThriftSyntaxHighlighterColors;
import com.intellij.plugins.thrift.lang.lexer.ThriftTokenTypes;
import com.intellij.plugins.thrift.lang.psi.ThriftCustomType;
import com.intellij.plugins.thrift.lang.psi.ThriftFunction;
import com.intellij.plugins.thrift.util.ThriftUtils;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

/**
 * Created by fkorotkov.
 */
public class ThriftColorAnnotator implements Annotator {
  @Override
  public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
    if (element instanceof ThriftCustomType) {
      ThriftCustomType customType = (ThriftCustomType) element;
      @NotNull PsiReference[] references = customType.getReferences();
      if (references.length == 2) {
        setRangeHighlighting(holder, ThriftSyntaxHighlighterColors.THRIFT_PREFIX, references[0].getAbsoluteRange());
        setRangeHighlighting(holder, ThriftSyntaxHighlighterColors.THRIFT_IMPORTED_TYPE, references[1].getAbsoluteRange());
      } else {
        setHighlighting(holder, ThriftSyntaxHighlighterColors.THRIFT_LOCAL_TYPE);
      }
    } else if (element instanceof ThriftFunction) {
      ThriftFunction function = (ThriftFunction) element;
      setRangeHighlighting(holder, ThriftSyntaxHighlighterColors.THRIFT_METHOD, function.getDefinitionName().getTextRange());
    } else if (element instanceof LeafPsiElement) {
      IElementType tokenType = ((LeafPsiElement) element).getElementType();
      if (tokenType == ThriftTokenTypes.IDENTIFIER && ThriftUtils.getKeywords().contains(element.getText())) {
        annotateKeyword(element, holder);
      }
    }
  }

  private static void setRangeHighlighting(@NotNull AnnotationHolder holder, @NotNull TextAttributesKey key, TextRange range) {
    holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
            .textAttributes(key)
            .range(range)
            .create();
  }

  private static void setHighlighting(@NotNull AnnotationHolder holder, @NotNull TextAttributesKey key) {
    holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
            .textAttributes(key)
            .create();
  }

  private void annotateKeyword(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
    holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
            .textAttributes(TextAttributesKey.find(ThriftSyntaxHighlighterColors.THRIFT_KEYWORD))
            .create();
  }


}
