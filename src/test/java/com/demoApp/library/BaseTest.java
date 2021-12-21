package com.demoApp.library;

import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.annotations.Optional;

import java.io.*;
import java.net.URL;



public class BaseTest {

    public ThreadLocal<AppiumDriverLocalService> threadService = new ThreadLocal<>();
    AppiumDriverLocalService service;
    AppiumDriverLocalService service2;
    public AppiumServiceBuilder builder;
    public ThreadLocal<AppiumDriverLocalService> threadService2 = new ThreadLocal<>();
    public AppiumServiceBuilder builder2;
    public WebDriverWait wait;
    public static RemoteWebDriver driver = null;
    public static ExtentTest test;
    PropertyFileReader propertyFileReader;
    public static String imagePath;
    public static String takeScreenEvidence;
    public static String androidBuild;
    public static String appPath;

    @BeforeSuite
    @Parameters({"takeScreenEvidence"})
    public void startSuite(String takeScreenEvidence) throws IOException {
        propertyFileReader = new PropertyFileReader();

        DesiredCapabilities caps1 = new DesiredCapabilities();
        caps1.setCapability("wdaLocalPort", "8220");
        caps1.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, "8220");
        builder = new AppiumServiceBuilder();

        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec("cmd /c netstat -ano | findstr 4753");

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(proc.getInputStream()));
            String s = null;
            if ((s = stdInput.readLine()) != null) {
                int index = s.lastIndexOf(" ");
                String sc = s.substring(index, s.length());

                rt.exec("cmd /c Taskkill /PID" + sc + " /T /F");
                System.out.println("Server runing on port: 4753 is killed successfully!!");
            }
        } catch (Exception e) {
            System.out.println("Server with port: 4753 is not started!!");
        }

        builder.withIPAddress("127.0.0.1").usingPort(4753).withCapabilities(caps1);

        service = AppiumDriverLocalService.buildService(builder);
        threadService.set(service);
        threadService.get().start();

        System.out.println("Appium Server 1 has started!!");


        DesiredCapabilities caps2 = new DesiredCapabilities();
        caps2.setCapability("wdaLocalPort", "8230");
        caps2.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, "8230");
        builder2 = new AppiumServiceBuilder();

        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec("cmd /c netstat -ano | findstr 4763");

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(proc.getInputStream()));
            String s = null;
            if ((s = stdInput.readLine()) != null) {
                int index = s.lastIndexOf(" ");
                String sc = s.substring(index, s.length());

                rt.exec("cmd /c Taskkill /PID" + sc + " /T /F");
                System.out.println("Server runing on port: 4763 is killed successfully!!");
            }
        } catch (Exception e) {
            System.out.println("Server with port: 4763 is not started!!");
        }

        builder2.withIPAddress("127.0.0.1").usingPort(4763).withCapabilities(caps2);
        service2 = AppiumDriverLocalService.buildService(builder2);
        threadService2.set(service2);
        threadService2.get().start();
        System.out.println("Appium Server 2 has started!!");

        ExtentManager.getReporter();

        this.takeScreenEvidence = takeScreenEvidence;

        imagePath = System.getProperty("user.dir") + File.separator + "reports" + File.separator + "screenshots";
        if ((new File(imagePath)).exists()) {
            FileUtils.forceDelete(new File(imagePath));
        }
        (new File(imagePath)).mkdir();
    }

    @BeforeMethod
    @Parameters({"automationName", "deviceName", "platformName", "platformVersion", "tags", "port", "systemPort"})
    public void setup(String automationName, String deviceName, String platformName, @Optional("OptionalTag") String platformVersion, String tags, String port, String systemPort) throws IOException {

        propertyFileReader = new PropertyFileReader();

        DesiredCapabilities caps = new DesiredCapabilities();

        if(platformName.equalsIgnoreCase("Android")) {
            androidBuild = System.getProperty("android_app");
            appPath = System.getProperty("user.dir") + File.separator + "app_folder" + File.separator + androidBuild;
            caps.setCapability("appPackage", System.getProperty("android_package_name"));
        } else {
            // Desired capabailities of iOS application should be set that includes appWaitActivity, appPackage, App path
        }
        caps.setCapability("deviceName", "Pixel 2");
        caps.setCapability("automationName", automationName);
        caps.setCapability("platformVersion", "8.1");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", automationName);
        caps.setCapability("noReset", true);
        caps.setCapability("uiautomator2ServerInstallTimeout", 300000);
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 400000);
        caps.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, systemPort);
        caps.setCapability(MobileCapabilityType.UDID, "Pixel 2");
        caps.setCapability("fullReset", false);
        caps.setCapability("app", "C:\\Users\\rahulmishra01\\Downloads\\ApiDemos-debug.apk");

        ThreadLocalDriver.setTLDriver(new AppiumDriver(new URL("http://127.0.0.1:" + 4723 + "/wd/hub"), caps));
        wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 10);
    }

    @AfterMethod
    public synchronized void teardown() {
        ThreadLocalDriver.getTLDriver().quit();
    }

    @AfterSuite
    public void endSuite() {
        threadService.get().stop();
        threadService2.get().stop();
        System.out.println("Appium Server is stopped!!");


    }
}
