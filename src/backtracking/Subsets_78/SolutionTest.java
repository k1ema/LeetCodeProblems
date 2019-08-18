package backtracking.Subsets_78;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(
                new ArrayList<>(),
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(1, 2),
                Arrays.asList(3),
                Arrays.asList(1, 3),
                Arrays.asList(2, 3),
                Arrays.asList(1, 2, 3)
        ), s.subsets(new int[] {1, 2, 3}));
        assertEquals(Arrays.asList(
                new ArrayList<>(),
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(1, 2),
                Arrays.asList(3),
                Arrays.asList(1, 3),
                Arrays.asList(2, 3),
                Arrays.asList(1, 2, 3),
                Arrays.asList(4),
                Arrays.asList(1, 4),
                Arrays.asList(2, 4),
                Arrays.asList(1, 2, 4),
                Arrays.asList(3, 4),
                Arrays.asList(1, 3, 4),
                Arrays.asList(2, 3, 4),
                Arrays.asList(1, 2, 3, 4)
        ), s.subsets(new int[] {1, 2, 3, 4}));
    }
}
