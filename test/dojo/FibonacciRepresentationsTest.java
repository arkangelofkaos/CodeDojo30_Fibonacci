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
public class FibonacciRepresentationsTest {

    private FibonacciRepresentationsCalculator calculator;

    @BeforeMethod
    public void setUp() throws Exception {
        calculator = new FibonacciRepresentationsCalculator();
    }

    @Test(dataProvider = "fibonacciMultipleRepresentationsTestData")
    public void givenANumber_shouldReturnMultipleFibonacciRepresentationsOfIt(int number, List<String> fibonacciRepresentations) throws Exception {
        assertThat(calculator.fibonacciRepresentationsOf(number), is(fibonacciRepresentations));
    }

    @DataProvider(name = "fibonacciMultipleRepresentationsTestData")
    public Object[][] fibonacciMultipleRepresentationsTestData() throws Exception {
        return new Object[][]{
                {1, asList("1")},
                {2, asList("10")},
                {3, asList("100", "11")},
                {5, asList("1000", "110")},
                {6, asList("1001", "111")},
        };
    }

}
