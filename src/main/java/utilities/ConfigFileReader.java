package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ConfigFileReader {
	
	private final Properties properties;

	public ConfigFileReader() {
		properties = new Properties();

		try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {

			if (input == null) {
				throw new RuntimeException("config.properties file not found.");
			}

			properties.load(input);

		} catch (IOException e) {
			throw new RuntimeException("Unable to load config.properties", e);
		}
	}

	public String getBrowser() {

	    String browser = System.getProperty("browser");

	    if (browser == null || browser.isBlank()) {
	        browser = properties.getProperty("browser");
	    }

	    return browser;
	}
	
	public String getApplicationUrl() {
		return properties.getProperty("url");
	}

	public String getInvalidUsername() {
		return properties.getProperty("InvalidUsername");
	}

	public String getInvalidPassword() {
		return properties.getProperty("InvalidPassword");
	}
	
	public String getUsername() {
		return properties.getProperty("username");
	}

	public String getPassword() {
		return properties.getProperty("password");
	}
	
	public int getImplicitWait() {
		return Integer.parseInt(properties.getProperty("implicitWait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(properties.getProperty("explicitWait"));
	}

	public String getExpectedPageTitle() {
		return properties.getProperty("expectedPageTitle");
	}
	public String getexpectedUrlAfterLogout() {
		return properties.getProperty("expectedUrl");
	}
}	

