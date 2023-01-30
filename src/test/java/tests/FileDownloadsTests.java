package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FileDownloadsTests extends BaseTest {

    @Test
    public void downloadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");

        WebElement linkElement = waitsService.waitForVisibilityBy(By.linkText("sample.png"));
        linkElement.click();

        String nameFile = linkElement.getText();
        Assert.assertTrue(waitsService.isFileExist(System.getProperty("user.dir") + File.separator + nameFile));
    }
}
