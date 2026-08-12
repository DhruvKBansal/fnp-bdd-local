package uistore;

import org.openqa.selenium.By;

public class HomePageLocators {

    public static By popupNoThanks = By.xpath("//button[@id = 'wzrk-cancel']");
    public static By pinCode = By.xpath("//button[@id = 'wzrk-cancel']");
    public static By profileIcon = By.xpath("//button[@title='Hi Guest']");
    public static By corporate = By.xpath("//div[text()='Corporate']");
    public static By myOrders = By.xpath("//a[@href='/account/my-orders']");
    public static By contactUs = By.xpath("//a[@href='/info/contact-us']");
    public static By searchBar = By.xpath("//input[@id = 'search_bar']");
    public static By searchSuggestions = By.xpath("(//p[text()='red roses'])[2]");
    public static By corporateContactUs = By.xpath("//a[@href='https://www.fnp.com/corporate/contact-us']");

    // location selection
    public static By whereToDeliver = By.xpath("//div[@class = 'flex items-center gap-2']");;
    public static By enterLocation = By.xpath("//input[@id = 'pincode-location-input']");
    public static By locationConfirmButton = By.xpath("//button[@id='location-lock-continue-button' and not(@disabled)]");
    public static By firstLocationSuggestion = By.xpath("//li[@id = 'list-item-0']");
}
