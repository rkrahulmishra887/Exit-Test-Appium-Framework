package com.demoApp.pages;

import com.demoApp.library.BaseTest;
import com.demoApp.pageobjects.APIDemoPreferenceScreenPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static com.demoApp.wrappers.ElementWrappers.click;



public class APIDemoPreferenceScreen extends BaseTest {

    private AppiumDriver driver;
    APIDemoPreferenceScreenPageObjects apiDemoPreferenceScreenPageObjects = new APIDemoPreferenceScreenPageObjects();

    public APIDemoPreferenceScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), apiDemoPreferenceScreenPageObjects);
    }

    public boolean verifyPreferenceScreen() {
        boolean preferencescreenflag = false;
        try {
            apiDemoPreferenceScreenPageObjects.lnkpreferencefromxml.isDisplayed();
            apiDemoPreferenceScreenPageObjects.lnkfragment.isDisplayed();
            apiDemoPreferenceScreenPageObjects.lnkdefaultvalues.isDisplayed();
            apiDemoPreferenceScreenPageObjects.lnkheaders.isDisplayed();
            preferencescreenflag = true;
        } catch (Exception e) {
            System.out.println(e + ": Preference screen is not displayed!!");
        }
        return preferencescreenflag;
    }

    public void tapdefaultvalues() {
        click(driver, apiDemoPreferenceScreenPageObjects.lnkdefaultvalues);
    }
}
