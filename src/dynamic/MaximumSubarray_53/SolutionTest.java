package dynamic.MaximumSubarray_53;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(6, s.maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(4, s.maxSubArray(new int[] {-10, -9, -8, -7, -1, 2, 1, -5, 4}));
        assertEquals(5, s.maxSubArray(new int[] {-1, -2, -3, 2, -1, 4, -7, -1, 2, 1, -5, 4}));
        assertEquals(11, s.maxSubArray(new int[] {10, -2, -3, 2, -1, 5, -7, -1, 2, 1, -5, 4}));
    }
}
