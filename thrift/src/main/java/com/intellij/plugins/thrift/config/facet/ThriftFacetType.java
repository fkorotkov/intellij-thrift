package com.intellij.plugins.thrift.config.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetType;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.module.UnknownModuleType;
import icons.ThriftIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * 15.07.2014 12:09
 *
 * @author xBlackCat
 */
public class ThriftFacetType extends FacetType<ThriftFacet, ThriftFacetConf> {

  public ThriftFacetType() {
    super(ThriftFacet.ID, ThriftFacet.NAME, ThriftFacet.DISPLAY_NAME);
  }

  @Nullable
  @Override
  public Icon getIcon() {
    return ThriftIcons.FACET;
  }

  @Override
  public ThriftFacetConf createDefaultConfiguration() {
    return new ThriftFacetConf();
  }

  @Override
  public boolean isSuitableModuleType(ModuleType moduleType) {
    return !(moduleType instanceof UnknownModuleType);
  }

  @Override
  public ThriftFacet createFacet(@NotNull Module module, String name, @NotNull ThriftFacetConf configuration, Facet underlyingFacet) {
    return new ThriftFacet(module, name, configuration, underlyingFacet);
  }
}
