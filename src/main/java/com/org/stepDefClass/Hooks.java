package com.org.stepDefClass;

import com.org.environmentClass.Application;
import com.org.environmentClass.Browser;
import com.org.environmentClass.Environment;
import com.org.utilityClass.BrowserFactory;
import com.org.utilityClass.DriverFactory;
import com.org.utilityClass.PropertiesOperations;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    BrowserFactory bf = new BrowserFactory();
    
    @Before
	public void tearUp() throws InterruptedException {
	
		DriverFactory.getInstance().setDriver(bf.createBrowserInstance(Browser.getBrowserName(), false));
		DriverFactory.getInstance().getDriver().get(PropertiesOperations.getPropertyValueByKey("application.url", Application.getApplicationName(),
				Environment.getEnvironmentName()));
		Thread.sleep(5000);
		
	}
	
	@After
	public void teardDown() {
		DriverFactory.getInstance().clearBrowser();
	}
	
	
}
