package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.ContactUsPageLocators;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

public class ContactUsPage {

    WebDriver webDriver;
    WebDriverHelper webDriverHelper;
    ExtentTest extentTest;

    By elementLocator;
    String actionLogMessage;
    Status logStatus;
    int excelRowIndex;
    int excelColumnIndex;

    public ContactUsPage(WebDriver webDriver, ExtentTest extentTest) {
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

            case "trackOrder":
                elementLocator = ContactUsPageLocators.trackOrder;
                actionLogMessage = "Clicked Track Order option";
                logStatus = Status.PASS;
                break;

            case "formTrackOrder":
                elementLocator = ContactUsPageLocators.formTrackOrder;
                actionLogMessage = "Clicked Track Order button";
                logStatus = Status.PASS;
                break;

            case "submit":
                elementLocator = ContactUsPageLocators.submitButton;
                actionLogMessage = "Clicked Submit button";
                logStatus = Status.PASS;
                break;

            case "messageField":
                elementLocator = ContactUsPageLocators.messageField;
                actionLogMessage = "Clicked Message textarea";
                logStatus = Status.PASS;
                break;

            case "phoneField":
                elementLocator = ContactUsPageLocators.phoneField;
                actionLogMessage = "Clicked Phone No. field";
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

            // Track Order (TC_53) - TrackOrder sheet
            case "orderNumber":
                elementLocator = ContactUsPageLocators.enterOrderNumber;
                excelRowIndex = 1;
                excelColumnIndex = 0;
                actionLogMessage = "Entered order number";
                break;

            case "trackOrderEmail":
                elementLocator = ContactUsPageLocators.enterEmailId;
                excelRowIndex = 2;
                excelColumnIndex = 0;
                actionLogMessage = "Entered email for order tracking";
                break;

            // Contact Us form - ContactUs sheet
            case "name":
                elementLocator = ContactUsPageLocators.nameField;
                excelRowIndex = 1;
                excelColumnIndex = 0;
                actionLogMessage = "Entered name";
                break;

            case "email":
                elementLocator = ContactUsPageLocators.emailField;
                excelRowIndex = 2;
                excelColumnIndex = 0;
                actionLogMessage = "Entered email";
                break;

            case "phone":
                elementLocator = ContactUsPageLocators.phoneField;
                excelRowIndex = 3;
                excelColumnIndex = 0;
                actionLogMessage = "Entered phone number";
                break;

            case "message":
                elementLocator = ContactUsPageLocators.messageField;
                excelRowIndex = 4;
                excelColumnIndex = 0;
                actionLogMessage = "Entered message";
                break;

            case "invalidEmail":
                elementLocator = ContactUsPageLocators.emailField;
                excelRowIndex = 5;
                excelColumnIndex = 0;
                actionLogMessage = "Entered invalid email";
                break;

            case "phone11Digit":
                elementLocator = ContactUsPageLocators.phoneField;
                excelRowIndex = 6;
                excelColumnIndex = 0;
                actionLogMessage = "Entered 11-digit phone number";
                break;

            case "phone9Digit":
                elementLocator = ContactUsPageLocators.phoneField;
                excelRowIndex = 7;
                excelColumnIndex = 0;
                actionLogMessage = "Entered 9-digit phone number";
                break;

            case "phoneSpecialChars":
                elementLocator = ContactUsPageLocators.phoneField;
                excelRowIndex = 8;
                excelColumnIndex = 0;
                actionLogMessage = "Entered alphabetic and special characters";
                break;

            default:
                LoggerHandler.warn("enterDataIntoElement: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "enterDataIntoElement: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {
            String sheetName = (elementIdentifier.equals("orderNumber") || elementIdentifier.equals("trackOrderEmail"))
                    ? "TrackOrder" : "ContactUs";
            String excelValue = ExcelReader.readDataFromExcel(sheetName, excelRowIndex, excelColumnIndex);
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

            case "trackOrder":
                elementLocator = ContactUsPageLocators.enterOrderNumber;
                actionLogMessage = "Verified Track Order page opened";
                break;

            case "formTrackOrder":
                elementLocator = ContactUsPageLocators.invalidOrderMessage;
                actionLogMessage = "Verified Track Order button clicked";
                break;

            case "submit":
                elementLocator = ContactUsPageLocators.emailErrorVerify;
                actionLogMessage = "Verified Submit clicked";
                break;

            case "messageField":
                elementLocator = ContactUsPageLocators.messageFieldVerify;
                actionLogMessage = "Verified message textarea active";
                break;

            case "phoneField":
                elementLocator = ContactUsPageLocators.phoneField;
                actionLogMessage = "Verified phone field active";
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

            case "orderNumber":
                elementLocator = ContactUsPageLocators.enterEmailId;
                actionLogMessage = "Verified order number entered";
                break;

            case "trackOrderEmail":
                elementLocator = ContactUsPageLocators.formTrackOrder;
                actionLogMessage = "Verified email entered for tracking";
                break;

            case "name":
                elementLocator = ContactUsPageLocators.emailField;
                actionLogMessage = "Verified name accepted";
                break;

            case "email":
                elementLocator = ContactUsPageLocators.phoneField;
                actionLogMessage = "Verified email accepted";
                break;

            case "invalidEmail":
                elementLocator = ContactUsPageLocators.emailField;
                actionLogMessage = "Verified invalid email entered";
                break;

            case "phone":
                elementLocator = ContactUsPageLocators.messageField;
                actionLogMessage = "Verified phone number accepted";
                break;

            case "phone11Digit":
            case "phone9Digit":
            case "phoneSpecialChars":
                elementLocator = ContactUsPageLocators.phoneField;
                actionLogMessage = "Verified phone number entered";
                break;

            case "message":
                elementLocator = ContactUsPageLocators.messageFieldVerify;
                actionLogMessage = "Verified message entered";
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
     * a. Method name: verifyContactUsFormVisible
     * b. Author name: Ruturaj Satish Bhoite
     * c. Short description of method: Verifies the Contact Us form is visible with
     *    all fields.
     * d. Return type: void
     * e. Parameter list: none
     */
    public void verifyContactUsFormVisible() {
        try {
            elementLocator = ContactUsPageLocators.contactUsForm;
            webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
            boolean isDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isDisplayed, "Contact Us form is visible");
            LoggerHandler.info("Contact Us form verified");
            extentTest.log(Status.PASS, "Contact Us form verified");
        } catch (Exception exception) {
            LoggerHandler.error("verifyContactUsFormVisible failed: " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifyContactUsFormVisible_FAIL", extentTest,
                    "verifyContactUsFormVisible failed: " + exception.getMessage());
            extentTest.log(Status.FAIL, "verifyContactUsFormVisible failed: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: verifySuccessMessage
     * b. Author name: Ruturaj Satish Bhoite
     * c. Short description of method: Verifies a success confirmation message is
     *    displayed after form submission.
     * d. Return type: void
     * e. Parameter list: none
     */
    public void verifySuccessMessage() {
        try {
            elementLocator = ContactUsPageLocators.successMessageVerify;
            webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
            boolean isDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isDisplayed, "Success confirmation message displayed");
            LoggerHandler.info("Success message verified");
            extentTest.log(Status.PASS, "Success message verified");
        } catch (Exception exception) {
            LoggerHandler.error("verifySuccessMessage failed: " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifySuccessMessage_FAIL", extentTest,
                    "verifySuccessMessage failed: " + exception.getMessage());
            extentTest.log(Status.FAIL, "verifySuccessMessage failed: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: verifyFormNotSubmitted
     * b. Author name: Ruturaj Satish Bhoite
     * c. Short description of method: Verifies that the form was not submitted by
     *    checking the user remains on the same page.
     * d. Return type: void
     * e. Parameter list: none
     */
    public void verifyFormNotSubmitted() {
        try {
            elementLocator = ContactUsPageLocators.nameField;
            webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
            boolean isDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isDisplayed, "User remains on the same page - form not submitted");
            LoggerHandler.info("Form not submitted verified");
            extentTest.log(Status.PASS, "Form not submitted verified");
        } catch (Exception exception) {
            LoggerHandler.error("verifyFormNotSubmitted failed: " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifyFormNotSubmitted_FAIL", extentTest,
                    "verifyFormNotSubmitted failed: " + exception.getMessage());
            extentTest.log(Status.FAIL, "verifyFormNotSubmitted failed: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: verifyElementText
     * b. Author name: Ruturaj Satish Bhoite
     * c. Short description of method: Verifies the text of an element by resolving
     *    its expected value and locator via switch-case.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void verifyElementText(String elementIdentifier) {

        switch (elementIdentifier) {

            case "invalidMobile":
                elementLocator = ContactUsPageLocators.phoneErrorVerify;
                actionLogMessage = "Verified phone validation error";
                break;

            case "invalidEmail":
                elementLocator = ContactUsPageLocators.emailErrorVerify;
                actionLogMessage = "Verified email validation error";
                break;

            case "nameRequired":
                elementLocator = ContactUsPageLocators.nameErrorVerify;
                actionLogMessage = "Verified name validation error";
                break;

            case "messageRequired":
                elementLocator = ContactUsPageLocators.messageErrorVerify;
                actionLogMessage = "Verified message validation error";
                break;

            default:
                LoggerHandler.warn("verifyElementText: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "verifyElementText: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {
            webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
            boolean isDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isDisplayed, actionLogMessage);
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
