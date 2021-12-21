package com.demoApp.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class APIDemoLayoutResourcesScreenPageObjects {

    @AndroidFindBy(xpath = "//*[@text='Content/Resources/Layout Reference']")
    public MobileElement lbllayoutreferenceheader;

    @AndroidFindBy(xpath = "//*[@text='Shows how to write layout resource references, so that you can define multiple different configurations of a layout resource that refer to one actual XML definition.']")
    public MobileElement lbllaouytrefcontent;
}
