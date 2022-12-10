package tests;

import factory.BrowsersFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class XPathSelectorsTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new BrowsersFactory().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void XPatchLocatorTest() {
        driver.get("C:\\Users\\nickd\\Desktop\\TeachMeSkills\\LESSONS\\AQA2_3\\Lesson2.3\\src\\test\\resources\\index.html");

        //Абсолютный xpath
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div/p[3]/span[2]/b")).isDisplayed());

        //Все элементы на странице
        Assert.assertEquals(128, driver.findElement(By.xpath("//*")).getSize());

        // Аналог поиска по tagName
        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());

        // Аналог родительского div и на один уровень ниже h1
        Assert.assertTrue(driver.findElement(By.xpath("//div/h1")).isDisplayed());

        // Аналог родительского div и на любом уровене ниже div
        Assert.assertTrue(driver.findElement(By.xpath("//div//div")).isDisplayed());

        // Поиск элемента с тэгом div у которого есть аттрибут id
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id]")).isDisplayed());

        // Поиск элемента у которого есть аттрибут id cо значением top-logo
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id = 'top-logo']")).isDisplayed());

        // Поиск элемента у которого есть аттрибут method cо значением и аттрибут target со значением
        Assert.assertTrue(driver.findElement(By.xpath("//*[@method='post' and @target='_blank']")).isDisplayed());

        // Поиск элемента c аттрибутом lang или class со значением
        Assert.assertTrue(driver.findElement(By.xpath("//*[@lang or @class='noSel newsletter']")).isDisplayed());

        // Поиск элемента у которого значение аттрибута начинается с
        Assert.assertTrue(driver.findElement(By.xpath("//*[starts-with(@id, 'new')]")).isDisplayed());

        // Поиск элемента у которого значение аттрибута содержит подстроку
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@id, 'Template')]")).isDisplayed());

        // Поиск элемента у которого текстовое значение содержит равно
        Assert.assertTrue(driver.findElement(By.xpath("//*[text() = 'We are all animals!']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[. = '<table>']")).isDisplayed());

        // Поиск элемента у которого текстовое значение содержит подстроку
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'All Projects')]")).isDisplayed());

        // Поиск элемента по индексу
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'summary-links text-secondary']/a[2]")).isDisplayed());


    }

    @Test
    public void XPatchAxesTest() {
        driver.get("C:\\Users\\nickd\\Desktop\\TeachMeSkills\\LESSONS\\AQA2_3\\Lesson2.3\\src\\test\\resources\\index.html");

        // Поиск родителя у элемента с тэгом h1
        Assert.assertTrue(driver.findElement(By.xpath("//h1/..")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//h1/parent::*")).isDisplayed());

        // Поиск всех предков с тэгом div у элемента с тэгом h1
        Assert.assertTrue(driver.findElement(By.xpath("//h1/ancestor::div")).isDisplayed());

        // Использование child - непосредственно дочерние элементы с тэго a от div
        Assert.assertTrue(driver.findElement(By.xpath("//div/a")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div/child::a")).isDisplayed());

        // Использование child - все дочерние элементы с тэго a от div
        Assert.assertTrue(driver.findElement(By.xpath("//div//a")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div/descendant::a")).isDisplayed());

        //Использование following - Выбирает всё в документе после закрытия тэга текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/following::form")).isDisplayed());

        //Использование preceding- Выбирает все узлы, которые появляются перед текущим узлом в документе
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"dialog-title\"]/preceding::form")).isDisplayed());

        //Использование preceding-sibling - Выбирает все узлы одного уровня до текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/preceding-sibling::form")).isDisplayed());
    }
}
