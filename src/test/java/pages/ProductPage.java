package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import models.Item;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

@Data
public class ProductPage extends BasePage {

    private final static String pagePath = "inventory.html";

    private SelenideElement productsIdentifireSelenideElement = $(withText("Products"));
    private SelenideElement iconProductSelenideElement = $(By.xpath("//div[@class = 'peek']"));
    private SelenideElement addToCartSauceLabsOnesieSelenideElement = $("#add-to-cart-sauce-labs-onesie");

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public SelenideElement getItemElement(Item item) {
        return $("#" + item.getLocatorValue());
    }

}
