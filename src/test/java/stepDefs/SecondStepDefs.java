package stepDefs;

import baseEntities.BaseCucumberTest;
import configuration.ReadProperties;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;

public class SecondStepDefs extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;

    public SecondStepDefs(BaseCucumberTest baseCucumberTest){
        this.baseCucumberTest = baseCucumberTest;
    }
    @Then("open settings page")
    public void openSettingsPage() {
        driver.get(ReadProperties.getUrl() + "index.php?/admin/overview");
    }
}
