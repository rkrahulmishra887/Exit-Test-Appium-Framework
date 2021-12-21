package com.demoApp.pages;

import com.demoApp.library.BaseTest;
import com.demoApp.pageobjects.APIDemoResourcesScreenPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static com.demoApp.wrappers.ElementWrappers.click;



public class APIDemoResourcesScreen extends BaseTest {

    private AppiumDriver driver;
    APIDemoResourcesScreenPageObjects apiDemoResourcesScreenPageObjects = new APIDemoResourcesScreenPageObjects();

    public APIDemoResourcesScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), apiDemoResourcesScreenPageObjects);
    }

    public boolean verifyResourcesScreen() {
        boolean resourcesscreenflag = false;
        try {
            apiDemoResourcesScreenPageObjects.lnklayoutreference.isDisplayed();
            apiDemoResourcesScreenPageObjects.lnkresources.isDisplayed();
            apiDemoResourcesScreenPageObjects.lnkreferencewidth.isDisplayed();
            resourcesscreenflag = true;
        } catch (Exception e) {
            System.out.println(e + ": Resources screen is not displayed!!");
        }
        return resourcesscreenflag;
    }

    public void tapLayoutRReference() {
        click(driver, apiDemoResourcesScreenPageObjects.lnklayoutreference);
    }
}
