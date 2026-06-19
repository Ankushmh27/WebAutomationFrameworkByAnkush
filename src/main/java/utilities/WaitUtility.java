package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

	protected WebDriver driver;
	protected WebDriverWait wait;

	public WaitUtility(WebDriver driver) {
		this.driver = driver;
	}

	// Wait until element is visible
	public WebElement waitForVisibility(By locator) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Wait until WebElement is visible
	public WebElement waitForVisibility(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Wait until element is clickable
	public WebElement waitForClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	// Wait until WebElement is clickable
	public WebElement waitForClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Wait until element is present in DOM
	public WebElement waitForPresence(By locator) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	// Wait until element disappears
	public boolean waitForInvisibility(By locator) {
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	// Wait until element contains text
	public boolean waitForText(By locator, String text) {
		return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}

	// Wait until URL contains text
	public boolean waitForUrlContains(String urlPart) {
		return wait.until(ExpectedConditions.urlContains(urlPart));
	}

	// Wait until URL is exactly equal
	public boolean waitForUrlToBe(String url) {
		return wait.until(ExpectedConditions.urlToBe(url));
	}

	// Wait until page title contains text
	public boolean waitForTitleContains(String title) {
		return wait.until(ExpectedConditions.titleContains(title));
	}

	// Wait until page title is exactly equal
	public boolean waitForTitleToBe(String title) {
		return wait.until(ExpectedConditions.titleIs(title));
	}

	// Wait for alert
	public void waitForAlert() {
		wait.until(ExpectedConditions.alertIsPresent());
	}

	// Wait until frame is available and switch
	public void waitForFrame(By locator) {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

	// Wait until number of windows
	public boolean waitForNumberOfWindows(int count) {
		return wait.until(ExpectedConditions.numberOfWindowsToBe(count));
	}
}