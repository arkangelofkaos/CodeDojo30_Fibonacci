package dojo;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author arkangelofkaos
 */
public class FibonacciSumsCalculator {
    private static final List<Integer> FIBONACCI_NUMBERS = asList(1, 2, 3, 5, 8, 13);

    public List<List<Integer>> fibonacciSumsFor(int number) {
        return asList(fibonacciSumFor(number, FIBONACCI_NUMBERS));
    }

    public List<Integer> fibonacciSumFor(int number, List<Integer> baseFibonacciNumbers) {
        if (number <= 0) {
            return asList();
        }

        Integer maxFib = baseFibonacciNumbers.stream()
                .filter(x -> x <= number)
                .max(Integer::compare)
                .get();

        List<Integer> fibsSoFar = new ArrayList<>();
        fibsSoFar.add(maxFib);
        fibsSoFar.addAll(fibonacciSumFor(number - maxFib, baseFibonacciNumbers));
        return fibsSoFar;
    }

}
