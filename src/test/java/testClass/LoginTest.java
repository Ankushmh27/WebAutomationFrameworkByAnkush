package testClass;

import org.testng.annotations.Test;

import base.BaseSetup;
import pageObjects.LoginPage;

public class LoginTest extends BaseSetup {

    LoginPage loginPage;

    @Test(priority = 0)
    public void userLogin() {
        loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
    }
}