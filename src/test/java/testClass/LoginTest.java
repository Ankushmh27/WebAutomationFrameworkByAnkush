package testClass;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseSetup;
import pageObjects.LoginPage;
import utilities.CommonUtility;
import utilities.ConfigFileReader;

public class LoginTest extends BaseSetup {

	LoginPage loginPage;
	ConfigFileReader config;
	CommonUtility commonUtility;
	WebDriverWait wait;

	@Test(priority = 0)
	public void userLogin() {

		config = new ConfigFileReader();
		loginPage = new LoginPage(driver);
		commonUtility = new CommonUtility();

		loginPage.login(config.getUsername(), config.getPassword());

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {

			// ================= SUCCESS CASE =================
			WebElement dashboard = wait.until(ExpectedConditions.visibilityOf(loginPage.getDashboardTitle()));
			Assert.assertTrue(dashboard.isDisplayed(), "Dashboard is not displayed");

			String actualTitle = driver.getTitle();
			String expectedPageTitle = config.getExpectedPageTitle();
			System.out.println("Page Title: " + actualTitle);
			System.out.println("LOGIN SUCCESS");
			commonUtility.assertEquals(actualTitle, expectedPageTitle, "Page title mismatch");
		} catch (Exception e) {

			try {
				// ================= FAILURE CASE =================
				WebElement error = wait.until(ExpectedConditions.visibilityOf(loginPage.getErrorMessage()));

				Assert.fail("LOGIN FAILED: " + error.getText());
			} catch (Exception inner) {
				Assert.fail("Login failed and no error message displayed");
			}
		}
		CommonUtility.assertAll();
	}
}
