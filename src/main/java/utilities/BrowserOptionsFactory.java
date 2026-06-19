package utilities;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserOptionsFactory {

	public static ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-save-password-bubble");
		options.addArguments("--disable-credentials-enable-service");
		return options;
	}

	public static FirefoxOptions getFirefoxOptions() {
		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("dom.webnotifications.enabled", false);
		options.addPreference("signon.rememberSignons", false);
		options.addPreference("signon.autofillForms", false);
		return options;
	}

	public static EdgeOptions getEdgeOptions() {
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--incognito");
		options.addArguments("--disable-notifications");
		return options;
	}
}