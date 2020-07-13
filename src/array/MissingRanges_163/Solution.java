package array.MissingRanges_163;

import java.util.ArrayList;
import java.util.List;

/**
 * 163. Missing Ranges
 * https://leetcode.com/problems/missing-ranges/
 *
 * Given a sorted integer array nums, where the range of elements are in the inclusive
 * range [lower, upper], return its missing ranges.
 *
 * Example:
 * Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 * Output: ["2", "4->49", "51->74", "76->99"]
 */
public class Solution {
    // tc O(n), sc O(n)
    // 8 ms, faster than 36.87%; 38.2 MB, less than 31.34%
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            res.add(formRange(lower, upper));
            return res;
        }
        int n = nums.length;
        if (lower < nums[0]) {
            res.add(formRange(lower, nums[0] - 1));
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1] && nums[i] > nums[i - 1] + 1) {
                res.add(formRange(nums[i - 1] + 1, nums[i] - 1));
            }
        }
        if (upper > nums[n - 1]) {
            res.add(formRange(nums[n - 1] + 1, upper));
        }
        return res;
    }

    private String formRange(int l, int r) {
        return l == r ? "" + l : String.format("%d->%d", l, r);
    }
}
