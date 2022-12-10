package tests;

import factory.BrowsersFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CssSelectorTest {

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
    public void sccLocatorTest() {
        driver.get("C:\\Users\\nickd\\Desktop\\TeachMeSkills\\LESSONS\\AQA2_3\\Lesson2.3\\src\\test\\resources\\index.html");

        //поиск по id ("#" - заменяет id в cssSelector)
        Assert.assertTrue(driver.findElement(By.cssSelector("#my-Address")).isDisplayed());
        //та же аналогия с поиском по id
        Assert.assertTrue(driver.findElement(By.id("my-Address")).isDisplayed());

        //поиск по class name "."
        Assert.assertTrue(driver.findElement(By.cssSelector(".newsletter")).isDisplayed());
        //аналог поиска по classname (но уже без ".")
        Assert.assertTrue(driver.findElement(By.className("newsletter")).isDisplayed());
        //поиск по нескольким class "." (если классов несколько, то их можно перечислять через ".", порядок не имеет значения)
        Assert.assertTrue(driver.findElement(By.cssSelector(".newsletter.noSel")).isDisplayed());

        //поиск по tag name (DevTools search equals "//h1". Remember that is the difference between DevTools and Idea. Idea need's only the name of tag, without "//")
        Assert.assertTrue(driver.findElement(By.cssSelector("h1")).isDisplayed());
        //analogue by tagName
        Assert.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());

        //search value of tag name and value of class name (DevTools search like "div(tagName).noSel(className).newsletter(className)")
        Assert.assertTrue(driver.findElement(By.cssSelector("div.intro")).isDisplayed());
        //Rare case because id is unique name of webElements //search value of tag name and value of id (DevTools search like "tagName#idName")
        Assert.assertTrue(driver.findElement(By.cssSelector("p#my-Address")).isDisplayed());

        //hierarchy search
        //search by hierarchy in DevTools looks like f.e. (#Lastname .markup) - Space between attributes is important there!
        //first value of search is Mother-attribute after that we need to put in a Space and then write next value of Daughter-Attribute
        Assert.assertEquals(driver.findElement(By.cssSelector("#Lastname .markup")).getSize(), 2);

        //search all elements with tagname hq OR p
        Assert.assertEquals(driver.findElement(By.cssSelector("h1, p")).getSize(), 8);

        //search all elements with tagname p which have direct Mother-tagname element
        Assert.assertEquals(6, driver.findElements(By.cssSelector("div > p")).size());

        // Поиск всех элементов с тэгом p которые идут сразу за элементом с тэго ul
        Assert.assertEquals(1, driver.findElements(By.cssSelector("ul + p")).size());

        // Поиск всех элементов у которых присутствует аттрибут lang
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p[lang]")).size());

        // Поиск всех элементов у которых присутствует аттрибут style с конкретным значением
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[style='overflow: auto;']")).size());

        // Поиск всех элементов у которых присутствует аттрибут id со значением ЗАКАНЧИВАЮИЩЙСЯ на какое-то value
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id$='ess']")).size());

        // Поиск всех элементов у которых присутствует аттрибут id со значением НАЧИНАЮЩИМСЯ на какое-то value
        Assert.assertEquals(2, driver.findElements(By.cssSelector("[id^=L]")).size());

        // Поиск всех элементов у которых присутствует аттрибут id с начинающимся словом value
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id|=my]")).size());

        // Поиск всех элементов у которых присутствует аттрибут title со значением содержащим слово целиком
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title~=beautiful]")).size());

        // Поиск всех элементов у которых присутствует аттрибут title со значением содержащим подстроку
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title*='o beautiful']")).size());


        // ПОИСК ПО СВЙОСТВУ ЭЛЕМЕНТОВ


        // Поиск всех disabled элементов
        Assert.assertEquals(1, driver.findElements(By.cssSelector(":disabled")).size());

        // Поиск всех enabled элементов
        Assert.assertEquals(8, driver.findElements(By.cssSelector(":enabled")).size());

        // Поиск всех выборанных элементов
        Assert.assertEquals(2, driver.findElements(By.cssSelector(":checked")).size());

        // Поиск всех элементов c пустым телом
        Assert.assertEquals(16, driver.findElements(By.cssSelector(":empty")).size());

        // Поиск элемента с тэгом p и которым является первым дочерним элементом
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:first-child")).size());

        // Поиск элемента с тэгом p и которым является последним дочерним элементом
        Assert.assertEquals(2, driver.findElements(By.cssSelector("p:last-child")).size());

        // Поиск элемента с тэгом p и которым является n-ым дочерним элементом
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:nth-child(2)")).size());


        //XPath

        
    }
}
