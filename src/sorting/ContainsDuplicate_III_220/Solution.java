package sorting.ContainsDuplicate_III_220;

import java.util.TreeSet;

/**
 * 220. Contains Duplicate III
 * https://leetcode.com/problems/contains-duplicate-iii/
 *
 * Given an array of integers, find out whether there are two distinct indices i and j in
 * the array such that the absolute difference between nums[i] and nums[j] is at most t
 * and the absolute difference between i and j is at most k.
 *
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 *
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 *
 * Example 3:
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 */
public class Solution {
    /*
        for each num - O(n)
            if set is not empty
                - find the smallest element x in set which x - nums[i] <= t
                - find the greatest element x in set which nums[i] - x <= t
            if set.size == k -> set.remove(nums[i - k])
            add nums[i] to set
        total - O(nlogk)
    */
    // tc O(nlog(min(n,k)))), sc O(min(n,k))
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k <= 0) return false;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer floor = set.floor(nums[i]);
            if (floor != null && (long) nums[i] - (long) floor <= t) return true;
            Integer ceiling = set.ceiling(nums[i]);
            if (ceiling != null && (long) ceiling - (long) nums[i] <= t) return true;

            if (set.size() == k) {
                set.remove(nums[i - k]);
            }
            set.add(nums[i]);
        }
        return false;
    }
}
