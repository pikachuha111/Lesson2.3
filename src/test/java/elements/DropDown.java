package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DropDown {
    private WebDriver driver;
    private UIElement dropDownField;
    private UIElement searchField;
//    private WebElement webElement;
    private List<UIElement> DropDownElementsList;
    private List<String> DropDownItemsTextList;


    public DropDown(WebDriver driver, By attributeNameValue) {
        DropDownElementsList = new ArrayList<>();
        DropDownItemsTextList = new ArrayList<>();

        UIElement templateFieldLocator = new UIElement(driver, attributeNameValue);
        dropDownField = templateFieldLocator.findUIElement(By.tagName("a"));
        searchField = templateFieldLocator.findUIElement(By.tagName("input"));

        for (UIElement element : templateFieldLocator.findUIElements(By.tagName("li"))) {
            DropDownElementsList.add(element);
            DropDownItemsTextList.add(element.getAttribute("innerText").trim());
        }
    }

    public void search(String text) {
        dropDownField.click();
        searchField.sendKeys(text);
    }

    public void selectByText(String text) {
        dropDownField.click();
        DropDownElementsList.get(DropDownItemsTextList.indexOf(text)).click();
    }

}
