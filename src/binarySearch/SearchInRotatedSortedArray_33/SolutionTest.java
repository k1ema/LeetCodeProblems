package binarySearch.SearchInRotatedSortedArray_33;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(8, s.search(new int[] {4, 5, 6, 7, 8, 9, 0, 1, 2}, 2));
        assertEquals(4, s.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0));
        assertEquals(2, s.search(new int[] {6, 7, 0, 1, 2, 3, 4}, 0));
        assertEquals(0, s.search(new int[] {0, 1, 2, 4, 5, 6, 7}, 0));
        assertEquals(1, s.search(new int[] {3, 1}, 1));
        assertEquals(0, s.search(new int[] {1, 3}, 1));
        assertEquals(-1, s.search(new int[] {1, 3}, 2));
        assertEquals(0, s.search(new int[] {5, 1, 3}, 5));
        assertEquals(1, s.search(new int[] {8, 9, 2, 3, 4}, 9));
    }
}