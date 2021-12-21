package com.demoApp.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class APIDemoAssetsScreenPageObjects {

    @AndroidFindBy(xpath = "//*[@text='Read Asset']")
    public MobileElement lnkreadasset;
}
