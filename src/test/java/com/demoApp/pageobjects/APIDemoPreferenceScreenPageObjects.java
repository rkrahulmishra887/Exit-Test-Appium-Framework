package com.demoApp.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;



public class APIDemoPreferenceScreenPageObjects {


    @AndroidFindBy(xpath = "//*[@text='1. Preferences from XML']")
    public MobileElement lnkpreferencefromxml;

    @AndroidFindBy(xpath = "//*[@text='4. Default values']")
    public MobileElement lnkdefaultvalues;

    @AndroidFindBy(xpath = "//*[@text='7. Fragment']")
    public MobileElement lnkfragment;

    @AndroidFindBy(xpath = "//*[@text='8. Headers']")
    public MobileElement lnkheaders;

}