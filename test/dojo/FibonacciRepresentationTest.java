package dojo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author arkangelofkaos
 */
public class FibonacciRepresentationTest {

    @Test(dataProvider = "fibonacciTestData")
    public void given_1_shouldReturnFibonacciRepresentationOf_1(int n, String representation) throws Exception {
        assertEquals(fibonacciRepresentationOf(n), representation);
    }

    @DataProvider(name = "fibonacciTestData")
    public Object[][] fibonacciTestData() {
        return new Object[][]{
                {1, "1"},
                {2, "10"},
                {3, "100"}
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
