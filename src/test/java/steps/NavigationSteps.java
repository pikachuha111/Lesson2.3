package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.project.AddProjectPage;
import pages.project.AddTestCaseProjectPage;
import pages.project.EditProjectPage;

public class NavigationSteps extends BaseStep {
    public NavigationSteps(WebDriver driver) {
        super(driver);
    }

    public AddProjectPage navigateToAddProjectPage() {

        AddProjectPage page = new AddProjectPage(driver);
        page.openPageByUrl();

        return page;
    }

    public EditProjectPage navigateToEditProjectPage(String numberOfProject) {

        EditProjectPage page = new EditProjectPage(driver, numberOfProject);
        page.openPageByUrl();

        return page;
    }

    public AddTestCaseProjectPage navigateToAddTestCaseProjectPage(String numberOfProject) {

        AddTestCaseProjectPage page = new AddTestCaseProjectPage(driver, numberOfProject);
        page.openPageByUrl();

        return page;
    }

}
