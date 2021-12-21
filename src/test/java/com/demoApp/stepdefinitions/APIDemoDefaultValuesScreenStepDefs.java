package com.demoApp.stepdefinitions;

import com.demoApp.constants.ExcelParameters;
import com.demoApp.library.ExcelReader;
import com.demoApp.library.Log;
import com.demoApp.library.ThreadLocalDriver;
import com.demoApp.pages.APIDemoDefaultValuesScreen;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;

import java.util.Map;



public class APIDemoDefaultValuesScreenStepDefs {
    AppiumDriver driver = ThreadLocalDriver.getTLDriver();
    APIDemoDefaultValuesScreen apiDemoDefaultValuesScreen;
    public static String favouriteanimal;
    public static String listpreferred;

    public APIDemoDefaultValuesScreenStepDefs() {
        apiDemoDefaultValuesScreen = new APIDemoDefaultValuesScreen(driver);
    }

    @Then("^I verify the checbox preference is \"([^\"]*)\"$")
    public void iVerifyCheckboxpreference(String checkboxstatus) {
        if (checkboxstatus.equalsIgnoreCase("checked")) {
            Assert.assertEquals(apiDemoDefaultValuesScreen.verifychecboxstatus(), "true", "Checkbox status is not set as true!!");
        } else {
            Assert.assertEquals(apiDemoDefaultValuesScreen.verifychecboxstatus(), "false", "Checkbox status is set as true!!");
        }
        Log.info("The checkbox preference is " + checkboxstatus);
    }


    @When("^I tap the checkbox preference$")
    public void iTapChecboxpreference() {
        apiDemoDefaultValuesScreen.tapCheckboxpreference();
        Log.info("The checkbox preference is tapped successfully!!");
    }

    @When("^I tap edit text preference$")
    public void iTapEdittxtpreference() {
        apiDemoDefaultValuesScreen.tapEditTextpreference();
        Log.info("The edit text preference is tapped successfully!!");
    }

    @Then("^I verify \"([^\"]*)\" panel is shown$")
    public void iVerifyPanel(String panel) {
        if (panel.equalsIgnoreCase("Enter favourite Animal")) {
            Assert.assertTrue(apiDemoDefaultValuesScreen.verifyParentPanel(), "Parent Panel is not shown!!");
            Assert.assertEquals(apiDemoDefaultValuesScreen.getHeaderParentPanel(), "Enter your favorite animal");
        } else {
            Assert.assertTrue(apiDemoDefaultValuesScreen.verifyParentPanel(), "Parent Panel is not shown!!");
            Assert.assertEquals(apiDemoDefaultValuesScreen.getHeaderParentPanel(), "Choose one");
        }
        Log.info("The panel " + panel + " is shown successfully!!");
    }

    @When("^I enter a favourite animal$")
    public void iEnterFavouriteAnimal() {
        ExcelReader excel = new ExcelReader();
        Map<ExcelParameters.Preferences, String> getPreferences = excel.getPreferences().get(0);
        favouriteanimal = getPreferences.get(ExcelParameters.Preferences.FAVOURITEANIMAL);
        apiDemoDefaultValuesScreen.enterFavouriteAnimal(favouriteanimal);
        Log.info("Favourite animal is entered successfully!!");
    }

    @Then("^I verify the the favourite animal is entered$")
    public void iVerifyEnteredAnimal() {
        Assert.assertEquals(apiDemoDefaultValuesScreen.enteredAnimal(), favouriteanimal, "Entered animal is not correct!!");
        apiDemoDefaultValuesScreen.tapOk();
        Log.info("Favourite animal is verified successfully!!");
    }

    @When("^I tap List preference$")
    public void iTapListpreference() {
        apiDemoDefaultValuesScreen.tapListPreference();
        Log.info("List preference is tapped successfully!!");
    }

    @When("^I select the preferred option in the List preference$")
    public void iSelectlistpreference() {
        ExcelReader excel = new ExcelReader();
        Map<ExcelParameters.Preferences, String> getPreferences = excel.getPreferences().get(0);
        listpreferred = getPreferences.get(ExcelParameters.Preferences.LISTPREFERENCE);
        apiDemoDefaultValuesScreen.selectListPreference(listpreferred);
        Log.info("Preferred option in the List preference is selected successfully!!");
    }

    @Then("^I verify the preferred option is selected in the List preference$")
    public void iVerifySelectedList() {
        Assert.assertTrue(apiDemoDefaultValuesScreen.verifySelectedList(listpreferred), "The expected option is not selected!!");
        apiDemoDefaultValuesScreen.tapcancel();
        Log.info("Preferred option in the List preference is verified successfully!!");
    }
}

