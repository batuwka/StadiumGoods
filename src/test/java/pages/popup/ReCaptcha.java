package pages.popup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class ReCaptcha extends BasePage {

    private By reCaptchaIframe = By.xpath("//iframe[contains(@title,'recaptcha')]");

    public ReCaptcha(WebDriver driver) {
        super(driver);
    }

    public boolean reCaptchaIsVisible() {
        try {
            waitUntilElementIsVisible(getDriver().findElement(reCaptchaIframe));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
