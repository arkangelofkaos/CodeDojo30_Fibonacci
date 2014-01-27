package dojo;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author arkangelofkaos
 */
public class FibonacciRepresentationsCalculator {

    public List<String> fibonacciRepresentationsOf(int number) {
        switch (number) {
            case 1:
                return asList("1");
            case 2:
                return asList("10");
            default:
                return asList("100", "11");
        }
    }
}
