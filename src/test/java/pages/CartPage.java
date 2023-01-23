package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
    private  final static String pagePath = "cart.html";

    private final By checkOutButtonLocator = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return checkOutButtonLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getCheckOutButton() {
        return driver.findElement(checkOutButtonLocator);
    }
}
