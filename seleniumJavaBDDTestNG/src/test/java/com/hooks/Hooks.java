package com.hooks;

import com.driver.Driver;
import com.utils.CommonFunctionsHelper;
import com.utils.Log;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	@Before(order=0)
    public void beforeScenarioStart(){
		Log.logInfo("-----------------Start of Scenario-----------------");
    } 
	
	@Before(order=1)
    public void setUp() throws Exception {
		Driver.initialize();
    }
	
	@After(order=1)
    public void tearDown(Scenario scenario) {
		scenario.attach(CommonFunctionsHelper.getImageAsByte(), "image/png", "Screenshot");
		Driver.quit();
    }
	
	@After(order=0)
    public void afterScenarioFinish(io.cucumber.java.Scenario scenario){
		
        Log.logInfo("-----------------End of Scenario-----------------");
    } 
	
}
