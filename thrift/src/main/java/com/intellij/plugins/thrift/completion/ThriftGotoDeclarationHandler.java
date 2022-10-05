package com.intellij.plugins.thrift.completion;

import com.intellij.codeInsight.navigation.actions.GotoDeclarationHandler;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.plugins.thrift.index.ThriftDeclarationIndex;
import com.intellij.plugins.thrift.lang.psi.ThriftDeclaration;
import com.intellij.psi.*;
import com.intellij.psi.search.GlobalSearchScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.plugins.scala.lang.psi.api.base.ScReference;
import org.jetbrains.plugins.scala.lang.resolve.ScalaResolveResult;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThriftGotoDeclarationHandler implements GotoDeclarationHandler {

    @NotNull
    private List<ThriftDeclaration> getThriftDeclarations(List<String> fullyQualifiedNames, Project project) {
        return fullyQualifiedNames.stream()
                .filter(name -> getElementName(name) != null && getPackageName(name) != null)
                .map(name -> ThriftDeclarationIndex.findDeclaration(getElementName(name), getPackageName(name), project, GlobalSearchScope.allScope(project)))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @Override
    public PsiElement @Nullable [] getGotoDeclarationTargets(@Nullable PsiElement sourceElement, int offset, Editor editor) {
        if(sourceElement == null) {
            return null;
        }

        PsiFile containingFile = sourceElement.getContainingFile();
        if(containingFile == null) {
            return null;
        }
        PsiReference psiReference = containingFile.findReferenceAt(sourceElement.getTextRange().getStartOffset());
        List<String> fullyQualifiedNames = Collections.emptyList();

        if (psiReference instanceof PsiJavaCodeReferenceElement) {
            fullyQualifiedNames = Arrays.stream(((PsiJavaCodeReferenceElement) psiReference).multiResolve(/*incompleteCode = */ false))
                    .map(ResolveResult::getElement)
                    .filter(javaResolveResult -> javaResolveResult instanceof PsiClass)
                    .map(javaResolveResult -> ((PsiClass) javaResolveResult).getQualifiedName())
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } else if (psiReference instanceof ScReference){
            fullyQualifiedNames = Stream.of(((ScReference) psiReference).multiResolveScala(/*incompleteCode = */ false))
                    .map(ScalaResolveResult::qualifiedNameId)
                    .filter(Objects::nonNull)
                    .map(qualifiedName -> qualifiedName.substring(qualifiedName.lastIndexOf(":") + 1))
                    .distinct()
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

    private String getPackageName(String qualifiedName) {
        int lastIndexOf = qualifiedName.lastIndexOf(".");
        if(lastIndexOf >= 0) {
            return qualifiedName.substring(0, lastIndexOf);
        }
        return null;
    }

    private String getElementName(String qualifiedName) {
        int lastIndexOf = qualifiedName.lastIndexOf(".");
        if(lastIndexOf >= 0) {
            return qualifiedName.substring(lastIndexOf + 1);
        }
        return null;
    }
}
