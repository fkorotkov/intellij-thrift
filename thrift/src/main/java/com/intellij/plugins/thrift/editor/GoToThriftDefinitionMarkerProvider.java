// Copyright 2020 Pants project contributors (see CONTRIBUTORS.md).
// Licensed under the Apache License, Version 2.0 (see LICENSE).

package com.intellij.plugins.thrift.editor;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Sets;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider;
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.plugins.thrift.ThriftBundle;
import com.intellij.plugins.thrift.index.ThriftDeclarationIndex;
import com.intellij.plugins.thrift.lang.psi.ThriftDeclaration;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiIdentifier;
import com.intellij.psi.PsiModifierList;
import com.intellij.psi.search.GlobalSearchScope;
import icons.ThriftIcons;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.*;

public class GoToThriftDefinitionMarkerProvider extends RelatedItemLineMarkerProvider {
  static Logger logger = Logger.getInstance(GoToThriftDefinition.class);

  private static Set<String> thriftStructBaseClasses =
      Sets.newHashSet(
          "org.apache.thrift.TBase",
          "org.apache.thrift.TEnum",
          "com.twitter.scrooge.ThriftStruct",
          "com.twitter.scrooge.ThriftEnum",
          "com.twitter.scrooge.ThriftUnion",
          "com.twitter.scrooge.ThriftException"
      );

  private boolean isThriftStruct(PsiClass element) {
    return Arrays
        .stream(element.getSupers())
        .anyMatch(superClass -> thriftStructBaseClasses.contains(superClass.getQualifiedName()))
        || element.getAnnotation("javax.annotation.Generated") != null;
  }

  @Override
  protected void collectNavigationMarkers(@NotNull PsiElement element,
                                          @NotNull Collection<? super RelatedItemLineMarkerInfo<?>> result) {
    if (element instanceof PsiClass && isThriftStruct((PsiClass)element)) {
      PsiClass psiClass = (PsiClass) element;
      String name = psiClass.getName();
      if (name != null) {
        Stopwatch stopWatch = Stopwatch.createStarted();
        List<ThriftDeclaration> thriftDefinitions =
            ThriftDeclarationIndex.findDeclaration(name, psiClass.getProject(),
                GlobalSearchScope.allScope(psiClass.getProject()));
        Duration time = stopWatch.elapsed();
        if (time.toMillis() > 20) {
          logger.warn("GoToThriftDefinition action update took " + time.toMillis() + "ms");
        }
        if (!thriftDefinitions.isEmpty()) {
          NavigationGutterIconBuilder<PsiElement> builder =
              NavigationGutterIconBuilder.create(ThriftIcons.STRUCT)
                  .setTargets(thriftDefinitions)
                  .setTooltipText(ThriftBundle.message("thrift.goto.source"));
          Optional<PsiElement> identifier =
              Arrays.stream(element.getChildren()).filter(x -> x instanceof PsiIdentifier).findFirst();
          // Some languages (Scala) don't put PsiIdentifier here, PsiModifierList is a fallback
          Optional<PsiElement> modifiersList =
              Arrays.stream(element.getChildren()).filter(x -> x instanceof PsiModifierList).findFirst();
          if (identifier.isPresent()) {
            result.add(builder.createLineMarkerInfo(identifier.get()));
          } else if (modifiersList.isPresent()) {
            result.add(builder.createLineMarkerInfo(modifiersList.get()));
          }
        }
      }
    }
  }
}
