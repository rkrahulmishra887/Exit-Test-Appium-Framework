package com.demoApp.library;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class ExtentTestManager extends BaseTest {

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    private static ExtentReports extent = ExtentManager.getReporter();

    public synchronized static ExtentTest getTest() {
        return extentTest.get();
    }

    public synchronized static ExtentTest createTest(String name, String description, String category) {
        ExtentTest test = extent.createTest(name, description);
        if (category != null && !category.isEmpty()) {test.assignCategory(category);}
        extentTest.set(test);
        return getTest();
    }
	  
	public synchronized static ExtentTest createTest(String name, String
	  description) { return createTest(name, description, null); }
	 
    public synchronized static ExtentTest createTest(String name) {
        return createTest(name, " ");
    }

}