package com.facebook.pages.facebook;

import com.facebook.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterWithTestFaceBookUser extends BasePage {

    @FindBy(xpath = "//a[@href='/apps/410154764281962']")
    WebElement appIdHolder;

    @FindBy(xpath = "//div[text()='Roles']")
    WebElement roleListItem;
    @FindAll({
            @FindBy(xpath = "//a[@href='/apps/410154764281962/roles/test-users/']"),
            @FindBy(xpath = "//a[@role = 'link']")
            // @FindBy(xpath = "//a[contains(.,'test-users')]")
    })
    WebElement testUserElement;

    @FindBy(xpath = "//div[contains(text(),'Create test users')]")
    WebElement createTestUserButton;

    @FindBy(xpath = "//body/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]")
    WebElement createTestUser1Button;


    public void registerTestUser() {
        clickOnAppIdHolder();
        clickOnRoleDropDown();
        clickOnTestUserElement();
        clickOnCreateTestUserButton();
        clickOnCreateTestUser1Button();
    }


    public void clickOnAppIdHolder() {
        wait.until(ExpectedConditions.visibilityOf(appIdHolder));
        JavascriptExecutor executor = (JavascriptExecutor) edgeDriver;
        executor.executeScript("arguments[0].click();", appIdHolder);

    }

    public void clickOnRoleDropDown() {

        //wait.until(ExpectedConditions.visibilityOf(roleListItem));
        wait.until(ExpectedConditions.elementToBeClickable(roleListItem));
        JavascriptExecutor executor = (JavascriptExecutor) edgeDriver;
        executor.executeScript("arguments[0].click();", roleListItem);


    }

    public void clickOnTestUserElement() {
       // edgeDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        JavascriptExecutor executor = (JavascriptExecutor) edgeDriver;
        executor.executeScript("arguments[0].click();", testUserElement);
    }

    public void clickOnCreateTestUserButton() {
        createTestUserButton.click();
    }

    public void clickOnCreateTestUser1Button() {
        createTestUser1Button.click();
    }


}
