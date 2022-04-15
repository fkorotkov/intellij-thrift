package com.intellij.plugins.thrift;

import com.intellij.openapi.util.IconLoader;
import com.intellij.plugins.thrift.config.target.GeneratorType;

import javax.swing.*;
import java.util.EnumMap;
import java.util.Map;

public final class GeneratorIcons {

  public static Icon getIcon(GeneratorType generatorType) {
    return LazyHolder.INSTANCE.getIconInstance(generatorType);
  }

  private Icon getIconInstance(GeneratorType generatorType) {
    return this.icons.get(generatorType);
  }

  private static class LazyHolder {
    static final GeneratorIcons INSTANCE = new GeneratorIcons();
  }

  private final Map<GeneratorType, Icon> icons = new EnumMap<>(GeneratorType.class);

  private GeneratorIcons() {

    for (final GeneratorType generatorType : GeneratorType.values()) {
      Icon lazyIcon = IconLoader.createLazy(() -> IconLoader.getIcon(generatorType.getIconName(), GeneratorIcons.class));
      icons.put(generatorType, lazyIcon);
    }
  }
}
