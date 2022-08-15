package com.utils;

import static com.constants.FrameworkConstant.EXPLICIT_MAXWAIT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.constants.FrameworkConstant;
import com.driver.DriverManager;

public class SeleniumHelper {
	
	/**
	 * This method clicks on the given element if it is clickable.
	 * @param element -> WebElement in which click operation needs to do.
	 */
	public static void clickElement(final WebElement element) {
		explicitWaitForElementToBeClickable(element).click();
	}
	
	/**
	 * This method enter value on the given element if it is visible and clickable.
	 * @param element -> WebElement in which value needs to enter.
	 * @param textToEnter -> Value to be entered.
	 */
	public static void enterText(final WebElement element, String textToEnter) {
		explicitWaitForElementToBeClickable(element).sendKeys(textToEnter);

	}
	
	/**
	 * This method clear the value on the given element.
	 * @param element -> WebElement in which value needs to clear.
	 * @param textToEnter -> Value tobe cleared.
	 */
	public static void clearText(final WebElement element) {
		explicitWaitForElementToBeClickable(element).clear();

	}
	
	/**
	 * Verify element is displayed on screen.
	 * @param element which needs to check
	 * @return return true if element present, else false.
	 */
	public static boolean isElementDisplayed(final WebElement element) {
		return explicitWaitForElementToBeClickable(element).isDisplayed();
	}
	
	/**
	 * Get text value from the element.
	 * @param element 
	 * @return text from the element
	 */
	public static String getText(final WebElement element) {
		try {
			return explicitWaitForElementToBeClickable(element).getText().trim();
		}catch(Exception e) {
			return null;
		}
		
	}
	
	/**
	 * Explicit wait for element to be clickable.
	 * @param element which needs to check
	 * @return WebElement
	 */
	public static WebElement explicitWaitForElementToBeClickable(final WebElement element) {
		return new WebDriverWait(DriverManager.getDriver(), EXPLICIT_MAXWAIT)
				.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * Navigate back to previous.
	 */
	public static void navigateBack() {
		DriverManager.getDriver().navigate().back();
	}

	/**
	 * Explicit wait for element to be present.
	 * @param element which needs to check
	 * @return WebElement
	 */
	public static WebElement explicitWaitForElementToBePresent(final WebElement element) {
		return new WebDriverWait(DriverManager.getDriver(), EXPLICIT_MAXWAIT)
				.until(ExpectedConditions.presenceOfElementLocated((By) element));
	}
	
	/**
	 * Explicit wait for element to be present with gien time.
	 * @param element which needs to check
	 * @return WebElement
	 */
	public static WebElement explicitWaitForElementToBePresent(final WebElement element, final int waitTime) {
		return new WebDriverWait(DriverManager.getDriver(), waitTime)
				.until(ExpectedConditions.presenceOfElementLocated((By) element));
	}
	  
	  /**
	   * This method verify the the current URL contains the searched element.
	   * @author Nisha Vekariya
	   * @param expectedURL -> expected URL to compare with
	   * @throws Exception -> Exception caller to handle the exception
	   * @return flag -> Returns true if expected and current URL is same else false
	   */
	  public boolean isUrlContains(final String searchElement) throws Exception {
	      return DriverManager.getDriver().getCurrentUrl().contains(searchElement);
	  }
	  
	    
	    /**
	     * This method launch the application.
	     * @param url-> URL to be launch
	     */
	    public void launch_URL(String url) {
	    	DriverManager.getDriver().get(url);
			
		}

	    /**
	     * This method refresh the application.
	     * @author Nisha
	     */
		public void refresh_Page() {
			DriverManager.getDriver().navigate().refresh();
		}
}

