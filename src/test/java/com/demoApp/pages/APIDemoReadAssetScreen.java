package com.demoApp.pages;

import com.demoApp.library.BaseTest;
import com.demoApp.pageobjects.APIDemoReadAssetScreenPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;



public class APIDemoReadAssetScreen extends BaseTest {

    private AppiumDriver driver;
    APIDemoReadAssetScreenPageObjects apiDemoReadAssetScreenPageObjects = new APIDemoReadAssetScreenPageObjects();

    public APIDemoReadAssetScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), apiDemoReadAssetScreenPageObjects);
    }

    public String getReadAssetScreen() {
        return apiDemoReadAssetScreenPageObjects.lblreadassetcontent.getText();
    }
}
