package uistore;

import org.openqa.selenium.By;

public class ProductDetailsPageLocators {
    public static By addToCart = By.xpath("//div[text()='Add To Cart']");
    public static By buyNow = By.xpath("//div[text()='Buy Now']");
    public static By aboutTheProduct = By.xpath("//p[text()='About the product']");
    public static By description = By.xpath("//button[text()='Description']");
    public static By homeBreadcrumb = By.xpath("//a[text()='Home']");

    // Delivery location on Product Details Page
    public static By pdpWhereToDeliver = By.xpath("//span[contains(text(),'Where to deliver')]");
    public static By pdpCountrySelector = By.id("search-country-button");

    // Country catalog redirection popup
    public static By redirectPopup = By.cssSelector(".modal");
    public static By redirectContinueButton = By.xpath("//button[text()='Continue']");

    // Product unavailability message & recovery options
    public static By unavailabilityMessage = By.cssSelector(".unavailable");
    public static By changeDeliveryPincodeOption = By.xpath("//button[contains(text(),'Change Delivery')]");
    public static By exploreSimilarGiftsOption = By.xpath("//button[contains(text(),'Explore Similar')]");
}
