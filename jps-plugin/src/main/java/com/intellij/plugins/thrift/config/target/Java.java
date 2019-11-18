package com.intellij.plugins.thrift.config.target;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 24.06.2014 12:10
 *
 * @author xBlackCat
 */ //Java
public class Java extends Generator {
  /**
   * Members will be private, and setter methods will return void.
   */
  private boolean beans;
  /**
   * Members will be private, but setter methods will return 'this' like usual.
   */
  private boolean privateMembers;
  /**
   * Do not use CamelCase field accessors with beans.
   */
  private boolean noCamel;
  /**
   * Generate quality hashCode methods.
   */
  private boolean hashCode;
  /**
   * Do not use java.io.IOException(throwable) (available for Android 2.3 and above).
   */
  private boolean androidLegacy;
  /**
   * Generate Java 1.5 compliant code (includes android_legacy flag).
   */
  private boolean java5;
  /**
   * Use TreeSet/TreeMap instead of HashSet/HashMap as a implementation of set/map.
   */
  private boolean sortedContainers;
  /**
   * Convert underscored_accessor_or_service_names to camelCase.
   */
  private boolean fullcamel;
  /**
   * Generated structures are Parcelable.
   */
  private boolean android;
  /**
   * Data objects will not be allocated, but existing instances will be used (read and write).
   */
  private boolean reuseObjects;

  /**
   * Generated annotations will be undated to avoid unnecessary changes in source tree
   */
  private boolean undatedAnnotations;

  protected Java() {
    super(GeneratorType.Java);
  }

  public void setBeans(boolean beans) {
    this.beans = beans;
  }

  public void setPrivateMembers(boolean privateMembers) {
    this.privateMembers = privateMembers;
  }

  public void setNoCamel(boolean noCamel) {
    this.noCamel = noCamel;
  }

  public void setHashCode(boolean hashCode) {
    this.hashCode = hashCode;
  }

  public void setAndroidLegacy(boolean androidLegacy) {
    this.androidLegacy = androidLegacy;
  }

  public void setJava5(boolean java5) {
    this.java5 = java5;
  }

  public void setSortedContainers(boolean sortedContainers) {
    this.sortedContainers = sortedContainers;
  }

  public void setFullcamel(boolean fullcamel) {
    this.fullcamel = fullcamel;
  }

  public void setAndroid(boolean android) {
    this.android = android;
  }

  public void setReuseObjects(boolean reuseObjects) {
    this.reuseObjects = reuseObjects;
  }

  public void setUndatedAnnotations(boolean undatedAnnotations) {
    this.undatedAnnotations = undatedAnnotations;
  }

  public boolean isBeans() {
    return beans;
  }

  public boolean isPrivateMembers() {
    return privateMembers;
  }

  public boolean isNoCamel() {
    return noCamel;
  }

  public boolean isHashCode() {
    return hashCode;
  }

  public boolean isAndroidLegacy() {
    return androidLegacy;
  }

  public boolean isJava5() {
    return java5;
  }

  public boolean isSortedContainers() {
    return sortedContainers;
  }

  public boolean isFullcamel() {
    return fullcamel;
  }

  public boolean isAndroid() {
    return android;
  }

  public boolean isReuseObjects() {
    return reuseObjects;
  }

  public boolean isUndatedAnnotations() {
    return undatedAnnotations;
  }

  @Override
  protected Collection<String> getOptions() {
    ArrayList<String> line = new ArrayList<String>();
    if (beans) {
      line.add("beans");
    }
    if (privateMembers) {
      line.add("private-members");
    }
    if (noCamel) {
      line.add("nocamel");
    }
    if (hashCode) {
      line.add("hashcode");
    }
    if (androidLegacy) {
      line.add("android_legacy");
    }
    if (java5) {
      line.add("java5");
    }
    if (sortedContainers) {
      line.add("sorted_containers");
    }
    if (fullcamel) {
      line.add("fullcamel");
    }
    if (android) {
      line.add("android");
    }
    if (reuseObjects) {
      line.add("reuse-objects");
    }
    if (undatedAnnotations) {
      line.add("generated_annotations=undated");
    }
    return line;
  }
}
