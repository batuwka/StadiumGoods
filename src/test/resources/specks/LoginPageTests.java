import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests {
    public WebDriver driver;
    public String baseURL = "https://stage.stadiumgoods.cloud";

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.navigate().to(baseURL);
    }

    @Test
    public void userIsAbleToLogIn(String login, String pass){

    }

    @Test
    public void userIsUnableToLogIn(String login, String pass){

    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}