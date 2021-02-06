package com.intellij.plugins.thrift.inspections;

public class TopLevelDeclarationDuplicatesTest extends ThriftInspectionTestBase {
  public TopLevelDeclarationDuplicatesTest() {
    super("inspections/duplicates/topLevelDeclaration", ThriftTopLevelDeclarationDuplicatesInspection.class);
  }

  public void testConst() {
    doTest();
  }

  public void testEnum() {
    doTest();
  }

  public void testException() {
    doTest();
  }

  public void testSenum() {
    doTest();
  }

  public void testService() {
    doTest();
  }

  public void testStruct() {
    doTest();
  }

  public void testTypedef() {
    doTest();
  }

  public void testUnion() {
    doTest();
  }
}