package uistore;

import org.openqa.selenium.By;

public class ProductListingLocators {
    public static By pageHeading = By.tagName("h1");
    public static By firstProduct = By.cssSelector("a.flex.h-full.w-full");
    public static By secondProduct = By.xpath("(//a[contains(@class,'h-full')])[2]");
    public static By noResultsMessage = By.className("no-result");
    public static By searchResultsContainer = By.tagName("main");
}
