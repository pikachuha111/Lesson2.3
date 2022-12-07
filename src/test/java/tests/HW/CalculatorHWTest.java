package tests.HW;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.Calculator;
import utils.Retry;

public class CalculatorHWTest {
    CalculatorHW calculatorhw = new CalculatorHW();
    private int attempt = 1;

    @Test (enabled = true)
    public void testOne() {
        Assert.assertEquals(calculatorhw.divisionIntResult(6,2), 4, "���-�� �� ��� ... ");
    }

    @Test (testName = "���� 2", description = "�������� ��������� ������", priority = 1, dependsOnMethods = "testOne", alwaysRun = true, groups = "regression")
    public void testTwo() {
        Assert.assertEquals(calculatorhw.divisionIntResult(4,2), 2, "���-�� ����� �� ��� ... ");
    }

    @Test (groups = "regression", priority = 2, invocationCount = 3, invocationTimeOut = 1000, threadPoolSize = 3)
    public void testThree() {
        Assert.assertEquals(calculatorhw.divisionIntResult(4,3), 2, "���-�� ����� �� ��� ... ");
    }

    @Test (priority = 3, dependsOnGroups = "regression", timeOut = 1000)
    public void testFour() {
        Assert.assertEquals(calculatorhw.divisionIntResult(4,2), 2, "���-�� ����� �� ��� ... ");
    }

    @Test (testName = "IntegerProvider",dataProvider = "DataForInteger", dataProviderClass = DivisionProvider.class)
    public void testFive(int a, int b, int excpected){
        Assert.assertEquals(calculatorhw.divisionIntResult(a,b), excpected, "���-�� ����� �� ��� ... ");
    }

    @Test (testName = "DoubleProvider", dataProvider = "DataForDouble", dataProviderClass = DivisionProvider.class)
    public void testFive(double a, double b, double excpected){
        Assert.assertEquals(calculatorhw.divisionDoubleResult(a,b), excpected, "���-�� ����� �� ��� ... ");
    }

    @Test (testName = "������� �� 0 Integer", expectedExceptions = ArithmeticException.class)
    public void testSix() {
        Assert.assertEquals(calculatorhw.divisionIntResult(-4,0), 0, "���-�� ����� �� ��� ... ");
    }

    @Test (testName = "������� �� 0 Double")
    public void testSeven() {
        Assert.assertEquals(calculatorhw.divisionDoubleResult(4.0,0.0), Double.POSITIVE_INFINITY, "���-�� ����� �� ��� ... ");
    }

    @Test (testName = "������� �� 0 Double")
    public void testEight() {
        Assert.assertEquals(calculatorhw.divisionDoubleResult(0.0,0.0), Double.NaN, "���-�� ����� �� ��� ... ");
    }

    @Test (retryAnalyzer = Retry.class)
    public void retryTest() {
        if (attempt == 3) {
            Assert.assertEquals(calculatorhw.divisionDoubleResult(10.0,2.0), 5.0, "Something goes wrong ... ");
        } else {
            attempt++;
            System.out.println("Attempt is: " + attempt);
            throw new NullPointerException();
        }
    }

    @Test (enabled = true)
    public void testNine() {
        Assert.assertEquals(calculatorhw.divisionDoubleResult(6.0,2.0), 2.0, "���-�� �� ��� ... ");
    }

    @Test (testName = "���� 2", description = "�������� ��������� ������", priority = 1, dependsOnMethods = "testOne", alwaysRun = true, groups = "regression")
    public void testTen() {
        Assert.assertEquals(calculatorhw.divisionDoubleResult(4.0,2.0), 2.0, "���-�� ����� �� ��� ... ");
    }

    @Test (groups = "regression", priority = 2, invocationCount = 3, invocationTimeOut = 1000, threadPoolSize = 3)
    public void testEleven() {
        Assert.assertEquals(calculatorhw.divisionDoubleResult(4.0,3.0), 2.0, "���-�� ����� �� ��� ... ");
    }

    @Test (priority = 3, dependsOnGroups = "regression", timeOut = 1000)
    public void testTwelve() {
        Assert.assertEquals(calculatorhw.divisionDoubleResult(4.0,2.0), 2.0, "���-�� ����� �� ��� ... ");
    }


}
