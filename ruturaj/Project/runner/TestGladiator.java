package runner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import utils.ProgressBar;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.ContactUsPage;
import pages.HomePage;
import pages.MyOrdersPage;
import pages.ProductListingPage;
import utils.Base;
import utils.Reporter;

@Listeners(ProgressBar.class)
public class TestGladiator extends Base {

    ExtentTest extentTest;
    ExtentReports extentReport;

    @BeforeSuite
    public void initializeReport() {
        extentReport = Reporter.generateExtentReport("Gladiator_Report");
    }

    @BeforeMethod
    public void launchBrowser() {
        openBrowser();
    }

    @Test(enabled = true, priority = 1)
    public void test49VerifyValidationMessageFor11DigitMobileNumber() {
        extentTest = extentReport.createTest("TC_49");

        HomePage homePageObject = new HomePage(webDriver, extentTest);
        MyOrdersPage myOrdersPageObject = new MyOrdersPage(webDriver, extentTest);

        homePageObject.clickOnElement("popup");
        homePageObject.verifyElementAfterClick("popup");
        homePageObject.clickOnElement("profileIcon");
        homePageObject.verifyElementAfterClick("profileIcon");
        homePageObject.clickOnElement("myOrders");
        homePageObject.verifyElementAfterClick("myOrders");
        myOrdersPageObject.enterDataIntoElement("email");
        myOrdersPageObject.verifyElementAfterDataEntry("email");
        myOrdersPageObject.clickOnElement("continue");
        myOrdersPageObject.verifyElementAfterClick("continue");
        myOrdersPageObject.enterDataIntoElement("name");
        myOrdersPageObject.verifyElementAfterDataEntry("name");
        myOrdersPageObject.enterDataIntoElement("mobile11Digit");
        myOrdersPageObject.verifyElementAfterDataEntry("mobile11Digit");
        myOrdersPageObject.clickOnElement("startGifting");
        myOrdersPageObject.verifyElementAfterClick("startGifting");
        myOrdersPageObject.verifyKeywordInPageSource("Please enter valid 10 digit no.");
        myOrdersPageObject.captureScreenshotAndLog("TC49_InvalidMobile11");
    }

    @Test(enabled = true, priority = 2)
    public void test50VerifyValidationMessageFor9DigitMobileNumber() {
        extentTest = extentReport.createTest("TC_50");

        HomePage homePageObject = new HomePage(webDriver, extentTest);
        MyOrdersPage myOrdersPageObject = new MyOrdersPage(webDriver, extentTest);

        homePageObject.clickOnElement("popup");
        homePageObject.verifyElementAfterClick("popup");
        homePageObject.clickOnElement("profileIcon");
        homePageObject.verifyElementAfterClick("profileIcon");
        homePageObject.clickOnElement("myOrders");
        homePageObject.verifyElementAfterClick("myOrders");
        myOrdersPageObject.enterDataIntoElement("email");
        myOrdersPageObject.verifyElementAfterDataEntry("email");
        myOrdersPageObject.clickOnElement("continue");
        myOrdersPageObject.verifyElementAfterClick("continue");
        myOrdersPageObject.enterDataIntoElement("name");
        myOrdersPageObject.verifyElementAfterDataEntry("name");
        myOrdersPageObject.enterDataIntoElement("mobile9Digit");
        myOrdersPageObject.verifyElementAfterDataEntry("mobile9Digit");
        myOrdersPageObject.clickOnElement("startGifting");
        myOrdersPageObject.verifyElementAfterClick("startGifting");
        myOrdersPageObject.verifyKeywordInPageSource("Please enter valid 10 digit no.");
        myOrdersPageObject.captureScreenshotAndLog("TC50_InvalidMobile9");
    }

    @Test(enabled = true, priority = 3)
    public void test51VerifyValidationFor10DigitMobileNumber() {
        extentTest = extentReport.createTest("TC_51");

        HomePage homePageObject = new HomePage(webDriver, extentTest);
        MyOrdersPage myOrdersPageObject = new MyOrdersPage(webDriver, extentTest);

        homePageObject.clickOnElement("popup");
        homePageObject.verifyElementAfterClick("popup");
        homePageObject.clickOnElement("profileIcon");
        homePageObject.verifyElementAfterClick("profileIcon");
        homePageObject.clickOnElement("myOrders");
        homePageObject.verifyElementAfterClick("myOrders");
        myOrdersPageObject.enterDataIntoElement("email");
        myOrdersPageObject.verifyElementAfterDataEntry("email");
        myOrdersPageObject.clickOnElement("continue");
        myOrdersPageObject.verifyElementAfterClick("continue");
        myOrdersPageObject.enterDataIntoElement("name");
        myOrdersPageObject.verifyElementAfterDataEntry("name");
        myOrdersPageObject.enterDataIntoElement("mobile10Digit");
        myOrdersPageObject.verifyElementAfterDataEntry("mobile10Digit");
        myOrdersPageObject.clickOnElement("startGifting");
        myOrdersPageObject.verifyElementAfterClick("startGifting");
        myOrdersPageObject.verifyKeywordInPageSource("OTP");
        myOrdersPageObject.captureScreenshotAndLog("TC51_ValidMobile10");
    }

    @Test(enabled = true, priority = 4)
    public void test52VerifyValidationMessageForInvalidEmail() {
        extentTest = extentReport.createTest("TC_52");

        HomePage homePageObject = new HomePage(webDriver, extentTest);
        MyOrdersPage myOrdersPageObject = new MyOrdersPage(webDriver, extentTest);

        homePageObject.clickOnElement("popup");
        homePageObject.verifyElementAfterClick("popup");
        homePageObject.clickOnElement("profileIcon");
        homePageObject.verifyElementAfterClick("profileIcon");
        homePageObject.clickOnElement("myOrders");
        homePageObject.verifyElementAfterClick("myOrders");
        myOrdersPageObject.enterDataIntoElement("invalidEmail");
        myOrdersPageObject.verifyElementAfterDataEntry("invalidEmail");
        myOrdersPageObject.clickOnElement("continue");
        myOrdersPageObject.verifyElementAfterClick("continue");
        myOrdersPageObject.verifyKeywordInPageSource("Please enter valid email ID");
        myOrdersPageObject.captureScreenshotAndLog("TC52_InvalidEmail");
    }

    @Test(enabled = true, priority = 5)
    public void test53TrackOrderWithInvalidOrderDetails() {
        extentTest = extentReport.createTest("TC_53");

        HomePage homePageObject = new HomePage(webDriver, extentTest);
        ContactUsPage contactUsPageObject = new ContactUsPage(webDriver, extentTest);

        homePageObject.clickOnElement("popup");
        homePageObject.verifyElementAfterClick("popup");
        homePageObject.clickOnElement("profileIcon");
        homePageObject.verifyElementAfterClick("profileIcon");
        homePageObject.clickOnElement("contactUs");
        homePageObject.verifyElementAfterClick("contactUs");
        contactUsPageObject.clickOnElement("trackOrder");
        contactUsPageObject.verifyElementAfterClick("trackOrder");
        contactUsPageObject.enterDataIntoElement("orderNumber");
        contactUsPageObject.verifyElementAfterDataEntry("orderNumber");
        contactUsPageObject.enterDataIntoElement("trackOrderEmail");
        contactUsPageObject.verifyElementAfterDataEntry("trackOrderEmail");
        contactUsPageObject.clickOnElement("formTrackOrder");
        contactUsPageObject.verifyElementAfterClick("formTrackOrder");
        contactUsPageObject.verifyKeywordInPageSource("Invalid Order");
        contactUsPageObject.captureScreenshotAndLog("TC53_InvalidOrder");
    }

    // LOCATION POPUP, Screenshot failed
    @Test(enabled = true, priority = 6)
    public void test54SearchProductUsingSearchBox() {
        extentTest = extentReport.createTest("TC_54");

        HomePage homePageObject = new HomePage(webDriver, extentTest);
        ProductListingPage productListingPageObject = new ProductListingPage(webDriver, extentTest);

        homePageObject.clickOnElement("popup");
        homePageObject.verifyElementAfterClick("popup");

        homePageObject.clickOnElement("whereToDeliver");
        homePageObject.verifyElementAfterClick("whereToDeliver");
        homePageObject.clickOnElement("enterLocation");
        homePageObject.verifyElementAfterClick("enterLocation");
        homePageObject.enterDataIntoElement("locationHyderabad");
        homePageObject.verifyElementAfterDataEntry("locationHyderabad");
        homePageObject.clickOnElement("firstLocationSuggestion");
        homePageObject.verifyElementAfterClick("firstLocationSuggestion");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        homePageObject.clickOnElement("locationConfirmButton");
        homePageObject.pressEnterOnElement("locationConfirmButton");

        homePageObject.clickOnElement("searchBar");
        homePageObject.verifyElementAfterClick("searchBar");
        homePageObject.enterDataIntoElement("searchProduct");
        homePageObject.verifyElementAfterDataEntry("searchProduct");
        homePageObject.pressEnterOnElement("searchBar");
        homePageObject.verifyElementAfterEnter("searchBar");
        productListingPageObject.verifyPageIsLoaded();
        productListingPageObject.verifyProductsDisplayed();
        productListingPageObject.clickOnElement("firstProduct");
        productListingPageObject.verifyElementAfterClick("firstProduct");
        productListingPageObject.switchToWindowAtIndex(1);
        productListingPageObject.verifyPageIsLoaded();
        productListingPageObject.captureScreenshotAndLog("TC54_ProductDetail");
    }

    @Test(enabled = true, priority = 7)
    public void test55SearchProductAndVerifyPrices() {
        extentTest = extentReport.createTest("TC_55");

        HomePage homePageObject = new HomePage(webDriver, extentTest);
        ProductListingPage productListingPageObject = new ProductListingPage(webDriver, extentTest);

        homePageObject.clickOnElement("popup");
        homePageObject.verifyElementAfterClick("popup");

        homePageObject.clickOnElement("whereToDeliver");
        homePageObject.verifyElementAfterClick("whereToDeliver");
        homePageObject.clickOnElement("enterLocation");
        homePageObject.verifyElementAfterClick("enterLocation");
        homePageObject.enterDataIntoElement("locationHyderabad");
        homePageObject.verifyElementAfterDataEntry("locationHyderabad");
        homePageObject.clickOnElement("firstLocationSuggestion");
        homePageObject.verifyElementAfterClick("firstLocationSuggestion");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        homePageObject.clickOnElement("locationConfirmButton");
        homePageObject.pressEnterOnElement("locationConfirmButton");

        homePageObject.clickOnElement("searchBar");
        homePageObject.verifyElementAfterClick("searchBar");
        homePageObject.enterDataIntoElement("searchProduct");
        homePageObject.verifyElementAfterDataEntry("searchProduct");
        homePageObject.pressEnterOnElement("searchBar");
        homePageObject.verifyElementAfterEnter("searchBar");
        productListingPageObject.verifySearchResultsPage();
        productListingPageObject.verifyProductsDisplayed();
        productListingPageObject.verifyProductPricesDisplayed();
        productListingPageObject.scrollToElement("productsList");
        productListingPageObject.verifyElementAfterScroll("productsList");
        productListingPageObject.captureScreenshotAndLog("TC55_ProductPrices");
    }

    // Price test case needs to be changed
    @Test(enabled = true, priority = 8)
    public void test56FilterProductsByPriceRange() {
        extentTest = extentReport.createTest("TC_56");

        HomePage homePageObject = new HomePage(webDriver, extentTest);
        ProductListingPage productListingPageObject = new ProductListingPage(webDriver, extentTest);

        homePageObject.clickOnElement("popup");
        homePageObject.verifyElementAfterClick("popup");

        homePageObject.clickOnElement("whereToDeliver");
        homePageObject.verifyElementAfterClick("whereToDeliver");
        homePageObject.clickOnElement("enterLocation");
        homePageObject.verifyElementAfterClick("enterLocation");
        homePageObject.enterDataIntoElement("locationHyderabad");
        homePageObject.verifyElementAfterDataEntry("locationHyderabad");
        homePageObject.clickOnElement("firstLocationSuggestion");
        homePageObject.verifyElementAfterClick("firstLocationSuggestion");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        homePageObject.clickOnElement("locationConfirmButton");
        homePageObject.pressEnterOnElement("locationConfirmButton");

        homePageObject.clickOnElement("searchBar");
        homePageObject.verifyElementAfterClick("searchBar");
        homePageObject.enterDataIntoElement("searchProduct");
        homePageObject.verifyElementAfterDataEntry("searchProduct");
        homePageObject.pressEnterOnElement("searchBar");
        homePageObject.verifyElementAfterEnter("searchBar");
        productListingPageObject.verifyPageIsLoaded();
        productListingPageObject.clickOnElement("priceFilter");
        productListingPageObject.verifyElementAfterClick("priceFilter");
        productListingPageObject.clickOnElement("priceRange500to1000");
        productListingPageObject.verifyElementAfterDataEntry("priceRange");
        productListingPageObject.clickOnElement("applyFilter");
        productListingPageObject.verifyElementAfterClick("applyFilter");
        productListingPageObject.verifyProductsDisplayed();
        productListingPageObject.captureScreenshotAndLog("TC56_PriceFilter");
    }

    // Error: Confirm button not pressed, but passed
    @Test(enabled = true, priority = 9)
    public void test57SearchProductsBasedOnSelectedDeliveryLocation() {
        extentTest = extentReport.createTest("TC_57");

        HomePage homePageObject = new HomePage(webDriver, extentTest);
        ProductListingPage productListingPageObject = new ProductListingPage(webDriver, extentTest);

        homePageObject.clickOnElement("popup");
        homePageObject.verifyElementAfterClick("popup");
        homePageObject.clickOnElement("whereToDeliver");
        homePageObject.verifyElementAfterClick("whereToDeliver");
        homePageObject.clickOnElement("enterLocation");
        homePageObject.verifyElementAfterClick("enterLocation");
        homePageObject.enterDataIntoElement("locationHyderabad");
        homePageObject.verifyElementAfterDataEntry("locationHyderabad");
        homePageObject.clickOnElement("firstLocationSuggestion");
        homePageObject.verifyElementAfterClick("firstLocationSuggestion");
        homePageObject.clickOnElement("locationConfirmButton");
        homePageObject.pressEnterOnElement("locationConfirmButton");
        // try {
        //     Thread.sleep(2000);
        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        homePageObject.verifyElementAfterClick("locationConfirmButton");
        homePageObject.clickOnElement("searchBar");
        homePageObject.verifyElementAfterClick("searchBar");
        homePageObject.enterDataIntoElement("searchProduct");
        homePageObject.verifyElementAfterDataEntry("searchProduct");
        homePageObject.pressEnterOnElement("searchBar");
        homePageObject.verifyElementAfterEnter("searchBar");
        productListingPageObject.verifySearchResultsPage();
        productListingPageObject.verifyProductsDisplayed();
        productListingPageObject.verifyDeliveryAvailabilityForLocation();
        productListingPageObject.captureScreenshotAndLog("TC57_DeliveryLocation");
    }

    @Test(enabled = true, priority = 10)
    public void test58VerifySuccessfulFormSubmissionWithAllValidInputs() {
        extentTest = extentReport.createTest("TC_58");

        HomePage homePageObject = new HomePage(webDriver, extentTest);
        ContactUsPage contactUsPageObject = new ContactUsPage(webDriver, extentTest);

        homePageObject.clickOnElement("popup");
        homePageObject.verifyElementAfterClick("popup");
        homePageObject.clickOnElement("corporate");
        homePageObject.clickOnElement("corporateContactUs");
        contactUsPageObject.verifyContactUsFormVisible();
        contactUsPageObject.enterDataIntoElement("name");
        contactUsPageObject.verifyElementAfterDataEntry("name");
        contactUsPageObject.enterDataIntoElement("email");
        contactUsPageObject.verifyElementAfterDataEntry("email");
        contactUsPageObject.enterDataIntoElement("phone");
        contactUsPageObject.verifyElementAfterDataEntry("phone");
        contactUsPageObject.clickOnElement("messageField");
        contactUsPageObject.verifyElementAfterClick("messageField");
        contactUsPageObject.enterDataIntoElement("message");
        contactUsPageObject.verifyElementAfterDataEntry("message");
        contactUsPageObject.clickOnElement("submit");
        contactUsPageObject.verifySuccessMessage();
        contactUsPageObject.captureScreenshotAndLog("TC58_ValidForm");
    }

    //works but contact from sometimes comes
    @Test(enabled = true, priority = 11)
    public void test59VerifyFormSubmissionFailsWhenAllFieldsAreEmpty() {
        extentTest = extentReport.createTest("TC_59");

        HomePage homePageObject = new HomePage(webDriver, extentTest);
        ContactUsPage contactUsPageObject = new ContactUsPage(webDriver, extentTest);

        homePageObject.clickOnElement("popup");
        homePageObject.verifyElementAfterClick("popup");
        homePageObject.clickOnElement("corporate");
        homePageObject.clickOnElement("corporateContactUs");
        contactUsPageObject.verifyContactUsFormVisible();
        contactUsPageObject.clickOnElement("submit");
        contactUsPageObject.verifyElementText("nameRequired");
        contactUsPageObject.verifyElementText("invalidEmail");
        contactUsPageObject.verifyElementText("invalidMobile");
        contactUsPageObject.verifyElementText("messageRequired");
        //contactUsPageObject.verifyFormNotSubmitted();
        contactUsPageObject.captureScreenshotAndLog("TC59_EmptyForm");
    }

    @Test(enabled = true, priority = 12)
    public void test60VerifyValidationForInvalidEmailFormat() {
        extentTest = extentReport.createTest("TC_60");

        HomePage homePageObject = new HomePage(webDriver, extentTest);
        ContactUsPage contactUsPageObject = new ContactUsPage(webDriver, extentTest);

        homePageObject.clickOnElement("popup");
        homePageObject.verifyElementAfterClick("popup");
        homePageObject.clickOnElement("corporate");
        homePageObject.clickOnElement("corporateContactUs");
        contactUsPageObject.verifyContactUsFormVisible();
        contactUsPageObject.enterDataIntoElement("name");
        contactUsPageObject.verifyElementAfterDataEntry("name");
        contactUsPageObject.enterDataIntoElement("invalidEmail");
        contactUsPageObject.verifyElementAfterDataEntry("invalidEmail");
        contactUsPageObject.enterDataIntoElement("phone");
        contactUsPageObject.verifyElementAfterDataEntry("phone");
        contactUsPageObject.clickOnElement("messageField");
        contactUsPageObject.verifyElementAfterClick("messageField");
        contactUsPageObject.enterDataIntoElement("message");
        contactUsPageObject.verifyElementAfterDataEntry("message");
        contactUsPageObject.clickOnElement("submit");
        contactUsPageObject.verifyElementText("invalidEmail");
        //contactUsPageObject.verifyFormNotSubmitted();
        contactUsPageObject.captureScreenshotAndLog("TC60_InvalidEmail");
    }

    @Test(enabled = true, priority = 13)
    public void test61VerifyPhoneValidationFor11DigitNumber() {
        extentTest = extentReport.createTest("TC_61");

        HomePage homePageObject = new HomePage(webDriver, extentTest);
        ContactUsPage contactUsPageObject = new ContactUsPage(webDriver, extentTest);

        homePageObject.clickOnElement("popup");
        homePageObject.verifyElementAfterClick("popup");
        homePageObject.clickOnElement("corporate");
        homePageObject.clickOnElement("corporateContactUs");
        contactUsPageObject.verifyContactUsFormVisible();
        contactUsPageObject.enterDataIntoElement("name");
        contactUsPageObject.verifyElementAfterDataEntry("name");
        contactUsPageObject.enterDataIntoElement("email");
        contactUsPageObject.verifyElementAfterDataEntry("email");
        contactUsPageObject.enterDataIntoElement("phone11Digit");
        contactUsPageObject.verifyElementAfterDataEntry("phone11Digit");
        contactUsPageObject.clickOnElement("messageField");
        contactUsPageObject.verifyElementAfterClick("messageField");
        contactUsPageObject.enterDataIntoElement("message");
        contactUsPageObject.verifyElementAfterDataEntry("message");
        contactUsPageObject.clickOnElement("submit");
        contactUsPageObject.verifyElementText("invalidMobile");
        //contactUsPageObject.verifyFormNotSubmitted();
        contactUsPageObject.captureScreenshotAndLog("TC61_11DigitPhone");
    }

    @Test(enabled = true, priority = 14)
    public void test62VerifyPhoneValidationFor9DigitNumber() {
        extentTest = extentReport.createTest("TC_62");

        HomePage homePageObject = new HomePage(webDriver, extentTest);
        ContactUsPage contactUsPageObject = new ContactUsPage(webDriver, extentTest);

        homePageObject.clickOnElement("popup");
        homePageObject.verifyElementAfterClick("popup");
        homePageObject.clickOnElement("corporate");
        homePageObject.clickOnElement("corporateContactUs");
        contactUsPageObject.verifyContactUsFormVisible();
        contactUsPageObject.enterDataIntoElement("name");
        contactUsPageObject.verifyElementAfterDataEntry("name");
        contactUsPageObject.enterDataIntoElement("email");
        contactUsPageObject.verifyElementAfterDataEntry("email");
        contactUsPageObject.enterDataIntoElement("phone9Digit");
        contactUsPageObject.verifyElementAfterDataEntry("phone9Digit");
        contactUsPageObject.clickOnElement("messageField");
        contactUsPageObject.verifyElementAfterClick("messageField");
        contactUsPageObject.enterDataIntoElement("message");
        contactUsPageObject.verifyElementAfterDataEntry("message");
        contactUsPageObject.clickOnElement("submit");
        contactUsPageObject.verifyElementText("invalidMobile");
        //contactUsPageObject.verifyFormNotSubmitted();
        contactUsPageObject.captureScreenshotAndLog("TC62_9DigitPhone");
    }

    @Test(enabled = true, priority = 15)
    public void test63VerifyFormSubmissionFailsWhenOnlyNameFieldIsEmpty() {
        extentTest = extentReport.createTest("TC_63");

        HomePage homePageObject = new HomePage(webDriver, extentTest);
        ContactUsPage contactUsPageObject = new ContactUsPage(webDriver, extentTest);

        homePageObject.clickOnElement("popup");
        homePageObject.verifyElementAfterClick("popup");
        homePageObject.clickOnElement("corporate");
        homePageObject.clickOnElement("corporateContactUs");
        contactUsPageObject.verifyContactUsFormVisible();
        contactUsPageObject.enterDataIntoElement("email");
        contactUsPageObject.verifyElementAfterDataEntry("email");
        contactUsPageObject.enterDataIntoElement("phone");
        contactUsPageObject.verifyElementAfterDataEntry("phone");
        contactUsPageObject.clickOnElement("messageField");
        contactUsPageObject.verifyElementAfterClick("messageField");
        contactUsPageObject.enterDataIntoElement("message");
        contactUsPageObject.verifyElementAfterDataEntry("message");
        contactUsPageObject.clickOnElement("submit");
        contactUsPageObject.verifyElementText("nameRequired");
        //contactUsPageObject.verifyFormNotSubmitted();
        contactUsPageObject.captureScreenshotAndLog("TC63_NameEmpty");
    }

    //passed, but special charaters not entered
    @Test(enabled = true, priority = 16)
    public void test64VerifyPhoneFieldRejectsAlphabeticAndSpecialCharacters() {
        extentTest = extentReport.createTest("TC_64");

        HomePage homePageObject = new HomePage(webDriver, extentTest);
        ContactUsPage contactUsPageObject = new ContactUsPage(webDriver, extentTest);

        homePageObject.clickOnElement("popup");
        homePageObject.verifyElementAfterClick("popup");
        homePageObject.clickOnElement("corporate");
        homePageObject.clickOnElement("corporateContactUs");
        contactUsPageObject.verifyContactUsFormVisible();
        contactUsPageObject.enterDataIntoElement("name");
        contactUsPageObject.verifyElementAfterDataEntry("name");
        contactUsPageObject.enterDataIntoElement("email");
        contactUsPageObject.verifyElementAfterDataEntry("email");
        contactUsPageObject.clickOnElement("phoneField");
        contactUsPageObject.verifyElementAfterClick("phoneField");
        contactUsPageObject.enterDataIntoElement("phoneSpecialChars");
        contactUsPageObject.verifyElementAfterDataEntry("phoneSpecialChars");
        contactUsPageObject.clickOnElement("messageField");
        contactUsPageObject.verifyElementAfterClick("messageField");
        contactUsPageObject.enterDataIntoElement("message");
        contactUsPageObject.verifyElementAfterDataEntry("message");
        contactUsPageObject.clickOnElement("submit");
        contactUsPageObject.verifyElementText("invalidMobile");
        //contactUsPageObject.verifyFormNotSubmitted();
        contactUsPageObject.captureScreenshotAndLog("TC64_PhoneSpecialChars");
    }

    @AfterMethod
    public void closeBrowser() {
        webDriver.quit();
    }

    @AfterSuite
    public void flushReport() {
        extentReport.flush();
    }
}
