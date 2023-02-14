package steps;

import pages.CartPage;

public class CartSteps {

    private CartPage cartPage = new CartPage();

    public void goToCheckOutInformationPage() {
        cartPage.getCheckOutButtonSelenideElement().click();
    }

    public String getTextItem() {
        return cartPage.getAddedItemSelenideElement();
    }

}
