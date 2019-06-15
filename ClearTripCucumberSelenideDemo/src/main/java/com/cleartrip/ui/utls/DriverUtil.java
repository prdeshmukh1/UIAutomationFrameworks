package com.cleartrip.ui.utls;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.ErrorHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtil {
	public static long DEFAULT_WAIT = 20;
	protected static WebDriver driver = null;

	/**
	 * @return Webdriver
	 */
	public static WebDriver getDriver() {
		System.out.println("Inside getDriver() ... ");
		if (driver != null) {
			return driver;
		}
		// Get the browser that is passed to the Maven Build compiler plugin.
		// if not provided , take Firefox as default.
		String preferredDriver = System.getProperty("browser", "firefox");
		System.out.println("preferredDriver :" + preferredDriver);
		driver = chooseDriver(preferredDriver);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return driver;
	}

	/**
	 * By default to web driver will be Firefox
	 *
	 * Override it by passing -Dbrowser=Chrome to the command line arguments
	 * 
	 * @param browserType
	 *            String browserType
	 * @return WebDriver
	 */
	private static WebDriver chooseDriver(String browserType) {
		System.out.println("Inside chooseDriver() ");
		DesiredCapabilities capabilities;
		// String preferredDriver = System.getProperty(browserType, "Firefox");
		System.out.println("browserType : " + browserType);
		boolean headless = System.getProperty("Headless", "false").equals(
				"true");
		switch (browserType.toLowerCase()) {

		case "chrome":
			System.out
					.println("********************* before driver created ************* ");
			// TBD
			System.setProperty("webdriver.chrome.driver",
					".\\src\\test\\resources\\Webdrivers\\chromedriver.exe");
			HashMap chromePrefs = new HashMap();
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			options.addArguments(new String[] { "--disable-notifications" });
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability("acceptSslCerts", true);
			cap.setCapability("goog:chromeOptions", options);
			driver = new ChromeDriver(options);
			System.out
					.println("********************* after driver created ***********");
			break;

		case "ie":
			System.out
					.println("********************* before driver created ************* ");
			//TBD
			System.setProperty("webdriver.ie.driver", ".\\IEDriverServer.exe");
			capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability("ignoreProtectedModeSettings", true);
			capabilities.setCapability("unexpectedAlertBehaviour", "ignore");
			capabilities.setCapability("ie.ensureCleanSession", true);
			capabilities.setCapability("disable-popup-blocking", true);
			capabilities.setPlatform(Platform.WINDOWS);
			capabilities.setCapability("ignoreProtectedModeSettings", true);
			capabilities.setCapability("nativeEvents", true);
			driver = new InternetExplorerDriver(capabilities);
			System.out
					.println("********************* after driver created ***********");
			break;

		case "firefox":
			System.out
					.println("********************* before driver created ************* ");
			System.setProperty("webdriver.gecko.driver",
					".\\src\\test\\resources\\Webdrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			System.out
					.println("********************* after driver created ***********");
			break;

		case "phantomjs":
			// return new PhantomJSDriver(capabilities);

		default:
			System.setProperty("webdriver.gecko.driver",
					".\\src\\test\\resources\\Webdrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		}
		return driver;
	}

	public static void closeDriver() {
		if (driver != null) {
			try {
				driver.close();
				driver.quit(); // fails in current geckodriver! TODO: Fixme
			} catch (NoSuchMethodError nsme) { // in case quit fails
			} catch (NoSuchSessionException nsse) { // in case close fails
			} catch (SessionNotCreatedException snce) {
			} // in case close fails
			driver = null;
		}
	}

}
