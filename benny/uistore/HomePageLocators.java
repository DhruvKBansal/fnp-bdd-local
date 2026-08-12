package uistore;

import org.openqa.selenium.By;

public class HomePageLocators {

    public static By popupNoThanks = By.xpath("//button[@id = 'wzrk-cancel']");
    public static By searchBar = By.xpath("//input[@id = 'search_bar']");
    public static By firstProduct = By.xpath("//div[@itemprop='name']");
    public static By corporateIcon = By.xpath("//a[contains(@href,'corporate')]");
    public static By reminderIcon = By.xpath("//span[contains(@class,'reminder')]");

// ===== Select Location popup =====
    public static By whereToDeliver = By.xpath("//div[@class = 'flex items-center gap-2']");
    public static By enterLocation = By.xpath("//input[@id = 'pincode-location-input']");
    public static By locationConfirmButton = By.xpath("//button[@id = 'location-lock-continue-button']");
    public static By locationConfirmButtonEnabled = By.xpath("//button[@id='location-lock-continue-button' and not(@disabled)]");
    public static By firstLocationSuggestion = By.xpath("//li[@id = 'list-item-0']");
    public static By chennaiPinCode = By.xpath("//span[text() = 'Chennai, Tamil Nadu, India, 600003']");
    public static By delhiPinCode = By.xpath("//span[text() = 'Delhi, India, 110085']");
    public static By bangalorePinCode = By.xpath("//span[text() = 'Bangalore, Karnataka, India, 560002']");
    public static By kolkataPinCode = By.xpath("//span[text() = 'Kolkata, West Bengal, India, 700073']");

}
