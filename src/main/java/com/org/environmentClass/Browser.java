package com.org.environmentClass;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.util.internal.StringUtil;

public class Browser {
	
	public static String getBrowserName() {
		
		switch (System.getProperty("browsername").toLowerCase()) {
		case "chrome":
		case "googlechrome":
		case "google chrome":
		default:
			return "chrome";
		case "ff":
		case "firefox":
		case "fire fox":
			return "firefox";
		case "edge":
		case "ms edge":
		case "msedge":
			return "edge";
		}
		
		
	}

}
