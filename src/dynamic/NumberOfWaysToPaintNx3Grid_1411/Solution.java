package dynamic.NumberOfWaysToPaintNx3Grid_1411;

/**
 * 1411. Number of Ways to Paint N × 3 Grid
 * https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/
 *
 * You have a grid of size n x 3 and you want to paint each cell of the grid with exactly one of the three colors:
 * Red, Yellow, or Green while making sure that no two adjacent cells have the same color (i.e., no two cells that
 * share vertical or horizontal sides have the same color).
 *
 * Given n the number of rows of the grid, return the number of ways you can paint this grid. As the answer may
 * grow large, the answer must be computed modulo 109 + 7.
 *
 * Example 1:
 * Input: n = 1
 * Output: 12
 * Explanation: There are 12 possible way to paint the grid as shown.
 *
 * Example 2:
 * Input: n = 2
 * Output: 54
 *
 * Example 3:
 * Input: n = 3
 * Output: 246
 *
 * Example 4:
 * Input: n = 7
 * Output: 106494
 *
 * Example 5:
 * Input: n = 5000
 * Output: 30228214
 *
 * Constraints:
 * n == grid.length
 * grid[i].length == 3
 * 1 <= n <= 5000
 */
public class Solution {
    private final static int MOD = (int) 1e9 + 7;
    private final static int[] colors = new int[] {1, 2, 3};

    // tc O(n), sc O(n)
    // https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/discuss/574912/JavaC%2B%2B-DFS-Memoization-with-Picture-Clean-code
    public int numOfWays(int n) {
        return f(n, 0, 0, 0, 0, new int[n][4][4][4]);
    }

    private int f(int n, int i, int a0, int b0, int c0, int[][][][] memo) {
        if (i == n) return 1;
        if (memo[i][a0][b0][c0] != 0) return memo[i][a0][b0][c0];
        int res = 0;
        for (int a : colors) {
            if (a == a0) continue;
            for (int b : colors) {
                if (b == b0 || b == a) continue;
                for (int c : colors) {
                    if (c == c0 || c == b) continue;
                    res += f(n, i + 1, a, b, c, memo);
                    res = res % MOD;
                }
            }
        }
        return memo[i][a0][b0][c0] = res;
    }
}
