package com.intellij.plugins.thrift.resolve;

import com.intellij.codeInsight.TargetElementUtilBase;
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

  protected void doTest(int expectedSize) {
    PsiFile file = myFixture.getFile();
    assertNotNull(file);
    PsiReference reference = file.findReferenceAt(myFixture.getCaretOffset());
    assertNotNull("no reference", reference);
    final Collection<PsiElement> elements = TargetElementUtilBase.getInstance().getTargetCandidates(reference);
    assertNotNull(elements);
    assertEquals(expectedSize, elements.size());
  }

  public void testInclude() {
    myFixture.addFileToProject("foo.thrift", "");
    myFixture.configureByText(ThriftFileType.INSTANCE, "include 'foo<caret>.thrift'");
    doTest(1);
  }
}
