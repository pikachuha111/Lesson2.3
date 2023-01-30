package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTests extends BaseTest {

    @Test
    public void checkContextMenuAlertTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/context_menu");

        actions
                .contextClick(waitsService.waitForVisibilityBy(By.id("hot-spot")))
                .build()
                .perform();

        alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText().trim(), "You selected a context menu");
        alert.accept();

    }
}
