package com.intellij.plugins.thrift;

import com.intellij.navigation.ChooseByNameContributor;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.project.Project;
import com.intellij.plugins.thrift.index.ThriftDeclarationIndex;
import com.intellij.plugins.thrift.lang.psi.ThriftDeclaration;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.ArrayUtil;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created by fkorotkov.
 */
public class ThriftClassContributor implements ChooseByNameContributor {
  @NotNull
  @Override
  public String[] getNames(Project project, boolean includeNonProjectItems) {
    return ArrayUtil.toStringArray(ThriftDeclarationIndex.findAllKeys(project, getScope(project, includeNonProjectItems)));
  }

  @NotNull
  @Override
  public NavigationItem[] getItemsByName(String name, String pattern, Project project, boolean includeNonProjectItems) {
    List<ThriftDeclaration> declarations = ThriftDeclarationIndex.findDeclaration(name, project, getScope(project, includeNonProjectItems));
    return declarations.toArray(new NavigationItem[declarations.size()]);
  }

  private GlobalSearchScope getScope(Project project, boolean includeNonProjectItems) {
    return includeNonProjectItems ? GlobalSearchScope.allScope(project) : GlobalSearchScope.projectScope(project);
  }
}
