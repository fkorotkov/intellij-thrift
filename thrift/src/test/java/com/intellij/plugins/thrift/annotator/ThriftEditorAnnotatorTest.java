package com.intellij.plugins.thrift.annotator;

import com.intellij.plugins.thrift.ThriftCodeInsightFixtureTestCase;

public class ThriftEditorAnnotatorTest extends ThriftCodeInsightFixtureTestCase {
  @Override
  protected String getBasePath() {
    return "annotator";
  }

  public void testTypeIsNotException(){
    myFixture.configureByFiles( "TypeIsNotException.thrift");
    myFixture.checkHighlighting(false, false, true);
  }
}
