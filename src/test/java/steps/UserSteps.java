package steps;

import configuration.ReadProperties;
import models.User;
import pages.LoginPage;
import pages.ProductPage;

public class UserSteps {
    private LoginPage loginPage = new LoginPage();

    public void login(String email, String psw) {
        loginPage.openPageByUrl();
        loginPage.getEmailInputSelenideElement().val(email);
        loginPage.getPasswordInputSelenideElement().val(psw);
        loginPage.getLogInButtonSelenideElement().click();
    }
    public ProductSteps login() {
        loginPage.openPageByUrl();
        loginPage.getEmailInputSelenideElement().val(ReadProperties.username());
        loginPage.getPasswordInputSelenideElement().val(ReadProperties.password());
        loginPage.getLogInButtonSelenideElement().click();
        return new ProductSteps();
    }

    public ProductPage loginSuccessful(User user) {
        return loginSuccessful(user.getUsername(), user.getPassword());
    }

    private ProductPage loginSuccessful(String email, String password) {
        login(email, password);

        return new ProductPage();
    }

}
