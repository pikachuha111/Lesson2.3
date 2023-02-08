package steps.pages;

import baseEntities.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    private Logger logger = LogManager.getLogger();

    @FindBy(id="user-name")
    public WebElement emailInput;
    @FindBy(id="password")
    public WebElement passwordInput;
    @FindBy(id="login-button")
    public WebElement logInButton;
    @FindBy(className="error-message-container")
    public WebElement errorTextLocator;


    public LoginPage(WebDriver driver) {
        super(driver);
        logger.info("Page Factory has been implemented in the class LoginPage");
    }

    @Override
    protected WebElement getPageIdentifier() {
        return logInButton;
    }




}
