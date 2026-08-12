package uistore;

import org.openqa.selenium.By;

public class MyOrdersPageLocators {

    public static By enterEmail = By.xpath("//input[@id='userEmail']");
    public static By continueButton = By.xpath("//button[@type='button']");
    public static By enterName = By.xpath("//input[@id='userName']");
    public static By enterMobileNumber = By.xpath("//input[@id='phoneNumber']");
    public static By startGiftingButton = By.xpath("//div[@class='text-center not-italic leading-6 text-16 font-600']");

    public static By errorMessage = By.xpath("//p[@class='ml-4']");
    public static By startGiftingResult = By.xpath("//p[text()='OTP sent to your mobile number'] | //p[@class='ml-4']");


}
