package uistore;

import org.openqa.selenium.By;

public class HomePageLocator {
    public static By popUpAllow = By.xpath("//button[@id = 'wzrk-confirm']");
    public static By hiGuest = By.xpath("(//div[@class = 'flex w-full items-center justify-center '])[3]");
    public static By loginReg = By.xpath("//span[text() = 'Login/Register']");
    public static By email = By.xpath("//input[@id = 'userEmail']");
    public static By countryDropDown = By.xpath("//div[@class ='flex w-full items-center justify-between ']");
    public static By indiaDropDown = By.xpath("(//div[@class ='flex w-full items-center justify-between '])[2]");
    public static By clickContinue = By.xpath("//div[@class = 'text-center not-italic leading-6 text-16 font-600']");
    public static By name = By.xpath("//input[@id = 'userName']");
    public static By number = By.xpath("//input[@id = 'phoneNumber']");
    public static By startGifting = By.xpath("(//div[@class ='flex w-full items-center justify-center '])[6]");
    public static By outsideEmail = By.xpath("//div[@class ='relative flex w-full flex-col flex-wrap']");
    public static By emailWrittenVerify = By.xpath("//input[@value = 'kavya.test3000@gmail.com']");
    public static By nameWrittenVerify = By.xpath("//input[@value = 'Kavya']");
    public static By locWrittenVerify = By.xpath("//div[@class ='text-center not-italic leading-6 text-14 font-600']");
    public static By numberWrittenVerify = By.xpath("//input[@value = '6574839201']");
    public static By otpPageVerify = By.xpath("//p[text() = 'Verify Details']");
    public static By nameInputVerify = By.xpath("//p[text() = 'Please enter your name']");
    public static By numberInputVerify = By.xpath("//p[text() = 'Please enter valid 10 digit mobile no.']");
    public static By emailInputVerify = By.xpath("//p[text() = 'Please enter valid email ID']");
    public static By otpField = By.xpath("//input[@maxlength = '4']");
    public static By verifyOtpButton = By.xpath("//button[contains(text(),'Verify')]");
    public static By incorrectOtpMessage = By.xpath("//p[contains(text(),'Incorrect entry. Please resend OTP')]");
    
}
