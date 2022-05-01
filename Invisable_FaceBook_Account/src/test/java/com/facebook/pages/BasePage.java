package com.facebook.pages;

import com.facebook.driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    public WebDriver edgeDriver = WebDriverSingleton.getDriverSingleton().getWebDriver();
    final int waitTime = 5;
    public WebDriverWait wait = new WebDriverWait(edgeDriver, 10);

    public BasePage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(edgeDriver, waitTime), this);
    }
}
