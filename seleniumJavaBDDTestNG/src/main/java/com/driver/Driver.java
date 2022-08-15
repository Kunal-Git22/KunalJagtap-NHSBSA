package com.driver;

import org.openqa.selenium.WebDriver;
import com.utils.Log;
import com.utils.PropertyEnum;
import com.utils.PropertyHelper;

public class Driver {

	/**
	 * Initialize the driver based on selected browser and open the url operation.
	 * @throws InterruptedException 
	 */
	public static void initialize() throws InterruptedException {
		if (DriverManager.getDriver() == null) {
			new Driver();
		}
		Log.logInfo("Driver is initialized Successfully.");
	}

	/**
	 * Initialize the driver and open the url operation.
	 * 
	 * @throws InterruptedException
	 */
	private Driver() throws InterruptedException {
		selectDriverType();
		DriverManager.getDriver().manage().deleteAllCookies();
		DriverManager.getDriver().manage().window().maximize();
		Log.logInfo("Browser is opened and maximize successfully.");
	}

	public static String getUrl() {
		if (PropertyHelper.get(PropertyEnum.RUNMODE).equalsIgnoreCase("remote")) {
			return PropertyHelper.get(PropertyEnum.REMOTEURL).toString();
		} else {
			return PropertyHelper.get(PropertyEnum.URL).toString();
		}
	}

	/**
	 * Select the driver based on selected browser.
	 * 
	 * @param browser -> browser name using that can create the driver.
	 * @throws InterruptedException
	 */
	private void selectDriverType() throws InterruptedException {
		String browser = PropertyHelper.get(PropertyEnum.BROWSER).toString();
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeBrowser().createDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeBrowser().createDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxBrowser().createDriver();
			Thread.sleep(5000); //Adding due to slowness of Firefox browser
		}
		DriverManager.setWebDriver(driver);
		Log.logInfo("Driver is initialized with browser : " + browser);
	}

	/**
	 * Quit and close the driver and browser.
	 */
	public static void quit() {
		if (DriverManager.getDriver() != null) {
			DriverManager.getDriver().close();
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
		Log.logInfo("Browser is closed successfully.");
	}

}
