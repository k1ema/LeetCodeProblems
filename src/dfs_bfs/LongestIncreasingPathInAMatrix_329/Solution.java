package dfs_bfs.LongestIncreasingPathInAMatrix_329;

/**
 * 329. Longest Increasing Path in a Matrix
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 *
 * Given an integer matrix, find the length of the longest increasing path.
 *
 * From each cell, you can either move to four directions: left, right, up or down. You may NOT move
 * diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 *
 * Example 1:
 * Input: nums =
 * [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 *
 * Example 2:
 * Input: nums =
 * [
 *   [3,4,5],
 *   [3,2,6],
 *   [2,2,1]
 * ]
 * Output: 4
 * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */
public class Solution {
    // tc O(mn), sc O(mn)
    // 10 ms, faster than 34.30%; 39.3 MB, less than 68.80%
    // with visited[i][j] array 256 ms
    // but we do not need visited[i][j] array since we have condition matrix[newI][newJ] > matrix[i][j]
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int res = 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, i, j, m, n, memo));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int i, int j, int m, int n, int[][] memo) {
        if (memo[i][j] != 0) return memo[i][j];
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int res = 1;
        for (int[] dir : dirs) {
            int newI = i + dir[0], newJ = j + dir[1];
            if (newI >= 0 && newI < m && newJ >=0 && newJ < n && matrix[newI][newJ] > matrix[i][j]) {
                res = Math.max(res, 1 + dfs(matrix, newI, newJ, m, n, memo));
            }
        }
        memo[i][j] = res;
        return res;
    }
}
