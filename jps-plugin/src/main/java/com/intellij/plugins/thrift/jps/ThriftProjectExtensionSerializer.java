package com.intellij.plugins.thrift.jps;

import com.intellij.plugins.thrift.config.ThriftConfig;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.jps.model.JpsProject;
import org.jetbrains.jps.model.serialization.JpsProjectExtensionSerializer;

/**
 * 11.07.2014 09:37
 *
 * @author xBlackCat
 */
public class ThriftProjectExtensionSerializer extends JpsProjectExtensionSerializer {
  public static final String NAME = "ThriftCompiler";
  public static final String CONFIG_FILE_NAME = "thriftCompiler.xml";

  public ThriftProjectExtensionSerializer() {
    super(CONFIG_FILE_NAME, NAME);
  }

  @Override
  public void loadExtension(@NotNull JpsProject project, @NotNull Element componentTag) {
    Element fwList = componentTag.getChild("compilers");
    if (fwList != null) {
      Element fw = fwList.getChild("compiler");
      if (fw != null) {
        String url = fw.getAttributeValue("url");
        if (url != null) {
          boolean noWarn = toBoolean(fw.getAttributeValue("nowarn"));
          boolean strict = toBoolean(fw.getAttributeValue("strict"));
          boolean verbose = toBoolean(fw.getAttributeValue("verbose"));
          boolean recurse = toBoolean(fw.getAttributeValue("recurse"));
          boolean debug = toBoolean(fw.getAttributeValue("debug"));
          boolean allowNegKeys = toBoolean(fw.getAttributeValue("allownegkeys"));
          boolean allow64bitConsts = toBoolean(fw.getAttributeValue("allow64bitconsts"));

          ThriftConfig config = new ThriftConfig(url, noWarn, strict, verbose, recurse, debug, allowNegKeys, allow64bitConsts);
          project.getContainer().setChild(ThriftConfig.ROLE, config);
        }
      }
    }
  }


  /**
   * <p>Converts a String to a Boolean.</p>
   * <p/>
   * <p>{@code 'true'}, {@code 'on'} or {@code 'yes'}
   * (case insensitive) will return {@code true}.
   * {@code 'false'}, {@code 'off'} or {@code 'no'}
   * (case insensitive) will return {@code false}.
   * Otherwise, {@code null} is returned.</p>
   * <p/>
   * <p>NOTE: This returns null and will throw a NullPointerException if autoboxed to a boolean. </p>
   * <p/>
   * <pre>
   *   BooleanUtils.toBooleanObject(null)    = null
   *   BooleanUtils.toBooleanObject("true")  = Boolean.TRUE
   *   BooleanUtils.toBooleanObject("false") = Boolean.FALSE
   *   BooleanUtils.toBooleanObject("on")    = Boolean.TRUE
   *   BooleanUtils.toBooleanObject("ON")    = Boolean.TRUE
   *   BooleanUtils.toBooleanObject("off")   = Boolean.FALSE
   *   BooleanUtils.toBooleanObject("oFf")   = Boolean.FALSE
   *   BooleanUtils.toBooleanObject("blue")  = null
   * </pre>
   *
   * @param str the String to check
   * @return the Boolean value of the string, {@code null} if no match or {@code null} input
   */
  public static Boolean toBooleanObject(String str) {
    // Previously used equalsIgnoreCase, which was fast for interned 'true'.
    // Non interned 'true' matched 15 times slower.
    //
    // Optimisation provides same performance as before for interned 'true'.
    // Similar performance for null, 'false', and other strings not length 2/3/4.
    // 'true'/'TRUE' match 4 times slower, 'tRUE'/'True' 7 times slower.
    if (str == "true") {
      return Boolean.TRUE;
    }
    if (str == null) {
      return null;
    }
    switch (str.length()) {
      case 1: {
        char ch0 = str.charAt(0);
        if (ch0 == 'y' || ch0 == 'Y' ||
            ch0 == 't' || ch0 == 'T') {
          return Boolean.TRUE;
        }
        if (ch0 == 'n' || ch0 == 'N' ||
            ch0 == 'f' || ch0 == 'F') {
          return Boolean.FALSE;
        }
        break;
      }
      case 2: {
        char ch0 = str.charAt(0);
        char ch1 = str.charAt(1);
        if ((ch0 == 'o' || ch0 == 'O') &&
            (ch1 == 'n' || ch1 == 'N')) {
          return Boolean.TRUE;
        }
        if ((ch0 == 'n' || ch0 == 'N') &&
            (ch1 == 'o' || ch1 == 'O')) {
          return Boolean.FALSE;
        }
        break;
      }
      case 3: {
        char ch0 = str.charAt(0);
        char ch1 = str.charAt(1);
        char ch2 = str.charAt(2);
        if ((ch0 == 'y' || ch0 == 'Y') &&
            (ch1 == 'e' || ch1 == 'E') &&
            (ch2 == 's' || ch2 == 'S')) {
          return Boolean.TRUE;
        }
        if ((ch0 == 'o' || ch0 == 'O') &&
            (ch1 == 'f' || ch1 == 'F') &&
            (ch2 == 'f' || ch2 == 'F')) {
          return Boolean.FALSE;
        }
        break;
      }
      case 4: {
        char ch0 = str.charAt(0);
        char ch1 = str.charAt(1);
        char ch2 = str.charAt(2);
        char ch3 = str.charAt(3);
        if ((ch0 == 't' || ch0 == 'T') &&
            (ch1 == 'r' || ch1 == 'R') &&
            (ch2 == 'u' || ch2 == 'U') &&
            (ch3 == 'e' || ch3 == 'E')) {
          return Boolean.TRUE;
        }
        break;
      }
      case 5: {
        char ch0 = str.charAt(0);
        char ch1 = str.charAt(1);
        char ch2 = str.charAt(2);
        char ch3 = str.charAt(3);
        char ch4 = str.charAt(4);
        if ((ch0 == 'f' || ch0 == 'F') &&
            (ch1 == 'a' || ch1 == 'A') &&
            (ch2 == 'l' || ch2 == 'L') &&
            (ch3 == 's' || ch3 == 'S') &&
            (ch4 == 'e' || ch4 == 'E')) {
          return Boolean.FALSE;
        }
        break;
      }
    }

    return null;
  }
  // String to boolean methods
  //-----------------------------------------------------------------------

  /**
   * <p>Converts a String to a boolean (optimised for performance).</p>
   * <p/>
   * <p>{@code 'true'}, {@code 'on'} or {@code 'yes'}
   * (case insensitive) will return {@code true}. Otherwise,
   * {@code false} is returned.</p>
   * <p/>
   * <p>This method performs 4 times faster (JDK1.4) than
   * {@code Boolean.valueOf(String)}. However, this method accepts
   * 'on' and 'yes' as true values.
   * <p/>
   * <pre>
   *   BooleanUtils.toBoolean(null)    = false
   *   BooleanUtils.toBoolean("true")  = true
   *   BooleanUtils.toBoolean("TRUE")  = true
   *   BooleanUtils.toBoolean("tRUe")  = true
   *   BooleanUtils.toBoolean("on")    = true
   *   BooleanUtils.toBoolean("yes")   = true
   *   BooleanUtils.toBoolean("false") = false
   *   BooleanUtils.toBoolean("x gti") = false
   * </pre>
   *
   * @param str the String to check
   * @return the boolean value of the string, {@code false} if no match or the String is null
   */
  public static boolean toBoolean(String str) {
    return toBooleanObject(str) == Boolean.TRUE;
  }
}
