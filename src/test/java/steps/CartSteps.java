package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CartPage;

public class CartSteps extends BaseStep {

    private CartPage cartPage;

    public CartSteps(WebDriver driver) {
        super(driver);
        cartPage = new CartPage(driver);
    }

    public void goToCheckOutInformationPage () {
        cartPage.getCheckOutButton().click();
    }

}
