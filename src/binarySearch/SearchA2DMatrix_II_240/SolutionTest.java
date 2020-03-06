package binarySearch.SearchA2DMatrix_II_240;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        int[][] matrix = new int[][] {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        assertTrue(s.searchMatrix(matrix, 5));
        assertFalse(s.searchMatrix(matrix, 20));

        assertFalse(s.searchMatrix(new int[][] {{}}, 1));

        matrix = new int[][] {
                {1,   3,  5,  7,  9},
                {2,   4,  6,  8, 10},
                {11, 13, 15, 17, 19},
                {12, 14, 16, 18, 20},
                {21, 22, 23, 24, 25}

        };
        assertTrue(s.searchMatrix(matrix, 5));
        assertTrue(s.searchMatrix(matrix, 11));
        assertTrue(s.searchMatrix(matrix, 13));

        matrix = new int[][] {
                {1,   2,  3,  4,  5},
                {6,   7,  8,  9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        assertTrue(s.searchMatrix(matrix, 15));

        matrix = new int[][] {
                {1,  2, 11, 12, 21},
                {3,  4, 13, 14, 22},
                {5,  6, 15, 16, 23},
                {7,  8, 17, 18, 24},
                {9, 10, 19, 20, 25}
        };
        assertTrue(s.searchMatrix(matrix, 11));
        assertTrue(s.searchMatrix(matrix, 5));
        assertTrue(s.searchMatrix(matrix, 15));
    }
}