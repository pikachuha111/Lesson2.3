package baseEntities;

import configuration.ReadProperties;

import static com.codeborne.selenide.Selenide.*;

public class BasePage {

    public void openPageByUrl(String pagePath) {
        open(ReadProperties.getUrl() + pagePath);
    }
    public void openPageByUrl() {
        open(ReadProperties.getUrl());
    }
}
