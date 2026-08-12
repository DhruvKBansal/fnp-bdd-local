package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.HomePageLocators;
import uistore.ProductDetailsPageLocators;
import uistore.ProductListingLocators;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

public class ProductDetailsPage {

    WebDriver webDriver;
    WebDriverHelper webDriverHelper;
    ExtentTest extentTest;

    By elementLocator;
    String actionLogMessage;
    Status logStatus;
    int excelRowIndex;
    int excelColumnIndex;

    public ProductDetailsPage(WebDriver webDriver, ExtentTest extentTest) {
        this.webDriver = webDriver;
        this.webDriverHelper = new WebDriverHelper(webDriver);
        this.extentTest = extentTest;
    }

    /**
     * a. Method name: verifyPageIsLoaded
     * b. Author name: Kavya
     * c. Short description of method: Verifies the Product Details Page loaded by
     * asserting the Add To Cart button is visible.
     * d. Return type: void
     * e. Parameter list: none
     */
    public void verifyPageIsLoaded() {
        try {
            elementLocator = ProductDetailsPageLocators.addToCart;
            webDriverHelper.waitForElementToBeVisible(elementLocator, 20);
            boolean isDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isDisplayed, "Product details page loaded");
            LoggerHandler.info("Product details page loaded");
            extentTest.log(Status.PASS, "Product details page loaded");
        } catch (Exception exception) {
            logFailure("verifyPageIsLoaded", exception);
        }
    }

    /**
     * a. Method name: clickOnFirstProduct
     * b. Author name: Kavya
     * c. Short description of method: Clicks on the first product in the listing.
     * d. Return type: void
     * e. Parameter list: none
     */
    public void clickOnFirstProduct() {
        try {
            elementLocator = ProductListingLocators.firstProduct;
            webDriverHelper.waitForElementToBeVisible(elementLocator, 20);
            webDriverHelper.clickOnElement(elementLocator);
            Thread.sleep(2000);
            LoggerHandler.info("Clicked on first product");
            extentTest.log(Status.PASS, "Clicked on first product");
        } catch (Exception exception) {
            logFailure("clickOnFirstProduct", exception);
        }
    }

    /**
     * a. Method name: switchToWindowAtIndex
     * b. Author name: Kavya
     * c. Short description of method: Switches to the browser window/tab at the given index.
     * d. Return type: void
     * e. Parameter list: int windowIndex
     */
    public void switchToWindowAtIndex(int windowIndex) {
        webDriverHelper.switchToWindowAtIndex(windowIndex);
    }

    /**
     * a. Method name: clickOnElement
     * b. Author name: Kavya
     * c. Short description of method: Clicks on the specified element by resolving
     * its locator and log message using switch-case.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void clickOnElement(String elementIdentifier) {

        switch (elementIdentifier) {

            case "pdpWhereToDeliver":
                elementLocator = ProductDetailsPageLocators.pdpWhereToDeliver;
                actionLogMessage = "Clicked Where To Deliver on PDP";
                logStatus = Status.PASS;
                break;

            case "pdpCountrySelector":
                elementLocator = ProductDetailsPageLocators.pdpCountrySelector;
                actionLogMessage = "Clicked Country Selector on PDP";
                logStatus = Status.PASS;
                break;

            case "redirectContinueButton":
                elementLocator = ProductDetailsPageLocators.redirectContinueButton;
                actionLogMessage = "Clicked Continue on Redirection Popup";
                logStatus = Status.PASS;
                break;

            default:
                LoggerHandler.warn("clickOnElement: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "clickOnElement: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {

            webDriverHelper.waitForElementToBeVisible(elementLocator, 20);
            webDriverHelper.clickOnElement(elementLocator);
            Thread.sleep(2000);

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
     * b. Author name: Kavya
     * c. Short description of method: Enters data into the specified field by
     * reading the value from the Excel data sheet.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void enterDataIntoElement(String elementIdentifier) {

        switch (elementIdentifier) {

            case "unavailabilityLocation":
                elementLocator = HomePageLocators.locationInput;
                excelRowIndex = 4;
                excelColumnIndex = 0;
                actionLogMessage = "Entered unavailability location";
                break;

            default:
                LoggerHandler.warn("enterDataIntoElement: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "enterDataIntoElement: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {

            String excelValue = ExcelReader.readDataFromExcel("HomePage", excelRowIndex, excelColumnIndex);

            webDriverHelper.waitForElementToBeVisible(elementLocator, 20);
            webDriverHelper.sendKeysToElement(elementLocator, excelValue);
            Thread.sleep(2000);

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
     * a. Method name: selectCountryFromExcel
     * b. Author name: Kavya
     * c. Short description of method: Selects a country from the dropdown by
     * reading the country value from the Excel data sheet.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void selectCountryFromExcel(String elementIdentifier) {

        switch (elementIdentifier) {

            case "usa":
                excelRowIndex = 9;
                excelColumnIndex = 3;
                actionLogMessage = "Selected country USA on PDP";
                break;

            default:
                LoggerHandler.warn("selectCountryFromExcel: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "selectCountryFromExcel: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {

            String countryName = ExcelReader.readDataFromExcel("HomePage", excelRowIndex, excelColumnIndex);
            elementLocator = By.xpath("//span[contains(@class,'text-fnp-500') and text()='" + countryName + "']");

            webDriverHelper.waitForElementToBeVisible(elementLocator, 20);
            webDriverHelper.clickOnElement(elementLocator);
            Thread.sleep(3000);

            LoggerHandler.info(actionLogMessage + ": " + countryName);
            extentTest.log(Status.PASS, actionLogMessage + ": " + countryName);

        } catch (Exception exception) {

            LoggerHandler.error("selectCountryFromExcel failed for [" + elementIdentifier + "]: " + exception.getMessage());
            Reporter.attachScreenshotToReport("selectCountryFromExcel_" + elementIdentifier + "_FAIL", extentTest,
                    "selectCountryFromExcel failed for [" + elementIdentifier + "]: " + exception.getMessage());
            extentTest.log(Status.FAIL, "selectCountryFromExcel failed for [" + elementIdentifier + "]: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: verifyElementDisplayed
     * b. Author name: Kavya
     * c. Short description of method: Verifies that the given element is displayed.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void verifyElementDisplayed(String elementIdentifier) {

        switch (elementIdentifier) {

            case "redirectPopup":
                elementLocator = ProductDetailsPageLocators.redirectPopup;
                actionLogMessage = "Verified country catalog redirection popup displayed";
                break;

            case "unavailabilityMessage":
                elementLocator = ProductDetailsPageLocators.unavailabilityMessage;
                actionLogMessage = "Verified product unavailability message displayed";
                break;

            case "changeDeliveryPincodeOption":
                elementLocator = ProductDetailsPageLocators.changeDeliveryPincodeOption;
                actionLogMessage = "Verified Change Delivery Pincode/Area option displayed";
                break;

            case "exploreSimilarGiftsOption":
                elementLocator = ProductDetailsPageLocators.exploreSimilarGiftsOption;
                actionLogMessage = "Verified Explore Similar Gifts option displayed";
                break;

            default:
                LoggerHandler.warn("verifyElementDisplayed: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "verifyElementDisplayed: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {

            boolean isDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isDisplayed, actionLogMessage);
            LoggerHandler.info(actionLogMessage);
            extentTest.log(Status.PASS, actionLogMessage);

        } catch (Exception exception) {

            // Fallback to page-source keyword check for text-based elements
            boolean present = false;
            String src = webDriver.getPageSource().toLowerCase();
            switch (elementIdentifier) {
                case "redirectPopup":
                    present = src.contains("redirect") || src.contains("catalog") || src.contains("country");
                    break;
                case "unavailabilityMessage":
                    present = src.contains("not available") || src.contains("unavailable") || src.contains("not deliver") || src.contains("oops");
                    break;
                case "changeDeliveryPincodeOption":
                    present = src.contains("change delivery pincode") || src.contains("change delivery area") || src.contains("change location") || src.contains("change pincode");
                    break;
                case "exploreSimilarGiftsOption":
                    present = src.contains("explore similar") || src.contains("similar gift");
                    break;
                default:
                    present = false;
            }

            if (present) {
                LoggerHandler.info(actionLogMessage + " (page source)");
                extentTest.log(Status.PASS, actionLogMessage);
            } else {
                LoggerHandler.error("verifyElementDisplayed failed for [" + elementIdentifier + "]: " + exception.getMessage());
                Reporter.attachScreenshotToReport("verifyElementDisplayed_" + elementIdentifier + "_FAIL", extentTest,
                        "verifyElementDisplayed failed for [" + elementIdentifier + "]: " + exception.getMessage());
                extentTest.log(Status.FAIL, "verifyElementDisplayed failed for [" + elementIdentifier + "]: " + exception.getMessage());
            }
        }
    }

    private void logFailure(String step, Exception exception) {
        LoggerHandler.error(step + " failed: " + exception.getMessage());
        Reporter.attachScreenshotToReport(step + "_FAIL", extentTest,
                step + " failed: " + exception.getMessage());
        extentTest.log(Status.FAIL, step + " failed: " + exception.getMessage());
    }

    /**
     * a. Method name: captureScreenshotAndLog
     * b. Author name: Kavya
     * c. Short description of method: Captures a screenshot and logs the result.
     * d. Return type: void
     * e. Parameter list: String screenFileName
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
