package com.demoApp.pages;

import com.demoApp.library.BaseTest;
import com.demoApp.pageobjects.APIDemoAssetsScreenPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static com.demoApp.wrappers.ElementWrappers.click;


public class APIDemoAssetScreen extends BaseTest {

    private AppiumDriver driver;
    APIDemoAssetsScreenPageObjects apiDemoAssetsScreenPageObjects = new APIDemoAssetsScreenPageObjects();

    public APIDemoAssetScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), apiDemoAssetsScreenPageObjects);
    }

    public boolean verifyAssetScreen() {
        boolean assetscreenflag = false;
        try {
            apiDemoAssetsScreenPageObjects.lnkreadasset.isDisplayed();
            assetscreenflag = true;
        } catch (Exception e) {
            System.out.println(e + ": Asset screen is not displayed!!");
        }
        return assetscreenflag;
    }

    public void tapreadasset() {
        click(driver, apiDemoAssetsScreenPageObjects.lnkreadasset);
    }
}
