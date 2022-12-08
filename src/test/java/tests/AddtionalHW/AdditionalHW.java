package tests.AddtionalHW;

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

public class AdditionalHW {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowsersFactory browsersFactory = new BrowsersFactory();
        driver = browsersFactory.getDriver();
    }

    @Test
    public void validateCalcBy() throws InterruptedException {
        driver.get("https://calc.by/building-calculators/laminate.html");

        Select layingMethodLaminate = new Select(driver.findElement(By.id("laying_method_laminate")));
        layingMethodLaminate.selectByValue("1");

        driver.findElement(By.id("ln_room_id")).clear();
        driver.findElement(By.id("ln_room_id")).sendKeys("500");
        driver.findElement(By.id("wd_room_id")).clear();
        driver.findElement(By.id("wd_room_id")).sendKeys("400");
        driver.findElement(By.id("ln_lam_id")).clear();
        driver.findElement(By.id("ln_lam_id")).sendKeys("2000");
        driver.findElement(By.id("wd_lam_id")).clear();
        driver.findElement(By.id("wd_lam_id")).sendKeys("200");

        driver.findElement(By.id("direction-laminate-id1")).click();
        driver.findElement(By.partialLinkText("Рассчитать")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div[3]/article/section/div[2]/div[3]/div[2]/div[1]")).getText(), "Требуемое количество досок ламината: 53");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div[3]/article/section/div[2]/div[3]/div[2]/div[2]")).getText(), "Количество упаковок ламината: 7");
        Thread.sleep(3000);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
