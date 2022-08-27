package com.org.runnerClass;

import org.openqa.selenium.WebDriver;

public class TestRunner {
 
 public  static WebDriver driver; 
 
 public static void main(String args[]) throws Throwable{
  try {
   cucumber.api.cli.Main.main(
     new String[]{
     "classpath:features",
      "-t","@scenario_AccountPage",
     "-g", "com.sadakar.cucumber.stepdefinitions/", 
     "-g","com.org.stepDefClass",
     "-p","pretty", 
     "-p","json:target/cucumber-reports/Cucumber.json",
     "-p", "html:target/cucumber-reports",
     "-m"
     }
   ); 
  }
  catch(Exception e) {
    System.out.println("Main method exception");
  }
 }
}
