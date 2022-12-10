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

        //���������� xpath
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div/p[3]/span[2]/b")).isDisplayed());

        //��� �������� �� ��������
        Assert.assertEquals(128, driver.findElement(By.xpath("//*")).getSize());

        // ������ ������ �� tagName
        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());

        // ������ ������������� div � �� ���� ������� ���� h1
        Assert.assertTrue(driver.findElement(By.xpath("//div/h1")).isDisplayed());

        // ������ ������������� div � �� ����� ������� ���� div
        Assert.assertTrue(driver.findElement(By.xpath("//div//div")).isDisplayed());

        // ����� �������� � ����� div � �������� ���� �������� id
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id]")).isDisplayed());

        // ����� �������� � �������� ���� �������� id c� ��������� top-logo
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id = 'top-logo']")).isDisplayed());

        // ����� �������� � �������� ���� �������� method c� ��������� � �������� target �� ���������
        Assert.assertTrue(driver.findElement(By.xpath("//*[@method='post' and @target='_blank']")).isDisplayed());

        // ����� �������� c ���������� lang ��� class �� ���������
        Assert.assertTrue(driver.findElement(By.xpath("//*[@lang or @class='noSel newsletter']")).isDisplayed());

        // ����� �������� � �������� �������� ��������� ���������� �
        Assert.assertTrue(driver.findElement(By.xpath("//*[starts-with(@id, 'new')]")).isDisplayed());

        // ����� �������� � �������� �������� ��������� �������� ���������
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@id, 'Template')]")).isDisplayed());

        // ����� �������� � �������� ��������� �������� �������� �����
        Assert.assertTrue(driver.findElement(By.xpath("//*[text() = 'We are all animals!']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[. = '<table>']")).isDisplayed());

        // ����� �������� � �������� ��������� �������� �������� ���������
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'All Projects')]")).isDisplayed());

        // ����� �������� �� �������
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'summary-links text-secondary']/a[2]")).isDisplayed());


    }

    @Test
    public void XPatchAxesTest() {
        driver.get("C:\\Users\\nickd\\Desktop\\TeachMeSkills\\LESSONS\\AQA2_3\\Lesson2.3\\src\\test\\resources\\index.html");

        // ����� �������� � �������� � ����� h1
        Assert.assertTrue(driver.findElement(By.xpath("//h1/..")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//h1/parent::*")).isDisplayed());

        // ����� ���� ������� � ����� div � �������� � ����� h1
        Assert.assertTrue(driver.findElement(By.xpath("//h1/ancestor::div")).isDisplayed());

        // ������������� child - ��������������� �������� �������� � ���� a �� div
        Assert.assertTrue(driver.findElement(By.xpath("//div/a")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div/child::a")).isDisplayed());

        // ������������� child - ��� �������� �������� � ���� a �� div
        Assert.assertTrue(driver.findElement(By.xpath("//div//a")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div/descendant::a")).isDisplayed());

        //������������� following - �������� �� � ��������� ����� �������� ���� �������� ����
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/following::form")).isDisplayed());

        //������������� preceding- �������� ��� ����, ������� ���������� ����� ������� ����� � ���������
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"dialog-title\"]/preceding::form")).isDisplayed());

        //������������� preceding-sibling - �������� ��� ���� ������ ������ �� �������� ����
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/preceding-sibling::form")).isDisplayed());
    }
}
