package com.demoApp.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class APIDemoAnimationScreenPageObjects {

    @AndroidFindBy(xpath = "//*[@text='Bouncing Balls']")
    public MobileElement lnkBouncingBalls;

    @AndroidFindBy(xpath = "//*[@text='Cloning']")
    public MobileElement lnkCloning;

    @AndroidFindBy(xpath = "//*[@text='Default Layout Animations']")
    public MobileElement lnkDefaultLayoutAnimations;

    @AndroidFindBy(xpath = "//*[@text='Layout Animations']")
    public MobileElement lnkLayoutAnimations;

    @AndroidFindBy(xpath = "//*[@text='View Flip']")
    public MobileElement lnkViewFlip;
}
