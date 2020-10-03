package twoPointers.SubarrayProductLessThanK_713;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(8, s.numSubarrayProductLessThanK(new int[] {10, 5, 2, 6}, 100));
        assertEquals(22286, s.numSubarrayProductLessThanK(new int[] {28, 7, 30, 8, 20, 27, 30, 23, 24, 15, 33, 19, 8, 13, 11, 5, 29, 11, 23, 30, 17, 25, 18, 29, 21, 2, 11, 10, 28, 22, 1, 19, 10, 25, 25, 17, 18, 3, 4, 6, 21, 22, 6, 28, 10, 19, 25, 7, 4, 3, 28, 5, 30, 30, 10, 12, 10, 27, 10, 31, 27, 12, 15, 19, 11, 32, 25, 30, 20, 9, 30, 26, 30, 23, 21, 5, 12, 30, 7, 5, 23, 21, 28, 27, 17, 23, 1, 11, 10, 13, 4, 31, 11, 6, 9, 13, 18, 8, 25, 8, 15, 6, 7, 7, 11, 20, 2, 2, 19, 5, 11, 11, 21, 1, 13, 32, 26, 4, 4, 19, 2, 29, 23, 20, 7, 19, 7, 21, 32, 29, 25, 11, 15, 26, 17, 16, 8, 2, 26, 9, 8, 14, 7, 14, 18, 27, 1, 1, 2, 21, 18, 13, 19, 22, 18, 29, 11, 15, 13, 24, 22, 18, 5, 32, 8, 8, 3, 33, 16, 5, 17, 3, 25, 30, 19, 17, 21, 1, 19, 18, 1, 1, 28, 32, 22, 20, 15, 20, 28, 33, 17, 18, 13, 20, 2, 29, 14, 2, 29, 3, 27, 3, 2, 18, 6, 33, 8, 6, 4, 11, 25, 11, 7, 31, 27, 17, 14, 33, 27, 15, 1, 32, 19, 22, 18, 19, 2, 32, 14, 13, 12, 2, 22, 29, 2, 18, 20, 30, 5, 12, 2, 22, 25, 3, 13, 31, 27, 24, 13, 8, 8, 6, 10, 28, 23, 16, 5, 4, 1, 1, 1, 32, 1, 7, 2, 24, 13, 1, 9, 20, 32, 32, 1, 3, 31, 6, 33, 23, 26, 10, 15, 32, 31, 29, 4, 29, 6, 33, 8, 6, 28, 22, 27, 13, 17, 33, 24, 30, 7, 30, 32, 20, 22, 27, 14, 20, 21, 28, 11, 30, 11, 28, 28, 3, 19, 31, 29, 33, 19, 32, 5, 19, 33, 18, 5, 5, 8, 30, 30, 30, 32, 22, 32, 26, 12, 14, 9, 30, 19, 1, 3, 14, 17, 13, 7, 9, 18, 17, 19, 28, 16, 4, 5, 12, 18, 19, 14, 6, 2, 27, 15, 19, 12, 10, 14, 32, 11, 22, 5, 10, 6, 2, 3, 28, 5, 25, 28, 10, 14, 1, 15, 4, 22, 27, 2, 1, 10, 19, 6, 21, 27, 18, 2, 16, 25, 2, 33, 17, 25, 32, 22, 9, 16, 17, 19, 32, 3, 3, 2, 2, 24, 33, 22, 2, 5, 19, 15, 5, 32, 29, 5, 17, 1, 1, 9, 15, 32, 19, 19, 6, 19, 1, 14, 9, 19, 15, 20, 1, 24, 13, 27, 2, 27, 7, 1, 9, 17, 24, 16, 21, 11, 3, 1, 14, 5, 31, 14, 27, 16, 3, 32, 31, 19, 17, 17, 9, 26, 25, 11, 2, 28, 20, 16, 17, 12, 5, 26, 18, 14, 23, 27, 30, 9, 2, 14, 26, 32, 20, 7, 33, 21, 22, 16, 23, 7, 20, 31, 6, 17, 14, 20, 29, 5, 14, 5, 15, 4, 9, 12, 3, 17, 4, 7, 11, 10, 29, 5, 28, 32, 20, 32, 12, 30, 17, 30, 4, 19, 28, 28, 24, 1, 18, 15, 19, 8, 21, 11, 31, 20, 23, 11, 17, 20, 33, 14, 25, 21, 1, 17, 4, 15, 28, 13, 33, 14, 10, 24, 19, 17, 26, 6, 26, 19, 3, 24, 9, 12, 1, 5, 10, 27, 33, 8, 4, 32, 2, 15, 7, 30, 31, 18, 16, 9, 14, 31, 33, 10, 20, 32, 14, 29, 25, 1, 27, 23, 32, 20, 2, 11, 9, 18, 11, 13, 29, 2, 12, 1, 25, 15, 12, 28, 19, 30, 1, 17, 18, 14, 3, 12, 7, 18, 1, 5, 8, 31, 27, 3, 6, 12, 7, 14, 26, 2, 10, 31, 8, 32, 12, 21, 13, 1, 17, 12, 30, 27, 6, 25, 30, 22, 20, 8, 30, 23, 20, 26, 19, 15, 1, 19, 15, 29, 5, 25, 27, 28, 7, 32, 9, 28, 33, 8, 30, 8, 27, 28, 21, 30, 22, 3, 18, 9, 22, 21, 31, 17, 5, 22, 12, 14, 4, 17, 23, 10, 32, 4, 19, 2, 3, 23, 21, 28, 15, 20, 28, 12, 27, 26, 33, 29, 19, 8, 28, 17, 33, 19, 16, 11, 29, 26, 29, 18, 33, 9, 19, 26, 9, 18, 1, 24, 15, 6, 10, 27, 32, 29, 23, 10, 9, 18, 22, 27, 1, 27, 12, 5, 31, 33, 21, 9, 14, 12, 27, 22, 32, 26, 2, 13, 24, 11, 14, 18, 20, 27, 27, 19, 1, 11, 33, 23, 26, 11, 30, 7, 3, 31, 9, 30, 25, 7, 20, 6, 17, 30, 18, 10, 11, 4, 32, 24, 19, 18, 10, 2, 4, 5, 26, 16, 25, 29, 25, 9, 23, 8, 5, 19, 18, 30, 19, 20, 19, 17, 11, 23, 18, 26, 13, 15, 8, 33, 8, 31, 19, 12, 26, 27, 19, 32, 31, 19, 20, 5, 6, 17, 1, 21, 25, 10, 23, 27, 31, 33, 2, 15, 27, 1, 13, 1, 24, 22, 31, 23, 5, 15, 3, 18, 30, 19, 24, 15, 25, 9, 3, 4, 32, 16, 33, 15, 14, 31, 28, 10, 18, 28, 6, 6, 3, 3, 30, 14, 33, 9, 8, 6, 30, 11, 27, 17, 14, 9, 9, 2, 30, 20, 18, 32, 11, 23, 9, 29, 32, 19, 4, 2, 28, 31, 1, 13, 10, 15, 27, 25, 17, 16, 17, 10, 21, 5, 17, 16, 32, 32, 4, 25, 13, 10, 6, 27, 3, 10, 21, 14, 25, 20, 29, 17, 29, 7, 31, 18, 12, 26, 25, 10, 12, 30, 33, 9, 2, 12, 27, 4, 3, 20, 4, 19, 12, 30, 23, 8, 33, 26, 21, 28, 8, 19, 3, 10, 24, 15, 18, 30, 7, 13, 3, 32, 20, 17, 13, 31, 30, 13, 12, 24, 30, 10, 26, 30, 16, 15, 29, 12, 25, 26, 26, 7, 19, 13, 30, 18, 24, 10, 5, 18, 5, 30, 20, 13, 13, 18, 16, 2, 24, 28, 27, 33, 5, 31, 19, 23, 23, 14, 32, 15, 31, 1, 28, 13, 1, 19, 28, 31, 23, 5, 8, 32, 28, 5, 14, 9, 24, 29, 31, 22, 25, 30, 15, 28, 12, 10, 9, 20, 16, 20, 24, 33, 7, 5, 10, 3, 27, 26, 29, 16, 28, 19, 32, 19, 21, 8, 26, 31, 33, 6, 3, 7, 18, 24, 19, 10, 6, 22, 29, 22, 29, 23, 23, 16, 29, 12, 30, 5, 26, 29, 3, 21, 32, 30, 6, 17, 3, 5, 19, 28, 14, 4, 7, 3, 25, 9, 27, 20, 6, 21, 4, 30, 5, 1, 14, 18, 9, 15, 23, 26, 7, 22, 8, 2, 22, 27, 8, 29, 9, 9, 23, 4, 33, 4, 9, 27, 1, 23, 3, 1, 17, 32, 5, 31, 7, 29, 10, 6, 11, 27, 12, 25, 29, 4, 5, 19, 9, 19, 6, 23, 20, 9, 30, 12, 26, 16, 22, 22, 29, 2, 15, 30, 18, 25, 18, 19, 28, 26, 2, 26, 32, 31, 27, 26, 26, 29, 4, 33, 7, 31, 12, 26, 31, 12, 28, 14, 3, 24, 19, 7, 20, 21, 7, 32, 23, 13, 3, 20, 7, 22, 19, 14, 18, 24, 5, 31, 27, 13, 25, 2, 24, 21, 29, 25, 33, 30, 15, 20, 12, 1, 23, 2, 30, 31, 20, 13, 3, 25, 13, 7, 10, 27, 32, 16, 18, 27, 15, 18, 30, 9, 26, 7, 21, 4, 26, 8, 6, 9, 9, 24, 13, 33, 25, 11, 25, 3, 22, 12, 30, 27, 25, 32, 21, 18, 29, 7, 31, 29, 18, 2, 4, 16, 25, 28, 30, 27, 23, 21, 17, 25, 3, 33, 26, 24, 32, 28, 31, 32, 24, 16, 19, 11, 8, 5, 32, 26, 12, 17, 16, 27, 22, 8, 29, 33, 18, 33, 14, 14, 6, 15, 21, 20, 25, 8, 7, 12, 17, 20, 4, 21, 8, 26, 13, 10, 18, 18, 11, 15, 13, 25, 15, 24, 2, 20, 8, 22, 25, 21, 32, 15, 1, 32, 28, 5, 19, 28, 25, 5, 11, 28, 3, 24, 27, 11, 27, 17, 3, 12, 14, 8, 7, 24, 29, 20, 26, 27, 17, 26, 30, 1, 11, 2, 26, 26, 15, 14, 24, 20, 1, 31, 10, 6, 9, 16, 7, 15, 2, 24, 9, 6, 3, 28, 23, 30, 23, 24, 24, 32, 12, 9, 4, 31, 29, 14, 24, 13, 12, 1, 7, 33, 29, 9, 25, 13, 23, 30, 26, 16, 30, 20, 18, 14, 19, 1, 24, 2, 16, 19, 7, 33, 9, 22, 33, 5, 19, 11, 3, 12, 24, 13, 7, 30, 3, 10, 1, 26, 28, 12, 12, 2, 16, 27, 14, 25, 13, 24, 8, 23, 12, 24, 5, 19, 23, 24, 15, 6, 8, 27, 28, 30, 14, 33, 27, 22, 10, 15, 5, 2, 24, 5, 13, 5, 25, 32, 4, 16, 28, 1, 5, 31, 7, 29, 32, 20, 29, 14, 4, 13, 6, 23, 33, 4, 11, 9, 33, 9, 11, 29, 21, 24, 25, 20, 31, 27, 9, 24, 27, 29, 11, 14, 10, 8, 21, 33, 25, 13, 11, 33, 19, 28, 11, 28, 10, 31, 27, 24, 13, 16, 15, 20, 11, 16, 20, 17, 8, 11, 30, 11, 2, 16, 1, 24, 15, 32, 12, 7, 4, 26, 26, 31, 12, 31, 29, 27, 31, 3, 30, 5, 17, 25, 24, 5, 16, 2, 20, 13, 3, 22, 13, 33, 3, 2, 8, 24, 9, 10, 12, 2, 5, 18, 26, 32, 4, 7, 14, 3, 22, 5, 9, 22, 8, 17, 21, 5, 23, 23, 6, 6, 27, 26, 11, 9, 18, 12, 32, 3, 24, 28, 17, 29, 5, 7, 2, 29, 7, 16, 21, 19, 7, 15, 25, 20, 26, 15, 1, 5, 32, 1, 23, 5, 4, 28, 32, 12, 19, 2, 11, 16, 29, 13, 30, 5, 28, 1, 19, 6, 18, 26, 24, 10, 2, 27, 30, 13, 6, 30, 22, 11, 2, 13, 21, 15, 7, 15, 15, 26, 30, 1, 8, 21, 4, 7, 7, 30, 20, 17, 29, 7, 28, 28, 7, 5, 23, 13, 21, 10, 11, 7, 11, 25, 7, 22, 1, 9, 7, 6, 8, 11, 21, 3, 16, 15, 18, 28, 33, 9, 17, 17, 25, 27, 5, 20, 12, 17, 3, 3, 1, 11, 24, 8, 20, 32, 3, 7, 22, 2, 31, 5, 14, 1, 30, 6, 32, 7, 27, 32, 26, 5, 17, 30, 28, 20, 5, 11, 9, 7, 7, 33, 17, 17, 2, 32, 13, 17, 21, 4, 6, 25, 26, 16, 14, 5, 8, 12, 7, 7, 11, 29, 27, 12, 5, 6, 28, 4, 24, 5, 15, 22, 33, 24, 19, 26, 26, 28, 16, 15, 21, 23, 30, 7, 6, 7, 20, 4, 17, 30, 17, 21, 15, 30, 20, 20, 16, 20, 3, 31, 19, 10, 21, 29, 21, 26, 32, 30, 27, 18, 3, 3, 5, 33, 25, 19, 19, 9, 18, 21, 25, 6, 31, 27, 11, 33, 16, 6, 27, 10, 14, 23, 10, 32, 31, 24, 18, 24, 15, 30, 33, 13, 12, 6, 20, 33, 33, 19, 4, 2, 32, 19, 21, 19, 30, 19, 19, 7, 5, 18, 9, 20, 13, 2, 2, 7, 25, 31, 7, 28, 32, 9, 6, 1, 13, 32, 25, 8, 10, 33, 7, 33, 2, 8, 26, 18, 29, 12, 32, 9, 3, 17, 31, 18, 25, 6, 28, 1, 26, 29, 16, 13, 1, 18, 4, 2, 13, 6, 25, 10, 32, 33, 5, 32, 20, 19, 18, 12, 33, 10, 12, 21, 30, 2, 24, 25, 2, 20, 31, 8, 19, 25, 2, 22, 6, 8, 9, 33, 33, 30, 30, 9, 10, 9, 1, 9, 31, 25, 27, 5, 18, 23, 16, 18, 9, 23, 20, 4, 32, 16, 17, 27, 8, 16, 7, 31, 12, 10, 3, 3, 16, 27, 10, 23, 4, 8, 20, 8, 22, 3, 20, 23, 11, 33, 14, 4, 7, 13, 12, 1, 5, 26, 9, 31, 32, 5, 24, 2, 10, 6, 2, 8, 22, 15, 29, 15, 17, 5, 17, 10, 10, 15, 25, 31, 8, 18, 22, 16, 32, 5, 2, 29, 5, 19, 9, 8, 1, 2, 21, 21, 8, 17, 15, 23, 14, 5, 28, 16, 26, 29, 31, 11, 2, 1, 12, 31, 13, 25, 6, 11, 32, 3, 15, 7, 24, 25, 11, 3, 11, 23, 19, 28, 19, 26, 12, 6, 27, 33, 9, 18, 21, 19, 26, 27, 23, 12, 27, 2, 29, 13, 1, 31, 12, 7, 23, 2, 12, 25, 8, 5, 32, 3, 32, 32, 5, 29, 17, 29, 7, 27, 6, 27, 30, 11, 2, 10, 31, 16, 8, 4, 20, 28, 17, 18, 26, 23, 31, 14, 23, 12, 24, 6, 26, 22, 9, 27, 27, 31, 27, 13, 24, 32, 3, 20, 23, 15, 3, 26, 6, 30, 16, 9, 3, 4, 12, 30, 14, 16, 19, 8, 21, 11, 7, 26, 27, 18, 32, 19, 12, 17, 30, 33, 14, 30, 9, 1, 5, 5, 11, 33, 28, 22, 27, 23, 15, 21, 14, 3, 32, 16, 20, 8, 9, 25, 13, 32, 15, 5, 15, 7, 4, 29, 19, 27, 6, 13, 18, 16, 18, 27, 16, 12, 18, 5, 8, 6, 17, 33, 19, 17, 9, 11, 3, 1, 1, 22, 15, 9, 6, 24, 2, 7, 10, 9, 4, 33, 31, 18, 23, 22, 18, 27, 7, 8, 9, 28, 15, 2, 8, 5, 3, 8, 27, 26, 20, 4, 18, 12, 15, 33, 28, 3, 32, 29, 25, 31, 14, 6, 6, 1, 27, 16, 3, 28, 16, 21, 28, 3, 17, 24, 19, 2, 22, 25, 23, 18, 1, 12, 24, 20, 6, 14, 5, 10, 13, 14, 27, 28, 27, 20, 6, 13, 24, 23, 11, 19, 8, 20, 3, 11, 7, 14, 33, 13, 15, 8, 28, 16, 31, 11, 24, 29, 29, 16, 1, 21, 14, 15, 24, 15, 22, 21, 32, 32, 17, 24, 11, 21, 23, 31, 29, 15, 18, 28, 23, 9, 32, 26, 1, 22, 9, 5, 27, 20, 3, 5, 11, 21, 15, 12, 16, 29, 26, 6, 32, 27, 26, 12, 20, 2, 10, 24, 10, 2, 12, 19, 32, 4, 3, 27, 7, 31, 33, 19, 2, 19, 22, 29, 28, 30, 33, 6, 33, 21, 23, 6, 5, 30, 27, 13, 2, 16, 5, 19, 15, 8, 26, 25, 4, 22, 1, 28, 18, 16, 5, 24, 21, 33, 1, 19, 21, 33, 8, 26, 14, 29, 8, 33, 22, 24, 14, 9, 22, 14, 13, 3, 24, 21, 1, 28, 29, 30, 22, 5, 9, 6, 11, 12, 17, 15, 17, 1, 21, 19, 25, 29, 15, 19, 31, 24, 23, 29, 24, 18, 28, 2, 25, 9, 11, 24, 29, 10, 3, 19, 30, 11, 23, 31, 16, 26, 12, 30, 20, 17, 4, 7, 31, 18, 26, 7, 21, 11, 16, 9, 23, 14, 30, 26, 25, 29, 31, 8, 5, 21, 18, 17, 20, 13, 1, 4, 10, 18, 17, 25, 17, 30, 27, 19, 6, 33, 17, 7, 6, 15, 20, 29, 25, 6, 21, 2, 4, 2, 19, 3, 31, 26, 24, 31, 9, 32, 5, 25, 10, 9, 14, 3, 24, 22, 20, 25, 25, 11, 1, 2, 15, 31, 12, 20, 6, 27, 16, 22, 1, 19, 30, 18, 2, 3, 30, 33, 26, 10, 25, 32, 21, 21, 5, 4, 8, 6, 19, 10, 32, 29, 28, 20, 20, 12, 29, 6, 10, 13, 13, 3, 7, 13, 6, 7, 24, 11, 25, 29, 8, 30, 24, 26, 17, 25, 1, 18, 4, 5, 12, 2, 2, 12, 6, 25, 24, 3, 9, 7, 29, 28, 31, 5, 28, 17, 18, 32, 1, 8, 11, 11, 32, 22, 11, 18, 7, 12, 25, 2, 29, 9, 31, 33, 1, 22, 8, 22, 3, 10, 7, 28, 21, 23, 22, 26, 21, 2, 30, 23, 9, 19, 26, 12, 16, 7, 11, 10, 33, 32, 15, 21, 17, 29, 27, 12, 14, 33, 25, 16, 31, 18, 12, 7, 16, 17, 4, 1, 18, 8, 12, 22, 14, 6, 26, 10, 32, 28, 33, 1, 23, 6, 17, 16, 10, 27, 27, 29, 8, 9, 20, 2, 16, 3, 29, 7, 30, 14, 26, 8, 11, 33, 13, 9, 30, 18, 19, 29, 13, 5, 4, 20, 6, 7, 29, 1, 28, 5, 4, 9, 18, 11, 7, 27, 23, 8, 22, 32, 26, 1, 10, 1, 3, 24, 5, 16, 11, 32, 19, 24, 3, 29, 21, 10, 19, 21, 14, 12, 28, 7, 20, 2, 8, 17, 22, 23, 30, 33, 19, 27, 32, 5, 12, 26, 6, 25, 24, 24, 22, 8, 10, 8, 19, 14, 24, 27, 27, 6, 23, 25, 11, 30, 32, 8, 13, 16, 23, 29, 12, 28, 28, 3, 1, 25, 22, 7, 10, 17, 14, 27, 23, 13, 14, 14, 1, 24, 28, 17, 24, 26, 21, 3, 12, 5, 17, 3, 2, 1, 17, 6, 2, 30, 30, 24, 14, 27, 14, 15, 13, 25, 9, 18, 4, 32, 17, 27, 22, 29, 9, 22, 6, 13, 1, 29, 8, 15, 6, 15, 21, 33, 11, 14, 4, 33, 11, 23, 19, 14, 1, 32, 9, 23, 33, 11, 4, 18, 16, 6, 18, 8, 13, 20, 7, 6, 28, 3, 26, 7, 8, 24, 25, 3, 16, 31, 30, 13, 17, 3, 26, 19, 30, 22, 22, 11, 4, 26, 29, 18, 25, 1, 19, 15, 23, 4, 9, 20, 27, 8, 19, 22, 4, 29, 22, 1, 13, 23, 10, 16, 14, 26, 23, 18, 26, 33, 27, 19, 23, 32, 8, 10, 3, 30, 2, 24, 33, 12, 29, 28, 23, 19, 19, 7, 12, 3, 12, 1, 16, 21, 6, 14, 31, 21, 1, 33, 2, 5, 12, 22, 15, 9, 3, 23, 4, 28, 7, 8, 31, 25, 2, 24, 14, 12, 27, 18, 9, 17, 23, 8, 8, 5, 7, 23, 7, 14, 22, 16, 20, 7, 21, 6, 31, 8, 19, 2, 24, 23, 17, 8, 9, 27, 17, 22, 9, 17, 33, 10, 30, 17, 25, 21, 7, 15, 32, 24, 23, 32, 31, 22, 19, 15, 15, 5, 11, 7, 17, 31, 9, 32, 25, 10, 28, 33, 26, 7, 8, 31, 2, 29, 2, 9, 3, 22, 8, 17, 20, 27, 11, 5, 16, 30, 26, 14, 13, 31, 9, 11, 6, 16, 10, 32, 30, 23, 15, 9, 27, 8, 4, 4, 16, 33, 5, 5, 3, 22, 30, 10, 11, 22, 33, 22, 32, 4, 17, 1, 9, 17, 25, 19, 29, 24, 15, 20, 9, 28, 3, 6, 19, 18, 20, 2, 4, 10, 14, 24, 11, 5, 32, 12, 4, 11, 32, 3, 16, 13, 4, 7, 6, 27, 4, 25, 3, 14, 23, 7, 27, 11, 30, 16, 28, 2, 30, 16, 26, 19, 32, 6, 27, 15, 27, 29, 5, 21, 32, 20, 14, 25, 30, 26, 4, 24, 10, 16, 5, 13, 7, 14, 14, 8, 19, 19, 5, 10, 9, 1, 28, 26, 2, 16, 19, 19, 6, 13, 15, 6, 2, 11, 10, 31, 4, 15, 11, 1, 30, 21, 28, 12, 33, 33, 31, 15, 25, 19, 4, 26, 17, 28, 12, 18, 15, 25, 31, 14, 8, 18, 13, 1, 18, 6, 20, 20, 27, 29, 29, 29, 15, 12, 22, 27, 15, 12, 28, 23, 1, 9, 7, 33, 33, 7, 2, 5, 13, 16, 26, 3, 6, 16, 33, 30, 18, 8, 20, 15, 29, 13, 19, 2, 22, 27, 14, 14, 8, 12, 4, 20, 25, 5, 3, 5, 17, 23, 14, 33, 2, 7, 7, 17, 2, 31, 19, 27, 15, 14, 18, 20, 27, 7, 28, 32, 9, 20, 19, 7, 7, 20, 19, 2, 31, 15, 17, 5, 11, 12, 21, 2, 5, 30, 23, 12, 24, 27, 4, 30, 5, 6, 12, 20, 11, 10, 12, 8, 15, 16, 28, 19, 31, 13, 9, 2, 30, 8, 7, 33, 6, 25, 22, 16, 21, 24, 18, 2, 1, 10, 9, 11, 13, 24, 17, 1, 8, 16, 21, 10, 12, 19, 32, 24, 16, 22, 31, 26, 8, 3, 1, 9, 3, 18, 13, 2, 22, 24, 16, 18, 21, 13, 12, 26, 7, 18, 28, 2, 15, 20, 13, 13, 11, 6, 15, 17, 5, 21, 7, 14, 24, 27, 2, 12, 8, 16, 1, 31, 29, 5, 21, 22, 6, 18, 26, 16, 23, 18, 17, 30, 10, 27, 5, 13, 19, 22, 17, 26, 5, 11, 27, 25, 13, 16, 25, 23, 30, 16, 15, 7, 12, 9, 22, 27, 6, 21, 19, 17, 31, 31, 28, 21, 8, 12, 23, 5, 28, 3, 23, 22, 13, 9, 24, 21, 10, 14, 10, 28, 30, 24, 14, 13, 26, 33, 33, 1, 12, 21, 18, 11, 33, 22, 9, 22, 27, 20, 11, 27, 3, 30, 23, 33, 4, 22, 22, 24, 17, 3, 4, 2, 19, 28, 7, 11, 26, 4, 24, 31, 33, 8, 6, 26, 18, 8, 17, 30, 18, 33, 12, 10, 33, 22, 7, 15, 1, 17, 20, 20, 2, 24, 13, 2, 26, 33, 9, 9, 14, 2, 25, 4, 1, 9, 7, 22, 30, 29, 15, 30, 23, 6, 26, 4, 24, 18, 25, 4, 8, 8, 18, 5, 3, 8, 17, 12, 5, 30, 30, 16, 25, 17, 10, 21, 11, 19, 29, 1, 20, 9, 3, 16, 31, 25, 12, 15, 14, 25, 8, 2, 4, 20, 2, 18, 19, 18, 32, 4, 7, 27, 28, 28, 2, 18, 28, 33, 16, 2, 2, 15, 17, 24, 30, 17, 8, 2, 21, 1, 10, 21, 13, 5, 11, 24, 33, 11, 11, 28, 17, 28, 5, 10, 15, 9, 33, 11, 25, 23, 32, 20, 14, 32, 16, 23, 22, 11, 25, 1, 12, 18, 15, 6, 13, 2, 10, 1, 29, 11, 22, 31, 20, 24, 22, 11, 12, 29, 7, 22, 1, 21, 4, 6, 1, 2, 11, 22, 14, 28, 19, 3, 20, 3, 14, 20, 7, 11, 13, 27, 12, 22, 9, 33, 11, 14, 11, 4, 24, 2, 33, 11, 15, 15, 17, 19, 28, 5, 22, 26, 27, 7, 27, 33, 32, 2, 15, 9, 24, 19, 1, 10, 31, 23, 30, 24, 8, 19, 25, 6, 32, 6, 5, 8, 28, 22, 2, 22, 13, 9, 27, 1, 16, 16, 26, 2, 3, 28, 25, 22, 15, 19, 31, 31, 12, 9, 13, 22, 8, 30, 22, 28, 6, 2, 29, 21, 26, 23, 5, 12, 28, 28, 3, 24, 18, 11, 17, 26, 16, 23, 28, 31, 4, 24, 6, 24, 5, 3, 28, 19, 31, 22, 2, 3, 13, 25, 22, 25, 16, 13, 12, 26, 30, 11, 18, 22, 9, 28, 21, 10, 15, 25, 10, 25, 12, 15, 13, 25, 4, 32, 9, 27, 12, 26, 17, 9, 2, 7, 14, 22, 29, 24, 2, 23, 16, 3, 9, 14, 3, 7, 21, 33, 16, 5, 23, 8, 12, 22, 27, 16, 25, 1, 26, 27, 29, 4, 11, 21, 20, 10, 10, 24, 24, 24, 16, 28, 25, 16, 18, 29, 29, 20, 24, 27, 17, 15, 20, 30, 14, 11, 12, 11, 1, 20, 4, 25, 16, 31, 28, 27, 1, 22, 3, 33, 3, 24, 7, 23, 18, 4, 20, 13, 10, 7, 28, 3, 10, 16, 11, 27, 10, 20, 26, 12, 10, 17, 27, 4, 3, 25, 17, 8, 6, 26, 26, 21, 17, 10, 17, 16, 18, 10, 20, 21, 27, 2, 11, 32, 2, 24, 30, 8, 31, 22, 7, 32, 5, 7, 1, 32, 25, 11, 30, 14, 6, 6, 8, 30, 14, 3, 24, 6, 31, 31, 14, 20, 17, 3, 6, 3, 18, 19, 21, 7, 8, 11, 20, 2, 16, 24, 26, 6, 16, 4, 2, 14, 16, 28, 31, 25, 14, 8, 3, 21, 5, 4, 11, 9, 31, 16, 6, 33, 31, 27, 31, 6, 18, 23, 29, 10, 32, 8, 26, 2, 14, 23, 7, 10, 4, 11, 4, 25, 16, 33, 31, 32, 29, 3, 28, 6, 8, 2, 7, 25, 20, 21, 1, 12, 16, 8, 11, 27, 24, 17, 10, 27, 16, 14, 23, 18, 12, 6, 19, 5, 4, 7, 7, 22, 33, 3, 25, 21, 13, 7, 17, 30, 32, 30, 3, 15, 8, 5, 10, 9, 18, 17, 4, 13, 20, 8, 12, 18, 5, 24, 30, 25, 28, 14, 9, 7, 23, 25, 21, 10, 28, 19, 10, 22, 14, 7, 3, 6, 1, 22, 1, 26, 18, 16, 10, 3, 20, 27, 22, 20, 3, 5, 18, 11, 25, 9, 24, 11, 15, 9, 1, 8, 29, 19, 28, 27, 11, 8, 8, 29, 7, 33, 7, 22, 11, 6, 26, 11, 20, 13, 9, 20, 9, 6, 22, 31, 20, 19, 19, 19, 27, 24, 26, 3, 23, 18, 9, 6, 1, 19, 13, 8, 4, 2, 31, 16, 3, 23, 7, 13, 15, 25, 14, 27, 12, 4, 7, 8, 5, 33, 13, 9, 18, 19, 3, 22, 28, 32, 29, 19, 26, 32, 30, 6, 26, 25, 33, 6, 8, 18, 17, 5, 3, 13, 33, 28, 10, 14, 16, 17, 23, 24, 10, 18, 2, 22, 15, 2, 9, 7, 16, 23, 11, 26, 22, 16, 16, 5, 23, 20, 16, 11, 26, 24, 30, 26, 19, 33, 15, 15, 14, 5, 3, 29, 8, 25, 22, 6, 5, 11, 8, 16, 28, 11, 10, 5, 30, 33, 3, 1, 15, 13, 30, 11, 21, 30, 23, 21, 24, 33, 18, 12, 11, 32, 17, 23, 33, 29, 1, 19, 13, 24, 15, 16, 9, 12, 10, 21, 4, 12, 18, 18, 28, 5, 18, 6, 33, 15, 14, 12, 11, 25, 6, 11, 28, 33, 13, 19, 14, 23, 14, 17, 28, 24, 1, 5, 14, 5, 12, 25, 10, 8, 25, 4, 22, 10, 12, 25, 28, 29, 21, 26, 27, 32, 8, 33, 24, 16, 31, 24, 32, 7, 10, 5, 14, 11, 18, 16, 33, 7, 33, 9, 27, 16, 23, 15, 21, 14, 4, 15, 16, 28, 23, 15, 21, 2, 32, 5, 13, 1, 32, 25, 33, 29, 23, 6, 10, 33, 6, 14, 29, 14, 14, 8, 19, 28, 27, 25, 21, 15, 23, 13, 2, 18, 30, 12, 28, 21, 23, 9, 22, 6, 18, 30, 25, 20, 24, 14, 23, 19, 22, 18, 5, 23, 4, 13, 16, 8, 4, 29, 30, 26, 3, 19, 33, 15, 30, 4, 18, 11, 16, 12, 30, 25, 9, 29, 17, 17, 29, 28, 10, 31, 10, 18, 16, 26, 3, 2, 28, 16, 9, 12, 20, 33, 31, 21, 16, 18, 8, 28, 3, 8, 28, 20, 1, 11, 26, 29, 12, 9, 17, 20, 27, 25, 26, 18, 18, 30, 30, 22, 7, 26, 12, 8, 9, 26, 11, 4, 1, 17, 13, 21, 10, 31, 30, 11, 30, 29, 9, 29, 5, 26, 10, 30, 31, 30, 3, 22, 2, 2, 33, 33, 19, 20, 22, 21, 11, 15, 27, 30, 1, 4, 20, 7, 22, 7, 9, 21, 20, 33, 6, 28, 6, 25, 24, 15, 24, 22, 23, 13, 25, 29, 26, 16, 8, 10, 8, 9, 13, 29, 9, 16, 32, 21, 19, 32, 14, 16, 29, 23, 3, 21, 30, 31, 32, 3, 18, 11, 24, 27, 30, 4, 23, 26, 27, 8, 18, 19, 4, 25, 8, 17, 23, 3, 32, 1, 2, 8, 24, 25, 11, 22, 18, 1, 3, 25, 2, 2, 19, 25, 21, 15, 30, 24, 13, 30, 7, 9, 15, 27, 19, 6, 33, 26, 14, 27, 6, 22, 13, 8, 17, 33, 11, 6, 25, 25, 25, 29, 2, 30, 10, 12, 17, 14, 29, 14, 3, 1, 6, 6, 14, 4, 23, 31, 10, 26, 12, 11, 2, 20, 6, 33, 27, 18, 21, 6, 31, 16, 18, 19, 18, 29, 3, 3, 13, 10, 25, 15, 5, 7, 10, 20, 16, 29, 26, 19, 12, 29, 28, 24, 8, 8, 5, 32, 28, 23, 8, 25, 16, 25, 23, 1, 33, 9, 26, 24, 30, 25, 32, 24, 19, 17, 13, 25, 19, 5, 1, 9, 26, 17, 19, 10, 17, 5, 3, 2, 31, 6, 1, 25, 15, 2, 25, 11, 11, 24, 30, 30, 20, 21, 24, 1, 6, 23, 5, 33, 17, 18, 2, 27, 29, 29, 4, 1, 18, 25, 5, 1, 21, 8, 2, 1, 17, 25, 17, 3, 12, 23, 33, 27, 6, 24, 27, 22, 20, 12, 4, 1, 3, 30, 10, 20, 14, 6, 18, 20, 3, 17, 29, 16, 24, 23, 2, 24, 11, 1, 29, 2, 3, 2, 2, 28, 3, 20, 28, 33, 5, 23, 2, 17, 29, 8, 15, 19, 32, 8, 10, 18, 30, 27, 11, 3, 26, 28, 17, 15, 25, 28, 7, 9, 33, 12, 19, 17, 23, 2, 26, 30, 1, 6, 18, 1, 30, 7, 19, 30, 3, 1, 33, 23, 2, 31, 2, 2, 5, 15, 6, 1, 2, 16, 23, 20, 4, 9, 32, 2, 33, 29, 16, 26, 2, 19, 30, 23, 29, 10, 32, 23, 3, 30, 32, 11, 25, 30, 19, 18, 32, 5, 26, 18, 10, 6, 6, 6, 10, 27, 4, 12, 17, 13, 14, 12, 8, 19, 11, 3, 29, 6, 32, 14, 15, 12, 27, 25, 1, 13, 3, 28, 10, 24, 12, 6, 25, 9, 1, 10, 4, 16, 19, 25, 3, 2, 12, 13, 26, 10, 4, 9, 5, 4, 17, 18, 8, 22, 3, 13, 12, 14, 16, 33, 8, 2, 22, 23, 33, 5, 10, 8, 27, 30, 11, 15, 11, 30, 28, 33, 4, 23, 30, 24, 8, 13, 11, 4, 16, 13, 23, 9, 9, 9, 20, 6, 31, 6, 27, 21, 1, 20, 18, 29, 10, 13, 28, 5, 32, 32, 8, 22, 6, 21, 23, 9, 10, 5, 21, 23, 24, 4, 15, 32, 32, 28, 14, 30, 11, 7, 27, 16, 16, 28, 27, 13, 4, 10, 3, 14, 20, 6, 20, 20, 5, 6, 10, 6, 27, 1, 33, 12, 22, 10, 29, 4, 3, 9, 3, 16, 27, 31, 30, 4, 6, 29, 24, 28, 31, 8, 28, 19, 32, 15, 12, 17, 13, 3, 14, 19, 12, 16, 24, 10, 13, 30, 18, 23, 20, 24, 25, 1, 30, 11, 8, 21, 15, 28, 11, 32, 18, 10, 9, 12, 19, 20, 7, 23, 27, 5, 5, 20, 28, 31, 27, 24, 4, 20, 26, 14, 23, 27, 25, 28, 27, 7, 20, 7, 28, 11, 15, 2, 13, 7, 8, 2, 11, 9, 24, 6, 21, 19, 19, 13, 8, 28, 17, 12, 9, 32, 9, 24, 30, 18, 10, 33, 8, 17, 33, 15, 30, 3, 29, 28, 11, 24, 23, 11, 1, 20, 23, 15, 5, 29, 13, 14, 5, 2, 19, 24, 4, 25, 21, 14, 31, 21, 18, 32, 31, 6, 22, 15, 19, 20, 27, 32, 25, 28, 8, 3, 33, 23, 28, 8, 26, 22, 3, 11, 28, 33, 20, 24, 5, 1, 10, 15, 33, 26, 19, 17, 11, 13, 19, 28, 29, 25, 4, 24, 19, 3, 30, 6, 13, 31, 5, 17, 31, 26, 23, 23, 20, 31, 7, 3, 33, 25, 28, 25, 14, 24, 1, 31, 14, 11, 25, 26, 29, 31, 26, 10, 18, 23, 6, 8, 23, 27, 30, 13, 28, 7, 9, 11, 18, 27, 32, 11, 9, 27, 5, 13, 6, 29, 32, 8, 3, 33, 27, 20, 31, 3, 12, 29, 23, 7, 7, 6, 22, 17, 7, 15, 13, 22, 32, 5, 22, 30, 30, 31, 25, 24, 20, 5, 8, 5, 17, 22, 12, 16, 5, 25, 2, 20, 14, 12, 28, 30, 13, 17, 33, 30, 20, 4, 19, 10, 5, 10, 20, 14, 24, 13, 23, 23, 23, 3, 12, 3, 12, 28, 1, 17, 5, 7, 21, 10, 23, 18, 11, 10, 6, 25, 21, 3, 30, 24, 23, 24, 2, 10, 9, 10, 22, 28, 8, 10, 12, 25, 29, 17, 16, 14, 28, 13, 11, 24, 4, 18, 13, 29, 13, 6, 8, 9, 23, 32, 20, 28, 13, 22, 26, 14, 18, 2, 28, 22, 28, 3, 1, 33, 8, 30, 7, 3, 10, 8, 20, 15, 28, 29, 16, 19, 6, 20, 7, 31, 30, 2, 20, 10, 4, 26, 19, 12, 31, 25, 8, 26, 26, 2, 19, 32, 13, 31, 23, 4, 17, 21, 20, 32, 26, 12, 4, 33, 19, 28, 13, 31, 22, 8, 3, 19, 31, 26, 28, 33, 13, 12, 8, 29, 29, 13, 32, 4, 30, 16, 31, 31, 28, 22, 20, 6, 3, 4, 32, 13, 28, 25, 17, 28, 25, 13, 22, 23, 24, 1, 32, 28, 32, 31, 21, 26, 20, 14, 6, 13, 8, 32, 18, 15, 1, 19, 19, 22, 10, 20, 30, 15, 13, 2, 25, 21, 18, 12, 30, 3, 9, 22, 6, 8, 33, 28, 25, 21, 7, 17, 19, 31, 12, 6, 3, 15, 25, 31, 32, 24, 2, 3, 23, 29, 14, 12, 13, 25, 8, 1, 31, 12, 28, 2, 12, 19, 24, 22, 23, 21, 24, 30, 11, 23, 3, 7, 17, 11, 1, 24, 8, 14, 3, 24, 27, 18, 30, 21, 2, 27, 33, 15, 1, 16, 8, 7, 3, 5, 5, 19, 23, 33, 27, 3, 18, 15, 22, 16, 31, 5, 2, 21, 30, 17, 24, 4, 18, 25, 28, 25, 8, 3, 9, 18, 8, 12, 15, 10, 2, 21, 23, 12, 6, 10, 29, 15, 16, 17, 19, 33, 12, 18, 2, 31, 10, 31, 13, 6, 25, 9, 16, 2, 8, 26, 6, 19, 23, 6, 14, 32, 3, 30, 3, 29, 18, 31, 20, 26, 33, 3, 23, 16, 2, 20, 22, 15, 3, 26, 18, 17, 15, 15, 21, 4, 27, 27, 22, 22, 33, 14, 8, 3, 7, 4, 29, 17, 24, 8, 6, 20, 11, 26, 11, 23, 1, 13, 9, 15, 6, 7, 19, 28, 23, 20, 10, 11, 30, 11, 17, 31, 24, 15, 22, 22, 3, 28, 8, 13, 2, 25, 16, 20, 26, 22, 6, 24, 4, 3, 15, 31, 8, 14, 13, 14, 24, 31, 17, 24, 8, 4, 10, 29, 10, 12, 28, 20, 12, 12, 2, 25, 32, 8, 30, 6, 6, 30, 12, 33, 2, 9, 27, 32, 25, 33, 26, 9, 32, 23, 30, 1, 12, 10, 25, 15, 22, 9, 12, 6, 7, 4, 24, 21, 3, 11, 16, 30, 7, 12, 30, 15, 14, 31, 32, 33, 6, 14, 12, 7, 22, 33, 30, 20, 7, 25, 23, 10, 5, 18, 2, 11, 28, 16, 30, 10, 31, 22, 27, 8, 26, 30, 14, 2, 7, 5, 21, 8, 20, 28, 19, 24, 28, 25, 15, 15, 32, 5, 1, 1, 12, 15, 2, 12, 16, 9, 28, 3, 2, 19, 11, 8, 25, 8, 10, 11, 19, 13, 5, 16, 31, 2, 31, 18, 25, 2, 18, 24, 16, 24, 10, 19, 32, 3, 27, 2, 17, 12, 14, 13, 12, 8, 18, 31, 8, 33, 24, 18, 7, 2, 32, 22, 25, 10, 16, 20, 7, 7, 20, 18, 32, 6, 4, 28, 21, 15, 27, 26, 22, 28, 29, 14, 24, 10, 12, 12, 16, 16, 20, 9, 10, 10, 20, 32, 27, 26, 25, 17, 14, 28, 25, 8, 17, 9, 21, 8, 24, 20, 24, 14, 3, 14, 20, 3, 1, 28, 17, 14, 3, 19, 5, 6, 28, 13, 8, 5, 13, 32, 32, 4, 20, 30, 27, 4, 17, 24, 6, 11, 8, 4, 5, 18, 32, 11, 8, 18, 15, 3, 1, 11, 32, 24, 24, 3, 13, 26, 31, 28, 4, 12, 7, 3, 25, 17, 14, 10, 31, 25, 28, 23, 26, 2, 18, 32, 4, 24, 1, 1, 4, 4, 25, 7, 24, 4, 5, 21, 7, 15, 28, 24, 17, 33, 6, 28, 31, 18, 25, 7, 27, 33, 18, 13, 2, 4, 31, 22, 11, 19, 3, 18, 3, 13, 29, 8, 22, 27, 26, 30, 21, 1, 19, 12, 16, 33, 33, 1, 22, 28, 8, 32, 33, 18, 9, 21, 11, 33, 14, 5, 16, 20, 22, 10, 11, 33, 15, 5, 20, 5, 25, 20, 31, 17, 23, 28, 20, 10, 6, 2, 12, 3, 32, 33, 6, 30, 8, 20, 25, 1, 20, 20, 1, 1, 5, 26, 26, 25, 9, 2, 21, 8, 13, 10, 2, 17, 2, 3, 31, 8, 20, 6, 18, 28, 11, 11, 1, 21, 8, 1, 30, 31, 14, 2, 32, 13, 30, 13, 5, 25, 33, 27, 2, 30, 14, 19, 33, 9, 4, 28, 12, 27, 20, 9, 28, 18, 19, 32, 8, 30, 3, 17, 30, 11, 9, 27, 30, 1, 7, 2, 30, 5, 4, 9, 21, 23, 31, 5, 21, 21, 28, 19, 14, 3, 11, 6, 8, 11, 24, 14, 11, 13, 1, 22, 19, 15, 2, 32, 5, 18, 32, 19, 25, 21, 8, 6, 29, 1, 4, 11, 30, 18, 9, 32, 25, 9, 26, 1, 8, 30, 9, 16, 22, 14, 9, 20, 13, 32, 15, 23, 3, 28, 15, 11, 23, 17, 14, 13, 7, 23, 7, 12, 33, 6, 23, 4, 27, 12, 33, 20, 12, 5, 16, 16, 19, 4, 10, 11, 5, 17, 10, 21, 15, 6, 1, 3, 12, 20, 4, 6, 33, 22, 12, 24, 27, 9, 28, 7, 17, 4, 13, 25, 3, 22, 14, 32, 22, 20, 11, 20, 24, 27, 22, 30, 13, 33, 19, 11, 14, 27, 6, 16, 29, 30, 2, 9, 26, 25, 1, 33, 25, 15, 17, 14, 21, 27, 25, 3, 30, 27, 18, 27, 13, 13, 26, 32, 19, 15, 21, 19, 15, 2, 16, 16, 9, 27, 2, 3, 9, 14, 27, 27, 1, 5, 31, 27, 3, 21, 3, 12, 29, 6, 21, 18, 8, 21, 9, 22, 25, 6, 7, 18, 10, 2, 30, 20, 23, 14, 9, 22, 27, 24, 32, 11, 17, 6, 31, 23, 33, 15, 30, 5, 29, 14, 6, 2, 24, 17, 33, 31, 11, 20, 8, 10, 33, 32, 28, 17, 17, 3, 3, 25, 14, 25, 2, 7, 6, 6, 6, 11, 1, 1, 22, 25, 12, 16, 31, 33, 13, 26, 18, 10, 19, 10, 21, 29, 24, 17, 22, 8, 6, 6, 29, 5, 25, 26, 14, 25, 14, 1, 8, 5, 4, 14, 5, 20, 16, 15, 17, 26, 31, 4, 8, 12, 18, 4, 18, 3, 19, 32, 30, 33, 27, 20, 23, 13, 5, 9, 18, 20, 13, 21, 22, 28, 7, 17, 18, 8, 19, 4, 9, 28, 14, 32, 4, 17, 31, 27, 14, 3, 1, 33, 3, 17, 24, 15, 24, 28, 8, 9, 10, 15, 16, 5, 15, 13, 8, 11, 6, 22, 23, 3, 3, 18, 13, 28, 24, 17, 23, 19, 24, 17, 6, 32, 6, 9, 17, 12, 29, 26, 30, 3, 20, 10, 29, 21, 27, 1, 11, 15, 11, 27, 6, 3, 2, 16, 26, 21, 5, 7, 33, 28, 3, 15, 7, 12, 9, 20, 28, 18, 3, 14, 26, 3, 1, 3, 4, 15, 19, 25, 29, 21, 29, 27, 29, 6, 27, 30, 10, 15, 33, 2, 6, 11, 24, 21, 19, 7, 28, 24, 14, 2, 19, 18, 28, 32, 9, 8, 17, 3, 23, 5, 11, 13, 8, 20, 13, 31, 19, 15, 13, 4, 18, 27, 24, 32, 8, 8, 26, 4, 18, 11, 1, 18, 29, 26, 16, 15, 1, 6, 12, 11, 10, 26, 19, 24, 12, 11, 20, 25, 20, 6, 19, 6, 11, 27, 22, 18, 10, 1, 19, 26, 17, 6, 15, 13, 30, 33, 4, 27, 11, 1, 17, 21, 1, 24, 15, 1, 1, 11, 10, 26, 27, 1, 15, 29, 3, 24, 21, 24, 7, 9, 16, 25, 9, 29, 10, 9, 28, 21, 2, 25, 6, 28, 30, 15, 26, 5, 29, 7, 3, 29, 25, 14, 5, 15, 3, 19, 28, 11, 17, 21, 13, 11, 13, 2, 8, 19, 3, 3, 18, 25, 15, 27, 6, 11, 18, 10, 4, 18, 22, 9, 21, 17, 2, 29, 1, 11, 22, 2, 11, 1, 15, 11, 8, 17, 16, 23, 23, 20, 18, 10, 14, 7, 12, 24, 29, 22, 8, 5, 16, 20, 11, 24, 21, 4, 32, 7, 26, 24, 33, 18, 14, 1, 4, 26, 10, 26, 14, 30, 14, 7, 15, 7, 27, 5, 14, 25, 31, 8, 8, 11, 16, 30, 3, 30, 16, 18, 20, 6, 19, 11, 23, 19, 27, 22, 15, 1, 7, 1, 19, 25, 6, 31, 12, 19, 24, 28, 6, 10, 30, 29, 3, 30, 15, 5, 3, 2, 6, 19, 30, 29, 25, 3, 8, 14, 23, 1, 18, 5, 23, 12, 4, 29, 12, 14, 22, 15, 28, 28, 4, 17, 29, 10, 20, 19, 19, 19, 26, 23, 10, 21, 27, 15, 19, 5, 32, 9, 1, 5, 3, 11, 14, 21, 24, 19, 23, 15, 12, 24, 19, 11, 7, 33, 11, 16, 27, 25, 22, 5, 11, 9, 9, 31, 22, 20, 28, 32, 30, 10, 11, 30, 32, 13, 24, 18, 2, 7, 24, 23, 19, 12, 10, 18, 4, 25, 12, 7, 22, 31, 11, 31, 3, 28, 5, 27, 27, 31, 25, 8, 25, 30, 13, 7, 19, 1, 4, 15, 3, 24, 25, 2, 32, 26, 18, 8, 30, 13, 15, 4, 27, 2, 31, 26, 12, 9, 9, 21, 2, 22, 18, 10, 30, 27, 27, 16, 16, 18, 33, 18, 22, 27, 10, 30, 27, 2, 14, 21, 11, 33, 30, 3, 15, 20, 21, 32, 18, 24, 24, 22, 7, 16, 20, 27, 13, 7, 21, 16, 20, 16, 17, 18, 27, 25, 13, 8, 6, 31, 20, 12, 15, 20, 27, 8, 5, 10, 22, 3, 5, 27, 13, 12, 18, 18, 10, 24, 5, 23, 13, 15, 5, 28, 18, 16, 8, 11, 15, 21, 30, 7, 30, 2, 19, 27, 2, 22, 10, 25, 9, 15, 8, 2, 11, 26, 17, 29, 21, 30, 8, 25, 3, 11, 26, 3, 25, 3, 5, 4, 23, 25, 28, 28, 16, 25, 32, 10, 1, 30, 25, 24, 9, 25, 23, 6, 4, 29, 13, 6, 11, 6, 24, 9, 27, 9, 19, 21, 11, 31, 18, 19, 8, 16, 16, 17, 3, 26, 19, 33, 29, 16, 1, 28, 13, 3, 17, 11, 31, 10, 4, 32, 23, 26, 28, 23, 2, 7, 4, 32, 6, 20, 2, 14, 17, 12, 21, 25, 7, 8, 4, 5, 12, 13, 15, 32, 21, 23, 32, 12, 27, 26, 21, 5, 25, 8, 22, 17, 21, 19, 2, 5, 33, 22, 3, 29, 31, 33, 23, 31, 15, 24, 32, 24, 28, 19, 29, 3, 29, 12, 19, 25, 17, 14, 4, 15, 24, 14, 2, 21, 27, 23, 33, 10, 18, 31, 4, 2, 6, 12, 30, 11, 16, 18, 4, 8, 26, 16, 9, 22, 7, 10, 11, 19, 21, 15, 19, 8, 26, 21, 10, 29, 5, 8, 5, 15, 4, 25, 7, 28, 21, 8, 22, 18, 25, 1, 5, 14, 20, 1, 11, 12, 14, 25, 20, 24, 10, 25, 9, 21, 14, 11, 3, 16, 9, 18, 3, 9, 32, 14, 8, 11, 15, 13, 16, 20, 22, 17, 1, 24, 19, 18, 15, 5, 27, 29, 31, 11, 14, 16, 31, 2, 20, 2, 20, 15, 16, 19, 4, 33, 1, 11, 2, 4, 14, 12, 19, 18, 32, 1, 29, 17, 22, 23, 29, 20, 24, 2, 10, 28, 19, 23, 12, 19, 18, 19, 20, 30, 27, 9, 18, 13, 17, 6, 31, 20, 19, 10, 14, 28, 13, 24, 1, 1, 8, 16, 6, 28, 13, 33, 18, 3, 2, 16, 20, 5, 4, 26, 12, 31, 25, 16, 25, 25, 12, 12, 25, 6, 19, 31, 30, 5, 24, 23, 18, 6, 19, 6, 9, 15, 5, 4, 15, 6, 16, 3, 15, 3, 3, 24, 10, 21, 16, 1, 5, 23, 24, 2, 9, 1, 29, 28, 21, 28, 30, 13, 28, 28, 7, 22, 3, 31, 3, 32, 2, 27, 32, 19, 24, 24, 24, 30, 5, 30, 12, 28, 19, 11, 19, 2, 8, 9, 27, 3, 25, 32, 2, 16, 32, 6, 32, 25, 32, 16, 26, 26, 9, 17, 26, 15, 19, 11, 1, 21, 20, 19, 11, 12, 30, 17, 31, 31, 26, 20, 6, 17, 26, 18, 30, 14, 29, 15, 20, 2, 28, 19, 3, 31, 32, 21, 6, 9, 10, 21, 2, 4, 7, 29, 20, 27, 10, 2, 31, 11, 31, 2, 26, 9, 8, 12, 2, 8, 11, 2, 15, 12, 10, 22, 16, 23, 21, 17, 16, 8, 9, 16, 30, 7, 24, 26, 1, 27, 10, 27, 22, 26, 22, 30, 4, 10, 23, 1, 4, 27, 6, 16, 15, 31, 21, 4, 10, 9, 24, 25, 32, 18, 8, 7, 8, 19, 14, 2, 2, 26, 32, 20, 29, 26, 21, 8, 20, 15, 11, 13, 3, 15, 26, 29, 4, 24, 17, 2, 5, 10, 7, 7, 5, 31, 16, 23, 6, 25, 14, 2, 32, 20, 17, 16, 26, 15, 21, 2, 9, 8, 28, 4, 19, 13, 14, 8, 2, 17, 4, 8, 14, 25, 17, 4, 14, 7, 18, 21, 15, 16, 29, 29, 28, 23, 33, 6, 32, 2, 33, 11, 30, 11, 19, 1, 6, 16}, 5994));
        assertEquals(389973, s.numSubarrayProductLessThanK(new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 5));
    }
}
