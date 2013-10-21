package com.intellij.plugins.thrift.completion;

import com.intellij.plugins.thrift.ThriftFileType;

/**
 * Created by fkorotkov.
 */
public class ThriftReferenceCompletionTest extends ThriftCompletionTestBase {
  public ThriftReferenceCompletionTest() {
    super("completion/reference");
  }

  public void testInclude() throws Throwable {
    myFixture.addFileToProject("bar.thrift", "");
    myFixture.addFileToProject("baz.thrift", "");
    myFixture.configureByText(ThriftFileType.INSTANCE, "include 'b<caret>'");
    myFixture.completeBasic();
    checkCompletion(CheckType.INCLUDES, "bar.thrift", "baz.thrift");
  }

  public void testSameFile() throws Throwable {
    doTest();
  }

  public void testIncludedFile() throws Throwable {
    myFixture.copyFileToProject("sameFile.thrift", "util/included.thrift");
    doTest();
  }
}
