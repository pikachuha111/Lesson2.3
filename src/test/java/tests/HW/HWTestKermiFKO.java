package tests.HW;

import factory.BrowsersFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.domsnapshot.model.InlineTextBox;
import org.openqa.selenium.devtools.v85.domsnapshot.model.TextBoxSnapshot;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;

public class HWTestKermiFKO {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowsersFactory browsersFactory = new BrowsersFactory();
        driver = browsersFactory.getDriver();
    }

    @Test
    public void validateIKTCalculator() throws InterruptedException {
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");

        driver.findElement(By.id("el_f_width")).sendKeys("30");
        driver.findElement(By.id("el_f_lenght")).sendKeys("40");

        Select selectRoomType = new Select(driver.findElement(By.id("room_type")));
        Select selectHeatingType = new Select(driver.findElement(By.id("heating_type")));

        selectRoomType.selectByValue("2");
        selectHeatingType.selectByValue("3");

        driver.findElement(By.name("button")).click();

        Assert.assertEquals(driver.findElement(By.id("floor_cable_power")).getAttribute("value"), "76320");
        Assert.assertEquals(driver.findElement(By.id("spec_floor_cable_power")).getAttribute("value"), "64");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
