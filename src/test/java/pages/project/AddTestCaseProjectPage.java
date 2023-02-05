package pages.project;

import baseEntities.BasePage;
import elements.CheckBox;
import elements.DropDown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddTestCaseProjectPage extends BasePage {
    private final String numberOfProject;
    private final By templateFieldLocator = By.id("template_id_chzn");

    private final static String pagePath = "/index.php?/cases/add/";

    public AddTestCaseProjectPage(WebDriver driver, String numberOfProject) {
        super(driver);
        this.numberOfProject = numberOfProject;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath + numberOfProject);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }

    public DropDown getType() {
        return new DropDown(driver, templateFieldLocator);
    }
}
