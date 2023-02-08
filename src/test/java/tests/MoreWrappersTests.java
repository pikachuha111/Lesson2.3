package tests;

import Configuration.ReadProperties;
import baseEntities.BaseTest;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import models.Item;
import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MoreWrappersTests extends BaseTest {
    private Logger logger = LogManager.getLogger();

    @Test
    public void loginSuccessfulTest() {
        logger.info("Builder has been used here in the class MoreWrappersTest");

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
        logger.info("Value Object has been used here in the class MoreWrappersTest");

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
