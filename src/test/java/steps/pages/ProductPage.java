package steps.pages;

import baseEntities.BasePage;
import models.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    private Logger logger = LogManager.getLogger();
    private  final static String pagePath = "inventory.html";

    @FindBy(xpath = "//div[@class = 'peek']")
    WebElement iconProductLocator;

    public ProductPage(WebDriver driver) {
        super(driver);
        logger.info("Page Factory has been implemented in the class ProductPage");
    }

    @Override
    protected WebElement getPageIdentifier() {
        return iconProductLocator;
    }

    public WebElement getItemElement(Item item) {
        return driver.findElement(By.id(item.getLocatorValue()));
    }
}
