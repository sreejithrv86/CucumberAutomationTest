package com.org.runnerClass;

import java.util.stream.Stream;

public class TestRunner {
	
	 private static String[] defaultOptions = {
	            "--glue", "com.org.stepDefClass",
	            "--plugin", "pretty",
	            "--plugin", "json:cucumber.json"
	    };

	 public static void main(String[] args) {
	        Stream<String> cucumberOptions = Stream.concat(Stream.of(defaultOptions), Stream.of(args));
	        io.cucumber.core.cli.Main.main(cucumberOptions.toArray(String[]::new));
	    }
}