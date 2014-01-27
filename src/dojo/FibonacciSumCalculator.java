package dojo;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author arkangelofkaos
 */
public class FibonacciSumCalculator {
    private static final List<Integer> FIBONACCI_NUMBERS = asList(1, 2, 3, 5, 8, 13);

    public List<Integer> fibonacciSumFor(int i) {
        if (i <= 0) {
            return asList();
        }

        Integer maxFib = FIBONACCI_NUMBERS.stream()
                .filter(x -> x <= i)
                .max(Integer::compare)
                .get();

        List<Integer> fibsSoFar = new ArrayList<>();
        fibsSoFar.add(maxFib);
        fibsSoFar.addAll(fibonacciSumFor(i - maxFib));
        return fibsSoFar;
    }
}
