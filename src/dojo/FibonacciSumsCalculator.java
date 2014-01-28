package dojo;

import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

/**
 * @author arkangelofkaos
 */
public class FibonacciSumsCalculator {
    private static final List<Integer> FIBONACCI_NUMBERS = asList(1, 2, 3, 5, 8, 13);

    public List<List<Integer>> fibonacciSumsFor(int number) {
        return fibonacciSumsFor(
                number,
                FIBONACCI_NUMBERS.stream()
                                 .filter(x -> x <= number)
                                 .collect(toList())
        );
    }

    private List<List<Integer>> fibonacciSumsFor(int number, List<Integer> baseFibonacciNumbers) {
        List<List<Integer>> fibonacciSums = new LinkedList<>();
        switch (number) {
            case 1:
            case 2:
                fibonacciSums.add(singleNumberFibonacciSum(number));
                return fibonacciSums;
        }

        int maxFibonacci = baseFibonacciNumbers.stream()
                                               .mapToInt(x -> x)
                                               .max().getAsInt();
        int remainder = number - maxFibonacci;

        if (remainder == 0) {
            fibonacciSums.add(singleNumberFibonacciSum(maxFibonacci));
        } else if (remainder > 0) {
            List<Integer> remainingBaseFibonacciNumbers =
                    baseFibonacciNumbers.stream()
                                        .filter(x -> x < maxFibonacci)
                                        .collect(toList());
            fibonacciSums.addAll(fibonacciSumsFor(remainder, remainingBaseFibonacciNumbers));
            fibonacciSums.forEach(fibonacciSum -> fibonacciSum.add(maxFibonacci));
        }

        if (baseFibonacciNumbers.stream()
                                .mapToInt(x -> x)
                                .filter(x -> x < maxFibonacci)
                                .sum() >= number) {
            fibonacciSums.addAll(fibonacciSumsFor(number, baseFibonacciNumbers.stream()
                                                                              .filter(x -> x < maxFibonacci)
                                                                              .collect(toList())));
        }

        return fibonacciSums;
    }

    private LinkedList<Integer> singleNumberFibonacciSum(int number) {
        LinkedList<Integer> fibonacciSum = new LinkedList<>();
        fibonacciSum.add(number);
        return fibonacciSum;
    }

}
