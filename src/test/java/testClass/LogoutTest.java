package testClass;

import org.testng.annotations.Test;

import pageObjects.BaseSetup;
import pageObjects.LogoutPage;

public class LogoutTest extends BaseSetup {
	LogoutPage logoutPage;
	@Test(priority = 1,dependsOnMethods = {"userLogin"})
	public void userLogout() throws InterruptedException {
		logoutPage = new LogoutPage(driver);
		logoutPage.logout();
		
	}
}
