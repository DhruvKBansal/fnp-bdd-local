package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.HomePageLocator;
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
    String expectedTextValue;
    String actualTextValue;
    int excelRowIndex;
    int excelColumnIndex;
    boolean isBlankField;

    public HomePage(WebDriver webDriver, ExtentTest extentTest) {
        this.webDriver = webDriver;
        this.webDriverHelper = new WebDriverHelper(webDriver);
        this.extentTest = extentTest;
    }

    /**
     * a. Method name: clickOnElement
     * b. Author name: Suraj Reddy
     * c. Short description of method: Clicks on the specified element by resolving
     *    its locator, log message and status using switch-case. Common wait, click
     *    and log actions are executed once after the switch. Captures screenshot
     *    on failure.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void clickOnElement(String elementIdentifier) {

        switch (elementIdentifier) {

            case "popup":
                elementLocator = HomePageLocator.popUpAllow;
                actionLogMessage = "Clicked Allow on the popup";
                logStatus = Status.PASS;
                break;

            case "hiGuest":
                elementLocator = HomePageLocator.hiGuest;
                actionLogMessage = "Clicked Hi Guest";
                logStatus = Status.PASS;
                break;

            case "loginReg":
                elementLocator = HomePageLocator.loginReg;
                actionLogMessage = "Clicked Login/Register";
                logStatus = Status.PASS;
                break;

            case "email":
                elementLocator = HomePageLocator.email;
                actionLogMessage = "Clicked Email field";
                logStatus = Status.PASS;
                break;

            case "clickContinue":
                elementLocator = HomePageLocator.clickContinue;
                actionLogMessage = "Clicked Continue";
                logStatus = Status.PASS;
                break;

            case "name":
                elementLocator = HomePageLocator.name;
                actionLogMessage = "Clicked Name field";
                logStatus = Status.PASS;
                break;

            case "countryDropDown":
                elementLocator = HomePageLocator.countryDropDown;
                actionLogMessage = "Clicked Country dropdown";
                logStatus = Status.PASS;
                break;

            case "indiaDropDown":
                elementLocator = HomePageLocator.indiaDropDown;
                actionLogMessage = "Selected India from Country dropdown";
                logStatus = Status.PASS;
                break;

            case "number":
                elementLocator = HomePageLocator.number;
                actionLogMessage = "Clicked Mobile Number field";
                logStatus = Status.PASS;
                break;

            case "startGifting":
                elementLocator = HomePageLocator.startGifting;
                actionLogMessage = "Clicked Start Gifting";
                logStatus = Status.PASS;
                break;

            case "outsideEmail":
                elementLocator = HomePageLocator.outsideEmail;
                actionLogMessage = "Clicked outside the Email field";
                logStatus = Status.PASS;
                break;

            case "otpField":
                elementLocator = HomePageLocator.otpField;
                actionLogMessage = "Clicked OTP field";
                logStatus = Status.PASS;
                break;

            case "verifyOtpButton":
                elementLocator = HomePageLocator.verifyOtpButton;
                actionLogMessage = "Clicked Verify/Submit OTP";
                logStatus = Status.PASS;
                break;

            default:
                LoggerHandler.warn("clickOnElement: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "clickOnElement: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {

            webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
            webDriverHelper.clickOnElement(elementLocator);

            LoggerHandler.info(actionLogMessage);
            extentTest.log(logStatus, actionLogMessage);

        } catch (Exception exception) {

            LoggerHandler.error("clickOnElement failed for [" + elementIdentifier + "]: " + exception.getMessage());

            Reporter.attachScreenshotToReport(
                    "clickOnElement_" + elementIdentifier + "_FAIL",
                    extentTest,
                    "clickOnElement failed for [" + elementIdentifier + "]: " + exception.getMessage());

            extentTest.log(Status.FAIL,
                    "clickOnElement failed for [" + elementIdentifier + "]: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: enterDataIntoElement
     * b. Author name: Suraj Reddy
     * c. Short description of method: Enters data into the specified field by
     *    resolving its locator, excel row/column and log message via switch-case.
     *    Data is read from the HomePage sheet of the excel file.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void enterDataIntoElement(String elementIdentifier) {

        switch (elementIdentifier) {

            case "validEmail":
                elementLocator = HomePageLocator.email;
                excelRowIndex = 0;
                excelColumnIndex = 0;
                actionLogMessage = "Entered valid Email address";
                break;

            case "validName":
                elementLocator = HomePageLocator.name;
                excelRowIndex = 0;
                excelColumnIndex = 1;
                actionLogMessage = "Entered valid Name";
                break;

            case "validNumber":
                elementLocator = HomePageLocator.number;
                excelRowIndex = 0;
                excelColumnIndex = 3;
                actionLogMessage = "Entered valid Mobile Number";
                break;

            case "invalidEmailNoDomain":
                elementLocator = HomePageLocator.email;
                excelRowIndex = 1;
                excelColumnIndex = 0;
                actionLogMessage = "Entered invalid Email (no domain)";
                break;

            case "invalidEmailOnlyAt":
                elementLocator = HomePageLocator.email;
                excelRowIndex = 2;
                excelColumnIndex = 0;
                actionLogMessage = "Entered invalid Email (only @)";
                break;

            case "invalidEmailNoExtension":
                elementLocator = HomePageLocator.email;
                excelRowIndex = 3;
                excelColumnIndex = 0;
                actionLogMessage = "Entered invalid Email (no extension)";
                break;

            case "blankEmail":
                elementLocator = HomePageLocator.email;
                isBlankField = true;
                actionLogMessage = "Attempted leaving Email field blank";
                break;

            case "specialName":
                elementLocator = HomePageLocator.name;
                excelRowIndex = 4;
                excelColumnIndex = 1;
                actionLogMessage = "Entered special characters in Name field";
                break;

            case "blankName":
                elementLocator = HomePageLocator.name;
                isBlankField = true;
                actionLogMessage = "Attempted leaving Name field blank";
                break;

            case "alphaNumber":
                elementLocator = HomePageLocator.number;
                excelRowIndex = 5;
                excelColumnIndex = 3;
                actionLogMessage = "Attempted entering alphabetic characters in Mobile field";
                break;

            case "blankNumber":
                elementLocator = HomePageLocator.number;
                isBlankField = true;
                actionLogMessage = "Attempted leaving Mobile Number field blank";
                break;

            case "incorrectOtp":
                elementLocator = HomePageLocator.otpField;
                excelRowIndex = 0;
                excelColumnIndex = 4;
                actionLogMessage = "Entered incorrect OTP";
                break;

            default:
                LoggerHandler.warn("enterDataIntoElement: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "enterDataIntoElement: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {

            webDriverHelper.waitForElementToBeVisible(elementLocator, 15);

            if (isBlankField) {
                webDriverHelper.clearElement(elementLocator);
            } else {
                String excelValue = ExcelReader.readData("HomePage", excelRowIndex, excelColumnIndex);
                webDriverHelper.sendKeysToElement(elementLocator, excelValue);
            }

            LoggerHandler.info(actionLogMessage);
            extentTest.log(Status.PASS, actionLogMessage);

            isBlankField = false;

        } catch (Exception exception) {

            LoggerHandler.error(
                    "enterDataIntoElement failed for [" + elementIdentifier + "]: " + exception.getMessage());

            Reporter.attachScreenshotToReport(
                    "enterDataIntoElement_" + elementIdentifier + "_FAIL",
                    extentTest,
                    "enterDataIntoElement failed for [" + elementIdentifier + "]: " + exception.getMessage());

            extentTest.log(Status.FAIL,
                    "enterDataIntoElement failed for [" + elementIdentifier + "]: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: verifyElementAfterClick
     * b. Author name: Suraj Reddy
     * c. Short description of method: Verifies the outcome of a click action by
     *    resolving the expected verification locator and log message via switch-case.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void verifyElementAfterClick(String elementIdentifier) {

        switch (elementIdentifier) {

            case "popup":
                elementLocator = HomePageLocator.hiGuest;
                actionLogMessage = "Verified homepage displayed after closing popup";
                break;

            case "hiGuest":
                elementLocator = HomePageLocator.loginReg;
                actionLogMessage = "Verified Login/Register option displayed";
                break;

            case "loginReg":
                elementLocator = HomePageLocator.email;
                actionLogMessage = "Verified Login/Register screen displayed";
                break;

            case "email":
                elementLocator = HomePageLocator.email;
                actionLogMessage = "Verified Email field is editable";
                break;

            case "clickContinue":
                elementLocator = HomePageLocator.name;
                actionLogMessage = "Verified registration form displayed after Continue";
                break;

            case "name":
                elementLocator = HomePageLocator.name;
                actionLogMessage = "Verified Name field is editable";
                break;

            case "countryDropDown":
                elementLocator = HomePageLocator.indiaDropDown;
                actionLogMessage = "Verified Country dropdown list displayed";
                break;

            case "indiaDropDown":
                elementLocator = HomePageLocator.locWrittenVerify;
                actionLogMessage = "Verified India selected as country";
                break;

            case "number":
                elementLocator = HomePageLocator.number;
                actionLogMessage = "Verified Mobile Number field is editable";
                break;

            case "startGifting":
                elementLocator = HomePageLocator.otpPageVerify;
                actionLogMessage = "Verified OTP verification page displayed";
                break;

            case "outsideEmail":
                elementLocator = HomePageLocator.email;
                actionLogMessage = "Verified clicked outside Email field";
                break;

            case "otpField":
                elementLocator = HomePageLocator.otpField;
                actionLogMessage = "Verified OTP field is editable";
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
     * b. Author name: Suraj Reddy
     * c. Short description of method: Verifies the outcome of entering data by
     *    checking the entered value is retained/displayed correctly.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void verifyElementAfterDataEntry(String elementIdentifier) {

        switch (elementIdentifier) {

            case "validEmail":
                elementLocator = HomePageLocator.emailWrittenVerify;
                expectedTextValue = "kavya.test3000@gmail.com";
                actionLogMessage = "Verified valid Email displayed correctly";
                break;

            case "validName":
                elementLocator = HomePageLocator.nameWrittenVerify;
                expectedTextValue = "Kavya";
                actionLogMessage = "Verified valid Name displayed correctly";
                break;

            case "validNumber":
                elementLocator = HomePageLocator.numberWrittenVerify;
                expectedTextValue ="6574839201";
                actionLogMessage = "Verified valid Mobile Number displayed correctly";
                break;

            case "specialName":
                elementLocator = HomePageLocator.name;
                expectedTextValue = "@#$%^";
                actionLogMessage = "Verified special characters accepted in Name field";
                break;

            case "alphaNumber":
                elementLocator = HomePageLocator.number;
                expectedTextValue = "";
                actionLogMessage = "Verified Mobile Number field rejects alphabetic input";
                break;

            default:
                LoggerHandler.warn("verifyElementAfterDataEntry: no verification mapped for [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "verifyElementAfterDataEntry: no verification mapped for [" + elementIdentifier + "]");
                return;
        }

        try {

            webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
            //boolean isDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            actualTextValue = webDriver.findElement(elementLocator).getAttribute("value");
            
            webDriverHelper.verifyEquals(actualTextValue, expectedTextValue);

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
     * a. Method name: verifyValidationMessage
     * b. Author name: Suraj Reddy
     * c. Short description of method: Verifies that a specific validation message
     *    is displayed for the given field/validation scenario.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void verifyValidationMessage(String elementIdentifier) {

        switch (elementIdentifier) {

            case "invalidEmail":
                elementLocator = HomePageLocator.emailInputVerify;
                expectedTextValue = "Please enter valid email ID";
                actionLogMessage = "Verified 'Please enter valid email ID' message displayed";
                break;

            case "blankName":
                elementLocator = HomePageLocator.nameInputVerify;
                expectedTextValue = "Please enter your name";
                actionLogMessage = "Verified 'Please enter your name' message displayed";
                break;
               
            case "alphaNumber":
            	expectedTextValue = "Please enter valid 10 digit mobile no.";
                elementLocator = HomePageLocator.numberInputVerify;
                actionLogMessage = "Verified 'Please enter valid 10 digit mobile no.' message displayed";
                break;

            case "incorrectOtp":
                elementLocator = HomePageLocator.incorrectOtpMessage;
                actionLogMessage = "Verified 'Incorrect entry. Please resend OTP' message displayed";
                break;

            default:
                LoggerHandler.warn("verifyValidationMessage: no verification mapped for [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "verifyValidationMessage: no verification mapped for [" + elementIdentifier + "]");
                return;
        }

        try {

            webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
            //boolean isDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            //webDriverHelper.verifyTrue(isDisplayed, actionLogMessage);
            actualTextValue = webDriverHelper.getTextFromElement(elementLocator);
            webDriverHelper.verifyEquals(actualTextValue, expectedTextValue);
            LoggerHandler.info(actionLogMessage);
            extentTest.log(Status.PASS, actionLogMessage);

        } catch (Exception exception) {

            LoggerHandler.error("verifyValidationMessage failed for [" + elementIdentifier + "]: " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifyValidationMessage_" + elementIdentifier + "_FAIL", extentTest,
                    "verifyValidationMessage failed for [" + elementIdentifier + "]: " + exception.getMessage());
            extentTest.log(Status.FAIL, "verifyValidationMessage failed for [" + elementIdentifier + "]: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: verifyKeywordInPageSource
     * b. Author name: Suraj Reddy
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
     * b. Author name: Suraj Reddy
     * c. Short description of method: Captures a screenshot using the Screenshot
     *    utility class method and logs the result.
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
