package tests.HW;

import org.testng.annotations.DataProvider;

public class DivisionProvider {

    @DataProvider (name = "DataForInteger")
    public static Object[][] dataForInteger (){
        return new Object[][] {
                {4, 2, 2},
                {-4, -2, 2}
        };
    }

    @DataProvider (name = "DataForDouble")
    public static Object[][] dataForDoubleProvider() {
        return new Object[][] {
                {6.0, 2.0, 3.0},
                {-6.0, -2.0, 3.0}
        };
    }
}
