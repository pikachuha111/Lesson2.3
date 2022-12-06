package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CalculatorTest extends BaseTest {

    @Test
    public void testSum() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма ...");
    }

    @Test
    public void testSum10() {
        Assert.assertEquals(calculator.sum(2, 3), 10, "Неверная сумма ...");
    }

    @Test (enabled = false) //доступность тест будет или не будет выполняться (по умолчанию стоит true)
    public void testSum1() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма ...");
    }

    @Test (description = "Тест с описанием") // добавления атрибута
    public void testSum2() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма ...");
    }

    @Test (testName = "Тест с названием") //название которое отображется слева в IDEA . Удобно для заказчика
    public void testSum3() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма ...");
    }

    @Test (timeOut = 1000) //атрибут, который устанавливает время, за которое должен пройти наш тест измеряется в милисекундах
    public void testSum4() throws InterruptedException {
        Thread.sleep(10);
    }

    @Test (invocationCount = 3, invocationTimeOut = 1000, threadPoolSize = 3)
    //invocationCount Атрибут выполняет один и тот же тест n кол-во раз
    //invocationTimeOut Доп атрибут для добавления времени за которое должен пройти тест
    //threadPoolSize распаралеливает выполнение (поэтому получается что в кажом потоке будет 1000 мл для выпления и в каждом отдельном потоком задержка будет 500 млс то каждый поток успеет выполниться)
    public void testSum5() throws InterruptedException {
        Thread.sleep(500); // суммируется и получается что за 1000 не получится т.к. будет 3 раза по 500
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма ...");
    }

    @Test (expectedExceptions = NullPointerException.class)
    public void exceptionTest() {
        List list = null;
        int size = list.size();
    }
}
