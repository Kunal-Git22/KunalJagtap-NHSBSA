package com.driver;

import org.openqa.selenium.WebDriver;

import com.utils.Log;

public abstract class BaseBrowser {

	/** WebDriver instance */
	public WebDriver driver;

	/** Create the WebDriver type object based on the browser. */
	public abstract WebDriver createDriver();

	/** This method close and quite the Webdriver. */
	public void quit() {
		if (driver != null) {
			driver.close();
			driver.quit();
			Log.logInfo("Browser is closed successfully.");
		}
	}

}
