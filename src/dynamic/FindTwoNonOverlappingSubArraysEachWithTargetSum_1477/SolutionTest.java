package dynamic.FindTwoNonOverlappingSubArraysEachWithTargetSum_1477;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.minSumOfLengths(new int[] {1, 2, 3}, 3));
        assertEquals(2, s.minSumOfLengths(new int[] {3, 2, 2, 4, 3}, 3));
        assertEquals(2, s.minSumOfLengths(new int[] {7, 3, 4, 7}, 7));
        assertEquals(-1, s.minSumOfLengths(new int[] {4, 3, 2, 6, 2, 3, 4}, 6));
        assertEquals(-1, s.minSumOfLengths(new int[] {5, 5, 4, 4, 5}, 3));
        assertEquals(3, s.minSumOfLengths(new int[] {3, 1, 1, 1, 5, 1, 2, 1}, 3));
        assertEquals(16, s.minSumOfLengths(new int[] {47, 17, 4, 8, 8, 2, 1, 1, 8, 35, 30, 1, 11, 1, 1, 1, 44, 1, 3, 27, 2, 8}, 88));
    }
}
