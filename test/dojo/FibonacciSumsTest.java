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
public class FibonacciSumsTest {

    private FibonacciSumsCalculator calculator;

    @BeforeMethod
    public void setUp() throws Exception {
        calculator = new FibonacciSumsCalculator();
    }

    @Test(dataProvider = "fibTestData")
    public void givenANumber_shouldReturnFibonacciSum(int number,
                                                      List<List<Integer>> expectedSums) throws Exception {
        assertThat(calculator.fibonacciSumsFor(number), is(expectedSums));
    }

    @DataProvider(name = "fibTestData")
    public Object[][] fibTestData() {
        return new Object[][]{
                {1, asList(asList(1))},
                {2, asList(asList(2))},
                {3, asList(asList(3), asList(1, 2))},
                {4, asList(asList(1, 3))},
                {5, asList(asList(5), asList(2, 3))},
                {6, asList(asList(1, 5), asList(1, 2, 3))},
                {7, asList(asList(2, 5))},
                {14, asList(asList(1, 13), asList(1, 5, 8), asList(1, 2, 3, 8))},
                {20, asList(asList(2, 5, 13))},
        };
    }

}
