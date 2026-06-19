package BasicPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Ignore
public class SeleniumTest {
	static WebDriver driver;
	static Actions action;
	static WebDriverWait wait;

	@BeforeClass
	public void browserLaunnch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 1)
	public void loginTest() throws InterruptedException {
		WebElement userName = driver.findElement(By.name("username"));
		userName.sendKeys("Admin");
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin123");

		WebElement loginButton = driver.findElement(By.xpath("//button"));
		Assert.assertTrue(loginButton.isEnabled(), "Login button is not enable");
		loginButton.click();
		
		String pageTitle = driver.getTitle();
		System.out.println("pageTitle is: " + pageTitle);
	}

	@Test(priority = 2)
	public void logoutTest() throws InterruptedException {
		WebElement userDropdown = driver.findElement(By.className("oxd-userdropdown-tab"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(userDropdown)).click();

		WebElement logoutButton = driver.findElement(By.xpath("//a[text()='Logout']"));
		boolean isLogoutButton = logoutButton.isEnabled();
		if (isLogoutButton==true) {
			wait = new WebDriverWait(driver, Duration.ofSeconds(2));
			wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
		}
		else {System.out.println("logout button is not enable");
		}
		Reporter.log("String msg", true);
		Thread.sleep(5000);
	}

	@AfterClass
	public void browserClose() {
		driver.close();
	}
}
