package com.intellij.plugins.thrift.completion;

import com.intellij.codeInsight.editorActions.TypedHandlerDelegate;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.project.Project;
import com.intellij.plugins.thrift.ThriftLanguage;
import com.intellij.plugins.thrift.lang.psi.ThriftGenericType;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

/**
 * Created by fkorotkov.
 */
public class ThriftTypeHandler extends TypedHandlerDelegate {
  @Override
  public Result beforeCharTyped(char c, Project project, Editor editor, PsiFile file, FileType fileType) {
    if (!isThriftContext(file)) {
      return super.charTyped(c, project, editor, file);
    }
    if (c == '>') {
      int offset = editor.getCaretModel().getOffset();
      final char charAtOffset = editor.getDocument().getCharsSequence().charAt(offset);
      final PsiElement elementAtOffset = file.findElementAt(offset);
      if (charAtOffset == '>' && elementAtOffset != null && elementAtOffset.getParent() instanceof ThriftGenericType) {
        editor.getCaretModel().moveToOffset(offset + 1);
        return Result.STOP;
      }
    }
    return super.beforeCharTyped(c, project, editor, file, fileType);
  }

  @Override
  public Result charTyped(char c, Project project, @NotNull Editor editor, @NotNull PsiFile file) {
    if (!isThriftContext(file)) {
      return super.charTyped(c, project, editor, file);
    }
    if (c == '<') {
      int offset = editor.getCaretModel().getOffset();
      editor.getDocument().insertString(offset, ">");
      editor.getCaretModel().moveToOffset(offset);
      return Result.STOP;
    }
    return super.charTyped(c, project, editor, file);
  }

  private static boolean isThriftContext(PsiFile file) {
    return file.getLanguage() instanceof ThriftLanguage;
  }
}
