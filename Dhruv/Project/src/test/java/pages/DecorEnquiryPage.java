package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.DecorEnquiryPageLocators;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

public class DecorEnquiryPage {

    WebDriver webDriver;
    WebDriverHelper webDriverHelper;
    ExtentTest extentTest;

    By elementLocator;
    String actionLogMessage;
    Status logStatus;
    int excelRowIndex;
    int excelColumnIndex;

    public DecorEnquiryPage(WebDriver webDriver, ExtentTest extentTest) {
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
                elementLocator = DecorEnquiryPageLocators.submitButton;
                actionLogMessage = "Clicked Submit button on Decor form";
                logStatus = Status.PASS;
                break;

            case "birthdayWeddingDecor":
                elementLocator = DecorEnquiryPageLocators.birthdayWeddingDecor;
                actionLogMessage = "Clicked Birthday/Wedding Decor";
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
     * c. Short description: Enters data into a decor form field, reading value
     *    from excel. Handles both positive and negative scenarios through row index.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier, int dataRowIndex
     */
    public void enterDataIntoElement(String elementIdentifier, int dataRowIndex) {

        switch (elementIdentifier) {

            case "name":
                elementLocator = DecorEnquiryPageLocators.nameField;
                excelColumnIndex = 0;
                actionLogMessage = "Entered decor enquiry name";
                break;

            case "mobile":
                elementLocator = DecorEnquiryPageLocators.mobileField;
                excelColumnIndex = 1;
                actionLogMessage = "Entered mobile number";
                break;

            case "email":
                elementLocator = DecorEnquiryPageLocators.emailField;
                excelColumnIndex = 2;
                actionLogMessage = "Entered email address";
                break;

            case "budget":
                elementLocator = DecorEnquiryPageLocators.budgetDropdown;
                excelColumnIndex = 3;
                actionLogMessage = "Selected budget";
                break;

            case "eventType":
                elementLocator = DecorEnquiryPageLocators.eventTypeField;
                excelColumnIndex = 4;
                actionLogMessage = "Entered event type";
                break;

            case "eventDate":
                elementLocator = DecorEnquiryPageLocators.eventDateField;
                excelColumnIndex = 5;
                actionLogMessage = "Entered event date";
                break;

            case "location":
                elementLocator = DecorEnquiryPageLocators.locationField;
                excelColumnIndex = 6;
                actionLogMessage = "Entered location";
                break;

            case "message":
                elementLocator = DecorEnquiryPageLocators.messageField;
                excelColumnIndex = 7;
                actionLogMessage = "Entered message";
                break;

            default:
                LoggerHandler.warn("enterDataIntoElement: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "enterDataIntoElement: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {
            String excelValue = ExcelReader.readDataFromExcel("DecorEnquiry", dataRowIndex, excelColumnIndex);
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
     * c. Short description: Selects an option from the budget dropdown.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier, String optionText
     */
    public void selectOptionFromDropdown(String elementIdentifier, String optionText) {

        switch (elementIdentifier) {

            case "budget":
                elementLocator = DecorEnquiryPageLocators.budgetDropdown;
                actionLogMessage = "Selected budget option: " + optionText;
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
     * c. Short description: Verifies the decor enquiry page loaded.
     * d. Return type: void
     * e. Parameter list: none
     */
    public void verifyPageIsLoaded() {
        try {
            elementLocator = DecorEnquiryPageLocators.nameField;
            webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
            boolean isDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isDisplayed, "Decor enquiry page loaded");
            LoggerHandler.info("Decor enquiry page loaded");
            extentTest.log(Status.PASS, "Decor enquiry page loaded");
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
     * c. Short description: Verifies that the decor form was submitted successfully.
     * d. Return type: void
     * e. Parameter list: none
     */
    // public void verifySubmissionSuccess() {
    //     try {
    //         elementLocator = DecorEnquiryPageLocators.successMessage;
    //         webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
    //         boolean isDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
    //         webDriverHelper.verifyTrue(isDisplayed, "Decor form submitted successfully");
    //         LoggerHandler.info("Decor form submitted successfully");
    //         extentTest.log(Status.PASS, "Decor form submitted successfully");
    //     } catch (Exception exception) {
    //         LoggerHandler.error("verifySubmissionSuccess failed: " + exception.getMessage());
    //         Reporter.attachScreenshotToReport("verifySubmissionSuccess_FAIL", extentTest,
    //                 "verifySubmissionSuccess failed: " + exception.getMessage());
    //         extentTest.log(Status.FAIL, "verifySubmissionSuccess failed: " + exception.getMessage());
    //     }
    // }

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
            elementLocator = DecorEnquiryPageLocators.validationMessage;
            webDriverHelper.waitForElementToBeVisible(elementLocator, 10);
            boolean isDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isDisplayed, "Validation error displayed for invalid decor input");
            LoggerHandler.info("Validation error displayed for invalid decor input");
            extentTest.log(Status.PASS, "Validation error displayed for invalid decor input");
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
