package pages.checkout;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import static com.codeborne.selenide.Selenide.*;

@Data
public class CheckOutYourInformationPage extends BasePage {
    private  final static String pagePath = "checkout-step-one.html";

    private SelenideElement continueButtonSelenideElement = $("#continue");
    private SelenideElement firstNameFieldSelenideElement = $("#first-name");
    private SelenideElement lastNameFieldSelenideElement = $("#last-name");
    private SelenideElement postalCodeFieldSelenideElement = $("#postal-code");

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

}
