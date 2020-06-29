package dynamic.UniquePaths_II_63;

/**
 * 63. Unique Paths II
 * https://leetcode.com/problems/unique-paths-ii/
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach
 * the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 * Input:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * Output: 2
 *
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 */
public class Solution {
    // tc O(m * n), sc O(1)
    // 0 ms, faster than 100.00%; 40.5 MB, less than 30.77%
    int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // If the starting cell has an obstacle, then simply return as there would be no paths to the destination.
        if (obstacleGrid[0][0] == 1) return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // there is only one way to reach {0, 0}
        obstacleGrid[0][0] = 1;
        // filling up first column
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) {
                obstacleGrid[i][0] = 1;
            } else {
                obstacleGrid[i][0] = 0;
            }
        }
        // filling up first row
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) {
                obstacleGrid[0][i] = 1;
            } else {
                obstacleGrid[0][i] = 0;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] += obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        return obstacleGrid[m - 1][n - 1];
    }
}
