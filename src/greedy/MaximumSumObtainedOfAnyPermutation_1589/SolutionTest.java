package greedy.MaximumSumObtainedOfAnyPermutation_1589;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(19, s.maxSumRangeQuery(new int[] {1, 2, 3, 4, 5}, new int[][] {{1, 3}, {0, 1}}));
        assertEquals(11, s.maxSumRangeQuery(new int[] {1, 2, 3, 4, 5, 6}, new int[][] {{0, 1}}));
        assertEquals(47, s.maxSumRangeQuery(new int[] {1, 2, 3, 4, 5, 10}, new int[][] {{0, 2}, {1, 3}, {1, 1}}));
    }
}