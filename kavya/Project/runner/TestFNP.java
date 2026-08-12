package runner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductListingPage;
import utils.Base;
import utils.Reporter;
import utils.ProgressBar;
import utils.VideoRecorder;

@Listeners({ProgressBar.class, VideoRecorder.class})
public class TestFNP extends Base {

    ExtentTest extentTest;
    ExtentReports extentReport;

    @BeforeSuite
    public void initializeReport() {
        extentReport = Reporter.generateExtentReport("FNP_Report_TC_65_To_80");
    }

    @BeforeMethod
    public void launchBrowser() {
        openBrowser();
    }

    @AfterMethod
    public void closeBrowser() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @AfterSuite
    public void flushReport() {
        if (extentReport != null) {
            extentReport.flush();
        }
    }

    // PASS
    // TC_65: Newsletter accepts valid email
    @Test(enabled = true, priority = 1)
    public void tc65_VerifyNewsletterAcceptsValidEmail() {
        extentTest = extentReport.createTest("TC_65_Newsletter_Valid_Email");
        HomePage homePage = new HomePage(webDriver, extentTest);

        homePage.clickOnElement("popup");
        homePage.scrollToElement("newsletter");
        homePage.verifyElementDisplayed("newsletterSection");
        homePage.clickOnElement("newsletterEmailInput");
        homePage.verifyElementAfterClick("newsletterEmailInput");
        homePage.enterDataIntoElement("validEmail");
        homePage.verifyElementAfterDataEntry("validEmail");
        homePage.clickOnElement("newsletterSubscribeButton");
        homePage.verifyElementText("newsletterSuccess");
        homePage.captureScreenshotAndLog("TC65_Newsletter_Valid");
    }

    // PASS
    // TC_66: Newsletter rejects invalid email
    @Test(enabled = true, priority = 2)
    public void tc66_VerifyNewsletterRejectsInvalidEmail() {
        extentTest = extentReport.createTest("TC_66_Newsletter_Invalid_Email");
        HomePage homePage = new HomePage(webDriver, extentTest);

        homePage.clickOnElement("popup");
        homePage.scrollToElement("newsletter");
        homePage.verifyElementDisplayed("newsletterSection");
        homePage.clickOnElement("newsletterEmailInput");
        homePage.verifyElementAfterClick("newsletterEmailInput");
        homePage.enterDataIntoElement("invalidEmail");
        homePage.verifyElementAfterDataEntry("invalidEmail");
        homePage.clickOnElement("newsletterSubscribeButton");
        homePage.verifyNewsletterValidationError();
        homePage.verifyElementText("newsletterNotSubscribed");
        homePage.captureScreenshotAndLog("TC66_Newsletter_Invalid");
    }

    // PASS
    // TC_67: Delivery location modal opens
    @Test(enabled = true, priority = 3)
    public void tc67_VerifyDeliveryModalOpens() {
        extentTest = extentReport.createTest("TC_67_Delivery_Modal_Opens");
        HomePage homePage = new HomePage(webDriver, extentTest);

        homePage.clickOnElement("popup");
        homePage.clickOnElement("whereToDeliver");
        homePage.verifyElementAfterClick("whereToDeliver");
        homePage.verifyElementDisplayed("deliveryModal");
        homePage.verifyElementDisplayed("locationConfirmButton");
        homePage.captureScreenshotAndLog("TC67_Delivery_Modal");
    }

    // PASS
    // TC_68: Valid pincode displays suggestions
    @Test(enabled = true, priority = 4)
    public void tc68_VerifyValidPincodeDisplaysSuggestions() {
        extentTest = extentReport.createTest("TC_68_Valid_Pincode_Suggestions");
        HomePage homePage = new HomePage(webDriver, extentTest);

        homePage.clickOnElement("popup");
        homePage.clickOnElement("whereToDeliver");
        homePage.verifyElementAfterClick("whereToDeliver");
        homePage.clickOnElement("enterLocation");
        homePage.verifyElementAfterClick("enterLocation");
        homePage.enterDataIntoElement("validPincode");
        homePage.verifyElementAfterDataEntry("validPincode");
        homePage.verifyElementDisplayed("citySuggestions");
        homePage.captureScreenshotAndLog("TC68_Valid_Pincode");
    }

    // PASS
    // TC_69: Invalid pincode shows no suggestions
    @Test(enabled = true, priority = 5)
    public void tc69_VerifyInvalidPincodeShowsNoSuggestions() {
        extentTest = extentReport.createTest("TC_69_Invalid_Pincode_No_Suggestions");
        HomePage homePage = new HomePage(webDriver, extentTest);

        homePage.clickOnElement("popup");
        homePage.clickOnElement("whereToDeliver");
        homePage.verifyElementAfterClick("whereToDeliver");
        homePage.clickOnElement("enterLocation");
        homePage.verifyElementAfterClick("enterLocation");
        homePage.enterDataIntoElement("invalidPincode");
        homePage.verifyElementAfterDataEntry("invalidPincode");
        homePage.verifyElementDisplayed("noCitySuggestions");
        homePage.captureScreenshotAndLog("TC69_Invalid_Pincode");
    }

    // PASS
    // TC_70: Empty pincode shows validation
    @Test(enabled = true, priority = 6)
    public void tc70_VerifyEmptyPincodeShowsValidation() {
        extentTest = extentReport.createTest("TC_70_Empty_Pincode_Validation");
        HomePage homePage = new HomePage(webDriver, extentTest);

        homePage.clickOnElement("popup");
        homePage.clickOnElement("whereToDeliver");
        homePage.verifyElementAfterClick("whereToDeliver");
        homePage.clickOnElement("enterLocation");
        homePage.enterDataIntoElement("emptyPincode");
        homePage.clickOnElement("confirmButton");
        homePage.verifyPincodeValidation();
        homePage.captureScreenshotAndLog("TC70_Empty_Pincode");
    }

    // PASS
    // TC_71: User can select a Country/Region
    @Test(enabled = true, priority = 7)
    public void tc71_VerifySelectCountryRegion() {
        extentTest = extentReport.createTest("TC_71_Select_Country_Region");
        HomePage homePage = new HomePage(webDriver, extentTest);

        homePage.clickOnElement("popup");
        // The country selector lives inside the delivery location modal, so open it first.
        homePage.clickOnElement("whereToDeliver");
        homePage.verifyElementAfterClick("whereToDeliver");
        homePage.verifyElementDisplayed("countrySelector");
        homePage.clickOnElement("countrySelector");
        homePage.verifyElementAfterClick("countrySelector");
        homePage.selectCountryFromExcel("india");
        homePage.verifyElementDisplayed("selectedCountry");
        homePage.captureScreenshotAndLog("TC71_Select_Country");
    }

    // PASS
    // TC_72: Default delivery location displayed on launch
    @Test(enabled = true, priority = 8)
    public void tc72_VerifyDefaultDeliveryLocationDisplayed() {
        extentTest = extentReport.createTest("TC_72_Default_Delivery_Location");
        HomePage homePage = new HomePage(webDriver, extentTest);

        homePage.clickOnElement("popup");
        homePage.verifyElementDisplayed("defaultDeliveryLocation");
        homePage.clickOnElement("whereToDeliver");
        homePage.verifyElementAfterClick("whereToDeliver");
        homePage.captureScreenshotAndLog("TC72_Default_Location");
    }

    // PASS
    // TC_73: Country selected without city -> prompt to select city
    @Test(enabled = true, priority = 9)
    public void tc73_ValidatePromptWhenCountrySelectedWithoutCity() {
        extentTest = extentReport.createTest("TC_73_Country_Without_City");
        HomePage homePage = new HomePage(webDriver, extentTest);

        homePage.clickOnElement("popup");
        homePage.verifyElementDisplayed("defaultDeliveryLocation");
        homePage.clickOnElement("whereToDeliver");
        homePage.verifyElementAfterClick("whereToDeliver");
        homePage.clickOnElement("countrySelector");
        homePage.selectCountryFromExcel("india");
        homePage.verifyElementDisplayed("defaultDeliveryLocation");
        homePage.captureScreenshotAndLog("TC73_Country_No_City");
    }

    // PASS
    // TC_74: Valid city search and selection
    @Test(enabled = true, priority = 10)
    public void tc74_VerifyValidCitySearchAndSelect() {
        extentTest = extentReport.createTest("TC_74_Valid_City_Search");
        HomePage homePage = new HomePage(webDriver, extentTest);

        homePage.clickOnElement("popup");
        homePage.clickOnElement("whereToDeliver");
        homePage.verifyElementAfterClick("whereToDeliver");
        homePage.clickOnElement("citySearchInput");
        homePage.verifyElementAfterClick("citySearchInput");
        homePage.enterDataIntoElement("validCity");
        homePage.verifyElementAfterDataEntry("validCity");
        homePage.verifyElementDisplayed("citySuggestions");
        homePage.clickOnElement("firstLocationSuggestion");
        homePage.verifyElementDisplayed("deliveryModal");
        homePage.captureScreenshotAndLog("TC74_Valid_City");
    }

    // PASS
    // TC_75: Invalid city search shows no suggestions
    @Test(enabled = true, priority = 11)
    public void tc75_VerifyInvalidCityShowsNoSuggestions() {
        extentTest = extentReport.createTest("TC_75_Invalid_City_No_Suggestions");
        HomePage homePage = new HomePage(webDriver, extentTest);

        homePage.clickOnElement("popup");
        homePage.clickOnElement("whereToDeliver");
        homePage.verifyElementAfterClick("whereToDeliver");
        homePage.clickOnElement("citySearchInput");
        homePage.verifyElementAfterClick("citySearchInput");
        homePage.enterDataIntoElement("invalidCity");
        homePage.verifyElementAfterDataEntry("invalidCity");
        homePage.verifyElementDisplayed("noCitySuggestions");
        homePage.captureScreenshotAndLog("TC75_Invalid_City");
    }

    // TC_76: Country change from PDP redirects to selected country catalog
    @Test(enabled = true, priority = 12)
    public void tc76_VerifyCountryChangeRedirectFromPDP() {
        extentTest = extentReport.createTest("TC_76_Country_Redirect_PDP");
        HomePage homePage = new HomePage(webDriver, extentTest);
        ProductListingPage listingPage = new ProductListingPage(webDriver, extentTest);
        ProductDetailsPage detailsPage = new ProductDetailsPage(webDriver, extentTest);

homePage.clickOnElement("popup");
        // Enter a delivery location first so the location modal (which overlays the
        // product list and would intercept the product click) is dismissed.
        homePage.clickOnElement("whereToDeliver");
        homePage.clickOnElement("enterLocation");
        homePage.enterDataIntoElement("validCity");
        homePage.clickOnElement("firstLocationSuggestion");
        homePage.clickOnElement("locationConfirmButton");
        homePage.clickOnElement("searchBar");
        homePage.enterDataIntoElement("validSearch");
        homePage.pressEnterOnElement("searchBar");
        listingPage.verifyPageIsLoaded();
        detailsPage.clickOnFirstProduct();
        detailsPage.switchToWindowAtIndex(1);
        detailsPage.verifyPageIsLoaded();
        detailsPage.clickOnElement("pdpWhereToDeliver");
        detailsPage.clickOnElement("pdpCountrySelector");
        detailsPage.selectCountryFromExcel("usa");
        detailsPage.verifyElementDisplayed("redirectPopup");
        detailsPage.clickOnElement("redirectContinueButton");
        detailsPage.captureScreenshotAndLog("TC76_Country_Redirect");
    }

    // TC_77: Product unavailability message with recovery options
    @Test(enabled = true, priority = 13)
    public void tc77_VerifyProductUnavailabilityRecoveryOptions() {
        extentTest = extentReport.createTest("TC_77_Product_Unavailability_Recovery");
        HomePage homePage = new HomePage(webDriver, extentTest);
        ProductListingPage listingPage = new ProductListingPage(webDriver, extentTest);
        ProductDetailsPage detailsPage = new ProductDetailsPage(webDriver, extentTest);

homePage.clickOnElement("popup");
        // Enter a delivery location first so the location modal (which overlays the
        // product list and would intercept the product click) is dismissed.
        homePage.clickOnElement("whereToDeliver");
        homePage.clickOnElement("enterLocation");
        homePage.enterDataIntoElement("validCity");
        homePage.clickOnElement("firstLocationSuggestion");
        homePage.clickOnElement("locationConfirmButton");
        homePage.clickOnElement("searchBar");
        homePage.enterDataIntoElement("validSearch");
        homePage.pressEnterOnElement("searchBar");
        listingPage.verifyPageIsLoaded();
        detailsPage.clickOnFirstProduct();
        detailsPage.switchToWindowAtIndex(1);
        detailsPage.verifyPageIsLoaded();
        detailsPage.clickOnElement("pdpWhereToDeliver");
        detailsPage.enterDataIntoElement("unavailabilityLocation");
        detailsPage.verifyElementDisplayed("unavailabilityMessage");
        detailsPage.verifyElementDisplayed("changeDeliveryPincodeOption");
        detailsPage.verifyElementDisplayed("exploreSimilarGiftsOption");
        detailsPage.captureScreenshotAndLog("TC77_Unavailability_Recovery");
    }

    // TC_78: Appropriate message when gift not available for chosen location
    @Test(enabled = true, priority = 14)
    public void tc78_VerifyMessageWhenGiftUnavailable() {
        extentTest = extentReport.createTest("TC_78_Gift_Unavailable_Message");
        HomePage homePage = new HomePage(webDriver, extentTest);
        ProductListingPage listingPage = new ProductListingPage(webDriver, extentTest);
        ProductDetailsPage detailsPage = new ProductDetailsPage(webDriver, extentTest);

homePage.clickOnElement("popup");
        // Enter a delivery location first so the location modal (which overlays the
        // product list and would intercept the product click) is dismissed.
        homePage.clickOnElement("whereToDeliver");
        homePage.clickOnElement("enterLocation");
        homePage.enterDataIntoElement("validCity");
        homePage.clickOnElement("firstLocationSuggestion");
        homePage.clickOnElement("locationConfirmButton");
        homePage.clickOnElement("searchBar");
        homePage.enterDataIntoElement("validSearch");
        homePage.pressEnterOnElement("searchBar");
        listingPage.verifyPageIsLoaded();
        detailsPage.clickOnFirstProduct();
        detailsPage.switchToWindowAtIndex(1);
        detailsPage.verifyPageIsLoaded();
        detailsPage.clickOnElement("pdpWhereToDeliver");
        detailsPage.enterDataIntoElement("unavailabilityLocation");
        detailsPage.verifyElementDisplayed("unavailabilityMessage");
        detailsPage.verifyElementDisplayed("changeDeliveryPincodeOption");
        detailsPage.verifyElementDisplayed("exploreSimilarGiftsOption");
        detailsPage.captureScreenshotAndLog("TC78_Gift_Unavailable");
    }

    // TC_79: Valid product search displays suggestions
    @Test(enabled = true, priority = 15)
    public void tc79_VerifyValidProductSearchDisplaysSuggestions() {
        extentTest = extentReport.createTest("TC_79_Valid_Product_Search");
        HomePage homePage = new HomePage(webDriver, extentTest);

        homePage.clickOnElement("popup");
        homePage.clickOnElement("searchBar");
        homePage.verifyElementAfterClick("searchBar");
        homePage.enterDataIntoElement("validSearch");
        homePage.verifyElementAfterDataEntry("validSearch");
        homePage.verifyElementDisplayed("searchSuggestions");
        homePage.captureScreenshotAndLog("TC79_Valid_Search");
    }

    // TC_80: Invalid product search shows no relevant results
    @Test(enabled = true, priority = 16)
    public void tc80_VerifyInvalidProductSearchShowsNoResults() {
        extentTest = extentReport.createTest("TC_80_Invalid_Product_Search");
        HomePage homePage = new HomePage(webDriver, extentTest);
        ProductListingPage listingPage = new ProductListingPage(webDriver, extentTest);

        homePage.clickOnElement("popup");
        homePage.clickOnElement("searchBar");
        homePage.verifyElementAfterClick("searchBar");
        homePage.enterDataIntoElement("invalidSearch");
        homePage.verifyElementAfterDataEntry("invalidSearch");
        homePage.pressEnterOnElement("searchBar");
        homePage.verifyElementAfterEnter("searchBar");
        listingPage.verifyNoRelevantResultsDisplayed();
        homePage.captureScreenshotAndLog("TC80_Invalid_Search");
    }
}
