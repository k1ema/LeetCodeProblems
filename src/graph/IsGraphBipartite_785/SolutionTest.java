package graph.IsGraphBipartite_785;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertFalse(s.isBipartite(new int[][] {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}));
        assertTrue(s.isBipartite(new int[][] {{1, 3}, {0, 2}, {1, 3}, {0, 2}}));
    }
}