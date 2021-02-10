package greedy.NonOverlappingIntervals_435;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.eraseOverlapIntervals(new int[][] {{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
        assertEquals(2, s.eraseOverlapIntervals(new int[][] {{1, 2}, {1, 2}, {1, 2}}));
        assertEquals(0, s.eraseOverlapIntervals(new int[][] {{1, 2}, {2, 3}}));
    }
}