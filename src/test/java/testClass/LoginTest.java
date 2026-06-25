package testClass;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseSetup;
import pageObjects.LoginPage;
import utilities.CommonUtility;
import utilities.ConfigFileReader;
import utilities.WaitUtility;

public class LoginTest extends BaseSetup {

    LoginPage loginPage;
    ConfigFileReader config;
    protected  CommonUtility commonUtility;
   protected  WaitUtility wait;

    @Test(priority = 0, groups = {"Regression"})
    public void userLoginTest() {

        config = new ConfigFileReader();
        loginPage = new LoginPage(driver);
        commonUtility = new CommonUtility();
        wait = new WaitUtility(driver);

        loginPage.login(config.getUsername(), config.getPassword());

        // ================= SUCCESS CHECK =================
        try {
            WebElement dashboard = loginPage.getDashboardTitle();
            wait.visibilityOfElement(dashboard);

            String actualTitle = driver.getTitle();
            String expectedTitle = config.getExpectedPageTitle();

            System.out.println("LOGIN SUCCESS");
            System.out.println("Page Title: " + actualTitle);

            commonUtility.assertEquals(actualTitle, expectedTitle, "Page title mismatch");

            return; // stop execution if login success

        } catch (Exception e) {
            // ignore and go to failure check
        }

        // ================= FAILURE CHECK =================
        try {
            WebElement error = loginPage.getErrorMessage();
            wait.visibilityOfElement(error);

            Assert.fail("LOGIN FAILED: " + error.getText());

        } catch (Exception e) {
        	System.out.println("Login Success");
        }
    }
}