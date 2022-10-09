package com.org.generic.Environment;

public class Application {
	
	public String getApplicationName() {

		switch (System.getProperty("applicationname").toLowerCase()) {
		case "phptravels":
		case "php travels":
		case "phptravel":
		case "php travel":
		default:
			return "phptravels";
		case "swaglabs":
		case "swag labs":
		case "swaglab":
		case "swag lab":
			return "swaglabs";
		}
	}

}
