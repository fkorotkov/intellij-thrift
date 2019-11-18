package com.intellij.plugins.thrift.resolve;

import com.intellij.codeInsight.TargetElementUtil;
import com.intellij.plugins.thrift.ThriftCodeInsightFixtureTestCase;
import com.intellij.plugins.thrift.ThriftFileType;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReference;

import java.util.Collection;

/**
 * Created by fkorotkov.
 */
public class ThriftResolveTest extends ThriftCodeInsightFixtureTestCase {
  @Override
  protected String getBasePath() {
    return "resolve";
  }

  protected Collection<PsiElement> doTest(int expectedSize) {
    PsiFile file = myFixture.getFile();
    assertNotNull(file);
    PsiReference reference = file.findReferenceAt(myFixture.getCaretOffset());
    assertNotNull("no reference", reference);
    final Collection<PsiElement> elements = TargetElementUtil.getInstance().getTargetCandidates(reference);
    assertNotNull(elements);
    assertEquals(expectedSize, elements.size());
    return elements;
  }

  private void configureDefault() {
    myFixture.configureByFile(getTestName(true) + "." + ThriftFileType.DEFAULT_EXTENSION);
  }

  public void testInclude() {
    myFixture.addFileToProject("foo.thrift", "");
    myFixture.configureByText(ThriftFileType.INSTANCE, "include 'foo<caret>.thrift'");
    doTest(1);
  }

  public void testGlobalType1() {
    myFixture.addFileToProject("data.thrift", "struct Impression {}");
    configureDefault();
    doTest(1);
  }

  public void testGlobalType2() {
    myFixture.addFileToProject("util/data.thrift", "struct Impression {}");
    configureDefault();
    doTest(1);
  }

  public void testGlobalType3() {
    myFixture.addFileToProject("util/data.thrift", "struct Impression {}");
    configureDefault();
    Collection<PsiElement> elements = doTest(1);
    assertInstanceOf(elements.iterator().next(), PsiFile.class);
  }

  public void testGlobalType4() {
    myFixture.addFileToProject("data.thrift", "struct Impression {}");
    configureDefault();
    doTest(1);
  }

  public void testLocalType() {
    configureDefault();
    doTest(1);
  }
}
