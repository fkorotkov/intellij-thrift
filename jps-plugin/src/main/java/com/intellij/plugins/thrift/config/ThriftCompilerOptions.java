package com.intellij.plugins.thrift.config;

import com.intellij.plugins.thrift.config.target.*;
import com.intellij.util.xmlb.annotations.XCollection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.jps.model.JpsElementChildRole;
import org.jetbrains.jps.model.ex.JpsElementBase;
import org.jetbrains.jps.model.ex.JpsElementChildRoleBase;
import org.jetbrains.jps.model.module.JpsModule;

import java.util.ArrayList;
import java.util.List;

/**
 * Global configuration class: stores
 *
 * @author xBlackCat
 */
public class ThriftCompilerOptions extends JpsElementBase<ThriftCompilerOptions> {
  public static final JpsElementChildRole<ThriftCompilerOptions> ROLE = JpsElementChildRoleBase.create("Thrift compiler options");

  private List<Generator> generators = new ArrayList<Generator>();
  private List<String> includes = new ArrayList<String>();
  private boolean cleanOutput;

  public static ThriftCompilerOptions getSettings(JpsModule module) {
    final ThriftCompilerOptions config = module.getContainer().getChild(ROLE);

    return config == null ? new ThriftCompilerOptions() : config;
  }

  @XCollection(
    elementTypes = {AS3.class, Cocoa.class, Cpp.class, CSharp.class, Delphi.class, Erlang.class, Generator.class, Go.class, Graphviz.class,
      HTML.class, IGenerator.class, Java.class, Javascript.class, PHP.class, Python.class, Ruby.class}
  )
  public List<Generator> getGenerators() {
    return generators;
  }

  public List<String> getIncludes() {
    return includes;
  }

  public void setIncludes(List<String> includes) {
    this.includes = includes;
  }

  public void setGenerators(List<Generator> generators) {
    this.generators = generators;
  }

  public boolean isCleanOutput() {
    return cleanOutput;
  }

  public void setCleanOutput(boolean cleanOutput) {
    this.cleanOutput = cleanOutput;
  }

  @NotNull
  @Override
  public ThriftCompilerOptions createCopy() {
    final ThriftCompilerOptions s = new ThriftCompilerOptions();
    final List<Generator> list = s.generators;
    list.clear();
    try {
      for (Generator g : generators) {
        list.add(g.clone());
      }
    }
    catch (CloneNotSupportedException e) {
      throw new RuntimeException("Failed to clone generator settings");
    }
    s.includes.clear();
    s.includes.addAll(includes);
    s.cleanOutput = cleanOutput;
    return s;
  }

  @Override
  public void applyChanges(@NotNull ThriftCompilerOptions modified) {
    generators.clear();
    includes.clear();
    cleanOutput = modified.cleanOutput;

    generators.addAll(modified.generators);
    includes.addAll(modified.includes);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ThriftCompilerOptions options = (ThriftCompilerOptions)o;

    return cleanOutput == options.cleanOutput && generators.equals(options.generators) && includes.equals(options.includes);
  }

  @Override
  public int hashCode() {
    int result = generators.hashCode();
    result = 31 * result + includes.hashCode();
    result = 31 * result + (cleanOutput ? 1 : 0);
    return result;
  }
}
