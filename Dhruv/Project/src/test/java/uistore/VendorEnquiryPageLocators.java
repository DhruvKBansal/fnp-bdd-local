package uistore;

import org.openqa.selenium.By;

public class VendorEnquiryPageLocators {

    public static By nameField = By.xpath("//input[@id = 'name']");
    public static By mobileField = By.xpath("//input[@id = 'phone']");
    public static By emailField = By.xpath("//input[@id='email']");
    public static By categoryDropdown = By.xpath("//select[@id = 'allCategories']");
    public static By cityField = By.xpath("//input[@id='city']");
    public static By areaField = By.xpath("//input[@id='area']");
    public static By commentsField = By.xpath("//textarea[@placeholder = 'Comments']");
    public static By submitButton = By.xpath("//input[@id='submit']");
    public static By successMessage = By.xpath("//h4[text() = 'Thanks!']");
    public static By validationMessage = By.xpath("//div[contains(@class,'error') or contains(@class,'validation')]");
}
