package com.org.stepDef.Common;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.org.generic.Environment.Application;
import com.org.generic.Environment.Browser;
import com.org.generic.Environment.Environment;
import com.org.generic.Utility.BrowserFactory;
import com.org.generic.Utility.DriverFactory;
import com.org.generic.Utility.FileReaderManager;
import com.org.generic.Utility.ReadPropertyFile;
import com.org.generic.Utility.ScenarioFactory;
import com.org.generic.Utility.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends commonSteps {
	BrowserFactory bf = new BrowserFactory();
	ReadPropertyFile propOps = new ReadPropertyFile();
	TestContext testContext;
	Application appln = new Application();
	Browser browser = new Browser();
	Environment env = new Environment();
	
	public Hooks(TestContext testContext) {
		super(testContext);
	}

	@Before
	public void tearUp(Scenario scenario) {
		FileReaderManager.getInstance().setFilePropery(
				propOps.getProperty(appln.getApplicationName(), env.getEnvironmentName()));
		DriverFactory.getInstance().setDriver(bf.createBrowserInstance(browser.getBrowserName(), false));
		ScenarioFactory.getInstance().setScenario(scenario);
		DriverFactory.getInstance().getDriver()
				.get(FileReaderManager.getInstance().getPropertyValueByKey("application.url"));

	}

	@After
	public void teardDown() {
		if (ScenarioFactory.getInstance().getScenario().isFailed()) {
			try {
				File screenshot = ((TakesScreenshot) DriverFactory.getInstance().getDriver())
						.getScreenshotAs(OutputType.FILE);
				byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
				ScenarioFactory.getInstance().getScenario().attach(fileContent, "image/png", "attachment");
			} catch (IOException e) {
			}
		}
		DriverFactory.getInstance().clearBrowser();
	}

}
