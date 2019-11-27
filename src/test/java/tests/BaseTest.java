package tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        this.driver = new ChromeDriver();

        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        this.driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        this.driver.manage().window().setSize(new Dimension(1280, 840));
    }

    public void afterMethod() {
        this.driver.quit();
    }
}
