package com.demoApp.pages;


import com.demoApp.library.BaseTest;
import com.demoApp.pageobjects.APIDemoDefaultLayoutAnimationsScreenPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;
import static com.demoApp.wrappers.ElementWrappers.click;



public class APIDemoDefaultLayoutAnimationsScreen extends BaseTest {
    private AppiumDriver driver;
    APIDemoDefaultLayoutAnimationsScreenPageObjects apiDemoDefaultLayoutAnimationsScreenPageObjects = new APIDemoDefaultLayoutAnimationsScreenPageObjects();

    public APIDemoDefaultLayoutAnimationsScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), apiDemoDefaultLayoutAnimationsScreenPageObjects);
    }

    public boolean verifyDefaultLaoyoutAnimationScreen() {
        boolean defaultanimationscreenflag = false;
        try{
            apiDemoDefaultLayoutAnimationsScreenPageObjects.lbldefaultlayoutanimations.isDisplayed();
            defaultanimationscreenflag = true;
        } catch (Exception e) {
            System.out.println(e + ": Default Layout Animations screen is not displayed!!");
        }
        return defaultanimationscreenflag;
    }

    public void tapbutton(int times) {
        for(int clicktimes=0; clicktimes < times; clicktimes++) {
            click(driver, apiDemoDefaultLayoutAnimationsScreenPageObjects.btnAddButton);
        }
    }

    public int getbuttons() {
        return driver.findElements(By.xpath("//*[@resource-id='io.appium.android.apis:id/gridContainer']//android.widget.Button")).size();
    }

}
