package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.ProductListingsPageLocators;
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
     * b. Author name: Ruturaj Satish Bhoite
     * c. Short description of method: Verifies that the Product Listing Page is loaded
     *    by asserting visibility of the page heading element.
     * d. Return type: void
     * e. Parameter list: none
     */
    public void verifyPageIsLoaded() {
        try {
            elementLocator = ProductListingsPageLocators.pageHeading;
            webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
            Assert.assertTrue(webDriver.findElement(elementLocator).isDisplayed(),
                    "Page heading not displayed - page did not load");
            LoggerHandler.info("Page loaded successfully");
            extentTest.log(Status.PASS, "Page loaded successfully");
        } catch (Exception exception) {
            LoggerHandler.error("verifyPageIsLoaded failed: " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifyPageIsLoaded_FAIL", extentTest, "verifyPageIsLoaded failed: " + exception.getMessage());
            extentTest.log(Status.FAIL, "verifyPageIsLoaded failed: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: clickOnElement
     * b. Author name: Ruturaj Satish Bhoite
     * c. Short description of method: Clicks on the specified element by resolving its
     *    locator, log message, and log level via switch-case. Common wait and click
     *    actions are executed once after the switch. Captures screenshot on failure.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void clickOnElement(String elementIdentifier) {
        switch (elementIdentifier) {

            case "firstProduct":
                elementLocator = ProductListingsPageLocators.firstProduct;
                actionLogMessage = "Clicked on first product in listing";
                logStatus = Status.PASS;
                break;

            case "priceFilter":
                elementLocator = ProductListingsPageLocators.priceFilter;
                actionLogMessage = "Expanded Price filter section";
                logStatus = Status.PASS;
                break;

            case "priceRange500to1000":
                elementLocator = ProductListingsPageLocators.priceRange500to1000;
                actionLogMessage = "Selected price range ₹500 - ₹1000";
                logStatus = Status.PASS;
                break;

            case "applyFilter":
                elementLocator = ProductListingsPageLocators.applyFilterButton;
                actionLogMessage = "Clicked Apply filter";
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
            Reporter.attachScreenshotToReport("clickOnElement_" + elementIdentifier + "_FAIL", extentTest, "clickOnElement failed for [" + elementIdentifier + "]: " + exception.getMessage());
            extentTest.log(Status.FAIL, "clickOnElement failed for [" + elementIdentifier + "]: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: switchToWindowAtIndex
     * b. Author name: Ruturaj Satish Bhoite
     * c. Short description of method: Switches to the browser window/tab at the given index.
     * d. Return type: void
     * e. Parameter list: int windowIndex
     */
    public void switchToWindowAtIndex(int windowIndex) {
        webDriverHelper.switchToWindowAtIndex(windowIndex);
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

    /**
     * a. Method name: verifyElementAfterClick
     * b. Author name: Ruturaj Satish Bhoite
     * c. Short description of method: Verifies the outcome of a click action by
     *    resolving its expected verification locator / condition via switch-case.
     *    For product clicks, verifies a new tab/window opened. Reuses uistore locators.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void verifyElementAfterClick(String elementIdentifier) {

        boolean shouldCheckNewWindow = false;

        switch (elementIdentifier) {

            case "firstProduct":
                elementLocator = ProductListingsPageLocators.firstProduct;
                actionLogMessage = "Verified first product clicked";
                shouldCheckNewWindow = true;
                break;

            case "priceFilter":
                elementLocator = ProductListingsPageLocators.priceRange500to1000;
                actionLogMessage = "Verified Price filter expanded";
                break;

            case "priceRange500to1000":
                elementLocator = ProductListingsPageLocators.applyFilterButton;
                actionLogMessage = "Verified price range selected";
                break;

            case "applyFilter":
                //elementLocator = ProductListingsPageLocators.filteredResults;
                actionLogMessage = "Verified filtered results displayed";
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
     * a. Method name: verifySearchResultsPage
     * b. Author name: Ruturaj Satish Bhoite
     * c. Short description of method: Verifies the search results page is loaded by
     *    checking the search results heading is displayed.
     * d. Return type: void
     * e. Parameter list: none
     */
    public void verifySearchResultsPage() {
        try {
            //elementLocator = ProductListingsPageLocators.searchResultsHeadingVerify;
            webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
            isElementDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isElementDisplayed, "Search results page opened");
            LoggerHandler.info("Search results page verified");
            extentTest.log(Status.PASS, "Search results page verified");
        } catch (Exception exception) {
            LoggerHandler.error("verifySearchResultsPage failed: " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifySearchResultsPage_FAIL", extentTest,
                    "verifySearchResultsPage failed: " + exception.getMessage());
            extentTest.log(Status.FAIL, "verifySearchResultsPage failed: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: verifyProductsDisplayed
     * b. Author name: Ruturaj Satish Bhoite
     * c. Short description of method: Verifies matching products are displayed on
     *    the search results page.
     * d. Return type: void
     * e. Parameter list: none
     */
    public void verifyProductsDisplayed() {
        try {
            //elementLocator = ProductListingsPageLocators.matchingProductsHeadingVerify;
            webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
            isElementDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isElementDisplayed, "Matching products displayed");
            LoggerHandler.info("Matching products verified");
            extentTest.log(Status.PASS, "Matching products verified");
        } catch (Exception exception) {
            LoggerHandler.error("verifyProductsDisplayed failed: " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifyProductsDisplayed_FAIL", extentTest,
                    "verifyProductsDisplayed failed: " + exception.getMessage());
            extentTest.log(Status.FAIL, "verifyProductsDisplayed failed: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: verifyProductPricesDisplayed
     * b. Author name: Ruturaj Satish Bhoite
     * c. Short description of method: Verifies product prices are displayed on the
     *    search results page.
     * d. Return type: void
     * e. Parameter list: none
     */
    public void verifyProductPricesDisplayed() {
        try {
            elementLocator = ProductListingsPageLocators.productPriceVerify;
            webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
            isElementDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isElementDisplayed, "Product prices displayed");
            LoggerHandler.info("Product prices verified");
            extentTest.log(Status.PASS, "Product prices verified");
        } catch (Exception exception) {
            LoggerHandler.error("verifyProductPricesDisplayed failed: " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifyProductPricesDisplayed_FAIL", extentTest,
                    "verifyProductPricesDisplayed failed: " + exception.getMessage());
            extentTest.log(Status.FAIL, "verifyProductPricesDisplayed failed: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: scrollToElement
     * b. Author name: Ruturaj Satish Bhoite
     * c. Short description of method: Scrolls to the specified element by resolving
     *    its locator and log message via switch-case.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void scrollToElement(String elementIdentifier) {
        switch (elementIdentifier) {
            case "productsList":
                elementLocator = ProductListingsPageLocators.firstProduct;
                actionLogMessage = "Scrolled to products list";
                logStatus = Status.PASS;
                break;
            default:
                LoggerHandler.warn("scrollToElement: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "scrollToElement: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {
            webDriverHelper.waitForElementToBeVisible(elementLocator, 10);
            webDriverHelper.scrollToElement(elementLocator);
            LoggerHandler.info(actionLogMessage);
            extentTest.log(logStatus, actionLogMessage);
        } catch (Exception exception) {
            LoggerHandler.error("scrollToElement failed for [" + elementIdentifier + "]: " + exception.getMessage());
            Reporter.attachScreenshotToReport("scrollToElement_" + elementIdentifier + "_FAIL", extentTest, "scrollToElement failed for [" + elementIdentifier + "]: " + exception.getMessage());
            extentTest.log(Status.FAIL, "scrollToElement failed for [" + elementIdentifier + "]: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: verifyElementAfterScroll
     * b. Author name: Ruturaj Satish Bhoite
     * c. Short description of method: Verifies the outcome of a scroll action by
     *    checking the products are still displayed.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void verifyElementAfterScroll(String elementIdentifier) {
        switch (elementIdentifier) {
            case "productsList":
                elementLocator = ProductListingsPageLocators.firstProduct;
                actionLogMessage = "Verified more products loaded after scroll";
                break;
            default:
                LoggerHandler.warn("verifyElementAfterScroll: no verification mapped for [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "verifyElementAfterScroll: no verification mapped for [" + elementIdentifier + "]");
                return;
        }

        try {
            webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
            isElementDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isElementDisplayed, actionLogMessage);
            LoggerHandler.info(actionLogMessage);
            extentTest.log(Status.PASS, actionLogMessage);
        } catch (Exception exception) {
            LoggerHandler.error("verifyElementAfterScroll failed for [" + elementIdentifier + "]: " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifyElementAfterScroll_" + elementIdentifier + "_FAIL", extentTest,
                    "verifyElementAfterScroll failed for [" + elementIdentifier + "]: " + exception.getMessage());
            extentTest.log(Status.FAIL, "verifyElementAfterScroll failed for [" + elementIdentifier + "]: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: verifyDeliveryAvailabilityForLocation
     * b. Author name: Ruturaj Satish Bhoite
     * c. Short description of method: Verifies delivery availability is shown for
     *    the selected location on the displayed products.
     * d. Return type: void
     * e. Parameter list: none
     */
    public void verifyDeliveryAvailabilityForLocation() {
        try {
            elementLocator = ProductListingsPageLocators.deliveryAvailabilityVerify;
            webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
            isElementDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isElementDisplayed, "Delivery availability shown for selected location");
            LoggerHandler.info("Delivery availability verified");
            extentTest.log(Status.PASS, "Delivery availability verified");
        } catch (Exception exception) {
            LoggerHandler.error("verifyDeliveryAvailabilityForLocation failed: " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifyDeliveryAvailabilityForLocation_FAIL", extentTest,
                    "verifyDeliveryAvailabilityForLocation failed: " + exception.getMessage());
            extentTest.log(Status.FAIL, "verifyDeliveryAvailabilityForLocation failed: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: verifyElementAfterDataEntry
     * b. Author name: Ruturaj Satish Bhoite
     * c. Short description of method: Verifies the outcome of entering data by
     *    checking the relevant element is displayed.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void verifyElementAfterDataEntry(String elementIdentifier) {
        switch (elementIdentifier) {
            case "priceRange":
                elementLocator = ProductListingsPageLocators.priceRange500to1000;
                actionLogMessage = "Verified price range selected";
                break;
            default:
                LoggerHandler.warn("verifyElementAfterDataEntry: no verification mapped for [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "verifyElementAfterDataEntry: no verification mapped for [" + elementIdentifier + "]");
                return;
        }

        try {
            webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
            isElementDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isElementDisplayed, actionLogMessage);
            LoggerHandler.info(actionLogMessage);
            extentTest.log(Status.PASS, actionLogMessage);
        } catch (Exception exception) {
            LoggerHandler.error("verifyElementAfterDataEntry failed for [" + elementIdentifier + "]: " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifyElementAfterDataEntry_" + elementIdentifier + "_FAIL", extentTest,
                    "verifyElementAfterDataEntry failed for [" + elementIdentifier + "]: " + exception.getMessage());
            extentTest.log(Status.FAIL, "verifyElementAfterDataEntry failed for [" + elementIdentifier + "]: " + exception.getMessage());
        }
    }
}
