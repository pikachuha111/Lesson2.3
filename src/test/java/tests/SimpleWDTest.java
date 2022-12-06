package tests;

import factory.BrowsersFactory;
import factory.SimpleDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SimpleWDTest {


        @Test
        public void simpleWDTest() {
            SimpleDriver simpleDriver = new SimpleDriver();
            WebDriver driver = simpleDriver.getDriver();
            driver.quit();
        }

    @Test
    public void advancedWDTest() {
        SimpleDriver advancedDriver = new SimpleDriver();
        WebDriver driver = advancedDriver.getDriver();
        driver.quit();
    }

    @Test
    public void browserFactoryWDTest() {
        BrowsersFactory browsersFactory = new BrowsersFactory();
        WebDriver driver = browsersFactory.getDriver();
        driver.quit();
    }
}
