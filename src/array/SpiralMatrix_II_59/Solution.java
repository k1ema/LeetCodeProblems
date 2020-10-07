package array.SpiralMatrix_II_59;

/**
 * 59. Spiral Matrix II
 * https://leetcode.com/problems/spiral-matrix-ii/
 *
 * Given a positive integer n, generate a square matrix filled with
 * elements from 1 to n2 in spiral order.
 *
 * Example:
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int num = 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                res[top][i] = num++;
            }
            top++;
            if (top > bottom || left > right) break;

            for (int i = top; i <= bottom; i++) {
                res[i][right] = num++;
            }
            right--;
            if (top > bottom || left > right) break;

            for (int i = right; i >= left; i--) {
                res[bottom][i] = num++;
            }
            bottom--;
            if (top > bottom || left > right) break;

            for (int i = bottom; i >= top; i--) {
                res[i][left] = num++;
            }
            left++;
            if (top > bottom || left > right) break;
        }
        return res;
    }
}
