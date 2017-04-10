Plugin to support the Apache Thrift language in JetBrains IDE's

Fork Notes
==========

This fork tweaks the main repo to allow building the plugin for all JetBrains apps.

Functionality is currently verified and tested in:
- PyCharm


How to Install
===============

The plugin currently must be installed from a zip file.  You can either
build the plugin yourself, or install a pre-built zip (check out the [builds](builds) dir).

To install: Settings -> Plugins -> Install plugins from disk... -> Choose the zip


Building the plugin
===================

* Project setup
  * see: http://www.jetbrains.org/intellij/sdk/docs/basics/getting_started/setting_up_environment.html
  * Note that checking out the IDEA CE source is roughly 5.5GB of data
  * Instead of pointing to an Intellij IDEA installation, point to your specific IDE install (e.g. PyCharm.app)
    * e.g. for PyCharm mac, point to /path/to/PyCharm.app/Contents/
* Invalidate output: Build -> Rebuild Project
* Generate plugin zip, either:
  a) zip $PROJECT_ROOT/out/artifacts/thrift folder
  b) Build -> Prepare Plugin Module 'intellij-thrift' for deployment

Builds
======

[PyCharm PC-171.3780.115](builds/intellij-thrift-PC-171.3780.115.zip) (Apr 10, 2017)
