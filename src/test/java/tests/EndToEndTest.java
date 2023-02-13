package tests;

import baseEntities.BaseTest;
import models.Item;
import models.User;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;

public class EndToEndTest extends BaseTest {

    @Test(groups = "End2EndCase")
    public void End2EndTest() {
        Item item = new Item();
        item.setLocatorValue("add-to-cart-sauce-labs-onesie");
        User userCheckOutCredentials = User.builder()
                .firstName("Nikita")
                .lastName("Solovev")
                .postCode("220070")
                .build();

        userSteps.login();
        productSteps.addItem(item);
        navigationSteps.navigateToCartPage();
        cartSteps.goToCheckOutInformationPage();
        checkOutSteps.fillRequiredFields(userCheckOutCredentials);
        checkOutSteps.pressContinueButton();
        checkOutSteps.pressFinishButton();
        checkOutSteps.pressBackToHomeButton()
                .should(exist);

    }

}
