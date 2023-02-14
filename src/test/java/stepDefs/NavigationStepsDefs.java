package stepDefs;

import io.cucumber.java.en.And;
import steps.NavigationSteps;

public class NavigationStepsDefs {
    private NavigationSteps navigationSteps;

    @And("navigate to cart page")
    public void navigateToCartPage() {
        navigationSteps = new NavigationSteps();
        navigationSteps.navigateToCartPage();
    }
}
