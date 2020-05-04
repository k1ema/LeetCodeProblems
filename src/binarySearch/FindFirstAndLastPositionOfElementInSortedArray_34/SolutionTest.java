package binarySearch.FindFirstAndLastPositionOfElementInSortedArray_34;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {2, 2}, s.searchRange(new int[] {5, 6, 7, 8, 8}, 7));
        assertArrayEquals(new int[] {3, 4}, s.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8));
        assertArrayEquals(new int[] {-1, -1}, s.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 6));
        assertArrayEquals(new int[] {0, 0}, s.searchRange(new int[] {1}, 1));
        assertArrayEquals(new int[] {0, 1}, s.searchRange(new int[] {1, 1}, 1));
        assertArrayEquals(new int[] {-1, -1}, s.searchRange(new int[] {0}, 1));
        assertArrayEquals(new int[] {0, 2}, s.searchRange(new int[] {8, 8, 8}, 8));
        assertArrayEquals(new int[] {0, 12}, s.searchRange(new int[] {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8}, 8));
        assertArrayEquals(new int[] {1, 11}, s.searchRange(new int[] {1, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9}, 8));
        assertArrayEquals(new int[] {1, 1}, s.searchRange(new int[] {1, 4}, 4));
    }
}
