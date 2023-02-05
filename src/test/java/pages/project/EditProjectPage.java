package pages.project;

import baseEntities.BasePage;
import elements.CheckBox;
import elements.RadioButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditProjectPage extends BasePage {
    private String numberOfProject;

    private final static String pagePath = "/index.php?/admin/projects/edit/";

    public EditProjectPage(WebDriver driver, String numberOfProject) {
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

    public CheckBox getType() {
        return new CheckBox(driver, "//*[@class = 'checkbox']//strong/following-sibling::input");
    }
}
