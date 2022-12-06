package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleDriver {

    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nickd\\Desktop\\TeachMeSkills\\LESSONS\\AQA2_3\\Lesson2.3\\src\\test\\resources\\chromedriver.exe");

    return new ChromeDriver();
    }
}
