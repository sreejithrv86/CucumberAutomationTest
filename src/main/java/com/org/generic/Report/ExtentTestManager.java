package com.org.generic.Report;

import java.io.IOException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentTestManager {
	
	private ExtentTestManager() {

	}

	private static ExtentTestManager extTestManager = new ExtentTestManager();

	public static ExtentTestManager getInstance() {
		return extTestManager;
	}

    private static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
    private static ExtentReports extent = ExtentManager.getReporter();

    public static synchronized ExtentTest getTest() {
        return testReport.get();
    }

    public static synchronized void setTest(ExtentTest tst) 
    { 
        testReport.set(tst); 
    }

    public static synchronized void logInfo(String message) {

        testReport.get().info(message);
    }

    public static synchronized void logPass(String message) {

        testReport.get().pass(message);
    }

    public static synchronized void scenarioPass() {

        String passLogg = "SCENARIO PASSED";
        Markup m = MarkupHelper.createLabel(passLogg, ExtentColor.GREEN);
        testReport.get().log(Status.PASS, m);


    }

    public static synchronized void logFail(String message) {

        testReport.get().fail(message);
    }
    
    public static synchronized void flushReport() {

        testReport.remove();

    }

    public static synchronized boolean addScreenShotsOnFailure() throws IOException {

        ExtentManager.captureScreenshot();
        testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
		        MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName).build());

        String failureLogg = "SCENARIO FAILED";
        Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
        testReport.get().log(Status.FAIL, m);
        return true;
    }

    public static synchronized boolean addScreenShots() throws IOException {

        ExtentManager.captureScreenshot();
        testReport.get().info(("<b>" + "<font color=" + "green>" + "Screenshot" + "</font>" + "</b>"),
		        MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName).build());

        return true;
    }

    public static synchronized ExtentTest startTest(String testName) {
        return startTest(testName, "");
    }

    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extent.createTest(testName, desc);
        testReport.set(test);
        return test;
    }
}