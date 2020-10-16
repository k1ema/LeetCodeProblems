package binarySearch.SearchA2DMatrix_II_240;

/**
 * 240. Search a 2D Matrix II
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the
 * following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 * Example:
 * Consider the following matrix:
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * Given target = 20, return false.
 */
public class Solution {
    // tc O(m + n), sc O(1)
    // 5 ms, faster than 99.64%; 42.2 MB, less than 100.00%
    // https://leetcode.com/problems/search-a-2d-matrix-ii/discuss/66140/My-concise-O(m%2Bn)-Java-solution
    boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) return true;
            else if (target < matrix[row][col]) col--;
            else row++;
        }
        return false;
    }

    // tc O(mlogn), sc O(1)
    // 7 ms, faster than 28.83%; 42 MB, less than 100.00%
    boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        for (int i = 0; i < m; i++) {
            if (bs(matrix[i], target)) return true;
        }
        return false;
    }

    private boolean bs(int[] nums, int target) {
        int l = -1, r = nums.length;
        while (r - l > 1) {
            int m = (l + r) >>> 1;
            if (nums[m] < target) {
                l = m;
            } else {
                r = m;
            }
        }
        return r != nums.length && nums[r] == target;
    }
}
