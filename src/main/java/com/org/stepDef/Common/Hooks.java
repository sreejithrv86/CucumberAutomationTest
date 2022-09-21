package com.org.stepDef.Common;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.org.generic.Environment.Application;
import com.org.generic.Environment.Browser;
import com.org.generic.Environment.Environment;
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
	
		DriverFactory.getInstance().setDriver(bf.createBrowserInstance(Browser.getBrowserName(), false));
		DriverFactory.getInstance().getDriver().get(PropertiesOperations.getPropertyValueByKey("application.url", Application.getApplicationName(),
				Environment.getEnvironmentName()));
		
	}
	
	@After
	public void teardDown(Scenario scenario) {
		  if(scenario.isFailed()) {
	            try {           
	                scenario.attach(((TakesScreenshot)DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES), "image/png", "screenshot");
	            } catch (WebDriverException noSupportScreenshot) {
	                System.err.println(noSupportScreenshot.getMessage());
	            }
	        }
		DriverFactory.getInstance().clearBrowser();
	}
	
	
}
