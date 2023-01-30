package baseEntities;

import configuration.ReadProperties;
import factory.BrowsersFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.WaitsService;
import steps.UserStep;

public class BaseTest {

    protected WebDriver driver;
    protected WaitsService waitsService;
    protected Alert alert;
    protected Actions actions;
    protected JavascriptExecutor js;

    @BeforeMethod
    public void setUp(){
        driver = new BrowsersFactory().getDriver();
        waitsService = new WaitsService(driver);
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
