package com.intellij.plugins.thrift.quickfix;

import com.intellij.codeInsight.intention.impl.BaseIntentionAction;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.plugins.thrift.ThriftLanguage;
import com.intellij.plugins.thrift.lang.psi.ThriftCustomType;
import com.intellij.plugins.thrift.lang.psi.ThriftTopLevelDeclaration;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.PsiReference;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;

public class ThriftCreateCustomTypeQuickFix extends BaseIntentionAction {

  private final ThriftCustomType type;

  public ThriftCreateCustomTypeQuickFix(ThriftCustomType key) {
    this.type = key;
  }

  @NotNull
  @Override
  public String getText() {
    return "Create type '" + type.getText() + "'";
  }


  @NotNull
  @Override
  public String getFamilyName() {
    return "Create type";
  }

  @Override
  public boolean isAvailable(@NotNull Project project, Editor editor, PsiFile file) {
    return true;
  }

  @Override
  public void invoke(@NotNull Project project, Editor editor, PsiFile file) throws IncorrectOperationException {
    ApplicationManager.getApplication().invokeLater(() -> {
      WriteCommandAction.writeCommandAction(project).run(() -> {
        PsiReference[] references = type.getReferences();


        if (references.length == 1) {
          PsiElement newFile = PsiFileFactory.
                  getInstance(project).
                  createFileFromText(ThriftLanguage.INSTANCE, String.format("\nstruct %s {}", type.getText()));

          PsiElement topLevelDeclaration = type;
          while (!(topLevelDeclaration instanceof ThriftTopLevelDeclaration)) {
            topLevelDeclaration = topLevelDeclaration.getParent();
          }

          PsiElement struct = file.addAfter(newFile.getLastChild(), topLevelDeclaration);
          file.addBefore(newFile.getFirstChild(), struct); // new line

          FileEditorManager.getInstance(project).getSelectedTextEditor().getCaretModel().moveToOffset(struct.getTextOffset()+9+type.getText().length());
        } else {
          String typeName = references[1].getRangeInElement().substring(type.getText());

          PsiFile newFile = PsiFileFactory.
                  getInstance(project).
                  createFileFromText(ThriftLanguage.INSTANCE, String.format("\nstruct %s {}", typeName));

          PsiElement importFile = references[0].resolve();

          if (importFile != null) {
            PsiElement struct = importFile.add(newFile.getLastChild());
            importFile.addBefore(newFile.getFirstChild(), struct);

            FileEditorManager.getInstance(project).openFile(((PsiFile) importFile).getVirtualFile(), true);
            FileEditorManager.getInstance(project).getSelectedTextEditor().getCaretModel().moveToOffset(struct.getTextOffset()+9+typeName.length());
          }
        }
      });
    });
  }
}
