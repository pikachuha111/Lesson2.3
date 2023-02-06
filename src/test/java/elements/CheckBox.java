package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CheckBox {
    private UIElement uiElement;

    public CheckBox(WebDriver driver, By by) {
        uiElement = new UIElement(driver, by);
    }

    public boolean isSelected() {
        return uiElement.isSelected();
    }

    public void setFlag() {
        if (!uiElement.isSelected()) {
            uiElement.click();
        }
    }

    public void removeFlag() {
        if (uiElement.isSelected()) {
            uiElement.click();
        }
    }

}
