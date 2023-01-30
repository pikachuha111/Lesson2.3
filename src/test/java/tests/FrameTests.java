package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTests extends BaseTest {

    @Test
    public void frameTest() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame("mce_0_ifr");

        Assert.assertEquals(waitsService.waitForExists(By.id("tinymce")).getText().trim(), "Your content goes here.");

        driver.switchTo().defaultContent();
    }
}
