package com.demoApp.stepdefinitions;

import com.demoApp.library.Log;
import com.demoApp.library.ThreadLocalDriver;
import com.demoApp.pages.*;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import static org.testng.Assert.fail;



public class CommonScreenStepDefs {

    AppiumDriver driver = ThreadLocalDriver.getTLDriver();
    APIDemoAnimationScreen apiDemoAnimationScreen;
    APIDemoLandingScreen apiDemoLandingScreen;
    APIDemoDefaultLayoutAnimationsScreen apiDemoDefaultLayoutAnimationsScreen;
    APIDemoContentScreen apiDemoContentScreen;
    APIDemoResourcesScreen apiDemoResourcesScreen;
    APIDemoLayoutReferenceScreen apiDemoLayoutReferenceScreen;
    APIDemoAssetScreen apiDemoAssetScreen;
    APIDemoReadAssetScreen apiDemoReadAssetScreen;
    APIDemoPreferenceScreen apiDemoPreferenceScreen;
    APIDemoDefaultValuesScreen apiDemoDefaultValuesScreen;

    public CommonScreenStepDefs() {
        apiDemoAnimationScreen = new APIDemoAnimationScreen(driver);
        apiDemoLandingScreen = new APIDemoLandingScreen(driver);
        apiDemoDefaultLayoutAnimationsScreen = new APIDemoDefaultLayoutAnimationsScreen(driver);
        apiDemoContentScreen = new APIDemoContentScreen(driver);
        apiDemoResourcesScreen = new APIDemoResourcesScreen(driver);
        apiDemoLayoutReferenceScreen = new APIDemoLayoutReferenceScreen(driver);
        apiDemoAssetScreen = new APIDemoAssetScreen(driver);
        apiDemoReadAssetScreen = new APIDemoReadAssetScreen(driver);
        apiDemoPreferenceScreen = new APIDemoPreferenceScreen(driver);
        apiDemoDefaultValuesScreen = new APIDemoDefaultValuesScreen(driver);
    }

    @When("^I navigate to \"([^\"]*)\" screen$")
    public void iNavigatetoscreen(String screen) {
        switch (screen) {
            case "Animation":
                apiDemoLandingScreen.tapAnimation();
                break;
            case "Content":
                apiDemoLandingScreen.tapContent();
                break;
            case "Preference":
                apiDemoLandingScreen.tapPreference();
                break;
            case "Resources":
                apiDemoContentScreen.tapResources();
                break;
            case "Layout Reference":
                apiDemoResourcesScreen.tapLayoutRReference();
                break;
            case "Default Layout Animations":
                apiDemoAnimationScreen.tapDefaultLayoutAnimations();
                break;
            case "Assets":
                apiDemoContentScreen.tapAssets();
                break;
            case "Read Asset":
                apiDemoAssetScreen.tapreadasset();
                break;
            case "Default Values":
                apiDemoPreferenceScreen.tapdefaultvalues();
                break;
        }
        Log.info("User is navigated to " + screen + " screen successfully!!");
    }


    @Then("^I should be landed successfully on \"([^\"]*)\" screen$")
    public void iVerifyLandedScreen(String screen) {
        switch (screen) {
            case "Animation":
                Assert.assertTrue(apiDemoAnimationScreen.verifyAnimationScreen(), "Animation screen is not displayed!!");
                break;
            case "Content":
                Assert.assertTrue(apiDemoContentScreen.verifyContentScreen(), "Content screen is not displayed!!");
                break;
            case "Resources":
                Assert.assertTrue(apiDemoResourcesScreen.verifyResourcesScreen(), "Resources screen is not displayed!!");
                break;
            case "Default Layout Animations":
                Assert.assertTrue(apiDemoDefaultLayoutAnimationsScreen.verifyDefaultLaoyoutAnimationScreen(), "Default Layout Animations screen is not displayed!!");
                break;
            case "Layout Reference":
                Assert.assertTrue(apiDemoLayoutReferenceScreen.verifyLayoutReferenceScreen(), "Layout Reference screen is not displayed!!");
                break;
            case "Assets":
                Assert.assertTrue(apiDemoAssetScreen.verifyAssetScreen(), "Asset screen is not displayed!!");
                break;
            case "Read Asset":
                if (!(apiDemoReadAssetScreen.getReadAssetScreen().contains("This text is stored in a raw Asset."))) {
                    fail("Read Asset screen is not displayed as expected!!");
                }
                break;
            case "Preference":
                Assert.assertTrue(apiDemoPreferenceScreen.verifyPreferenceScreen(), "Preference screen is not displayed!!");
                break;
            case "Default values":
                Assert.assertTrue(apiDemoDefaultValuesScreen.verifyDefaultValuesScreen(), "Default Values screen is not displayed!!");
                break;
        }
        Log.info("User is successfully landed on " + screen + " screen successfully!!");
    }
}
