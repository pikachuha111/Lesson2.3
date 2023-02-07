package steps;

import Configuration.ReadProperties;
import baseEntities.BaseStep;
import models.User;
import org.openqa.selenium.WebDriver;
import steps.pages.LoginPage;
import steps.pages.ProductPage;

public class UserSteps extends BaseStep {
    private LoginPage loginPage;
    private ReadProperties readProperties;

    public UserSteps(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
    }

    public void login(String email, String psw) {
        loginPage.emailInput.sendKeys(email);
        loginPage.passwordInput.sendKeys(psw);
        loginPage.logInButton.click();
    }

    public ProductPage loginSuccessful(User user) {
        return loginSuccessful(user.getUsername(), user.getPassword());
    }

    private ProductPage loginSuccessful(String email, String password) {
        login(email, password);

        return new ProductPage(driver);
    }

}
