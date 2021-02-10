package greedy.RemoveCoveredIntervals_1288;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.removeCoveredIntervals(new int[][] {{1, 4}, {3, 6}, {2, 8}}));
        assertEquals(1, s.removeCoveredIntervals(new int[][] {{1, 4}, {2, 3}}));
        assertEquals(2, s.removeCoveredIntervals(new int[][] {{0, 10}, {5, 12}}));
        assertEquals(2, s.removeCoveredIntervals(new int[][] {{3, 10}, {4, 10}, {5, 11}}));
        assertEquals(1, s.removeCoveredIntervals(new int[][] {{1, 2}, {1, 4}, {3, 4}}));
    }
}