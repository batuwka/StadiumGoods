package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public final String title = "Customer Login";

    private final By userNameInput = By.name("login[username]");
    private final By userPasswordInput = By.name("login[password]");

    private final By loginButton = By.id("send2");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setUsername(String username){
        for (int i = 1; i <= username.length(); i++) {
            getDriver().findElement(userNameInput).sendKeys(username.substring(i-1,i));
            try {
                Thread.sleep(275);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setUserPassword(String userPass){
        for (int i = 1; i <= userPass.length(); i++) {
            getDriver().findElement(userPasswordInput).sendKeys(userPass.substring(i-1,i));
            try {
                Thread.sleep(95);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void clickLoginButton(){
        waitElementToBeClickable(getDriver().findElement(loginButton));

        focusElement(getDriver().findElement(loginButton));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().findElement(userNameInput).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().findElement(loginButton).click();
    }


}
