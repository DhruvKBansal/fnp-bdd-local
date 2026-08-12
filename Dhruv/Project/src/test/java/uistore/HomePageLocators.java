package uistore;

import org.openqa.selenium.By;

public class HomePageLocators {

    public static By popupNoThanks = By.xpath("//button[@id = 'wzrk-cancel']");
    public static By whereToDeliver = By.xpath("//div[contains(@class,'flex items-center gap-2')]");
    public static By enterLocation = By.xpath("//input[@id = 'pincode-location-input']");
    public static By locationConfirmButton = By.xpath("//button[@id='location-lock-continue-button' and not(@disabled)]");
    public static By firstLocationSuggestion = By.xpath("//li[@id = 'list-item-0']");
    public static By hyderabadPinCode = By.xpath("//span[contains(text(),'Hyderabad')]");
    public static By searchBar = By.xpath("//input[@id = 'search_bar']");
    public static By searchSuggestion = By.xpath("(//img[@alt = 'search icon' and @loading ='lazy'])[3]");

// Navigation menu items (hover)
    public static By flowersNav = By.xpath("//span[text() = 'Flowers']");
    public static By cakesNav = By.xpath("//span[text() = 'Cakes']");
    public static By plantsNav = By.xpath("//span[text() = 'Plants']");
    public static By moreMenu = By.xpath("//button[contains(@aria-label,'More')]");
    public static By moreImage = By.xpath("//img[@alt = 'More']");
    public static By becomeVendorMenuItem = By.xpath("//span[text() = 'Become a Vendor']");

    // Sub-categories
    public static By rosesSubCategory = By.xpath("//div[text() = 'Roses']");

    // Footer links
    public static By footerVendorLink = By.xpath("//a[contains(text(),'Become a Vendor')]");
    public static By footerMoreLink = By.xpath("//a[contains(text(),'More')]");
    public static By footerFranchiseLink = By.xpath("//span[text() = 'Start an FNP Franchise']");

    // Best Sellers / Homepage sections
    public static By bestSellersSection = By.xpath("//h2[contains(text(),'Best Sellers')]");
    public static By bestSellerFirstProduct = By.xpath("//h2[contains(text(),'Best Sellers')]/ancestor::section//div[contains(@class,'product')][1]");

// Personalise It options
    public static By personaliseItFilter = By.xpath("//span[text()='Personalise It']");
    public static By personaliseYes = By.xpath("//span[text()='Yes']");
    public static By personaliseNo = By.xpath("//span[text()='No']");

    // Flower category on homepage (Orchid)
    public static By flowerOrchid = By.xpath("//h3[contains(text(),'Orchid')]");
}
