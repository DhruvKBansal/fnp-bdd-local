package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.CorporatePageLocators;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

public class CorporatePage {

    WebDriver webDriver;
    WebDriverHelper webDriverHelper;
    ExtentTest extentTest;

    By elementLocator;
    String actionLogMessage;
    Status logStatus;
    boolean isElementDisplayed;

    public CorporatePage(WebDriver webDriver, ExtentTest extentTest) {
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

            case "callbackContactPerson":
                elementLocator = CorporatePageLocators.callbackContactPerson;
                actionLogMessage = "Clicked Contact Person input field (callback)";
                logStatus = Status.PASS;
                break;
            case "callbackContactNumber":
                elementLocator = CorporatePageLocators.callbackContactNumber;
                actionLogMessage = "Clicked Contact Number input field (callback)";
                logStatus = Status.PASS;
                break;
            case "callbackContactEmail":
                elementLocator = CorporatePageLocators.callbackContactEmail;
                actionLogMessage = "Clicked Contact Email input field (callback)";
                logStatus = Status.PASS;
                break;
            case "callbackQuantity":
                elementLocator = CorporatePageLocators.callbackQuantity;
                actionLogMessage = "Clicked Quantity input field (callback)";
                logStatus = Status.PASS;
                break;
            case "callbackCompanyName":
                elementLocator = CorporatePageLocators.callbackCompanyName;
                actionLogMessage = "Clicked Company Name input field (callback)";
                logStatus = Status.PASS;
                break;
            case "callbackSubmit":
                elementLocator = CorporatePageLocators.callbackSubmit;
                actionLogMessage = "Clicked Submit button (callback)";
                logStatus = Status.PASS;
                break;

            case "giftingFullName":
                elementLocator = CorporatePageLocators.giftingFullName;
                actionLogMessage = "Clicked Full Name input field (gifting)";
                logStatus = Status.PASS;
                break;
            case "giftingCompanyName":
                elementLocator = CorporatePageLocators.giftingCompanyName;
                actionLogMessage = "Clicked Company Name input field (gifting)";
                logStatus = Status.PASS;
                break;
            case "giftingMobileNo":
                elementLocator = CorporatePageLocators.giftingMobileNo;
                actionLogMessage = "Clicked Mobile Number input field (gifting)";
                logStatus = Status.PASS;
                break;
            case "giftingEmail":
                elementLocator = CorporatePageLocators.giftingEmail;
                actionLogMessage = "Clicked Email input field (gifting)";
                logStatus = Status.PASS;
                break;
            case "giftingNeed":
                elementLocator = CorporatePageLocators.giftingNeed;
                actionLogMessage = "Clicked Gifting Need input field (gifting)";
                logStatus = Status.PASS;
                break;
            case "giftingState":
                elementLocator = CorporatePageLocators.giftingState;
                actionLogMessage = "Clicked State dropdown (gifting)";
                logStatus = Status.PASS;
                break;
            case "giftingBudget":
                elementLocator = CorporatePageLocators.giftingBudget;
                actionLogMessage = "Clicked Budget dropdown (gifting)";
                logStatus = Status.PASS;
                break;
            case "giftingSubmit":
                elementLocator = CorporatePageLocators.giftingSubmit;
                actionLogMessage = "Clicked Submit button (gifting)";
                logStatus = Status.PASS;
                break;

            case "downloadContactPerson":
                elementLocator = CorporatePageLocators.downloadContactPerson;
                actionLogMessage = "Clicked Contact Person input field (download)";
                logStatus = Status.PASS;
                break;
            case "downloadContactNumber":
                elementLocator = CorporatePageLocators.downloadContactNumber;
                actionLogMessage = "Clicked Contact Number input field (download)";
                logStatus = Status.PASS;
                break;
            case "downloadContactEmail":
                elementLocator = CorporatePageLocators.downloadContactEmail;
                actionLogMessage = "Clicked Contact Email input field (download)";
                logStatus = Status.PASS;
                break;
            case "downloadOccasion":
                elementLocator = CorporatePageLocators.downloadOccasion;
                actionLogMessage = "Clicked Occasion dropdown (download)";
                logStatus = Status.PASS;
                break;
            case "downloadQuantity":
                elementLocator = CorporatePageLocators.downloadQuantity;
                actionLogMessage = "Clicked Quantity input field (download)";
                logStatus = Status.PASS;
                break;
            case "downloadCompanyName":
                elementLocator = CorporatePageLocators.downloadCompanyName;
                actionLogMessage = "Clicked Company Name input field (download)";
                logStatus = Status.PASS;
                break;
            case "downloadSubmit":
                elementLocator = CorporatePageLocators.downloadSubmit;
                actionLogMessage = "Clicked Download Now button (download)";
                logStatus = Status.PASS;
                break;

            // ===== Shared / Common =====
            case "crossIcon":
                elementLocator = CorporatePageLocators.crossIcon;
                actionLogMessage = "Clicked cross icon to close popup";
                logStatus = Status.PASS;
                break;
            case "downloadCatalogue":
                elementLocator = CorporatePageLocators.downloadCatalogueButton;
                actionLogMessage = "Clicked Download Catalogue button";
                logStatus = Status.PASS;
                break;
            case "requestACallBack":
                elementLocator = CorporatePageLocators.requestACallBackButton;
                actionLogMessage = "Clicked Request a call back button";
                logStatus = Status.PASS;
                break;

            default:
                LoggerHandler.warn("clickOnElement: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "clickOnElement: unknown element [" + elementIdentifier + "]");
                return;
        }

try {
            webDriverHelper.waitForElementToBeVisible(elementLocator, 20);
            webDriverHelper.scrollToElement(elementLocator);
            webDriverHelper.hoverOverElement(elementLocator);
            webDriverHelper.waitForElementToBeClickable(elementLocator, 20);
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

            //Callback form
            case "callbackContactPerson":
                elementLocator = CorporatePageLocators.callbackContactPerson;
                actionLogMessage = "Entered valid contact person name (callback)";
                break;
            case "callbackContactNumber":
                elementLocator = CorporatePageLocators.callbackContactNumber;
                actionLogMessage = "Entered valid contact number (callback)";
                break;
            case "callbackContactEmail":
                elementLocator = CorporatePageLocators.callbackContactEmail;
                actionLogMessage = "Entered valid email address (callback)";
                break;
            case "callbackQuantity":
                elementLocator = CorporatePageLocators.callbackQuantity;
                actionLogMessage = "Entered valid quantity (callback)";
                break;
            case "callbackCompanyName":
                elementLocator = CorporatePageLocators.callbackCompanyName;
                actionLogMessage = "Entered valid company name (callback)";
                break;

            //Gift form
            case "giftingFullName":
                elementLocator = CorporatePageLocators.giftingFullName;
                actionLogMessage = "Entered valid full name (gifting)";
                break;
            case "giftingCompanyName":
                elementLocator = CorporatePageLocators.giftingCompanyName;
                actionLogMessage = "Entered valid company name (gifting)";
                break;
            case "giftingMobileNo":
                elementLocator = CorporatePageLocators.giftingMobileNo;
                actionLogMessage = "Entered valid mobile number (gifting)";
                break;
            case "giftingEmail":
                elementLocator = CorporatePageLocators.giftingEmail;
                actionLogMessage = "Entered valid email address (gifting)";
                break;
            case "giftingNeed":
                elementLocator = CorporatePageLocators.giftingNeed;
                actionLogMessage = "Entered gifting requirement (gifting)";
                break;

            //Download catalog 
            case "downloadContactPerson":
                elementLocator = CorporatePageLocators.downloadContactPerson;
                actionLogMessage = "Entered valid contact person name (download)";
                break;
            case "downloadContactNumber":
                elementLocator = CorporatePageLocators.downloadContactNumber;
                actionLogMessage = "Entered valid contact number (download)";
                break;
            case "downloadContactEmail":
                elementLocator = CorporatePageLocators.downloadContactEmail;
                actionLogMessage = "Entered valid email address (download)";
                break;
            case "downloadQuantity":
                elementLocator = CorporatePageLocators.downloadQuantity;
                actionLogMessage = "Entered valid quantity (download)";
                break;
            case "downloadCompanyName":
                elementLocator = CorporatePageLocators.downloadCompanyName;
                actionLogMessage = "Entered valid company name (download)";
                break;

            default:
                LoggerHandler.warn("enterDataIntoElement: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "enterDataIntoElement: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {
            webDriverHelper.waitForElementToBeVisible(elementLocator, 20);
            webDriverHelper.sendKeysToElement(elementLocator, getTestData(elementIdentifier));
            LoggerHandler.info(actionLogMessage);
            extentTest.log(Status.PASS, actionLogMessage);
        } catch (Exception exception) {
            LoggerHandler.error("enterDataIntoElement failed for [" + elementIdentifier + "]: " + exception.getMessage());
            Reporter.attachScreenshotToReport("enterDataIntoElement_" + elementIdentifier + "_FAIL", extentTest,
                    "enterDataIntoElement failed for [" + elementIdentifier + "]: " + exception.getMessage());
            extentTest.log(Status.FAIL, "enterDataIntoElement failed for [" + elementIdentifier + "]: " + exception.getMessage());
        }
    }

    //Method to provide data
    private String getTestData(String elementIdentifier) throws IOException {

        switch (elementIdentifier) {
            case "downloadContactPerson":
                return ExcelReader.readDataFromExcel("TestData", 1, 0);

            case "downloadContactNumber":
                return ExcelReader.readDataFromExcel("TestData", 1, 1);

            case "downloadContactEmail":
                return ExcelReader.readDataFromExcel("TestData", 1, 2);

            case "downloadQuantity":
                return ExcelReader.readDataFromExcel("TestData", 1, 3);

            case "downloadCompanyName":
                return ExcelReader.readDataFromExcel("TestData", 1, 4);

            case "giftingFullName":
                return ExcelReader.readDataFromExcel("TestData", 2, 0);

            case "giftingCompanyName":
                return ExcelReader.readDataFromExcel("TestData", 2, 1);

            case "giftingMobileNo":
                return ExcelReader.readDataFromExcel("TestData", 2, 2);

            case "giftingEmail":
                return ExcelReader.readDataFromExcel("TestData", 2, 3);

            case "giftingNeed":
                return ExcelReader.readDataFromExcel("TestData", 2, 4);

            case "callbackContactPerson":
                return ExcelReader.readDataFromExcel("TestData", 3, 0);

            case "callbackContactNumber":
                return ExcelReader.readDataFromExcel("TestData", 3, 1);

            case "callbackContactEmail":
                return ExcelReader.readDataFromExcel("TestData", 3, 2);

            case "callbackQuantity":
                return ExcelReader.readDataFromExcel("TestData", 3, 3);

            case "callbackCompanyName":
                return ExcelReader.readDataFromExcel("TestData", 3, 4);

            default:
                return "";
        }
    }

    /**
     * a. Method name: selectOptionFromDropdown
     * b. Short description: Selects an option from a dropdown.
     * c. Return type: void
     * d. Parameter list: String elementIdentifier
     */
    public void selectOptionFromDropdown(String elementIdentifier) {

        switch (elementIdentifier) {

            case "giftingState":
                elementLocator = CorporatePageLocators.giftingState;
                actionLogMessage = "Selected State from dropdown (gifting)";
                break;

            case "giftingBudget":
                elementLocator = CorporatePageLocators.giftingBudget;
                actionLogMessage = "Selected Budget from dropdown (gifting)";
                break;

            default:
                LoggerHandler.warn("selectOptionFromDropdown: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "selectOptionFromDropdown: unknown element [" + elementIdentifier + "]");
                return;
        }

try {
            webDriverHelper.waitForElementToBeVisible(elementLocator, 20);
            webDriverHelper.selectOptionFromDropdown(elementLocator, getDropdownOption(elementIdentifier));
            LoggerHandler.info(actionLogMessage);
            extentTest.log(Status.PASS, actionLogMessage);
        } catch (Exception exception) {
            LoggerHandler.error("selectOptionFromDropdown failed for [" + elementIdentifier + "]: " + exception.getMessage());
            Reporter.attachScreenshotToReport("selectOptionFromDropdown_" + elementIdentifier + "_FAIL", extentTest,
                    "selectOptionFromDropdown failed for [" + elementIdentifier + "]: " + exception.getMessage());
            extentTest.log(Status.FAIL, "selectOptionFromDropdown failed for [" + elementIdentifier + "]: " + exception.getMessage());
        }
    }

    //
    private String getDropdownOption(String elementIdentifier) {
        switch (elementIdentifier) {
            case "giftingState":
                return "KARNATAKA";
            case "giftingBudget":
                return "Under ₹1499";
            default:
                return "";
        }
    }

    /**
     * a. Method name: scrollToForm
     * b. Short description: Scrolls down to the Call Back form.
     * c. Return type: void
     * d. Parameter list: none
     */
    public void scrollToForm() {
        try {
            webDriverHelper.scrollDownToFooter();
            LoggerHandler.info("Scrolled down to the Call Back form");
            extentTest.log(Status.PASS, "Scrolled down to the Call Back form");
        } catch (Exception exception) {
            LoggerHandler.error("scrollToForm failed: " + exception.getMessage());
            Reporter.attachScreenshotToReport("scrollToForm_FAIL", extentTest,
                    "scrollToForm failed: " + exception.getMessage());
            extentTest.log(Status.FAIL, "scrollToForm failed: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: verifyPageIsLoaded
     * b. Short description: Verifies the Corporate page loads successfully.
     * c. Return type: void
     * d. Parameter list: none
     */
    public void verifyPageIsLoaded() {
        try {
            elementLocator = CorporatePageLocators.giftingFullName;
            webDriverHelper.waitForElementToBeVisible(elementLocator, 20);
            isElementDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isElementDisplayed, "Corporate page loaded successfully");
            LoggerHandler.info("Corporate page loaded successfully");
            extentTest.log(Status.PASS, "Corporate page loaded successfully");
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

            case "crossIcon":
                elementLocator = CorporatePageLocators.downloadCatalogueButton;
                actionLogMessage = "Verified popup closed";
                break;

            case "downloadCatalogue":
                elementLocator = CorporatePageLocators.downloadSubmit;
                actionLogMessage = "Verified Download Now button displayed";
                break;

            case "downloadSubmit":
                elementLocator = CorporatePageLocators.downloadError;
                actionLogMessage = "Verified Download Now clicked";
                break;

            case "callbackSubmit":
            case "giftingSubmit":
                elementLocator = CorporatePageLocators.thanksPage;
                actionLogMessage = "Verified Submit clicked";
                break;

            case "downloadContactPerson":
                elementLocator = CorporatePageLocators.downloadContactPerson;
                actionLogMessage = "Verified Contact Person field clicked (download)";
                break;

            case "downloadContactNumber":
                elementLocator = CorporatePageLocators.downloadContactNumber;
                actionLogMessage = "Verified Contact Number field clicked (download)";
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

            case "callbackContactPerson":
            case "callbackContactNumber":
            case "callbackContactEmail":
            case "callbackQuantity":
            case "callbackCompanyName":
            case "giftingFullName":
            case "giftingCompanyName":
            case "giftingMobileNo":
            case "giftingEmail":
            case "giftingNeed":
            case "downloadContactPerson":
            	elementLocator = resolveDataLocator(elementIdentifier);
                actionLogMessage = "Verified data entered in " + elementIdentifier;
                break;
            case "downloadContactNumber":
            	elementLocator = resolveDataLocator(elementIdentifier);
                actionLogMessage = "Verified data entered in " + elementIdentifier;
                break;
            case "downloadContactEmail":
            case "downloadQuantity":
            case "downloadCompanyName":
                elementLocator = resolveDataLocator(elementIdentifier);
                actionLogMessage = "Verified data entered in " + elementIdentifier;
                break;

            default:
                LoggerHandler.warn("verifyElementAfterDataEntry: no verification mapped for [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "verifyElementAfterDataEntry: no verification mapped for [" + elementIdentifier + "]");
                return;
        }

        try {
//            webDriverHelper.waitForElementToBeVisible(elementLocator, 20);
//            isElementDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
//            webDriverHelper.verifyTrue(isElementDisplayed, actionLogMessage);
//            LoggerHandler.info(actionLogMessage);
//            extentTest.log(Status.PASS, actionLogMessage);
            webDriverHelper.waitForElementToBeVisible(elementLocator, 20);
        	String value = webDriver.findElement(elementLocator).getAttribute("value");
        	boolean hasText = value != null && !value.trim().isEmpty();
        	webDriverHelper.verifyTrue(hasText, actionLogMessage);
        	LoggerHandler.info(actionLogMessage);
        	extentTest.log(Status.PASS, actionLogMessage);
        } catch (Exception exception) {
            LoggerHandler.error("verifyElementAfterDataEntry failed for [" + elementIdentifier + "]: " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifyElementAfterDataEntry_" + elementIdentifier + "_FAIL", extentTest,
                    "verifyElementAfterDataEntry failed for [" + elementIdentifier + "]: " + exception.getMessage());
            extentTest.log(Status.FAIL, "verifyElementAfterDataEntry failed for [" + elementIdentifier + "]: " + exception.getMessage());
        }
    }

    private By resolveDataLocator(String elementIdentifier) {
        switch (elementIdentifier) {
            case "callbackContactPerson":
            case "downloadContactPerson":
                return CorporatePageLocators.callbackContactPerson;
            case "callbackContactNumber":
            case "downloadContactNumber":
                return CorporatePageLocators.callbackContactNumber;
            case "callbackContactEmail":
            case "downloadContactEmail":
                return CorporatePageLocators.callbackContactEmail;
            case "callbackQuantity":
            case "downloadQuantity":
                return CorporatePageLocators.callbackQuantity;
            case "callbackCompanyName":
            case "downloadCompanyName":
                return CorporatePageLocators.callbackCompanyName;

            case "giftingFullName":
                return CorporatePageLocators.giftingFullName;
            case "giftingCompanyName":
                return CorporatePageLocators.giftingCompanyName;
            case "giftingMobileNo":
                return CorporatePageLocators.giftingMobileNo;
            case "giftingEmail":
                return CorporatePageLocators.giftingEmail;
            case "giftingNeed":
                return CorporatePageLocators.giftingNeed;

            default:
                return CorporatePageLocators.callbackContactPerson;
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
     * a. Method name: verifyInvalidSubmitMessage
     * b. Short description: Verifies a validation message is displayed after submit.
     * c. Return type: void
     * d. Parameter list: String keywordToVerify
     */
    public void verifyInvalidSubmitMessage(String keywordToVerify) {
        try {
            boolean keywordPresent = webDriver.getPageSource().contains(keywordToVerify);
            webDriverHelper.verifyTrue(keywordPresent, "validation message");
            LoggerHandler.info("Verified validation message: " + keywordToVerify);
            extentTest.log(Status.PASS, "Verified validation message: " + keywordToVerify);
        } catch (Exception exception) {
            LoggerHandler.error("Validation message verification failed [" + keywordToVerify + "] : " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifyInvalidSubmitMessage_FAIL", extentTest,
                    "Validation message verification failed [" + keywordToVerify + "] : " + exception.getMessage());
            extentTest.log(Status.FAIL, "Validation message verification failed [" + keywordToVerify + "] : " + exception.getMessage());
        }
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
    
    public void manualScroll() {
    	webDriverHelper.scrollUpToHeader();
    }
    
    public void requestACallBackTrigger() {
    	webDriverHelper.hoverOverElement(CorporatePageLocators.giftingFullName);
    	webDriverHelper.clickOnElement(CorporatePageLocators.giftingFullName);
    	webDriverHelper.scrollUpToHeader();
    	webDriverHelper.hoverOverElement(CorporatePageLocators.giftingFullName);

    }
}

