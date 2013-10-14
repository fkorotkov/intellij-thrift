package com.intellij.plugins.thrift.annotator;

import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.plugins.thrift.highlight.ThriftSyntaxHighlighterColors;
import com.intellij.plugins.thrift.lang.lexer.ThriftTokenTypes;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.containers.ContainerUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

/**
 * Created by fkorotkov.
 */
public class ThriftColorAnnotator implements Annotator {
    private static final Set<String> keywords = ContainerUtil.immutableSet(
            "const", "cpp_include", "enum", "exception", "include", "namespace",
            "php_namespace", "senum", "service", "struct", "typedef", "union",
            "xsd_namespace", "cpp", "java", "py", "py.twisted", "perl", "rb", "js", "st",
            "cocoa", "csharp", "c_glib", "go", "php", "delphi", "const", "enum", "exception",
            "senum", "service", "struct", "typedef", "union", "required", "optional", "xsd_optional",
            "xsd_nillable", "oneway", "throws", "bool", "byte", "i16", "i32", "i64", "double",
            "string", "binary", "slist", "list", "map", "set", "cpp_type"
    );

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof LeafPsiElement) {
            IElementType tokenType = ((LeafPsiElement) element).getElementType();
            if (tokenType == ThriftTokenTypes.IDENTIFIER && keywords.contains(element.getText())) {
                annotateKeyword(element, holder);
            }
        }
    }

    private void annotateKeyword(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        final Annotation annotation = holder.createInfoAnnotation(element, null);
        annotation.setTextAttributes(TextAttributesKey.find(ThriftSyntaxHighlighterColors.THRIFT_KEYWORD));
    }
}
