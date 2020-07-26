package backtracking.AllPathsFromSourceToTarget_797;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(Arrays.asList(0, 1, 3), Arrays.asList(0, 2, 3)),
                s.allPathsSourceTarget(new int[][] {{1, 2}, {3}, {3}, {}}));
        assertEquals(Arrays.asList(Arrays.asList(0, 4), Arrays.asList(0, 3, 4), Arrays.asList(0, 1, 3, 4),
                Arrays.asList(0, 1, 2, 3, 4), Arrays.asList(0, 1, 4)),
                s.allPathsSourceTarget(new int[][] {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}}));
    }
}