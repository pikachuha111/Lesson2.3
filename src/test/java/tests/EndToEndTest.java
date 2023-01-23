package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEndTest extends BaseTest {


    @Test
    public void successfulPurchaseTest() {

        userSteps.logIn();
        productSteps.addToCartaddToCartSauceLabsOnesieItem();
        navigationSteps.navigateToCartPage();
        cartSteps.goToCheckOutInformationPage();
        checkOutSteps.fillRequiredFields("Nikita","Solovev", "220070");
        checkOutSteps.pressContinueButton();
        checkOutSteps.pressFinishButton();
        Assert.assertTrue(checkOutSteps.pressBackToHomeButton().isPageOpened());
    }

}
