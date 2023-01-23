package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {
    private  final static String pagePath = "inventory.html";

    private final By iconProductLocator = By.xpath("//div[@class = 'peek']");
    private final By addToCartSauceLabsOnesieLocator = By.id ("add-to-cart-sauce-labs-onesie");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return iconProductLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getAddToCartSauceLabsOnesieElement() {
        return driver.findElement(addToCartSauceLabsOnesieLocator);
    }
}
