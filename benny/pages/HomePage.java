package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.HomePageLocators;
import uistore.ProductListingLocators;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

public class HomePage {

    WebDriver webDriver;
    WebDriverHelper webDriverHelper;
    ExtentTest extentTest;

    By elementLocator;
    String actionLogMessage;
String expectedTextValue;
    String actualTextValue;
    Status logStatus;

    public HomePage(WebDriver webDriver, ExtentTest extentTest) {
        this.webDriver = webDriver;
        this.webDriverHelper = new WebDriverHelper(webDriver);
        this.extentTest = extentTest;
    }

    /**
     * a. Method name: clickOnElement
     * b. Short description: Clicks on the specified element by resolving its locator
     *    and log message via switch-case.
     * c. Return type: void
     * d. Parameter list: String elementIdentifier
     */
    public void clickOnElement(String elementIdentifier) {

        switch (elementIdentifier) {

            case "popup":
                elementLocator = HomePageLocators.popupNoThanks;
                actionLogMessage = "Clicked No Thanks popup";
                logStatus = Status.PASS;
                break;

            case "whereToDeliver":
                elementLocator = HomePageLocators.whereToDeliver;
                actionLogMessage = "Clicked Where To Deliver";
                logStatus = Status.PASS;
                break;

            case "enterLocation":
                elementLocator = HomePageLocators.enterLocation;
                actionLogMessage = "Clicked Enter Location";
                logStatus = Status.PASS;
                break;

            case "firstLocationSuggestion":
                elementLocator = HomePageLocators.firstLocationSuggestion;
                actionLogMessage = "Clicked on First Location Suggestion";
                logStatus = Status.PASS;
                break;

            case "locationConfirmButton":
                elementLocator = HomePageLocators.locationConfirmButton;
                actionLogMessage = "Clicked Confirm Location Button";
                logStatus = Status.PASS;
                break;
                
            case "locationConfirmButtonEnabled":
            	elementLocator = HomePageLocators.locationConfirmButtonEnabled;
                actionLogMessage = "Clicked Confirm Location Button";
                logStatus = Status.PASS;
                break;

            case "searchBar":
                elementLocator = HomePageLocators.searchBar;
                actionLogMessage = "Clicked Search Bar";
                logStatus = Status.PASS;
                break;

            case "corporateIcon":
                elementLocator = HomePageLocators.corporateIcon;
                actionLogMessage = "Clicked Corporate icon";
                logStatus = Status.PASS;
                break;

            case "reminderIcon":
                elementLocator = HomePageLocators.reminderIcon;
                actionLogMessage = "Clicked Reminder icon";
                logStatus = Status.PASS;
                break;

            default:
                LoggerHandler.warn("clickOnElement: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "clickOnElement: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {
            webDriverHelper.waitForElementToBeVisible(elementLocator, 10);
            webDriverHelper.clickWithFallback(elementLocator);
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

        	case "delhi":
                elementLocator = HomePageLocators.enterLocation;
                actionLogMessage = "Entered location: Delhi";
                break;

            case "chennai":
                elementLocator = HomePageLocators.enterLocation;
                actionLogMessage = "Entered location: Chennai";
                break;

            case "bangalore":
                elementLocator = HomePageLocators.enterLocation;
                actionLogMessage = "Entered location: Bangalore";
                break;

            case "kolkata":
                elementLocator = HomePageLocators.enterLocation;
                actionLogMessage = "Entered location: Kolkata";
                break;

            case "searchProduct":
                elementLocator = HomePageLocators.searchBar;
                actionLogMessage = "Entered product in search box";
                break;

            default:
                LoggerHandler.warn("enterDataIntoElement: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "enterDataIntoElement: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {
            webDriverHelper.waitForElementToBeVisible(elementLocator, 10);
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

    /**
     * Helper method to provide the hardcoded data to enter for a given element identifier.
     */
    private String resolveDataToEnter(String elementIdentifier) {
        switch (elementIdentifier) {
            case "delhi":
                return "Delhi";
            case "chennai":
                return "Chennai";
            case "bangalore":
                return "Bangalore";
            case "kolkata":
                return "Kolkata";
            case "searchProduct":
                return "Cake";
            default:
                return "";
        }
    }

    /**
     * a. Method name: pressEnterOnElement
     * b. Short description: Presses ENTER on the specified element.
     * c. Return type: void
     * d. Parameter list: String elementIdentifier
     */
    public void pressEnterOnElement(String elementIdentifier) {

        switch (elementIdentifier) {

            case "locationConfirmButton":
                elementLocator = HomePageLocators.locationConfirmButton;
                actionLogMessage = "Pressed Enter on Confirm Location Button";
                break;

            case "searchBar":
                elementLocator = HomePageLocators.searchBar;
                actionLogMessage = "Pressed Enter on Search Bar";
                break;

            default:
                LoggerHandler.warn("pressEnterOnElement: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "pressEnterOnElement: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {
            webDriverHelper.waitForElementToBeVisible(elementLocator, 10);
            webDriverHelper.pressEnterKey(elementLocator);
            LoggerHandler.info(actionLogMessage);
            extentTest.log(Status.PASS, actionLogMessage);
        } catch (Exception exception) {
            LoggerHandler.error("pressEnterOnElement failed for [" + elementIdentifier + "]: " + exception.getMessage());
            Reporter.attachScreenshotToReport("pressEnterOnElement_" + elementIdentifier + "_FAIL", extentTest,
                    "pressEnterOnElement failed for [" + elementIdentifier + "]: " + exception.getMessage());
            extentTest.log(Status.FAIL, "pressEnterOnElement failed for [" + elementIdentifier + "]: " + exception.getMessage());
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

            case "popup":
                elementLocator = HomePageLocators.searchBar;
                actionLogMessage = "Verified homepage loaded after closing popup";
                break;

            case "whereToDeliver":
                elementLocator = HomePageLocators.enterLocation;
                actionLogMessage = "Verified Where To Deliver dialog opened";
                break;

            case "enterLocation":
            case "firstLocationSuggestion":
                elementLocator = HomePageLocators.locationConfirmButton;
                actionLogMessage = "Verified location suggestion selected";
                break;

            case "locationConfirmButton":
                elementLocator = HomePageLocators.searchBar;
                actionLogMessage = "Verified location was confirmed";
                break;
            

            case "searchBar":
                elementLocator = HomePageLocators.searchBar;
                actionLogMessage = "Verified search bar is ready";
                break;

            case "corporateIcon":
                elementLocator = HomePageLocators.corporateIcon;
                actionLogMessage = "Verified Corporate icon clicked";
                break;

            case "reminderIcon":
                elementLocator = HomePageLocators.reminderIcon;
                actionLogMessage = "Verified Reminder icon clicked";
                break;

            default:
                LoggerHandler.warn("verifyElementAfterClick: no verification mapped for [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "verifyElementAfterClick: no verification mapped for [" + elementIdentifier + "]");
                return;
        }

        try {
            webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
            boolean isDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isDisplayed, actionLogMessage);
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
     * b. Short description: Verifies that entering data produced the expected result,
     *    e.g. location suggestions appeared after entering a city.
     * c. Return type: void
     * d. Parameter list: String elementIdentifier
     */
    public void verifyElementAfterDataEntry(String elementIdentifier) {

        switch (elementIdentifier) {

            case "delhi":
            case "chennai":
            case "bangalore":
            case "kolkata":
                elementLocator = HomePageLocators.firstLocationSuggestion;
                actionLogMessage = "Verified location suggestions appeared for entered data";
                break;

            case "searchProduct":
                elementLocator = HomePageLocators.searchBar;
                actionLogMessage = "Verified search keyword entered";
                break;

            default:
                LoggerHandler.warn("verifyElementAfterDataEntry: no verification mapped for [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "verifyElementAfterDataEntry: no verification mapped for [" + elementIdentifier + "]");
                return;
        }

        try {
            webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
            boolean isDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isDisplayed, actionLogMessage);
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
     * a. Method name: verifyElementAfterEnter
     * b. Short description: Verifies the outcome of an ENTER key action.
     *    For location confirm, verifies search bar is reachable (dialog closed).
     *    For search, verifies the listing page heading is displayed.
     * c. Return type: void
     * d. Parameter list: String elementIdentifier
     */
    public void verifyElementAfterEnter(String elementIdentifier) {

        switch (elementIdentifier) {

            case "locationConfirmButton":
                elementLocator = HomePageLocators.searchBar;
                actionLogMessage = "Verified location confirmed via Enter";
                break;

            case "searchBar":
                elementLocator = ProductListingLocators.pageHeading;
                actionLogMessage = "Verified search results page loaded";
                break;

            default:
                LoggerHandler.warn("verifyElementAfterEnter: no verification mapped for [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "verifyElementAfterEnter: no verification mapped for [" + elementIdentifier + "]");
                return;
        }

        try {
            webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
            boolean isDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isDisplayed, actionLogMessage);
            LoggerHandler.info(actionLogMessage);
            extentTest.log(Status.PASS, actionLogMessage);
        } catch (Exception exception) {
            LoggerHandler.error("verifyElementAfterEnter failed for [" + elementIdentifier + "]: " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifyElementAfterEnter_" + elementIdentifier + "_FAIL", extentTest,
                    "verifyElementAfterEnter failed for [" + elementIdentifier + "]: " + exception.getMessage());
            extentTest.log(Status.FAIL, "verifyElementAfterEnter failed for [" + elementIdentifier + "]: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: verifyElementText
     * b. Short description: Verifies the text of the selected location (pincode).
     * c. Return type: void
     * d. Parameter list: String elementIdentifier
     */
    public void verifyElementText(String elementIdentifier) {

        switch (elementIdentifier) {

            case "delhiPinCode":
                expectedTextValue = "Delhi, India, 110085";
                elementLocator = HomePageLocators.delhiPinCode;
                actionLogMessage = "Verified Delhi Pincode";
                break;

            case "chennaiPinCode":
                expectedTextValue = "Chennai, Tamil Nadu, India, 600003";
                elementLocator = HomePageLocators.chennaiPinCode;
                actionLogMessage = "Verified Chennai Pincode";
                break;

            case "bangalorePinCode":
                expectedTextValue = "Bangalore, Karnataka, India, 560002";
                elementLocator = HomePageLocators.bangalorePinCode;
                actionLogMessage = "Verified Bangalore Pincode";
                break;

            case "kolkataPinCode":
                expectedTextValue = "Kolkata, West Bengal, India, 700073";
                elementLocator = HomePageLocators.kolkataPinCode;
                actionLogMessage = "Verified Kolkata Pincode";
                break;

            default:
                LoggerHandler.warn("verifyElementText: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "verifyElementText: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {
            actualTextValue = webDriverHelper.getTextFromElement(elementLocator);
            webDriverHelper.verifyEquals(actualTextValue, expectedTextValue);
            LoggerHandler.info(actionLogMessage);
            extentTest.log(Status.PASS, actionLogMessage);
        } catch (Exception exception) {
            LoggerHandler.error("verifyElementText failed for [" + elementIdentifier + "]: " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifyElementText_" + elementIdentifier + "_FAIL", extentTest,
                    "verifyElementText failed for [" + elementIdentifier + "]: " + exception.getMessage());
            extentTest.log(Status.FAIL, "verifyElementText failed for [" + elementIdentifier + "]: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: verifyPageIsLoaded
     * b. Short description: Verifies the FNP website loads successfully.
     * c. Return type: void
     * d. Parameter list: none
     */
    public void verifyPageIsLoaded() {
        try {
            elementLocator = HomePageLocators.searchBar;
            webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
            boolean isDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isDisplayed, "FNP website loaded successfully");
            LoggerHandler.info("FNP website loaded successfully");
            extentTest.log(Status.PASS, "FNP website loaded successfully");
        } catch (Exception exception) {
            LoggerHandler.error("verifyPageIsLoaded failed: " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifyPageIsLoaded_FAIL", extentTest,
                    "verifyPageIsLoaded failed: " + exception.getMessage());
            extentTest.log(Status.FAIL, "verifyPageIsLoaded failed: " + exception.getMessage());
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
