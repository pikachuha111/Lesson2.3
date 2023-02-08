package steps.pages;

import baseEntities.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    private Logger logger = LogManager.getLogger();
    private  final static String pagePath = "cart.html";

    @FindBy(id="checkout")
    WebElement checkOutButtonLocator;
    @FindBy(className="inventory_item_name")
    WebElement addedItemLocator;

    public CartPage(WebDriver driver) {
        super(driver);
        logger.info("Page Factory has been implemented in the class CartPage");
    }

    @Override
    protected WebElement getPageIdentifier() {
        return  checkOutButtonLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getCheckOutButton() {
        return checkOutButtonLocator;
    }

    public String getAddedItemLocator() {
        return addedItemLocator.getText().trim();
    }
}
