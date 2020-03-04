package array.RotateImage_48;

/**
 * 48. Rotate Image
 * https://leetcode.com/problems/rotate-image/
 *
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 *
 * Note:
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 * Example 2:
 * Given input matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */
public class Solution {
    // tc O(n*n), sc O(1)
    // 0 ms, faster than 100.00%; 38.6 MB, less than 5.77%
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 1) return;
        int n = matrix.length - 1;
        for (int row = 0; row < matrix.length / 2; row++) {
            for (int col = row; col < n - row; col++) {
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[n - col][row];
                matrix[n - col][row] = matrix[n - row][n - col];
                matrix[n - row][n - col] = matrix[col][n - row];
                matrix[col][n - row] = tmp;
            }
        }
    }

    // https://discuss.leetcode.com/topic/6796/a-common-method-to-rotate-the-image
    public void rotate1(int[][] matrix) {
        if (matrix == null || matrix.length < 2) return;
        reverse(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                swap(matrix, i, j);
            }
        }
    }

    private void reverse(int[][] matrix) {
        int[] temp;
        for (int i = 0; i < matrix.length / 2; i++) {
            temp = matrix[i];
            matrix[i] = matrix[matrix.length - 1 - i];
            matrix[matrix.length - 1 - i] = temp;
        }
    }

    private void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}
