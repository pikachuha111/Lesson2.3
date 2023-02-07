package steps.pages;

import baseEntities.BasePage;
import models.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    private  final static String pagePath = "inventory.html";

    @FindBy(xpath = "//div[@class = 'peek']")
    WebElement iconProductLocator;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return iconProductLocator;
    }

    public WebElement getItemElement(Item item) {
        return driver.findElement(By.id(item.getLocatorValue()));
    }
}
