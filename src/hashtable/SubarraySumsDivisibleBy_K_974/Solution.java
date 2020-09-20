package hashtable.SubarraySumsDivisibleBy_K_974;

/**
 * 974. Subarray Sums Divisible by K
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/
 *
 * Given an array A of integers, return the number of (contiguous, non-empty)
 * subarrays that have a sum divisible by K.
 *
 * Example 1:
 * Input: A = [4,5,0,-2,-3,1], K = 5
 * Output: 7
 * Explanation: There are 7 subarrays with a sum divisible by K = 5:
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *
 * Note:
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 */
public class Solution {
    // tc O(n), sc O(n)
    // 5 ms, faster than 87.05%; 42.7 MB, less than 75.78%
    public int subarraysDivByK(int[] A, int K) {
        int[] count = new int[K];
        count[0] = 1;
        int res = 0, prefix = 0;
        for(int a : A) {
            prefix = (prefix + a % K + K) % K;
            res += count[prefix]++;
        }
        return res;
    }

    // tc O(n^2), TLE
    public int subarraysDivByK1(int[] A, int K) {
        int[] prefixSum = new int[A.length + 1];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] += prefixSum[i - 1] + A[i - 1];
        }
        int cnt = 0;
        for (int i = 0; i < prefixSum.length; i++) {
            for (int j = i + 1; j < prefixSum.length; j++) {
                if ((prefixSum[j] - prefixSum[i]) % K == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
