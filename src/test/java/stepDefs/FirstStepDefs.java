package stepDefs;

import configuration.ReadProperties;
import factory.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import steps.UserStep;

public class FirstStepDefs {
    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @Given("open browser")
    public void startBrowser() {
        driver = new BrowserFactory().getDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @When("login page is open")
    @Given("step duplicate")
    public void openLoginPage() {
        driver.get(ReadProperties.getUrl());
        loginPage = new LoginPage(driver);
    }

    @Then("username field is display")
    public void isUsernameDisplayed() {
        Assert.assertTrue(loginPage.getEmailInput().isDisplayed());
    }

    @Then("password field is display")
    public void isPasswordDisplayed() {
        Assert.assertTrue(loginPage.getPasswordInput().isDisplayed());
    }

    @But("error is not displayed")
    public boolean isErrorDisplayed() {
        try {
            return loginPage.getErrorTextElement().isDisplayed();
        } catch (TimeoutException ex) {
            return false;
        }
    }

    @When("user {string} with password {string} logged in")
    public void userWithPasswordLoggedIn(String username, String password) {
        UserStep userStep = new UserStep(driver);
        dashboardPage = userStep.loginSuccessful(username, password);
    }

    @Then("title is {string}")
    public void titleIs(String value) {
        Assert.assertEquals(value, dashboardPage.getTitle());
    }

    @And("project id is {int}")
    public void projectIdIs(boolean value) {
        Assert.assertEquals(value, 123);
    }

//    @And("project id is the {boolean}")
//    public void projectIdIsTrue(boolean value) {
//        Assert.assertTrue(value);
//    }

}
