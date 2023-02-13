package pages.checkout;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import org.openqa.selenium.*;

import static com.codeborne.selenide.Selenide.*;

@Data
public class CheckOutCompletePage extends BasePage {
    private  final static String pagePath = "checkout-complete.html";
    private SelenideElement backHomeButtonSelenideElement = $("#back-to-products");
    private SelenideElement completeHeaderSelenideElement = $(By.className("complete-text"));


        public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

}
