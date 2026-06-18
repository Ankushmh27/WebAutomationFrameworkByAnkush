package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BaseSetup{
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(name = "username")
	private WebElement userName;
	
	@FindBy(name = "username")
	private WebElement password;
	
	@FindBy(xpath = "//button")
	private WebElement loginButton;
	
	public void login() {
		userName.sendKeys("Admin");
		password.sendKeys("admin123");
		Assert.assertTrue(loginButton.isEnabled(), "Login button is not enable");
		loginButton.click();
		String pageTitle = driver.getTitle();
		System.out.println("pageTitle is: " + pageTitle);

	}
}
