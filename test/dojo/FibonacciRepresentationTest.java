package dojo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

/**
 * @author arkangelofkaos
 */
public class FibonacciRepresentationTest {

    @Test(dataProvider = "fibonacciMultipleRepresentationsTestData")
    public void givenANumber_shouldReturnMultipleFibonacciRepresentationsOfIt(int number, List<String> fibonacciRepresentations) throws Exception {
        assertThat(allFibonacciRepresentationOf(number), is(fibonacciRepresentations));
    }

    @DataProvider(name = "fibonacciMultipleRepresentationsTestData")
    public Object[][] fibonacciMultipleRepresentationsTestData() throws Exception {
        return new Object[][]{
                {1, asList("1")},
                {2, asList("10")},
                {3, asList("100", "11")}
        };
    }

    @DataProvider(name = "fibonacciOneAndZeroes")
    public Object[][] fibonacciOneAndZeroesTestData() throws Exception {
        return new Object[][]{
                {1, "1"},
                {2, "10"},
                {3, "100"},
                {5, "1000"}
        };
    }

    @Test(dataProvider = "fibonacciOneAndZeroes")
    public void givenAFibonacciNumber_shouldReturnARepresentationOneFollowedByNZeroes(int number, String rep) throws Exception {
        List<String> representations = allFibonacciRepresentationOf(number);
        assertTrue(representations.contains(rep), "Expected rep:" + rep + " but only found: " + representations);
    }

    private List<String> allFibonacciRepresentationOf(int number) {
        switch (number) {
            case 1:
                return asList("1");
            case 2:
                return asList("10");
            default:
                return asList("100", "11");
        }
    }

}
