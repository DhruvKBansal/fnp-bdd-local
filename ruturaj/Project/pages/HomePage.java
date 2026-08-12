package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.ContactUsPageLocators;
import uistore.CorporatePageLocators;
import uistore.HomePageLocators;
import uistore.MyOrdersPageLocators;
import uistore.ProductListingsPageLocators;
import utils.ExcelReader;
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
    Status logStatus;
    int excelRowIndex;
    int excelColumnIndex;
    String actualTextValue;
    String expectedTextValue;

    public HomePage(WebDriver webDriver, ExtentTest extentTest) {
        this.webDriver = webDriver;
        this.webDriverHelper = new WebDriverHelper(webDriver);
        this.extentTest = extentTest;
    }

    /**
     * a. Method name: clickOnElement
     * b. Author name: Ruturaj Satish Bhoite
     * c. Short description of method: Clicks on the specified element by resolving
     *    its locator and log message using switch-case. Common wait and click
     *    actions are executed once after the switch. Captures screenshot on failure.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void clickOnElement(String elementIdentifier) {

        switch (elementIdentifier) {

            case "popup":
                elementLocator = HomePageLocators.popupNoThanks;
                actionLogMessage = "Clicked No Thanks popup";
                logStatus = Status.PASS;
                break;

            case "profileIcon":
                elementLocator = HomePageLocators.profileIcon;
                actionLogMessage = "Clicked Profile icon";
                logStatus = Status.PASS;
                break;

            case "myOrders":
                elementLocator = HomePageLocators.myOrders;
                actionLogMessage = "Clicked My Orders";
                logStatus = Status.PASS;
                break;
            
            case "corporate":
                elementLocator = HomePageLocators.corporate;
                actionLogMessage = "Clicked Corporate";
                logStatus = Status.PASS;
                break;

            case "corporateContactUs":
                elementLocator = HomePageLocators.corporateContactUs;
                actionLogMessage = "Clicked My Orders";
                logStatus = Status.PASS;
                break;

            case "contactUs":
                elementLocator = HomePageLocators.contactUs;
                actionLogMessage = "Clicked Contact Us";
                logStatus = Status.PASS;
                break;

            case "searchBar":
                elementLocator = HomePageLocators.searchBar;
                actionLogMessage = "Clicked Search Bar";
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
                actionLogMessage = "Clicked First Location Suggestion";
                logStatus = Status.PASS;
                break;

            case "locationConfirmButton":
                elementLocator = HomePageLocators.locationConfirmButton;
                actionLogMessage = "Clicked Confirm Location Button";
                logStatus = Status.PASS;
                break;

            default:
                LoggerHandler.warn("clickOnElement: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "clickOnElement: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {
            webDriverHelper.waitForElementToBeVisible(elementLocator, 10);
            webDriverHelper.clickOnElement(elementLocator);
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
     * b. Author name: Ruturaj Satish Bhoite
     * c. Short description of method: Enters data into specified field by
     *    resolving its locator, excel row index, and column index via switch-case.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void enterDataIntoElement(String elementIdentifier) {

        switch (elementIdentifier) {

            case "searchProduct":
                elementLocator = HomePageLocators.searchBar;
                excelRowIndex = 1;
                excelColumnIndex = 0;
                actionLogMessage = "Entered search product";
                break;

            case "searchFlowers":
                elementLocator = HomePageLocators.searchBar;
                excelRowIndex = 2;
                excelColumnIndex = 0;
                actionLogMessage = "Entered search product: Flowers";
                break;

            case "locationHyderabad":
                elementLocator = HomePageLocators.enterLocation;
                excelRowIndex = 3;
                excelColumnIndex = 0;
                actionLogMessage = "Entered delivery location: Hyderabad";
                break;

            default:
                LoggerHandler.warn("enterDataIntoElement: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "enterDataIntoElement: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {
            String excelValue = ExcelReader.readDataFromExcel("HomePage", excelRowIndex, excelColumnIndex);
            webDriverHelper.waitForElementToBeVisible(elementLocator, 10);
            webDriverHelper.sendKeysToElement(elementLocator, excelValue);
            LoggerHandler.info(actionLogMessage + ": " + excelValue);
            extentTest.log(Status.PASS, actionLogMessage + ": " + excelValue);
        } catch (Exception exception) {
            LoggerHandler.error("enterDataIntoElement failed for [" + elementIdentifier + "]: " + exception.getMessage());
            Reporter.attachScreenshotToReport("enterDataIntoElement_" + elementIdentifier + "_FAIL", extentTest,
                    "enterDataIntoElement failed for [" + elementIdentifier + "]: " + exception.getMessage());
            extentTest.log(Status.FAIL, "enterDataIntoElement failed for [" + elementIdentifier + "]: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: pressEnterOnElement
     * b. Author name: Ruturaj Satish Bhoite
     * c. Short description of method: Performs ENTER action on specified element.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void pressEnterOnElement(String elementIdentifier) {

        switch (elementIdentifier) {

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
     * a. Method name: switchToWindowAtIndex
     * b. Author name: Ruturaj Satish Bhoite
     * c. Short description of method: Switches to the browser window/tab at the given index.
     * d. Return type: void
     * e. Parameter list: int windowIndex
     */
    public void switchToWindowAtIndex(int windowIndex) {
        webDriverHelper.switchToWindowAtIndex(windowIndex);
    }

    /**
     * a. Method name: captureScreenshotAndLog
     * b. Author name: Ruturaj Satish Bhoite
     * c. Short description of method: Captures a screenshot and logs the result.
     * d. Return type: void
     * e. Parameter list: String screenshotFileName
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

    /**
     * a. Method name: verifyElementAfterClick
     * b. Author name: Ruturaj Satish Bhoite
     * c. Short description of method: Verifies the outcome of a click action by
     *    resolving its expected verification locator and log message via switch-case.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void verifyElementAfterClick(String elementIdentifier) {

        switch (elementIdentifier) {

            case "popup":
                elementLocator = HomePageLocators.profileIcon;
                actionLogMessage = "Verified homepage displayed after closing popup";
                break;

            case "profileIcon":
                elementLocator = HomePageLocators.myOrders;
                actionLogMessage = "Verified Profile menu opened";
                break;

            case "myOrders":
                elementLocator = MyOrdersPageLocators.enterEmail;
                actionLogMessage = "Verified My Orders page loaded";
                break;
            
            case "corporate":
                elementLocator = CorporatePageLocators.requestCallback;
                actionLogMessage = "Verified Corporate page loaded";
                break;

            case "contactUs":
                elementLocator = ContactUsPageLocators.trackOrder;
                actionLogMessage = "Verified Contact Us page loaded";
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
     * b. Author name: Ruturaj Satish Bhoite
     * c. Short description of method: Verifies the outcome of entering data by
     *    checking the relevant suggestion/populated field is displayed.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void verifyElementAfterDataEntry(String elementIdentifier) {

        switch (elementIdentifier) {

            // case "searchProduct":
            //     elementLocator = HomePageLocators.searchSuggestionsVerify;
            //     actionLogMessage = "Verified search suggestions appeared";
            //     break;

            case "searchFlowers":
                expectedTextValue = "flowers";
                elementLocator = HomePageLocators.searchBar;
                actionLogMessage = "Verified search keyword entered";
                break;

            case "hyderabad":
                expectedTextValue = "Hyderabad";
                elementLocator = HomePageLocators.enterLocation;
                actionLogMessage = "Verified location suggestions appeared";
                break;

            default:
                LoggerHandler.warn("verifyElementAfterDataEntry: no verification mapped for [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "verifyElementAfterDataEntry: no verification mapped for [" + elementIdentifier + "]");
                return;
                
        }

        try {
            webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
            actualTextValue = webDriver.findElement(elementLocator).getAttribute("value");
            webDriverHelper.verifyEquals(actualTextValue,expectedTextValue);
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
     * b. Author name: Ruturaj Satish Bhoite
     * c. Short description of method: Verifies the outcome of an ENTER key action.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void verifyElementAfterEnter(String elementIdentifier) {

        switch (elementIdentifier) {

            case "searchBar":
                elementLocator = ProductListingsPageLocators.pageHeading;
                actionLogMessage = "Verified search initiated";
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
     * b. Author name: Ruturaj Satish Bhoite
     * c. Short description of method: Verifies the text of the selected location.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void verifyElementText(String elementIdentifier) {

        switch (elementIdentifier) {

            case "hyderabadPinCode":
                expectedTextValue = "Hyderabad, Telangana, India, 500063";
                actionLogMessage = "Verified Hyderabad Pincode";
                break;


            default:
                LoggerHandler.warn("verifyElementText: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "verifyElementText: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {

            elementLocator = HomePageLocators.pinCode;
            actualTextValue = webDriverHelper.getTextFromElement(elementLocator);
            webDriverHelper.verifyEquals(actualTextValue, expectedTextValue);

            LoggerHandler.info(actionLogMessage);
            extentTest.log(Status.PASS, actionLogMessage);

        } catch (Exception exception) {

            LoggerHandler.error(
                    "verifyElementText failed for [" + elementIdentifier + "]: " + exception.getMessage());

            Reporter.attachScreenshotToReport(
                    "verifyElementText_" + elementIdentifier + "_FAIL",
                    extentTest,
                    "verifyElementText failed for [" + elementIdentifier + "]: " + exception.getMessage());

            extentTest.log(Status.FAIL,
                    "verifyElementText failed for [" + elementIdentifier + "]: " + exception.getMessage());
        }
    }
    
}
