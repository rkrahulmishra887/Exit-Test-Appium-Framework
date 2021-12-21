package com.demoApp.wrappers;

import com.aventstack.extentreports.ExtentTest;
import com.demoApp.library.Log;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.imgscalr.Scalr;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.*;





public class ElementWrappers {

    static int maxElementWait = 10;
    public static Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    public static ExtentTest features;
    public static Map<String, ExtentTest> featuresNameList = new HashMap<>();
    // MOBILE ELEMENT METHODS

    public static boolean pressByElement(AppiumDriver driver, WebElement ele) {
        boolean isTrue = false;
        try {
            Point center = getCenter(ele);
            new TouchAction(driver).press(PointOption.point(center.getX(), center.getY())).perform();
            Log.info("Pass : [EW] Press on element - " + ele.toString());
            isTrue = true;
        } catch (Exception e) {
            Log.info("Error : Press on element - " + e);
        }
        return isTrue;
    }

    /**
     * To tap on the element
     *
     * @param driver
     * @param ele
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static boolean tapByElement(AppiumDriver driver, WebElement ele) {
        boolean isTrue = false;
        try {
            Point center = getCenter(ele);
            new TouchAction(driver).tap(PointOption.point(center.getX(), center.getY())).perform();
            Log.info("Pass : [EW] Tap on element - " + ele.toString());
            isTrue = true;
        } catch (Exception e) {
            Log.info("Error : Tap on element - " + e);
        }
        return isTrue;
    }

    public static boolean tapByPosition(AppiumDriver driver, int x, int y) {
        boolean isTrue = false;
        try {
            new TouchAction(driver).tap(PointOption.point(x, y));
            Log.info("Pass : [EW] Tap by position - (" + x + "," + y + ")");
            isTrue = true;
        } catch (Exception e) {
            Log.info("Error : Tap by position - " + e);
        }
        return isTrue;
    }

    public static boolean closeApp(AppiumDriver driver) {
        boolean isTrue = false;
        try {
            driver.closeApp();
            Log.info("Pass : [EW] Close app");
            isTrue = true;
        } catch (Exception e) {
            Log.info("Error : Close app - " + e);
        }
        return isTrue;
    }

    public static boolean getContext(AppiumDriver driver) {
        boolean isTrue = false;
        try {
            String context = driver.getContext();
            Log.info("Pass : [EW] Get context - " + context);
            isTrue = true;
        } catch (Exception e) {
            Log.info("Error : Get context - " + e);
        }
        return isTrue;
    }

    public static boolean enterText(AppiumDriver driver, WebElement ele, String value) {
        boolean isTrue = false;
        try {
            ele.clear();
            ele.sendKeys(value);
            Log.info("Pass : [EW] Enter text - " + ele.toString() + "; Value - " + value);
            isTrue = true;
        } catch (Exception e) {
            Log.info("Error : Enter text - " + e);
        }
        return isTrue;
    }

    public static boolean enterText(AppiumDriver driver, By by, String value) {
        boolean isTrue = false;
        try {
            WebElement ele = driver.findElement(by);
            ele.clear();
            ele.sendKeys(value);
            Log.info("Pass : [EW] Enter text - " + ele.toString() + "; Value - " + value);
            isTrue = true;
        } catch (Exception e) {
            Log.info("Error : Enter text - " + e);
        }
        return isTrue;
    }

    public static boolean doSwipeOnScreen(AppiumDriver driver, String swipeDirection) throws Exception {

        final long startTime = Log.startTime();
        boolean isTrue = false;

        try {
            Dimension size = driver.manage().window().getSize();
            int startY = (int) (size.height * 0.6);
            int endY = (int) (size.height * 0.75);
            int startX = (int) (size.width * 0.5);
            int endX = (int) (size.width * 0.5);

            int duration = 3000;

            switch (swipeDirection.toLowerCase()) {

                case "left": {
                    new TouchAction((AppiumDriver) driver).press(PointOption.point(startX, startY))
                            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration))).moveTo(PointOption.point(endX, endY))
                            .release().perform();
                    Log.info("Pass : [EW] Do swipe on screen towards direction \t:" + swipeDirection);
                    break;
                }
                case "right": {
                    new TouchAction((AppiumDriver) driver).press(PointOption.point(endX, startY))
                            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration))).moveTo(PointOption.point(startX, endY))
                            .release().perform();
                    Log.info("Pass : [EW] Do swipe on screen towards direction \t:" + swipeDirection);
                    break;
                }
                case "up": {
                    new TouchAction((AppiumDriver) driver).press(PointOption.point(startX, endY))
                            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration))).moveTo(PointOption.point(endX, endY / 2))
                            .release().perform();
                    Log.info("Pass : [EW] Do swipe on screen towards direction \t:" + swipeDirection);
                    break;
                }
                case "down": {
                    new TouchAction((AppiumDriver) driver).press(PointOption.point(endX, endY / 2))
                            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration))).moveTo(PointOption.point(endX, endY))
                            .release().perform();
                    Log.info("Pass : [EW] Do swipe on screen towards direction \t:" + swipeDirection);
                    break;
                }
                default: {
                    new TouchAction((AppiumDriver) driver).press(PointOption.point(startX, startY))
                            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000))).moveTo(PointOption.point(endX, endY))
                            .release().perform();
                    Log.info("Pass : [EW] Do swipe on screen towards direction \t:" + swipeDirection);
                    break;
                }
            }

            isTrue = true;

        }//End try

        catch (Exception e) {
            throw new Exception("Exception at ElementWrapper.doSwipeOnScreen \t: " + e.getMessage(), e);
        }//End catch

        finally {
            Log.info("ElementWrapper.doSwipeOnScreen\t" + Log.elapsedTime(startTime));
        }//End finally

        return isTrue;
    }

    public static boolean doSwipeOnScreen(AppiumDriver driver, String swipeDirection, int duration) throws Exception {

        final long startTime = Log.startTime();
        boolean isTrue = false;

        try {

            Dimension size = driver.manage().window().getSize();
            int startY = (int) (size.height * 0.6);
            int endY = (int) (size.height * 0.75);
            int startX = (int) (size.width * 0.75);
            int endX = (int) (size.width * 0.125);

            switch (swipeDirection.toLowerCase()) {

                case "left": {
                    new TouchAction((AppiumDriver) driver).press(PointOption.point(startX, startY))
                            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration))).moveTo(PointOption.point(endX, endY))
                            .release().perform();
                    Log.info("Pass : [EW] Do swipe on screen towards direction \t:" + swipeDirection);
                    break;
                }
                case "right": {
                    new TouchAction((AppiumDriver) driver).press(PointOption.point(endX, startY))
                            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration))).moveTo(PointOption.point(startX, endY))
                            .release().perform();
                    Log.info("Pass : [EW] Do swipe on screen towards direction \t:" + swipeDirection);
                    break;
                }
                case "up": {
                    new TouchAction((AppiumDriver) driver).press(PointOption.point(startX, endY))
                            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration))).moveTo(PointOption.point(endX, endY / 2))
                            .release().perform();
                    Log.info("Pass : [EW] Do swipe on screen towards direction \t:" + swipeDirection);
                    break;
                }
                case "down": {
                    new TouchAction((AppiumDriver) driver).press(PointOption.point(endX, endY / 2))
                            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration))).moveTo(PointOption.point(endX, endY))
                            .release().perform();
                    Log.info("Pass : [EW] Do swipe on screen towards direction \t:" + swipeDirection);
                    break;
                }
                default: {
                    new TouchAction((AppiumDriver) driver).press(PointOption.point(startX, startY))
                            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000))).moveTo(PointOption.point(endX, endY))
                            .release().perform();
                    Log.info("Pass : [EW] Do swipe on screen towards direction \t:" + swipeDirection);
                    break;
                }
            }

            isTrue = true;

        }//End try

        catch (Exception e) {
            throw new Exception("Exception at ElementWrapper.doSwipeOnScreen \t: " + e.getMessage(), e);
        }//End catch

        finally {
            Log.info("ElementWrapper.doSwipeOnScreen\t" + Log.elapsedTime(startTime));
        }//End finally

        return isTrue;
    }

    public static void scrollToElementTextAndCenter(AppiumDriver driver, String elementText) throws Exception {
        int i = 0;
        Dimension size = driver.manage().window().getSize();
        while (true) {
            Thread.sleep(2000);
            try {
                if ((driver.findElementByXPath("//*[contains(@text,'" + elementText + "')]")).isDisplayed()) {
                    Point center = getCenter(driver.findElementByXPath("//*[contains(@text,'" + elementText + "')]"));
                    new TouchAction(driver)
                            .press(PointOption.point(center.getX(), center.getY()))
                            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)))
                            .moveTo(PointOption.point((int) (size.width * 0.5), (int) (size.height * 0.5)))
                            .release()
                            .perform();

                    break;
                }
            } catch (Exception e) {

            }
            if (++i == 5) {
                break;
            }
            doSwipeOnScreen(driver, "up");
        }
    }

    // BROWSER WEB ELEMENT METHODS

    public static boolean waitForElement(AppiumDriver driver, WebElement ele) {
        return waitForElement(driver, ele, maxElementWait);
    }

    public static boolean waitForElement(AppiumDriver driver, WebElement ele, int maxElementWait) {
        WebDriverWait wait = new WebDriverWait(driver, maxElementWait);
        boolean elementState = false;
        try {

            // WebDriver Wait
            wait.withTimeout(Duration.ofSeconds(maxElementWait))
                    .pollingEvery(Duration.ofSeconds(1));
            WebElement waitElement = wait.until(ExpectedConditions.elementToBeClickable(ele));
            Log.info("Info : [EW] Waiting for element - " + ele.toString());

            if (waitElement.isDisplayed()) {
                Log.info("Pass : [EW] Element found - " + ele.toString());
                elementState = true;
            } else {
                Log.info("Fail : [EW] Element not found - " + ele.toString());
            }

        } catch (Exception e) {
            Log.info("Error : [EW] - Wait for element - " + e);
            elementState = false;
        }
        return elementState;
    }

    public static boolean click(AppiumDriver driver, By by) {
        boolean isTrue = false;
        try {
//			(new WebDriverWait(driver, maxElementWait)).until(ExpectedConditions.elementToBeClickable(by));
            ElementWrappers.waitForElement(driver, driver.findElement(by));
            driver.findElement(by).click();
            isTrue = true;
        } catch (StaleElementReferenceException e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(by));
            isTrue = true;
        } catch (WebDriverException e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(by));
            isTrue = true;
        } catch (Exception e) {
            Log.error("Error - Click : " + e);
        }
        return isTrue;
    }

    public static boolean clickWithJs(AppiumDriver driver, WebElement element) {
        return clickWithJs(driver, element, true);
    }

    public static boolean clickWithJs(AppiumDriver driver, WebElement element, boolean isWaitRequired) {
        boolean isTrue = false;
        String logMsg = " : [EW] Element clicked by JS - " + element.toString();
        try {
            isTrue = isWaitRequired ? ElementWrappers.waitForElement(driver, element) : false;
            // (new WebDriverWait(driver, maxElementWait)).until(ExpectedConditions.elementToBeClickable(element));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
            Log.info("Pass" + logMsg);
            isTrue = true;
        } catch (Exception e) {
            Log.info("Error" + logMsg + " - " + e);
        }
        return isTrue;
    }

    public static boolean click(AppiumDriver driver, WebElement element) {
        boolean isTrue = false;
        try {
            ElementWrappers.waitForElement(driver, element);
//            (new WebDriverWait(driver, maxElementWait)).until(ExpectedConditions.elementToBeClickable(element));
//            scrollToElement(driver, element);
            element.click();
            Log.info("Pass : [EW] Element clicked - " + element.toString());
            isTrue = true;
        } catch (NoSuchElementException e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
            Log.info("Pass : [EW] Element clicked by js (NSE) - " + element.toString());
            isTrue = true;
        } catch (StaleElementReferenceException e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
            Log.info("Pass : [EW] Element clicked by js (Stale) - " + element.toString());
            isTrue = true;
        } catch (WebDriverException e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
            Log.info("Pass : [EW] Element clicked by js (WDE) - " + element.toString());
            isTrue = true;
        } catch (Exception e) {
            Log.error("Error : Click - " + e);
        }
        return isTrue;
    }

    public static void clear(AppiumDriver driver, By by) {
        try {
            (new WebDriverWait(driver, maxElementWait)).until(ExpectedConditions.elementToBeClickable(by));
            driver.findElement(by).clear();
        } catch (StaleElementReferenceException e) {
            // retry the find element
            driver.findElement(by).clear();
        } catch (Exception e) {
            // log("Element identified is not clickable");
        }

    }

    public static boolean isDisplayed(WebElement ele) {
        return ele.isDisplayed();
    }

    public static boolean isDisplayed(AppiumDriver driver, WebElement ele, int waitTime) {
        boolean isDisplayed = false;
        try {
            ElementWrappers.waitForElement(driver, ele, waitTime);
//			(new WebDriverWait(driver, maxElementWait)).until(ExpectedConditions.visibilityOf(ele));
            isDisplayed = ele.isDisplayed();
            String output = isDisplayed ? "Pass" : "Fail";
//            Log.info(output + " : Element displayed");
        } catch (StaleElementReferenceException e) {
            // retry the find element
            isDisplayed = ele.isDisplayed();
        } catch (Exception e) {
            Log.info("Error : Element identified is not clickable: " + e);
        }
        return isDisplayed;
    }

    public static boolean isDisplayed(AppiumDriver driver, WebElement ele) {
        boolean isDisplayed = false;
        try {
            ElementWrappers.waitForElement(driver, ele);
//			(new WebDriverWait(driver, maxElementWait)).until(ExpectedConditions.visibilityOf(ele));
            isDisplayed = ele.isDisplayed();
            String output = isDisplayed ? "Pass" : "Fail";
//            Log.info(output + " : Element displayed");
        } catch (StaleElementReferenceException e) {
            // retry the find element
            isDisplayed = ele.isDisplayed();
        } catch (Exception e) {
            Log.info("Error : Element identified is not clickable: " + e);
        }
        return isDisplayed;
    }

    public static boolean isDisplayed(AppiumDriver driver, By by) {
        boolean isDisplayed = false;
        try {
            ElementWrappers.waitForElement(driver, driver.findElement(by));
//			(new WebDriverWait(driver, maxElementWait)).until(ExpectedConditions.elementToBeClickable(by));
            isDisplayed = driver.findElement(by).isDisplayed();
        } catch (StaleElementReferenceException e) {
            // retry the find element
            isDisplayed = driver.findElement(by).isDisplayed();
        } catch (Exception e) {
            // log("Element identified is not clickable");
        }
        return isDisplayed;
    }

    public static int getChildCount(AppiumDriver driver, By by) {
        int count = 0;
        try {
            ElementWrappers.waitForElement(driver, driver.findElement(by));
            (new WebDriverWait(driver, maxElementWait)).until(ExpectedConditions.elementToBeClickable(by));
            count = driver.findElements(by).size();
        } catch (StaleElementReferenceException e) {
            // retry the find element
            count = driver.findElements(by).size();
        } catch (Exception e) {
            // log("Element identified is not clickable");
        }
        return count;
    }

    /**
     * Getting the WebElements as list at run time
     *
     * @param driver
     * @param by
     * @return
     */
    public static List<WebElement> getElements(AppiumDriver driver, By by) {
        List<WebElement> ele = new ArrayList<>();
        ele = driver.findElements(by);
        return ele;
    }

    /**
     * Getting the WebElement at run time
     *
     * @param driver
     * @param by
     * @return
     */
    public static WebElement getElement(AppiumDriver driver, By by) {
        WebElement ele;
        ele = driver.findElement(by);
        return ele;
    }

    /**
     * To get getCCenter point of the web element
     *
     * @param element
     * @return
     */
    public static Point getCenter(WebElement element) {
        Dimension size = element.getSize();
        int halfWidth = size.getWidth() / 2;
        int halfHeight = size.getHeight() / 2;

        Point loc = element.getLocation();
        int posX = loc.getX() + halfWidth;
        int posY = loc.getY() + halfHeight;

        Point point = new Point(posX, posY);
        return point;
    }

    public static String getMobileScreenshot(AppiumDriver driver, String deviceName) throws IOException {
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage img = Scalr.resize(ImageIO.read(screen), 400);
        Date d = new Date();
        String imgName = "Extent_" + (new Timestamp(System.currentTimeMillis())).toString().replaceAll("-", "").replaceAll(":", "").replaceAll("\\s+", "").substring(0, 14) + deviceName + ".png";
        ImageIO.write(img, "png", new File(System.getProperty("user.dir") + File.separator + "reports" + File.separator + "screenshots" + File.separator + imgName));
        return "screenshots" + File.separator + imgName;
    }

    public static String getScrenshShotInBase64(String image) {
        try {
            String imageLocation = System.getProperty("user.dir") + File.separator + "reports" + File.separator + image;
            File fileInputStreamReader = new File(imageLocation);
            String encodedImage = Base64.getEncoder().withoutPadding().encodeToString(FileUtils.readFileToByteArray(fileInputStreamReader));
            return encodedImage;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "File Not Found";
        } catch (IOException e) {
            e.printStackTrace();
            return "IO Exception";
        }
    }
}
