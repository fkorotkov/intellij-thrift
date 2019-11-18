package com.intellij.plugins.thrift.config.target;

/**
 * 24.06.2014 15:53
 *
 * @author xBlackCat
 */
public interface IGenerator {
  GeneratorType getType();

  String getOutputDir();

  String getOptionsString();
}
