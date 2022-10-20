package com.org.stepDef.Common;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.service.ExtentService;
import com.org.generic.Environment.Application;
import com.org.generic.Environment.Browser;
import com.org.generic.Environment.Environment;
import com.org.generic.Environment.Platform;
import com.org.generic.Utility.BrowserFactory;
import com.org.generic.Utility.DriverFactory;
import com.org.generic.Utility.FileReaderManager;
import com.org.generic.Utility.ReadPropertyFile;
import com.org.generic.Utility.ScenarioFactory;
import com.org.generic.Utility.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	BrowserFactory bf = new BrowserFactory();
	ReadPropertyFile propOps = new ReadPropertyFile();
	public TestContext testContext;
	Application appln = new Application();
	Browser browser = new Browser();
	Environment env = new Environment();
	Platform platform = new Platform();
	
	public Hooks() {
        this.testContext = new TestContext();
	}

	@Before
	public synchronized void tearUp(Scenario scenario) {
		ScenarioFactory.getInstance().setScenario(scenario);
		ExtentService.getInstance().setSystemInfo("Application Name", appln.getApplicationName().toUpperCase());
		ExtentService.getInstance().setSystemInfo("Environment Name", env.getEnvironmentName().toUpperCase());
		ExtentService.getInstance().setSystemInfo("Browser Name", browser.getBrowserName().toUpperCase());
		ExtentService.getInstance().setSystemInfo("Platform Name", platform.getPlatFormType().toUpperCase());
		ExtentService.getInstance().setSystemInfo("OS Name", System.getProperty("os.name").toUpperCase());
		ExtentService.getInstance().setSystemInfo("Tester Name", System.getProperty("user.name").toUpperCase());
		ExtentService.getInstance().setSystemInfo("Scenario Name", ScenarioFactory.getInstance().getScenario().getName().toUpperCase());
		ExtentService.getInstance().setSystemInfo("Time Stamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
		FileReaderManager.getInstance().setFilePropery(
				propOps.getProperty(appln.getApplicationName(), env.getEnvironmentName()));
		DriverFactory.getInstance().setDriver(bf.createBrowserInstance(browser.getBrowserName(), false));
		DriverFactory.getInstance().getDriver()
				.get(FileReaderManager.getInstance().getPropertyValueByKey("application.url"));

	}

	@After
	public synchronized void teardDown() {
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
