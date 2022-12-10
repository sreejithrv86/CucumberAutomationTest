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
	Application appln = new Application();
	Browser browser = new Browser();
	Environment env = new Environment();
	Platform platform = new Platform();
	private String Application_Name = "Application Name";
	private String Environment_Name = "Environment Name";
	private String Browser_Name = "Browser Name";
	private String Platform_Name = "Platform Name";
	private String OS_Name = "OS Name";
	private String Tester_Name = "Tester Name";
	private String Scenario_Name = "Scenario Name";
	private String Time_Stamp = "Time Stamp";

	@Before
	public synchronized void tearUp(Scenario scenario) {
		ScenarioFactory.getInstance().setScenario(scenario);
		ExtentService.getInstance().setSystemInfo(Application_Name, appln.getApplicationName().toUpperCase());
		ExtentService.getInstance().setSystemInfo(Environment_Name, env.getEnvironmentName().toUpperCase());
		ExtentService.getInstance().setSystemInfo(Browser_Name, browser.getBrowserName().toUpperCase());
		ExtentService.getInstance().setSystemInfo(Platform_Name, platform.getPlatFormType().toUpperCase());
		ExtentService.getInstance().setSystemInfo(OS_Name, System.getProperty("os.name").toUpperCase());
		ExtentService.getInstance().setSystemInfo(Tester_Name, System.getProperty("user.name").toUpperCase());
		ExtentService.getInstance().setSystemInfo(Scenario_Name,
				ScenarioFactory.getInstance().getScenario().getName().toUpperCase());
		ExtentService.getInstance().setSystemInfo(Time_Stamp,
				LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
		FileReaderManager.getInstance()
				.setFilePropery(propOps.getProperty(appln.getApplicationName(), env.getEnvironmentName()));
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
