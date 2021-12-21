package com.demoApp.pages;

import com.demoApp.library.BaseTest;
import com.demoApp.pageobjects.APIDemoContentScreenPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static com.demoApp.wrappers.ElementWrappers.click;


public class APIDemoContentScreen extends BaseTest {

    private AppiumDriver driver;
    APIDemoContentScreenPageObjects apiDemoContentScreenPageObjects = new APIDemoContentScreenPageObjects();

    public APIDemoContentScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), apiDemoContentScreenPageObjects);
    }

    public boolean verifyContentScreen() {
        boolean contentscreenflag = false;
        try {
            apiDemoContentScreenPageObjects.lnkassets.isDisplayed();
            apiDemoContentScreenPageObjects.lnkclipboard.isDisplayed();
            apiDemoContentScreenPageObjects.lnkresources.isDisplayed();
            contentscreenflag = true;
        } catch (Exception e) {
            System.out.println(e + ": Content screen is not displayed!!");
        }
        return contentscreenflag;
    }

    public void tapResources() {
        click(driver, apiDemoContentScreenPageObjects.lnkresources);
    }

    public void tapAssets() {
        click(driver, apiDemoContentScreenPageObjects.lnkassets);
    }
}
