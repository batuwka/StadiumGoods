package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class OverviewPage extends BasePage {

    private final By logOutButton = By.xpath("//a[contains(text(),'Log Out')]");
    public final String title = "My Account";

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public void pageLoaded() {
        waitElementToBeClickable(getDriver().findElement(logOutButton));
    }
}
