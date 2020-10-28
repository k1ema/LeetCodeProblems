package array.MaximumProductOfThreeNumbers_628;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 628. Maximum Product of Three Numbers
 * https://leetcode.com/problems/maximum-product-of-three-numbers/
 *
 * Given an integer array nums, find three numbers whose product is
 * maximum and return the maximum product.
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: 6
 *
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: 24
 *
 * Example 3:
 * Input: nums = [-1,-2,-3]
 * Output: -6
 *
 * Constraints:
 * 3 <= nums.length <= 104
 * -1000 <= nums[i] <= 1000
 */
public class Solution {
    // tc O(n), sc O(1)
    public int maximumProduct(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for (int n : nums) {
            pq.add(n);
            if (pq.size() > 3) {
                pq.poll();
            }
        }
        int max = Integer.MIN_VALUE;
        int p1 = 1;
        while (!pq.isEmpty()) {
            int v = pq.poll();
            p1 *= v;
            max = Math.max(max, v);
        }

        pq = new PriorityQueue<>((a, b) -> b - a);
        for (int n : nums) {
            pq.add(n);
            if (pq.size() > 2) {
                pq.poll();
            }
        }
        int p2 = max;
        while (!pq.isEmpty()) {
            p2 *= pq.poll();
        }
        return Math.max(p1, p2);
    }

    // tc O(nlogn), sc O(logn)
    public int maximumProduct1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int p1 = nums[n-1] * nums[n-2] * nums[n-3];
        if (n == 3) return p1;
        int p2 = nums[0] * nums[1] * nums[n -1];
        return Math.max(p1, p2);
    }
}
