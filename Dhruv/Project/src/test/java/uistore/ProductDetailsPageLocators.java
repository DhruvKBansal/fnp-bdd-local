package uistore;

import org.openqa.selenium.By;

public class ProductDetailsPageLocators {

    public static By addToCart = By.xpath("//div[text() = 'Add To Cart']");
    public static By buyNow = By.xpath("//div[text() = 'Buy Now']");
    public static By productName = By.xpath("//h1[contains(@class,'productName') or contains(@class,'Typography')]");
    public static By productPrice = By.xpath("//span[contains(@class,'price')]");
    public static By aboutTheProduct = By.xpath("//p[text()='About the product']");
    public static By productSubTitle = By.xpath("//div[contains(@class,'subtitle')]");
    public static By cartIcon = By.xpath("//div[@id='cart']");
    public static By cartCount = By.xpath("//div[@id='cart']//span[contains(@class,'count')]");
}
