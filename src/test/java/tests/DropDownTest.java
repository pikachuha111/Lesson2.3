package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.annotations.Test;
import pages.project.AddTestCaseProjectPage;
import steps.NavigationSteps;

public class DropDownTest extends BaseTest {

    @Test
    public void DropDownTest() throws InterruptedException {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        AddTestCaseProjectPage page = new NavigationSteps(driver).navigateToAddTestCaseProjectPage("1");
        page.getType().selectByText("Test Case (Text)");
        Thread.sleep(2000);
    }
}
