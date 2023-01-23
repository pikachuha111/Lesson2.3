package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.ProductPage;
import pages.checkout.CheckOutCompletePage;
import pages.checkout.CheckOutOverviewPage;
import pages.checkout.CheckOutYourInformationPage;

public class CheckOutSteps extends BaseStep {

    private CheckOutYourInformationPage checkOutYourInformationPage;
    private CheckOutOverviewPage checkOutOverviewPage;
    private CheckOutCompletePage checkOutCompletePage;


    public CheckOutSteps(WebDriver driver) {
        super(driver);
        checkOutYourInformationPage = new CheckOutYourInformationPage(driver);
        checkOutOverviewPage = new CheckOutOverviewPage(driver);
        checkOutCompletePage = new CheckOutCompletePage(driver);
    }

    public void fillRequiredFields (String firstName, String lastName, String postCode) {
        checkOutYourInformationPage.getFirstNameFieldLocator().sendKeys(firstName);
       checkOutYourInformationPage.getLastNameFieldLocator().sendKeys(lastName);
       checkOutYourInformationPage.getPostalCodeFieldLocator().sendKeys(postCode);
    }

    public void pressContinueButton() {
        checkOutYourInformationPage.getContinueButtonLocator().click();
    }

    public void pressFinishButton() {
        checkOutOverviewPage.getFinishButtonLocator().click();
    }

    public ProductPage pressBackToHomeButton() {
        checkOutCompletePage.getBackHomeButtonLocator().click();
        return new ProductPage(driver);
    }

}
