package hashtable.NumberOfDistinctIslands_694;

import java.util.HashSet;
import java.util.Set;

/**
 * 694. Number of Distinct Islands
 * https://leetcode.com/problems/number-of-distinct-islands/
 *
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected
 * 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * Count the number of distinct islands. An island is considered to be the same as another if and only if one
 * island can be translated (and not rotated or reflected) to equal the other.
 *
 * Example 1:
 * 11000
 * 11000
 * 00011
 * 00011
 * Given the above grid map, return 1.
 *
 * Example 2:
 * 11011
 * 10000
 * 00001
 * 11011
 * Given the above grid map, return 3.
 *
 * Notice that:
 * 11
 * 1
 * and
 *  1
 * 11
 * are considered different island shapes, because we do not consider reflection / rotation.
 * Note: The length of each dimension in the given grid does not exceed 50.
 */
public class Solution {
    // tc O(m * n); sc O(m * n)
    // 7 ms, faster than 60.84%; 40.7 MB, less than 100.00%
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int count = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, 0, 0, sb);
                    String s = sb.toString();
                    if (sb.length() != 0 && !set.contains(s)) {
                        count++;
                        set.add(s);
                    }
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid, int i, int j, int xPos, int yPos, StringBuilder sb) {
        if (grid[i][j] == 0) return;
        grid[i][j] = 0;
        sb.append(xPos).append(yPos);
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int[] dir : dirs) {
            int newI = i + dir[0], newJ = j + dir[1];
            if (newI >= 0 && newI < grid.length && newJ >= 0 && newJ < grid[0].length) {
                dfs(grid, newI, newJ, xPos + dir[0], yPos + dir[1], sb);
            }
        }
    }

    // same solution but with boolean[][] visited
    // tc O(m * n), sc O(m * n)
    // 8 ms, faster than 49.77%; 42.1 MB, less than 68.18%
    public int numDistinctIslands1(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, visited, 0, 0, sb);
                    String s = sb.toString();
                    if (sb.length() != 0 && !set.contains(s)) {
                        count++;
                        set.add(s);
                    }
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid, int i, int j, boolean[][] visited, int xPos, int yPos, StringBuilder sb) {
        if (grid[i][j] == 0) return;
        visited[i][j] = true;
        sb.append(xPos).append(yPos);
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int[] dir : dirs) {
            int newI = i + dir[0], newJ = j + dir[1];
            if (newI >= 0 && newI < grid.length && newJ >= 0 && newJ < grid[0].length && !visited[newI][newJ]) {
                dfs(grid, newI, newJ, visited, xPos + dir[0], yPos + dir[1], sb);
            }
        }
    }
}
