package uistore;

import org.openqa.selenium.By;

public class DecorEnquiryPageLocators {

    public static By moreMenu = By.xpath("//button[contains(@aria-label,'More')]");
    public static By birthdayWeddingDecor = By.xpath("//span[contains(text(),'Birthday') or contains(text(),'Wedding')]");
    public static By decorPageHeading = By.xpath("//h1[contains(text(),'Decor')]");

    public static By nameField = By.xpath("//input[@id = 'name']");
    public static By mobileField = By.xpath("//input[@id = 'mobile']");
    public static By emailField = By.xpath("//input[@id='email-id']");
    public static By budgetDropdown = By.xpath("//select[@id='budget']");
    public static By eventTypeField = By.xpath("//input[@id='eventtype']");
    public static By eventDateField = By.xpath("//input[@id='datepicker']");
    public static By locationField = By.xpath("//input[@id='loc']");
    public static By messageField = By.xpath("//input[@id='msg']");
    public static By submitButton = By.xpath("//input[@id='submit']");
    public static By validationMessage = By.xpath("//div[contains(@class,'error') or contains(@class,'validation')]");
}
