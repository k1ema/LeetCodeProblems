package dynamic.CherryPickup_741;

/**
 * 741. Cherry Pickup
 * https://leetcode.com/problems/cherry-pickup/
 *
 * You are given an n x n grid representing a field of cherries, each cell is one of three possible integers.
 *
 * 0 means the cell is empty, so you can pass through,
 * 1 means the cell contains a cherry that you can pick up and pass through, or
 * -1 means the cell contains a thorn that blocks your way.
 * Return the maximum number of cherries you can collect by following the rules below:
 *
 * Starting at the position (0, 0) and reaching (n - 1, n - 1) by moving right or down through valid path cells (cells with value 0 or 1).
 * After reaching (n - 1, n - 1), returning to (0, 0) by moving left or up through valid path cells.
 * When passing through a path cell containing a cherry, you pick it up, and the cell becomes an empty cell 0.
 * If there is no valid path between (0, 0) and (n - 1, n - 1), then no cherries can be collected.
 *
 * Example 1:
 * Input: grid = [[0,1,-1],[1,0,-1],[1,1,1]]
 * Output: 5
 * Explanation: The player started at (0, 0) and went down, down, right right to reach (2, 2).
 * 4 cherries were picked up during this single trip, and the matrix becomes [[0,1,-1],[0,0,-1],[0,0,0]].
 * Then, the player went left, up, up, left to return home, picking up one more cherry.
 * The total number of cherries picked up is 5, and this is the maximum possible.
 *
 * Example 2:
 * Input: grid = [[1,1,-1],[1,-1,1],[-1,1,1]]
 * Output: 0
 *
 * Constraints:
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 50
 * grid[i][j] is -1, 0, or 1.
 * grid[0][0] != -1
 * grid[n - 1][n - 1] != -1
 */
public class Solution {
    // tc O(n^4), sc O(n^4)
    // 108 ms, faster than 15.75%; 89.9 MB, less than 17.54%
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        return Math.max(0, helper(grid, 0, 0, 0, 0, new Integer[n][n][n][n]));
    }

    private int helper(int[][] grid, int i1, int j1, int i2, int j2, Integer[][][][] memo) {
        int n = grid.length;
        if (i1 < 0 || i1 == n || j1 < 0 || j1 == n || i2 < 0 || i2 == n || j2 < 0 || j2 == n || grid[i1][j1] == -1 || grid[i2][j2] == -1) {
            return Integer.MIN_VALUE;
        }
        if (memo[i1][j1][i2][j2] != null) {
            return memo[i1][j1][i2][j2];
        }

        if (i1 == n - 1 && j1 == n - 1) {
            return grid[i1][j1];
        }
        if (i2 == n - 1 && j2 == n - 1) {
            return grid[i2][j2];
        }

        int res;
        if (i1 == i2 && j1 == j2) {
            res = grid[i1][j1];
        } else {
            res = grid[i1][j1] + grid[i2][j2];
        }

        res += Math.max(
                Math.max(helper(grid, i1 + 1, j1, i2 + 1, j2, memo), helper(grid, i1 + 1, j1, i2, j2 + 1, memo)),
                Math.max(helper(grid, i1, j1 + 1, i2 + 1, j2, memo), helper(grid, i1, j1 + 1, i2, j2 + 1, memo))
        );

        return memo[i1][j1][i2][j2] = res;
    }
}
