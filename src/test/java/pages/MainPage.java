package pages;

import org.openqa.selenium.WebDriver;
import pages.popup.MainPagePopup;

public class MainPage extends BasePage {

    MainPagePopup mainPagePopup;

    public MainPage(WebDriver driver) {
        super(driver);
        this.mainPagePopup = new MainPagePopup(driver);
    }

    public void closePopup(){
        this.mainPagePopup.clickCloseButton();
    }
}
