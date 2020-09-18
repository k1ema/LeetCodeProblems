package dfs_bfs.RottingOranges_994;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. Rotting Oranges
 * https://leetcode.com/problems/rotting-oranges/
 *
 * In a given grid, each cell can have one of three values:
 *
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
 * If this is impossible, return -1 instead.
 *
 * Example 1:
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 *
 * Example 2:
 * Input: [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting
 * only happens 4-directionally.
 *
 * Example 3:
 * Input: [[0,2]]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 *
 * Note:
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] is only 0, 1, or 2.
 */
public class Solution {
    /*
        1. find all rotten oranges and put them to queue;
        2. start bfs, in each iteration increment result time
        3. when queue is empty look at grid and find any fresh oranges.
    */
    // tc O(N), sc O(N)
    // 2 ms, faster than 97.60%; 39.5 MB, less than 45.58%
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                    grid[i][j] = 3;
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int time = 0;
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] coord = queue.poll();
                for (int[] dir : dirs) {
                    int newI = coord[0] + dir[0];
                    int newJ = coord[1] + dir[1];
                    if (newI < 0 || newI == m || newJ < 0 || newJ == n) continue;
                    if (grid[newI][newJ] == 1) {
                        queue.add(new int[] {newI, newJ});
                        grid[newI][newJ] = 3;
                        fresh--;
                    }
                }
            }
            time++;
        }

        return fresh == 0 ?  time - 1 : -1;
    }
}
