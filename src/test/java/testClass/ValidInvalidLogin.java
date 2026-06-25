package testClass;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseSetup;
import pageObjects.LoginPage;
import utilities.CommonUtility;
import utilities.ConfigFileReader;
import utilities.WaitUtility;

public class ValidInvalidLogin extends BaseSetup{
	LoginPage loginPage;
	protected ConfigFileReader config;
	protected CommonUtility commonUtility;
	//private WebDriverWait wait;
	protected WaitUtility wait;

	@Test(priority = 0,groups = {"Sanity"})
	public void loginWithInvalidCredentials() 
	{
		config = new ConfigFileReader();
		loginPage = new LoginPage(driver);
		commonUtility = new CommonUtility();
		wait = new WaitUtility(driver);
		loginPage.login(config.getInvalidUsername(), config.getInvalidPassword());
		
		WebElement error = wait.visibilityOfElement(loginPage.getErrorMessage());
		if (error.isDisplayed()) {
			System.out.println("Login failed! error is message displayed :" + error.getText());
			
		}
		else {
			System.out.println("Login failed and no error message displayed");
			}		
	}
	
	@Test(priority = 1,groups = {"Sanity"}, dependsOnMethods = {"loginWithInvalidCredentials"})
	public void loginWithValidCredentials() throws InterruptedException {
		loginPage.clearUsernamePassword();
		
		loginPage.login(config.getUsername(), config.getPassword());
		
		WebElement dashboard = wait.visibilityOfElement(loginPage.getDashboardTitle());
	    Assert.assertTrue(dashboard.isDisplayed(), "Dashboard is not displayed");

	    String actualTitle = driver.getTitle();
	    String expectedPageTitle = config.getExpectedPageTitle();
        
	    System.out.println("Page Title: " + actualTitle);
	    commonUtility.assertEquals(actualTitle, expectedPageTitle, "Page title mismatch!");
	    System.out.println("LOGIN SUCCESS");
	    CommonUtility.assertAll();
	}
}	

