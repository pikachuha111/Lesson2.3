package steps;

import com.codeborne.selenide.SelenideElement;
import models.User;
import pages.ProductPage;
import pages.checkout.CheckOutCompletePage;
import pages.checkout.CheckOutOverviewPage;
import pages.checkout.CheckOutYourInformationPage;

public class CheckOutSteps {

    private CheckOutYourInformationPage checkOutYourInformationPage = new CheckOutYourInformationPage();
    private CheckOutOverviewPage checkOutOverviewPage = new CheckOutOverviewPage();
    private CheckOutCompletePage checkOutCompletePage = new CheckOutCompletePage();
    private ProductPage productPage = new ProductPage();


    public void fillRequiredFields(String firstName, String lastName, String postalCode) {
        checkOutYourInformationPage.getFirstNameFieldSelenideElement().setValue(firstName);
        checkOutYourInformationPage.getLastNameFieldSelenideElement().setValue(lastName);
        checkOutYourInformationPage.getPostalCodeFieldSelenideElement().setValue(postalCode);
    }

    public CheckOutOverviewPage pressContinueButton() {
        checkOutYourInformationPage.getContinueButtonSelenideElement().click();
        return new CheckOutOverviewPage();
    }

    public CheckOutCompletePage pressFinishButton() {
        checkOutOverviewPage.getFinishButtonSelenideElement().click();
        return new CheckOutCompletePage();
    }

    public ProductPage pressBackToHomeButton() {
        checkOutCompletePage.getBackHomeButtonSelenideElement().click();
        return new ProductPage();
    }

}
