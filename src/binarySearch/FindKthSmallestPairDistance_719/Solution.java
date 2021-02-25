package binarySearch.FindKthSmallestPairDistance_719;

import java.util.Arrays;

/**
 * 719. Find K-th Smallest Pair Distance
 * https://leetcode.com/problems/find-k-th-smallest-pair-distance/
 *
 * Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B)
 * is defined as the absolute difference between A and B.
 *
 * Example 1:
 * Input:
 * nums = [1,3,1]
 * k = 1
 * Output: 0
 * Explanation:
 * Here are all the pairs:
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * Then the 1st smallest distance pair is (1,1), and its distance is 0.
 * Note:
 * 2 <= len(nums) <= 10000.
 * 0 <= nums[i] < 1000000.
 * 1 <= k <= len(nums) * (len(nums) - 1) / 2.
 */
public class Solution {
    // tc O(nlogn + nlogD), sc O(1). D - max distance between nums[max] and nums[min]
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = -1, r = nums[n - 1] - nums[0];
        while (r - l > 1) {
            int m = (l + r) >>> 1;
            int pairCount = getPairCountOfMaxDistance(nums, m);
            if (pairCount < k) {
                l = m;
            } else {
                r = m;
            }
        }
        return r;
    }

    private int getPairCountOfMaxDistance(int[] nums, int dist) {
        int count = 0, l = 0;
        for (int r = 0; r < nums.length; r++) {
            while (nums[r] - nums[l] > dist) {
                l++;
            }
            count += r - l;
        }
        return count;
    }
}
