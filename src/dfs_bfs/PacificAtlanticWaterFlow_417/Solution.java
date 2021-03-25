package dfs_bfs.PacificAtlanticWaterFlow_417;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/**
 * 417. Pacific Atlantic Water Flow
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 *
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent,
 * the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the
 * right and bottom edges.
 *
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
 *
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 *
 * Note:
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 *
 * Example:
 *
 * Given the following 5x5 matrix:
 *
 *   Pacific ~   ~   ~   ~   ~
 *        ~  1   2   2   3  (5) *
 *        ~  3   2   3  (4) (4) *
 *        ~  2   4  (5)  3   1  *
 *        ~ (6) (7)  1   4   5  *
 *        ~ (5)  1   1   2   4  *
 *           *   *   *   *   * Atlantic
 *
 * Return:
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 */
public class Solution {
    // DFS, tc O(mn), sc O(mn)
    // 5 ms, faster than 62.57%; 40.1 MB, less than 78.56%
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return Collections.emptyList();
        }

        int m = matrix.length, n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix, i, 0, pacific);
            dfs(matrix, i, n - 1, atlantic);
        }
        for (int i = 0; i < n; i++) {
            dfs(matrix, 0, i, pacific);
            dfs(matrix, m - 1, i, atlantic);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] matrix, int i, int j, boolean[][] visited) {
        int m = matrix.length, n = matrix[0].length;
        visited[i][j] = true;
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int[] dir : dirs) {
            int newI = i + dir[0], newJ = j + dir[1];
            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && matrix[newI][newJ] >= matrix[i][j] && !visited[newI][newJ]) {
                dfs(matrix, newI, newJ, visited);
            }
        }
    }

    // BFS, tc O(mn), sc O(mn)
    // 5 ms, faster than 62.57%; 40.1 MB, less than 78.56%
    public List<List<Integer>> pacificAtlantic1(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return Collections.emptyList();
        }

        int m = matrix.length, n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            bfs(matrix, i, 0, pacific);
            bfs(matrix, i, n - 1, atlantic);
        }
        for (int i = 0; i < n; i++) {
            bfs(matrix, 0, i, pacific);
            bfs(matrix, m - 1, i, atlantic);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    }

    private void bfs(int[][] matrix, int startI, int startJ, boolean[][] visited) {
        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {startI, startJ});
        visited[startI][startJ] = true;
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int i = p[0], j = p[1];
            for (int[] dir : dirs) {
                int newI = i + dir[0], newJ = j + dir[1];
                if (newI >= 0 && newJ >= 0 && newI < m && newJ < n && !visited[newI][newJ] && matrix[newI][newJ] >= matrix[i][j]) {
                    q.add(new int[] {newI, newJ});
                    visited[newI][newJ] = true;
                }
            }
        }
    }

    // my solution
    // DFS, tc O((mn)^2), sc O(mn)
    // 366 ms, 40.6 MB
    public List<List<Integer>> pacificAtlantic2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return Collections.emptyList();
        int m = matrix.length, n = matrix[0].length;
        int[][] state = new int[m][n];
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(matrix, i, j, i, j, new boolean[m][n], state)) {
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    }

    private boolean dfs(int[][] matrix, int initI, int initJ, int i, int j, boolean[][] visited, int[][] state) {
        int m = matrix.length, n = matrix[0].length;
        if (i == -1 || j == -1 || i == m || j == n) {
            int mask = 0;
            if (i == -1) {
                mask = 1 << 1;
            } else if (j == -1) {
                mask = 1 << 2;
            } else if (i == m) {
                mask = 1 << 3;
            } else if (j == n) {
                mask = 1 << 4;
            }
            state[initI][initJ] |= mask;
            return canReachBoth(state, initI, initJ);
        }
        if (canReachBoth(state, i, j)) {
            return true;
        }
        visited[i][j] = true;
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int[] dir : dirs) {
            int newI = i + dir[0], newJ = j + dir[1];
            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && matrix[newI][newJ] <= matrix[i][j] && !visited[newI][newJ] || newI == -1 || newJ == -1 || newI == m || newJ == n) {
                if (dfs(matrix, initI, initJ, newI, newJ, visited, state)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean canReachBoth(int[][] state, int i, int j) {
        boolean pacific = ((state[i][j] >> 1) & 1) == 1 || ((state[i][j] >> 2) & 1) == 1;
        boolean atlantic = ((state[i][j] >> 3) & 1) == 1 || ((state[i][j] >> 4) & 1) == 1;
        return pacific && atlantic;
    }
}
