package com.intellij.plugins.thrift.completion;

import com.intellij.plugins.thrift.ThriftFileType;

/**
 * Created by fkorotkov.
 */
public class ThriftReferenceCompletionTest extends ThriftCompletionTestBase {
  public ThriftReferenceCompletionTest() {
    super("completion/reference");
  }

  public void testInclude1() throws Throwable {
    myFixture.addFileToProject("bar.thrift", "");
    myFixture.addFileToProject("baz.thrift", "");
    myFixture.configureByText(ThriftFileType.INSTANCE, "include 'b<caret>'");
    myFixture.completeBasic();
    checkCompletion(CheckType.INCLUDES, "bar.thrift", "baz.thrift");
  }

  public void testInclude2() throws Throwable {
    myFixture.addFileToProject("foo/bar.thrift", "");
    myFixture.addFileToProject("foo/baz.thrift", "");
    myFixture.configureByText(ThriftFileType.INSTANCE, "include 'foo/b<caret>'");
    myFixture.completeBasic();
    checkCompletion(CheckType.INCLUDES, "bar.thrift", "baz.thrift");
  }

  public void testInclude3() throws Throwable {
    myFixture.addFileToProject("foo/bar.thrift", "");
    myFixture.addFileToProject("foo/baz.thrift", "");
    myFixture.configureByFile("include/includeRelative1.thrift");
    myFixture.completeBasic();
    checkCompletion(CheckType.INCLUDES, "bar.thrift", "baz.thrift");
  }

  public void testInclude4() throws Throwable {
    myFixture.addFileToProject("include/bar.thrift", "");
    myFixture.addFileToProject("include/baz.thrift", "");
    myFixture.configureByFile("include/includeRelative2.thrift");
    myFixture.completeBasic();
    checkCompletion(CheckType.INCLUDES, "bar.thrift", "baz.thrift");
  }

  public void testExtends() throws Throwable {
    doTest();
  }

  public void testSameFile() throws Throwable {
    doTest();
  }

  public void testIncludedFile() throws Throwable {
    myFixture.copyFileToProject("sameFile.thrift", "util/included.thrift");
    doTest();
  }
}
