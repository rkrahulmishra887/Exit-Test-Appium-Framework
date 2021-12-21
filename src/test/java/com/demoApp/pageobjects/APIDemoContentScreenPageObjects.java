package com.demoApp.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;



public class APIDemoContentScreenPageObjects {

    @AndroidFindBy(xpath = "//*[@text='Assets']")
    public MobileElement lnkassets;

    @AndroidFindBy(xpath = "//*[@text='Clipboard']")
    public MobileElement lnkclipboard;

    @AndroidFindBy(xpath = "//*[@text='Resources']")
    public MobileElement lnkresources;

    @AndroidFindBy(xpath = "//*[@text='Storage']")
    public MobileElement lnkstorage;

}
