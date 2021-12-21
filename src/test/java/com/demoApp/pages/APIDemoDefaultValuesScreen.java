package com.demoApp.pages;

import com.demoApp.library.BaseTest;
import com.demoApp.pageobjects.APIDemoDefaultValuesScreenPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;
import static com.demoApp.wrappers.ElementWrappers.click;
import static com.demoApp.wrappers.ElementWrappers.enterText;



public class APIDemoDefaultValuesScreen extends BaseTest {

    private AppiumDriver driver;
    APIDemoDefaultValuesScreenPageObjects apiDemoDefaultValuesScreenPageObjects = new APIDemoDefaultValuesScreenPageObjects();

    public APIDemoDefaultValuesScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), apiDemoDefaultValuesScreenPageObjects);
    }

    public boolean verifyDefaultValuesScreen() {
        boolean defaultvaluescreenflag = false;
        try {
            apiDemoDefaultValuesScreenPageObjects.lbldefaultvaluesheader.isDisplayed();
            apiDemoDefaultValuesScreenPageObjects.lblcheckbox.isDisplayed();
            apiDemoDefaultValuesScreenPageObjects.lbledittxtpreference.isDisplayed();
            apiDemoDefaultValuesScreenPageObjects.lbllistpreference.isDisplayed();

            defaultvaluescreenflag = true;
        } catch (Exception e) {
            System.out.println(e + ": Default Value screen is not displayed!!");
        }
        return defaultvaluescreenflag;
    }

    public String verifychecboxstatus() {
        return apiDemoDefaultValuesScreenPageObjects.chkpreference.getAttribute("checked");
    }

    public void tapCheckboxpreference() {
        click(driver, apiDemoDefaultValuesScreenPageObjects.chkpreference);
    }

    public void tapEditTextpreference() {
        click(driver, apiDemoDefaultValuesScreenPageObjects.lbledittxtpreference);
    }

    public boolean verifyParentPanel() {
        return apiDemoDefaultValuesScreenPageObjects.lblparentpanel.isDisplayed();
    }

    public String getHeaderParentPanel() {
        return apiDemoDefaultValuesScreenPageObjects.lblparentpanelheader.getText();
    }

    public void tapOk() {
        click(driver, apiDemoDefaultValuesScreenPageObjects.btnok);
    }

    public void tapcancel() {
        click(driver, apiDemoDefaultValuesScreenPageObjects.btncancel);
    }

    public void enterFavouriteAnimal(String animal) {
        enterText(driver, apiDemoDefaultValuesScreenPageObjects.txtparentpanel, animal);
        tapOk();
    }

    public String enteredAnimal() {
        tapEditTextpreference();
        return apiDemoDefaultValuesScreenPageObjects.txtparentpanel.getText();
    }

    public void tapListPreference() {
        click(driver, apiDemoDefaultValuesScreenPageObjects.lbllistpreference);
    }

    public void selectListPreference(String listpreferred) {
        click(driver, By.xpath("//*[contains(@text, '" + listpreferred + "')]"));
    }

    public boolean verifySelectedList(String listpreferred){
        tapListPreference();
        boolean selectedlistFlag = false;
        try {
            driver.findElement(By.xpath("//*[contains(@text, '" + listpreferred + "')]")).isDisplayed();
            selectedlistFlag = true;
        } catch (Exception e) {
            System.out.println(e + ": The expected value is not selected!!");
        }
        return selectedlistFlag;

    }

}