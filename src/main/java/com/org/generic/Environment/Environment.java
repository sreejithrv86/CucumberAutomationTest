package com.org.generic.Environment;

public class Environment {

	public static String getEnvironmentName() {

		switch (System.getProperty("envname").toLowerCase()) {
		case "uat":
		case "aut":
		default:
			return "uat";
		case "qa":
			return "qa";
		case "prod":
			return "prod";
		}
	}

}
