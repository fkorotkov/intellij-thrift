package com.intellij.plugins.thrift.index;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.plugins.thrift.ThriftFileType;
import com.intellij.plugins.thrift.lang.psi.ThriftDeclaration;
import com.intellij.plugins.thrift.lang.psi.ThriftTopLevelDeclaration;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.Processor;
import com.intellij.util.indexing.*;
import com.intellij.util.io.DataExternalizer;
import com.intellij.util.io.EnumeratorStringDescriptor;
import com.intellij.util.io.KeyDescriptor;
import gnu.trove.THashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by fkorotkov.
 */
public class ThriftSubDeclarationIndex extends FileBasedIndexExtension<String, String> {
  public static final ID<String, String> THRIFT_DECLARATION_INDEX = ID.create("ThriftSubDeclarationIndex");
  private final EnumeratorStringDescriptor myKeyDescriptor = new EnumeratorStringDescriptor();
  private final FileBasedIndex.InputFilter myFilter = new FileBasedIndex.InputFilter() {
    @Override
    public boolean acceptInput(VirtualFile file) {
      return file.getFileType() == ThriftFileType.INSTANCE;
    }
  };
  private static final ThriftSubDeclarationIndex.MyIndexer myIndexer = new MyIndexer();

  @NotNull
  @Override
  public ID<String, String> getName() {
    return THRIFT_DECLARATION_INDEX;
  }

  @NotNull
  @Override
  public DataIndexer<String, String, FileContent> getIndexer() {
    return myIndexer;
  }

  @NotNull
  @Override
  public KeyDescriptor<String> getKeyDescriptor() {
    return myKeyDescriptor;
  }

  @NotNull
  @Override
  public DataExternalizer<String> getValueExternalizer() {
    return myKeyDescriptor;
  }

  @NotNull
  @Override
  public FileBasedIndex.InputFilter getInputFilter() {
    return myFilter;
  }

  @Override
  public boolean dependsOnFileContent() {
    return true;
  }

  @Override
  public int getVersion() {
    return 2;
  }

  public static List<String> findAllKeys(Project project, GlobalSearchScope scope) {
    final List<String> result = new ArrayList<String>();
    FileBasedIndex.getInstance().processAllKeys(
      THRIFT_DECLARATION_INDEX,
      new Processor<String>() {
        @Override
        public boolean process(String name) {
          result.add(name);
          return true;
        }
      },
      scope,
      null
    );
    return result;
  }

  public static List<ThriftDeclaration> findDeclaration(@Nullable final String className,
                                                        @NotNull final String name,
                                                        @NotNull Project project,
                                                        @NotNull GlobalSearchScope scope) {
    final List<ThriftDeclaration> result = new ArrayList<ThriftDeclaration>();
    final PsiManager manager = PsiManager.getInstance(project);
    FileBasedIndex.getInstance().getFilesWithKey(
      THRIFT_DECLARATION_INDEX,
      Collections.singleton(name),
      new Processor<VirtualFile>() {
        @Override
        public boolean process(VirtualFile file) {
          PsiFile psiFile = manager.findFile(file);
          if (psiFile != null) {
            for (PsiElement child : psiFile.getChildren()) {
              if (!(child instanceof ThriftTopLevelDeclaration)) {
                continue;
              }
              if (className != null && !className.equals(((ThriftTopLevelDeclaration)child).getName())) {
                continue;
              }
              for (ThriftDeclaration declaration : ((ThriftTopLevelDeclaration)child).findSubDeclarations()) {
                String subName = declaration.getName();
                if (subName != null && name.equals(subName)) {
                  result.add(declaration);
                }
              }
            }
          }
          return true;
        }
      },
      scope
    );
    return result;
  }

  private static class MyIndexer implements DataIndexer<String, String, FileContent> {
    @NotNull
    @Override
    public Map<String, String> map(FileContent inputData) {
      Map<String, String> result = new THashMap<String, String>();
      for (PsiElement child : inputData.getPsiFile().getChildren()) {
        if (child instanceof ThriftTopLevelDeclaration) {
          String topLevelName = ((ThriftTopLevelDeclaration)child).getName();
          if (topLevelName != null) {
            for (ThriftDeclaration declaration : ((ThriftTopLevelDeclaration)child).findSubDeclarations()) {
              String subName = declaration.getName();
              if (subName != null) {
                result.put(subName, topLevelName);
              }
            }
          }
        }
      }

      return result;
    }
  }
}
