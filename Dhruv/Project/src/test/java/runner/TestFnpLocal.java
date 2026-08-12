package runner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.HomePage;
import pages.ProductListingPage;
import pages.ProductDetailsPage;
import pages.VendorEnquiryPage;
import pages.FranchiseEnquiryPage;
import pages.DecorEnquiryPage;
import utils.Base;
import utils.Reporter;
import org.testng.annotations.Listeners;
import utils.ProgressBar;
import utils.VideoRecorder;

@Listeners({ProgressBar.class, VideoRecorder.class})
public class TestFnpLocal extends Base {

    ExtentTest extentTest;
    ExtentReports extentReport;

    @BeforeSuite
    public void initializeReport() {
        extentReport = Reporter.generateExtentReport("FNP_Local_Report");
    }

    @BeforeMethod
    public void launchBrowser() {
        openBrowser();
    }

    /**
     * TC_33: Browse Products Through Header Navigation Menu
     */
    @Test(enabled = true, priority = 1)
    public void test33BrowseProductsThroughHeader() {
        extentTest = extentReport.createTest("TC_33_Browse_Products_Through_Header");
        HomePage homePageObject = new HomePage(webDriver, extentTest);
        ProductListingPage productListingPageObject = new ProductListingPage(webDriver, extentTest);

        // Launch FNP website, wait for homepage load
        homePageObject.verifyPageIsLoaded();
        // Select delivery location
        homePageObject.clickOnElement("popup");
        homePageObject.clickOnElement("whereToDeliver");
        homePageObject.clickOnElement("enterLocation");
        homePageObject.enterDataIntoElement("hyderabad");
        homePageObject.clickOnElement("firstLocationSuggestion");
        homePageObject.clickOnElement("locationConfirmButton");
        homePageObject.verifyElementAfterClick("locationConfirmButton");
        // Press Enter on the continue/confirm button to finalize the location
        homePageObject.pressEnterOnElement("locationConfirmButton");
        homePageObject.verifyElementAfterEnter("locationConfirmButton");
        homePageObject.verifyElementText("hyderabadPinCode");
        // Hover over Flowers category
        homePageObject.hoverOverElement("flowers");
        // Select Roses sub-category
        homePageObject.clickOnElement("rosesSubCategory");
        // Verify product listing page opens
        productListingPageObject.verifyPageIsLoaded();
        productListingPageObject.captureScreenshotAndLog("TC33_Products");
    }

    /**
     * TC_34: Submit Become a Vendor Enquiry Form (Positive)
     */
    @Test(enabled = true, priority = 2)
    public void test34SubmitVendorEnquiryPositive() {
        extentTest = extentReport.createTest("TC_34_Submit_Vendor_Enquiry_Positive");
        HomePage homePageObject = new HomePage(webDriver, extentTest);
        VendorEnquiryPage vendorEnquiryPageObject = new VendorEnquiryPage(webDriver, extentTest);

    homePageObject.verifyPageIsLoaded();
        homePageObject.clickOnElement("popup");
        // Navigate to Become a Vendor page via the More menu
        homePageObject.clickOnElement("moreImage");
        homePageObject.clickOnElement("becomeVendorMenuItem");
        vendorEnquiryPageObject.verifyPageIsLoaded();
        // Enter valid details (row 1 in VendorEnquiry sheet)
        vendorEnquiryPageObject.enterDataIntoElement("name", 1);
        vendorEnquiryPageObject.enterDataIntoElement("mobile", 1);
        vendorEnquiryPageObject.enterDataIntoElement("email", 1);
        vendorEnquiryPageObject.selectOptionFromDropdown("category", "Sweets");
        vendorEnquiryPageObject.enterDataIntoElement("city", 1);
        vendorEnquiryPageObject.enterDataIntoElement("area", 1);
        vendorEnquiryPageObject.enterDataIntoElement("comments", 1);
        vendorEnquiryPageObject.clickOnElement("submitButton");
        vendorEnquiryPageObject.verifySubmissionSuccess();
        vendorEnquiryPageObject.captureScreenshotAndLog("TC34_VendorSuccess");
    }

    /**
     * TC_35: Submit Become a Vendor Enquiry Form with Empty Name (Negative)
     */
    @Test(enabled = false, priority = 3)
    public void test35VendorEnquiryEmptyNameNegative() {
        extentTest = extentReport.createTest("TC_35_Vendor_Enquiry_Empty_Name");
        HomePage homePageObject = new HomePage(webDriver, extentTest);
        VendorEnquiryPage vendorEnquiryPageObject = new VendorEnquiryPage(webDriver, extentTest);

        homePageObject.verifyPageIsLoaded();
        homePageObject.clickOnElement("popup");
        // Navigate to Become a Vendor page via the More menu
        homePageObject.clickOnElement("moreImage");
        homePageObject.clickOnElement("becomeVendorMenuItem");
        vendorEnquiryPageObject.verifyPageIsLoaded();
        // Leave Name blank (row 2), enter other valid data
        vendorEnquiryPageObject.enterDataIntoElement("name", 2);
        vendorEnquiryPageObject.enterDataIntoElement("mobile", 2);
        vendorEnquiryPageObject.enterDataIntoElement("email", 2);
        vendorEnquiryPageObject.selectOptionFromDropdown("category", "Sweets");
        vendorEnquiryPageObject.enterDataIntoElement("city", 2);
        vendorEnquiryPageObject.enterDataIntoElement("area", 2);
        vendorEnquiryPageObject.enterDataIntoElement("comments", 2);
        vendorEnquiryPageObject.clickOnElement("submitButton");
        vendorEnquiryPageObject.verifyValidationError();
        vendorEnquiryPageObject.captureScreenshotAndLog("TC35_VendorEmptyName");
    }

    /**
     * TC_36: Submit Become a Vendor Enquiry Form with Invalid Mobile (Negative)
     */
    @Test(enabled = false, priority = 4)
    public void test36VendorEnquiryInvalidMobileNegative() {
        extentTest = extentReport.createTest("TC_36_Vendor_Enquiry_Invalid_Mobile");
        HomePage homePageObject = new HomePage(webDriver, extentTest);
        VendorEnquiryPage vendorEnquiryPageObject = new VendorEnquiryPage(webDriver, extentTest);

homePageObject.verifyPageIsLoaded();
        homePageObject.clickOnElement("popup");
        // Navigate to Become a Vendor page via the More menu
        homePageObject.clickOnElement("moreImage");
        homePageObject.clickOnElement("becomeVendorMenuItem");
        vendorEnquiryPageObject.verifyPageIsLoaded();
        // Enter 9-digit mobile (row 3)
        vendorEnquiryPageObject.enterDataIntoElement("name", 3);
        vendorEnquiryPageObject.enterDataIntoElement("mobile", 3);
        vendorEnquiryPageObject.enterDataIntoElement("email", 3);
        vendorEnquiryPageObject.selectOptionFromDropdown("category", "Sweets");
        vendorEnquiryPageObject.enterDataIntoElement("city", 3);
        vendorEnquiryPageObject.enterDataIntoElement("area", 3);
        vendorEnquiryPageObject.enterDataIntoElement("comments", 3);
        vendorEnquiryPageObject.clickOnElement("submitButton");
        vendorEnquiryPageObject.verifyValidationError();
        vendorEnquiryPageObject.captureScreenshotAndLog("TC36_VendorInvalidMobile");
    }

    /**
     * TC_37: Submit Become a Franchise Owner Form (Positive)
     */

    //No error
    @Test(enabled = false, priority = 5)
    public void test37SubmitFranchiseOwnerPositive() {
        extentTest = extentReport.createTest("TC_37_Submit_Franchise_Owner_Positive");
        HomePage homePageObject = new HomePage(webDriver, extentTest);
        FranchiseEnquiryPage franchiseEnquiryPageObject = new FranchiseEnquiryPage(webDriver, extentTest);

        homePageObject.verifyPageIsLoaded();
        homePageObject.clickOnElement("popup");
        // Navigate to Start an FNP Franchise page via footer
        homePageObject.clickOnElement("moreImage");
        homePageObject.clickOnElement("footerFranchiseLink");
        franchiseEnquiryPageObject.verifyPageIsLoaded();
        // Enter valid details (row 1)
        franchiseEnquiryPageObject.enterDataIntoElement("name", 1);
        franchiseEnquiryPageObject.enterDataIntoElement("email", 1);
        franchiseEnquiryPageObject.enterDataIntoElement("mobile", 1);
        franchiseEnquiryPageObject.enterDataIntoElement("city", 1);
        franchiseEnquiryPageObject.enterDataIntoElement("query", 1);
        franchiseEnquiryPageObject.selectOptionFromDropdown("neededToKnow", "Flower Shop");
        franchiseEnquiryPageObject.clickOnElement("submitButton");
        franchiseEnquiryPageObject.verifySubmissionSuccess();
        franchiseEnquiryPageObject.captureScreenshotAndLog("TC37_FranchiseSuccess");
    }

    /**
     * TC_38: Submit Franchise Form without Selecting Needed to Know (Negative)
     */

    //form submitted successfully which should not 
    @Test(enabled = false, priority = 6)
    public void test38FranchiseNoDropdownNegative() {
        extentTest = extentReport.createTest("TC_38_Franchise_No_Dropdown");
        HomePage homePageObject = new HomePage(webDriver, extentTest);
        FranchiseEnquiryPage franchiseEnquiryPageObject = new FranchiseEnquiryPage(webDriver, extentTest);

        homePageObject.verifyPageIsLoaded();
        homePageObject.clickOnElement("popup");
        homePageObject.clickOnElement("moreImage");
        homePageObject.clickOnElement("footerFranchiseLink");
        franchiseEnquiryPageObject.verifyPageIsLoaded();
        // Fill without selecting dropdown (row 2)
        franchiseEnquiryPageObject.enterDataIntoElement("name", 2);
        franchiseEnquiryPageObject.enterDataIntoElement("email", 2);
        franchiseEnquiryPageObject.enterDataIntoElement("mobile", 2);
        franchiseEnquiryPageObject.enterDataIntoElement("city", 2);
        franchiseEnquiryPageObject.enterDataIntoElement("query", 2);
        // No dropdown selection
        franchiseEnquiryPageObject.clickOnElement("submitButton");
        franchiseEnquiryPageObject.verifyValidationError();
        franchiseEnquiryPageObject.captureScreenshotAndLog("TC38_FranchiseNoDropdown");
    }

    /**
     * TC_39: Submit Franchise Form with Mobile > 10 digits (Negative)
     */
    //form submitted successfully which should not 
    @Test(enabled = false, priority = 7)
    public void test39FranchiseInvalidMobileNegative() {
        extentTest = extentReport.createTest("TC_39_Franchise_Invalid_Mobile");
        HomePage homePageObject = new HomePage(webDriver, extentTest);
        FranchiseEnquiryPage franchiseEnquiryPageObject = new FranchiseEnquiryPage(webDriver, extentTest);

        homePageObject.verifyPageIsLoaded();
        homePageObject.clickOnElement("popup");
        homePageObject.clickOnElement("moreImage");
        homePageObject.clickOnElement("footerFranchiseLink");
        franchiseEnquiryPageObject.verifyPageIsLoaded();
        // Enter 11-digit mobile (row 3)
        franchiseEnquiryPageObject.enterDataIntoElement("name", 3);
        franchiseEnquiryPageObject.enterDataIntoElement("email", 3);
        franchiseEnquiryPageObject.enterDataIntoElement("mobile", 3);
        franchiseEnquiryPageObject.enterDataIntoElement("city", 3);
        franchiseEnquiryPageObject.enterDataIntoElement("query", 3);
        franchiseEnquiryPageObject.selectOptionFromDropdown("neededToKnow", "Flower Shop");
        franchiseEnquiryPageObject.clickOnElement("submitButton");
        franchiseEnquiryPageObject.verifyValidationError();
        franchiseEnquiryPageObject.captureScreenshotAndLog("TC39_FranchiseInvalidMobile");
    }

    /**
     * TC_40: Submit Decor Service Enquiry from More Menu (Positive)
     */
    //NO success MEssage after form 
    @Test(enabled = false, priority = 8)
    public void test40SubmitDecorEnquiryPositive() {
        extentTest = extentReport.createTest("TC_40_Submit_Decor_Enquiry_Positive");
        HomePage homePageObject = new HomePage(webDriver, extentTest);
        DecorEnquiryPage decorEnquiryPageObject = new DecorEnquiryPage(webDriver, extentTest);

        homePageObject.verifyPageIsLoaded();
        homePageObject.clickOnElement("popup");
        // Navigate to More menu
        homePageObject.clickOnElement("moreImage");
        // Click Birthday/Wedding decor
        decorEnquiryPageObject.clickOnElement("birthdayWeddingDecor");
        decorEnquiryPageObject.verifyPageIsLoaded();
        // Enter valid details (row 1)
        decorEnquiryPageObject.enterDataIntoElement("name", 1);
        decorEnquiryPageObject.enterDataIntoElement("mobile", 1);
        decorEnquiryPageObject.enterDataIntoElement("email", 1);
        decorEnquiryPageObject.selectOptionFromDropdown("budget", "5 - 10 Lacs");
        decorEnquiryPageObject.enterDataIntoElement("eventType", 1);
        decorEnquiryPageObject.enterDataIntoElement("eventDate", 1);
        decorEnquiryPageObject.enterDataIntoElement("location", 1);
        decorEnquiryPageObject.enterDataIntoElement("message", 1);
        decorEnquiryPageObject.clickOnElement("submitButton");
        decorEnquiryPageObject.captureScreenshotAndLog("TC40_DecorSuccess");
    }

    /**
     * TC_41: Submit Decor Service Enquiry with Empty Name (Negative)
     */
    //Validation message is just becoming that field red  but not implemented that 
    @Test(enabled = false, priority = 9)
    public void test41DecorEnquiryEmptyNameNegative() {
        extentTest = extentReport.createTest("TC_41_Decor_Enquiry_Empty_Name");
        HomePage homePageObject = new HomePage(webDriver, extentTest);
        DecorEnquiryPage decorEnquiryPageObject = new DecorEnquiryPage(webDriver, extentTest);

        homePageObject.verifyPageIsLoaded();
        homePageObject.clickOnElement("popup");
        homePageObject.clickOnElement("moreImage");
        decorEnquiryPageObject.clickOnElement("birthdayWeddingDecor");
        decorEnquiryPageObject.verifyPageIsLoaded();
        // Leave Name blank (row 2)
        decorEnquiryPageObject.enterDataIntoElement("name", 2);
        decorEnquiryPageObject.enterDataIntoElement("mobile", 2);
        decorEnquiryPageObject.enterDataIntoElement("email", 2);
        decorEnquiryPageObject.selectOptionFromDropdown("budget", "5 - 10 Lacs");
        decorEnquiryPageObject.enterDataIntoElement("eventType", 2);
        decorEnquiryPageObject.enterDataIntoElement("eventDate", 2);
        decorEnquiryPageObject.enterDataIntoElement("location", 2);
        decorEnquiryPageObject.enterDataIntoElement("message", 2);
        decorEnquiryPageObject.clickOnElement("submitButton");
        decorEnquiryPageObject.verifyValidationError();
        decorEnquiryPageObject.captureScreenshotAndLog("TC41_DecorEmptyName");
    }

    /**
     * TC_42: Submit Decor Service Enquiry with Invalid Mobile (Negative)
     */
    //Form Submiited wihich should not be submitted 
    @Test(enabled = false, priority = 10)
    public void test42DecorEnquiryInvalidMobileNegative() {
        extentTest = extentReport.createTest("TC_42_Decor_Enquiry_Invalid_Mobile");
        HomePage homePageObject = new HomePage(webDriver, extentTest);
        DecorEnquiryPage decorEnquiryPageObject = new DecorEnquiryPage(webDriver, extentTest);

        homePageObject.verifyPageIsLoaded();
        homePageObject.clickOnElement("popup");
        homePageObject.clickOnElement("moreImage");
        decorEnquiryPageObject.clickOnElement("birthdayWeddingDecor");
        decorEnquiryPageObject.verifyPageIsLoaded();
        // Enter 9-digit mobile (row 3)
        decorEnquiryPageObject.enterDataIntoElement("name", 3);
        decorEnquiryPageObject.enterDataIntoElement("mobile", 3);
        decorEnquiryPageObject.enterDataIntoElement("email", 3);
        decorEnquiryPageObject.selectOptionFromDropdown("budget", "5 - 10 Lacs");
        decorEnquiryPageObject.enterDataIntoElement("eventType", 3);
        decorEnquiryPageObject.enterDataIntoElement("eventDate", 3);
        decorEnquiryPageObject.enterDataIntoElement("location", 3);
        decorEnquiryPageObject.enterDataIntoElement("message", 3);
        decorEnquiryPageObject.clickOnElement("submitButton");
        decorEnquiryPageObject.verifyValidationError();
        decorEnquiryPageObject.captureScreenshotAndLog("TC42_DecorInvalidMobile");
    }

    /**
     * TC_43: Search Product Using Header Search Functionality
     */
    //Verified
    @Test(enabled = false, priority = 11)
    public void test43SearchProductUsingHeader() {
        extentTest = extentReport.createTest("TC_43_Search_Product_Using_Header");
        HomePage homePageObject = new HomePage(webDriver, extentTest);
        ProductListingPage productListingPageObject = new ProductListingPage(webDriver, extentTest);
        ProductDetailsPage productDetailsPageObject = new ProductDetailsPage(webDriver, extentTest);

        homePageObject.verifyPageIsLoaded();
        homePageObject.clickOnElement("popup");
          homePageObject.clickOnElement("whereToDeliver");
        homePageObject.clickOnElement("enterLocation");
        homePageObject.enterDataIntoElement("hyderabad");
        homePageObject.clickOnElement("firstLocationSuggestion");
        homePageObject.clickOnElement("locationConfirmButton");
        homePageObject.verifyElementAfterClick("locationConfirmButton");
        homePageObject.pressEnterOnElement("locationConfirmButton");
        homePageObject.verifyElementAfterEnter("locationConfirmButton");
        homePageObject.verifyElementText("hyderabadPinCode");
        homePageObject.clickOnElement("searchBar");
        homePageObject.enterDataIntoElement("searchProduct");
        homePageObject.verifyElementAfterDataEntry("searchProduct");
        homePageObject.clickOnElement("searchSuggestion");
        productListingPageObject.verifyPageIsLoaded();
        productListingPageObject.clickOnElement("firstProduct");
        productListingPageObject.verifyElementAfterClick("firstProduct");
        productListingPageObject.switchToWindowAtIndex(1);
        productDetailsPageObject.captureScreenshotAndLog("TC43_SearchProduct");
    }

    /**
     * TC_44: Filter Products by Delivery Type
     */
    //Verified
    @Test(enabled = false, priority = 12)
    public void test44FilterProductsByDeliveryType() {
        extentTest = extentReport.createTest("TC_44_Filter_Products_By_Delivery_Type");
        HomePage homePageObject = new HomePage(webDriver, extentTest);
        ProductListingPage productListingPageObject = new ProductListingPage(webDriver, extentTest);
        homePageObject.clickOnElement("popup");
        homePageObject.clickOnElement("whereToDeliver");
        homePageObject.clickOnElement("enterLocation");
        homePageObject.enterDataIntoElement("hyderabad");
        homePageObject.clickOnElement("firstLocationSuggestion");
        homePageObject.clickOnElement("locationConfirmButton");
        homePageObject.verifyElementAfterClick("locationConfirmButton");
        homePageObject.pressEnterOnElement("locationConfirmButton");
        homePageObject.verifyElementAfterEnter("locationConfirmButton");
        homePageObject.verifyElementText("hyderabadPinCode");
        homePageObject.clickOnElement("searchBar");
        homePageObject.enterDataIntoElement("searchProduct");
        homePageObject.pressEnterOnElement("searchBar");
        productListingPageObject.verifyPageIsLoaded();
        productListingPageObject.clickOnElement("deliveryTypeFilter");
        // productListingPageObject.verifyElementAfterClick("deliveryTypeFilter");
        productListingPageObject.clickOnElement("nextDayDelivery");
        productListingPageObject.verifyPageIsLoaded();
        productListingPageObject.clickOnElement("firstProduct");
        productListingPageObject.verifyElementAfterClick("firstProduct");
        productListingPageObject.captureScreenshotAndLog("TC44_DeliveryFilter");
    }

    /**
     * TC_45: Add Product to Cart from Homepage Journey
     */
    //Verified
    @Test(enabled = false, priority = 13)
    public void test45AddProductToCart() {
        extentTest = extentReport.createTest("TC_45_Add_Product_To_Cart");
        HomePage homePageObject = new HomePage(webDriver, extentTest);
        ProductListingPage productListingPageObject = new ProductListingPage(webDriver, extentTest);
        ProductDetailsPage productDetailsPageObject = new ProductDetailsPage(webDriver, extentTest);

        homePageObject.verifyPageIsLoaded();
        homePageObject.clickOnElement("popup");
        // Select delivery location
        homePageObject.clickOnElement("whereToDeliver");
        homePageObject.clickOnElement("enterLocation");
        homePageObject.enterDataIntoElement("hyderabad");
        homePageObject.clickOnElement("firstLocationSuggestion");
        homePageObject.clickOnElement("locationConfirmButton");
        homePageObject.pressEnterOnElement("locationConfirmButton");
        // Search for product
        homePageObject.clickOnElement("searchBar");
        homePageObject.enterDataIntoElement("searchProduct");
        homePageObject.pressEnterOnElement("searchBar");
        productListingPageObject.verifyPageIsLoaded();
        // Select product from search results
        productListingPageObject.clickOnElement("secondProduct");
        productListingPageObject.verifyElementAfterClick("secondProduct");
        productListingPageObject.switchToWindowAtIndex(1);
        // Verify product detail page opens
        productDetailsPageObject.verifyPageIsLoaded();
        // Add To Cart
        productDetailsPageObject.clickOnElement("addToCart");
        productDetailsPageObject.verifyElementAfterClick("addToCart");
        // Open cart page
        productDetailsPageObject.clickOnElement("cartIcon");
        productDetailsPageObject.verifyKeywordInPageSource("Red Roses");
        productDetailsPageObject.captureScreenshotAndLog("TC45_Cart");
    }

    /**
     * TC_46: Open Product Details from Homepage Section (Best Sellers)
     */

    @Test(enabled = true, priority = 14)
    public void test46OpenProductDetailsFromHomepage() {
        extentTest = extentReport.createTest("TC_46_Open_Product_Details_Homepage");
        HomePage homePageObject = new HomePage(webDriver, extentTest);
        ProductListingPage productListingPageObject = new ProductListingPage(webDriver, extentTest);
        ProductDetailsPage productDetailsPageObject = new ProductDetailsPage(webDriver, extentTest);

        homePageObject.verifyPageIsLoaded();
        homePageObject.clickOnElement("popup");
        // Scroll to Best Sellers section
        homePageObject.scrollDownToFooter();
        // Select a product from the section
        homePageObject.clickOnElement("bestSellerFirstProduct");
        // Clicking a product opens a new tab; verify that happened
        productListingPageObject.verifyElementAfterClick("firstProduct");
        productListingPageObject.switchToWindowAtIndex(1);
        // Verify product detail page opens
        productDetailsPageObject.verifyPageIsLoaded();
        // Verify product name and price displayed
        productDetailsPageObject.verifyKeywordInPageSource("Red");
        productDetailsPageObject.verifyKeywordInPageSource("Rs");
        // Add To Cart
        productDetailsPageObject.clickOnElement("addToCart");
        productDetailsPageObject.verifyElementAfterClick("addToCart");
        productDetailsPageObject.captureScreenshotAndLog("TC46_ProductDetails");
    }

    /**
     * TC_47: Explore Flowers from Homepage
     */
    @Test(enabled = false, priority = 15)
    public void test47ExploreFlowersFromHomepage() {
        extentTest = extentReport.createTest("TC_47_Explore_Flowers_Homepage");
        HomePage homePageObject = new HomePage(webDriver, extentTest);
        ProductListingPage productListingPageObject = new ProductListingPage(webDriver, extentTest);
        ProductDetailsPage productDetailsPageObject = new ProductDetailsPage(webDriver, extentTest);

        homePageObject.verifyPageIsLoaded();
        homePageObject.clickOnElement("popup");
        // Scroll to pick favourite flower
        homePageObject.scrollDownToFooter();
        // Click on a flower
        homePageObject.clickOnElement("flowerOrchid");
        // Verify flower page opens
        productListingPageObject.verifyPageIsLoaded();
        // Click on Personalise It
        homePageObject.clickOnElement("personaliseIt");
        // Click on Yes
        homePageObject.clickOnElement("personaliseYes");
        // Verify flowers are displayed
        productListingPageObject.verifyPageIsLoaded();
        // Click on the first product
        productListingPageObject.clickOnElement("firstProduct");
        productListingPageObject.verifyElementAfterClick("firstProduct");
        productListingPageObject.switchToWindowAtIndex(1);
        productDetailsPageObject.verifyPageIsLoaded();
        productDetailsPageObject.captureScreenshotAndLog("TC47_ExploreFlowers");
    }

    /**
     * TC_48: Explore Flowers and Verify Sort Functionality
     */
    @Test(enabled = false, priority = 16)
    public void test48ExploreFlowersAndSort() {
        extentTest = extentReport.createTest("TC_48_Explore_Flowers_And_Sort");
        HomePage homePageObject = new HomePage(webDriver, extentTest);
        ProductListingPage productListingPageObject = new ProductListingPage(webDriver, extentTest);
        ProductDetailsPage productDetailsPageObject = new ProductDetailsPage(webDriver, extentTest);

        homePageObject.verifyPageIsLoaded();
        homePageObject.clickOnElement("popup");
        // Scroll to pick favourite flower
        homePageObject.scrollDownToFooter();
        // Click on a flower
        homePageObject.clickOnElement("flowerOrchid");
        // Verify flower page opens
        productListingPageObject.verifyPageIsLoaded();
        // Click on Personalise It -> Yes
        homePageObject.clickOnElement("personaliseIt");
        homePageObject.clickOnElement("personaliseYes");
        // Verify flowers are displayed
        productListingPageObject.verifyPageIsLoaded();
        // Click on Sort By
        productListingPageObject.clickOnElement("sortBy");
        // Select Price: Low to High
        productListingPageObject.clickOnElement("sortPriceLowToHigh");
        // Verify products sorted correctly
        productListingPageObject.verifyPageIsLoaded();
        // Open the first displayed flower product
        productListingPageObject.clickOnElement("firstProduct");
        productListingPageObject.verifyElementAfterClick("firstProduct");
        productListingPageObject.switchToWindowAtIndex(1);
        productDetailsPageObject.verifyPageIsLoaded();
        productDetailsPageObject.captureScreenshotAndLog("TC48_SortedFlowers");
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
