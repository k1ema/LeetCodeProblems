package array.DiagonalTraverse_498;

import java.util.*;

/**
 * 498. Diagonal Traverse
 * https://leetcode.com/problems/diagonal-traverse/
 *
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the
 * matrix in diagonal order as shown in the below image.
 *
 * Example:
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output:  [1,2,4,7,5,3,6,8,9]
 *
 * Explanation: see link
 *
 * Note:
 * The total number of elements of the given matrix will not exceed 10,000.
 */
public class Solution {
    // the sum of indices on all diagonals are equal
    // tc O(mn), sc O(mn)
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];
        Map<Integer, List<Integer>> dict = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = i + j;
                dict.putIfAbsent(sum, new ArrayList<>());
                dict.get(sum).add(matrix[i][j]);
            }
        }
        int idx = 0;
        for (Map.Entry<Integer, List<Integer>> entry : dict.entrySet()) {
            List<Integer> tempList;
            if (entry.getKey() % 2 == 0) {
                tempList = entry.getValue();
                Collections.reverse(tempList);
            } else {
                tempList = entry.getValue();
            }
            for (int i = 0; i < tempList.size(); i++) {
                res[idx++] = tempList.get(i);
            }
        }
        return res;
    }

    // tc O(mn), sc O(1)
    public int[] findDiagonalOrder1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[] {};

        int m = matrix.length, n = matrix[0].length;
        int[] res = new int[m * n];
        int i = 0, j = 0, k = 0;
        boolean up = true;
        while (k < res.length) {
            res[k++] = matrix[i][j];
            if (up) {
                if (i > 0 && j < n - 1) {
                    i--; j++;
                } else {
                    up = false;
                    if (j == n - 1) i++;
                    else j++;
                }
            } else {
                if (i < m - 1 && j > 0) {
                    i++; j--;
                } else {
                    up = true;
                    if (i == m - 1) j++;
                    else i++;
                }
            }
        }
        return res;
    }
}
