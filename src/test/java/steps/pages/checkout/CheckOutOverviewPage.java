package steps.pages.checkout;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutOverviewPage extends BasePage {
    private  final static String pagePath = "checkout-step-two.html";
    private final By finishButtonLocator = By.id("finish");

    public CheckOutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return finishButtonLocator;
    }

    public WebElement getFinishButtonLocator() {
        return driver.findElement(finishButtonLocator);
    }

}
