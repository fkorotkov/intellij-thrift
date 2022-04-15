package com.intellij.plugins.thrift.config.facet;

import com.intellij.facet.ui.FacetBasedFrameworkSupportProvider;
import com.intellij.ide.util.frameworkSupport.FrameworkVersion;
import com.intellij.openapi.roots.ModifiableRootModel;

/**
 * 15.07.2014 16:16
 *
 * @author xBlackCat
 */
public class ThriftFacetSupportProvider extends FacetBasedFrameworkSupportProvider<ThriftFacet> {
  protected ThriftFacetSupportProvider() {
    super(ThriftFacet.TYPE);
  }

  @Override
  protected void setupConfiguration(ThriftFacet facet, ModifiableRootModel rootModel, FrameworkVersion version) {
    // Do nothing
  }
}
