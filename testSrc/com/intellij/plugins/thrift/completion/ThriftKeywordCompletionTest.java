package com.intellij.plugins.thrift.completion;

/**
 * Created by fkorotkov.
 */
public class ThriftKeywordCompletionTest extends ThriftCompletionTestBase {
  public ThriftKeywordCompletionTest() {
    super("completion/keyword");
  }

  public void testEmpty() throws Throwable {
    doTest();
  }

  public void testTopLevelAfterDefinition() throws Throwable {
    doTest();
  }

  public void testType() throws Throwable {
    doTest();
  }

  public void testField() throws Throwable {
    doTest();
  }
}
