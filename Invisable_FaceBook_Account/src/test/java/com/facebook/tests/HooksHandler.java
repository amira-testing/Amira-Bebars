package com.facebook.tests;

import com.facebook.driver.WebDriverSingleton;
import io.cucumber.java.Before;
import io.cucumber.java.After;


import java.io.IOException;

public class HooksHandler extends BaseTest {

    @Before(value = " @Facebook", order = 1)
    public void setUpFacebook() throws IOException, InterruptedException {
        edgeDriver = WebDriverSingleton.getDriverSingleton();
        properties = WebDriverSingleton.setProperties();
        edgeDriver.resetCache();
        edgeDriver.navigateTo(properties.getProperty("APPURL"));
        System.out.println(properties.getProperty("APPURL"));

    }

    @After(value = " @Facebook", order = 0)
    public void tearDownFacebook() throws InterruptedException {
        edgeDriver.resetCache();
        closeWebDriverAfterAllTestsHook();

    }

    private void closeWebDriverAfterAllTestsHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            WebDriverSingleton.close();
        }));
    }

}
