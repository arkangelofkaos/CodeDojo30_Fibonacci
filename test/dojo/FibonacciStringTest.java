package dojo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author arkangelofkaos
 */
public class FibonacciStringTest {

    private FibonacciSumToStringCalculator calculator;

    @BeforeMethod
    public void setUp() throws Exception {
        calculator = new FibonacciSumToStringCalculator();
    }

    @Test(dataProvider = "fibonacciStrings")
    public void givenFibonacciSum_shouldReturnStringRepresentation(List<Integer> fibonacciSum,
                                                                   String fibonacciString) throws Exception {
        assertThat(calculator.fibonacciSumToString(fibonacciSum), is(fibonacciString));
    }

    @DataProvider(name = "fibonacciStrings")
    public Object[][] fibonacciStrings() {
        return new Object[][]{
                {asList(1, 2, 3), "111"},
                {asList(1, 8), "10001"},
                {asList(), ""},
        };
    }
}
