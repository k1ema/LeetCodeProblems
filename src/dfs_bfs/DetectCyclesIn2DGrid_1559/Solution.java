package dfs_bfs.DetectCyclesIn2DGrid_1559;

/**
 * 1559. Detect Cycles in 2D Grid
 * https://leetcode.com/problems/detect-cycles-in-2d-grid/
 *
 * Given a 2D array of characters grid of size m x n, you need to find if there exists any
 * cycle consisting of the same value in grid.
 *
 * A cycle is a path of length 4 or more in the grid that starts and ends at the same cell.
 * From a given cell, you can move to one of the cells adjacent to it - in one of the four
 * directions (up, down, left, or right), if it has the same value of the current cell.
 *
 * Also, you cannot move to the cell that you visited in your last move. For example, the
 * cycle (1, 1) -> (1, 2) -> (1, 1) is invalid because from (1, 2) we visited (1, 1) which
 * was the last visited cell.
 *
 * Return true if any cycle of the same value exists in grid, otherwise, return false.
 *
 * Example 1:
 * a a a a
 * a b b a
 * a b b a
 * a a a a
 *
 * Input: grid = [["a","a","a","a"],["a","b","b","a"],["a","b","b","a"],["a","a","a","a"]]
 * Output: true
 * Explanation: There are two valid cycles shown in different colors in the image below:
 *
 * Example 2:
 * c c c a
 * c d c c
 * c c e c
 * f c c c
 *
 * Input: grid = [["c","c","c","a"],["c","d","c","c"],["c","c","e","c"],["f","c","c","c"]]
 * Output: true
 * Explanation: There is only one valid cycle highlighted in the image below:
 *
 * Example 3:
 * a b b
 * b z b
 * b b a
 *
 * Input: grid = [["a","b","b"],["b","z","b"],["b","b","a"]]
 * Output: false
 *
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 500
 * 1 <= n <= 500
 * grid consists only of lowercase English letters.
 */
public class Solution {
    // tc O(mn), sc O(mn)
    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                if (dfs(grid, i, j, -1, -1, m, n, visited)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, int i, int j, int prevI, int prevJ, int m, int n, boolean[][] visited) {
        if (i < 0 || i == m || j < 0 || j == n || (prevI != -1 && grid[i][j] != grid[prevI][prevJ])) {
            return false;
        }
        if (visited[i][j]) return true;
        visited[i][j] = true;
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int[] dir : dirs) {
            int newI = i + dir[0], newJ = j + dir[1];
            if (newI != prevI || newJ != prevJ) {
                if (dfs(grid, newI, newJ, i, j, m, n, visited)) return true;
            }
        }
        return false;
    }
}
