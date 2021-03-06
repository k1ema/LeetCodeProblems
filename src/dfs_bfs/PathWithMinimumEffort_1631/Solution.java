package dfs_bfs.PathWithMinimumEffort_1631;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

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
 * 1 <= heights[i][j] <= 10^6
 */
public class Solution {
    // Dijkstra, tc O(m*n*log(m*n)), sc O(m * n)
    // 68 ms, faster than 51.32%; 39.6 MB, less than 67.93%
    public int minimumEffortPath1(int[][] heights) {
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

    // Binary search + BFS, same could be written using DFS
    // tc O(mn), sc O(mn)
    // 206 ms, faster than 11.54%; 114.4 MB, less than 5.05%
    public int minimumEffortPath(int[][] heights) {
        int l = -1, r = (int) 1e6;
        while (r - l > 1) {
            int m = (l + r) >>> 1;
            if (canReachDestination(heights, m)) {
                r = m;
            } else {
                l = m;
            }
        }
        return r;
    }

    private boolean canReachDestination(int[][] heights, int k) {
        int m = heights.length, n = heights[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        q.add(new int[] {0, 0});
        visited[0][0] = true;
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int i = node[0], j = node[1];
            if (i == m - 1 && j == n - 1) {
                return true;
            }
            for (int[] dir : dirs) {
                int newI = i + dir[0], newJ = j + dir[1];
                if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && !visited[newI][newJ]) {
                    int nextEffort = Math.abs(heights[i][j] - heights[newI][newJ]);
                    if (nextEffort <= k) {
                        visited[newI][newJ] = true;
                        q.add(new int[] {newI, newJ, nextEffort});
                    }
                }
            }
        }
        return false;
    }

    // brute-force, TLE
    // tc O(3^(mn)), sc O(mn)
    public int minimumEffortPath2(int[][] heights) {
        return dfs(heights, 0, 0, 0);
    }

    private int dfs(int[][] heights, int i, int j, int curMax) {
        if (i == heights.length - 1 && j == heights[i].length - 1) {
            return curMax;
        }
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int curHeight = heights[i][j];
        heights[i][j] = 0;
        int res = (int) 1e6;
        for (int[] dir : dirs) {
            int newI = i +  dir[0], newJ = j + dir[1];
            if (newI >= 0 && newI < heights.length && newJ >= 0 && newJ < heights[i].length && heights[newI][newJ] != 0) {
                res = Math.min(res, dfs(heights, newI, newJ, Math.max(curMax, Math.abs(curHeight - heights[newI][newJ]))));
            }
        }
        heights[i][j] = curHeight;
        return res;
    }
}
