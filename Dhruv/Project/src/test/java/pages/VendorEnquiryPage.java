package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.VendorEnquiryPageLocators;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

public class VendorEnquiryPage {

    WebDriver webDriver;
    WebDriverHelper webDriverHelper;
    ExtentTest extentTest;

    By elementLocator;
    String actionLogMessage;
    Status logStatus;
    int excelRowIndex;
    int excelColumnIndex;

    public VendorEnquiryPage(WebDriver webDriver, ExtentTest extentTest) {
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
                elementLocator = VendorEnquiryPageLocators.submitButton;
                actionLogMessage = "Clicked Submit button";
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
     * c. Short description: Enters data into a vendor form field, reading value
     *    from excel. Handles both positive and negative scenarios through row index.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier, int dataRowIndex
     */
    public void enterDataIntoElement(String elementIdentifier, int dataRowIndex) {

        switch (elementIdentifier) {

            case "name":
                elementLocator = VendorEnquiryPageLocators.nameField;
                excelColumnIndex = 0;
                actionLogMessage = "Entered vendor name";
                break;

            case "mobile":
                elementLocator = VendorEnquiryPageLocators.mobileField;
                excelColumnIndex = 1;
                actionLogMessage = "Entered mobile number";
                break;

            case "email":
                elementLocator = VendorEnquiryPageLocators.emailField;
                excelColumnIndex = 2;
                actionLogMessage = "Entered email address";
                break;

            case "category":
                elementLocator = VendorEnquiryPageLocators.categoryDropdown;
                excelColumnIndex = 3;
                actionLogMessage = "Selected category";
                break;

            case "city":
                elementLocator = VendorEnquiryPageLocators.cityField;
                excelColumnIndex = 4;
                actionLogMessage = "Entered city";
                break;

            case "area":
                elementLocator = VendorEnquiryPageLocators.areaField;
                excelColumnIndex = 5;
                actionLogMessage = "Entered area";
                break;

            case "comments":
                elementLocator = VendorEnquiryPageLocators.commentsField;
                excelColumnIndex = 6;
                actionLogMessage = "Entered comments";
                break;

            default:
                LoggerHandler.warn("enterDataIntoElement: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "enterDataIntoElement: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {
            String excelValue = ExcelReader.readDataFromExcel("VendorEnquiry", dataRowIndex, excelColumnIndex);
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
     * c. Short description: Selects an option from a dropdown.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier, String optionText
     */
    public void selectOptionFromDropdown(String elementIdentifier, String optionText) {

        switch (elementIdentifier) {

            case "category":
                elementLocator = VendorEnquiryPageLocators.categoryDropdown;
                actionLogMessage = "Selected category option: " + optionText;
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
     * c. Short description: Verifies the vendor enquiry page loaded.
     * d. Return type: void
     * e. Parameter list: none
     */
    public void verifyPageIsLoaded() {
        try {
            elementLocator = VendorEnquiryPageLocators.nameField;
            webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
            boolean isDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isDisplayed, "Vendor enquiry page loaded");
            LoggerHandler.info("Vendor enquiry page loaded");
            extentTest.log(Status.PASS, "Vendor enquiry page loaded");
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
     * c. Short description: Verifies that the vendor form was submitted successfully.
     * d. Return type: void
     * e. Parameter list: none
     */
    public void verifySubmissionSuccess() {
        try {
            elementLocator = VendorEnquiryPageLocators.successMessage;
            webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
            boolean isDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isDisplayed, "Vendor form submitted successfully");
            LoggerHandler.info("Vendor form submitted successfully");
            extentTest.log(Status.PASS, "Vendor form submitted successfully");
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
            elementLocator = VendorEnquiryPageLocators.validationMessage;
            webDriverHelper.waitForElementToBeVisible(elementLocator, 10);
            boolean isDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isDisplayed, "Validation error displayed for invalid input");
            LoggerHandler.info("Validation error displayed for invalid input");
            extentTest.log(Status.PASS, "Validation error displayed for invalid input");
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
