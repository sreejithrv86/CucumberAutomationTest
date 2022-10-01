package com.org.generic.Report;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.org.generic.Utility.DriverFactory;
import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    static ExtentReports extent;
    static Date d = new Date();
    static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
    static String baseDir = "";
    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
        	baseDir = System.getProperty("user.dir").replace("\\target", "");
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(baseDir+"/target/extent-report/"+fileName);

            htmlReporter.loadXMLConfig(".\\src\\main\\resources\\reports\\ExtentReport\\extent-config.xml");
            htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
            htmlReporter.config().setChartVisibilityOnOpen(true);
            htmlReporter.config().setTheme(Theme.STANDARD);
            htmlReporter.config().setDocumentTitle(fileName);
            htmlReporter.config().setEncoding("utf-8");
            htmlReporter.config().setReportName(fileName);
            //htmlReporter.setAppendExisting(true);

            extent = new ExtentReports();
            extent.setAnalysisStrategy(AnalysisStrategy.TEST);
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("Automation Analyst", System.getProperty("user.name"));
            extent.setSystemInfo("Organization", "Auto Organization");
            extent.setSystemInfo("Build no", "W2A-1234");
        }
        return extent;
    }

    public static String screenshotPath;
    public static String screenshotName;
    static int i=0;
    public static void captureScreenshot() {
        i = i + 1;
        File scrFile = ((TakesScreenshot) DriverFactory.getInstance()).getScreenshotAs(OutputType.FILE);

        Date d = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("E dd MMM HH:mm:ss z yyyy");  
        String strDate = formatter.format(d);
        screenshotName = strDate.replace(":", "_").replace(" ", "_") + "_"+i+".jpg";
        baseDir = System.getProperty("user.dir").replace("\\target", "");
        try {
            FileUtils.copyFile(scrFile, new File(baseDir + "/target/extent-report/" + screenshotName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createExtentReportDirectory() {
    	baseDir = System.getProperty("user.dir").replace("\\target", "");
        File file = new File(baseDir + "/target/extent-report/");
        if (!file.exists()) {
            if (file.mkdir()) {
            } else {
            }
        }
    }
}
