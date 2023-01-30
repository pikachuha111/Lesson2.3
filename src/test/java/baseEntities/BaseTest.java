package baseEntities;

import configuration.ReadProperties;
import factory.BrowsersFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.WaitsService;
import steps.UserStep;

public class BaseTest {

    protected WebDriver driver;
    protected UserStep userStep;
    protected WaitsService waitsService;

    @BeforeMethod
    public void setUp(){
        driver = new BrowsersFactory().getDriver();
        waitsService = new WaitsService(driver);
//        driver.get(ReadProperties.getUrl());

        userStep = new UserStep(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
