package steps;

import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.CartPage;

@Data
public class NavigationSteps {
    private Logger logger = LogManager.getLogger();
    private CartPage page = new CartPage();

    public CartPage navigateToCartPage() {
        logger.info("Chain of invocation has been used here in the class MoreWrappersTest");
        page.openPageByUrl();

        return page;
    }
}
