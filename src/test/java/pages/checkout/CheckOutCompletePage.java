package pages.checkout;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutCompletePage extends BasePage {
    private  final static String pagePath = "checkout-complete.html";
    private final By backHomeButtonLocator = By.id("back-to-products");
    private final By completeHeaderLocator = By.className("complete-text");


    public CheckOutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return completeHeaderLocator;
    }

    public WebElement getBackHomeButtonLocator() {
        return driver.findElement(backHomeButtonLocator);
    }

    //    public void openPageByUrl() {
//        super.openPageByUrl(pagePath);
//    }

}
