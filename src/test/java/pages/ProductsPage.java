package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage extends BasePage {

    private Header header;

    private By loadingIcon = By.xpath("//*[@id='loading_mask_loader']/img");

    private By pageHeroHead = By.xpath("//h1");
    private By sortByDropdown = By.xpath("//select[./option[contains(text(),'Price Low to High')]]");

    private By sortByMenu = By.xpath("//*[@id = 'sort_by_chosen']/a");
    private By sortByMenuPriceLowToHigh = By.xpath("//li[contains(text(),'Price Low to High')]");

    private By productPrice = By.xpath("//*[contains(@class,'ProductSummary___StyledBodyText2')]");
    private By productPriceLegacy = By.xpath("//*[contains(@class,'price-box ')]//*[@class = 'price' and not(contains(@data-flow-item-price-attribute,'strikethrough_price'))]");

    private By productsTable = By.xpath("//*[contains(@class,'ProductListingInnerElement')]");


    public ProductsPage(WebDriver driver) {
        super(driver);
        this.header = new Header(driver);
    }

    public void sortByPriceLowToHighSelect() {
        String prodTableClass;
        try {
            waitElementToBeClickable(getDriver().findElement(sortByDropdown), 5);
            prodTableClass = getDriver().findElement(productsTable).getAttribute("class");
            new Select(getDriver().findElement(sortByDropdown)).selectByVisibleText("Price Low to High");
            waitUntilElementIsVisible(getDriver().findElement(By.xpath("//*[contains(@class,'" + prodTableClass + "')]")));
        } catch (Exception e) {
            isLegacy = true;
            waitElementToBeClickable(getDriver().findElement(sortByMenu));
            getDriver().findElement(sortByMenu).click();
            waitElementToBeClickable(getDriver().findElement(sortByMenuPriceLowToHigh));
            scrollToElement(getDriver().findElement(pageHeroHead));
            waitSeconds(1);
            waitElementToBeClickable(getDriver().findElement(sortByMenuPriceLowToHigh));
            getDriver().findElement(sortByMenuPriceLowToHigh).click();
            waitUntilElementNotVisible(getDriver().findElement(loadingIcon));
        }
    }

    public void validateRightOrderOfProductsByPriceLowToHigh() {
        double basePrice = 0;
        List<WebElement> prices;
        if (isLegacy) {
            prices = getDriver().findElements(productPriceLegacy);
        } else {
            prices = getDriver().findElements(productPrice);
        }
        if (prices.size() == 0) {
            waitSeconds(55555);
            throw new InternalError("No prices to compare. env legacy=" + isLegacy);
        }
        for (WebElement price : prices) {
            double productPrice = Double.parseDouble(price.getText().substring(1).replaceAll(",", ""));
            if (productPrice >= basePrice) {
                basePrice = productPrice;
            } else {
                throw new IllegalArgumentException("Price is lover than previous: this price-"
                        + productPrice + " previous price" + basePrice + " Page Title" + getDriver().getTitle());
            }
        }
    }

    public int getHeaderMenuButtonsCount() {
        return header.getMenuButtonsCount();
    }
}
