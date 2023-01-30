package services;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class WaitsService {
    private WebDriver driver;
    private WebDriverWait wait;

    public WaitsService(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(ReadProperties.timeout()));
    }

    public WaitsService(WebDriver driver, Duration timeout) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeout);
    }

    public WebElement waitForVisibilityBy(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public boolean waitForElementInvisible(WebElement webElement) {
        return wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    public List<WebElement> waitForAllVisibleElementsLocatedBy(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public WebElement waitForExists(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void fluentWaitForElement(By by) {
        Wait<WebDriver> fluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(50))
                .ignoring(NoSuchElementException.class);

        fluent.until(driver -> driver.findElement(by));
    }

    public boolean isFileExist(String filePath) throws InterruptedException {

        File file = new File(filePath); //реализовать через fluentWait т.к. все зависит от скорости инета. А через флюент мы будем проверять, пока файл точно не появится в ситеме!
        int attempts = 0;
        while (!file.exists() && attempts < 4) {
            Thread.sleep(1000);
            attempts++;
        }

        if (attempts == 4 && !file.exists()) {
            file.delete();
            return false;
        } else {
            file.delete();
            return true;
        }
    }
}
