package com.intellij.plugins.thrift.config;

import com.intellij.openapi.components.*;
import com.intellij.plugins.thrift.jps.ThriftProjectExtensionSerializer;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 27.06.2014 10:48
 *
 * @author xBlackCat
 */
@State(
  name = ThriftProjectExtensionSerializer.NAME,
  storages = {
    @Storage(ThriftProjectExtensionSerializer.CONFIG_FILE_NAME)
  }
)
public class ThriftPlugin implements NamedComponent, PersistentStateComponent<Element> {
  private ThriftConfig myConfig;

  @Nullable
  @Override
  public Element getState() {
    final Element root = new Element("thrift");

    Element frameWorksList = new Element("compilers");
    if (myConfig != null && StringUtils.isNotBlank(myConfig.getCompilerPath())) {
      Element fw = new Element("compiler");

      fw.setAttribute("url", myConfig.getCompilerPath());
      fw.setAttribute("nowarn", myConfig.isNoWarn() ? "yes" : "no");
      fw.setAttribute("strict", myConfig.isStrict() ? "yes" : "no");
      fw.setAttribute("verbose", myConfig.isVerbose() ? "yes" : "no");
      fw.setAttribute("recurse", myConfig.isRecurse() ? "yes" : "no");
      fw.setAttribute("debug", myConfig.isDebug() ? "yes" : "no");
      fw.setAttribute("allownegkeys", myConfig.isAllowNegKeys() ? "yes" : "no");
      fw.setAttribute("allow64bitconsts", myConfig.isAllow64bitConsts() ? "yes" : "no");

      frameWorksList.addContent(fw);
    }

    root.addContent(frameWorksList);

    return root;
  }

  @Override
  public void loadState(Element state) {
    Element fwList = state.getChild("compilers");
    if (fwList != null) {
      Element fw = fwList.getChild("compiler");
      if (fw != null) {
        String url = fw.getAttributeValue("url");
        if (url != null) {
          boolean noWarn = BooleanUtils.toBoolean(fw.getAttributeValue("nowarn"));
          boolean strict = BooleanUtils.toBoolean(fw.getAttributeValue("strict"));
          boolean verbose = BooleanUtils.toBoolean(fw.getAttributeValue("verbose"));
          boolean recurse = BooleanUtils.toBoolean(fw.getAttributeValue("recurse"));
          boolean debug = BooleanUtils.toBoolean(fw.getAttributeValue("debug"));
          boolean allowNegKeys = BooleanUtils.toBoolean(fw.getAttributeValue("allownegkeys"));
          boolean allow64bitConsts = BooleanUtils.toBoolean(fw.getAttributeValue("allow64bitconsts"));

          myConfig = new ThriftConfig(url, noWarn, strict, verbose, recurse, debug, allowNegKeys, allow64bitConsts);
        }
      }
    }
  }

  @NotNull
  @Override
  public String getComponentName() {
    return "Thrift";
  }

  public void setConfig(ThriftConfig config) {
    myConfig = config;
  }

  public ThriftConfig getConfig() {
    return myConfig;
  }
}
