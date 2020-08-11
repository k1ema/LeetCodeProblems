package binarySearch.FindMinimumInRotatedSortedArray_153;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.findMin(new int[] {3, 4, 5, 1, 2}));
        assertEquals(0, s.findMin(new int[] {4, 5, 6, 7, 0, 1, 2}));
        assertEquals(0, s.findMin(new int[] {0, 1, 2, 4, 5, 6, 7}));
        assertEquals(0, s.findMin(new int[] {7, 0, 1, 2, 4, 5, 6}));
        assertEquals(1, s.findMin(new int[] {2, 1}));
    }
}
