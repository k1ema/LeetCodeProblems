package dfs_bfs.MaxAreaOfIsland_695;

/**
 * 695. Max Area of Island
 * https://leetcode.com/problems/max-area-of-island/
 *
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's
 * (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 *
 * Find the maximum area of an island in the given 2D array. (If there is no island,
 * the maximum area is 0.)
 *
 * Example 1:
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 *
 * Given the above grid, return 6. Note the answer is not 11, because the island
 * must be connected 4-directionally.
 *
 * Example 2:
 * [[0,0,0,0,0,0,0,0]]
 *
 * Given the above grid, return 0.
 *
 * Note: The length of each dimension in the given grid does not exceed 50.
 */
public class Solution {
    // tc O(n*m), sc O(n*m)
    // 4 ms, faster than 23.46%; 38.9 MB, less than 99.30%
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    res = Math.max(res, dfs(grid, i, j, visited));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        int res = 1;
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int m = grid.length, n = grid[0].length;
        for (int[] dir : dirs) {
            int newI = i + dir[0], newJ = j + dir[1];
            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && grid[newI][newJ] == 1 && !visited[newI][newJ]) {
                res += dfs(grid, newI, newJ, visited);
            }
        }
        return res;
    }
}
