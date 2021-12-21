package com.demoApp.pages;

import com.demoApp.library.BaseTest;
import com.demoApp.pageobjects.APIDemoLayoutResourcesScreenPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;



public class APIDemoLayoutReferenceScreen extends BaseTest {

    private AppiumDriver driver;
    APIDemoLayoutResourcesScreenPageObjects apiDemoLayoutResourcesScreenPageObjects = new APIDemoLayoutResourcesScreenPageObjects();

    public APIDemoLayoutReferenceScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), apiDemoLayoutResourcesScreenPageObjects);
    }

    public boolean verifyLayoutReferenceScreen() {
        boolean layoutrefscreenflag = false;
        try{
            apiDemoLayoutResourcesScreenPageObjects.lbllaouytrefcontent.isDisplayed();
            apiDemoLayoutResourcesScreenPageObjects.lbllayoutreferenceheader.isDisplayed();
            layoutrefscreenflag = true;
        } catch (Exception e) {
            System.out.println(e + ": Layout Reference screen is not displayed!!");
        }
        return layoutrefscreenflag;
    }
}
