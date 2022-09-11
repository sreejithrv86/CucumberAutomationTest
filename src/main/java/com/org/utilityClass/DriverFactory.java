package com.org.utilityClass;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	private DriverFactory() {

	}

	private static DriverFactory instance = new DriverFactory();

	public static DriverFactory getInstance() {
		return instance;
	}

	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public void setDriver(WebDriver driverParam) {
		driver.set(driverParam);
	}

	public WebDriver getDriver() {
		return driver.get();
	}

	public void clearBrowser() {
		driver.get().quit();
		driver.remove();
		
	}

}
