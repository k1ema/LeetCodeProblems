package array.MissingNumber_268;

/**
 * 268. Missing Number
 * https://leetcode.com/problems/missing-number/
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * Example 1:
 * Input: [3,0,1]
 * Output: 2

 * Example 2:
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8

 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class Solution {
    // tc O(n), sc O(1). need a litle bit fewer memory than the next one
    int missingNumber(int[] nums) {
        int sum = 0;
        int sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum2 += i;
        }
        sum2 += nums.length;
        return sum2 - sum;
    }

    // tc O(n), sc O(1)
    int missingNumber1(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return nums.length * (nums.length + 1) / 2 - sum;
    }

    // from leetcode, XOR
    // tc O(n), sc O(1)
    int missingNumber2(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}
