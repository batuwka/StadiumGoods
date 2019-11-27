package pages;

import org.openqa.selenium.WebDriver;
import pages.popup.MainPagePopup;

public class MainPage extends BasePage {

    private Header header;
    private MainPagePopup mainPagePopup;

    public MainPage(WebDriver driver) {
        super(driver);
        this.mainPagePopup = new MainPagePopup(driver);
        this.header = new Header(driver);
    }

    public void closePopup() {
        this.mainPagePopup.clickCloseButton();
    }

    public void clickHeaderMenuButton(int number) {
        System.out.println("number:" + number);
        header.clickMenuButton(number);
    }
}
