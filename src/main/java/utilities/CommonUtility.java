package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class CommonUtility {
	protected WebDriver driver;
	protected ConfigFileReader config;
	protected WebDriverWait wait;
	Actions actions;
	Select select;
	protected static SoftAssert softAssert;

//	public CommonUtility(WebDriver driver) {
//		this.driver = driver;
//		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//		this.actions = new Actions(driver);
//		this.select = new Select(null);
//   }

	public static String captureScreenshots(WebDriver driver, String name) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir") + "/screenshots/" + name + ".png";

		try {
			FileUtils.copyFile(src, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}

	public boolean urlContains(String url) {
		return wait.until(ExpectedConditions.urlContains(url));
	}

	public boolean titleContains(String title) {
		return wait.until(ExpectedConditions.titleContains(title));
	}

	// JavascriptExecutor utility methods
	public void click(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public void scrollTo(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public String getTitle() {
		return ((JavascriptExecutor) driver).executeScript("return document.title").toString();
	}

	// action class utility methods
	public void moveTo(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void rightClick(WebElement element) {
		actions.contextClick(element).perform();
	}

	public void doubleClick(WebElement element) {
		actions.doubleClick(element).perform();
	}

	// select class utility method
	public void selectByVisibleText(WebElement element, String text) {
		select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectByValue(String value) {
		select.selectByValue(value);
	}

	public void selectByIndex(int index) {
		select.selectByIndex(index);
	}

	// window handling utility
	public void switchToWindow(String title) {
		Set<String> windows = driver.getWindowHandles();

		for (String window : windows) {
			driver.switchTo().window(window);
			if (driver.getTitle().contains(title)) {
				break;
			}
		}

	}

	// frame handling
	public void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrameByElement(WebElement switchToElement) {
		driver.switchTo().frame(switchToElement);
	}

	public void switchToDefault() {
		driver.switchTo().defaultContent();
	}

	// soft asserts methods
	// Assert Equals
	public void assertEquals(String actual, String expected, String message) {
		softAssert = new SoftAssert();
		softAssert.assertEquals(actual, expected, message);
	}

	// Assert True
	public void assertTrue(boolean condition, String message) {
		softAssert.assertTrue(condition, message);
	}

	// Assert False
	public void assertFalse(boolean condition, String message) {
		softAssert.assertFalse(condition, message);
	}

	// Assert Not Null
	public void assertNotNull(Object object, String message) {
		softAssert.assertNotNull(object, message);
	}

	// Call this at end of test
	public static void assertAll() {
		softAssert.assertAll();
	}
}
