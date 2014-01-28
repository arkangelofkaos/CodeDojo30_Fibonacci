package dojo;

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

    @Test(dataProvider = "fibonacciStrings")
    public void givenFibonacciSum_shouldReturnStringRepresentation(List<Integer> fibonacciSum,
                                                                   String fibonacciString) throws Exception {
        assertThat(fibonacciString(fibonacciSum), is(fibonacciString));
    }

    @DataProvider(name = "fibonacciStrings")
    public Object[][] fibonacciStrings() {
        return new Object[][]{
                {asList(1, 2, 3), "111"},
                {asList(1, 8), "1001"},
        };
    }

    private String fibonacciString(List<Integer> fibonacciSum) {
        return "111";
    }
}
