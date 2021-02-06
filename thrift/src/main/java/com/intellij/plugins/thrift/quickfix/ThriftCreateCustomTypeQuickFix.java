package com.intellij.plugins.thrift.quickfix;

import com.intellij.codeInsight.intention.impl.BaseIntentionAction;
import com.intellij.ide.util.EditSourceUtil;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.plugins.thrift.lang.ThriftElementFactory;
import com.intellij.plugins.thrift.lang.psi.ThriftCustomType;
import com.intellij.plugins.thrift.lang.psi.ThriftTopLevelDeclaration;
import com.intellij.pom.Navigatable;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReference;
import com.intellij.psi.util.PsiTreeUtil;
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

        PsiElement createdStruct;
        if (references.length == 1) {
          PsiElement newStruct = ThriftElementFactory.createStructFromText(project, String.format("struct %s {}", type.getText()));

          ThriftTopLevelDeclaration topLevelDeclaration = PsiTreeUtil.getParentOfType(type, ThriftTopLevelDeclaration.class);

          createdStruct = file.addAfter(newStruct, topLevelDeclaration);
        } else {
          String typeName = references[1].getRangeInElement().substring(type.getText());

          PsiElement newStruct = ThriftElementFactory.createStructFromText(project, String.format("struct %s {}", typeName));
          PsiElement importFile = references[0].resolve();

          if (importFile == null) {
              throw new IncorrectOperationException("can't resolve import");
          }

          createdStruct = importFile.add(newStruct);
        }

        createdStruct.getParent().addBefore(ThriftElementFactory.createNewLine(project), createdStruct);

        Navigatable addedElementDescriptor = EditSourceUtil.getDescriptor(createdStruct);

        if (addedElementDescriptor != null) addedElementDescriptor.navigate(true);
      });
    });
  }
}
