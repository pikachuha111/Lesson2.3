package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CheckBox {
    private UIElement uiElement;
    private List<CheckBox> CheckBoxList;
    private List<String> textList;
    private List<String> idList;
    private WebElement webElement;
    private WebDriver driver;


    public CheckBox(WebDriver driver, WebElement webElement) {
        this.driver = driver;
        this.webElement = webElement;
        uiElement = new UIElement(driver, webElement);
    }

    public CheckBox(WebDriver driver, String attributeNameValue) {
        CheckBoxList = new ArrayList<>();
        idList = new ArrayList<>();
        textList = new ArrayList<>();


        for (UIElement uiElement : uiElement.findUIElements(By.xpath(attributeNameValue))) {
            CheckBox element = new CheckBox(driver, uiElement);
            CheckBoxList.add(element);
            idList.add(element.getAttribute("id"));
            textList.add(element.FindCheckBoxElement(By.xpath("parent::*/strong")).getText().trim());
        }
    }

    public CheckBox FindCheckBoxElement(By by) {
        return new CheckBox(driver, webElement.findElement(by));
    }

    public String getAttribute(String name) {
        return webElement.getAttribute(name);
    }

    public String getText() {
        return webElement.getText();
    }

    public boolean isSelected() {
        return webElement.isSelected();
    }

    public void setFlag() {
        if (!uiElement.isSelected()) {
            uiElement.click();
        }
    }

    public void unSetFlag() {
        if (uiElement.isSelected()) {
            uiElement.click();
        }
    }

    public void setFlagById(String id) {
        CheckBoxList.get(idList.indexOf(id)).setFlag();
    }

    public void setFlagByText(String text) {
        CheckBoxList.get(textList.indexOf(text)).setFlag();
    }

    public void unSetFlagById(String idText) {
        CheckBoxList.get(idList.indexOf(idText)).unSetFlag();
    }

    public void unSetFlagByText(String text) {
        CheckBoxList.get(textList.indexOf(text)).unSetFlag();
    }

    public boolean isCheckBoxSelectedById(String idText) {
        return CheckBoxList.get(idList.indexOf(idText)).isSelected();
    }

    public boolean isCheckBoxSelectedByText(String text) {
        return CheckBoxList.get(textList.indexOf(text)).isSelected();
    }


}
