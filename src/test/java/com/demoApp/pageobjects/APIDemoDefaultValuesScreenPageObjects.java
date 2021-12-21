package com.demoApp.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;



public class APIDemoDefaultValuesScreenPageObjects {


    @AndroidFindBy(xpath = "//*[@text='Preference/4. Default values']")
    public MobileElement lbldefaultvaluesheader;

    @AndroidFindBy(xpath = "//*[@text='Checkbox preference']")
    public MobileElement lblcheckbox;

    @AndroidFindBy(xpath = "//*[@text='Checkbox preference']/../following-sibling::android.widget.LinearLayout//android.widget.CheckBox")
    public MobileElement chkpreference;

    @AndroidFindBy(xpath = "//*[@text='Edit text preference']")
    public MobileElement lbledittxtpreference;

    @AndroidFindBy(xpath = "//*[@text='List preference']")
    public MobileElement lbllistpreference;

    @AndroidFindBy(xpath = "//*[@resource-id='android:id/parentPanel']")
    public MobileElement lblparentpanel;

    @AndroidFindBy(xpath = "//*[@resource-id='android:id/parentPanel']//*[@resource-id='android:id/alertTitle']")
    //Enter your favorite animal
    public MobileElement lblparentpanelheader;

    @AndroidFindBy(xpath = "//*[@resource-id='android:id/customPanel']//*[@resource-id='android:id/edit']")
    //Enter your favorite animal
    public MobileElement txtparentpanel;

    @AndroidFindBy(xpath = "//*[@text='Cancel']")
    public MobileElement btncancel;

    @AndroidFindBy(xpath = "//*[@text='OK']")
    public MobileElement btnok;

    @AndroidFindBy(xpath = "//*[@text='Choose one']")
    public MobileElement lblchooseone;

    @AndroidFindBy(xpath = "//*[@text='Alpha Option 01']")
    public MobileElement selectalphaoption;

    @AndroidFindBy(xpath = "//*[@text='Charlie Option 03']")
    public MobileElement selectcharlieoption;

    @AndroidFindBy(xpath = "//*[@text='Beta Option 02']")
    public MobileElement selectbetaoption;
}