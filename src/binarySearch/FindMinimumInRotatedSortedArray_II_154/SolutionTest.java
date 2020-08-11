package binarySearch.FindMinimumInRotatedSortedArray_II_154;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.findMin(new int[] {1, 3, 5}));
        assertEquals(0, s.findMin(new int[] {2, 2, 2, 0, 1}));
        assertEquals(0, s.findMin(new int[] {2, 2, 0, 1, 2}));
        assertEquals(1, s.findMin(new int[] {3, 1, 3, 3}));
    }
}