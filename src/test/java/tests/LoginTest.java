package tests;

import configuration.ReadProperties;
import baseEntities.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import steps.NavigationSteps;
import steps.UserStep;
import pages.project.AddProjectPage;

public class LoginTest extends BaseTest {


    //@Test
    public void loginTest() {


        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailInput().sendKeys(ReadProperties.username());
        loginPage.getPasswordInput().sendKeys(ReadProperties.password());
        loginPage.getLogInButton().click();

        Assert.assertTrue(new DashboardPage(driver).isPageOpened());
    }

    @Test(description = "description")
    @Issue("AQA18-12")
    @TmsLink("TC-001")
    @Description("Description1")
    @Link("https://www.onliner.by")
    @Link(name = "catalog", type = "myLink", url = "https://www.onliner.by")
    @Severity(SeverityLevel.BLOCKER)

    public void loginSuccessfulTest() {
        Assert.assertTrue(userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password())
                .isPageOpened()
        );

    }

    @Test
    public void loginIncorrectTest() {
        Assert.assertEquals(
                userStep.loginIncorrect(ReadProperties.username(), "sdfsdfsdf")
                        .getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.1"
        );
    }

    @Test
    public void addProjectTest() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        projectSteps.addProject("WP_01");

        Assert.assertEquals(driver.findElement(By.className("page_title")).getText(),
                "WP_01");
    }

    @Test
    public void radioButtonTest() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        AddProjectPage page = new NavigationSteps(driver).navigateToAddProjectPage();
        page.getType().selectByIndex(1);
        page.getType().selectByValue("3");
        page.getType().selectByText("Use a single repository for all cases (recommended)");
    }
}
