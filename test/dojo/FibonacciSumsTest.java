package dojo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

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
        List<List<Integer>> actualSums = calculator.fibonacciSumsFor(number);
        for (List<Integer> expectedSum : expectedSums) {
            assertThat(actualSums, contains(expectedSum));
        }
    }

    @DataProvider(name = "fibTestData")
    public Object[][] fibTestData() {
        return new Object[][]{
                {1, asList(asList(1))},
                {2, asList(asList(2))},
                {3, asList(asList(3), asList(2, 1))},
//                {5, asList(asList(5), asList(3,2))},
                {4, asList(asList(3, 1))},
                {6, asList(asList(5, 1))},
                {7, asList(asList(5, 2))},
                {20, asList(asList(13, 5, 2))},
        };
    }

}
