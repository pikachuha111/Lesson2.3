package tests;

import Configuration.ReadProperties;
import baseEntities.BaseTest;
import models.Item;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MoreWrappersTests extends BaseTest {

    @Test
    public void loginSuccessfulTest() {
        User user = new User.Builder()
                .withEmail(ReadProperties.username())
                .withPassword(ReadProperties.password())
                .build();
        Assert.assertTrue(userSteps.loginSuccessful(user)
                .isPageOpened()
        );
    }

    @Test
    public void addItemToCart() {
        Item item = new Item();
        item.setLocatorValue("add-to-cart-sauce-labs-onesie");
        item.setItemName("Sauce Labs Onesie");
        User user = new User.Builder()
                .withEmail(ReadProperties.username())
                .withPassword(ReadProperties.password())
                .build();
        userSteps.loginSuccessful(user);
        productSteps.addItem(item);
        navigationSteps.navigateToCartPage();
        Assert.assertEquals(cartSteps.getTextItem(), item.getItemName());
    }
}
