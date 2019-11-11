package com.intellij.plugins.thrift;

import com.intellij.openapi.util.IconLoader;
import com.intellij.plugins.thrift.config.target.GeneratorType;

import javax.swing.*;
import java.util.HashMap;
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

  private Map<GeneratorType, IconLoader.LazyIcon> icons = new HashMap<GeneratorType, IconLoader.LazyIcon>();

  private GeneratorIcons() {

    for (final GeneratorType generatorType : GeneratorType.values()) {
      IconLoader.LazyIcon lazyIcon = new IconLoader.LazyIcon() {
        @Override
        protected Icon compute() {
          return IconLoader.getIcon(generatorType.getIconName());
        }
      };
      icons.put(generatorType, lazyIcon);
    }
  }
}
