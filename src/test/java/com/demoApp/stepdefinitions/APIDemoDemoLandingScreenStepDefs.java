package com.demoApp.stepdefinitions;

import com.demoApp.library.BaseTest;
import com.demoApp.library.Log;
import com.demoApp.library.ThreadLocalDriver;
import com.demoApp.pages.APIDemoLandingScreen;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;



public class APIDemoDemoLandingScreenStepDefs extends BaseTest {

    AppiumDriver driver = ThreadLocalDriver.getTLDriver();
    APIDemoLandingScreen apiDemoLandingScreen;

    public APIDemoDemoLandingScreenStepDefs() {
        apiDemoLandingScreen = new APIDemoLandingScreen(driver);
    }

    @Given("^I launch the app and verify I am on Landing screen$")
    public void i_am_on_landing_page() {
        Assert.assertTrue(apiDemoLandingScreen.verifyLandingScreenHeader(), "Landing screen is not displayed!!");
        Log.info("App is launched and user is shown with landing screen successfully!!");
    }

    @Then("^I verify the icons in the landing screen$")
    public void i_verify_icons_landingscreen() throws Exception {
        Assert.assertTrue(apiDemoLandingScreen.verifyAccessibility1icon(), "Accessibility1 icon is not displayed!!");
        Assert.assertTrue(apiDemoLandingScreen.verifyAccessibility2icon(), "Accessibility2 icon is not displayed!!");
        Assert.assertTrue(apiDemoLandingScreen.verifyAnimationicon(), "Animation icon is not displayed!!");
        Assert.assertTrue(apiDemoLandingScreen.verifyAppicon(), "App icon is not displayed!!");
        Assert.assertTrue(apiDemoLandingScreen.verifyMediaicon(), "Media icon is not displayed!!");
        Assert.assertTrue(apiDemoLandingScreen.verifyViewicon(), "View icon is not displayed!!");
        Log.info("The icons in the landing screen is verified successfully!!");
    }

}
