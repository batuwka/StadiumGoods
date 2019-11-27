package tests.loginpage;

import cloud.stadiumgoods.utils.XLSXDataReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.OverviewPage;
import pages.popup.ReCaptcha;
import tests.BaseTest;

import java.io.IOException;

public class LoginPageTests extends BaseTest {
    private String baseURL;
    private MainPage mainPage;
    private LoginPage loginPage;
    private OverviewPage overviewPage;
    private ReCaptcha reCaptcha;
    private XLSXDataReader xlsxDataReader = new XLSXDataReader();

    @BeforeMethod
    public void beforeLoginPageTestsMethod() {
        this.beforeMethod();
        baseURL = "https://" + System.getProperty("basicAuth.login") + ":" + System.getProperty("basicAuth.pass") + "@stage.stadiumgoods.cloud";

        this.mainPage = new MainPage(driver);
        this.loginPage = new LoginPage(driver);
        this.overviewPage = new OverviewPage(driver);
        this.reCaptcha = new ReCaptcha(driver);

        driver.get(baseURL);

        mainPage.closePopup();
        mainPage.clickAccountButtonHeader();
    }

    @DataProvider
    public Object[][] users() throws IOException {
        return new Object[][]{{xlsxDataReader.getUsername(1), xlsxDataReader.getPassword(1)},
                {xlsxDataReader.getUsername(2), xlsxDataReader.getPassword(2)}};
    }

    @Test(dataProvider = "users")
    public void userIsAbleToLogIn(String login, String pass) throws InterruptedException {
        loginPage.setUsername(login);
        loginPage.setUserPassword(pass);
        loginPage.clickLoginButton();
        if (reCaptcha.reCaptchaIsVisible()) {
            Assert.assertEquals(driver.getTitle(), loginPage.title);
        } else {
            Assert.assertEquals(driver.getTitle(), overviewPage.title);
        }
    }

    @AfterMethod
    public void afterLoginPageTestsMethod() {
        this.afterMethod();
    }
}