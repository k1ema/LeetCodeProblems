package dynamic.MaximumSubarraySumWithOneDeletion_1186;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.maximumSum(new int[] {1, -2, 0, 3}));
        assertEquals(3, s.maximumSum(new int[] {1, -2, -2, 3}));
        assertEquals(-1, s.maximumSum(new int[] {-1, -1, -1, -1}));
        assertEquals(11, s.maximumSum(new int[] {1, 2, 3, -2, 3, -5, 4}));
        assertEquals(-50, s.maximumSum(new int[] {-50}));
    }
}