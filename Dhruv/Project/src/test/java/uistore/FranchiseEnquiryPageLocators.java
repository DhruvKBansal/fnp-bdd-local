package uistore;

import org.openqa.selenium.By;

public class FranchiseEnquiryPageLocators {

    public static By nameField = By.xpath("//input[@id='Last_Name']");
    public static By emailField = By.xpath("//input[@id='Email']");
    public static By mobileField = By.xpath("//input[@id='Mobile']");
    public static By cityField = By.xpath("//input[@id='City']");
    public static By queryField = By.xpath("//textarea[@id='Description']");
    public static By neededToKnowDropdown = By.xpath("//select[@id='LEADCF2']");
    public static By flowerShopOption = By.xpath("//select[@id='LEADCF2']/option[@value='Flower Shop']");
    public static By cakeShopOption = By.xpath("//select[@id='LEADCF2']/option[@value='Cake Shop']");
    public static By submitButton = By.xpath("//input[@id='formsubmit']");
    public static By successMessage = By.xpath("//h1[text() = 'Thank you for contacting us']");
    public static By validationMessage = By.xpath("//div[contains(@class,'error') or contains(@class,'validation')]");
}
