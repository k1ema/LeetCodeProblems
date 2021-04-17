package dfs_bfs.WallsAndGates_286;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 286. Walls and Gates
 * https://leetcode.com/problems/walls-and-gates/
 *
 * You are given an m x n grid rooms initialized with these three possible values.
 *
 * -1 A wall or an obstacle.
 * 0 A gate.
 * INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the
 * distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 *
 * Example 1:
 * Input: rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
 * Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
 *
 * Example 2:
 * Input: rooms = [[-1]]
 * Output: [[-1]]
 *
 * Example 3:
 * Input: rooms = [[2147483647]]
 * Output: [[2147483647]]
 *
 * Example 4:
 * Input: rooms = [[0]]
 * Output: [[0]]
 *
 * Constraints:
 * m == rooms.length
 * n == rooms[i].length
 * 1 <= m, n <= 250
 * rooms[i][j] is -1, 0, or 2^31 - 1.
 */
public class Solution {
    // tc O(mn), sc O(mn)
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> q = new ArrayDeque<>();
        int m = rooms.length, n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    q.add(new int[] {i, j, rooms[i][j]});
                }
            }
        }
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while (!q.isEmpty()) {
            int[] nums = q.poll();
            int i = nums[0], j = nums[1], dist = nums[2];
            for (int[] dir : dirs) {
                int newI = i + dir[0], newJ = j + dir[1];
                if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && rooms[newI][newJ] == Integer.MAX_VALUE) {
                    rooms[newI][newJ] = dist + 1;
                    q.add(new int[] {newI, newJ, dist + 1});
                }
            }
        }
    }

}
