package dojo;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author arkangelofkaos
 */
public class FibonacciSumToStringCalculator {
    private static final List<Integer> FIBONACCI_NUMBERS = asList(1, 2, 3, 5, 8, 13);

    public String fibonacciSumToString(List<Integer> fibonacciSum) {
        int max = fibonacciSum.stream().mapToInt(x -> x).max().orElse(0);
        return FIBONACCI_NUMBERS.stream().mapToInt(x -> x)
                                .filter(x -> x <= max)
                                .mapToObj(x -> fibonacciSum.contains(x) ? "1" : "0")
                                .reduce(String::concat).orElse("");
    }
}
