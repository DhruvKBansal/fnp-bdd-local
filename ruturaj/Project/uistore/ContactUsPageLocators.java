package uistore;

import org.openqa.selenium.By;

public class ContactUsPageLocators {

    public static By trackOrder = By.xpath("//a[@href='/info/track-order?promo=contact_us_track']");
    public static By enterOrderNumber = By.xpath("//input[@id='orderNo']");
    public static By enterEmailId = By.xpath("//input[@id='emailid']");
    public static By formTrackOrder = By.xpath("//button[@id='myForm-order']");
    public static By contactUsForm = By.xpath("//div[@class='col-xl-6 col-md-6 col-sm-12']");

    //test5
    public static By invalidOrderMessage = By.xpath("//div[@class='invalidorder']");

    // Contact Us form fields
    public static By nameField = By.xpath("//input[@id='name']");
    public static By emailField = By.xpath("//input[@id='email']");
    public static By phoneField = By.xpath("//input[@id='number']");
    public static By messageField = By.xpath("//textarea[@name='Description']");
    public static By submitButton = By.xpath("//button[@type='submit']");

    // verification locators
    public static By messageFieldVerify = By.xpath("//textarea[@id='message']");
    public static By successMessageVerify = By.xpath("//div[contains(text(),'Thank you')]");
    public static By emailErrorVerify = By.xpath("//p[contains(text(),'valid email')]");
    public static By phoneErrorVerify = By.xpath("//p[contains(text(),'valid')]");
    public static By nameErrorVerify = By.xpath("//p[contains(text(),'required')]");
    public static By messageErrorVerify = By.xpath("//p[contains(text(),'required')]");
}
