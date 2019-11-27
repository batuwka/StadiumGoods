package tests.rundomproductpage;

import cloud.stadiumgoods.utils.RandomNumberGenerator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProductsPage;
import tests.BaseTest;

import java.io.IOException;

public class RandomProductTests extends BaseTest {
    private String baseURL;
    private MainPage mainPage;
    private RandomNumberGenerator randomNumberGenerator;
    private ProductsPage productsPage;

    @BeforeMethod
    public void beforeRandomProductTestsMethod() throws InterruptedException, IOException {
        this.beforeMethod();
        this.baseURL = "https://" + System.getProperty("basicAuth.login") + ":" + System.getProperty("basicAuth.pass") + "@stage.stadiumgoods.cloud";

        this.mainPage = new MainPage(driver);
        this.productsPage = new ProductsPage(driver);
        this.randomNumberGenerator = new RandomNumberGenerator();

        driver.get(this.baseURL);
        mainPage.closePopup();
    }

    @Test()
    public void userIsAbleChoseRandomProductAndSortByPriceFromLowToHighAndPricesIsInCorrectOrder() {
        //the last page is Journal page without any products
        mainPage.clickHeaderMenuButton(randomNumberGenerator.getRandomNumberInRange(0, 8));
        productsPage.sortByPriceLowToHighSelect();
        productsPage.waitSeconds(2);
        productsPage.waitForScriptsCompleted();
        productsPage.validateRightOrderOfProductsByPriceLowToHigh();
        Assert.assertEquals(productsPage.getHeaderMenuButtonsCount(), 10);
    }

    @AfterMethod
    public void afterRandomProductTestsMethod() {
        this.afterMethod();
    }
}
