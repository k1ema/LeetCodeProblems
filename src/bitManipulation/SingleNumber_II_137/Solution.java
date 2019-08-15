package bitManipulation.SingleNumber_II_137;

import java.util.HashMap;
import java.util.Map;

/**
 * 137. Single Number II
 * https://leetcode.com/problems/single-number-ii/
 *
 * Given a non-empty array of integers, every element appears three times except for one,
 * which appears exactly once. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without
 * using extra memory?
 *
 * Example 1:
 * Input: [2,2,3,2]
 * Output: 3
 *
 * Example 2:
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 */
public class Solution {
    // https://leetcode.com/problems/single-number-ii/discuss/43297/Java-O(n)-easy-to-understand-solution-easily-extended-to-any-times-of-occurance
    // tc O(32n) = O(n), sc O(1)
    // 1 ms, faster than 72.61%; 37.7 MB, less than 94.74%
    int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += (nums[j] >> i) & 1;
            }
            sum %= 3;
            res |= (sum << i);
        }
        return res;
    }

    // same idea but use arrays for counting 1s in each bit of 32
    // 1 ms, faster than 72.61%; 37.1 MB, less than 100.00%
    int singleNumber2(int[] nums) {
        int[] counters = new int[32];
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < nums.length; j++) {
                counters[i] += (nums[j] >> i) & 1;
            }
        }
        int r = 0;
        for (int i = 0; i < counters.length; i++) {
            r |= (counters[i] % 3) << i;
        }
        return r;
    }

    // tc O(n), sc O(1) but used extra memory
    // 41 ms, faster than 11.70%; 37.5 MB, less than 100.00%
    int singleNumber1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.merge(nums[i], 1, Integer::sum);
        }
        return map.entrySet().stream().filter(e -> e.getValue() == 1).findFirst().get().getKey();
    }
}
