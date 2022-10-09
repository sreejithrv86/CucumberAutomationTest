package com.org.generic.Environment;

public class Platform {
	
	public String getPlatFormType() {

		switch (System.getProperty("platform").toLowerCase()) {
		case "local":
		default:
			return "local";
		case "remote":
			return "remote";
		}
	}

}
