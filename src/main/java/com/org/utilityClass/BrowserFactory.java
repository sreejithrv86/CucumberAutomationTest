package com.org.utilityClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
    
	// create a webdriver object for a given browser
	@SuppressWarnings("deprecation")
	public WebDriver createBrowserInstance(String browserName, Boolean headLess) {
		WebDriver driver = null;
		DesiredCapabilities cap = null;
		try {
		switch (browserName) {
		case "chrome":
		case "googlechrome":
		case "google chrome":
		default:
			WebDriverManager.chromedriver().setup();
			cap = new DesiredCapabilities();
			cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			ChromeOptions chromeoptions = new ChromeOptions();
			chromeoptions.merge(cap);
			chromeoptions.addArguments("--incognito");
			chromeoptions.addArguments("start-maximized");
			if (headLess)
				chromeoptions.addArguments("--headless");
			driver = new ChromeDriver(chromeoptions);
			break;
		case "ff":
		case "firefox":
		case "fire fox":
			WebDriverManager.firefoxdriver().setup();
			cap = new DesiredCapabilities();
			cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			FirefoxOptions ffOptions = new FirefoxOptions();
			ffOptions.merge(cap);
			ffOptions.addArguments("-private");
			ffOptions.addArguments("start-maximized");
			if (headLess)
				ffOptions.setHeadless(true);
			driver = new FirefoxDriver(ffOptions);
			break;
		case "edge":
		case "ms edge":
		case "msedge":
			WebDriverManager.iedriver().setup();
			cap = new DesiredCapabilities();
			cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.merge(cap);
			edgeOptions.addArguments("-private");
			edgeOptions.addArguments("start-maximized");
			if (headLess)
				edgeOptions.addArguments("--headless");
			driver = new EdgeDriver(edgeOptions);
			break;
		}
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return driver;
	}

}
