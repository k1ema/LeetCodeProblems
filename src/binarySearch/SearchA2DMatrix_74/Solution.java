package binarySearch.SearchA2DMatrix_74;

/**
 * 74. Search a 2D Matrix
 * https://leetcode.com/problems/search-a-2d-matrix/
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * - Integers in each row are sorted from left to right.
 * - The first integer of each row is greater than the last integer of the previous row.
 *
 * Example 1:
 * Input: matrix = [
 *              [1,3,5,7],
 *              [10,11,16,20],
 *              [23,30,34,50]], target = 3
 * Output: true
 *
 * Example 2:
 * Input: matrix = [
 *              [1,3,5,7],
 *              [10,11,16,20],
 *              [23,30,34,50]], target = 13
 * Output: false
 *
 * Example 3:
 * Input: matrix = [], target = 0
 * Output: false
 *
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 0 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 */
public class Solution {
    /*
        tc O(logm + logn) = O(log(mn)), sc O(1) - 2d binary search
        1. use bs to fetch proper row
        2. use bs to find if that row contains target
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int l = -1, r = matrix.length;
        while (r - l > 1) {
            int m = (l + r) >>> 1;
            if (matrix[m][0] <= target) {
                l = m;
            } else {
                r = m;
            }
        }
        if (l == -1) return false;
        int row = l;
        l = -1; r = matrix[0].length;
        while (r - l > 1) {
            int m = (l + r) >>> 1;
            if (matrix[row][m] <= target) {
                l = m;
            } else {
                r = m;
            }
        }
        return l != -1 && matrix[row][l] == target;
    }
}
