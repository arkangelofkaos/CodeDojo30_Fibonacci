package dojo;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author arkangelofkaos
 */
public class FibonacciRepresentationTest {

    @Test
    public void given_1_shouldReturnFibonacciRepresentationOf_1() throws Exception {
        assertEquals(fibonacciRepresentationOf(1), "1");
    }

    @Test
    public void given_2_shouldReturnFibonacciRepresentationOf_10() throws Exception {
        assertEquals(fibonacciRepresentationOf(2), "10");
    }

    private String fibonacciRepresentationOf(int n) {
        switch (n) {
            case 2:
                return "10";
            default:
                return "1";
        }
    }
}
