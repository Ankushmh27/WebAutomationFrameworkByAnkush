package testClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseSetup;
import pageObjects.LoginPage;

public class LoginTest extends BaseSetup {

    LoginPage loginPage;

    @Test(priority = 0)
    public void userLogin() {
        loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
        String actualPageTitle= driver.getTitle();
        String expectedPageTitle="OrangeHRM";
        	System.out.println("actualPageTitle: " + driver.getTitle());	
        Assert.assertEquals(actualPageTitle, expectedPageTitle, "Expected Page Title not matched!");
    }
}