package com.demoApp.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;



public class APIDemoLandingScreenPageObjects {

    @AndroidFindBy(xpath = "//*[@text='API Demos']")
    public MobileElement lblApiDemoHeader;

    @AndroidFindBy(xpath = "//*[@text=\"Access'ibility\"]")
    public MobileElement lnkAccessibility1;

    @AndroidFindBy(xpath = "//*[@text='Accessibility']")
    public MobileElement lnkAccessibility2;

    @AndroidFindBy(xpath = "//*[@text='Animation']")
    public MobileElement lnkAnimation;

    @AndroidFindBy(xpath = "//*[@text='App']")
    public MobileElement lnkApp;

    @AndroidFindBy(xpath = "//*[@text='Content']")
    public MobileElement lnkContent;

    @AndroidFindBy(xpath = "//*[@text='Graphics']")
    public MobileElement linkGraphics;

    @AndroidFindBy(xpath = "//*[@text='Preference']")
    public MobileElement lnkPreference;

    @AndroidFindBy(xpath = "//*[@text='Media']")
    public MobileElement lnkMedia;

    @AndroidFindBy(xpath = "//*[@text='Views']")
    public MobileElement lnkViews;


    @AndroidFindBy(xpath = "//*[@text='AlphaBitmap']")
    public MobileElement lnkAlphabitmap;

    @AndroidFindBy(xpath = "//*[@text='AnimateDrawables']")
    public MobileElement lnkAnimatedrawables;

    @AndroidFindBy(xpath = "//*[@text='Arcs']")
    public MobileElement lnkArcs;

    @AndroidFindBy(xpath = "//*[@text='BitmapDecode']")
    public MobileElement lnkBitmapdecode;

    @AndroidFindBy(xpath = "//*[@text='BitmapMesh']")
    public MobileElement lnkBitmapmesh;

    @AndroidFindBy(xpath = "//*[@text='BitmapPixels']")
    public MobileElement lnkBitmappixels;

    @AndroidFindBy(xpath = "//*[@text='CameraPreview']")
    public MobileElement lnkCamerapreview;

    @AndroidFindBy(xpath = "//*[@text='Clipping']")
    public MobileElement lnkClipping;

    @AndroidFindBy(xpath = "//*[@text='ColorMatrix']")
    public MobileElement linkColorMatrix;

    @AndroidFindBy(xpath = "//*[@text='Compass']")
    public MobileElement linkCompass;

    @AndroidFindBy(xpath = "//*[@text='CreateBitmap']")
    public MobileElement linkCreateBitmap;

    @AndroidFindBy(xpath = "//*[@text='Density']")
    public MobileElement linkDensity;

    @AndroidFindBy(xpath = "//*[@text='Drawable']")
    public MobileElement linkDrawable;

    @AndroidFindBy(xpath = "//*[@text='FingerPaint']")
    public MobileElement linkFingerPaint;

    @AndroidFindBy(xpath = "//*[@text='Patterns']")
    public MobileElement linkPatterns;

    @AndroidFindBy(xpath = "//*[@text='Points']")
    public MobileElement linkPoints;

    @AndroidFindBy(xpath = "//*[@text='PolyToPoly']")
    public MobileElement linkPolyToPoly;

    @AndroidFindBy(xpath = "//*[@text='Regions']")
    public MobileElement linkRegions;

    @AndroidFindBy(xpath = "//*[@text='RoundRects']")
    public MobileElement linkRoundRects;

    @AndroidFindBy(xpath = "//*[@text='ScaleToFit']")
    public MobileElement linkScaleToFit;

    @AndroidFindBy(xpath = "//*[@text='SensorTest']")
    public MobileElement linkSensorTest;

    @AndroidFindBy(xpath = "//*[@text='Surface Window']")
    public MobileElement linkSurfaceWindow;

    @AndroidFindBy(xpath = "//*[@text='Vertices']")
    public MobileElement linkVertices;

    @AndroidFindBy(xpath = "//*[@text='Xfermodes']")
    public MobileElement linkXfermodes;
}
