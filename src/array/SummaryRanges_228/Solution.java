package array.SummaryRanges_228;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. Summary Ranges
 * https://leetcode.com/problems/summary-ranges/
 *
 * You are given a sorted unique integer array nums.
 *
 * Return the smallest sorted list of ranges that cover all the numbers in the
 * array exactly. That is, each element of nums is covered by exactly one of
 * the ranges, and there is no integer x such that x is in one of the ranges
 * but not in nums.
 *
 * Each range [a,b] in the list should be output as:
 * "a->b" if a != b
 * "a" if a == b
 *
 * Example 1:
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: The ranges are:
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 *
 * Example 2:
 * Input: nums = [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: The ranges are:
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 *
 * Example 3:
 * Input: nums = []
 * Output: []
 *
 * Example 4:
 * Input: nums = [-1]
 * Output: ["-1"]
 *
 * Example 5:
 * Input: nums = [0]
 * Output: ["0"]
 *
 * Constraints:
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * All the values of nums are unique.
 */
public class Solution {
    // tc O(n), sc O(1)
    public List<String> summaryRanges(int[] nums) {
        List<String> summary = new ArrayList<>();
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (j + 1 < nums.length && nums[j + 1] == nums[j] + 1) continue;
            if (i == j) {
                summary.add(nums[i] + "");
            } else {
                summary.add(nums[i] + "->" + nums[j]);
            }
            i = j + 1;
        }
        return summary;
    }

    public List<String> summaryRanges1(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        int l = 0, r;
        StringBuilder sb = new StringBuilder();
        sb.append(nums[l]);
        for (r = 1; r < nums.length; r++) {
            if (nums[r] - 1 > nums[r - 1]) {
                if (r - 1 > l) {
                    sb.append("->").append(nums[r - 1]);
                }
                res.add(sb.toString());
                l = r;
                sb = new StringBuilder();
                sb.append(nums[l]);
            }
        }
        if (r - 1 > l) {
            sb.append("->").append(nums[r - 1]);
        }
        res.add(sb.toString());

        return res;
    }
}
