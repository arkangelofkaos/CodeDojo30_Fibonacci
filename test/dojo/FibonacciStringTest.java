package dojo;

import org.testng.annotations.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author arkangelofkaos
 */
public class FibonacciStringTest {

    @Test
    public void givenFibonacciSum_shouldReturnStringRepresentation() throws Exception {
        assertThat(fibonacciString(asList(1, 2, 3)), is("111"));
    }

    private String fibonacciString(List<Integer> fibonacciSum) {
        return null;
    }
}
