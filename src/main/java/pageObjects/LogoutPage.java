package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseSetup;

public class LogoutPage extends BaseSetup {

    public WebDriverWait wait;

    public LogoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(className = "oxd-userdropdown-tab")
    private WebElement userDropdown;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logoutButton;

    public void logout() {

        wait.until(ExpectedConditions.elementToBeClickable(userDropdown)).click();

        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();

    }
}