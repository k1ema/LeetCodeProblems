package twoPointers.SubarrayProductLessThanK_713;

import javafx.util.Pair;

/**
 * 713. Subarray Product Less Than K
 * https://leetcode.com/problems/subarray-product-less-than-k/
 *
 * Your are given an array of positive integers nums.
 *
 * Count and print the number of (contiguous) subarrays where the product of all the
 * elements in the subarray is less than k.
 *
 * Example 1:
 * Input: nums = [10, 5, 2, 6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2],
 * [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 *
 * Note:
 * 0 < nums.length <= 50000.
 * 0 < nums[i] < 1000.
 * 0 <= k < 10^6.
 */
public class Solution {
    // tc O(n), sc O(1)
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0, prod = 1, left = 0;
        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i];
            while (prod >= k && left <= i) {
                prod /= nums[left++];
            }
            res += i - left + 1;
        }
        return res;
    }

    // my solution
    // tc O(n), sc O(1)
    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        int res = 0, prevI = 0, prevProd = 1;
        for (int j = 0; j < nums.length; j++) {
            Pair<Integer, Integer> pair = helper(nums, j, k, prevI, prevProd);
            prevI = pair.getKey();
            prevProd = pair.getValue();
            res += (j - prevI + 1);
        }
        return res;
    }

    private Pair<Integer, Integer> helper(int[] nums, int j, int k, int prevI, int prevProd) {
        int prod = prevProd * nums[j];
        while (prod >= k && prevI <= j) {
            prod /= nums[prevI];
            prevI++;
        }
        return new Pair<>(prevI, prod);
    }
}
