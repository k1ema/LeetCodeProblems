package twoPointers.MinimumSizeSubarraySum_209;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(0, s.minSubArrayLen(3, new int[] {1, 1}));
        assertEquals(1, s.minSubArrayLen(7, new int[] {21, 3, 1, 2, 4, 3}));
        assertEquals(1, s.minSubArrayLen(4, new int[] {1, 4, 4}));
        assertEquals(2, s.minSubArrayLen(7, new int[] {2, 3, 1, 2, 4, 3}));
        assertEquals(3, s.minSubArrayLen(11, new int[] {1, 2, 3, 4, 5}));
    }
}