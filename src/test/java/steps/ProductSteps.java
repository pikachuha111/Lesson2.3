package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import steps.pages.ProductPage;

public class ProductSteps extends BaseStep {

    private ProductPage productPage;

    public ProductSteps(WebDriver driver) {
        super(driver);
        productPage = new ProductPage(driver);
    }

    public void addToCartaddToCartSauceLabsOnesieItem () {
        productPage.getAddToCartSauceLabsOnesieElement().click();
    }


}
