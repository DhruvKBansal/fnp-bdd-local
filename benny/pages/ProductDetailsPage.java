package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.ProductDetailsPageLocators;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

public class ProductDetailsPage {

    WebDriver webDriver;
    WebDriverHelper webDriverHelper;
    ExtentTest extentTest;

    By elementLocator;
    String actionLogMessage;
    Status logStatus;
    boolean isElementDisplayed;

    public ProductDetailsPage(WebDriver webDriver, ExtentTest extentTest) {
        this.webDriver = webDriver;
        this.webDriverHelper = new WebDriverHelper(webDriver);
        this.extentTest = extentTest;
    }

    /**
     * a. Method name: clickOnElement
     * b. Short description: Clicks on the specified element by resolving its locator.
     * c. Return type: void
     * d. Parameter list: String elementIdentifier
     */
    public void clickOnElement(String elementIdentifier) {

        switch (elementIdentifier) {

            case "giftReceiverLocation":
                elementLocator = ProductDetailsPageLocators.giftReceiverLocation;
                actionLogMessage = "Clicked Gift Receiver's Location input field";
                logStatus = Status.PASS;
                break;

            case "giftReceiverLocationClear":
                elementLocator = ProductDetailsPageLocators.giftReceiverLocationClear;
                actionLogMessage = "Clicked X to clear pre-filled Gift Receiver's Location";
                logStatus = Status.PASS;
                break;

            case "giftReceiverLocationInput":
                elementLocator = ProductDetailsPageLocators.giftReceiverLocationInput;
                actionLogMessage = "Clicked Gift Receiver's Location input field for entry";
                logStatus = Status.PASS;
                break;

            case "giftReceiverLocationSuggestion":
                elementLocator = ProductDetailsPageLocators.giftReceiverLocationSuggestion;
                actionLogMessage = "Clicked first location suggestion for Gift Receiver";
                logStatus = Status.PASS;
                break;


            case "addToCart":
                elementLocator = ProductDetailsPageLocators.addToCart;
                actionLogMessage = "Clicked Add To Cart button";
                logStatus = Status.PASS;
                break;

            case "skipAndContinue":
                elementLocator = ProductDetailsPageLocators.skipAndContinue;
                actionLogMessage = "Clicked Skip & Continue";
                logStatus = Status.PASS;
                break;

            case "viewCart":
                elementLocator = ProductDetailsPageLocators.viewCart;
                actionLogMessage = "Clicked View Cart";
                logStatus = Status.PASS;
                break;

            case "removeCross":
                elementLocator = ProductDetailsPageLocators.removeCross;
                actionLogMessage = "Clicked cross mark to remove item";
                logStatus = Status.PASS;
                break;

            case "confirmRemove":
                elementLocator = ProductDetailsPageLocators.confirmRemove;
                actionLogMessage = "Clicked Yes, Remove";
                logStatus = Status.PASS;
                break;

            default:
                LoggerHandler.warn("clickOnElement: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "clickOnElement: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {
            webDriverHelper.waitForElementToBeVisible(elementLocator, 20);
            webDriverHelper.hoverOverElement(elementLocator);
            webDriverHelper.waitForElementToBeClickable(elementLocator, 20);
            webDriverHelper.jsClick(elementLocator);
            LoggerHandler.info(actionLogMessage);
            extentTest.log(logStatus, actionLogMessage);
        } catch (Exception exception) {
            LoggerHandler.error("clickOnElement failed for [" + elementIdentifier + "]: " + exception.getMessage());
            Reporter.attachScreenshotToReport("clickOnElement_" + elementIdentifier + "_FAIL", extentTest,
                    "clickOnElement failed for [" + elementIdentifier + "]: " + exception.getMessage());
            extentTest.log(Status.FAIL, "clickOnElement failed for [" + elementIdentifier + "]: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: enterDataIntoElement
     * b. Short description: Enters data into the specified field.
     * c. Return type: void
     * d. Parameter list: String elementIdentifier
     */
    public void enterDataIntoElement(String elementIdentifier) {

        switch (elementIdentifier) {

            case "giftReceiverLocationInput":
                elementLocator = ProductDetailsPageLocators.giftReceiverLocationInput;
                actionLogMessage = "Entered city in Gift Receiver's Location";
                break;
            case "giftReceiverLocationInputInvalid":
            	elementLocator = ProductDetailsPageLocators.giftReceiverLocationInput;
                actionLogMessage = "Entered city in Gift Receiver's Location";
                break;

            default:
                LoggerHandler.warn("enterDataIntoElement: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "enterDataIntoElement: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {
            webDriverHelper.waitForElementToBeVisible(elementLocator, 20);
            webDriverHelper.sendKeysToElement(elementLocator, resolveDataToEnter(elementIdentifier));
            LoggerHandler.info(actionLogMessage);
            extentTest.log(Status.PASS, actionLogMessage);
        } catch (Exception exception) {
            LoggerHandler.error("enterDataIntoElement failed for [" + elementIdentifier + "]: " + exception.getMessage());
            Reporter.attachScreenshotToReport("enterDataIntoElement_" + elementIdentifier + "_FAIL", extentTest,
                    "enterDataIntoElement failed for [" + elementIdentifier + "]: " + exception.getMessage());
            extentTest.log(Status.FAIL, "enterDataIntoElement failed for [" + elementIdentifier + "]: " + exception.getMessage());
        }
    }
    
    private String resolveDataToEnter(String elementIdentifier) {
        switch (elementIdentifier) {
            case "giftReceiverLocationInput":
                return "Chennai";
            case "giftReceiverLocationInputInvalid":
                return "53236262@";
            default:
                return "";
        }
    }



    /**
     * a. Method name: verifyPageIsLoaded
     * b. Short description: Verifies the Product Details Page is loaded.
     * c. Return type: void
     * d. Parameter list: none
     */
    public void verifyPageIsLoaded() {
        try {
            elementLocator = ProductDetailsPageLocators.addToCart;
            webDriverHelper.waitForElementToBeVisible(elementLocator, 20);
            isElementDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isElementDisplayed, "Product details page loaded successfully");
            LoggerHandler.info("Product details page loaded successfully");
            extentTest.log(Status.PASS, "Product details page loaded successfully");
        } catch (Exception exception) {
            LoggerHandler.error("verifyPageIsLoaded failed: " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifyPageIsLoaded_FAIL", extentTest,
                    "verifyPageIsLoaded failed: " + exception.getMessage());
            extentTest.log(Status.FAIL, "verifyPageIsLoaded failed: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: verifyElementAfterClick
     * b. Short description: Verifies the outcome of a click action.
     * c. Return type: void
     * d. Parameter list: String elementIdentifier
     */
    public void verifyElementAfterClick(String elementIdentifier) {

        switch (elementIdentifier) {

case "giftReceiverLocation":
                elementLocator = ProductDetailsPageLocators.giftReceiverLocation;
                actionLogMessage = "Verified Gift Receiver's Location field clicked";
                break;

            case "giftReceiverLocationClear":
                elementLocator = ProductDetailsPageLocators.giftReceiverLocationInput;
                actionLogMessage = "Verified pre-filled Gift Receiver's Location cleared";
                break;

            case "giftReceiverLocationInput":
                elementLocator = ProductDetailsPageLocators.giftReceiverLocationInput;
                actionLogMessage = "Verified Gift Receiver's Location input ready for entry";
                break;

            case "addToCart":
                elementLocator = ProductDetailsPageLocators.skipAndContinue;
                actionLogMessage = "Verified Add To Cart clicked";
                break;

            case "skipAndContinue":
                elementLocator = ProductDetailsPageLocators.viewCart;
                actionLogMessage = "Verified Skip & Continue clicked";
                break;

            case "viewCart":
                elementLocator = ProductDetailsPageLocators.removeCross;
                actionLogMessage = "Verified View Cart opened";
                break;

            case "removeCross":
                elementLocator = ProductDetailsPageLocators.confirmRemove;
                actionLogMessage = "Verified remove confirmation appeared";
                break;

            case "confirmRemove":
                elementLocator = ProductDetailsPageLocators.emptyGiftBoxMessage;
                actionLogMessage = "Verified item removed";
                break;

            default:
                LoggerHandler.warn("verifyElementAfterClick: no verification mapped for [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "verifyElementAfterClick: no verification mapped for [" + elementIdentifier + "]");
                return;
        }

        try {
            webDriverHelper.waitForElementToBeVisible(elementLocator, 20);
            isElementDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isElementDisplayed, actionLogMessage);
            LoggerHandler.info(actionLogMessage);
            extentTest.log(Status.PASS, actionLogMessage);
        } catch (Exception exception) {
            LoggerHandler.error("verifyElementAfterClick failed for [" + elementIdentifier + "]: " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifyElementAfterClick_" + elementIdentifier + "_FAIL", extentTest,
                    "verifyElementAfterClick failed for [" + elementIdentifier + "]: " + exception.getMessage());
            extentTest.log(Status.FAIL, "verifyElementAfterClick failed for [" + elementIdentifier + "]: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: verifyElementAfterDataEntry
     * b. Short description: Verifies data was entered into a field.
     * c. Return type: void
     * d. Parameter list: String elementIdentifier
     */
    public void verifyElementAfterDataEntry(String elementIdentifier) {

        switch (elementIdentifier) {

            case "giftReceiverLocation":
            case "giftReceiverLocationInput":
                elementLocator = ProductDetailsPageLocators.giftReceiverLocationInput;
                actionLogMessage = "Verified Gift Receiver's Location entered";
                break;

            default:
                LoggerHandler.warn("verifyElementAfterDataEntry: no verification mapped for [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "verifyElementAfterDataEntry: no verification mapped for [" + elementIdentifier + "]");
                return;
        }

        try {
            webDriverHelper.waitForElementToBeVisible(elementLocator, 20);
            isElementDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isElementDisplayed, actionLogMessage);
            LoggerHandler.info(actionLogMessage);
            extentTest.log(Status.PASS, actionLogMessage);
        } catch (Exception exception) {
            LoggerHandler.error("verifyElementAfterDataEntry failed for [" + elementIdentifier + "]: " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifyElementAfterDataEntry_" + elementIdentifier + "_FAIL", extentTest,
                    "verifyElementAfterDataEntry failed for [" + elementIdentifier + "]: " + exception.getMessage());
            extentTest.log(Status.FAIL, "verifyElementAfterDataEntry failed for [" + elementIdentifier + "]: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: verifyKeywordInPageSource
     * b. Short description: Verifies a keyword is present in the page source.
     * c. Return type: void
     * d. Parameter list: String keywordToVerify
     */
    public void verifyKeywordInPageSource(String keywordToVerify) {
        try {
            boolean keywordPresent = webDriver.getPageSource().contains(keywordToVerify);
            webDriverHelper.verifyTrue(keywordPresent, "verified");
            LoggerHandler.info("Verified keyword: " + keywordToVerify);
            extentTest.log(Status.PASS, "Verified keyword present: " + keywordToVerify);
        } catch (Exception exception) {
            LoggerHandler.error("Keyword verification failed [" + keywordToVerify + "] : " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifyKeywordInPageSource_FAIL", extentTest,
                    "Keyword verification failed [" + keywordToVerify + "] : " + exception.getMessage());
            extentTest.log(Status.FAIL, "Keyword verification failed [" + keywordToVerify + "] : " + exception.getMessage());
        }
    }

    /**
     * a. Method name: switchToWindowAtIndex
     * b. Short description: Switches to the browser window/tab at the given index.
     * c. Return type: void
     * d. Parameter list: int windowIndex
     */
    public void switchToWindowAtIndex(int windowIndex) {
        webDriverHelper.switchToWindowAtIndex(windowIndex);
    }

    /**
     * a. Method name: captureScreenshotAndLog
     * b. Short description: Captures a screenshot and logs the result.
     * c. Return type: void
     * d. Parameter list: String screenshotFileName
     */
    public void captureScreenshotAndLog(String screenshotFileName) {
        try {
            Screenshot.captureScreenshot(webDriver, screenshotFileName);
            LoggerHandler.info("Screenshot captured: " + screenshotFileName);
            extentTest.log(Status.PASS, "Screenshot captured: " + screenshotFileName);
        } catch (Exception exception) {
            LoggerHandler.error("Screenshot capture failed for [" + screenshotFileName + "]: " + exception.getMessage());
            extentTest.log(Status.FAIL, "Screenshot capture failed for [" + screenshotFileName + "]: " + exception.getMessage());
        }
    }
}
