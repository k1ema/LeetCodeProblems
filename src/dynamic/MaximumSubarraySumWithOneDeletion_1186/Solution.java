package dynamic.MaximumSubarraySumWithOneDeletion_1186;

/**
 * 1186. Maximum Subarray Sum with One Deletion
 * https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/
 *
 * Given an array of integers, return the maximum sum for a non-empty subarray
 * (contiguous elements) with at most one element deletion. In other words, you want
 * to choose a subarray and optionally delete one element from it so that there is
 * still at least one element left and the sum of the remaining elements is maximum possible.
 *
 * Note that the subarray needs to be non-empty after deleting one element.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,-2,0,3]
 * Output: 4
 * Explanation: Because we can choose [1, -2, 0, 3] and drop -2, thus the
 * subarray [1, 0, 3] becomes the maximum value.
 *
 * Example 2:
 * Input: arr = [1,-2,-2,3]
 * Output: 3
 * Explanation: We just choose [3] and it's the maximum sum.
 *
 * Example 3:
 * Input: arr = [-1,-1,-1,-1]
 * Output: -1
 * Explanation: The final subarray needs to be non-empty. You can't choose [-1] and
 * delete -1 from it, then get an empty subarray to make the sum equals to 0.
 *
 * Constraints:
 * 1 <= arr.length <= 10^5
 * -10^4 <= arr[i] <= 10^4
 */
public class Solution {
    // tc O(n), sc O(1)
    // keep tracking of two variables:
    //  withDel - max sum with one deletion
    //  withoutDel - Kadane's algorithm for max sum without deletion
    public int maximumSum(int[] arr) {
        int res = arr[0], withDel = arr[0], withoutDel = arr[0];
        for (int i = 1; i < arr.length; i++) {
            withDel = Math.max(withDel + arr[i], withoutDel);
            withoutDel = Math.max(withoutDel + arr[i], arr[i]);
            res = Math.max(res, Math.max(withDel, withoutDel));
        }
        return res;
    }

    /*
        [1,-1, 1, 1, 3]
      l [3, 2, 4, 3, 3]
      r [1,-2, 1, 0, 3]

        1, -2, 0, 3
      l 1  -1  0  3
      r 2   1  3  3

     */
    // tc O(n), sc O(n)
    // 2 ms, faster than 98.65%; 48 MB, less than 100.00%
    public int maximumSum1(int[] arr) {
        int maxSum = arr[0];
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        left[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            left[i] = Math.max(arr[i], left[i - 1] + arr[i]);
            maxSum = Math.max(maxSum, left[i]);
        }
        right[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            right[i] = Math.max(arr[i], right[i + 1] + arr[i]);
        }
        for (int i = 1; i < arr.length - 1; i++) {
            maxSum = Math.max(maxSum, left[i - 1] + right[i + 1]);
        }
        return maxSum;
    }

    // tc O(n^2), sc O(1)
    public int maximumSum2(int[] arr) {
        int cur = arr[0], max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            cur = Math.max(arr[i], cur + arr[i]);
            max = Math.max(max, cur);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) continue;
            cur = 0;
            for (int j = 0; j < arr.length; j++) {
                if (j == i) continue;
                cur = Math.max(arr[j], cur + arr[j]);
                max = Math.max(max, cur);
            }
        }

        return max;
    }
}
