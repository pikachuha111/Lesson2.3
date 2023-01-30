package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControlTests extends BaseTest {

    @Test
    public void checkBoxTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement checkBoxElement = waitsService.waitForVisibilityBy(By.xpath("//input[@type = 'checkbox']"));
        checkBoxElement.click();

        waitsService.waitForVisibilityBy(By.xpath("//button[contains(text(), 'Remove')]")).click();

        Assert.assertEquals(waitsService.waitForVisibilityBy(By.id("message")).getText().trim(), "It's gone!");

        Assert.assertTrue(waitsService.waitForElementInvisible(checkBoxElement));
    }

    @Test
    public void elementConditionsTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement inputFieldElement = waitsService.waitForVisibilityBy(By.xpath("//input[@type = 'text']"));
        Assert.assertFalse(inputFieldElement.isEnabled());

        waitsService.waitForVisibilityBy(By.xpath("//button[contains(text(), 'Enable')]")).click();
        Assert.assertEquals(waitsService.waitForVisibilityBy(By.id("message")).getText().trim(), "It's enabled!");
        Assert.assertTrue(inputFieldElement.isEnabled());
    }
}
