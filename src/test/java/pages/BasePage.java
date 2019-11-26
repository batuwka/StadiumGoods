package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

public class BasePage {
    private final WebDriver driver;
    private final Wait<WebDriver> wait;

    private final By accountButtonHeader = By.xpath("//a[@title='Account']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new FluentWait<>(driver).withMessage("Element was not found").withTimeout(30, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS);
    }

    protected void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        waitUntilElementNotVisible(element);
    }

    protected void waitUntilElementNotVisible(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected void waitUntilElementIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebDriver getDriver() {
        return this.driver;
    }

    public void clickAccountButtonHeader() {
        waitElementToBeClickable(getDriver().findElement(accountButtonHeader));
        getDriver().findElement(accountButtonHeader).click();
    }
}