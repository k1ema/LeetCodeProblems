package dfs_bfs.Matrix01_542;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 Matrix
 * https://leetcode.com/problems/01-matrix/
 *
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1.
 *
 * Example 1:
 * Input:
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 *
 * Output:
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 *
 * Example 2:
 * Input:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,1,1]]
 *
 * Output:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,2,1]]
 *
 * Note:
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right.
 */
public class Solution {
    // BFS
    // tc O(mn), sc O(mn)
    // 14 ms, faster than 72.67%; 41.9 MB, less than 79.89%
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];
        for (int[] row : res) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(10000 * i + j);
                    res[i][j] = 0;
                }
            }
        }
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while (!queue.isEmpty()) {
            int val = queue.poll();
            int i = val / 10000, j = val % 10000;
            for (int[] dir : dirs) {
                int newI = i + dir[0], newJ = j + dir[1];
                if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && res[i][j] + 1 < res[newI][newJ]) {
                    res[newI][newJ] = res[i][j] + 1;
                    queue.add(10000 * newI + newJ);
                }
            }
        }
        return res;
    }

    // DFS
    // Assign a large value to all the positions with value 1 and don't have 0 neighbors
    // Start dfs search from positions whose value is 1
    // tc O(mn), sc O(mn)
    // 10 ms, faster than 87.41%; 43 MB, less than 62.52%
    public int[][] updateMatrix1(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1 && !hasNeighbourZero(matrix, i, j)) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) dfs(matrix, i, j, 1);
            }
        }

        return matrix;
    }

    private void dfs(int[][] matrix, int i, int j, int val) {
        if (i < 0 || i == matrix.length || j < 0 || j == matrix[i].length || matrix[i][j] < val) return;

        matrix[i][j] = val;

        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int[] dir : dirs) {
            dfs(matrix, i + dir[0], j + dir[1], 1 + matrix[i][j]);
        }
    }

    private boolean hasNeighbourZero(int[][] matrix, int i, int j) {
        if (i > 0 && matrix[i - 1][j] == 0 || i < matrix.length - 1 && matrix[i + 1][j] == 0
                || j > 0 && matrix[i][j - 1] == 0 || j < matrix[i].length - 1 && matrix[i][j + 1] == 0) {
            return true;
        }
        return false;
    }
}
