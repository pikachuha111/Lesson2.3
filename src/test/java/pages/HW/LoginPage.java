package pages.HW;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private final By emailInputLocator = By.id("user-name");
    private final By passwordInputLocator = By.cssSelector("#password");
    private final By logInButtonLocator = By.xpath("//div[@id='login-button']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return logInButtonLocator;
    }

    public WebElement getEmailInput() { return driver.findElement(emailInputLocator);}
    public WebElement getPasswordInput() { return driver.findElement(passwordInputLocator);}
    public WebElement getLogInButton() { return driver.findElement(logInButtonLocator);}
}
