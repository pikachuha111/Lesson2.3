package stepDefs;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ReadProperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Hook {


    @Before
    public void initScenario(Scenario scenario) {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = ReadProperties.browserName();
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.timeout = 5000;
        Configuration.fastSetValue = false;

        System.out.println("HOOK: start browser");

    }

    @After
    public void completeScenario(Scenario scenario){
        closeWebDriver();
    }

}
