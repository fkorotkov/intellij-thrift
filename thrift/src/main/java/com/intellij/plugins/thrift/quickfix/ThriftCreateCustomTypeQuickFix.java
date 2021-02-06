package com.intellij.plugins.thrift.quickfix;

import com.intellij.codeInsight.intention.impl.BaseIntentionAction;
import com.intellij.ide.util.EditSourceUtil;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.plugins.thrift.lang.ThriftElementFactory;
import com.intellij.plugins.thrift.lang.psi.*;
import com.intellij.plugins.thrift.util.ThriftPsiUtil;
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

  public void addType(@NotNull Project project, @NotNull PsiElement after, String name) {
    boolean isException = PsiTreeUtil.getParentOfType(type, ThriftThrows.class) != null;

    PsiElement newElement;
    if (isException) {
      newElement = ThriftElementFactory.createExceptionFromText(project, String.format("exception %s {}", name));
    } else {
      newElement = ThriftElementFactory.createStructFromText(project, String.format("struct %s {}", name));
    }

    newElement = after.getParent().addAfter(newElement, after);
    after.getParent().addBefore(ThriftElementFactory.createNewLine(project), newElement);

    PsiElement body = PsiTreeUtil.findChildOfType(newElement, ThriftDeclarationBody.class);
    Navigatable newElementDescriptor = EditSourceUtil.getDescriptor(body);
    if (newElementDescriptor != null) newElementDescriptor.navigate(true);
  }

  @Override
  public void invoke(@NotNull Project project, Editor editor, PsiFile file) throws IncorrectOperationException {
    ApplicationManager.getApplication().invokeLater(() -> {
      WriteCommandAction.writeCommandAction(project).run(() -> {
        PsiReference[] references = type.getReferences();
        if (references.length == 1) {
          ThriftTopLevelDeclaration topLevelDeclaration = PsiTreeUtil.getParentOfType(type, ThriftTopLevelDeclaration.class);
          addType(project, topLevelDeclaration, type.getText());
        } else {
          PsiElement importFile = references[0].resolve();

          if (importFile == null) {
            throw new IncorrectOperationException("can't resolve import");
          }

          String typeName = references[1].getRangeInElement().substring(type.getText());
          addType(project, importFile.getLastChild(), typeName);


        }
      });
    });
  }
}
