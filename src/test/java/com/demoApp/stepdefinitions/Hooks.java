package com.demoApp.stepdefinitions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.demoApp.library.*;
import com.demoApp.wrappers.ElementWrappers;
import cucumber.api.PickleStepTestStep;
import cucumber.api.Result;
import cucumber.api.Scenario;
import cucumber.api.TestCase;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.File;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.demoApp.wrappers.ElementWrappers.*;



public class Hooks extends BaseTest {

    AppiumDriver driver = ThreadLocalDriver.getTLDriver();
    public String featureScenario = "";
    PropertyFileReader propertyFileReader;
    ExtentTestManager extent;
    public ExtentTest scenarios;
    public ExtentTest testStep;
    public ExtentTest errorStep;
    public static String timestampToAppend;
    public static ThreadLocal parentTest = new ThreadLocal();

    Map<String, Object> devices = new HashMap<>();

    public static void logError(Scenario scenario, ExtentTest extentTest) {
        Field field = FieldUtils.getField((scenario).getClass(), "stepResults", true);
        field.setAccessible(true);
        try {
            ArrayList<Result> results = (ArrayList<Result>) field.get(scenario);
            for (Result result : results) {
                if (result.getError() != null)
                    extentTest.error(result.getError());
            }
        } catch (Exception e) {
            extentTest.error(e);
        }
    }

    @Before
    public void startScenario(Scenario scenario) {
        getDeviceDetails();
        propertyFileReader = new PropertyFileReader();
        featureScenario = scenario.getName();
        timestampToAppend = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
        System.setProperty("timestampToAppend", timestampToAppend);
        DOMConfigurator.configure("src" + File.separator + "test" + File.separator + "java" + File.separator + "com" + File.separator + "demoApp"
                        + File.separator + "config" + File.separator +
                "log4j.xml");
        String featureName = ((scenario.getId().split("/")[5]).split("\\.")[0]).replaceAll("_", " ");

        if (!(isFeatureDuplicate(featureName, featuresNameList))) {
            ElementWrappers.features = extent.createTest(featureName);
            featuresNameList.put(featureName, features);
        } else {
            features = featuresNameList.get(featureName);
        }

        scenarios = ElementWrappers.features.createNode("<b>" + scenario.getName() + System.lineSeparator() + " - Device Name : " + devices.get("device") + "</b>");
        parentTest.set(scenarios);
    }


    @BeforeStep
    public void beforeStep(Scenario scenario) {
        timestamp = new Timestamp(System.currentTimeMillis());
    }

    @AfterStep
    public void afterStep(Scenario scenario) throws Exception {
        getDeviceDetails();
        String stepName = null;
        try {
            Field stepResultsField = FieldUtils.getField((scenario).getClass(), "stepResults", true);
            ArrayList<Result> stepresults = (ArrayList<Result>) stepResultsField.get(scenario);
            int sizeofresults = stepresults.size();
            if (sizeofresults >= 3) {
                Field testCaseField = FieldUtils.getField((scenario).getClass(), "testCase", true);
                TestCase testCase = (TestCase) testCaseField.get(scenario);
                Field testSteps = FieldUtils.getField((testCase).getClass(), "testSteps", true);
                ArrayList<PickleStepTestStep> pickleStepTestSteps = (ArrayList<PickleStepTestStep>) testSteps.get(testCase);
                int valuetouse = (sizeofresults / 3) - 1;
                stepName = pickleStepTestSteps.get(valuetouse).getPickleStep().getText();
            }
        } catch (Exception e) {

        }
        testStep = ((ExtentTest) parentTest.get()).createNode(stepName);
        if (scenario.getStatus().toString().equalsIgnoreCase("Failed")) {
            errorStep = testStep.createNode("Screenshot");
            errorStep.log(Status.FAIL, "<img src=\"data:image/png;base64," + getScrenshShotInBase64(getMobileScreenshot(ThreadLocalDriver.getTLDriver(), devices.get("device").toString())) + "\"/>");
            errorStep = testStep.createNode("Console Ouput");
            logError(scenario, errorStep);
        }
        if (scenario.getStatus().toString().equalsIgnoreCase("Passed")) {
            if (takeScreenEvidence.equalsIgnoreCase("true")) {
                String screeshot = getMobileScreenshot(ThreadLocalDriver.getTLDriver(), devices.get("device").toString());
                testStep.log(Status.PASS, "<img src=\"data:image/png;base64," + getScrenshShotInBase64(screeshot) + "\"/>");
            } else {
                testStep.pass("PASS");
            }
        } else {
            testStep.log(Status.SKIP, "Unable to execute this step because the above step failed");
        }
    }


    @After
    public void endScenario(Scenario scenario) {
        ExtentManager.getReporter().flush();
    }

    public void getDeviceDetails() {
        switch (driver.getCapabilities().getCapability("deviceName").toString()) {
            case "RFCN90WF8WB":
                devices.put("device", "Pixel 2");
                devices.put("platformName", "android");
                break;
            case "R58N22HW4PN":
                devices.put("device", "Pixel 2");
                devices.put("platformName", "android");
                break;
        }
    }

    public boolean isFeatureDuplicate(String featureName, Map<String, ExtentTest> featureNameList) {
        boolean isDuplicate = false;
        Set<String> featureListNames = featureNameList.keySet();
        Iterator<String> iterator = featureListNames.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equalsIgnoreCase(featureName)) {
                isDuplicate = true;
            }
        }
        if (isDuplicate) {
            return true;
        } else {
            return false;
        }
    }
}
