package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage extends BaseSetup {
	static WebDriverWait wait;
	public LogoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "oxd-userdropdown-tab")
	private WebElement userDropdown;
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutButton;
	
	public void logout() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(userDropdown)).click();

		boolean isLogoutButton = logoutButton.isEnabled();
		if (isLogoutButton==true) {
			wait = new WebDriverWait(driver, Duration.ofSeconds(2));
			wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
		}
		else {System.out.println("logout button is not enable");
		}
		
		Thread.sleep(5000);
	}
}
