package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import data.LoadProperties;
import utilities.Helper;

public class TestBase2 {

	// Sauce labs configurations
	public static final String SAUCE_URL = LoadProperties.sauceLabsData.getProperty("seleniumUrl");

	public static String BaseURL = "https://demo.nopcommerce.com/";
	protected ThreadLocal<RemoteWebDriver> getDriver = null;

	@BeforeClass
	@Parameters(value = { "browser" })
	public void setup(@Optional("chrome") String browser) throws MalformedURLException {
		getDriver = new ThreadLocal<>();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", browser);
		// Selenium Grid Local
		// getDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
		// caps));

		// SauceLabs
		getDriver.set(new RemoteWebDriver(new URL(SAUCE_URL), caps));

		getDriver().navigate().to(BaseURL);
	}

	public WebDriver getDriver() {
		return getDriver.get();
	}

	@AfterClass
	public void stopDriver() {
		getDriver().quit();
		getDriver.remove();
	}

	// take screenshot on failure after every method
	@AfterMethod
	public void takeScreenshotOnFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed");
			System.out.println("Taking screenshot...");
			Helper.captureScreenShot(getDriver(), result.getName());
		}
	}
}
