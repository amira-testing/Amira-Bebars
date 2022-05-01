package com.facebook.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebDriverSingleton {

    private static WebDriver webDriver;
    private static WebDriverSingleton webDriverSingleton = null;
    public static String EdgePath = System.getProperty("user.dir") + "/WebDriver/msedgedriver.exe";
    private static final String driverType = "webdriver.edge.driver";
    private static final String ConfigPath = System.getProperty("user.dir") + "/resources/config/Config.properties";

    private WebDriverSingleton() {
        setDriverCapabilities();
    }

    public static WebDriverSingleton getDriverSingleton() {
        if (webDriverSingleton == null)
            webDriverSingleton = new WebDriverSingleton();
        return webDriverSingleton;
    }

    private void setDriverCapabilities() {

        System.setProperty(driverType, EdgePath);

        EdgeOptions ChromeCapabilities = new EdgeOptions();
        ChromeCapabilities.setCapability("requireWindowFocus()", true);
        ChromeCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
        ChromeCapabilities.setCapability("ignoreProtectedModeSettings", true);
        ChromeCapabilities.setCapability("disable-popup-blocking", true);
        ChromeCapabilities.setCapability("newCommandTimeout", 1200);
        ChromeCapabilities.setCapability("enablePersistentHover", true);
        ChromeCapabilities.setCapability("ignoreZoomSetting", true);
        ChromeCapabilities.setCapability("nativeEvents", false);
        webDriver = new EdgeDriver(ChromeCapabilities);
        webDriver.manage().window().maximize();

    }

    public static Properties setProperties() throws IOException {
        Properties configProperties = new Properties();
        FileInputStream inputStream = new FileInputStream(ConfigPath);
        configProperties.load(inputStream);
        return configProperties;
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public void navigateTo(String link) {
        webDriver.navigate().to(link);
    }

    public void resetCache() throws InterruptedException {
        webDriver.manage().deleteAllCookies();

        //TODO: remove thread.sleep
        Thread.sleep(7000);
    }

    public static void close() {
        webDriver.quit();
    }

}

