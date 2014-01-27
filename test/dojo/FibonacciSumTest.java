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
public class FibonacciSumTest {

    private FibonacciSumCalculator calculator;

    @BeforeMethod
    public void setUp() throws Exception {
        calculator = new FibonacciSumCalculator();
    }

    @Test(dataProvider = "fibTestData")
    public void givenANumber_shouldReturnFibonacciSum(int number, List<Integer> expected) throws Exception {
        assertThat(calculator.fibonacciSumFor(number), is(expected));
    }

    @DataProvider(name = "fibTestData")
    public Object[][] fibTestData() {
        return new Object[][]{
                {1, asList(1)},
                {2, asList(2)},
                {3, asList(3)},
                {4, asList(3, 1)},
                {6, asList(5, 1)},
                {7, asList(5, 2)},
                {20, asList(13, 5, 2)},
        };
    }
}
