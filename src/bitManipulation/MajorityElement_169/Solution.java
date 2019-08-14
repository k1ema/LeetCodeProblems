package bitManipulation.MajorityElement_169;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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
    // https://discuss.leetcode.com/topic/28601/java-solutions-sorting-hashmap-moore-voting-bit-manipulation
    // https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm - Boyer–Moore majority vote algorithm
    int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }
            count = (nums[i] == candidate) ? count + 1 : count - 1;
        }
        return candidate;
    }

    // tc O(nlogn), sc O(1)
    int majorityElement1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // tc O(n), sc O(n)
    int majorityElement2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(i -> map.merge(i, 1, Integer::sum));
        int threshold = nums.length / 2;
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > threshold) {
                return entry.getKey();
            }
        }
        throw new IllegalArgumentException("wrong input array: " + Arrays.toString(nums));
    }
}
