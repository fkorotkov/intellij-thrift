package com.intellij.plugins.thrift.completion;

import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.openapi.util.text.CharFilter;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.plugins.thrift.ThriftCodeInsightFixtureTestCase;
import com.intellij.testFramework.UsefulTestCase;

import java.util.*;

/**
 * Created by fkorotkov.
 */
abstract public class ThriftCompletionTestBase extends ThriftCodeInsightFixtureTestCase {
  enum CheckType {EQUALS, INCLUDES, EXCLUDES}

  private final String myPath;

  public ThriftCompletionTestBase(String... path) {
    myPath = getPath(path);
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

  protected void doTest() throws Throwable {
    myFixture.configureByFile(getTestName(true) + ".thrift");
    doTestVariantsInner(getTestName(true) + ".txt");
  }

  protected void doTest(char charToType) {
    myFixture.configureByFile(getTestName(true) + ".thrift");
    myFixture.type(charToType);
    myFixture.checkResultByFile(getTestName(true) + ".txt");
  }

  protected void doTestVariantsInner(String fileName) throws Throwable {
    final VirtualFile virtualFile = myFixture.copyFileToProject(fileName);
    final Scanner in = new Scanner(virtualFile.getInputStream());

    final CompletionType type = CompletionType.valueOf(in.next());
    final int count = in.nextInt();
    final CheckType checkType = CheckType.valueOf(in.next());

    final List<String> variants = new ArrayList<String>();
    while (in.hasNext()) {
      final String variant = StringUtil.strip(in.next(), CharFilter.NOT_WHITESPACE_FILTER);
      if (variant.length() > 0) {
        variants.add(variant);
      }
    }

    myFixture.complete(type, count);
    checkCompletion(checkType, variants);
  }

  protected void checkCompletion(CheckType checkType, String... variants) {
    checkCompletion(checkType, new ArrayList<String>(Arrays.asList(variants)));
  }

  protected void checkCompletion(CheckType checkType, List<String> variants) {
    List<String> stringList = myFixture.getLookupElementStrings();
    if (stringList == null) {
      stringList = Collections.emptyList();
    }

    if (checkType == CheckType.EQUALS) {
      UsefulTestCase.assertSameElements(stringList, variants);
    }
    else if (checkType == CheckType.INCLUDES) {
      variants.removeAll(stringList);
      assertTrue("Missing variants: " + variants, variants.isEmpty());
    }
    else if (checkType == CheckType.EXCLUDES) {
      variants.retainAll(stringList);
      assertTrue("Unexpected variants: " + variants, variants.isEmpty());
    }
  }
}
