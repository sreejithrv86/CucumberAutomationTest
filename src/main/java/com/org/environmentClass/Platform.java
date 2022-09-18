package com.org.environmentClass;

public class Platform {
	
	public static String getPlatFormType() {

		switch (System.getProperty("platform").toLowerCase()) {
		case "local":
		default:
			return "local";
		case "remote":
			return "remote";
		}
	}

}
