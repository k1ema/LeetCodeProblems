package dynamic.TargetSum_494;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(5, s.findTargetSumWays(new int[] {1, 1, 1, 1, 1}, 3));
        assertEquals(3, s.findTargetSumWays(new int[] {1, 2, 3, 4, 5}, 3));
        assertEquals(3, s.findTargetSumWays(new int[] {5, 4, 3, 2, 1}, 3));
    }
}
