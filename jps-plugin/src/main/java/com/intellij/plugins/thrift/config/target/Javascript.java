package com.intellij.plugins.thrift.config.target;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 24.06.2014 12:10
 *
 * @author xBlackCat
 */ //JavaScript
public class Javascript extends Generator {
  /**
   * Generate jQuery compatible code.
   */
  private boolean jquery;
  /**
   * Generate node.js compatible code.
   */
  private boolean node;
  /**
   * Generate TypeScript definition files
   */
  private boolean ts;

  protected Javascript() {
    super(GeneratorType.JavaScript);
  }

  public void setJquery(boolean jquery) {
    this.jquery = jquery;
  }

  public void setNode(boolean node) {
    this.node = node;
  }

  public void setTs(boolean ts) {
    this.ts = ts;
  }

  public boolean isJquery() {
    return jquery;
  }

  public boolean isNode() {
    return node;
  }

  public boolean isTs() {
    return ts;
  }

  @Override
  protected Collection<String> getOptions() {
    ArrayList<String> line = new ArrayList<String>();

    if (jquery) {
      line.add("jquery");
    }
    if (node) {
      line.add("node");
    }
    if (ts) {
      line.add("ts");
    }

    return line;
  }
}
