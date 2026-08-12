package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.MyOrdersPageLocators;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

public class MyOrdersPage {

    WebDriver webDriver;
    WebDriverHelper webDriverHelper;
    ExtentTest extentTest;

    By elementLocator;
    String actionLogMessage;
    Status logStatus;
    boolean isElementDisplayed;
    int excelRowIndex;
    int excelColumnIndex;

    public MyOrdersPage(WebDriver webDriver, ExtentTest extentTest) {
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

            case "continue":
                elementLocator = MyOrdersPageLocators.continueButton;
                actionLogMessage = "Clicked Continue button";
                logStatus = Status.PASS;
                break;

            case "startGifting":
                elementLocator = MyOrdersPageLocators.startGiftingButton;
                actionLogMessage = "Clicked Start Gifting button";
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
     * c. Short description of method: Enters data into specified field by resolving
     *    its locator, excel row index, and column index via switch-case.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void enterDataIntoElement(String elementIdentifier) {

        switch (elementIdentifier) {

            case "email":
                elementLocator = MyOrdersPageLocators.enterEmail;
                excelRowIndex = 1;
                excelColumnIndex = 0;
                actionLogMessage = "Entered email";
                break;

            case "name":
                elementLocator = MyOrdersPageLocators.enterName;
                excelRowIndex = 2;
                excelColumnIndex = 0;
                actionLogMessage = "Entered name";
                break;

            case "mobile11Digit":
                elementLocator = MyOrdersPageLocators.enterMobileNumber;
                excelRowIndex = 3;
                excelColumnIndex = 0;
                actionLogMessage = "Entered 11-digit mobile number";
                break;

            case "mobile9Digit":
                elementLocator = MyOrdersPageLocators.enterMobileNumber;
                excelRowIndex = 4;
                excelColumnIndex = 0;
                actionLogMessage = "Entered 9-digit mobile number";
                break;

            case "mobile10Digit":
                elementLocator = MyOrdersPageLocators.enterMobileNumber;
                excelRowIndex = 5;
                excelColumnIndex = 0;
                actionLogMessage = "Entered 10-digit mobile number";
                break;

            case "invalidEmail":
                elementLocator = MyOrdersPageLocators.enterEmail;
                excelRowIndex = 6;
                excelColumnIndex = 0;
                actionLogMessage = "Entered invalid email";
                break;

            default:
                LoggerHandler.warn("enterDataIntoElement: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "enterDataIntoElement: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {
            String excelValue = ExcelReader.readDataFromExcel("MyOrders", excelRowIndex, excelColumnIndex);
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
     * a. Method name: verifyElementAfterClick
     * b. Author name: Ruturaj Satish Bhoite
     * c. Short description of method: Verifies the outcome of a click action by
     *    resolving its expected verification locator and log message via switch-case.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void verifyElementAfterClick(String elementIdentifier) {

        switch (elementIdentifier) {

            case "continue":
                elementLocator = MyOrdersPageLocators.enterName;
                actionLogMessage = "Verified account creation form opened";
                break;

            case "startGifting":
                elementLocator = MyOrdersPageLocators.startGiftingResult;
                actionLogMessage = "Verified Start Gifting clicked";
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
     *    checking the relevant field is displayed.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void verifyElementAfterDataEntry(String elementIdentifier) {

        switch (elementIdentifier) {

            case "email":
                elementLocator = MyOrdersPageLocators.continueButton;
                actionLogMessage = "Verified email entered";
                break;

            case "invalidEmail":
                elementLocator = MyOrdersPageLocators.errorMessage;
                actionLogMessage = "Verified invalid email entered";
                break;

            case "name":
                elementLocator = MyOrdersPageLocators.enterMobileNumber;
                actionLogMessage = "Verified name entered";
                break;

            case "mobile11Digit":
            case "mobile9Digit":
            case "mobile10Digit":
                elementLocator = MyOrdersPageLocators.startGiftingButton;
                actionLogMessage = "Verified mobile number entered";
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
     * a. Method name: verifyKeywordInPageSource
     * b. Author name: Ruturaj Satish Bhoite
     * c. Short description of method: Verifies a keyword is present in the page source.
     * d. Return type: void
     * e. Parameter list: String keywordToVerify
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
}
