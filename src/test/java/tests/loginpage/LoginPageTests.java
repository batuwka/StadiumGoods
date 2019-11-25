package tests.loginpage;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.OverviewPage;

import java.util.Date;
import java.util.concurrent.TimeUnit;


public class LoginPageTests {
    private WebDriver driver;
    private String baseURL;
    private MainPage mainPage;
    private LoginPage loginPage;
    private OverviewPage overviewPage;

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");

        final Cookie COOKIE = new Cookie("rCookie", "g2ceakvsot2z9n9xzq28k3ev7lo2", ".stadiumgoods.cloud", "/", new Date(2020, 11, 26));
        final Cookie COOKIE2 = new Cookie("guid", "52375155-0103-3858-abe3-58add8b4d30d", ".steelhousemedia.com", "/", new Date(2020, 11, 26));
        final Cookie COOKIE3 = new Cookie("DUMMY_COOKIE", "DUMMY_VALUE", ".affirm.com", "/", new Date(2020, 11, 26));
        final Cookie COOKIE4 = new Cookie("tracker_device", "090a0a5e-f92a-4b47-84c1-ae9c956ef23d", "stage.stadiumgoods.cloud", "/", new Date(2020, 11, 26));
        final Cookie COOKIE5 = new Cookie("JSESSIONID", "1c74f70bf77c2754", ".nr-data.net", "/", new Date(2020, 11, 26));
        final Cookie COOKIE6 = new Cookie("frontend", "pbsabpappukg3rsrresnks51hv", ".stage.stadiumgoods.cloud", "/", new Date(2020, 11, 26));
        final Cookie COOKIE7 = new Cookie("rt", "\"MTk1MjM6MTU3NDcxODgzMg==\"", ".steelhousemedia.com", "/", new Date(2020, 11, 26));


        baseURL = "https://" + System.getProperty("loginPage.login") + ":" + System.getProperty("loginPage.pass") + "@stage.stadiumgoods.cloud";
        driver = new ChromeDriver();

        this.mainPage = new MainPage(driver);
        this.loginPage = new LoginPage(driver);
        this.overviewPage = new OverviewPage(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1024, 768));

        driver.get(baseURL);
        driver.manage().addCookie(COOKIE);
        driver.manage().addCookie(COOKIE2);
        driver.manage().addCookie(COOKIE3);
        driver.manage().addCookie(COOKIE4);
        driver.manage().addCookie(COOKIE5);
        driver.manage().addCookie(COOKIE6);
        driver.manage().addCookie(COOKIE7);

        mainPage.closePopup();
        mainPage.clickAccountButtonHeader();
    }

    @DataProvider
    public Object[][] firstUser() {
        return new Object[][]{{"qa.automation@test.com", "password1"}};
    }

    @DataProvider
    public Object[][] secondUser() {
        return new Object[][]{{"qa1.automation@test.com", "password1"}};
    }

//    @Test(dataProvider = "firstUser")
//    public void userIsAbleToLogIn(String login, String pass) throws InterruptedException {
//
//        loginPage.setUsername(login);
//        loginPage.setUserPassword(pass);
//        loginPage.clickLoginButton();
//
//        overviewPage.pageLoaded();
//
//        Assert.assertEquals(driver.getTitle(), overviewPage.title);
//
//    }

    @Test(dataProvider = "secondUser")
    public void userIsUnableToLogIn(String login, String pass) throws InterruptedException {
//        Thread.sleep(10000);
        loginPage.setUsername(login);
        loginPage.setUserPassword(pass);
        loginPage.clickLoginButton();

//        Thread.sleep(15000000);

        overviewPage.pageLoaded();

        Assert.assertEquals(driver.getTitle(), overviewPage.title);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}