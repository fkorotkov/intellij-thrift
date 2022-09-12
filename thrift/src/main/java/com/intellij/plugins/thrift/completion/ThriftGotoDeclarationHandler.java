package com.intellij.plugins.thrift.completion;

import com.intellij.codeInsight.navigation.actions.GotoDeclarationHandler;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.plugins.thrift.index.ThriftDeclarationIndex;
import com.intellij.plugins.thrift.lang.psi.ThriftDeclaration;
import com.intellij.psi.*;
import com.intellij.psi.search.GlobalSearchScope;
import org.apache.commons.compress.utils.Lists;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.plugins.scala.lang.psi.api.base.ScReference;
import org.jetbrains.plugins.scala.lang.resolve.ScalaResolveResult;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThriftGotoDeclarationHandler implements GotoDeclarationHandler {

    @NotNull
    private List<ThriftDeclaration> getThriftDeclarations(List<String> fullyQualifiedNames, Project project) {
        try {
            return fullyQualifiedNames.stream()
                    .filter(name -> getElementName(name) != null && getPackageName(name) != null)
                    .map(name -> {
                            String elementName = getElementName(name);
                            String packageName = getPackageName(name);
                            return ThriftDeclarationIndex.findDeclaration(elementName, packageName, project, GlobalSearchScope.allScope(project));
                    })
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
        } catch (NoClassDefFoundError ignored) {}
        return Lists.newArrayList();
    }

    @Override
    public PsiElement @Nullable [] getGotoDeclarationTargets(@Nullable PsiElement sourceElement, int offset, Editor editor) {
        assert sourceElement != null;

        PsiFile containingFile = sourceElement.getContainingFile();
        PsiReference ref = containingFile.findReferenceAt(sourceElement.getTextRange().getStartOffset());
        List<String> fullyQualifiedNames = Collections.emptyList();

        if (ref instanceof PsiJavaCodeReferenceElement) {
            fullyQualifiedNames = Arrays.stream(((PsiJavaCodeReferenceElement) ref).multiResolve(false))
                    .map(ResolveResult::getElement)
                    .filter(javaResolveResult -> javaResolveResult instanceof PsiClass)
                    .map(javaResolveResult -> ((PsiClass) javaResolveResult).getQualifiedName())
                    .collect(Collectors.toList());
        } else if (ref instanceof ScReference){
            fullyQualifiedNames = Stream.of(((ScReference) ref).multiResolveScala(false))
                    .map(ScalaResolveResult::qualifiedNameId)
                    .map(qualifiedName -> qualifiedName.substring(qualifiedName.lastIndexOf(":") + 1))
                    .collect(Collectors.toList());
        }

        if(!fullyQualifiedNames.isEmpty()) {
            PsiElement[] thriftMatches = getThriftDeclarations(fullyQualifiedNames, sourceElement.getProject()).stream()
                    .map(PsiElement::getNavigationElement)
                    .toArray(PsiElement[]::new);
            if(thriftMatches.length > 0) {
                return thriftMatches;
            }
        }
        return null;
    }

    @Override
    public @Nullable @Nls(capitalization = Nls.Capitalization.Title) String getActionText(@NotNull DataContext context) {
        return GotoDeclarationHandler.super.getActionText(context);
    }

    private String getPackageName(String qualifiedName) {
        try {
            return qualifiedName.substring(0, qualifiedName.lastIndexOf("."));
        } catch (IndexOutOfBoundsException ex){
            return null;
        }
    }

    private String getElementName(String qualifiedName) {
        try {
            return qualifiedName.substring(qualifiedName.lastIndexOf(".") + 1);
        } catch (IndexOutOfBoundsException ex){
            return null;
        }
    }
}
