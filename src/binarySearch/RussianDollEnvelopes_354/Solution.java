package binarySearch.RussianDollEnvelopes_354;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * 354. Russian Doll Envelopes
 * https://leetcode.com/problems/russian-doll-envelopes/
 *
 * You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.
 *
 * One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.
 *
 * Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
 *
 * Note: You cannot rotate an envelope.
 *
 * Example 1:
 * Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 *
 * Example 2:
 * Input: envelopes = [[1,1],[1,1],[1,1]]
 * Output: 1
 *
 * Constraints:
 * 1 <= envelopes.length <= 5000
 * envelopes[i].length == 2
 * 1 <= wi, hi <= 10^4
 */
public class Solution {
    // tc O(nlogn), sc O(n)
    // 10 ms, faster than 68.94%; 40.4 MB, less than 12.59%
    // https://leetcode.com/problems/russian-doll-envelopes/solution/
    // same as 300. Longest Increasing Subsequence
    // https://leetcode.com/problems/longest-increasing-subsequence/
    /*
        We answer the question from the intuition by sorting. Let's pretend that we found the best arrangement of envelopes. We know that each
        envelope must be increasing in w, thus our best arrangement has to be a subsequence of all our envelopes sorted on w.
        After we sort our envelopes, we can simply find the length of the longest increasing subsequence on the second dimension (h). Note that
        we use a clever trick to solve some edge cases:
        Consider an input [[1, 3], [1, 4], [1, 5], [2, 3]]. If we simply sort and extract the second dimension we get [3, 4, 5, 3], which implies
        that we can fit three envelopes (3, 4, 5). The problem is that we can only fit one envelope, since envelopes that are equal in the first
        dimension can't be put into each other.
        In order fix this, we don't just sort increasing in the first dimension - we also sort decreasing on the second dimension, so two
        envelopes that are equal in the first dimension can never be in the same increasing subsequence.
        Now when we sort and extract the second element from the input we get [5, 4, 3, 3], which correctly reflects an LIS of one.
     */
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });
        int[][] dp = new int[envelopes.length][2];
        int len = 0;
        for (int[] env : envelopes) {
            int l = -1, r = len;
            while (r - l > 1) {
                int m = l + (r - l) / 2;
                if (dp[m][0] < env[0] && dp[m][1] < env[1]) {
                    l = m;
                } else {
                    r = m;
                }
            }
            dp[r] = env;
            if (r == len) {
                len++;
            }
        }
        return len;
    }

    // tc O(n^2), sc O(n)
    // 247 ms; 39.8 MB
    public int maxEnvelopes1(int[][] envelopes) {
        Arrays.sort(envelopes, Comparator.comparingInt(a -> a[0] + a[1]));
        int n = envelopes.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        return IntStream.of(dp).max().orElse(1);
    }
}
