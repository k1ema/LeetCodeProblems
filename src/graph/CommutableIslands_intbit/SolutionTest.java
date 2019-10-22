package graph.CommutableIslands_intbit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SolutionTest {
    @Parameterized.Parameters(name = "Algorithm: {0}")
    public static Object[] data() {
        return new Object[] {
                new SolutionPrimLazy(), new SolutionKruskal()
        };
    }

    @Parameterized.Parameter
    public Solution s;

    @Test
    public void test() {
        assertEquals(6, s.solve(4, Arrays.asList(
                Arrays.asList(1, 2, 1),
                Arrays.asList(2, 3, 4),
                Arrays.asList(1, 4, 3),
                Arrays.asList(4, 3, 2),
                Arrays.asList(1, 3, 10))));
        assertEquals(6, s.solve(4, Arrays.asList(
                Arrays.asList(1, 2, 1),
                Arrays.asList(2, 3, 2),
                Arrays.asList(3, 4, 4),
                Arrays.asList(1, 4, 3))));
    }
}
