package dynamic.MinCostClimbingStairs_746;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(15, s.minCostClimbingStairs(new int[] {10, 15, 20}));
        assertEquals(6, s.minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}