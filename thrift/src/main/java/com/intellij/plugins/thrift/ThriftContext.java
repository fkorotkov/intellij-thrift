package com.intellij.plugins.thrift;

import com.intellij.codeInsight.template.TemplateActionContext;
import com.intellij.codeInsight.template.TemplateContextType;
import org.jetbrains.annotations.NotNull;

public class ThriftContext extends TemplateContextType {

  protected ThriftContext() {
    super("THRIFT", "Thrift");
  }

  @Override
  public boolean isInContext(@NotNull TemplateActionContext templateActionContext) {
    return templateActionContext.getFile().getName().endsWith(".thrift");
  }

}