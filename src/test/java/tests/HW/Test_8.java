package tests.HW;

import Configuration.ReadProperties;
import factory.BrowsersFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_8 {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new BrowsersFactory().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test8() throws InterruptedException {
        driver.get(ReadProperties.getUrl());

        driver.findElement(By.cssSelector("#user-name")).sendKeys(ReadProperties.username());
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(ReadProperties.password());
        driver.findElement(By.xpath("//input[@type='submit' and @class='submit-button btn_action']")).click();
        driver.findElement(By.cssSelector("[name*='bike-light']")).click();
        driver.findElement(By.xpath("//div/a[@class] ")).click();
        Assert.assertEquals(driver.findElement(By.partialLinkText("Bike Light")).getText(), "Sauce Labs Bike Light");
        Assert.assertEquals(driver.findElement(By.cssSelector("[class$=price]")).getText(), "$9.99");

        Thread.sleep(2000);
    }
}
