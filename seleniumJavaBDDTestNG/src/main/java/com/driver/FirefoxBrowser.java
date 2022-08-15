package com.driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxBrowser extends BaseBrowser{
	
	/**
	 * This method helps to setup the Firefox driver for Testing.
	 * @return driver -> It returns the Firefox type WebDriver.
	 */
	@Override
	public WebDriver createDriver(){
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		return driver;
	}
}