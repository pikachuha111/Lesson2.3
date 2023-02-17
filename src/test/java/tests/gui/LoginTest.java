package tests.gui;

import configuration.ReadProperties;
import baseEntities.BaseTest;
import io.qameta.allure.*;
import models.UserGUI;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.NavigationSteps;
import pages.project.AddProjectPage;

public class LoginTest extends BaseTest {


    @Test(description = "description")
    @Issue("AQA18-12")
    @TmsLink("TC-001")
    @Description("Description1")
    @Link("https://www.onliner.by")
    @Link(name = "catalog", type = "myLink", url = "https://www.onliner.by")
    @Severity(SeverityLevel.BLOCKER)

    public void loginSuccessfulTest() {
        UserGUI user = new UserGUI.Builder()
                .withEmail(ReadProperties.username())
                .withPassword(ReadProperties.password())
                .build();
        Assert.assertTrue(userStep.loginSuccessful(user)
                .isPageOpened()
        );

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
