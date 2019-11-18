package com.intellij.plugins.thrift.rename;

import com.intellij.plugins.thrift.ThriftCodeInsightFixtureTestCase;

public class ThriftRenameTest extends ThriftCodeInsightFixtureTestCase {
  @Override
  protected String getBasePath() {
    return "rename";
  }

  public void doTest(String newName, String... additionalFiles) {
    myFixture.testRename(getTestName(true) + ".thrift", getTestName(true) + "_after.thrift", newName, additionalFiles);
  }

  public void testLocalType1() {
    doTest("Foo");
  }

  public void testLocalType2() {
    doTest("Foo");
  }
}
