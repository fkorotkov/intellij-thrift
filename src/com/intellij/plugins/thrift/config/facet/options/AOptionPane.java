package com.intellij.plugins.thrift.config.facet.options;

import com.intellij.plugins.thrift.config.target.Generator;
import com.intellij.plugins.thrift.config.target.GeneratorType;

import javax.swing.*;
import java.awt.*;
import java.util.EnumMap;
import java.util.Map;

/**
 * 16.07.2014 17:28
 *
 * @author xBlackCat
 */
abstract class AOptionPane<G extends Generator> extends JPanel {
  private final static Map<GeneratorType, AOptionPane<? extends Generator>> PANES =
    new EnumMap<GeneratorType, AOptionPane<? extends Generator>>(GeneratorType.class);

  static {
    PANES.put(GeneratorType.AS3, new AS3OptionPane());
    PANES.put(GeneratorType.Cocoa, new CocoaOptionPane());
    PANES.put(GeneratorType.Cpp, new CppOptionPane());
    PANES.put(GeneratorType.CSharp, new CSharpOptionPane());
    PANES.put(GeneratorType.Delphi, new DelphiOptionPane());
    PANES.put(GeneratorType.Erlang, new ErlangOptionPane());
    PANES.put(GeneratorType.Go, new GoOptionPane());
    PANES.put(GeneratorType.Graphviz, new GraphvizOptionPane());
    PANES.put(GeneratorType.HTML, new HTMLOptionPane());
    PANES.put(GeneratorType.Java, new JavaOptionPane());
    PANES.put(GeneratorType.JavaScript, new JavaScriptOptionPane());
    PANES.put(GeneratorType.PHP, new PHPOptionPane());
    PANES.put(GeneratorType.Python, new PythonOptionPane());
    PANES.put(GeneratorType.Ruby, new RubyOptionPane());
  }

  public static <G extends Generator> AOptionPane<G> get(GeneratorType type) {
    return (AOptionPane<G>)PANES.get(type);
  }

  public AOptionPane(LayoutManager layout, boolean isDoubleBuffered) {
    super(layout, isDoubleBuffered);
  }

  public AOptionPane(LayoutManager layout) {
    super(layout);
  }

  public AOptionPane(boolean isDoubleBuffered) {
    super(isDoubleBuffered);
  }

  public AOptionPane() {
  }

  public JComponent getPanel() {
    return this;
  }

  public abstract void setValues(G g);

  public abstract void readValuesTo(G g);
}
