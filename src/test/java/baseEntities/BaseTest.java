package baseEntities;

import Configuration.ReadProperties;
import factory.BrowsersFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.*;

public class BaseTest {

    protected WebDriver driver;
    protected UserSteps userSteps;
    protected ProductSteps productSteps;
    protected NavigationSteps navigationSteps;
    protected CartSteps cartSteps;
    protected CheckOutSteps checkOutSteps;

    @BeforeMethod
    public void setUp(){
        driver = new BrowsersFactory().getDriver();
        driver.get(ReadProperties.getUrl());

        userSteps = new UserSteps(driver);
        productSteps = new ProductSteps(driver);
        navigationSteps = new NavigationSteps(driver);
        cartSteps = new CartSteps(driver);
        checkOutSteps = new CheckOutSteps(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
