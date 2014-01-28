package dojo;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author arkangelofkaos
 */
public class FibonacciRepresentationsCalculator {

    private FibonacciSumsCalculator sumsCalculator = new FibonacciSumsCalculator();

    private FibonacciSumToStringCalculator toStringCalculator = new FibonacciSumToStringCalculator();

    private Stream<String> fibonacciSumStringStream(int number) {
        return sumsCalculator.fibonacciSumsFor(number)
                             .parallelStream()
                             .map(toStringCalculator::fibonacciSumToString);
    }

    public List<String> fibonacciRepresentationsOf(int number) {
        return fibonacciSumStringStream(number)
                .collect(toList());
    }

    public String fibonacciRepresentationWithoutConsectiveOnes(int number) {
        return fibonacciSumStringStream(number)
                .filter(x -> !x.contains("11"))
                .findFirst().orElse("");
    }
}
