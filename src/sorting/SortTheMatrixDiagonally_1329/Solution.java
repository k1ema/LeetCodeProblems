package sorting.SortTheMatrixDiagonally_1329;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 1329. Sort the Matrix Diagonally
 * https://leetcode.com/problems/sort-the-matrix-diagonally/
 *
 * A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column
 * and going in the bottom-right direction until reaching the matrix's end. For example, the matrix diagonal starting
 * from mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and mat[4][2].
 *
 * Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.
 *
 * Example 1:
 * Input: mat = [[3,3,1,1],
 *               [2,2,1,2],
 *               [1,1,1,2]]
 * Output: [[1,1,1,1],
 *          [1,2,2,2],
 *          [1,2,3,3]]
 *
 * Constraints:
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * 1 <= mat[i][j] <= 100
 */
public class Solution {
    // tc O(mn*log(min(m,n))), sc O(min(m,n))
    // The space is used by the list with diagonal elements, and the longest diagonal contains not more than min(m,n) elements.
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        for (int i = m - 1; i >= 0; i--) {
            sortDiagonal(mat, i, 0);
        }
        for (int j = 1; j < n; j++) {
            sortDiagonal(mat, 0, j);
        }
        return mat;
    }

    private void sortDiagonal(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        int i = r, j = c;
        List<Integer> diag = new ArrayList<>();
        while (i < m && j < n) {
            diag.add(mat[i++][j++]);
        }
        Collections.sort(diag);
        i = r; j = c; int k = 0;
        while (i < m && j < n) {
            mat[i++][j++] = diag.get(k++);
        }
    }

    // tc O(mn*log(min(m,n))), sc O(m*n)
    public int[][] diagonalSort1(int[][] mat) {
        Map<Integer, PriorityQueue<Integer>> h = new HashMap<>();
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                h.putIfAbsent(i - j, new PriorityQueue<>());
                h.get(i - j).add(mat[i][j]);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = h.get(i - j).poll();
            }
        }

        return mat;
    }
}
