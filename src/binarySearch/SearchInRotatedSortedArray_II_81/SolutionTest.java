package binarySearch.SearchInRotatedSortedArray_II_81;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.search(new int[] {2, 5, 6, 0, 0, 1, 2}, 0));
        assertTrue(s.search(new int[] {2, 5, 6, 0, 0, 1, 2}, 1));
        assertTrue(s.search(new int[] {2, 5, 6, 0, 0, 1, 2}, 2));
        assertFalse(s.search(new int[] {2, 5, 6, 0, 0, 1, 2}, 3));
        assertFalse(s.search(new int[] {2, 5, 6, 0, 0, 1, 2}, 4));
        assertTrue(s.search(new int[] {2, 5, 6, 0, 0, 1, 2}, 5));
        assertTrue(s.search(new int[] {2, 5, 6, 0, 0, 1, 2}, 6));
        assertFalse(s.search(new int[] {2, 5, 6, 0, 0, 1, 2}, 7));
        assertTrue(s.search(new int[] {3, 3, 3, 1}, 1));
        assertTrue(s.search(new int[] {1, 1, 1, 1, 3}, 3));
        assertTrue(s.search(new int[] {1, 3, 1, 1, 1}, 3));
    }
}