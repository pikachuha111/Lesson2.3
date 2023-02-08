package steps;

import baseEntities.BaseStep;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import steps.pages.CartPage;

public class NavigationSteps  extends BaseStep {
    private Logger logger = LogManager.getLogger();

    public NavigationSteps  (WebDriver driver) {
        super(driver);
    }

    public CartPage navigateToCartPage() {
        logger.info("Chain of invocation has been used here in the class MoreWrappersTest");
        CartPage page = new CartPage(driver);
        page.openPageByUrl();

        return page;
    }
}
