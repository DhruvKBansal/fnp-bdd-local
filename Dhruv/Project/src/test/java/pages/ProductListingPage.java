package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.ProductListingLocators;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

public class ProductListingPage {

    WebDriver webDriver;
    WebDriverHelper webDriverHelper;
    ExtentTest extentTest;

    By elementLocator;
    String actionLogMessage;
    Status logStatus;
    boolean isElementDisplayed;
    boolean isNewWindowOpened;

    public ProductListingPage(WebDriver webDriver, ExtentTest extentTest) {
        this.webDriver = webDriver;
        this.webDriverHelper = new WebDriverHelper(webDriver);
        this.extentTest = extentTest;
    }

    /**
     * a. Method name: verifyPageIsLoaded
     * b. Author name: Dhruv Kumar Bansal
     * c. Short description: Verifies that the Product Listing Page is loaded
     *    by asserting visibility of the page heading element.
     * d. Return type: void
     * e. Parameter list: none
     */
    public void verifyPageIsLoaded() {
        try {
            elementLocator = ProductListingLocators.pageHeading;
            webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
            isElementDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isElementDisplayed, "Product listing page loaded");
            LoggerHandler.info("Product listing page loaded");
            extentTest.log(Status.PASS, "Product listing page loaded");
        } catch (Exception exception) {
            LoggerHandler.error("verifyPageIsLoaded failed: " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifyPageIsLoaded_FAIL", extentTest,
                    "verifyPageIsLoaded failed: " + exception.getMessage());
            extentTest.log(Status.FAIL, "verifyPageIsLoaded failed: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: clickOnElement
     * b. Author name: Dhruv Kumar Bansal
     * c. Short description: Clicks on the specified element by resolving its
     *    locator, log message, and log level via switch-case.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void clickOnElement(String elementIdentifier) {

        switch (elementIdentifier) {

            case "firstProduct":
                elementLocator = ProductListingLocators.firstProduct;
                actionLogMessage = "Clicked on first product in listing";
                logStatus = Status.PASS;
                break;

            case "secondProduct":
                elementLocator = ProductListingLocators.secondProduct;
                actionLogMessage = "Clicked on second product in listing";
                logStatus = Status.PASS;
                break;

            case "sortBy":
                elementLocator = ProductListingLocators.sortBy;
                actionLogMessage = "Clicked Sort By button";
                logStatus = Status.PASS;
                break;

            case "sortNew":
                elementLocator = ProductListingLocators.sortNew;
                actionLogMessage = "Selected New Arrivals sort option";
                logStatus = Status.PASS;
                break;

            case "sortPriceLowToHigh":
                elementLocator = ProductListingLocators.sortPriceLowToHigh;
                actionLogMessage = "Selected Price: Low to High sort option";
                logStatus = Status.PASS;
                break;

            case "deliveryTypeFilter":
                elementLocator = ProductListingLocators.deliveryTypeFilter;
                actionLogMessage = "Expanded Delivery Type filter";
                logStatus = Status.PASS;
                break;

            case "nextDayDelivery":
                elementLocator = ProductListingLocators.nextDayDelivery;
                actionLogMessage = "Selected Same Day Delivery filter";
                logStatus = Status.PASS;
                break;

            case "priceFilter":
                elementLocator = ProductListingLocators.priceFilter;
                actionLogMessage = "Expanded Price filter";
                logStatus = Status.PASS;
                break;

            case "categoryFilter":
                elementLocator = ProductListingLocators.categoryFilter;
                actionLogMessage = "Expanded Category filter";
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
     * a. Method name: switchToWindowAtIndex
     * b. Author name: Dhruv Kumar Bansal
     * c. Short description: Switches to the browser window at the given index.
     * d. Return type: void
     * e. Parameter list: int windowIndex
     */
    public void switchToWindowAtIndex(int windowIndex) {
        webDriverHelper.switchToWindowAtIndex(windowIndex);
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

    /**
     * a. Method name: verifyElementAfterClick
     * b. Author name: Dhruv Kumar Bansal
     * c. Short description: Verifies the outcome of a click action.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void verifyElementAfterClick(String elementIdentifier) {

        boolean shouldCheckNewWindow = false;

        switch (elementIdentifier) {

            case "firstProduct":
            case "secondProduct":
                elementLocator = ProductListingLocators.firstProduct;
                actionLogMessage = "Verified product clicked";
                shouldCheckNewWindow = true;
                break;

            case "sortBy":
                elementLocator = ProductListingLocators.sortNew;
                actionLogMessage = "Verified Sort By dropdown opened";
                break;

            case "deliveryTypeFilter":
                elementLocator = ProductListingLocators.nextDayDelivery;
                actionLogMessage = "Verified Delivery Type filter expanded";
                break;

            default:
                LoggerHandler.warn("verifyElementAfterClick: no verification mapped for [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "verifyElementAfterClick: no verification mapped for [" + elementIdentifier + "]");
                return;
        }

        try {
            if (shouldCheckNewWindow) {
                isNewWindowOpened = webDriverHelper.getWindowCount() > 1;
                webDriverHelper.verifyTrue(isNewWindowOpened, "Expected a new tab to open");
                LoggerHandler.info("Verified a new tab opened after " + elementIdentifier);
                extentTest.log(Status.PASS, "Verified a new tab opened after " + elementIdentifier);
            } else {
                webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
                isElementDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
                webDriverHelper.verifyTrue(isElementDisplayed, actionLogMessage);
                LoggerHandler.info(actionLogMessage);
                extentTest.log(Status.PASS, actionLogMessage);
            }
        } catch (Exception exception) {
            LoggerHandler.error("verifyElementAfterClick failed for [" + elementIdentifier + "]: " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifyElementAfterClick_" + elementIdentifier + "_FAIL", extentTest,
                    "verifyElementAfterClick failed for [" + elementIdentifier + "]: " + exception.getMessage());
            extentTest.log(Status.FAIL, "verifyElementAfterClick failed for [" + elementIdentifier + "]: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: verifyKeywordInPageSource
     * b. Author name: Dhruv Kumar Bansal
     * c. Short description: Verifies a keyword is present in the page source.
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
}
