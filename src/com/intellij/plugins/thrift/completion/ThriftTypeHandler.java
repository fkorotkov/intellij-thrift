package com.intellij.plugins.thrift.completion;

import com.intellij.codeInsight.editorActions.TypedHandlerDelegate;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.plugins.thrift.ThriftLanguage;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

/**
 * Created by fkorotkov.
 */
public class ThriftTypeHandler extends TypedHandlerDelegate {
  @Override
  public Result charTyped(char c, Project project, @NotNull Editor editor, @NotNull PsiFile file) {
    if (c == '<' && file.getLanguage() instanceof ThriftLanguage) {
      int offset = editor.getCaretModel().getOffset();
      editor.getDocument().insertString(offset, ">");
      editor.getCaretModel().moveToOffset(offset);
      return Result.STOP;
    }
    return super.charTyped(c, project, editor, file);
  }
}
