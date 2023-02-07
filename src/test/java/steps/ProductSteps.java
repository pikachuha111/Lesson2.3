package steps;

import baseEntities.BaseStep;
import models.Item;
import org.openqa.selenium.WebDriver;
import steps.pages.ProductPage;

public class ProductSteps extends BaseStep {

    private ProductPage productPage;

    public ProductSteps(WebDriver driver) {
        super(driver);
        productPage = new ProductPage(driver);
    }



    public void addItem(Item item){
        productPage.getItemElement(item).click();

    }


}
