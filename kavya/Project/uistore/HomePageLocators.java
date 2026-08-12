package uistore;

import org.openqa.selenium.By;

public class HomePageLocators {

    // Popup
    public static By popupDismiss = By.id("wzrk-cancel");

    // Newsletter subscription
    public static By newsletterComponent = By.cssSelector("[data-testid='subscription-component']");
    public static By newsletterEmailInput = By.id("subscription-input");
    public static By newsletterSubscribeButton = By.cssSelector("[data-testid='subscription-component'] div.cursor-pointer");
    public static By newsletterSuccessMessage = By.cssSelector("[data-testid='subscription-component'] p.ml-4");

    // Delivery location
    public static By whereToDeliver = By.xpath("//span[text()='Where to deliver?']");
    public static By deliveryModalTitle = By.xpath("//h2[text()='Personalize Your Experience']");
    public static By countrySelectorButton = By.id("search-country-button");
    public static By countryOptionIndia = By.xpath("//span[contains(@class,'text-fnp-500') and text()='India']");
    public static By countryDropdownOptions = By.xpath("//span[contains(@class,'text-fnp-500')]");
    public static By countryDropdownContainer = By.xpath("//span[contains(@class,'text-fnp-500')]");
    public static By countrySelectorDisplayed = By.id("search-country-button");
    public static By locationInput = By.id("pincode-location-input");
    public static By locationConfirmButton = By.xpath("//button[@id='location-lock-continue-button' and not(@disabled)]");
    public static By firstLocationSuggestion = By.id("list-item-0");
    public static By locationValidationMessage = By.cssSelector(".error");

    // Search
    public static By searchBar = By.id("search_bar");
    public static By searchSuggestionItems = By.cssSelector("div.mb-12.flex");
}
