package com.intellij.plugins.thrift.inspections;

public class IDDuplicatesTest extends ThriftInspectionTestBase {
  public IDDuplicatesTest() {
    super("inspections/duplicates/id", ThriftIDDuplicatesInspection.class);
  }

  public void testEnum() {
    doTest();
  }

  public void testException() {
    doTest();
  }

  public void testServiceMethodArg() {
    doTest();
  }

  public void testStruct() {
    doTest();
  }

  public void testThrow() {
    doTest();
  }

  public void testUnion() {
    doTest();
  }
}