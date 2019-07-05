package graph.EvaluateDivision_399;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        List<List<String>> equations = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"));
        List<List<String>> queries = Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("b", "a"),
                Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x"));
        double[] values = new double[] {2.0, 3.0};
        assertArrayEquals(new double[] {6.0, 0.5, -1.0, 1.0, -1.0}, s.calcEquation(equations, values, queries), 0.1);
    }
}
