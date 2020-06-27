package array.LongestSubarrayOf1sAfterDeletingOneElement_1493;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.longestSubarray(new int[] {1, 1, 0, 1}));
        assertEquals(5, s.longestSubarray(new int[] {0, 1, 1, 1, 0, 1, 1, 0, 1}));
        assertEquals(2, s.longestSubarray(new int[] {1, 1, 1}));
        assertEquals(4, s.longestSubarray(new int[] {1, 1, 0, 0, 1, 1, 1, 0, 1}));
        assertEquals(0, s.longestSubarray(new int[] {0, 0, 0}));
    }
}