package com.intellij.plugins.thrift.inspections;

import com.intellij.codeInspection.LocalInspectionTool;
import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase;

abstract public class ThriftInspectionTestBase extends LightJavaCodeInsightFixtureTestCase {
  private final String myPath;
  Class<? extends LocalInspectionTool>  inspection;

  public ThriftInspectionTestBase(String path, Class<? extends LocalInspectionTool> inspection) {
    myPath = getPath(path);
    this.inspection = inspection;
  }

  private static String getPath(String... args) {
    final StringBuilder result = new StringBuilder();
    for (String folder : args) {
      result.append("/");
      result.append(folder);
    }
    return result.toString();
  }

  @Override
  protected String getBasePath() {
    return myPath;
  }

  @SuppressWarnings("unchecked")
  protected void doTest() {
    myFixture.enableInspections(this.inspection);
    myFixture.configureByFile(getTestName(true) + ".thrift");
    myFixture.checkHighlighting();
  }

}
