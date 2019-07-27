package array.FourSum_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 * https://leetcode.com/problems/4sum/
 *
 * Given an array nums of n integers and an integer target, are there
 * elements a, b, c, and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class Solution {
    // tc O(n!), sc O(n)
    List<List<Integer>> fourSum(int[] nums, int target) {
        int len;
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || (len = nums.length) < 4) {
            return result;
        }

        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = len - 1; j > i + 2 ; j--) {
                if (j < len - 1 && nums[j] == nums[j + 1]) {
                    continue;
                }
                int sum;
                int lo = i + 1;
                int hi = j - 1;
                while (lo < hi) {
                    sum = nums[i] + nums[j] + nums[lo] + nums[hi];
                    if (sum == target) {
                        List<Integer> tmp = Arrays.asList(nums[i], nums[lo], nums[hi], nums[j]);
                        if (!result.contains(tmp)) {
                            result.add(tmp);
                        }
                        lo++;
                    } else if (sum < target) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return result;
    }
}
