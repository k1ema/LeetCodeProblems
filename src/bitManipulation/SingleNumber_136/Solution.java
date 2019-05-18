package bitManipulation.SingleNumber_136;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 136. Single Number
 * https://leetcode.com/problems/single-number/
 *
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 */
class Solution {
    int singleNumber(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(nums[i])) {
                m.put(nums[i], nums[i]);
            } else {
                m.put(nums[i], null);
            }
        }
        for (Entry<Integer, Integer> entry : m.entrySet()) {
            if (entry.getValue() == null) {
                return entry.getKey();
            }
        }
        throw new IllegalArgumentException("No single number");
    }

    // a XOR a = 0; O(n) - time complexity; O(1) - space complexity
    int singleNumber1(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
