package com.org.runner.TestRunner;

import java.util.stream.Stream;

public class CucumberRunner{
	
	 private static String[] defaultOptions = {
	            "--glue", "com/org/stepDef",
	            "--plugin", "json:target/report/cucumber/cucumber_report.json",
	            "--plugin", "pretty",
	            "--plugin", "html:target/report/cucumber/cucumber_report.html",
	            "--plugin", "rerun:target/report/cucumber/cucumber_rerun.txt",
	            "--plugin", "junit:target/report/cucumber/cucumber_report.xml",
	            "--plugin", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
	            "--monochrome"
	            
	    };

	 public static void main(String[] args) {
		  
	        Stream<String> cucumberOptions = Stream.concat(Stream.of(defaultOptions), Stream.of(args));
	        io.cucumber.core.cli.Main.main(cucumberOptions.toArray(String[]::new));
	    }
	 
}