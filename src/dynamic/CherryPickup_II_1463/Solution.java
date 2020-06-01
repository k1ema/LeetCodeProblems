package dynamic.CherryPickup_II_1463;

import java.util.HashMap;
import java.util.Map;

/**
 * 1463. Cherry Pickup II
 * https://leetcode.com/problems/cherry-pickup-ii/
 *
 * Given a rows x cols matrix grid representing a field of cherries. Each cell in grid represents
 * the number of cherries that you can collect.
 *
 * You have two robots that can collect cherries for you, Robot #1 is located at the top-left corner (0,0),
 * and Robot #2 is located at the top-right corner (0, cols-1) of the grid.
 *
 * Return the maximum number of cherries collection using both robots  by following the rules below:
 *
 * From a cell (i,j), robots can move to cell (i+1, j-1) , (i+1, j) or (i+1, j+1).
 * When any robot is passing through a cell, It picks it up all cherries, and the cell becomes an empty cell (0).
 * When both robots stay on the same cell, only one of them takes the cherries.
 * Both robots cannot move outside of the grid at any moment.
 * Both robots should reach the bottom row in the grid.
 *
 * Example 1:
 * Input: grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
 * Output: 24
 * Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
 * Cherries taken by Robot #1, (3 + 2 + 5 + 2) = 12.
 * Cherries taken by Robot #2, (1 + 5 + 5 + 1) = 12.
 * Total of cherries: 12 + 12 = 24.
 *
 * Example 2:
 * Input: grid = [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]
 * Output: 28
 * Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
 * Cherries taken by Robot #1, (1 + 9 + 5 + 2) = 17.
 * Cherries taken by Robot #2, (1 + 3 + 4 + 3) = 11.
 * Total of cherries: 17 + 11 = 28.
 *
 * Example 3:
 * Input: grid = [[1,0,0,3],[0,0,0,3],[0,0,3,3],[9,0,3,3]]
 * Output: 22
 *
 * Example 4:
 * Input: grid = [[1,1],[1,1]]
 * Output: 4
 *
 * Constraints:
 * rows == grid.length
 * cols == grid[i].length
 * 2 <= rows, cols <= 70
 * 0 <= grid[i][j] <= 100
 */
public class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Map<String, Integer> memo = new HashMap<>();
        return bt(grid, 0, 0, n - 1, m, n, memo);
    }

    private int bt(int[][] grid, int i, int j1, int j2, int m, int n, Map<String, Integer> memo) {
        if (i == m || j1 < 0 || j1 == n || j2 < 0 || j2 == n) return 0;
        String key = i + " " + j1 + " " + j2;
        if (memo.containsKey(key)) return memo.get(key);
        int res = j1 == j2 ? grid[i][j1] : grid[i][j1] + grid[i][j2];
        if (i == m - 1) return res;
        int v1 = bt(grid, i + 1, j1 - 1, j2 - 1, m, n, memo);
        int v2 = bt(grid, i + 1, j1 - 1, j2, m, n, memo);
        int v3 = bt(grid, i + 1, j1 - 1, j2 + 1, m, n, memo);
        int v4 = bt(grid, i + 1, j1, j2 - 1, m, n, memo);
        int v5 = bt(grid, i + 1, j1, j2, m, n, memo);
        int v6 = bt(grid, i + 1, j1, j2 + 1, m, n, memo);
        int v7 = bt(grid, i + 1, j1 + 1, j2 - 1, m, n, memo);
        int v8 = bt(grid, i + 1, j1 + 1, j2, m, n, memo);
        int v9 = bt(grid, i + 1, j1 + 1, j2 + 1, m, n, memo);
        int vv1 = Math.max(v1, Math.max(v2, v3));
        int vv2 = Math.max(v4, Math.max(v5, v6));
        int vv3 = Math.max(v7, Math.max(v8, v9));
        res += Math.max(vv1, Math.max(vv2, vv3));
        memo.put(key, res);
        return res;
    }
}
