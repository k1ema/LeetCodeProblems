package dynamic.NumberOfSubmatricesThatSumToTarget_1074;

import java.util.HashMap;
import java.util.Map;

/**
 * 1074. Number of Submatrices That Sum to Target
 * https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/
 *
 * Given a matrix and a target, return the number of non-empty submatrices that sum to target.
 *
 * A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2.
 *
 * Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if they have some coordinate that is different: for example, if x1 != x1'.
 *
 * Example 1:
 * Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
 * Output: 4
 * Explanation: The four 1x1 submatrices that only contain 0.
 *
 * Example 2:
 * Input: matrix = [[1,-1],[-1,1]], target = 0
 * Output: 5
 * Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the 2x2 submatrix.
 *
 * Example 3:
 * Input: matrix = [[904]], target = 0
 * Output: 0
 *
 * Constraints:
 * 1 <= matrix.length <= 100
 * 1 <= matrix[0].length <= 100
 * -1000 <= matrix[i] <= 1000
 * -10^8 <= target <= 10^8
 */
public class Solution {
    // tc O(R^2 * C), sc O(RC)
    public int numSubmatrixSumTarget1(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int[][] prefixSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        int count = 0, currSum;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i1 = 1; i1 <= m; i1++) {
            for (int i2 = i1; i2 <= m; i2++) {
                map.clear();
                map.put(0, 1);
                for (int j = 1; j <= n; j++) {
                    currSum = prefixSum[i2][j] - prefixSum[i1 - 1][j];
                    count += map.getOrDefault(currSum - target, 0);
                    map.put(currSum, map.getOrDefault(currSum, 0) + 1);
                }
            }
        }
        return count;
    }

    // https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/discuss/303750/JavaC%2B%2BPython-Find-the-Subarray-with-Target-Sum
    // tc O(mn^2), sc O(n)
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int res = 0, m = matrix.length, n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] += matrix[i - 1][j];
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int r1 = 0; r1 < m; r1++) {
            for (int r2 = r1; r2 < m; r2++) {
                map.clear();
                map.put(0, 1);
                int cur = 0;
                for (int c = 0; c < n; c++) {
                    cur += matrix[r2][c] - (r1 > 0 ? matrix[r1 - 1][c] : 0);
                    res += map.getOrDefault(cur - target, 0);
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return res;
    }
}
