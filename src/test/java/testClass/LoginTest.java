package testClass;

import org.testng.annotations.Test;

import pageObjects.BaseSetup;
import pageObjects.LoginPage;

public class LoginTest extends BaseSetup {
	LoginPage loginPage;

	@Test(priority = 0)
	public void userLogin() {
		loginPage = new LoginPage(driver);
		loginPage.login();
	}
}
