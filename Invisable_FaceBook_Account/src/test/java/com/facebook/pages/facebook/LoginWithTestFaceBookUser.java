package com.facebook.pages.facebook;

import com.facebook.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.xml.xpath.XPath;

public class LoginWithTestFaceBookUser extends BasePage {
    @FindAll({
           /* @FindBy(xpath = "//div[text()='Options']"),
            @FindBy(xpath = "//div[@id='js_lh']"),*/
            @FindBy(xpath = "//tbody/tr[1]/td[6]/div[1]/div[1]/span[1]/div[1]/div[2]/div[1]/div[1]")

    })
    WebElement loginOptionList;

    @FindBy(xpath = "//div[text()='Log in as this test user']")
    WebElement loginAsTestUserText;

    @FindBy(xpath = "//input[@type='submit' and @value='1']")
    WebElement loginButton;

    @FindBy(xpath = "//input[@type='submit' and @value='1']")
    WebElement confirmLoginButton;

    public void loginAsTestUser() {
        clickOnOptionList();
        clickOnLoginAsTestUserText();
        //clickOnLoginButton();
        clickOnConfirmLoginButton();

    }

    public void clickOnOptionList() {
        wait.until(ExpectedConditions.elementToBeClickable(loginOptionList));
        JavascriptExecutor executor = (JavascriptExecutor) edgeDriver;
        executor.executeScript("arguments[0].click();", loginOptionList);

    }

    public void clickOnLoginAsTestUserText() {
        loginAsTestUserText.click();
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void clickOnConfirmLoginButton() {

        wait.until(ExpectedConditions.elementToBeClickable(confirmLoginButton));
        JavascriptExecutor executor = (JavascriptExecutor) edgeDriver;
        executor.executeScript("arguments[0].click();", confirmLoginButton);
        //confirmLoginButton.click();
    }

}
