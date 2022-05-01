package com.facebook.tests.LoginAndRegister;

import com.facebook.tests.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CommonStepDef extends BaseTest {



    @Given("user login with UserName {string} and  Password {string} and login")
    public void user_login_with_user_name_and_password_and_login(String username, String password) {
        // Write code here that turns the phrase above into concrete actions
        browser.login.loginFunction(properties.getProperty(username), properties.getProperty(password));
    }

    @When("user create facebook App with {string} and {string}")
    public void userCreateFacebookAppWithAnd(String appName, String email) {
        browser.createFaceBookApp.createApp(properties.getProperty(appName), properties.getProperty(email));

    }

    @And("user reenter password{string}")
    public void userReenterPassword(String password) {
        browser.createFaceBookApp.reEnterPassword(properties.getProperty(password));
    }




    @Then("user register with test facebook account")
    public void user_register_with_test_facebook_account() {
        browser.register.registerTestUser();
    }



    @Then("user login with test facebook account")
    public void user_login_with_test_facebook_account() {
        // Write code here that turns the phrase above into concrete actions
        browser.loginTestUser.loginAsTestUser();
    }

}

