package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseSetup;
import utilities.WaitUtility;

public class LogoutPage extends BaseSetup {

	private WaitUtility wait; // need to setup wait utilty webriver

	public LogoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "oxd-userdropdown-tab")
	private WebElement userDropdown;

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutButton;

	public void logout() {
		wait = new WaitUtility(driver);
		wait.webElementToBeClickable(userDropdown);
		wait.visibilityOfElement(logoutButton);
		wait.visibilityOfElement(logoutButton).click();

	}
}