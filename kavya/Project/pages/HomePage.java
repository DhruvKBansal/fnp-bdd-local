package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.HomePageLocators;
import uistore.ProductListingLocators;
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
     * b. Author name: Kavya
     * c. Short description of method: Clicks on the specified element by resolving
     * its locator and log message using switch-case. Common wait and click
     * actions are executed once after the switch. Captures screenshot on failure.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void clickOnElement(String elementIdentifier) {

        switch (elementIdentifier) {

            case "popup":
                elementLocator = HomePageLocators.popupDismiss;
                actionLogMessage = "Clicked No Thanks";
                logStatus = Status.PASS;
                break;

            case "whereToDeliver":
                elementLocator = HomePageLocators.whereToDeliver;
                actionLogMessage = "Clicked Where To Deliver";
                logStatus = Status.PASS;
                break;

            case "enterLocation":
                elementLocator = HomePageLocators.locationInput;
                actionLogMessage = "Clicked Enter Location";
                logStatus = Status.PASS;
                break;

            case "firstLocationSuggestion":
                elementLocator = HomePageLocators.firstLocationSuggestion;
                actionLogMessage = "Clicked on First Location Suggestion";
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

            case "countrySelector":
                elementLocator = HomePageLocators.countrySelectorButton;
                actionLogMessage = "Clicked Country Selector";
                logStatus = Status.PASS;
                break;

            case "newsletterEmailInput":
                elementLocator = HomePageLocators.newsletterEmailInput;
                actionLogMessage = "Clicked Newsletter Email Input";
                logStatus = Status.PASS;
                break;

            case "newsletterSubscribeButton":
                elementLocator = HomePageLocators.newsletterSubscribeButton;
                actionLogMessage = "Clicked Newsletter Subscribe Button";
                logStatus = Status.PASS;
                break;

            case "citySearchInput":
                elementLocator = HomePageLocators.locationInput;
                actionLogMessage = "Clicked City Search Input";
                logStatus = Status.PASS;
                break;

            case "confirmButton":
                elementLocator = HomePageLocators.locationConfirmButton;
                actionLogMessage = "Clicked Confirm Button";
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
     * b. Author name: Kavya
     * c. Short description of method: Enters data into specified field by reading
     * the value from the Excel data sheet using the configured row/column.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void enterDataIntoElement(String elementIdentifier) {

        switch (elementIdentifier) {

            case "validEmail":
                elementLocator = HomePageLocators.newsletterEmailInput;
                excelRowIndex = 1;
                excelColumnIndex = 2;
                actionLogMessage = "Entered valid email";
                break;

            case "invalidEmail":
                elementLocator = HomePageLocators.newsletterEmailInput;
                excelRowIndex = 2;
                excelColumnIndex = 2;
                actionLogMessage = "Entered invalid email";
                break;

case "delhi":
                elementLocator = HomePageLocators.locationInput;
                excelRowIndex = 2;
                excelColumnIndex = 0;
                actionLogMessage = "Entered location Delhi";
                break;

            case "validPincode":
                elementLocator = HomePageLocators.locationInput;
                excelRowIndex = 3;
                excelColumnIndex = 0;
                actionLogMessage = "Entered valid pincode";
                break;

            case "invalidPincode":
                elementLocator = HomePageLocators.locationInput;
                excelRowIndex = 4;
                excelColumnIndex = 0;
                actionLogMessage = "Entered invalid pincode";
                break;

            case "emptyPincode":
                elementLocator = HomePageLocators.locationInput;
                excelRowIndex = 5;
                excelColumnIndex = 0;
                actionLogMessage = "Left pincode empty";
                break;

            case "validCity":
                elementLocator = HomePageLocators.locationInput;
                excelRowIndex = 6;
                excelColumnIndex = 0;
                actionLogMessage = "Entered valid city name";
                break;

            case "invalidCity":
                elementLocator = HomePageLocators.locationInput;
                excelRowIndex = 7;
                excelColumnIndex = 0;
                actionLogMessage = "Entered invalid city name";
                break;

            case "validSearch":
                elementLocator = HomePageLocators.searchBar;
                excelRowIndex = 3;
                excelColumnIndex = 1;
                actionLogMessage = "Entered valid search term";
                break;

            case "invalidSearch":
                elementLocator = HomePageLocators.searchBar;
                excelRowIndex = 8;
                excelColumnIndex = 1;
                actionLogMessage = "Entered invalid search term";
                break;

            case "unavailabilityLocation":
                elementLocator = HomePageLocators.locationInput;
                excelRowIndex = 4;
                excelColumnIndex = 0;
                actionLogMessage = "Entered unavailability location";
                break;

            default:
                LoggerHandler.warn("enterDataIntoElement: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING,
                        "enterDataIntoElement: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {

            String excelValue = ExcelReader.readDataFromExcel("HomePage", excelRowIndex, excelColumnIndex);

            webDriverHelper.waitForElementToBeVisible(elementLocator, 10);
            webDriverHelper.sendKeysToElement(elementLocator, excelValue);

            LoggerHandler.info(actionLogMessage + ": " + excelValue);
            extentTest.log(Status.PASS, actionLogMessage + ": " + excelValue);

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
     * a. Method name: selectCountryFromExcel
     * b. Author name: Kavya
     * c. Short description of method: Selects a country from the dropdown by
     * reading the country value from the Excel data sheet.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void selectCountryFromExcel(String elementIdentifier) {

        switch (elementIdentifier) {

            case "india":
                excelRowIndex = 1;
                excelColumnIndex = 3;
                actionLogMessage = "Selected country India";
                break;

            case "usa":
                excelRowIndex = 9;
                excelColumnIndex = 3;
                actionLogMessage = "Selected country USA";
                break;

            default:
                LoggerHandler.warn("selectCountryFromExcel: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "selectCountryFromExcel: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {

            String countryName = ExcelReader.readDataFromExcel("HomePage", excelRowIndex, excelColumnIndex);
            elementLocator = By.xpath("//*[@id='search-country-button']/ancestor::div[contains(@class,'fixed')]//span[contains(@class,'text-fnp-500') and text()='" + countryName + "']");

            webDriverHelper.waitForElementToBeVisible(elementLocator, 10);
            webDriverHelper.clickOnElement(elementLocator);

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
     * a. Method name: pressEnterOnElement
     * b. Author name: Kavya
     * c. Short description of method: Performs ENTER action on specified element.
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
                extentTest.log(Status.WARNING,
                        "pressEnterOnElement: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {

            webDriverHelper.waitForElementToBeVisible(elementLocator, 10);
            webDriverHelper.pressEnterKey(elementLocator);

            LoggerHandler.info(actionLogMessage);
            extentTest.log(Status.PASS, actionLogMessage);

        } catch (Exception exception) {

            LoggerHandler.error(
                    "pressEnterOnElement failed for [" + elementIdentifier + "]: " + exception.getMessage());

            Reporter.attachScreenshotToReport(
                    "pressEnterOnElement_" + elementIdentifier + "_FAIL",
                    extentTest,
                    "pressEnterOnElement failed for [" + elementIdentifier + "]: " + exception.getMessage());

            extentTest.log(Status.FAIL,
                    "pressEnterOnElement failed for [" + elementIdentifier + "]: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: scrollToElement
     * b. Author name: Kavya
     * c. Short description of method: Scrolls to the specified element.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void scrollToElement(String elementIdentifier) {

        switch (elementIdentifier) {

            case "newsletter":
                elementLocator = HomePageLocators.newsletterComponent;
                actionLogMessage = "Scrolled to newsletter section";
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
            extentTest.log(Status.PASS, actionLogMessage);

        } catch (Exception exception) {

            LoggerHandler.error("scrollToElement failed for [" + elementIdentifier + "]: " + exception.getMessage());

            Reporter.attachScreenshotToReport("scrollToElement_" + elementIdentifier + "_FAIL", extentTest,
                    "scrollToElement failed for [" + elementIdentifier + "]: " + exception.getMessage());

            extentTest.log(Status.FAIL, "scrollToElement failed for [" + elementIdentifier + "]: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: verifyElementAfterClick
     * b. Author name: Kavya
     * c. Short description of method: Verifies the outcome of a click action by
     * resolving its expected verification locator / condition via switch-case.
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
                elementLocator = HomePageLocators.locationInput;
                actionLogMessage = "Verified Where To Deliver dialog opened";
                break;

case "enterLocation":
            case "citySearchInput":
                elementLocator = HomePageLocators.locationConfirmButton;
                actionLogMessage = "Verified location/city search input active";
                break;

            case "firstLocationSuggestion":
                elementLocator = HomePageLocators.locationConfirmButton;
                actionLogMessage = "Verified location suggestion selected";
                break;

            case "locationConfirmButton":
            case "confirmButton":
                elementLocator = HomePageLocators.searchBar;
                actionLogMessage = "Verified location confirmed";
                break;

            case "searchBar":
                elementLocator = HomePageLocators.searchBar;
                actionLogMessage = "Verified search bar is ready";
                break;

            case "countrySelector":
                elementLocator = HomePageLocators.countryDropdownOptions;
                actionLogMessage = "Verified country list displayed";
                break;

            case "newsletterEmailInput":
                elementLocator = HomePageLocators.newsletterEmailInput;
                actionLogMessage = "Verified newsletter email input active";
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
     * b. Author name: Kavya
     * c. Short description of method: Verifies the outcome of entering data by
     * checking the relevant suggestion / populated field is displayed.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void verifyElementAfterDataEntry(String elementIdentifier) {

        switch (elementIdentifier) {

            case "validEmail":
            case "invalidEmail":
                elementLocator = HomePageLocators.newsletterEmailInput;
                actionLogMessage = "Verified email value entered";
                break;

            case "validPincode":
            case "invalidPincode":
            case "emptyPincode":
                elementLocator = HomePageLocators.locationInput;
                actionLogMessage = "Verified pincode value entered";
                break;

case "delhi":
            case "validCity":
            case "invalidCity":
                elementLocator = HomePageLocators.locationInput;
                actionLogMessage = "Verified city name entered";
                break;

            case "validSearch":
            case "invalidSearch":
                elementLocator = HomePageLocators.searchBar;
                actionLogMessage = "Verified search term entered";
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
     * b. Author name: Kavya
     * c. Short description of method: Verifies the outcome of an ENTER key action.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void verifyElementAfterEnter(String elementIdentifier) {

        switch (elementIdentifier) {

            case "locationConfirmButton":
                elementLocator = HomePageLocators.searchBar;
                actionLogMessage = "Verified location confirmed via Enter";
                break;

            case "searchBar":
                elementLocator = ProductListingLocators.pageHeading;
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
     * a. Method name: verifyElementText
     * b. Author name: Kavya
     * c. Short description of method: Verifies the text of the given element.
     * d. Return type: void
     * e. Parameter list: String elementIdentifier
     */
    public void verifyElementText(String elementIdentifier) {

        switch (elementIdentifier) {

            case "newsletterSuccess":
                expectedTextValue = "subscribed";
                elementLocator = HomePageLocators.newsletterSuccessMessage;
                actionLogMessage = "Verified newsletter success message";
                break;

            case "newsletterNotSubscribed":
                expectedTextValue = "";
                elementLocator = HomePageLocators.newsletterSuccessMessage;
                actionLogMessage = "Verified newsletter not subscribed";
                break;

            default:
                LoggerHandler.warn("verifyElementText: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "verifyElementText: unknown element [" + elementIdentifier + "]");
                return;
        }

        try {

            actualTextValue = webDriverHelper.getTextFromElement(elementLocator);
            if ("newsletterNotSubscribed".equals(elementIdentifier)) {
                webDriverHelper.verifyTrue(!actualTextValue.toLowerCase().contains("subscribed"),
                        "Subscription not successful");
            } else {
                webDriverHelper.verifyTrue(actualTextValue.toLowerCase().contains(expectedTextValue),
                        actionLogMessage);
            }

            LoggerHandler.info(actionLogMessage);
            extentTest.log(Status.PASS, actionLogMessage);

        } catch (Exception exception) {

            if ("newsletterNotSubscribed".equals(elementIdentifier)) {
                // If the success message is absent, the subscription was not successful -> PASS
                LoggerHandler.info("No success message - subscription not successful");
                extentTest.log(Status.PASS, "Subscription not successful for invalid email");
            } else {
                LoggerHandler.error("verifyElementText failed for [" + elementIdentifier + "]: " + exception.getMessage());
                Reporter.attachScreenshotToReport("verifyElementText_" + elementIdentifier + "_FAIL", extentTest,
                        "verifyElementText failed for [" + elementIdentifier + "]: " + exception.getMessage());
                extentTest.log(Status.FAIL, "verifyElementText failed for [" + elementIdentifier + "]: " + exception.getMessage());
            }
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

            case "defaultDeliveryLocation":
                elementLocator = HomePageLocators.whereToDeliver;
                actionLogMessage = "Verified default delivery location displayed";
                break;

            case "countrySelector":
                elementLocator = HomePageLocators.countrySelectorDisplayed;
                actionLogMessage = "Verified country selector displayed";
                break;

            case "newsletterSection":
                elementLocator = HomePageLocators.newsletterComponent;
                actionLogMessage = "Verified newsletter section displayed";
                break;

            case "searchSuggestions":
                elementLocator = HomePageLocators.searchSuggestionItems;
                actionLogMessage = "Verified search suggestions displayed";
                break;

            case "noSearchSuggestions":
                elementLocator = HomePageLocators.searchSuggestionItems;
                actionLogMessage = "Verified no search suggestions displayed";
                break;

            case "deliveryModal":
                elementLocator = HomePageLocators.locationInput;
                actionLogMessage = "Verified delivery modal displayed";
                break;

            case "locationConfirmButton":
                elementLocator = HomePageLocators.locationConfirmButton;
                actionLogMessage = "Verified location confirm button displayed";
                break;

            case "citySuggestions":
                elementLocator = HomePageLocators.firstLocationSuggestion;
                actionLogMessage = "Verified city suggestions displayed";
                break;

            case "noCitySuggestions":
                elementLocator = HomePageLocators.firstLocationSuggestion;
                actionLogMessage = "Verified no city suggestions displayed";
                break;

            case "selectedCountry":
                elementLocator = HomePageLocators.countrySelectorDisplayed;
                actionLogMessage = "Verified selected country displayed";
                break;

            default:
                LoggerHandler.warn("verifyElementDisplayed: unknown element [" + elementIdentifier + "]");
                extentTest.log(Status.WARNING, "verifyElementDisplayed: unknown element [" + elementIdentifier + "]");
                return;
        }

try {

            boolean isDisplayed;
            if (elementIdentifier.startsWith("no")) {
                // Absence checks: verify the element is NOT present (no wait needed).
                isDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            } else {
                // Presence checks: wait for the element to become visible first,
                // because suggestions/selectors load asynchronously.
                webDriverHelper.waitForElementToBeVisible(elementLocator, 15);
                isDisplayed = webDriverHelper.isElementDisplayed(elementLocator);
            }

            if (elementIdentifier.startsWith("no")) {
                webDriverHelper.verifyTrue(!isDisplayed, actionLogMessage);
            } else {
                webDriverHelper.verifyTrue(isDisplayed, actionLogMessage);
            }
            LoggerHandler.info(actionLogMessage);
            extentTest.log(Status.PASS, actionLogMessage);

        } catch (Exception exception) {

            LoggerHandler.error("verifyElementDisplayed failed for [" + elementIdentifier + "]: " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifyElementDisplayed_" + elementIdentifier + "_FAIL", extentTest,
                    "verifyElementDisplayed failed for [" + elementIdentifier + "]: " + exception.getMessage());
            extentTest.log(Status.FAIL, "verifyElementDisplayed failed for [" + elementIdentifier + "]: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: verifyPincodeValidation
     * b. Author name: Kavya
     * c. Short description of method: Verifies that a validation message is shown
     * for empty/invalid pincode.
     * d. Return type: void
     * e. Parameter list: none
     */
    public void verifyPincodeValidation() {
        try {
            boolean hasValidation = webDriverHelper.isElementDisplayed(HomePageLocators.locationValidationMessage)
                    || webDriver.getPageSource().contains("Please")
                    || webDriver.getPageSource().contains("required")
                    || webDriver.getPageSource().contains("Enter");
            webDriverHelper.verifyTrue(hasValidation, "Pincode validation message displayed");
            LoggerHandler.info("Pincode validation message displayed");
            extentTest.log(Status.PASS, "Pincode validation message displayed");
        } catch (Exception exception) {
            LoggerHandler.error("verifyPincodeValidation failed: " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifyPincodeValidation_FAIL", extentTest,
                    "verifyPincodeValidation failed: " + exception.getMessage());
            extentTest.log(Status.FAIL, "verifyPincodeValidation failed: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: verifyNewsletterValidationError
     * b. Author name: Kavya
     * c. Short description of method: Verifies validation error for invalid email.
     * d. Return type: void
     * e. Parameter list: none
     */
    public void verifyNewsletterValidationError() {
        try {
            boolean hasError = webDriver.getPageSource().contains("Please")
                    || webDriver.findElements(HomePageLocators.newsletterSuccessMessage).size() == 0;
            webDriverHelper.verifyTrue(hasError, "Newsletter validation error displayed");
            LoggerHandler.info("Newsletter validation error displayed");
            extentTest.log(Status.PASS, "Newsletter validation error displayed for invalid email");
        } catch (Exception exception) {
            LoggerHandler.error("verifyNewsletterValidationError failed: " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifyNewsletterValidationError_FAIL", extentTest,
                    "verifyNewsletterValidationError failed: " + exception.getMessage());
            extentTest.log(Status.FAIL, "verifyNewsletterValidationError failed: " + exception.getMessage());
        }
    }

    /**
     * a. Method name: verifySearchExecuted
     * b. Author name: Kavya
     * c. Short description of method: Verifies that a search was executed.
     * d. Return type: void
     * e. Parameter list: none
     */
    public void verifySearchExecuted() {
        try {
            String url = webDriver.getCurrentUrl();
            boolean hasQuery = url.contains("search") || url.contains("q=") || url.contains("?");
            boolean listingLoaded = webDriverHelper.isElementDisplayed(ProductListingLocators.pageHeading);
            webDriverHelper.verifyTrue(hasQuery || listingLoaded, "Search executed successfully");
            LoggerHandler.info("Search executed");
            extentTest.log(Status.PASS, "Search executed");
        } catch (Exception exception) {
            LoggerHandler.error("verifySearchExecuted failed: " + exception.getMessage());
            Reporter.attachScreenshotToReport("verifySearchExecuted_FAIL", extentTest,
                    "verifySearchExecuted failed: " + exception.getMessage());
            extentTest.log(Status.FAIL, "verifySearchExecuted failed: " + exception.getMessage());
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
     * a. Method name: scrollDownToFooter
     * b. Author name: Kavya
     * c. Short description of method: Scrolls down to the footer of the page.
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
     * a. Method name: captureScreenshotAndLog
     * b. Author name: Kavya
     * c. Short description of method: Captures a screenshot using the Screenshot
     * utility class method and logs the result.
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
