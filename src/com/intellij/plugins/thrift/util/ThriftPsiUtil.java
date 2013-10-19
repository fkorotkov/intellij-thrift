package com.intellij.plugins.thrift.util;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.util.Ref;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.plugins.thrift.ThriftFileType;
import com.intellij.plugins.thrift.lang.psi.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileSystemItem;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.impl.providers.FileReferenceSet;
import com.intellij.util.Processor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by fkorotkov.
 */
public class ThriftPsiUtil {
  @Nullable
  public static PsiFile resolveInclude(@Nullable ThriftInclude include) {
    final PsiFileSystemItem target = include != null ? getReferenceSet(include).resolve() : null;
    return target instanceof PsiFile ? (PsiFile)target : null;
  }

  @NotNull
  public static PsiReference[] getReferences(@NotNull ThriftInclude include) {
    return getReferenceSet(include).getAllReferences();
  }

  @NotNull
  private static FileReferenceSet getReferenceSet(@NotNull ThriftInclude include) {
    final PsiElement element = include.getLastChild();
    final String path = getPath(include);
    return new FileReferenceSet(
      path, include, element.getStartOffsetInParent() + 1, null, true, true, new FileType[]{ThriftFileType.INSTANCE}
    );
  }

  @NotNull
  public static String getPath(ThriftInclude include) {
    PsiElement element = include.getLastChild();
    return StringUtil.unquoteString(element.getText());
  }

  @NotNull
  public static PsiReference[] getReferences(ThriftCustomType type) {
    return new PsiReference[]{new ThriftTypeReference(type)};
  }

  public static void processDeclarations(@NotNull PsiFile psiFile, @NotNull Processor<ThriftDeclaration> processor) {
    for (PsiElement child : psiFile.getChildren()) {
      if (child instanceof ThriftDeclaration && !processor.process((ThriftDeclaration)child)) {
        break;
      }
    }
  }

  public static ThriftDefinitionName findDeclaration(@NotNull final String name, @NotNull PsiFile containingFile) {
    final Ref<ThriftDefinitionName> result = new Ref<ThriftDefinitionName>();
    processDeclarations(containingFile, new Processor<ThriftDeclaration>() {
      @Override
      public boolean process(ThriftDeclaration declaration) {
        if (name.equals(declaration.getName())) {
          result.set(declaration.getIdentifier());
        }
        return true;
      }
    });
    return result.get();
  }

  @Nullable
  public static ThriftInclude findImportByPrefix(@NotNull PsiFile psiFile, @NotNull String fileName) {
    for (PsiElement element : psiFile.getChildren()) {
      if (element instanceof ThriftInclude) {
        String path = ((ThriftInclude)element).getPath();
        if (FileUtil.getNameWithoutExtension(path).endsWith(fileName)) {
          return (ThriftInclude)element;
        }
      }
    }
    return null;
  }
}
