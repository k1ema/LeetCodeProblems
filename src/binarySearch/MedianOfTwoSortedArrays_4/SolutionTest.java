package binarySearch.MedianOfTwoSortedArrays_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2.0, s.findMedianSortedArrays(new int[] {1, 3}, new int[] {2}), 0.1);
        assertEquals(2.5, s.findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}), 0.1);
        assertEquals(2.5, s.findMedianSortedArrays(new int[] {}, new int[] {2, 3}), 0.1);
        assertEquals(2.0, s.findMedianSortedArrays(new int[] {2}, new int[] {}), 0.1);
        assertEquals(3.5, s.findMedianSortedArrays(new int[] {1, 2, 3, 5, 6}, new int[] {4}), 0.1);
        assertEquals(11, s.findMedianSortedArrays(new int[] {1, 3, 8, 9, 15}, new int[] {7, 11, 18, 19, 21, 25}), 0.1);
        assertEquals(13.5, s.findMedianSortedArrays(new int[] {23, 26, 31, 35}, new int[] {3, 5, 7, 9, 11, 16}), 0.1);
        assertEquals(11, s.findMedianSortedArrays(new int[] {1, 2, 4, 7, 15}, new int[] {21, 22, 30}), 0.1);
    }
}
