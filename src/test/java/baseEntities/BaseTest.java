package baseEntities;

import configuration.ReadProperties;
import factory.BrowsersFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import services.WaitsService;
import steps.UserStep;
import utils.InvokedListener;
import steps.ProjectSteps;

@Listeners(InvokedListener.class)
public class BaseTest {

    protected WebDriver driver;
    protected UserStep userStep;
    protected WaitsService waitsService;
    protected ProjectSteps projectSteps;

    @BeforeMethod
    public void setUp(ITestContext iTestContext){
        driver = new BrowsersFactory().getDriver();
        waitsService = new WaitsService(driver);
        driver.get(ReadProperties.getUrl());

        iTestContext.setAttribute("driver",driver);

        userStep = new UserStep(driver);
        projectSteps = new ProjectSteps(driver);
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) {
        // Solution - 2: Плохое решение - потому, что Screenshot добавляется в шаг TearDown
        /*
        if (testResult.getStatus() == ITestResult.FAILURE) {
            try {
                byte[] srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                saveScreenshot(srcFile);
            } catch (NoSuchSessionException ex) {

            }
        }
        */
        driver.quit();
    }

}
