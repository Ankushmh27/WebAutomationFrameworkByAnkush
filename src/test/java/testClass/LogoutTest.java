package testClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseSetup;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import utilities.CommonUtility;
import utilities.WaitUtility;

public class LogoutTest extends BaseSetup {

	LogoutPage logoutPage;
	LoginPage loginPage;
	protected WaitUtility wait;
	protected CommonUtility commonUtility;

	@Test(priority = 1, groups = {"Regression"}, dependsOnMethods = "testClass.LoginTest.userLoginTest")
	public void userLogout() {
		wait = new WaitUtility(driver);
		// Initialize login page
		loginPage = new LoginPage(driver);
		loginPage.login(config.getUsername(), config.getPassword());

		// Initialize logout page
		logoutPage = new LogoutPage(driver);
		logoutPage.logout();

		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = config.getexpectedUrlAfterLogout();

		// Wait until URL contains login
		// wait.until(ExpectedConditions.urlContains("/auth/login"));
		wait.waitForUrlContains("/auth/login");
		System.out.println("Current URL: " + currentUrl);
		Assert.assertEquals(currentUrl, expectedUrl, "Incorrect url! After logout user is NOT on Login page");
		System.out.println("LOGOUT SUCCESS");
	}
}