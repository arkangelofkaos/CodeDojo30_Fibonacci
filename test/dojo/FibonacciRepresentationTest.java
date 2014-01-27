package dojo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author arkangelofkaos
 */
public class FibonacciRepresentationTest {

    @Test(dataProvider = "fibonacciTestData")
    public void givenANumber_shouldReturnIts_FibonacciRepresentation(int number, String fibonacciRepresentation) throws Exception {
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

    @Test
    public void()throws Exception

    {

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
