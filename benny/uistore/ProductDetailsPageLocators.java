package uistore;

import org.openqa.selenium.By;

public class ProductDetailsPageLocators {

    public static By giftReceiverLocation = By.xpath("//input[@placeholder='Gift Receiver\\'s Location']");
    public static By giftReceiverLocationClear = By.xpath("//div[@class='absolute inset-y-0 right-0 flex items-center pl-[6px] pr-[12px] cursor-pointer']");
    public static By giftReceiverLocationInput = By.xpath("//input[@id = 'pincode-location-input']");
    public static By giftReceiverLocationSuggestion = By.xpath("//li[@id='list-item-0']");

//    public static By deliveryDateCheckbox = By.xpath("//input[@type='checkbox']");
    public static By addToCart = By.xpath("//button[@class='px-8 h-52 flex w-full h-auto px-32 py-12 items-center gap-2 shrink-0 border border-lightOliveGreen text-fnp-300 justify-center bg-white-900 rounded-lg  ']");
    public static By skipAndContinue = By.xpath("//button[@class='bg-opacity-0 transition-all duration-300 ease-in-out h-full flex w-full h-auto items-center bg-fnp-300 text-white-900 justify-center  rounded-lg  ']");
    public static By viewCart = By.xpath("//button[@aria-label='Cart']");
    public static By invalidLocationError = By.xpath("//*[contains(text(),'Please enter delivery location')]");
    public static By removeCross = By.xpath("//button[@class='mb-auto shrink-0 border-0 bg-transparent p-0']");
    public static By confirmRemove = By.xpath("//*[text()='Yes, Remove']");
    public static By emptyGiftBoxMessage = By.xpath("//*[contains(text(),'Your Gift box is empty')]");

}
