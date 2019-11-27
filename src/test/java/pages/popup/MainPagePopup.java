package pages.popup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class MainPagePopup extends BasePage {
    private final By closeButton = By.className("subscribe-close-header");

    public MainPagePopup(WebDriver driver) {
        super(driver);
    }

    public void clickCloseButton() {
        waitElementToBeClickable(getDriver().findElement(closeButton));
        getDriver().findElement(closeButton).click();
        waitUntilElementNotVisible(getDriver().findElement(closeButton));
    }
}
