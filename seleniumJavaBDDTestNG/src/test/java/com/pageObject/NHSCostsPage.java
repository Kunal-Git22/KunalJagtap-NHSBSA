package com.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.driver.DriverManager;
import com.utils.SeleniumHelper;

public class NHSCostsPage {

    // ----------------------- Objects ------------------------
    @FindBy(css = "[id='nhsuk-cookie-banner__link_accept_analytics']")
    WebElement btnAcceptCookies;
    @FindBy(css = "[class='heading-group'] h1")
    WebElement HdrStartingPageTitle;
    @FindBy(xpath = "//*[@id='next-button']")
    WebElement btnStartNow_Next;
    @FindBy(xpath = "//*[@id='dob-day']")
    WebElement txtDay;
    @FindBy(xpath = "//*[@id='dob-month']")
    WebElement txtMonth;
    @FindBy(xpath = "//*[@id='dob-year']")
    WebElement txtYear;
    @FindBy(xpath = "//*[@id='result-heading']")
    WebElement HdrFinalPageTitle;

    // ----------------------- Methods ------------------------

    /**
     * This constructer method set the driver and PageFactory
     */
    public NHSCostsPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void verifyStartPageTitle() {
        SeleniumHelper.clickElement(btnAcceptCookies);
        System.out.println("PAGE TITLE is - "+ HdrStartingPageTitle.getText());
        Assert.assertEquals(HdrStartingPageTitle.getText(), "Check what help you could get to pay for NHS costs");
    }

    public void clickOnStartNow() {
        SeleniumHelper.clickElement(btnStartNow_Next);
    }

    public void selectLivingCountry(String str) {
        SelectLivingCountry(str);
        SeleniumHelper.clickElement(btnStartNow_Next);
    }

    public void selectGPPractice() {
        SelectGPPractice("No");
        SeleniumHelper.clickElement(btnStartNow_Next);
    }

    public void selectDentalPractice() {
        SelectDentalPractice("ENGLAND");
        SeleniumHelper.clickElement(btnStartNow_Next);
    }

    public void selectDoYouLiveWithPartner(String str) {
        SelectDoYouLiveWithPartner(str);
        SeleniumHelper.clickElement(btnStartNow_Next);
    }

    public void enterDateOfBirth() {
        SeleniumHelper.enterText(txtDay, "31");
        SeleniumHelper.enterText(txtMonth, "07");
        SeleniumHelper.enterText(txtYear, "1961");
        SeleniumHelper.clickElement(btnStartNow_Next);
    }

    public void selectTaxCredits(String str) {
        SelectTaxCredits(str);
        SeleniumHelper.clickElement(btnStartNow_Next);
    }

    public void selectInjury() {
        SelectInjury("No");
        SeleniumHelper.clickElement(btnStartNow_Next);
    }

    public void selectCareHome() {
        SelectCareHome("No");
        SeleniumHelper.clickElement(btnStartNow_Next);
    }

    public void selectSavings(String str) {
        SelectSavings(str);
        SeleniumHelper.clickElement(btnStartNow_Next);
    }

    public void verifyFinalPageHeaderTitle() {
        Assert.assertTrue(HdrFinalPageTitle.getText()
                .equalsIgnoreCase("Based on what you've told us\n" + "You get help with NHS costs"));
    }

    public void SelectLivingCountry(String str) {
        List<WebElement> elements = DriverManager.getDriver()
                .findElements(By.xpath("//*[@id='livingCountry_fieldset']//div//label"));
        for (WebElement ele : elements) {
            if (ele.getText().equalsIgnoreCase(str)) {
                SeleniumHelper.clickElement(ele);
                break;
            }
        }
    }

    public void SelectGPPractice(String str) {
        List<WebElement> elements = DriverManager.getDriver()
                .findElements(By.xpath("//*[@id='gpPracticeInScotlandOrWales_fieldset']//div//label"));
        for (WebElement ele : elements) {
            if (ele.getText().equalsIgnoreCase(str)) {
                SeleniumHelper.clickElement(ele);
                break;
            }
        }
    }

    public void SelectDentalPractice(String str) {
        List<WebElement> elements = DriverManager.getDriver()
                .findElements(By.xpath("//*[@id='dentalPracticeCountry_fieldset']//div//label"));
        for (WebElement ele : elements) {
            if (ele.getText().equalsIgnoreCase(str)) {
                SeleniumHelper.clickElement(ele);
                break;
            }
        }
    }

    public void SelectDoYouLiveWithPartner(String str) {
        List<WebElement> elements = DriverManager.getDriver()
                .findElements(By.xpath("//*[@id='partner_fieldset']//div//label"));
        for (WebElement ele : elements) {
            if (ele.getText().equalsIgnoreCase(str)) {
                SeleniumHelper.clickElement(ele);
                break;
            }
        }
    }

    public void SelectTaxCredits(String str) {
        List<WebElement> elements = DriverManager.getDriver()
                .findElements(By.xpath("//*[@id='benefits-or-tax-credit_fieldset']//div//label"));
        for (WebElement ele : elements) {
            if (ele.getText().equalsIgnoreCase(str)) {
                SeleniumHelper.clickElement(ele);
                break;
            }
        }
    }

    public void SelectInjury(String str) {
        List<WebElement> elements = DriverManager.getDriver()
                .findElements(By.xpath("//*[@id='warPension_fieldset']//div//label"));
        for (WebElement ele : elements) {
            if (ele.getText().equalsIgnoreCase(str)) {
                SeleniumHelper.clickElement(ele);
                break;
            }
        }
    }

    public void SelectCareHome(String str) {
        List<WebElement> elements = DriverManager.getDriver()
                .findElements(By.xpath("//*[@id='inCareHome_fieldset']//div//label"));
        for (WebElement ele : elements) {
            if (ele.getText().equalsIgnoreCase(str)) {
                SeleniumHelper.clickElement(ele);
                break;
            }
        }
    }

    public void SelectSavings(String str) {
        List<WebElement> elements = DriverManager.getDriver()
                .findElements(By.xpath("//*[@id='savings_fieldset']//div//label"));
        for (WebElement ele : elements) {
            if (ele.getText().equalsIgnoreCase(str)) {
                SeleniumHelper.clickElement(ele);
                break;
            }
        }
    }
}
