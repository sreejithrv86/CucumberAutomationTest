package com.org.runner.TestRunner;

import java.util.stream.Stream;

public class CucumberRunner{
	
	 private static String[] defaultOptions = {
	            "--glue", "com/org/stepDef",
	            "--plugin", "json:report/cucumber/cucumber_report.json",
	            //"--plugin", "html:report/cucumber/cucumber_html_report.html",
	            "--plugin", "pretty",
	            "--plugin", "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
	            "--monochrome"
	            
	    };

	 public static void main(String[] args) {
		  
	        Stream<String> cucumberOptions = Stream.concat(Stream.of(defaultOptions), Stream.of(args));
	        io.cucumber.core.cli.Main.main(cucumberOptions.toArray(String[]::new));
	    }
	 
}