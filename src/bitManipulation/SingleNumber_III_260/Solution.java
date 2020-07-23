package bitManipulation.SingleNumber_III_260;

/**
 * 260. Single Number III
 * https://leetcode.com/problems/single-number-iii/
 *
 * Given an array of numbers nums, in which exactly two elements appear only once and all
 * the other elements appear exactly twice. Find the two elements that appear only once.
 *
 * Example:
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 *
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only
 * constant space complexity?
 */
public class Solution {
    // good explanation:
    // https://leetcode.com/problems/single-number-iii/discuss/68901/sharing-explanation-of-the-solution
    // https://leetcode.com/problems/single-number-iii/discuss/68945/share-my-c-solution
    // https://leetcode.com/problems/single-number-iii/discuss/68900/Accepted-C%2B%2BJava-O(n)-time-O(1)-space-Easy-Solution-with-Detail-Explanations
    // tc O(n), sc O(1)
    public int[] singleNumber(int[] nums) {
        int r = 0;
        for (int n : nums) {
            r ^= n;
        }

        int firstBit = r ^ (r & (r - 1)); // r & (r - 1) - remove first 1. Or could be: firstBit = r & -r
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & firstBit) == 0) {
                res[0] ^= nums[i];
            } else {
                res[1] ^= nums[i];
            }
        }

        return res;
    }
}
