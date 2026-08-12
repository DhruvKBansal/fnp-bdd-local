package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WebDriverHelper {
    private WebDriver webDriver;

    public WebDriverHelper(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

public void waitForElementToBeVisible(By elementLocator, int timeoutInSeconds) {
        new WebDriverWait(webDriver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

public void clickOnElement(By elementLocator) {
        WebElement targetElement = webDriver.findElement(elementLocator);
        Highlighter.highlight(webDriver, targetElement);
        targetElement.click();
    }

    public void sendKeysToElement(By elementLocator, String textToEnter) {
        WebElement targetElement = webDriver.findElement(elementLocator);
        Highlighter.highlight(webDriver, targetElement);
        targetElement.sendKeys(textToEnter);
    }

    public String getTextFromElement(By elementLocator) {
        WebElement targetElement = webDriver.findElement(elementLocator);
        Highlighter.highlight(webDriver, targetElement);
        return targetElement.getText();
    }

    public void pressEnterKey(By elementLocator) {
        WebElement targetElement = webDriver.findElement(elementLocator);
        Highlighter.highlight(webDriver, targetElement);
        targetElement.sendKeys(Keys.ENTER);
    }

    public void hoverOverElement(By elementLocator) {
        WebElement targetElement = webDriver.findElement(elementLocator);
        Highlighter.highlight(webDriver, targetElement);
        Actions actions = new Actions(webDriver);
        actions.moveToElement(targetElement).perform();
    }

    public List<WebElement> getElementsByXPath(String xpathValue) {
        return webDriver.findElements(By.xpath(xpathValue));
    }

    public void verifyEquals(String actualValue, String expectedValue) {
        Assert.assertEquals(actualValue, expectedValue);
    }
    
    public void verifyTrue(Boolean condition, String conditionDescription) {
        Assert.assertTrue(condition, conditionDescription);
    }
    
    public void scrollToElement(By elementLocator) {
        WebElement targetElement = webDriver.findElement(elementLocator);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true)", targetElement);
    }
    
    public void scrollDownToFooter(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript("window.scrollBy(0,12000)");
    }

    public void scrollUpToHeader(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript("window.scrollBy(0,-12000)");
    }

public void switchToWindowAtIndex(int windowIndex) {
        // Wait until the expected number of windows/tabs is available before switching.
        new WebDriverWait(webDriver, Duration.ofSeconds(15))
                .until(driver -> driver.getWindowHandles().size() > windowIndex);
        Set<String> windowHandles = webDriver.getWindowHandles();
        ArrayList<String> windowHandlesList = new ArrayList<>(windowHandles);
        webDriver.switchTo().window(windowHandlesList.get(windowIndex));
    }

public void selectOptionFromDropdown(By dropdownLocator, String optionText) {
        WebElement dropdownElement = webDriver.findElement(dropdownLocator);
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(optionText);
    }

    public void waitUntilTitleIs(String expectedTitle, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.titleIs(expectedTitle));
    }

    public boolean isElementDisplayed(By elementLocator) {
        try {
            return webDriver.findElement(elementLocator).isDisplayed();
        } catch (Exception exception) {
            return false;
        }
    }

    public int getWindowCount() {
        try {
            return webDriver.getWindowHandles().size();
        } catch (Exception exception) {
            return 0;
        }
    }
}
