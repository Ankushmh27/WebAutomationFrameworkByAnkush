package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonUtility;

public class LoginPage {
	private WebDriver driver;
	protected WebDriverWait wait;
	protected CommonUtility commonUtility;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement username;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;

	@FindBy(xpath = "//h6[text()='Dashboard']")
	private WebElement pagetitle;

	@FindBy(xpath = "//h6[text()='Dashboard']")
	private WebElement dashboardText;

	@FindBy(xpath = "//p[text()='Invalid credentials']")
	private WebElement errorMessage;

	public void login(String userName, String userPassword) {
		commonUtility = new CommonUtility();
		username.sendKeys(userName);
		password.sendKeys(userPassword);
		loginButton.click();
	}
	public void clearUsernamePassword() {
		username.clear();
		password.clear();
	}
	// Return dashboard page text
	public WebElement getDashboardTitle() {
		return dashboardText;
	}
	// Return login error
	public WebElement getErrorMessage() {
		return errorMessage;
	}
}