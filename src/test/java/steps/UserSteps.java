package steps;

import Configuration.ReadProperties;
import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class UserSteps extends BaseStep {
    private LoginPage loginPage;
    private ReadProperties readProperties;

    public UserSteps(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
    }

    public void logIn() {
        loginPage.getEmailInput().sendKeys(readProperties.username());
        loginPage.getPasswordInput().sendKeys(readProperties.password());
        loginPage.getLogInButton().click();
    }

}
