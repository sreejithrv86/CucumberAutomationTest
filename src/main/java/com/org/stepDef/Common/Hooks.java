package com.org.stepDef.Common;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.org.generic.Environment.Application;
import com.org.generic.Environment.Browser;
import com.org.generic.Environment.Environment;
import com.org.generic.Log.MyLogger;
import com.org.generic.Report.ExtentTestManager;
import com.org.generic.Utility.BrowserFactory;
import com.org.generic.Utility.DriverFactory;
import com.org.generic.Utility.PropertiesOperations;
import com.org.generic.Utility.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends commonSteps{
    BrowserFactory bf = new BrowserFactory();
    TestContext testContext;

    public Hooks(TestContext testContext) {
    	super(testContext);
    }
    
    @Before
	public void tearUp(Scenario scenario) {
    	MyLogger.startTestCase(scenario.getName());
    	ExtentTestManager.startTest(scenario.getName());
		DriverFactory.getInstance().setDriver(bf.createBrowserInstance(Browser.getBrowserName(), false));
		DriverFactory.getInstance().getDriver().get(PropertiesOperations.getPropertyValueByKey("application.url", Application.getApplicationName(),
				Environment.getEnvironmentName()));
		
	}
	
	@After
	public void teardDown(Scenario scenario) {
		  if(scenario.isFailed()) {
	            try {           
	            	ExtentTestManager.addScreenShotsOnFailure();
	            } catch (WebDriverException | IOException noSupportScreenshot) {
	                System.err.println(noSupportScreenshot.getMessage());
	            }
	        }
		DriverFactory.getInstance().clearBrowser();
		MyLogger.endTestCase(scenario.getName());
		ExtentTestManager.flushReport();
	}
	
	
}
