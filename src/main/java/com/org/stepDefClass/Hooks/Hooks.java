package com.org.stepDefClass.Hooks;

import com.org.utilityClass.BrowserFactory;
import com.org.utilityClass.DriverFactory;
import com.org.utilityClass.Environment;
import com.org.utilityClass.PropertiesOperations;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    BrowserFactory bf = new BrowserFactory();
    Environment environment = new Environment();
    PropertiesOperations props = new PropertiesOperations();
	@Before
	public void tearUp() {
		environment.setBrowserName(System.getProperty("browsername"));
		environment.setEnvironmentName(System.getProperty("environmentname"));
		environment.setApplicationName(System.getProperty("applicationname"));
		DriverFactory.getInstance().setDriver(bf.createBrowserInstance(environment.getBrowserName(), false));
		DriverFactory.getInstance().getDriver().get(props.getPropertyValueByKey("application.url", environment.getApplicationName(), environment.getEnvironmentName()));
		
	}
	
	@After
	public void teardDown() {
		DriverFactory.getInstance().clearBrowser();
	}
	
	
}
