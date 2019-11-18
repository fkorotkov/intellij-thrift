package com.intellij.plugins.thrift.config.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import com.intellij.openapi.module.Module;

/**
 * 15.07.2014 12:08
 *
 * @author xBlackCat
 */
public class ThriftFacet extends Facet<ThriftFacetConf> {
  public static final String NAME = "thrift";
  public static final String DISPLAY_NAME = "Thrift";
  public static final FacetTypeId<ThriftFacet> ID = new FacetTypeId<ThriftFacet>(NAME);
  public static final ThriftFacetType TYPE = new ThriftFacetType();

  public ThriftFacet(Module module,
                     String name,
                     ThriftFacetConf configuration, Facet underlyingFacet) {
    super(TYPE, module, name, configuration, underlyingFacet);
  }
}
