package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CartPage;

public class NavigationSteps  extends BaseStep {

    public NavigationSteps  (WebDriver driver) {
        super(driver);
    }

    public CartPage navigateToCartPage() {
        CartPage page = new CartPage(driver);
        page.openPageByUrl();

        return page;
    }
}
