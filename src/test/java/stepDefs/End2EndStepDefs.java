package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import models.Item;
import pages.ProductPage;
import steps.CartSteps;
import steps.CheckOutSteps;
import steps.ProductSteps;
import steps.UserSteps;

import static com.codeborne.selenide.Condition.exist;

public class End2EndStepDefs {
    private UserSteps userSteps;
    private ProductSteps productSteps;
    private CartSteps cartSteps;
    private CheckOutSteps checkOutSteps;
    private ProductPage productPage;
    private Item item;


    @Given("user has logged in")
    public void userHasLoggedIn() {
        userSteps = new UserSteps();
        productSteps = userSteps.login();
    }

    @And("add item to cart {string}")
    public void addItemToCart(String itemLacatorValue) {
        item = new Item();
        item.setLocatorValue(itemLacatorValue);
        productSteps.addItem(item);
    }

    @And("press Checkout button")
    public void pressCheckOutButton() {
        cartSteps = new CartSteps();
        cartSteps.goToCheckOutInformationPage();
    }

    @And("fill required fields {string} {string} {string}")
    public void fillRequiredFields(String firstName, String lastName, String postalCode) {
        checkOutSteps = new CheckOutSteps();
        checkOutSteps.fillRequiredFields(firstName,lastName, postalCode);
    }

    @And("press continue button")
    public void pressContinueButton() {
        checkOutSteps.pressContinueButton();
    }

    @And("press finish button")
    public void pressFinishButton() {
        checkOutSteps.pressFinishButton();
    }

    @And("press backToHome button")
    public void pressBackHomeButton() {
       productPage = checkOutSteps.pressBackToHomeButton();
    }

    @And("product page is open")
    public void isProductPageOpened() {
        productPage.getProductsIdentifireSelenideElement().should(exist);
    }

}
