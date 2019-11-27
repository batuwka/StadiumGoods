package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends BasePage {

    private By productMenuButtons = By.xpath("//header//*[@class='nav-primary']/li");

    public Header(WebDriver driver) {
        super(driver);
    }

    protected void clickMenuButton(int number) {
        getDriver().findElements(productMenuButtons).get(number).click();
    }

    protected int getMenuButtonsCount() {
        return getDriver().findElements(productMenuButtons).size();
    }
}
