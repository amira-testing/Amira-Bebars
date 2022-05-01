package com.facebook.browser;

import com.facebook.driver.WebDriverSingleton;
import com.facebook.pages.facebook.Login;
import com.facebook.pages.facebook.CreateFaceBookApp;
import com.facebook.pages.facebook.LoginWithTestFaceBookUser;
import com.facebook.pages.facebook.RegisterWithTestFaceBookUser;

public class Browser {

    private final WebDriverSingleton webDriverSingleton = WebDriverSingleton.getDriverSingleton();
    public Login login;
    public CreateFaceBookApp createFaceBookApp;
    public RegisterWithTestFaceBookUser register;
    public LoginWithTestFaceBookUser loginTestUser;

    public Browser() {
        login = new Login();
        createFaceBookApp =new CreateFaceBookApp();
        register=new RegisterWithTestFaceBookUser();
        loginTestUser=new LoginWithTestFaceBookUser();

    }

}
