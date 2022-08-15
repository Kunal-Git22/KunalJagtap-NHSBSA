package com.stepDefinations;

import com.driver.Driver;
import com.driver.DriverManager;
import com.pageObject.NHSCostsPage;
import com.utils.Log;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NHSCosts {
    public NHSCostsPage nhs = new NHSCostsPage();

    @Given("I am a citizen of the UK")
    public void i_am_a_citizen_of_the_uk() {
        // Write code here that turns the phrase above into concrete actions
        DriverManager.getDriver().get(Driver.getUrl());
        nhs.verifyStartPageTitle();
        nhs.clickOnStartNow();
        Log.logInfo("Verified Stating Page Header Title");
    }

    @When("I put my circumstances into the Checker tool with Inputs {string},{string},{string},{string}")
    public void i_put_my_circumstances_into_the_checker_tool(String country, String partner, String taxCredits, String savings ) {
        // Write code here that turns the phrase above into concrete actions
        nhs.selectLivingCountry(country);
        nhs.selectGPPractice();
        nhs.selectDentalPractice();
        nhs.enterDateOfBirth();
        nhs.selectDoYouLiveWithPartner(partner);
        nhs.selectTaxCredits(taxCredits);
        nhs.selectInjury();
        nhs.selectCareHome();
        nhs.selectSavings(savings);
        Log.logInfo("Provided Required Information in Checker Tool");
    }

    @Then("I should get a result of whether I will get help or not")
    public void i_should_get_a_result_of_whether_i_will_get_help_or_not() {
        // Write code here that turns the phrase above into concrete actions
        nhs.verifyFinalPageHeaderTitle();
        Log.logInfo("Verified Final Page Header Title");
    }

}
