package com.facebook.tests;

import com.facebook.browser.Browser;
import com.facebook.driver.WebDriverSingleton;

import java.util.Properties;

public class BaseTest {

    protected WebDriverSingleton edgeDriver;
    protected static  Browser browser = new Browser();
    protected static Properties properties;
    public BaseTest() {
        edgeDriver = WebDriverSingleton.getDriverSingleton();
    }
}
