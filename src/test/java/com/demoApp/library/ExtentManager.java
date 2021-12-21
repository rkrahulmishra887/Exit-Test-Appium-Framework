package com.demoApp.library;

import java.io.File;
import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager {

static ExtentReports extent;
static String fileName ="DetailedTestReport.html";

    public static synchronized ExtentReports getReporter() {
    	
    	if(extent == null) {
		String startupPath = System.getProperty("user.dir");
    	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(startupPath + File.separator + "reports" + File.separator + fileName);
    	htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("APIDemoApp Execution Results");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName);
        htmlReporter.loadConfig(startupPath + File.separator + "src" + File.separator + "test" + File.separator + "java" + File.separator + "com" + File.separator + "demoApp" + File.separator + "config" + File.separator + "extent-config.xml");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setAnalysisStrategy(AnalysisStrategy.SUITE);
    	}
    	return extent;
	}
}
