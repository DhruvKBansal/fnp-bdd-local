package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.FranchiseEnquiryPageLocators;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

public class FranchiseEnquiryPage {

    WebDriver webDriver;
    WebDriverHelper webDriverHelper;
    ExtentTest extentTest;

    By elementLocator;
    String actionLogMessage;
    Status logStatus;
    int excelRowIndex;
    int excelColumnIndex;

    public FranchiseEnquiryPage(WebDriver webDriver, ExtentTest extentTest) {
        this.webDriver = webDriver;
        this.webDriverHelper = new WebDriverHelper(webDriver);
        this.extentTest = extentTest;
    }

    /**
     * a. Method name: clickOnElement
     * b. Author name: Dhruv Kumar Bansal
     * c. Short description: Clicks on the specified element by resolving its
     *    locator and log message using a switch-case.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void clickOnElement(String elementIdentifier) {

        switch (elementIdentifier) {

            case "submitButton":
                elementLocator = FranchiseEnquiryPageLocators.submitButton;
                actionLogMessage = "Clicked Submit button on Franchise form";
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
     * b. Author name: Dhruv Kumar Bansal
     * c. Short description: Enters data into a franchise form field, reading value
     *    from excel. Handles both positive and negative scenarios through row index.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier, int dataRowIndex
     */
    public void enterDataIntoElement(String elementIdentifier, int dataRowIndex) {

        switch (elementIdentifier) {

            case "name":
                elementLocator = FranchiseEnquiryPageLocators.nameField;
                excelColumnIndex = 0;
                actionLogMessage = "Entered franchise owner name";
                break;

            case "email":
                elementLocator = FranchiseEnquiryPageLocators.emailField;
                excelColumnIndex = 1;
                actionLogMessage = "Entered email address";
                break;

            case "mobile":
                elementLocator = FranchiseEnquiryPageLocators.mobileField;
                excelColumnIndex = 2;
                actionLogMessage = "Entered mobile number";
                break;

            case "city":
                elementLocator = FranchiseEnquiryPageLocators.cityField;
                excelColumnIndex = 3;
                actionLogMessage = "Entered city";
                break;

            case "query":
                elementLocator = FranchiseEnquiryPageLocators.queryField;
                excelColumnIndex = 4;
                actionLogMessage = "Entered query";
                break;

            case "neededToKnow":
                elementLocator = FranchiseEnquiryPageLocators.neededToKnowDropdown;
                excelColumnIndex = 5;
                actionLogMessage = "Selected needed-to-know option";
                break;

            default:
                LoggerHandler.warn("enterDataIntoElement: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "enterDataIntoElement: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {
            String excelValue = ExcelReader.readDataFromExcel("FranchiseEnquiry", dataRowIndex, excelColumnIndex);
            webDriverHelper.waitForElementToBeVisible(elementLocator, 10);
            webDriverHelper.clickOnElement(elementLocator);
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
     * a. Method name: selectOptionFromDropdown
     * b. Author name: Dhruv Kumar Bansal
     * c. Short description: Selects an option from the needed-to-know dropdown.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier, String optionText
     */
    public void selectOptionFromDropdown(String elementIdentifier, String optionText) {

        switch (elementIdentifier) {

            case "neededToKnow":
                elementLocator = FranchiseEnquiryPageLocators.neededToKnowDropdown;
                actionLogMessage = "Selected needed-to-know option: " + optionText;
                break;

            default:
                LoggerHandler.warn("selectOptionFromDropdown: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "selectOptionFromDropdown: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {
            webDriverHelper.waitForElementToBeVisible(elementLocator, 10);
            webDriverHelper.selectOptionFromDropdown(elementLocator, optionText);
            LoggerHandler.info(actionLogMessage);
            extentTest.log(Status.PASS, actionLogMessage);
        } catch (Exception exception) {
            LoggerHandler.error("selectOptionFromDropdown failed for [" + elementIdentifier + "]: " + exception.getMessage());
            Reporter.attachScreenshotToReport("selectOptionFromDropdown_" + elementIdentifier + "_FAIL", extentTest,
                    "selectOptionFromDropdown failed for [" + elementIdentifier + "]: " + exception.getMessage());
            extentTest.log(Status.FAIL, "selectOptionFromDropdown failed for [" + elementIdentifier + "]: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: verifyPageIsLoaded
     * b. Author name: Dhruv Kumar Bansal
     * c. Short description: Verifies the franchise enquiry page loaded.
     * d. Return type: void
     * e. Parameter list: none
     */
    public void verifyPageIsLoaded() {
        try {
            elementLocator = FranchiseEnquiryPageLocators.nameField;
            webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
            boolean isDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isDisplayed, "Franchise enquiry page loaded");
            LoggerHandler.info("Franchise enquiry page loaded");
            extentTest.log(Status.PASS, "Franchise enquiry page loaded");
        } catch (Exception exception) {
            LoggerHandler.error("verifyPageIsLoaded failed: " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifyPageIsLoaded_FAIL", extentTest,
                    "verifyPageIsLoaded failed: " + exception.getMessage());
            extentTest.log(Status.FAIL, "verifyPageIsLoaded failed: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: verifySubmissionSuccess
     * b. Author name: Dhruv Kumar Bansal
     * c. Short description: Verifies that the franchise form was submitted successfully.
     * d. Return type: void
     * e. Parameter list: none
     */
    public void verifySubmissionSuccess() {
        try {
            elementLocator = FranchiseEnquiryPageLocators.successMessage;
            webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
            boolean isDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isDisplayed, "Franchise form submitted successfully");
            LoggerHandler.info("Franchise form submitted successfully");
            extentTest.log(Status.PASS, "Franchise form submitted successfully");
        } catch (Exception exception) {
            LoggerHandler.error("verifySubmissionSuccess failed: " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifySubmissionSuccess_FAIL", extentTest,
                    "verifySubmissionSuccess failed: " + exception.getMessage());
            extentTest.log(Status.FAIL, "verifySubmissionSuccess failed: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: verifyValidationError
     * b. Author name: Dhruv Kumar Bansal
     * c. Short description: Verifies that a validation error is displayed for
     *    negative scenarios.
     * d. Return type: void
     * e. Parameter list: none
     */
    public void verifyValidationError() {
        try {
            elementLocator = FranchiseEnquiryPageLocators.validationMessage;
            webDriverHelper.waitForElementToBeVisible(elementLocator, 10);
            boolean isDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isDisplayed, "Validation error displayed for invalid franchise input");
            LoggerHandler.info("Validation error displayed for invalid franchise input");
            extentTest.log(Status.PASS, "Validation error displayed for invalid franchise input");
        } catch (Exception exception) {
            LoggerHandler.error("verifyValidationError failed: " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifyValidationError_FAIL", extentTest,
                    "verifyValidationError failed: " + exception.getMessage());
            extentTest.log(Status.FAIL, "verifyValidationError failed: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: captureScreenshotAndLog
     * b. Author name: Dhruv Kumar Bansal
     * c. Short description: Captures a screenshot and logs the result.
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
