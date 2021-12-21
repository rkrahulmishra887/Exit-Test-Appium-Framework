package com.demoApp.pages;

import com.demoApp.library.BaseTest;
import com.demoApp.pageobjects.APIDemoAnimationScreenPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static com.demoApp.wrappers.ElementWrappers.click;



public class APIDemoAnimationScreen extends BaseTest {

    private AppiumDriver driver;
    APIDemoAnimationScreenPageObjects apiDemoAnimationScreenPageObjects = new APIDemoAnimationScreenPageObjects();

    public APIDemoAnimationScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), apiDemoAnimationScreenPageObjects);
    }

    public boolean verifyAnimationScreen() {
        boolean animationscreenflag = false;
        try{
            apiDemoAnimationScreenPageObjects.lnkBouncingBalls.isDisplayed();
            apiDemoAnimationScreenPageObjects.lnkCloning.isDisplayed();
            apiDemoAnimationScreenPageObjects.lnkDefaultLayoutAnimations.isDisplayed();
            apiDemoAnimationScreenPageObjects.lnkLayoutAnimations.isDisplayed();
            apiDemoAnimationScreenPageObjects.lnkViewFlip.isDisplayed();
            animationscreenflag = true;
        } catch (Exception e) {
            System.out.println(e + ": Animation screen is not displayed!!");
        }
        return animationscreenflag;
    }

    public void tapDefaultLayoutAnimations() {
        click(driver, apiDemoAnimationScreenPageObjects.lnkDefaultLayoutAnimations);
    }
}
