package runner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.CorporatePage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductListingPage;
import utils.Base;
import utils.Reporter;

public class TestFNP extends Base {

    ExtentTest extentTest;
    ExtentReports extentReport;

    @BeforeSuite
    public void initializeReport() {
        extentReport = Reporter.generateExtentReport("FNP_Report");
    }

    @BeforeMethod
    public void launchBrowser() {
        openBrowser();
    }

    @Test(enabled = true, priority = 1)//working
    public void test01VerifyAddToCartFlow() {
        extentTest = extentReport.createTest("Test_01_VerifyAddToCartFlow");

        HomePage homePageObject = new HomePage(webDriver, extentTest);
        ProductListingPage productListingPageObject = new ProductListingPage(webDriver, extentTest);
        ProductDetailsPage productDetailsPageObject = new ProductDetailsPage(webDriver, extentTest);

        homePageObject.clickOnElement("popup");
        homePageObject.verifyElementAfterClick("popup"); // verify search bar available
        homePageObject.clickOnElement("whereToDeliver");
        homePageObject.verifyElementAfterClick("whereToDeliver");
        homePageObject.clickOnElement("enterLocation");
        homePageObject.verifyElementAfterClick("enterLocation");
        homePageObject.enterDataIntoElement("delhi");
        homePageObject.verifyElementAfterDataEntry("delhi");
        homePageObject.clickOnElement("firstLocationSuggestion");
        homePageObject.verifyElementAfterClick("firstLocationSuggestion");
        homePageObject.clickOnElement("locationConfirmButtonEnabled");
        //homePageObject.verifyElementAfterClick("locationConfirmButton");
        //homePageObject.pressEnterOnElement("locationConfirmButton");
        //homePageObject.verifyElementAfterEnter("locationConfirmButton");
        homePageObject.clickOnElement("searchBar");
        homePageObject.verifyElementAfterClick("searchBar");
        homePageObject.enterDataIntoElement("searchProduct");
        homePageObject.pressEnterOnElement("searchBar");
        productListingPageObject.verifyProductsAreVisible();
        productListingPageObject.clickOnElement("firstProduct");
        productListingPageObject.verifyElementAfterClick("firstProduct");
        productListingPageObject.switchToWindowAtIndex(1);
        productDetailsPageObject.verifyPageIsLoaded();
        productDetailsPageObject.clickOnElement("giftReceiverLocationClear");
        productDetailsPageObject.verifyElementAfterClick("giftReceiverLocationClear");
        productDetailsPageObject.clickOnElement("giftReceiverLocationInput");
        productDetailsPageObject.verifyElementAfterClick("giftReceiverLocationInput");
        productDetailsPageObject.enterDataIntoElement("giftReceiverLocationInput");
        productDetailsPageObject.clickOnElement("giftReceiverLocationSuggestion"); // verify Add To Cart available
        productDetailsPageObject.verifyPageIsLoaded(); 
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        productDetailsPageObject.clickOnElement("addToCart");
        productDetailsPageObject.verifyElementAfterClick("addToCart");
        productDetailsPageObject.clickOnElement("skipAndContinue");
        productDetailsPageObject.verifyElementAfterClick("skipAndContinue");
        productDetailsPageObject.clickOnElement("viewCart");
        productDetailsPageObject.verifyElementAfterClick("viewCart");
        productDetailsPageObject.captureScreenshotAndLog("Test01_AddToCart");
    }

    @Test(enabled = true, priority = 2)//workingButThrowingFailure
    public void test02VerifyInvalidLocation() {
        extentTest = extentReport.createTest("Test_02_VerifyInvalidLocation");

        HomePage homePageObject = new HomePage(webDriver, extentTest);
        ProductListingPage productListingPageObject = new ProductListingPage(webDriver, extentTest);
        ProductDetailsPage productDetailsPageObject = new ProductDetailsPage(webDriver, extentTest);

        homePageObject.verifyPageIsLoaded();
        homePageObject.clickOnElement("popup");
        homePageObject.verifyElementAfterClick("popup");
        // Handle the Select Location popup before searching
        homePageObject.clickOnElement("whereToDeliver");
        homePageObject.verifyElementAfterClick("whereToDeliver");
        homePageObject.clickOnElement("enterLocation");
        homePageObject.verifyElementAfterClick("enterLocation");
        homePageObject.enterDataIntoElement("chennai");
        homePageObject.verifyElementAfterDataEntry("chennai");
        homePageObject.clickOnElement("firstLocationSuggestion");
        homePageObject.verifyElementAfterClick("firstLocationSuggestion");
        homePageObject.clickOnElement("locationConfirmButtonEnabled");
//        homePageObject.clickOnElement("locationConfirmButton");
//        homePageObject.verifyElementAfterClick("locationConfirmButton");
//        homePageObject.pressEnterOnElement("locationConfirmButton");
//        homePageObject.verifyElementAfterEnter("locationConfirmButton");
        homePageObject.clickOnElement("searchBar");
        homePageObject.enterDataIntoElement("searchProduct");
        homePageObject.pressEnterOnElement("searchBar");
        productListingPageObject.verifyProductsAreVisible();
        productListingPageObject.clickOnElement("firstProduct");
        productListingPageObject.switchToWindowAtIndex(1);
        productDetailsPageObject.verifyPageIsLoaded();
        productDetailsPageObject.clickOnElement("giftReceiverLocationClear");
        productDetailsPageObject.verifyElementAfterClick("giftReceiverLocationClear");
        productDetailsPageObject.clickOnElement("giftReceiverLocationInput");
        productDetailsPageObject.verifyElementAfterClick("giftReceiverLocationInput");
        productDetailsPageObject.enterDataIntoElement("giftReceiverLocationInputInvalid");
        productDetailsPageObject.verifyPageIsLoaded();
        productDetailsPageObject.clickOnElement("addToCart");
        productDetailsPageObject.verifyKeywordInPageSource("Please enter delivery location");
        productDetailsPageObject.captureScreenshotAndLog("Test02_InvalidLocation");
    }

    @Test(enabled = true, priority = 3)//working
    public void test03VerifyRemoveFromCart() {
        extentTest = extentReport.createTest("Test_03_VerifyRemoveFromCart");

        HomePage homePageObject = new HomePage(webDriver, extentTest);
        ProductListingPage productListingPageObject = new ProductListingPage(webDriver, extentTest);
        ProductDetailsPage productDetailsPageObject = new ProductDetailsPage(webDriver, extentTest);

        homePageObject.verifyPageIsLoaded();
        homePageObject.clickOnElement("popup");
        homePageObject.verifyElementAfterClick("popup");
        // Handle the Select Location popup before searching
        homePageObject.clickOnElement("whereToDeliver");
        homePageObject.verifyElementAfterClick("whereToDeliver");
        homePageObject.clickOnElement("enterLocation");
        homePageObject.verifyElementAfterClick("enterLocation");
        homePageObject.enterDataIntoElement("bangalore");
        homePageObject.verifyElementAfterDataEntry("bangalore");
        homePageObject.clickOnElement("firstLocationSuggestion");
        homePageObject.verifyElementAfterClick("firstLocationSuggestion");
        homePageObject.clickOnElement("locationConfirmButtonEnabled");
        homePageObject.verifyElementAfterClick("locationConfirmButton");
        homePageObject.pressEnterOnElement("locationConfirmButton");
        homePageObject.clickOnElement("searchBar");
        homePageObject.enterDataIntoElement("searchProduct");
        homePageObject.pressEnterOnElement("searchBar");
        productListingPageObject.verifyProductsAreVisible();
        productListingPageObject.clickOnElement("firstProduct");
        productListingPageObject.switchToWindowAtIndex(1);
        productDetailsPageObject.verifyPageIsLoaded();
        productDetailsPageObject.clickOnElement("giftReceiverLocation");
        productDetailsPageObject.enterDataIntoElement("giftReceiverLocation");
        productDetailsPageObject.verifyPageIsLoaded(); // verify Add To Cart available
        productDetailsPageObject.clickOnElement("addToCart");
        productDetailsPageObject.clickOnElement("skipAndContinue");
        productDetailsPageObject.clickOnElement("viewCart");
        productDetailsPageObject.clickOnElement("removeCross");
        productDetailsPageObject.clickOnElement("confirmRemove");
        
    }

    @Test(enabled = true, priority = 4)//working
    public void test04VerifyCorporateFormValidSubmit() {
        extentTest = extentReport.createTest("Test_04_CorporateFormValidSubmit");

        HomePage homePageObject = new HomePage(webDriver, extentTest);
        CorporatePage corporatePageObject = new CorporatePage(webDriver, extentTest);

        homePageObject.verifyPageIsLoaded();
        homePageObject.clickOnElement("popup");
        homePageObject.verifyElementAfterClick("popup");
        homePageObject.clickOnElement("corporateIcon");
        //corporatePageObject.verifyPageIsLoaded();
        corporatePageObject.requestACallBackTrigger();
        corporatePageObject.clickOnElement("callbackContactPerson");
        corporatePageObject.enterDataIntoElement("callbackContactPerson");
        corporatePageObject.clickOnElement("callbackContactNumber");
        corporatePageObject.enterDataIntoElement("callbackContactNumber");
        corporatePageObject.clickOnElement("callbackContactEmail");
        corporatePageObject.enterDataIntoElement("callbackContactEmail");
        corporatePageObject.clickOnElement("callbackQuantity");
        corporatePageObject.enterDataIntoElement("callbackQuantity");
        corporatePageObject.clickOnElement("callbackCompanyName");
        corporatePageObject.enterDataIntoElement("callbackCompanyName");
        corporatePageObject.clickOnElement("callbackSubmit");
        // Verify redirect to Thanks page
        corporatePageObject.verifyKeywordInPageSource("Thank");
        corporatePageObject.captureScreenshotAndLog("Test04_ThanksPage");
    }

    @Test(enabled = true, priority = 5)//working
    public void test05VerifyNameEmptyError() {
        extentTest = extentReport.createTest("Test_05_NameEmptyError");

        HomePage homePageObject = new HomePage(webDriver, extentTest);
        CorporatePage corporatePageObject = new CorporatePage(webDriver, extentTest);

        homePageObject.verifyPageIsLoaded();
        homePageObject.clickOnElement("popup");
        homePageObject.verifyElementAfterClick("popup");
        homePageObject.clickOnElement("corporateIcon");
        corporatePageObject.verifyPageIsLoaded();
        corporatePageObject.requestACallBackTrigger();
        corporatePageObject.verifyPageIsLoaded(); 
        corporatePageObject.clickOnElement("callbackSubmit");
        corporatePageObject.verifyInvalidSubmitMessage("Name cannot be empty");
        corporatePageObject.captureScreenshotAndLog("Test05_NameEmptyError");
    }

    @Test(enabled = true, priority = 6)//working
    public void test06VerifyEmailEmptyError() {
        extentTest = extentReport.createTest("Test_06_EmailEmptyError");

        HomePage homePageObject = new HomePage(webDriver, extentTest);
        CorporatePage corporatePageObject = new CorporatePage(webDriver, extentTest);

        homePageObject.verifyPageIsLoaded();
        homePageObject.clickOnElement("popup");
        homePageObject.verifyElementAfterClick("popup");
        homePageObject.clickOnElement("corporateIcon");
        corporatePageObject.verifyPageIsLoaded();
        corporatePageObject.requestACallBackTrigger();
        corporatePageObject.clickOnElement("callbackContactPerson");
        corporatePageObject.enterDataIntoElement("callbackContactPerson");
        corporatePageObject.clickOnElement("callbackContactNumber");
        corporatePageObject.enterDataIntoElement("callbackContactNumber");
        corporatePageObject.clickOnElement("callbackSubmit");
        corporatePageObject.verifyInvalidSubmitMessage("Email Id. cannot be empty");
        corporatePageObject.captureScreenshotAndLog("Test06_EmailEmptyError");
    }

    @Test(enabled = true, priority = 7)//working
    public void test07VerifyPhoneEmptyError() {
        extentTest = extentReport.createTest("Test_07_PhoneEmptyError");

        HomePage homePageObject = new HomePage(webDriver, extentTest);
        CorporatePage corporatePageObject = new CorporatePage(webDriver, extentTest);

        homePageObject.verifyPageIsLoaded();
        homePageObject.clickOnElement("popup");
        homePageObject.verifyElementAfterClick("popup");
        homePageObject.clickOnElement("corporateIcon");
        corporatePageObject.verifyPageIsLoaded();
        corporatePageObject.requestACallBackTrigger();
        corporatePageObject.clickOnElement("callbackContactPerson");
        corporatePageObject.enterDataIntoElement("callbackContactPerson");
        corporatePageObject.clickOnElement("callbackContactEmail");
        corporatePageObject.enterDataIntoElement("callbackContactEmail");
        corporatePageObject.clickOnElement("callbackSubmit");
        corporatePageObject.verifyInvalidSubmitMessage("Phone No. cannot be empty");
        corporatePageObject.captureScreenshotAndLog("Test07_PhoneEmptyError");
    }

    @Test(enabled = true, priority = 8)//working
    public void test08VerifyFullFormValidSubmit() {
        extentTest = extentReport.createTest("Test_08_FullFormValidSubmit");

        HomePage homePageObject = new HomePage(webDriver, extentTest);
        CorporatePage corporatePageObject = new CorporatePage(webDriver, extentTest);

        homePageObject.verifyPageIsLoaded();
        homePageObject.clickOnElement("popup");
        homePageObject.verifyElementAfterClick("popup");
        homePageObject.clickOnElement("corporateIcon");
        corporatePageObject.verifyPageIsLoaded();
        corporatePageObject.requestACallBackTrigger();
        corporatePageObject.clickOnElement("crossIcon");
        corporatePageObject.enterDataIntoElement("giftingFullName");
        corporatePageObject.clickOnElement("giftingCompanyName");
        corporatePageObject.enterDataIntoElement("giftingCompanyName");
        corporatePageObject.clickOnElement("giftingMobileNo");
        corporatePageObject.enterDataIntoElement("giftingMobileNo");
        corporatePageObject.clickOnElement("giftingEmail");
        corporatePageObject.enterDataIntoElement("giftingEmail");
        corporatePageObject.clickOnElement("giftingNeed");
        corporatePageObject.enterDataIntoElement("giftingNeed");
        corporatePageObject.selectOptionFromDropdown("giftingState");
        corporatePageObject.selectOptionFromDropdown("giftingBudget");
        corporatePageObject.clickOnElement("giftingSubmit");
        corporatePageObject.verifyKeywordInPageSource("Thank");
        corporatePageObject.captureScreenshotAndLog("Test08_ThanksPage");
    }

    @Test(enabled = true, priority = 9)//working
    public void test09VerifyFullFormNameEmptyError() {
        extentTest = extentReport.createTest("Test_09_FullFormNameEmptyError");

        HomePage homePageObject = new HomePage(webDriver, extentTest);
        CorporatePage corporatePageObject = new CorporatePage(webDriver, extentTest);

        homePageObject.verifyPageIsLoaded();
        homePageObject.clickOnElement("popup");
        homePageObject.verifyElementAfterClick("popup");
        homePageObject.clickOnElement("corporateIcon");
        corporatePageObject.verifyPageIsLoaded();
        corporatePageObject.requestACallBackTrigger();
        corporatePageObject.clickOnElement("crossIcon");
        corporatePageObject.clickOnElement("giftingSubmit");
        corporatePageObject.verifyInvalidSubmitMessage("Name cannot be empty");
        corporatePageObject.captureScreenshotAndLog("Test09_NameEmptyError");
    }

    @Test(enabled = true, priority = 10)//working
    public void test10VerifyFullFormEmailEmptyError() {
        extentTest = extentReport.createTest("Test_10_FullFormEmailEmptyError");

        HomePage homePageObject = new HomePage(webDriver, extentTest);
        CorporatePage corporatePageObject = new CorporatePage(webDriver, extentTest);

        homePageObject.verifyPageIsLoaded();
        homePageObject.clickOnElement("popup");
        homePageObject.verifyElementAfterClick("popup");
        homePageObject.clickOnElement("corporateIcon");
        corporatePageObject.verifyPageIsLoaded();
        corporatePageObject.clickOnElement("giftingFullName");
        corporatePageObject.manualScroll();
        corporatePageObject.clickOnElement("crossIcon");
        corporatePageObject.enterDataIntoElement("giftingFullName");
        corporatePageObject.clickOnElement("giftingSubmit");
        corporatePageObject.verifyInvalidSubmitMessage("Email Id. cannot be empty");
        corporatePageObject.captureScreenshotAndLog("Test10_EmailEmptyError");
    }

    @Test(enabled = true, priority = 11)//working
    public void test11VerifyFullFormPhoneEmptyError() {
        extentTest = extentReport.createTest("Test_11_FullFormPhoneEmptyError");

        HomePage homePageObject = new HomePage(webDriver, extentTest);
        CorporatePage corporatePageObject = new CorporatePage(webDriver, extentTest);

        homePageObject.verifyPageIsLoaded();
        homePageObject.clickOnElement("popup");
        homePageObject.verifyElementAfterClick("popup");
        homePageObject.clickOnElement("corporateIcon");
        corporatePageObject.verifyPageIsLoaded();
        corporatePageObject.clickOnElement("giftingFullName");
        corporatePageObject.manualScroll();
        corporatePageObject.clickOnElement("crossIcon");
        corporatePageObject.enterDataIntoElement("giftingFullName");
        corporatePageObject.clickOnElement("giftingEmail");
        corporatePageObject.enterDataIntoElement("giftingEmail");
        corporatePageObject.clickOnElement("giftingSubmit");
        corporatePageObject.verifyInvalidSubmitMessage("Phone No. cannot be empty");
        corporatePageObject.captureScreenshotAndLog("Test11_PhoneEmptyError");
    }

    @Test(enabled = true, priority = 12)//working_partially
    public void test12VerifyDownloadCatalogueError() {
        extentTest = extentReport.createTest("Test_12_DownloadCatalogueError");

        HomePage homePageObject = new HomePage(webDriver, extentTest);
        CorporatePage corporatePageObject = new CorporatePage(webDriver, extentTest);

        homePageObject.verifyPageIsLoaded();
        homePageObject.clickOnElement("popup");
        homePageObject.verifyElementAfterClick("popup");
        homePageObject.clickOnElement("corporateIcon");
        corporatePageObject.verifyPageIsLoaded();
        corporatePageObject.requestACallBackTrigger();
        corporatePageObject.clickOnElement("crossIcon");
        corporatePageObject.verifyElementAfterClick("crossIcon");
        corporatePageObject.clickOnElement("downloadCatalogue");
        corporatePageObject.verifyElementAfterClick("downloadCatalogue");
        corporatePageObject.clickOnElement("downloadSubmit");
        //corporatePageObject.verifyInvalidSubmitMessage("Please select an item in the list");
        corporatePageObject.captureScreenshotAndLog("Test12_DownloadCatalogueError");
    }

    @Test(enabled = true, priority = 13)//working
    public void test13VerifyContactPersonEntry() {
        extentTest = extentReport.createTest("Test_13_ContactPersonEntry");

        HomePage homePageObject = new HomePage(webDriver, extentTest);
        CorporatePage corporatePageObject = new CorporatePage(webDriver, extentTest);

        homePageObject.verifyPageIsLoaded();
        homePageObject.clickOnElement("popup");
        homePageObject.verifyElementAfterClick("popup");
        homePageObject.clickOnElement("corporateIcon");
        corporatePageObject.verifyPageIsLoaded();
        corporatePageObject.requestACallBackTrigger();
        corporatePageObject.clickOnElement("crossIcon");
        corporatePageObject.clickOnElement("downloadCatalogue");
        corporatePageObject.clickOnElement("downloadContactPerson");
        corporatePageObject.enterDataIntoElement("downloadContactPerson");
        corporatePageObject.verifyElementAfterDataEntry("downloadContactPerson");
        corporatePageObject.captureScreenshotAndLog("Test13_ContactPerson");
    }

    @Test(enabled = true, priority = 14)//working but work on verify
    public void test14VerifyContactNumberEntry() {
        extentTest = extentReport.createTest("Test_14_ContactNumberEntry");

        HomePage homePageObject = new HomePage(webDriver, extentTest);
        CorporatePage corporatePageObject = new CorporatePage(webDriver, extentTest);

        homePageObject.verifyPageIsLoaded();
        homePageObject.clickOnElement("popup");
        homePageObject.verifyElementAfterClick("popup");
        homePageObject.clickOnElement("corporateIcon");
        corporatePageObject.verifyPageIsLoaded();
        corporatePageObject.requestACallBackTrigger();
        corporatePageObject.clickOnElement("crossIcon");
        corporatePageObject.clickOnElement("downloadCatalogue");
        corporatePageObject.clickOnElement("downloadContactNumber");
        corporatePageObject.enterDataIntoElement("downloadContactNumber");
        corporatePageObject.verifyElementAfterDataEntry("downloadContactNumber");
        corporatePageObject.captureScreenshotAndLog("Test14_ContactNumber");
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
