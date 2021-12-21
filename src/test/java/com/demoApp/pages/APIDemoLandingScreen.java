package com.demoApp.pages;

import com.demoApp.library.BaseTest;
import com.demoApp.pageobjects.APIDemoLandingScreenPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;
import static com.demoApp.wrappers.ElementWrappers.*;



public class APIDemoLandingScreen extends BaseTest {

    private AppiumDriver driver;
    APIDemoLandingScreenPageObjects apiDemoLandingScreenPageObjects = new APIDemoLandingScreenPageObjects();

    public APIDemoLandingScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), apiDemoLandingScreenPageObjects);
    }

    public boolean verifyLandingScreenHeader() {
        boolean headerflag = false;
        try{
            apiDemoLandingScreenPageObjects.lblApiDemoHeader.isDisplayed();
            headerflag = true;
        } catch (Exception e) {
            System.out.println(e + ": The header is not displayed!!");
        }
        return headerflag;
    }

    public boolean verifyAccessibility1icon() {
        boolean displayAccessibilityflag = false;
        try{
            apiDemoLandingScreenPageObjects.lnkAccessibility1.isDisplayed();
            displayAccessibilityflag = true;
        } catch (Exception e) {
            System.out.println(e + ": Accessibility1 icon is not displayed!!");
        }
        return displayAccessibilityflag;
    }

    public boolean verifyAccessibility2icon() {
        boolean displayAccessibilityflag = false;
        try{
            apiDemoLandingScreenPageObjects.lnkAccessibility2.isDisplayed();
            displayAccessibilityflag = true;
        } catch (Exception e) {
            System.out.println(e + ": Accessibility2 icon is not displayed!!");
        }
        return displayAccessibilityflag;
    }

    public boolean verifyAnimationicon() {
        boolean displayAnimationflag = false;
        try{
            apiDemoLandingScreenPageObjects.lnkAnimation.isDisplayed();
            displayAnimationflag = true;
        } catch (Exception e) {
            System.out.println(e + ": Animation icon is not displayed!!");
        }
        return displayAnimationflag;
    }

    public boolean verifyAppicon() {
        boolean displayAppflag = false;
        try{
            apiDemoLandingScreenPageObjects.lnkApp.isDisplayed();
            displayAppflag = true;
        } catch (Exception e) {
            System.out.println(e + ": App icon is not displayed!!");
        }
        return displayAppflag;
    }

    public boolean verifyContenticon() {
        boolean displayContentflag = false;
        try{
            apiDemoLandingScreenPageObjects.lnkContent.isDisplayed();
            displayContentflag = true;
        } catch (Exception e) {
            System.out.println(e + ": Content icon is not displayed!!");
        }
        return displayContentflag;
    }

    public boolean verifyMediaicon() {
        boolean displayMediaflag = false;
        try{
            apiDemoLandingScreenPageObjects.lnkMedia.isDisplayed();
            displayMediaflag = true;
        } catch (Exception e) {
            System.out.println(e + ": Media icon is not displayed!!");
        }
        return displayMediaflag;
    }

    public boolean verifyViewicon() {
        boolean displayViewflag = false;
        try{
            apiDemoLandingScreenPageObjects.lnkViews.isDisplayed();
            displayViewflag = true;
        } catch (Exception e) {
            System.out.println(e + ": View icon is not displayed!!");
        }
        return displayViewflag;
    }

    public void tapAnimation() {
        click(driver, apiDemoLandingScreenPageObjects.lnkAnimation);
    }

    public void tapContent() {
        click(driver, apiDemoLandingScreenPageObjects.lnkContent);
    }

    public void tapPreference() {
        click(driver, apiDemoLandingScreenPageObjects.lnkPreference);
    }


    public boolean verifyAlphabitMapicon() throws Exception {
        boolean displayAlphabitMapflag = false;
        try{
            apiDemoLandingScreenPageObjects.lnkAlphabitmap.isDisplayed();
            displayAlphabitMapflag = true;
        } catch (Exception e) {
            scrollToElementTextAndCenter(driver, "AlphaBitmap");
            System.out.println(e + ": The header is not displayed!!");
        }
        return displayAlphabitMapflag;
    }

    public boolean verifyClippingicon() throws Exception {
        boolean displayClippingflag = false;
        try{
            apiDemoLandingScreenPageObjects.lnkClipping.isDisplayed();
            displayClippingflag = true;
        } catch (Exception e) {
            scrollToElementTextAndCenter(driver, "Clipping");
            System.out.println(e + ": Clipping icon is not displayed!!");
        }
        return displayClippingflag;
    }


    public boolean verifyDensityicon() throws Exception {
        boolean displayDensityflag = false;
        try{
            apiDemoLandingScreenPageObjects.linkDensity.isDisplayed();
            displayDensityflag = true;
        } catch (Exception e) {
            scrollToElementTextAndCenter(driver, "Density");
            System.out.println(e + ": Density icon is not displayed!!");
        }
        return displayDensityflag;
    }

    public boolean verifyDrawableicon() throws Exception {
        boolean displayDrawableflag = false;
        try{
            apiDemoLandingScreenPageObjects.linkDrawable.isDisplayed();
            displayDrawableflag = true;
        } catch (Exception e) {
            scrollToElementTextAndCenter(driver, "Drawable");
            System.out.println(e + ": Drawable icon is not displayed!!");
        }
        return displayDrawableflag;
    }

    public boolean verifyScaleToFiticon() throws Exception {
        boolean displayScaleToFitflag = false;
        try{
            apiDemoLandingScreenPageObjects.linkScaleToFit.isDisplayed();
            displayScaleToFitflag = true;
        } catch (Exception e) {
            scrollToElementTextAndCenter(driver, "ScaleToFit");
            System.out.println(e + ": ScaleToFit icon is not displayed!!");
        }
        return displayScaleToFitflag;
    }
}
