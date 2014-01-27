package dojo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * @author arkangelofkaos
 */
public class FibonacciSumCalculator {
    private static final List<Integer> FIBONACCI_NUMBERS = asList(1, 2, 3, 5, 8, 13);

    public List<List<Integer>> fibonacciSumsFor(int number) {
        return asList(fibonacciSumFor(number));
    }

    public List<Integer> fibonacciSumFor(int number) {
        if (number <= 0) {
            return asList();
        }

        Integer maxFib = fibonacciStreamUpTo(number)
                .max(Integer::compare)
                .get();

        List<Integer> fibsSoFar = new ArrayList<>();
        fibsSoFar.add(maxFib);
        fibsSoFar.addAll(fibonacciSumFor(number - maxFib));
        return fibsSoFar;
    }

    private Stream<Integer> fibonacciStreamUpTo(int i) {
        return FIBONACCI_NUMBERS.stream()
                .filter(x -> x <= i);
    }
}
