package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.project.EditProjectPage;
import steps.NavigationSteps;

public class CheckBoxTest extends BaseTest {

    @Test
    public void checkBoxTest() throws InterruptedException {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        EditProjectPage page = new NavigationSteps(driver).navigateToEditProjectPage("1");
        page.getType().setFlagByText("Show the announcement on the overview page");
        page.getType().unSetFlagById("show_announcement");
        Assert.assertFalse(page.getType().isCheckBoxSelectedById("show_announcement"));
        Thread.sleep(2000);
    }
}
