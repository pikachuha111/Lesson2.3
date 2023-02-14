package steps;

import models.Item;
import pages.ProductPage;

public class ProductSteps {

    private ProductPage productPage = new ProductPage();

    public void addItem(Item item){
        productPage.getItemElement(item).click();
    }

}
