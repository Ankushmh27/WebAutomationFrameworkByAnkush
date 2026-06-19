package testClass;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import base.BaseSetup;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;

public class LogoutTest extends BaseSetup {

    LogoutPage logoutPage;
    LoginPage loginPage;

    @Test(priority = 1)
    public void userLogout() {

        // Initialize login page
        loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        // Initialize logout page
        logoutPage = new LogoutPage(driver);
        logoutPage.logout();
    }
}