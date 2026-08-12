package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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
     * b. Short description: Verifies the Product Listing Page is loaded.
     * c. Return type: void
     * d. Parameter list: none
     */
    public void verifyPageIsLoaded() {
        try {
            elementLocator = ProductListingLocators.pageHeading;
            webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
            Assert.assertTrue(webDriver.findElement(elementLocator).isDisplayed(),
                    "Page heading not displayed - page did not load");
            LoggerHandler.info("Page loaded successfully");
            extentTest.log(Status.PASS, "Page loaded successfully");
        } catch (Exception exception) {
            LoggerHandler.error("verifyPageIsLoaded failed: " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifyPageIsLoaded_FAIL", extentTest,
                    "verifyPageIsLoaded failed: " + exception.getMessage());
            extentTest.log(Status.FAIL, "verifyPageIsLoaded failed: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: clickOnElement
     * b. Short description: Clicks on the specified element by resolving its locator.
     * c. Return type: void
     * d. Parameter list: String elementIdentifier
     */
    public void clickOnElement(String elementIdentifier) {

        switch (elementIdentifier) {

            case "firstProduct":
                elementLocator = ProductListingLocators.firstProduct;
                actionLogMessage = "Clicked on first product in search results";
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
     * a. Method name: verifyElementAfterClick
     * b. Short description: Verifies search results are displayed / new window opens for product click.
     * c. Return type: void
     * d. Parameter list: String elementIdentifier
     */
    public void verifyElementAfterClick(String elementIdentifier) {

        boolean shouldCheckNewWindow = false;

        switch (elementIdentifier) {

            case "firstProduct":
                elementLocator = ProductListingLocators.firstProduct;
                actionLogMessage = "Verified first product clicked";
                shouldCheckNewWindow = true;
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
     * a. Method name: verifyProductsAreVisible
     * b. Short description: Verifies products are visible in the search results.
     * c. Return type: void
     * d. Parameter list: none
     */
    public void verifyProductsAreVisible() {
        try {
            elementLocator = ProductListingLocators.firstProduct;
            webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
            isElementDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isElementDisplayed, "Products are visible in search results");
            LoggerHandler.info("Products are visible in search results");
            extentTest.log(Status.PASS, "Products are visible in search results");
        } catch (Exception exception) {
            LoggerHandler.error("verifyProductsAreVisible failed: " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifyProductsAreVisible_FAIL", extentTest,
                    "verifyProductsAreVisible failed: " + exception.getMessage());
            extentTest.log(Status.FAIL, "verifyProductsAreVisible failed: " + exception.getMessage());
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
