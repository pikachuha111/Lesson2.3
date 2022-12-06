package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CalculatorTest extends BaseTest {

    @Test
    public void testSum() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "�������� ����� ...");
    }

    @Test
    public void testSum10() {
        Assert.assertEquals(calculator.sum(2, 3), 10, "�������� ����� ...");
    }

    @Test (enabled = false) //����������� ���� ����� ��� �� ����� ����������� (�� ��������� ����� true)
    public void testSum1() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "�������� ����� ...");
    }

    @Test (description = "���� � ���������") // ���������� ��������
    public void testSum2() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "�������� ����� ...");
    }

    @Test (testName = "���� � ���������") //�������� ������� ����������� ����� � IDEA . ������ ��� ���������
    public void testSum3() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "�������� ����� ...");
    }

    @Test (timeOut = 1000) //�������, ������� ������������� �����, �� ������� ������ ������ ��� ���� ���������� � ������������
    public void testSum4() throws InterruptedException {
        Thread.sleep(10);
    }

    @Test (invocationCount = 3, invocationTimeOut = 1000, threadPoolSize = 3)
    //invocationCount ������� ��������� ���� � ��� �� ���� n ���-�� ���
    //invocationTimeOut ��� ������� ��� ���������� ������� �� ������� ������ ������ ����
    //threadPoolSize ��������������� ���������� (������� ���������� ��� � ����� ������ ����� 1000 �� ��� �������� � � ������ ��������� ������� �������� ����� 500 ��� �� ������ ����� ������ �����������)
    public void testSum5() throws InterruptedException {
        Thread.sleep(500); // ����������� � ���������� ��� �� 1000 �� ��������� �.�. ����� 3 ���� �� 500
        Assert.assertEquals(calculator.sum(2, 3), 5, "�������� ����� ...");
    }

    @Test (expectedExceptions = NullPointerException.class)
    public void exceptionTest() {
        List list = null;
        int size = list.size();
    }
}
