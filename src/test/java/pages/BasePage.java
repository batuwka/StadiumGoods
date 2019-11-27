package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {
    private final WebDriver driver;
    private final Wait<WebDriver> wait;
    private int fluentWaitTimeoutSeconds;

    private final By accountButtonHeader = By.xpath("//a[@title='Account']");

    protected static boolean isLegacy = false;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.fluentWaitTimeoutSeconds = 30;
        wait = new FluentWait<>(driver).withMessage("Element was not found").withTimeout(fluentWaitTimeoutSeconds, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS);
    }

    protected void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void waitUntilElementNotVisible(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected void waitUntilElementIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitElementToBeClickable(WebElement element, int seconds) {
        Wait<WebDriver> waitSeconds = new FluentWait<>(driver).withMessage("Element was not found").withTimeout(seconds, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS);
        waitSeconds.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForScriptsCompleted() {
        new WebDriverWait(driver, 15).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    protected WebDriver getDriver() {
        return this.driver;
    }

    public void clickAccountButtonHeader() {
        waitElementToBeClickable(getDriver().findElement(accountButtonHeader));
        getDriver().findElement(accountButtonHeader).click();
    }
}
