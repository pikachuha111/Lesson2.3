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


    public void fillRequiredFields(User user) {
        checkOutYourInformationPage.getFirstNameFieldSelenideElement().setValue(user.getFirstName());
        checkOutYourInformationPage.getLastNameFieldSelenideElement().setValue(user.getLastName());
        checkOutYourInformationPage.getPostalCodeFieldSelenideElement().setValue(user.getPostCode());
    }

    public CheckOutOverviewPage pressContinueButton() {
        checkOutYourInformationPage.getContinueButtonSelenideElement().click();
        return new CheckOutOverviewPage();
    }

    public CheckOutCompletePage pressFinishButton() {
        checkOutOverviewPage.getFinishButtonSelenideElement().click();
        return new CheckOutCompletePage();
    }

    public SelenideElement pressBackToHomeButton() {
        checkOutCompletePage.getBackHomeButtonSelenideElement().click();
        return productPage.getProductsIdentifireSelenideElement();
    }

}
