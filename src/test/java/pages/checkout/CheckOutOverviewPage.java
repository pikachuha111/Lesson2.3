package pages.checkout;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import configuration.ReadProperties;
import lombok.Data;

import static com.codeborne.selenide.Selenide.*;

@Data
public class CheckOutOverviewPage extends BasePage {
    private  final static String pagePath = "checkout-step-two.html";
    private SelenideElement finishButtonSelenideElement = $("#finish");


        public void openPageByUrl() {
        open(ReadProperties.getUrl() + pagePath);
    }
}
