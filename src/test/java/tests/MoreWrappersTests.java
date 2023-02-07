package tests;

import Configuration.ReadProperties;
import baseEntities.BaseTest;
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
}
