package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

@Data
public class LoginPage extends BasePage {

    private SelenideElement emailInputSelenideElement = $("#user-name");
    private SelenideElement passwordInputSelenideElement = $("#password");
    private SelenideElement logInButtonSelenideElement = $("#login-button");
    private SelenideElement errorTextSelenideElement = $(By.className("error-message-container"));

}
