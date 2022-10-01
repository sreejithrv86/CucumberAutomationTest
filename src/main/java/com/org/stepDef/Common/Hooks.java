package com.org.stepDef.Common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;
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
		Reporter.assignAuthor(System.getProperty("user.name"));
		FileReaderManager.getInstance().setFilePropery(
				ReadPropertyFile.getProperty(Application.getApplicationName(), Environment.getEnvironmentName()));
		DriverFactory.getInstance().setDriver(bf.createBrowserInstance(Browser.getBrowserName(), false));
		DriverFactory.getInstance().getDriver()
				.get(FileReaderManager.getInstance().getPropertyValueByKey("application.url"));

	}

	@After
	public void teardDown(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				File sourcePath = ((TakesScreenshot) DriverFactory.getInstance().getDriver())
						.getScreenshotAs(OutputType.FILE);
				File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/"
						+ screenshotName + ".png");
				Files.copy(sourcePath, destinationPath);
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			} catch (IOException e) {
			}
		}
		DriverFactory.getInstance().clearBrowser();
		MyLogger.endTestCase(scenario.getName());
	}

	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getReportConfigPath()));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Start Time", new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date()));
		Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
		Reporter.setSystemInfo("Application Name", Application.getApplicationName());
		Reporter.setSystemInfo("Browser Name", Browser.getBrowserName());
		Reporter.setSystemInfo("Environment Name", Environment.getEnvironmentName());

	}

}
