package dynamic.MaxDotProductOfTwoSubsequences_1458;

import java.util.HashMap;
import java.util.Map;

/**
 * 1458. Max Dot Product of Two Subsequences
 * https://leetcode.com/problems/max-dot-product-of-two-subsequences/
 *
 * Given two arrays nums1 and nums2.
 *
 * Return the maximum dot product between non-empty subsequences of nums1 and nums2
 * with the same length.
 *
 * A subsequence of a array is a new array which is formed from the original array by
 * deleting some (can be none) of the characters without disturbing the relative positions
 * of the remaining characters. (ie, [2,3,5] is a subsequence of [1,2,3,4,5] while [1,5,3] is not).
 *
 * Example 1:
 * Input: nums1 = [2,1,-2,5], nums2 = [3,0,-6]
 * Output: 18
 * Explanation: Take subsequence [2,-2] from nums1 and subsequence [3,-6] from nums2.
 * Their dot product is (2*3 + (-2)*(-6)) = 18.
 *
 * Example 2:
 * Input: nums1 = [3,-2], nums2 = [2,-6,7]
 * Output: 21
 * Explanation: Take subsequence [3] from nums1 and subsequence [7] from nums2.
 * Their dot product is (3*7) = 21.
 *
 * Example 3:
 * Input: nums1 = [-1,-1], nums2 = [1,1]
 * Output: -1
 * Explanation: Take subsequence [-1] from nums1 and subsequence [1] from nums2.
 * Their dot product is -1.
 *
 * Constraints:
 * 1 <= nums1.length, nums2.length <= 500
 * -1000 <= nums1[i], nums2[i] <= 1000
 */
public class Solution {
    // norm diagram
    // https://leetcode.com/problems/max-dot-product-of-two-subsequences/discuss/648528/Finally-a-diagram-to-make-understanding-easy

    // dp
    // tc O(n * m), sc O(n * m)
    // 7 ms, faster than 100.00%; 38.4 MB, less than 100.00%
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = nums1[i] * nums2[j];
                if (i > 0 && j > 0) dp[i][j] += Math.max(0, dp[i - 1][j - 1]);
                if (i > 0) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                if (j > 0) dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }

    // backtracking with memoization; tc w/o memo O(2^(m + n))
    // tc O(m * n), sc O(m * n)
    // 233 ms, faster than 50.00%; 66.2 MB
    private Map<String, Integer> memo;
    public int maxDotProduct1(int[] nums1, int[] nums2) {
        memo = new HashMap<>();
        return bt(nums1, nums2, 0, 0);
    }

    private Integer bt(int[] nums1, int[] nums2, int i, int j) {
        if (i == nums1.length || j == nums2.length) return null;
        String s = i + " " + j;
        if (memo.containsKey(s)) return memo.get(s);
        int cur = nums1[i] * nums2[j];
        Integer v1 = bt(nums1, nums2, i + 1, j + 1);
        Integer v2 = bt(nums1, nums2, i, j + 1);
        Integer v3 = bt(nums1, nums2, i + 1, j);
        int res = cur;
        if (v1 != null) res = Math.max(res, res + v1);
        if (v2 != null) res = Math.max(res, v2);
        if (v3 != null) res = Math.max(res, v3);
        memo.put(s, res);
        return res;
    }
}
