package com.intellij.plugins.thrift.usages;

import com.intellij.openapi.actionSystem.DataProvider;
import com.intellij.openapi.editor.ex.EditorEx;
import com.intellij.plugins.thrift.ThriftCodeInsightFixtureTestCase;
import com.intellij.usageView.UsageInfo;
import com.intellij.usages.PsiElementUsageTarget;
import com.intellij.usages.UsageTarget;
import com.intellij.usages.UsageTargetUtil;
import org.jetbrains.annotations.NonNls;

import java.util.Collection;

public class ThriftFindUsagesTest extends ThriftCodeInsightFixtureTestCase {
  @Override
  protected String getBasePath() {
    return "usages";
  }


  protected void doTest(int size) throws Throwable {
    myFixture.configureByFile(getTestName(true) + ".thrift");
    final Collection<UsageInfo> elements = findUsages();
    assertNotNull(elements);
    assertEquals(size, elements.size());
  }

  private Collection<UsageInfo> findUsages() throws Throwable {
    final UsageTarget[] targets = UsageTargetUtil.findUsageTargets(new DataProvider() {
      @Override
      public Object getData(@NonNls String dataId) {
        return ((EditorEx)myFixture.getEditor()).getDataContext().getData(dataId);
      }
    });

    assert targets != null && targets.length > 0 && targets[0] instanceof PsiElementUsageTarget;
    return myFixture.findUsages(((PsiElementUsageTarget)targets[0]).getElement());
  }

  public void testUsages1() throws Throwable {
    doTest(2);
  }

  public void testUsages2() throws Throwable {
    doTest(2);
  }
}
