package com.facebook.pages.facebook;

import com.facebook.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CreateFaceBookApp extends BasePage {

    @FindBy(xpath = "//body/div[1]/div[5]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]")
    WebElement createAPPButton;

    @FindBy(xpath = "//body/div[1]/div[5]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]")
    WebElement appTypeButton;

    @FindBy(xpath = "//body/div[1]/div[5]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]")
    WebElement nextButton;
    @FindAll({
            @FindBy(css = "input[type='text']"),
            @FindBy(id = "js_57"),
            @FindBy(xpath = "//input[@id='js_57']"),
            @FindBy(xpath = "//body/div[1]/div[5]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")
    })
    WebElement appNameTextBox;

    @FindBy(xpath = "//input[@id='js_c8']")
    WebElement emailTextBox;

    @FindBy(xpath = "//div[text()='Create app']")
    WebElement createAppButton;

    @FindBy(id = "ajax_password")
    WebElement confirmPasswordTextBox;

    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    WebElement submitButton;

    public void createApp(String appName, String email) {
        clickOnCreateAPPButton();
        clickOnAppTypeButton();
        clickOnNextButton();
       // enterAppName(appName);
        // enterEmail(email);
         clickOnCreateAppButton();


    }

    public void clickOnCreateAPPButton() {
        createAPPButton.click();
    }

    public void clickOnAppTypeButton() {
        appTypeButton.click();
    }

    public void clickOnNextButton() {
        nextButton.click();
    }

    public void clickOnCreateAppButton() {
        wait.until(ExpectedConditions.elementToBeClickable(createAppButton));
        JavascriptExecutor executor = (JavascriptExecutor)edgeDriver;
        executor.executeScript("arguments[0].click();", createAppButton);

    }

    public void enterAppName(String appName) {

        // wait.until(ExpectedConditions.elementToBeClickable(appNameTextBox));
        appNameTextBox.clear();
        JavascriptExecutor executor = (JavascriptExecutor) edgeDriver;
        executor.executeScript("arguments[0].click();", appNameTextBox);
        appNameTextBox.sendKeys(appName);
    }

    public void enterEmail(String email) {
        emailTextBox.click();
        emailTextBox.clear();
        emailTextBox.sendKeys(email);
    }

    public void reEnterPassword(String password) {
        confirmPasswordTextBox.click();
        confirmPasswordTextBox.clear();
        confirmPasswordTextBox.sendKeys(password);
        clickOnSubmitButton();
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }
}
