package dojo;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

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
        if (baseCase(number)) {
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
                    remainingBaseFibonacciNumberStream(baseFibonacciNumbers, maxFibonacci)
                            .collect(toList());
            fibonacciSums.addAll(fibonacciSumsFor(remainder, remainingBaseFibonacciNumbers));
            fibonacciSums.forEach(fibonacciSum -> fibonacciSum.add(maxFibonacci));
        }

        if (remainingBaseFibonacciNumberStream(baseFibonacciNumbers, maxFibonacci)
                .mapToInt(x -> x).sum() >= number) {
            fibonacciSums.addAll(
                    fibonacciSumsFor(number,
                            remainingBaseFibonacciNumberStream(baseFibonacciNumbers, maxFibonacci)
                                    .collect(toList())
                    )
            );
        }

        return fibonacciSums;
    }

    private boolean baseCase(int number) {
        return number == 1 || number == 2;
    }

    private Stream<Integer> remainingBaseFibonacciNumberStream(List<Integer> baseFibonacciNumbers, int maxFibonacci) {
        return baseFibonacciNumbers.stream().filter(x -> x < maxFibonacci);
    }

    private LinkedList<Integer> singleNumberFibonacciSum(int number) {
        LinkedList<Integer> fibonacciSum = new LinkedList<>();
        fibonacciSum.add(number);
        return fibonacciSum;
    }

}
