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

        //����� �� id ("#" - �������� id � cssSelector)
        Assert.assertTrue(driver.findElement(By.cssSelector("#my-Address")).isDisplayed());
        //�� �� �������� � ������� �� id
        Assert.assertTrue(driver.findElement(By.id("my-Address")).isDisplayed());

        //����� �� class name "."
        Assert.assertTrue(driver.findElement(By.cssSelector(".newsletter")).isDisplayed());
        //������ ������ �� classname (�� ��� ��� ".")
        Assert.assertTrue(driver.findElement(By.className("newsletter")).isDisplayed());
        //����� �� ���������� class "." (���� ������� ���������, �� �� ����� ����������� ����� ".", ������� �� ����� ��������)
        Assert.assertTrue(driver.findElement(By.cssSelector(".newsletter.noSel")).isDisplayed());

        //����� �� tag name (DevTools search equals "//h1". Remember that is the difference between DevTools and Idea. Idea need's only the name of tag, without "//")
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

        // ����� ���� ��������� � ����� p ������� ���� ����� �� ��������� � ���� ul
        Assert.assertEquals(1, driver.findElements(By.cssSelector("ul + p")).size());

        // ����� ���� ��������� � ������� ������������ �������� lang
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p[lang]")).size());

        // ����� ���� ��������� � ������� ������������ �������� style � ���������� ���������
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[style='overflow: auto;']")).size());

        // ����� ���� ��������� � ������� ������������ �������� id �� ��������� ��������������� �� �����-�� value
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id$='ess']")).size());

        // ����� ���� ��������� � ������� ������������ �������� id �� ��������� ������������ �� �����-�� value
        Assert.assertEquals(2, driver.findElements(By.cssSelector("[id^=L]")).size());

        // ����� ���� ��������� � ������� ������������ �������� id � ������������ ������ value
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id|=my]")).size());

        // ����� ���� ��������� � ������� ������������ �������� title �� ��������� ���������� ����� �������
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title~=beautiful]")).size());

        // ����� ���� ��������� � ������� ������������ �������� title �� ��������� ���������� ���������
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title*='o beautiful']")).size());


        // ����� �� �������� ���������


        // ����� ���� disabled ���������
        Assert.assertEquals(1, driver.findElements(By.cssSelector(":disabled")).size());

        // ����� ���� enabled ���������
        Assert.assertEquals(8, driver.findElements(By.cssSelector(":enabled")).size());

        // ����� ���� ���������� ���������
        Assert.assertEquals(2, driver.findElements(By.cssSelector(":checked")).size());

        // ����� ���� ��������� c ������ �����
        Assert.assertEquals(16, driver.findElements(By.cssSelector(":empty")).size());

        // ����� �������� � ����� p � ������� �������� ������ �������� ���������
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:first-child")).size());

        // ����� �������� � ����� p � ������� �������� ��������� �������� ���������
        Assert.assertEquals(2, driver.findElements(By.cssSelector("p:last-child")).size());

        // ����� �������� � ����� p � ������� �������� n-�� �������� ���������
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:nth-child(2)")).size());


        //XPath

        
    }
}
