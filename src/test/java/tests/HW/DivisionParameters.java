package tests.HW;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DivisionParameters {
    @Parameters({"one", "two", "result"})
    @Test
    public void paramTest(@Optional("6")String one, @Optional("2") String two, @Optional("0") String ans) {
        System.out.println(one + " / " + two + " = " + ans);
    }
}
