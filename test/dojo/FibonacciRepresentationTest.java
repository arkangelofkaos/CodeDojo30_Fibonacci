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

    private String fibonacciRepresentationOf(int n) {
        return "1";
    }
}
