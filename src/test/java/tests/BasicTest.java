package tests;

import cloud.stadiumgoods.utils.XLSXDataReader;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.MainPage;
import pages.OverviewPage;
import pages.popup.ReCaptcha;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BasicTest {
    protected WebDriver driver;

    public void beforeMethod() throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        this.driver = new ChromeDriver();

        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        this.driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        this.driver.manage().window().setSize(new Dimension(1024, 768));
    }

    public void afterMethod() {
        this.driver.quit();
    }
}
