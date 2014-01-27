package dojo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.testng.Assert.assertEquals;

/**
 * @author arkangelofkaos
 */
public class FibonacciTest {

    private static final List<Integer> FIBS = asList(1, 2, 3, 5, 8, 13);

    @Test(dataProvider = "fibTestData")
    public void given1_shouldReturn1(int number, List<Integer> expected) throws Exception {
        assertEquals(expected, fibDecomposition(number));
    }

    @DataProvider(name = "fibTestData")
    public Object[][] fibTestData() {
        return new Object[][]{
                {1, asList(1)},
                {2, asList(2)},
                {3, asList(3)},
                {4, asList(3, 1)},
                {6, asList(5, 1)},
                {7, asList(5, 2)},
                {20, asList(13, 5, 2)},
        };
    }

    private List<Integer> fibDecomposition(int i) {
        if (i <= 0) {
            return asList();
        }

        List<Integer> fibList = FIBS.stream().filter(x -> x <= i).collect(Collectors.<Integer>toList());
        Integer maxFib = fibList.get(fibList.size() - 1);

        List<Integer> fibsSoFar = new ArrayList<>();
        fibsSoFar.add(maxFib);
        fibsSoFar.addAll(fibDecomposition(i - maxFib));
        return fibsSoFar;
    }
}
