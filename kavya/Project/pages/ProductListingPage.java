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

    public ProductListingPage(WebDriver webDriver, ExtentTest extentTest) {
        this.webDriver = webDriver;
        this.webDriverHelper = new WebDriverHelper(webDriver);
        this.extentTest = extentTest;
    }

    private void logFailure(String step, Exception exception) {
        LoggerHandler.error(step + " failed: " + exception.getMessage());
        Reporter.attachScreenshotToReport(step + "_FAIL", extentTest,
                step + " failed: " + exception.getMessage());
        extentTest.log(Status.FAIL, step + " failed: " + exception.getMessage());
    }

    public void verifyPageIsLoaded() {
        try {
            elementLocator = ProductListingLocators.pageHeading;
            webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
            boolean isDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isDisplayed, "Product listing page loaded");
            LoggerHandler.info("Product listing page loaded");
            extentTest.log(Status.PASS, "Product listing page loaded");
        } catch (Exception exception) {
            logFailure("verifyPageIsLoaded", exception);
        }
    }

    By elementLocator;

    public void verifyNoRelevantResultsDisplayed() {
        try {
            boolean hasNoResultsMessage = webDriver.findElements(ProductListingLocators.noResultsMessage).size() > 0;
            boolean hasRelevantContent = webDriverHelper.isElementDisplayed(ProductListingLocators.firstProduct);
            boolean noRelevant = hasNoResultsMessage || !hasRelevantContent;
            webDriverHelper.verifyTrue(noRelevant, "No relevant search results displayed for invalid product");
            LoggerHandler.info("No relevant search results displayed");
            extentTest.log(Status.PASS, "No relevant search results displayed for invalid product name");
        } catch (Exception exception) {
            logFailure("verifyNoRelevantResultsDisplayed", exception);
        }
    }

    public void captureScreenshotAndLog(String filename) {
        try {
            Screenshot.captureScreenshot(webDriver, filename);
            LoggerHandler.info("Screenshot captured: " + filename);
            extentTest.log(Status.PASS, "Screenshot captured: " + filename);
        } catch (Exception exception) {
            LoggerHandler.error("Screenshot capture failed for [" + filename + "]: " + exception.getMessage());
            extentTest.log(Status.FAIL, "Screenshot capture failed for [" + filename + "]: " + exception.getMessage());
        }
    }
}
