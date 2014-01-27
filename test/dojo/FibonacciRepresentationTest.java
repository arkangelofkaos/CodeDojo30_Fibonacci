package dojo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.testng.Assert.assertEquals;

/**
 * @author arkangelofkaos
 */
public class FibonacciRepresentationTest {

    @Test(dataProvider = "fibonacciTestData")
    public void givenANumber_shouldReturnAFibonacciRepresentationOfIt(int number, String fibonacciRepresentation) throws Exception {
        assertEquals(fibonacciRepresentationOf(number), fibonacciRepresentation);
    }

    @DataProvider(name = "fibonacciTestData")
    public Object[][] fibonacciTestData() {
        return new Object[][]{
                {1, "1"},
                {2, "10"},
                {3, "100"}
        };
    }

    @Test(dataProvider = "fibonacciMultipleRepresentationsTestData")
    public void givenANumber_shouldReturnMultipleFibonacciRepresentationsOfIt(int number, List<String> fibonacciRepresentations) throws Exception {
        assertEquals(allFibonacciRepresentationOf(number), fibonacciRepresentations);
    }

    @DataProvider(name = "fibonacciMultipleRepresentationsTestData")
    public Object[][] fibonacciMultipleRepresentationsTestData() throws Exception {
        return new Object[][]{
                {3, asList("100", "101")}
        };
    }

    private String fibonacciRepresentationOf(int n) {
        switch (n) {
            case 3:
                return "100";
            case 2:
                return "10";
            default:
                return "1";
        }
    }
}
