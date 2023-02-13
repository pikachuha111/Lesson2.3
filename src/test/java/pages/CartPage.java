package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

@Data
public class CartPage extends BasePage {
    private  final static String pagePath = "cart.html";

    SelenideElement checkOutButtonSelenideElement = $("#checkout");
    SelenideElement addedItemSelenideElement = $(By.className("inventory_item_name"));

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }


    public String getAddedItemSelenideElement() {
        return addedItemSelenideElement.getText().trim();
    }
}
