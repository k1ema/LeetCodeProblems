package dynamic.LongestArithmeticSequence_1027;

import java.util.HashMap;
import java.util.Map;

/**
 * 1027. Longest Arithmetic Sequence
 * https://leetcode.com/problems/longest-arithmetic-sequence/
 *
 * Given an array A of integers, return the length of the longest arithmetic subsequence in A.
 *
 * Recall that a subsequence of A is a list A[i_1], A[i_2], ..., A[i_k]
 * with 0 <= i_1 < i_2 < ... < i_k <= A.length - 1, and that a sequence B is arithmetic if
 * B[i+1] - B[i] are all the same value (for 0 <= i < B.length - 1).
 *
 * Example 1:
 * Input: [3,6,9,12]
 * Output: 4
 * Explanation:
 * The whole array is an arithmetic sequence with steps of length = 3.
 *
 * Example 2:
 * Input: [9,4,7,2,10]
 * Output: 3
 * Explanation:
 * The longest arithmetic subsequence is [4,7,10].
 *
 * Example 3:
 * Input: [20,1,15,3,10,5,8]
 * Output: 4
 * Explanation:
 * The longest arithmetic subsequence is [20,15,10,5].
 *
 * Note:
 * 2 <= A.length <= 2000
 * 0 <= A[i] <= 10000
 */
public class Solution {
    // tc O(n^2), sc O(n^2)
    // 377 ms, faster than 72.93%; 154.4 MB, less than 60.00%
    public int longestArithSeqLength(int[] A) {
        int res = 0, n = A.length;
        Map<Integer, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int val = A[i] - A[j];
                dp[i].put(val, dp[j].getOrDefault(val, 1) + 1);
                res = Math.max(res, dp[i].get(val));
            }
        }
        return res;
    }

    // tc O(n^3), sc O(1)
    // 1310 ms; 37.1 MB
    public int longestArithSeqLength1(int[] A) {
        int max = 2;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int count = 2;
                int diff = A[j] - A[i];
                int val = A[j] + diff;
                for (int k = j + 1; k < A.length; k++) {
                    if (A[k] == val) {
                        count++;
                        val += diff;
                    }
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
