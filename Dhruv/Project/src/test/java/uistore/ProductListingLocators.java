package uistore;

import org.openqa.selenium.By;

public class ProductListingLocators {

    public static By pageHeading = By.xpath("//h1[@class]");
    public static By firstProduct = By.xpath("//div[@itemprop='name']");
    public static By secondProduct = By.xpath("(//div[@itemprop='name'])[2]");
    public static By sortBy = By.xpath("//span[text() = 'Sort by :']");
    public static By sortRecommended = By.xpath("//span[text() = 'Sort by :']");
    public static By sortNew = By.xpath("//span[@id='New']");
    public static By sortPriceLowToHigh = By.xpath("//span[contains(text(),'Price: Low to High')]");
    public static By sortPriceHighToLow = By.xpath("//span[contains(text(),'Price: High to Low')]");

    // Filters
    public static By deliveryTypeFilter = By.xpath("//span[text()='Delivery']");
    public static By nextDayDelivery = By.xpath("//span[@class='cursor-pointer text-grey-500 text-14 hover:font-600 hover:text-fnp-500' and contains(., 'Next Day')]");
    public static By candyFlowerDelivery = By.xpath("//input[contains(@id,'CANDY_FLOWER')]");
    public static By midnightDelivery = By.xpath("//input[contains(@id,'MIDNIGHT')]");

    // Category filters
    public static By priceFilter = By.xpath("//span[text()='Price']");
    public static By categoryFilter = By.xpath("//span[text()='Category']");
}
