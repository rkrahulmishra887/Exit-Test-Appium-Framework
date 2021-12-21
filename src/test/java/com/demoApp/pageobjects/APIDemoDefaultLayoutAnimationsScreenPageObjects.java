package com.demoApp.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class APIDemoDefaultLayoutAnimationsScreenPageObjects {

    @AndroidFindBy(xpath = "//*[@text='Animation/Default Layout Animations']")
    public MobileElement lbldefaultlayoutanimations;

    @AndroidFindBy(xpath = "//*[@text='ADD BUTTON']")
    public MobileElement btnAddButton;

}
