package com.org.stepDefClass;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.org.environmentClass.Application;
import com.org.environmentClass.Browser;
import com.org.environmentClass.Environment;
import com.org.utilityClass.BrowserFactory;
import com.org.utilityClass.DriverFactory;
import com.org.utilityClass.PropertiesOperations;
import com.org.utilityClass.TestContext;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Hooks {
    BrowserFactory bf = new BrowserFactory();
    TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }
    
    @Before
	public void tearUp() throws InterruptedException {
	
		DriverFactory.getInstance().setDriver(bf.createBrowserInstance(Browser.getBrowserName(), false));
		DriverFactory.getInstance().getDriver().get(PropertiesOperations.getPropertyValueByKey("application.url", Application.getApplicationName(),
				Environment.getEnvironmentName()));
		Thread.sleep(5000);
		
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
