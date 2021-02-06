package com.intellij.plugins.thrift.inspections;

public class NameDuplicatesTest extends ThriftInspectionTestBase {
  public NameDuplicatesTest() {
    super("inspections/duplicates/name", ThriftNameDuplicatesInspection.class);

  }

  public void testSenum() {
    doTest();
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

  public void testServiceMethodName() {
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