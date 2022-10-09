package com.org.generic.Environment;

public class Browser {
	
	public String getBrowserName() {
		
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
