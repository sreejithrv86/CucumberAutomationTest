package com.org.stepDef.Common;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.google.common.io.Files;
import com.org.generic.Environment.Application;
import com.org.generic.Environment.Browser;
import com.org.generic.Environment.Environment;
import com.org.generic.Log.MyLogger;
import com.org.generic.Utility.BrowserFactory;
import com.org.generic.Utility.DriverFactory;
import com.org.generic.Utility.FileReaderManager;
import com.org.generic.Utility.ReadPropertyFile;
import com.org.generic.Utility.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends commonSteps {
	BrowserFactory bf = new BrowserFactory();
	ReadPropertyFile propOps = new ReadPropertyFile();
	TestContext testContext;

	public Hooks(TestContext testContext) {
		super(testContext);
	}

	@Before
	public void tearUp(Scenario scenario) {
		MyLogger.startTestCase(scenario.getName());
		FileReaderManager.getInstance().setFilePropery(
				ReadPropertyFile.getProperty(Application.getApplicationName(), Environment.getEnvironmentName()));
		DriverFactory.getInstance().setDriver(bf.createBrowserInstance(Browser.getBrowserName(), false));
		DriverFactory.getInstance().getDriver()
				.get(FileReaderManager.getInstance().getPropertyValueByKey("application.url"));

	}

	@After
	public void teardDown(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				File screenshot = ((TakesScreenshot)DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
				byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
				scenario.attach(fileContent, "image/png", "image1");
			} catch (IOException e) {
			}
		}
		DriverFactory.getInstance().clearBrowser();
		MyLogger.endTestCase(scenario.getName());
	}
	

}
