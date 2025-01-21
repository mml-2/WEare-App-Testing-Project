package com.weare.pages;

import testframework.PropertiesManager;
import testframework.core.BaseWebPage;

public class BaseWeArePage extends BaseWebPage {
public BaseWeArePage (String pageSpecificUrl){
    super(pageSpecificUrl);
}
public String getBasePageUrl() {
  return   PropertiesManager.getConfigProperties().getProperty("weAreBaseUrl");
}
}
