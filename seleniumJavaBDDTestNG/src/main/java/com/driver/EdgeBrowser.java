package com.driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeBrowser extends BaseBrowser{
	
	/**
	 * This method helps to setup the Edge driver for Testing.
	 * @return driver -> It returns the Edge type WebDriver.
	 */
	@Override
	public WebDriver createDriver(){
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		return driver;
	}
}