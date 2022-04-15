package com.intellij.plugins.thrift.jps;

import com.intellij.plugins.thrift.config.ThriftCompilerOptions;
import com.intellij.util.xmlb.XmlSerializer;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.jps.model.JpsElement;
import org.jetbrains.jps.model.module.JpsModule;
import org.jetbrains.jps.model.serialization.facet.JpsFacetConfigurationSerializer;

/**
 * 11.07.2014 09:38
 *
 * @author xBlackCat
 */
public class ThriftFacetConfigurationSerializer extends JpsFacetConfigurationSerializer<ThriftCompilerOptions> {
  public ThriftFacetConfigurationSerializer() {
    super(ThriftCompilerOptions.ROLE, "thrift", "Apache Thrift");
  }

  @Override
  protected ThriftCompilerOptions loadExtension(@NotNull Element facetConfigurationElement,
                                                String name,
                                                JpsElement parent,
                                                JpsModule module) {
    ThriftCompilerOptions configuration = XmlSerializer.deserialize(
      facetConfigurationElement,
      ThriftCompilerOptions.class
    );

    if (configuration == null) {
      configuration = new ThriftCompilerOptions();
    }

    return configuration;
  }
}
