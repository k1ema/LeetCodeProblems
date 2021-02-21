package dfs_bfs.ShortestDistanceFromAllBuildings_317;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 317. Shortest Distance from All Buildings
 * https://leetcode.com/problems/shortest-distance-from-all-buildings/
 *
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance.
 * You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
 *
 * Each 0 marks an empty land which you can pass by freely.
 * Each 1 marks a building which you cannot pass through.
 * Each 2 marks an obstacle which you cannot pass through.
 *
 * Example:
 * Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
 *
 * 1 - 0 - 2 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 *
 * Output: 7
 *
 * Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
 *              the point (1,2) is an ideal empty land to build a house, as the total
 *              travel distance of 3+3+1=7 is minimal. So return 7.
 * Note:
 * There will be at least one building. If it is not possible to build such house according to the
 * above rules, return -1.
 */
public class Solution {
    // tc O((mn)^2), sc O(mn)
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int m = grid.length, n = grid[0].length;
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        int buildings = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) buildings++;
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) continue;
                boolean[][] visited = new boolean[m][n];
                Queue<int[]> q = new ArrayDeque<>();
                q.add(new int[] {i, j, 0});
                visited[i][j] = true;
                int curRes = 0, buildingsReached = 0;
                while (!q.isEmpty()) {
                    int[] nums = q.poll();
                    int ii = nums[0], jj = nums[1], curDist = nums[2];
                    for (int[] dir : dirs) {
                        int newI = ii + dir[0], newJ = jj + dir[1];
                        if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && !visited[newI][newJ] && grid[newI][newJ] != 2) {
                            visited[newI][newJ] = true;
                            if (grid[newI][newJ] == 1) {
                                curRes += curDist + 1;
                                buildingsReached++;
                            } else {
                                q.add(new int[] {newI, newJ, curDist + 1});
                            }
                        }
                    }
                }
                if (buildingsReached == buildings) {
                    res = Math.min(res, curRes);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
