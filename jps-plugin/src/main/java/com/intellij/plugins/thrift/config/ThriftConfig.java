package com.intellij.plugins.thrift.config;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.jps.model.JpsElementChildRole;
import org.jetbrains.jps.model.JpsProject;
import org.jetbrains.jps.model.ex.JpsElementBase;
import org.jetbrains.jps.model.ex.JpsElementChildRoleBase;

/**
 * 27.06.2014 10:59
 *
 * @author xBlackCat
 */
public class ThriftConfig extends JpsElementBase<ThriftConfig> {
  public static final String COMPILER_DEFAULT_NAME = "thrift";
  public static final JpsElementChildRole<ThriftConfig> ROLE = JpsElementChildRoleBase.create("Thrift config");

  private final String compilerPath;
  private final boolean myNoWarn;
  private final boolean myStrict;
  private final boolean myVerbose;
  private final boolean myRecurse;
  private final boolean myDebug;
  private final boolean myAllowNegKeys;
  private final boolean myAllow64bitConsts;

  public ThriftConfig(String compilerPath,
                      boolean warn,
                      boolean strict,
                      boolean verbose,
                      boolean recurse,
                      boolean debug,
                      boolean keys,
                      boolean consts) {
    this.compilerPath = compilerPath;
    myNoWarn = warn;
    myStrict = strict;
    myVerbose = verbose;
    myRecurse = recurse;
    myDebug = debug;
    myAllowNegKeys = keys;
    myAllow64bitConsts = consts;
  }

  public VirtualFile getCompilerFile() {
    return VirtualFileManager.getInstance().findFileByUrl(compilerPath);
  }

  public String getCompilerPath() {
    return compilerPath;
  }

  @NotNull
  @Override
  public ThriftConfig createCopy() {
    return new ThriftConfig(compilerPath, myNoWarn, myStrict, myVerbose, myRecurse, myDebug, myAllowNegKeys, myAllow64bitConsts);
  }

  @Override
  public void applyChanges(@NotNull ThriftConfig modified) {
  }

  public static ThriftConfig getSettings(JpsProject project) {
    final ThriftConfig config = project.getContainer().getChild(ThriftConfig.ROLE);
    return config == null ? new ThriftConfig(COMPILER_DEFAULT_NAME, false, false, false, false, false, false, false) : config;
  }

  public boolean isNoWarn() {
    return myNoWarn;
  }

  public boolean isStrict() {
    return myStrict;
  }

  public boolean isVerbose() {
    return myVerbose;
  }

  public boolean isRecurse() {
    return myRecurse;
  }

  public boolean isDebug() {
    return myDebug;
  }

  public boolean isAllowNegKeys() {
    return myAllowNegKeys;
  }

  public boolean isAllow64bitConsts() {
    return myAllow64bitConsts;
  }
}
