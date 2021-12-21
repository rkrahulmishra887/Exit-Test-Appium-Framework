package com.demoApp.runner;

import java.net.URL;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
//import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;

public class apprunner {
	public AppiumDriver<MobileElement> wd = null;
	static AppiumDriverLocalService service;
	
	@BeforeSuite
	public void startAppium() {
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
	}
	
	@BeforeTest
	public void setup() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "8.1");
		capabilities.setCapability("appPackage", "io.appium.android.apis");
		capabilities.setCapability("appActivity", ".ApiDemos");
		capabilities.setCapability("deviceName", "Pixel 2");
		capabilities.setCapability("app", "C:\\Users\\rahulmishra01\\Downloads\\ApiDemos-debug.apk");
		
		try {
			wd = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public MobileElement waitForElement(MobileElement element) {
		try {
			WebDriverWait wait=new WebDriverWait(wd, 60);
		} catch(Exception e) {
			System.out.println(element+"is not displayed on the web page");
		}
		return element;
		
	}
	
	//@Test
	/*public void apidemoapp() throws Throwable {
		wd.findElementByXPath("//android.widget.TextView[@content-desc=\"Graphics\"]").click();
		Thread.sleep(5000);
		
		//Tap functionality
		
		TouchAction touch=new TouchAction(wd);
		MobileElement Element=wd.findElementByAccessibilityId("Arcs");
		touch.tap(tapOptions().withElement(element(Element))).release().perform();
		Thread.sleep(5000);
		
		//Drag and Drop
		/*TouchAction touch=new TouchAction(wd);
		MobileElement Element1=wd.findElementByAccessibilityId("ColorFilters");
		MobileElement Element2=wd.findElementByAccessibilityId("Arcs");
		touch.longPress(longPressOptions().withElement(element(Element1))).moveTo(element(Element2)).release().perform();
		Thread.sleep(5000);
		*/
		
		//swipe
		/*verticalswipeByPercentage(0.70,0.10,0.50);
	}
	
	public void verticalswipeByPercentage(double startpercentage, double endpercentage, double anchorpercentage) throws Throwable {
		Dimension size = wd.manage().window().getSize();
		int anchor = (int)(size.width * anchorpercentage);
		int startpoint = (int)(size.height * startpercentage);
		int endpoint = (int)(size.height * endpercentage);
		new TouchAction(wd).press(point(anchor,startpoint)).waitAction(waitOptions(ofMillis(1000))).moveTo(point(anchor,endpoint)).release().perform();
		Thread.sleep(5000);
		
		
	}*/
	
	/*
	@AndroidFindBy(xpath = "//*[@text='Animation']")
    public MobileElement lnkAnimation;

    @AndroidFindBy(xpath = "//*[@text='App']")
    public MobileElement lnkApp;
    

    @AndroidFindBy(xpath = "//*[@text='Animation/Default Layout Animations']")
    public MobileElement lbldefaultlayoutanimations;

    @AndroidFindBy(xpath = "//*[@text='ADD BUTTON']")
    public MobileElement btnAddButton;

	public boolean verifyAnimationicon() {
        boolean displayAnimationflag = false;
        try{
            lnkAnimation.isDisplayed();
            displayAnimationflag = true;
        } catch (Exception e) {
            System.out.println(e + ": Animation icon is not displayed!!");
        }
        return displayAnimationflag;
    }
	
	public boolean verifyDefaultLaoyoutAnimationScreen() {
        boolean defaultanimationscreenflag = false;
        try{
            lbldefaultlayoutanimations.isDisplayed();
            defaultanimationscreenflag = true;
        } catch (Exception e) {
            System.out.println(e + ": Default Layout Animations screen is not displayed!!");
        }
        return defaultanimationscreenflag;
    }
	
	/* public void iVerifyButtonDisplay(int buttons) {
	        Assert.assertEquals(getbuttons(), buttons, "The no. of buttons displayed is invalid!!");
	        //Log.info("The button " + buttons + " is displayed successfully!!");

	    }*/
	

	   /* public int getbuttons() {
	        return wd.findElements(By.xpath("//*[@resource-id='io.appium.android.apis:id/gridContainer']//android.widget.Button")).size();
	    }
	    */
	
	
	@Test
	public void animation_screen() {
		
		//Assert.assertTrue(verifyAnimationicon(), "Animation icon is not displayed!!");
		
		new TouchAction(wd).tap(TapOptions.tapOptions().withElement(ElementOption.element((wd).findElement(By.xpath("//android.widget.TextView[@content-desc=\"Animation\"]"))))).perform();
		
		//Assert.assertTrue(verifyDefaultLaoyoutAnimationScreen(), "Default Layout Animations screen is not displayed!!");
		
		new TouchAction(wd).tap(TapOptions.tapOptions().withElement(ElementOption.element((wd).findElement(By.xpath("//android.widget.TextView[@content-desc=\"Default Layout Animations\"]"))))).perform();
		
		new TouchAction(wd).tap(TapOptions.tapOptions().withElement(ElementOption.element((wd).findElement(By.xpath("//android.widget.Button[@content-desc=\"Add Button\"]"))))).perform();
		
		new TouchAction(wd).tap(TapOptions.tapOptions().withElement(ElementOption.element((wd).findElement(By.id("io.appium.android.apis:id/addNewButton"))))).perform();
		
		new TouchAction(wd).tap(TapOptions.tapOptions().withElement(ElementOption.element((wd).findElement(By.xpath("//android.widget.Button[@content-desc=\"Add Button\"]"))))).perform();
		
		new TouchAction(wd).tap(TapOptions.tapOptions().withElement(ElementOption.element((wd).findElement(By.id("io.appium.android.apis:id/addNewButton"))))).perform();
	    
		
		//Assert.assertEquals(getbuttons(), buttons, "The no. of buttons displayed is invalid!!");
		
		wd.quit();
	
	}
	
	@Test
	public void content_screen() {
		
		
		new TouchAction(wd).tap(TapOptions.tapOptions().withElement(ElementOption.element((wd).findElement(By.xpath("//android.widget.TextView[@content-desc=\"Content\"]"))))).perform();
		
		//new TouchAction(wd).tap(TapOptions.tapOptions().withElement(ElementOption.element((wd).findElement(By.id("io.appium.android.apis:id/addNewButton"))))).perform();
		
		new TouchAction(wd).tap(TapOptions.tapOptions().withElement(ElementOption.element((wd).findElement(By.xpath("//android.widget.TextView[@content-desc=\"Resources\"]"))))).perform();
		
		new TouchAction(wd).tap(TapOptions.tapOptions().withElement(ElementOption.element((wd).findElement(By.xpath("//android.widget.TextView[@content-desc=\"Layout Reference\"]"))))).perform();
		
		wd.quit();
		
	}
	
	//@Test
	public void content_screen_asset() {
		new TouchAction(wd).tap(TapOptions.tapOptions().withElement(ElementOption.element((wd).findElement(By.xpath("//android.widget.TextView[@content-desc=\"Content\"]"))))).perform();
		
		new TouchAction(wd).tap(TapOptions.tapOptions().withElement(ElementOption.element((wd).findElement(By.xpath("//android.widget.TextView[@content-desc=\"Assets\"]"))))).perform();
		
		new TouchAction(wd).tap(TapOptions.tapOptions().withElement(ElementOption.element((wd).findElement(By.xpath("//android.widget.TextView[@content-desc=\"Read Asset\"]"))))).perform();
		
		wd.quit();
	}
	
	
	@Test
	public void preference_screen() {
		new TouchAction(wd).tap(TapOptions.tapOptions().withElement(ElementOption.element((wd).findElement(By.xpath("//android.widget.TextView[@content-desc=\"Preference\"]"))))).perform();
		
		new TouchAction(wd).tap(TapOptions.tapOptions().withElement(ElementOption.element((wd).findElement(By.xpath("//android.widget.TextView[@content-desc=\"4. Default values\"]"))))).perform();
	
		new TouchAction(wd).tap(TapOptions.tapOptions().withElement(ElementOption.element((wd).findElement(By.xpath("//android.widget.TextView[@content-desc=\"Preference\"]"))))).perform();
		
		
		//new TouchAction(wd).tap(TapOptions.tapOptions().withElement(ElementOption.element((wd).findElement(By.xpath("//*[@text='Checkbox preference']"))))).perform();
		
		//new TouchAction(wd).tap(TapOptions.tapOptions().withElement(ElementOption.element((wd).findElement(By.id("io.appium.android.apis:id/checkbox"))))).perform();
		
		
		
		//Edit Preferences
		
		//new TouchAction(wd).tap(TapOptions.tapOptions().withElement(ElementOption.element((wd).findElement(By.xpath("//*[@text='Edit text preference']"))))).perform();
		
		//new TouchAction(wd).tap(TapOptions.tapOptions().withElement(ElementOption.element((wd).findElement(By.xpath("//android.widget.TextView[@content-desc=\"Edit Text Preference\"]"))))).perform();
		
		
		//new TouchAction(wd).tap(TapOptions.tapOptions().withElement(ElementOption.element((wd).findElement(By.id("io.appium.android.apis:id/edit"))))).perform();
		
		//new TouchAction(wd).tap(TapOptions.tapOptions().withElement(ElementOption.element((wd).findElement(By.xpath("//android.widget.EditText[@text=\"Default value\"]"))))).clear();
		//new TouchAction(wd).tap(TapOptions.tapOptions().withElement(ElementOption.element((wd).findElement(By.xpath("//android.widget.EditText[@text=\"Default value\"]"))))).perform();
		
		//wd.findElement(By.id("io.appium.android.apis:id/edit")).sendKeys("Horse");
		
	
	}
	
	/*@AfterTest
	public void stopappium(){
		wd.quit();
		}
		*/
	
	
	@AfterSuite
	public void closeappium() {
		service.stop();
}
}
