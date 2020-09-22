package array.MajorityElement_169;

/**
 * 169. Majority Element
 * https://leetcode.com/problems/majority-element/
 *
 * Given an array of size n, find the majority element. The majority element is the element
 * that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 * Input: [3,2,3]
 * Output: 3
 *
 * Example 2:
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class Solution {
    // Boyer-Moore majority vote algorithm.
    // tc O(n), sc O(1)
    // https://leetcode.com/problems/majority-element/discuss/51613/O(n)-time-O(1)-space-fastest-solution
    // https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm - Boyer–Moore majority vote algorithm
    int majorityElement(int[] nums) {
        int candidate = nums[0], count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            } else if (count == 0) {
                count++;
                candidate = num;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
