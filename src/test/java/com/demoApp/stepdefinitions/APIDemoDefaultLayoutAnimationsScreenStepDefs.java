package com.demoApp.stepdefinitions;

import com.demoApp.library.Log;
import com.demoApp.library.ThreadLocalDriver;
import com.demoApp.pages.APIDemoDefaultLayoutAnimationsScreen;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;



public class APIDemoDefaultLayoutAnimationsScreenStepDefs {

    AppiumDriver driver = ThreadLocalDriver.getTLDriver();
    APIDemoDefaultLayoutAnimationsScreen apiDemoDefaultLayoutAnimationsScreen;

    public APIDemoDefaultLayoutAnimationsScreenStepDefs() {
        apiDemoDefaultLayoutAnimationsScreen = new APIDemoDefaultLayoutAnimationsScreen(driver);
    }

    @When("^I tap add button \"([^\"]*)\" times$")
    public void iTapAddButton(int times) {
        apiDemoDefaultLayoutAnimationsScreen.tapbutton(times);
        Log.info("The add button is tapped " + times + " times!!");
    }

    @Then("^I should see \"([^\"]*)\" buttons displayed$")
    public void iVerifyButtonDisplay(int buttons) {
        Assert.assertEquals(apiDemoDefaultLayoutAnimationsScreen.getbuttons(), buttons, "The no. of buttons displayed is invalid!!");
        Log.info("The button " + buttons + " is displayed successfully!!");

    }
}
