package dfs_bfs.NumberOfClosedIslands_1254;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1254. Number of Closed Islands
 * https://leetcode.com/problems/number-of-closed-islands/
 *
 * Given a 2D grid consists of 0s (land) and 1s (water). An island is a maximal
 * 4-directionally connected group of 0s and a closed island is an island totally
 * (all left, top, right, bottom) surrounded by 1s.
 *
 * Return the number of closed islands.
 *
 * Example 1:
 * Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * Output: 2
 * Explanation:
 * Islands in gray are closed because they are completely surrounded by water (group of 1s).
 *
 * Example 2:
 * Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * Output: 1
 *
 * Example 3:
 * Input: grid = [[1,1,1,1,1,1,1],
 *                [1,0,0,0,0,0,1],
 *                [1,0,1,1,1,0,1],
 *                [1,0,1,0,1,0,1],
 *                [1,0,1,1,1,0,1],
 *                [1,0,0,0,0,0,1],
 *                [1,1,1,1,1,1,1]]
 * Output: 2
 *
 * Constraints:
 * 1 <= grid.length, grid[0].length <= 100
 * 0 <= grid[i][j] <=1
 */
public class Solution {
    // BFS same as Number of Islands but change 0s to 1s and each time when we at border with 0 (land) we do not increment the result.
    // tc O(m*n), sc O(m*n)
    public int closedIsland3(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    res += bfs(grid, i, j, m, n, visited);
                }
            }
        }
        return res;
    }

    private int bfs(int[][] grid, int i, int j, int m, int n, boolean[][] visited) {
        Deque<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        queue.add(new Pair<>(i, j));
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int res = 1;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> coord = queue.poll();
            int x = coord.getKey(), y = coord.getValue();
            visited[x][y] = true;
            for (int[] dir : dirs) {
                i = x + dir[0]; j = y + dir[1];
                if (i < 0 || j < 0 || i >= m || j >= n) {
                    res = 0;
                    continue;
                }
                if (grid[i][j] == 0 && !visited[i][j]) {
                    queue.add(new Pair<>(i, j));
                }
            }
        }
        return res;
    }

    // DFS
    // tc O(m*n), sc O(m*n)
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    res += dfs(grid, i, j, m, n, visited);
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j, int m, int n, boolean[][] visited) {
        visited[i][j] = true;
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int res = 1;
        for (int[] dir : dirs) {
            int nextI = i + dir[0], nextJ = j + dir[1];
            if (nextI < 0 || nextI >= m || nextJ < 0 || nextJ >= n) {
                res = 0;
                continue;
            }
            if (grid[nextI][nextJ] == 0 && !visited[nextI][nextJ]) {
                int next = dfs(grid, nextI, nextJ, m, n, visited);
                if (res != 0) res = next; // tricky part: if we have already been outside border (res = 0)
                // we should not update res because next can be 1 but still we should return 0;
                /*
                      * v *
                      1 0 1
                        1
                 */
                // in this case BFS approach is more clear
            }
        }
        return res;
    }

    // DFS, before run dfs we go through borders and fill recursively all 0s as 1s
    // tc O(m*n), sc O(m*n)
    public int closedIsland2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) fill(grid, i, 0);
            if (grid[i][n - 1] == 0) fill(grid, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 0) fill(grid, 0, j);
            if (grid[m - 1][j] == 0) fill(grid, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    dfs(grid, i, j, visited, m, n);
                    count++;
                }
            }
        }
        return count;
    }

    private void fill(int[][] grid, int i, int j) {
        grid[i][j] = 1;
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int[] dir : dirs) {
            int nextI = i + dir[0], nextJ = j + dir[1];
            if (nextI >= 0 && nextI < grid.length && nextJ >= 0 && nextJ < grid[0].length && grid[nextI][nextJ] == 0) {
                fill(grid, nextI, nextJ);
            }
        }
    }

    private void dfs(int[][] grid, int i, int j, boolean[][] visited, int m, int n) {
        if (grid[i][j] == 1) return;
        visited[i][j] = true;
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int[] dir : dirs) {
            int nextI = i + dir[0], nextJ = j + dir[1];
            if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n && !visited[nextI][nextJ] && grid[nextI][nextJ] == 0) {
                dfs(grid, nextI, nextJ, visited, m, n);
            }
        }
    }
}
