package com.intellij.plugins.thrift.util;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.plugins.thrift.ThriftFileType;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.impl.providers.FileReferenceSet;
import org.jetbrains.annotations.NotNull;

/**
 * Created by fkorotkov.
 */
public class ThriftPsiUtil {
  @NotNull
  public static PsiReference[] getReferences(PsiElement original) {
    PsiElement element = original.getLastChild();
    final String path = StringUtil.unquoteString(element.getText());
    final FileReferenceSet referenceSet = new FileReferenceSet(
      path, original, element.getStartOffsetInParent() + 1, null, true, true, new FileType[]{ThriftFileType.INSTANCE}
    );
    return referenceSet.getAllReferences();
  }
}
