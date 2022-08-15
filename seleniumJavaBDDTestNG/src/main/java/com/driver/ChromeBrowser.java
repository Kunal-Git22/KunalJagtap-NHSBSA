package com.driver;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeBrowser extends BaseBrowser{
	
	/** The ChromeOption instance to set the options for Chrome Browser */
	private ChromeOptions options;
	
	/**
	 * This method helps to setup the Chrome driver for Testing.
	 * @return driver -> It returns the Chrome type WebDriver.
	 */
	@Override
	public WebDriver createDriver(){
		WebDriverManager.chromedriver().setup();
		browserSetting();
		driver = new ChromeDriver(options);
		return driver;
	}
	
	/** This method helps to setup the ChromeOption instance. */
	private void setChromeOption(){
		if(options == null){
			options = new ChromeOptions();
		}
	}
	
	/**
	 * This method helps to do the settings on Chrome browser.
	 */
	private void browserSetting(){
		setChromeOption();
		options.addArguments("disable-infobars");
		options.setAcceptInsecureCerts(true);
		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	}
	
	

}
