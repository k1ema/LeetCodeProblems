package backtracking.UniquePaths_III_980;

/**
 * 980. Unique Paths III
 * https://leetcode.com/problems/unique-paths-iii/
 *
 * On a 2-dimensional grid, there are 4 types of squares:
 * 1 represents the starting square.  There is exactly one starting square.
 * 2 represents the ending square.  There is exactly one ending square.
 * 0 represents empty squares we can walk over.
 * -1 represents obstacles that we cannot walk over.
 *
 * Return the number of 4-directional walks from the starting square to the ending square, that walk
 * over every non-obstacle square exactly once.
 *
 * Example 1:
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * Output: 2
 *
 * Explanation: We have the following two paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 *
 * Example 2:
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 * Output: 4
 *
 * Explanation: We have the following four paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
 * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
 * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
 * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 *
 * Example 3:
 * Input: [[0,1],[2,0]]
 * Output: 0
 *
 * Explanation:
 * There is no path that walks over every empty square exactly once.
 * Note that the starting and ending square can be anywhere in the grid.
 *
 * Note:
 * 1 <= grid.length * grid[0].length <= 20
 */
public class Solution {
    // my solution
    // tc O(m*n*3^(m+n)), sc O(mn)
    public int uniquePathsIII_1(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) return dfs(grid, i, j, m, n);
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i == m || j == n || grid[i][j] == 3 || grid[i][j] == -1) return 0;
        if (grid[i][j] == 2) {
            return check(grid) ? 1 : 0;
        }
        int tmp = grid[i][j];
        grid[i][j] = 3;
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int res = 0;
        for (int[] dir : dirs) {
            res += dfs(grid, i + dir[0], j + dir[1], m, n);
        }
        grid[i][j] = tmp;
        return res;
    }

    private boolean check(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) return false;
            }
        }
        return true;
    }

    // tc O(3^(m+n)), sc O(mn) - because of recursion
    // https://leetcode.com/problems/unique-paths-iii/discuss/289954/Java-Solution-DFS-With-backtracking
    // https://leetcode.com/problems/unique-paths-iii/discuss/221946/JavaPython-Brute-Force-Backstracking
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int startI = 0, startJ = 0;
        int empty = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    startI = i; startJ = j;
                } else if (grid[i][j] == 0) {
                    empty++;
                }
            }
        }
        return dfs(grid, startI, startJ, m, n, -1, empty);
    }

    private int dfs(int[][] grid, int i, int j, int m, int n, int zeros, int need) {
        if (i < 0 || j < 0 || i == m || j == n || grid[i][j] < 0) return 0;
        if (grid[i][j] == 2) {
            return zeros == need ? 1 : 0;
        }
        grid[i][j] = -2;
        int count = 0;
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int[] dir : dirs) {
            count += dfs(grid, i + dir[0], j + dir[1], m, n, zeros + 1, need);
        }
        grid[i][j] = 0;
        return count;
    }
}
