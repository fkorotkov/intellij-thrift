package com.intellij.plugins.thrift.completion;

import com.intellij.plugins.thrift.ThriftCodeInsightFixtureTestCase;
import com.intellij.plugins.thrift.ThriftFileType;

/**
 * Created by fkorotkov.
 */
public class ThriftEditorCompletionTest extends ThriftCodeInsightFixtureTestCase {
  @Override
  protected String getBasePath() {
    return "completion/editor";
  }

  public void testTypeParam(){
    myFixture.configureByText(ThriftFileType.INSTANCE, "service Foo {1: list<caret>}");
    myFixture.type('<');
    myFixture.checkResult("service Foo {1: list<<caret>>}");
  }
}
