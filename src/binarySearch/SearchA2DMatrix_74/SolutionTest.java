package binarySearch.SearchA2DMatrix_74;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.searchMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 1));
        assertTrue(s.searchMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 3));
        assertTrue(s.searchMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 7));
        assertTrue(s.searchMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 10));
        assertTrue(s.searchMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 16));
        assertTrue(s.searchMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 20));
        assertTrue(s.searchMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 23));
        assertTrue(s.searchMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 50));
        assertFalse(s.searchMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 0));
        assertFalse(s.searchMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 4));
        assertFalse(s.searchMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 8));
        assertFalse(s.searchMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 12));
        assertFalse(s.searchMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 21));
        assertFalse(s.searchMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 55));
        assertFalse(s.searchMatrix(new int[][] {}, 55));
        assertFalse(s.searchMatrix(new int[][] {{}}, 55));
    }
}