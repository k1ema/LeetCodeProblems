package dfs_bfs.PathWithMinimumEffort_1631;

import java.util.*;

/**
 * 1631. Path With Minimum Effort
 * https://leetcode.com/problems/path-with-minimum-effort/
 *
 * You are a hiker preparing for an upcoming hike. You are given heights, a 2D array
 * of size rows x columns, where heights[row][col] represents the height of cell (row, col).
 * You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell,
 * (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to
 * find a route that requires the minimum effort.
 *
 * A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
 *
 * Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
 *
 * Example 1:
 * Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
 * Output: 2
 * Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
 * This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
 *
 * Example 2:
 * Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
 * Output: 1
 * Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells,
 * which is better than route [1,3,5,3,5].
 *
 * Example 3:
 * Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * Output: 0
 * Explanation: This route does not require any effort.
 *
 * Constraints:
 * rows == heights.length
 * columns == heights[i].length
 * 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 106
 */
public class Solution {
    // Dijkstra, tc O(m*n*log(m*n)), sc O(m * n)
    // 68 ms, faster than 51.32%; 39.6 MB, less than 67.93%
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int res = 0;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.add(new int[] {0, 0, 0});
        boolean[][] visited = new boolean[m][n];
        // List<int[]> pathTo = new ArrayList<>();
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int i = node[0], j = node[1];
            visited[i][j] = true;
            res = Math.max(res, node[2]);
            // pathTo.add(new int[] {i, j, node[2]});
            if (i == m - 1 && j == n - 1) {
                // for (int[] nd : pathTo) {
                //     System.out.print(String.format("[%d,%d %d]->", nd[0], nd[1], nd[2]));
                // }
                // System.out.println();
                return res;
            }
            for (int[] dir : dirs) {
                int newI = i + dir[0], newJ = j + dir[1];
                if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && !visited[newI][newJ]) {
                    pq.add(new int[] {newI, newJ, Math.abs(heights[newI][newJ] - heights[i][j])});
                }
            }
        }
        return -1;
    }

    // brute-force, TLE
    // tc O(3^(mn)), sc O(mn)
    public int minimumEffortPath1(int[][] heights) {
        List<Integer> path = new ArrayList<>();
        int m = heights.length, n = heights[0].length;
        return dfs(heights, 0, 0, 0, 0, m, n, 0, new boolean[m][n]);
    }

    private int dfs(int[][] heights, int i, int j, int prevI, int prevJ, int m, int n, int maxEffort, boolean[][] visited) {
        if (visited[i][j]) return Integer.MAX_VALUE;
        maxEffort = Math.max(maxEffort, Math.abs(heights[i][j] - heights[prevI][prevJ]));
        if (i == m - 1 && j == n - 1) {
            return maxEffort;
        }
        visited[i][j] = true;
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int res = Integer.MAX_VALUE;
        for (int[] dir: dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && !visited[newI][newJ]) {
                res = Math.min(res, dfs(heights, newI, newJ, i, j, m, n, maxEffort, visited));
            }
        }
        visited[i][j] = false;
        return res;
    }

}
