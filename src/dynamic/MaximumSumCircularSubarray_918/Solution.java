package dynamic.MaximumSumCircularSubarray_918;

/**
 * 918. Maximum Sum Circular Subarray
 * https://leetcode.com/problems/maximum-sum-circular-subarray/
 *
 * Given a circular array C of integers represented by A, find the maximum possible
 * sum of a non-empty subarray of C.
 *
 * Here, a circular array means the end of the array connects to the beginning of the array.
 * (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)
 *
 * Also, a subarray may only include each element of the fixed buffer A at most once.
 * (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j
 * with k1 % A.length = k2 % A.length.)
 *
 * Example 1:
 * Input: [1,-2,3,-2]
 * Output: 3
 * Explanation: Subarray [3] has maximum sum 3
 *
 * Example 2:
 * Input: [5,-3,5]
 * Output: 10
 * Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10
 *
 * Example 3:
 * Input: [3,-1,2,-1]
 * Output: 4
 * Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4
 *
 * Example 4:
 * Input: [3,-2,2,-3]
 * Output: 3
 * Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3
 *
 * Example 5:
 * Input: [-2,-3,-1]
 * Output: -1
 * Explanation: Subarray [-1] has maximum sum -1
 *
 * Note:
 * -30000 <= A[i] <= 30000
 * 1 <= A.length <= 30000
 */
public class Solution {
    // tc O(n), sc O(1)
    public int maxSubarraySumCircular(int[] A) {
        int maxAtPos = 0, minAtPos = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int total = 0;
        for (int i = 0; i < A.length; i++) {
            maxAtPos = Math.max(maxAtPos + A[i], A[i]);
            maxSum = Math.max(maxSum, maxAtPos);
            minAtPos = Math.min(minAtPos + A[i], A[i]);
            minSum = Math.min(minSum, minAtPos);
            total += A[i];
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }

    // my solution tc O(n^2) - TLE, sc O(1)
    public int maxSubarraySumCircular1(int[] A) {
        int maxSum = A[0];
        for (int i = 0; i < A.length; i++) {
            maxSum = Math.max(maxSum, A[i]);
            int curSum = A[i];
            int j = (i + 1) % A.length;
            int count = 0;
            while (j % A.length != i && count < A.length) {
                curSum = Math.max(curSum + A[j % A.length], A[j % A.length]);
                maxSum = Math.max(maxSum, curSum);
                j++;
                count++;
            }
        }

        return maxSum;
    }
}
