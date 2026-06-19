package testClass;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseSetup;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;

public class LogoutTest extends BaseSetup {

	LogoutPage logoutPage;
	LoginPage loginPage;
	WebDriverWait wait;
//    WaitUtility wait;
//    CommonUtility commonUtility;

	@Test(dependsOnMethods = "testClass.LoginTest.userLogin")
	public void userLogout() {
//    	    wait = new WebDriverWait(driver);
		// Initialize login page
		loginPage = new LoginPage(driver);
		loginPage.login(config.getUsername(), config.getPassword());

		// Initialize logout page
		logoutPage = new LogoutPage(driver);
		logoutPage.logout();

		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = config.getexpectedUrlAfterLogout();

		// Wait until URL contains login
//        wait.waitForUrlContains("/auth/login");
		wait = new WebDriverWait(driver, Duration.ofSeconds(13));
		wait.until(ExpectedConditions.urlContains("/auth/login"));

		System.out.println("Current URL: " + currentUrl);
		Assert.assertEquals(currentUrl, expectedUrl, "Incorrect url! After logout user is NOT on Login page");
		System.out.println("LOGOUT SUCCESS");
	}
}