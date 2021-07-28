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
    myFixture.configureByText(ThriftFileType.INSTANCE, "struct Foo {1: list<caret>}");
    myFixture.type('<');
    myFixture.checkResult("struct Foo {1: list<<caret>>}");
  }

  public void testExistingClosingBrace1(){
    myFixture.configureByText(ThriftFileType.INSTANCE, "struct Foo {1: list<Foo<caret>>}");
    myFixture.type('>');
    myFixture.checkResult("struct Foo {1: list<Foo><caret>}");
  }

  public void testExistingClosingBrace2(){
    myFixture.configureByText(ThriftFileType.INSTANCE, "struct Foo {1: list<Foo<caret>> list}");
    myFixture.type('>');
    myFixture.checkResult("struct Foo {1: list<Foo><caret> list}");
  }

  // todo: ignored for now since it stopped working in 2021.2
  private void _testExistingCurlyBrace(){
    myFixture.configureByText(ThriftFileType.INSTANCE, "service Foo {<caret>}");
    myFixture.type('}');
    myFixture.checkResult("service Foo {}<caret>");
  }
}
