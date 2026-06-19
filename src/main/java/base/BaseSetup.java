package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.BrowserOptionsFactory;
import utilities.CommonUtility;
import utilities.ConfigFileReader;

public class BaseSetup {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected ConfigFileReader config;
	protected CommonUtility utility;
	protected ChromeOptions options;

	@BeforeClass
	public void browserLaunch() {
		WebDriverManager.chromedriver().setup();

		config = new ConfigFileReader();
		wait = new WebDriverWait(driver, Duration.ofSeconds(config.getExplicitWait()));
		options = new ChromeOptions();
		String browser = config.getBrowser();

		switch (browser.toLowerCase()) {

		case "chrome":
			driver = new ChromeDriver(BrowserOptionsFactory.getChromeOptions());
			break;

		case "firefox":
			driver = new FirefoxDriver(BrowserOptionsFactory.getFirefoxOptions());
			break;

		case "edge":
			driver = new EdgeDriver(BrowserOptionsFactory.getEdgeOptions());
			break;

		default:
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}
		driver.manage().window().maximize();
		driver.get(config.getApplicationUrl());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(config.getImplicitWait()));
	}

	@AfterClass
	public void browserClose() {
		if (driver != null) {
			driver.quit();
		}
	}
}