package com.org.runnerClass;

import java.util.stream.Stream;

public class TestRunner{
	
	 private static String[] defaultOptions = {
	            "--glue", "com/org/stepDefClass",
	            "--plugin", "json:report/cucumber/cucumber_report.json",
	            "--plugin", "html:report/cucumber/cucumber_html_report.html",
	            "--plugin", "pretty",
	            "--monochrome"
	            
	    };

	 public static void main(String[] args) {
		  
	        Stream<String> cucumberOptions = Stream.concat(Stream.of(defaultOptions), Stream.of(args));
	        io.cucumber.core.cli.Main.main(cucumberOptions.toArray(String[]::new));
	    }
	 
}