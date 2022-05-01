package com.facebook.pages.facebook;

import com.facebook.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Login extends BasePage {

    @FindBy(xpath = "//input[@id='email']")
    WebElement userNameTextBox;

    @FindBy(id = "pass")
    WebElement passwordTextBox;

    @FindBy(name = "login")
    WebElement loginButton;

    public void loginFunction(String UserName, String Password) {
        enterUserName(UserName);
        enterPassword(Password);
        clickOnLoginButton();
    }

    public void enterUserName(String userName) {
        userNameTextBox.click();
        userNameTextBox.sendKeys(userName);
    }

    public void enterPassword(String password) {

        passwordTextBox.click();
        passwordTextBox.clear();
        passwordTextBox.sendKeys(password);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }


}
