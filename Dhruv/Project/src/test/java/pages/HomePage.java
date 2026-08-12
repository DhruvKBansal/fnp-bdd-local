package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.HomePageLocators;
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

    public HomePage(WebDriver webDriver, ExtentTest extentTest) {
        this.webDriver = webDriver;
        this.webDriverHelper = new WebDriverHelper(webDriver);
        this.extentTest = extentTest;
    }

    /**
     * a. Method name: clickOnElement
     * b. Author name: Dhruv Kumar Bansal
     * c. Short description: Clicks on the specified element by resolving its
     *    locator and log message using a switch-case. Common wait and click
     *    actions run once. Captures screenshot on failure.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void clickOnElement(String elementIdentifier) {

        switch (elementIdentifier) {

            case "popup":
                elementLocator = HomePageLocators.popupNoThanks;
                actionLogMessage = "Clicked No Thanks on popup";
                logStatus = Status.PASS;
                break;

            case "whereToDeliver":
                elementLocator = HomePageLocators.whereToDeliver;
                actionLogMessage = "Clicked Where To Deliver";
                logStatus = Status.PASS;
                break;

            case "enterLocation":
                elementLocator = HomePageLocators.enterLocation;
                actionLogMessage = "Clicked Enter Location field";
                logStatus = Status.PASS;
                break;

            case "firstLocationSuggestion":
                elementLocator = HomePageLocators.firstLocationSuggestion;
                actionLogMessage = "Clicked First Location Suggestion";
                logStatus = Status.PASS;
                break;

            case "locationConfirmButton":
                elementLocator = HomePageLocators.locationConfirmButton;
                actionLogMessage = "Clicked Confirm Location Button";
                logStatus = Status.PASS;
                break;

            case "searchBar":
                elementLocator = HomePageLocators.searchBar;
                actionLogMessage = "Clicked Search Bar";
                logStatus = Status.PASS;
                break;

            case "searchSuggestion":
                elementLocator = HomePageLocators.searchSuggestion;
                actionLogMessage = "Clicked Search Suggestion";
                logStatus = Status.PASS;
                break;

            case "flowersNav":
                elementLocator = HomePageLocators.flowersNav;
                actionLogMessage = "Clicked Flowers in navigation bar";
                logStatus = Status.PASS;
                break;

            case "rosesSubCategory":
                elementLocator = HomePageLocators.rosesSubCategory;
                actionLogMessage = "Clicked Roses sub-category";
                logStatus = Status.PASS;
                break;

            case "footerVendorLink":
                elementLocator = HomePageLocators.footerVendorLink;
                actionLogMessage = "Clicked Become a Vendor link in footer";
                logStatus = Status.PASS;
                break;

case "footerMoreLink":
                elementLocator = HomePageLocators.footerMoreLink;
                actionLogMessage = "Clicked More link in footer";
                logStatus = Status.PASS;
                break;

            case "footerFranchiseLink":
                elementLocator = HomePageLocators.footerFranchiseLink;
                actionLogMessage = "Clicked Franchise link in footer";
                logStatus = Status.PASS;
                break;

            case "moreImage":
                elementLocator = HomePageLocators.moreImage;
                actionLogMessage = "Clicked More image in header";
                logStatus = Status.PASS;
                break;

            case "becomeVendorMenuItem":
                elementLocator = HomePageLocators.becomeVendorMenuItem;
                actionLogMessage = "Clicked Become a Vendor in More menu";
                logStatus = Status.PASS;
                break;

            case "bestSellerFirstProduct":
                elementLocator = HomePageLocators.bestSellerFirstProduct;
                actionLogMessage = "Clicked Best Seller First Product";
                logStatus = Status.PASS;
                break;

            case "personaliseIt":
                elementLocator = HomePageLocators.personaliseItFilter;
                actionLogMessage = "Clicked Personalise It";
                logStatus = Status.PASS;
                break;

            case "personaliseYes":
                elementLocator = HomePageLocators.personaliseYes;
                actionLogMessage = "Clicked Personalise Yes";
                logStatus = Status.PASS;
                break;

            case "personaliseNo":
                elementLocator = HomePageLocators.personaliseNo;
                actionLogMessage = "Clicked Personalise No";
                logStatus = Status.PASS;
                break;

            case "flowerOrchid":
                elementLocator = HomePageLocators.flowerOrchid;
                actionLogMessage = "Clicked Orchid flower";
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
     * a. Method name: hoverOverElement
     * b. Author name: Dhruv Kumar Bansal
     * c. Short description: Hovers over the specified navigation menu item.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void hoverOverElement(String elementIdentifier) {

        switch (elementIdentifier) {

            case "flowers":
                elementLocator = HomePageLocators.flowersNav;
                actionLogMessage = "Hovered over Flowers";
                break;

            case "cakes":
                elementLocator = HomePageLocators.cakesNav;
                actionLogMessage = "Hovered over Cakes";
                break;

            case "plants":
                elementLocator = HomePageLocators.plantsNav;
                actionLogMessage = "Hovered over Plants";
                break;

            case "more":
                elementLocator = HomePageLocators.moreMenu;
                actionLogMessage = "Hovered over More menu";
                break;

            default:
                LoggerHandler.warn("hoverOverElement: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "hoverOverElement: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {
            webDriverHelper.waitForElementToBeVisible(elementLocator, 10);
            webDriverHelper.hoverOverElement(elementLocator);
            LoggerHandler.info(actionLogMessage);
            extentTest.log(Status.PASS, actionLogMessage);
        } catch (Exception exception) {
            LoggerHandler.error("hoverOverElement failed for [" + elementIdentifier + "]: " + exception.getMessage());
            Reporter.attachScreenshotToReport("hoverOverElement_" + elementIdentifier + "_FAIL", extentTest,
                    "hoverOverElement failed for [" + elementIdentifier + "]: " + exception.getMessage());
            extentTest.log(Status.FAIL, "hoverOverElement failed for [" + elementIdentifier + "]: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: enterDataIntoElement
     * b. Author name: Dhruv Kumar Bansal
     * c. Short description: Enters data into a field, reading value from excel.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void enterDataIntoElement(String elementIdentifier) {

        switch (elementIdentifier) {

            case "hyderabad":
                elementLocator = HomePageLocators.enterLocation;
                excelRowIndex = 1;
                excelColumnIndex = 0;
                actionLogMessage = "Entered location: Hyderabad";
                break;

            case "searchProduct":
                elementLocator = HomePageLocators.searchBar;
                excelRowIndex = 1;
                excelColumnIndex = 1;
                actionLogMessage = "Entered search value from excel";
                break;

            default:
                LoggerHandler.warn("enterDataIntoElement: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "enterDataIntoElement: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {
            String excelValue = ExcelReader.readDataFromExcel("HomePage", excelRowIndex, excelColumnIndex);
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
     * a. Method name: pressEnterOnElement
     * b. Author name: Dhruv Kumar Bansal
     * c. Short description: Presses ENTER on the specified element.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void pressEnterOnElement(String elementIdentifier) {

        switch (elementIdentifier) {

            case "locationConfirmButton":
                elementLocator = HomePageLocators.locationConfirmButton;
                actionLogMessage = "Pressed Enter on Confirm Location Button";
                break;

            case "searchBar":
                elementLocator = HomePageLocators.searchBar;
                actionLogMessage = "Pressed Enter on Search Bar";
                break;

            default:
                LoggerHandler.warn("pressEnterOnElement: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "pressEnterOnElement: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {
            webDriverHelper.waitForElementToBeVisible(elementLocator, 10);
            webDriverHelper.pressEnterKey(elementLocator);
            LoggerHandler.info(actionLogMessage);
            extentTest.log(Status.PASS, actionLogMessage);
        } catch (Exception exception) {
            LoggerHandler.error("pressEnterOnElement failed for [" + elementIdentifier + "]: " + exception.getMessage());
            Reporter.attachScreenshotToReport("pressEnterOnElement_" + elementIdentifier + "_FAIL", extentTest,
                    "pressEnterOnElement failed for [" + elementIdentifier + "]: " + exception.getMessage());
            extentTest.log(Status.FAIL, "pressEnterOnElement failed for [" + elementIdentifier + "]: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: verifyElementText
     * b. Author name: Dhruv Kumar Bansal
     * c. Short description: Verifies the text of the selected location.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void verifyElementText(String elementIdentifier) {

        switch (elementIdentifier) {

            case "hyderabadPinCode":
                expectedTextValue = "Hyderabad, India, 500001";
                elementLocator = HomePageLocators.hyderabadPinCode;
                actionLogMessage = "Verified Hyderabad Pincode";
                break;

            default:
                LoggerHandler.warn("verifyElementText: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "verifyElementText: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {
            actualTextValue = webDriverHelper.getTextFromElement(elementLocator);
            webDriverHelper.verifyTrue(webDriverHelper.getTextFromElement(elementLocator).contains("Hyderabad"),
                    "Location Hyderabad selected");
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
     * a. Method name: verifyPageIsLoaded
     * b. Author name: Dhruv Kumar Bansal
     * c. Short description: Verifies the homepage loaded by checking the search bar.
     * d. Return type: void
     * e. Parameter list: none
     */
    public void verifyPageIsLoaded() {
        try {
            elementLocator = HomePageLocators.searchBar;
            webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
            boolean isDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isDisplayed, "Home page loaded successfully");
            LoggerHandler.info("Home page loaded successfully");
            extentTest.log(Status.PASS, "Home page loaded successfully");
        } catch (Exception exception) {
            LoggerHandler.error("verifyPageIsLoaded failed: " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifyPageIsLoaded_FAIL", extentTest,
                    "verifyPageIsLoaded failed: " + exception.getMessage());
            extentTest.log(Status.FAIL, "verifyPageIsLoaded failed: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: scrollDownToFooter
     * b. Author name: Dhruv Kumar Bansal
     * c. Short description: Scrolls down to the footer of the page.
     * d. Return type: void
     * e. Parameter list: none
     */
    public void scrollDownToFooter() {
        try {
            webDriverHelper.scrollDownToFooter();
            LoggerHandler.info("Scrolled down to the footer");
            extentTest.log(Status.PASS, "Scrolled down to the footer");
        } catch (Exception exception) {
            LoggerHandler.error("scrollDownToFooter failed: " + exception.getMessage());
            Reporter.attachScreenshotToReport("scrollDownToFooter_FAIL", extentTest,
                    "scrollDownToFooter failed: " + exception.getMessage());
            extentTest.log(Status.FAIL, "scrollDownToFooter failed: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: scrollUpToHeader
     * b. Author name: Dhruv Kumar Bansal
     * c. Short description: Scrolls up to the header of the page.
     * d. Return type: void
     * e. Parameter list: none
     */
    public void scrollUpToHeader() {
        try {
            webDriverHelper.scrollUpToHeader();
            LoggerHandler.info("Scrolled up to the header");
            extentTest.log(Status.PASS, "Scrolled up to the header");
        } catch (Exception exception) {
            LoggerHandler.error("scrollUpToHeader failed: " + exception.getMessage());
            Reporter.attachScreenshotToReport("scrollUpToHeader_FAIL", extentTest,
                    "scrollUpToHeader failed: " + exception.getMessage());
            extentTest.log(Status.FAIL, "scrollUpToHeader failed: " + exception.getMessage());
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

        switch (elementIdentifier) {

            case "popup":
                elementLocator = HomePageLocators.whereToDeliver;
                actionLogMessage = "Verified homepage displayed after closing popup";
                break;

            case "whereToDeliver":
                elementLocator = HomePageLocators.enterLocation;
                actionLogMessage = "Verified Where To Deliver dialog opened";
                break;

            case "enterLocation":
            case "firstLocationSuggestion":
                elementLocator = HomePageLocators.locationConfirmButton;
                actionLogMessage = "Verified location suggestion selected";
                break;

            case "locationConfirmButton":
                elementLocator = HomePageLocators.searchBar;
                actionLogMessage = "Verified location confirmed";
                break;

            case "searchBar":
                elementLocator = HomePageLocators.searchBar;
                actionLogMessage = "Verified search bar is ready";
                break;

            case "footerVendorLink":
                elementLocator = HomePageLocators.footerVendorLink;
                actionLogMessage = "Verified vendor page opened";
                break;

            case "footerFranchiseLink":
                elementLocator = HomePageLocators.footerFranchiseLink;
                actionLogMessage = "Verified franchise page opened";
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
     * b. Author name: Dhruv Kumar Bansal
     * c. Short description: Verifies the outcome of entering data.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void verifyElementAfterDataEntry(String elementIdentifier) {

        switch (elementIdentifier) {

            case "hyderabad":
                elementLocator = HomePageLocators.firstLocationSuggestion;
                actionLogMessage = "Verified location suggestions appeared";
                break;

            case "searchProduct":
                elementLocator = HomePageLocators.searchSuggestion;
                actionLogMessage = "Verified search suggestions appeared";
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
     * a. Method name: verifyElementAfterEnter
     * b. Author name: Dhruv Kumar Bansal
     * c. Short description: Verifies the outcome of an ENTER key action.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void verifyElementAfterEnter(String elementIdentifier) {

        switch (elementIdentifier) {

            case "locationConfirmButton":
                elementLocator = HomePageLocators.searchBar;
                actionLogMessage = "Verified location confirmed";
                break;

            case "searchBar":
                elementLocator = uistore.ProductListingLocators.firstProduct;
                actionLogMessage = "Verified search results page loaded";
                break;

            default:
                LoggerHandler.warn("verifyElementAfterEnter: no verification mapped for [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "verifyElementAfterEnter: no verification mapped for [" + elementIdentifier + "]");
                return;
        }

        try {
            webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
            boolean isDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            webDriverHelper.verifyTrue(isDisplayed, actionLogMessage);
            LoggerHandler.info(actionLogMessage);
            extentTest.log(Status.PASS, actionLogMessage);
        } catch (Exception exception) {
            LoggerHandler.error("verifyElementAfterEnter failed for [" + elementIdentifier + "]: " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifyElementAfterEnter_" + elementIdentifier + "_FAIL", extentTest,
                    "verifyElementAfterEnter failed for [" + elementIdentifier + "]: " + exception.getMessage());
            extentTest.log(Status.FAIL, "verifyElementAfterEnter failed for [" + elementIdentifier + "]: " + exception.getMessage());
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
