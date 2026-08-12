package uistore;

import org.openqa.selenium.By;

public class ProductListingsPageLocators {

    public static By closeLocationPopUp = By.xpath("//button[@type='button']");
    public static By matchingProductsVerify = By.xpath("//h1[text()='Fresh Red Roses']");
    public static By firstProduct = By.xpath("//div[@class='line-clamp-1 mb-4 text-12 font-500 leading-0 text-fnp-500 md:text-14']");
    public static By pageHeading = By.xpath("//h1[@class]");

    // search results & price verification locators
    public static By searchResultsHeadingVerify = By.xpath("//h1[@class]");
    public static By matchingProductsHeadingVerify = By.xpath("//h1[text()='Fresh Red Roses']");
    public static By productPriceVerify = By.xpath("//div[contains(@class,'text-14 font-600')]");
    public static By productDetailPageVerify = By.xpath("//div[contains(@class,'product-name')]");

    // price range filter locators
    public static By priceFilter = By.xpath("//span[text()='Price']");
    public static By priceRange500to1000 = By.xpath("//label[contains(text(),'₹500 - ₹1000')]");
    public static By applyFilterButton = By.xpath("//button[text()='Apply']");
    public static By filteredResultsVerify = By.xpath("//h1[@class]");

    // Delivery availability based on location
    public static By deliveryAvailabilityVerify = By.xpath("//p[contains(@class,'text-fnp-500')]");
}
