package com.intellij.plugins.thrift.util;

import com.intellij.navigation.ChooseByNameContributor;
import com.intellij.navigation.ChooseByNameRegistry;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.util.Condition;
import com.intellij.openapi.util.Ref;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.plugins.thrift.ThriftClassContributor;
import com.intellij.plugins.thrift.ThriftFileType;
import com.intellij.plugins.thrift.lang.psi.*;
import com.intellij.psi.*;
import com.intellij.psi.impl.source.resolve.reference.impl.providers.FileReferenceSet;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.PathUtil;
import com.intellij.util.Processor;
import com.intellij.util.containers.ContainerUtil;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fkorotkov.
 */
public class ThriftPsiUtil {
  @Nullable
  public static PsiFile resolveInclude(@Nullable ThriftInclude include) {
    if (include == null) {
      return null;
    }
    final PsiFileSystemItem target = getReferenceSet(include).resolve();
    if (target instanceof PsiFile) {
      return (PsiFile)target;
    }
    // check current dir
    PsiFile psiFile = include.getContainingFile();
    if (psiFile == null) {
      return null;
    }
    PsiDirectory directory = psiFile.getContainingDirectory();
    final String includePath = include.getPath();
    PsiFile fileInDir = directory != null ? directory.findFile(PathUtil.getFileName(includePath)) : null;
    if (fileInDir != null) {
      return fileInDir;
    }


    final VirtualFile includedVirtualFile = ContainerUtil.find(
      FilenameIndex.getVirtualFilesByName(
        PathUtil.getFileName(includePath),
        GlobalSearchScope.allScope(include.getProject())
      ), file -> file.getPath().endsWith(includePath)
    );

    return includedVirtualFile != null ? include.getManager().findFile(includedVirtualFile) : null;
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
    String text = type.getText();
    int index = text.lastIndexOf(".");
    if (index == -1) {
      return new PsiReference[]{new ThriftTypeReference(type, 0)};
    }
    else {
      return new PsiReference[]{
        new ThriftPrefixReference(type, index),
        new ThriftTypeReference(type, index + 1)
      };
    }
  }

  @Nullable
  public static ThriftDefinitionName findDeclaration(@NotNull final String name, @Nullable PsiFile containingFile) {
    if (containingFile == null) {
      return null;
    }
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

  public static void processDeclarations(@Nullable PsiFile psiFile, @NotNull Processor<ThriftDeclaration> processor) {
    processElements(psiFile, processor, ThriftDeclaration.class);
  }

  @Nullable
  public static ThriftInclude findImportByPrefix(@NotNull PsiFile psiFile, @NotNull final String fileName) {
    final Ref<ThriftInclude> result = new Ref<ThriftInclude>();
    processIncludes(psiFile, new Processor<ThriftInclude>() {
      @Override
      public boolean process(ThriftInclude include) {
        String path = include.getPath();
        if (FileUtil.getNameWithoutExtension(new File(path)).equals(fileName)) {
          result.set(include);
          return false;
        }
        return true;
      }
    });
    return result.get();
  }

  public static void processIncludes(@Nullable PsiFile psiFile, @NotNull Processor<ThriftInclude> processor) {
    processElements(psiFile, processor, ThriftInclude.class);
  }

  public static <T> void processElements(@Nullable PsiFile psiFile, @NotNull Processor<T> processor, Class<? extends T> clazz) {
    if (psiFile == null) {
      return;
    }
    for (PsiElement child : psiFile.getChildren()) {
      if (clazz.isInstance(child) && !processor.process((T)child)) {
        break;
      }
    }
  }

  @NotNull
  public static List<NavigatablePsiElement> findImplementations(ThriftDefinitionName definitionName) {
    final List<NavigatablePsiElement> implementations = new ArrayList<NavigatablePsiElement>();
    processImplementations(definitionName, new Processor<NavigatablePsiElement>() {
      @Override
      public boolean process(NavigatablePsiElement element) {
        implementations.add(element);
        return true;
      }
    });
    return implementations;
  }

  public static void processImplementations(ThriftDefinitionName definitionName, @NotNull Processor<NavigatablePsiElement> processor) {
    String name = definitionName.getText();
    for (ChooseByNameContributor contributor : ChooseByNameRegistry.getInstance().getClassModelContributors()) {
      if (!(contributor instanceof ThriftClassContributor)) {
        for (NavigationItem navigationItem : contributor.getItemsByName(name, name, definitionName.getProject(), false)) {
          if (navigationItem instanceof NavigatablePsiElement && !processor.process((NavigatablePsiElement)navigationItem)) {
            return;
          }
        }
      }
    }
  }

  @NotNull
  public static PsiElement setName(@NotNull ThriftDefinitionName definitionName, String name) {
    PsiElement child = definitionName.getFirstChild();
    if (child instanceof LeafPsiElement) {
      ((LeafPsiElement)child).replaceWithText(name);
    }
    return definitionName;
  }

  @Nullable
  @NonNls
  public static String getName(@NotNull ThriftDefinitionName definitionName) {
    return definitionName.getText();
  }

  @NotNull
  public static PsiElement getNameIdentifier(@NotNull ThriftDefinitionName definitionName) {
    return definitionName;
  }
}
