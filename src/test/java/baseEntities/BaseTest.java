package baseEntities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;
import steps.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class BaseTest {

    protected NavigationSteps navigationSteps;
    protected CartSteps cartSteps;
    protected UserSteps userSteps;
    protected ProductSteps productSteps;
    protected CheckOutSteps checkOutSteps;

    @BeforeSuite
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = ReadProperties.browserName();
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.timeout = 5000;
        Configuration.fastSetValue = false;

    }

    @BeforeGroups("End2EndCase")
    public void objectInitialization() {
        navigationSteps = new NavigationSteps();
        cartSteps = new CartSteps();
        userSteps = new UserSteps();
        productSteps = new ProductSteps();
        checkOutSteps = new CheckOutSteps();
    }



    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}
