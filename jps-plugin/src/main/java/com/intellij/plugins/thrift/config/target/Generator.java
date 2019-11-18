package com.intellij.plugins.thrift.config.target;

import com.intellij.openapi.vfs.VirtualFile;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/**
 * 24.06.2014 10:24
 *
 * @author xBlackCat
 */
public class Generator implements IGenerator, Cloneable, Serializable {
  private String outputDir;
  private GeneratorType type;

  public Generator() {
  }

  protected Generator(GeneratorType myType) {
    this.type = myType;
  }

  public void setOutputDir(String outputDir) {
    this.outputDir = outputDir;
  }

  @Override
  public GeneratorType getType() {
    return type;
  }

  public void setType(GeneratorType type) {
    this.type = type;
  }

  @Override
  public String getOutputDir() {
    return outputDir;
  }

  @Override
  public String getOptionsString() {
    StringBuilder line = new StringBuilder();
    line.append(type.name);

    Collection<String> options = getOptions();
    if (options != null && !options.isEmpty()) {
      line.append(':');
      Iterator<String> it = options.iterator();
      line.append(it.next());
      while (it.hasNext()) {
        line.append(',');
        line.append(it.next());
      }
    }

    return line.toString();
  }

  protected Collection<String> getOptions() {
    return null;
  }

  @Override
  public Generator clone() throws CloneNotSupportedException {
    return (Generator)super.clone();
  }

  public static final class Arg {
    public static final Arg[] NO_ARGS = new Arg[0];

    public static Arg bool(String name) {
      return new Arg(name, boolean.class);
    }

    public static Arg string(String name) {
      return new Arg(name, String.class);
    }

    public static Arg file(String name) {
      return new Arg(name, VirtualFile.class);
    }

    private final String name;
    private final Class<?> type;

    public Arg(String name, Class<?> type) {
      this.name = name;
      this.type = type;
    }

    public String getName() {
      return name;
    }

    public Class<?> getType() {
      return type;
    }
  }
}
