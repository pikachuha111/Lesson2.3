package pages;

import baseEntities.BasePage;
import elements.Button;
import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By emailInputLocator = By.id("name");
    private final By passwordInputLocator = By.id("password");
    private final By logInButtonLocator = By.id("button_primary");
    private final By errorTextLocator = By.className("error-text");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return logInButtonLocator;
    }

    public UIElement getEmailInput() { return new UIElement(driver, emailInputLocator);}
    public UIElement getPasswordInput() { return new UIElement(driver, passwordInputLocator);}
    public Button getLogInButton() { return new Button(driver, logInButtonLocator);}
    public UIElement getErrorTextElement() { return new UIElement(driver, errorTextLocator);}


}
