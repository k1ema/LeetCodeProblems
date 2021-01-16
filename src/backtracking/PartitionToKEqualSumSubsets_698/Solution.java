package backtracking.PartitionToKEqualSumSubsets_698;

/**
 * 698. Partition to K Equal Sum Subsets
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
 *
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
 *
 * Example 1:
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * Output: True
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 *
 * Note:
 * 1 <= k <= len(nums) <= 16.
 * 0 < nums[i] < 10000.
 */
public class Solution {
    // tc O(n * 2^n), sc O(n)
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % k != 0 || maxNum > sum / k) return false;
        return helper(nums, sum / k, 0, new boolean[nums.length], k, 0);
    }

    private boolean helper(int[] nums, int target, int cursum, boolean[] used, int k, int idx) {
        if (k == 0) {
            return true;
        }
        if (cursum == target) {
            return helper(nums, target, 0, used, k - 1, 0);
        }

        for (int i = idx; i < nums.length; i++) {
            if (!used[i] && cursum + nums[i] <= target) {
                used[i] = true;
                if (helper(nums, target, cursum + nums[i], used, k, i + 1)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }

    // TLE, sc O(n * n^n)
    public boolean canPartitionKSubsets1(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;
        return helper(nums, sum / k, 0, new boolean[nums.length], k);
    }

    private boolean helper(int[] nums, int target, int cursum, boolean[] used, int k) {
        if (cursum == target) {
            k--;
            cursum = 0;
            if (k == 0) {
                for (int i = 0; i < used.length; i++) {
                    if (!used[i]) return false;
                }
                return true;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i] && cursum + nums[i] <= target) {
                used[i] = true;
                if(helper(nums, target, cursum + nums[i], used, k)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }
}
