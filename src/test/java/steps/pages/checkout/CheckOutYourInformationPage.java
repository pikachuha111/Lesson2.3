package steps.pages.checkout;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutYourInformationPage extends BasePage {
    private  final static String pagePath = "checkout-step-one.html";
    private final By continueButtonLocator = By.id("continue");
    private final By firstNameFieldLocator = By.id("first-name");
    private final By lastNameFieldLocator = By.id("last-name");
    private final By postalCodeFieldLocator = By.id("postal-code");

    public CheckOutYourInformationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return continueButtonLocator;
    }

    public WebElement getFirstNameFieldLocator() {
        return driver.findElement(firstNameFieldLocator);
    }

    public WebElement getLastNameFieldLocator() {
        return driver.findElement(lastNameFieldLocator);
    }

    public WebElement getPostalCodeFieldLocator() {
        return driver.findElement(postalCodeFieldLocator);
    }

    public WebElement getContinueButtonLocator() {
        return driver.findElement(continueButtonLocator);
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }
}
