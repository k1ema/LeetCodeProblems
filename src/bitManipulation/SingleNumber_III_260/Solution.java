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
    //
    int[] singleNumber(int[] nums) {
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            r ^= nums[i];
        }

        // for instance:
        // r   == 0111000  =>
        // r-1 == 0110111
        // from left to right: before first 1 is the same (prefix), 0 instead of 1 (target bit), 1s instead of 0s at the end (suffix);
        // ~(r - 1) = 1001000 - inverted prefix (with & gives 0s), target == 1 in both, suffix = 0s.
        // r & (~(r - 1)) == 0001000 =>
        // it always has only one 1 in position where r has last 1 (from right to left).
        int lastBit = r & -r; // = ~(r - 1)
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if ((lastBit & nums[i]) != 0) {
                res[0] ^= nums[i];
            } else {
                res[1] ^= nums[i];
            }
        }

        return res;
    }
}
