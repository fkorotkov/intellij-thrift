package com.intellij.plugins.thrift;


import com.intellij.AbstractBundle;
import com.intellij.reference.SoftReference;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.PropertyKey;

import java.lang.ref.Reference;
import java.util.Enumeration;
import java.util.ResourceBundle;

/**
 * Created by fkorotkov.
 */
public class ThriftBundle extends ResourceBundle {
  private static Reference<ResourceBundle> ourBundle;

  @NonNls
  private static final String BUNDLE = "ThriftBundle";

  public static String message(@PropertyKey(resourceBundle = BUNDLE) String key, Object... params) {
    return AbstractBundle.message(getBundle(), key, params);
  }

  private static ResourceBundle getBundle() {
    ResourceBundle bundle = null;

    if (ourBundle != null) bundle = ourBundle.get();

    if (bundle == null) {
      bundle = ResourceBundle.getBundle(BUNDLE);
      ourBundle = new SoftReference<ResourceBundle>(bundle);
    }
    return bundle;
  }

  @Override
  protected Object handleGetObject(@NotNull String key) {
    return ourBundle.get().getObject(key);
  }

  @NotNull
  @Override
  public Enumeration<String> getKeys() {
    return ourBundle.get().getKeys();
  }
}
