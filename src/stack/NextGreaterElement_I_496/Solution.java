package stack.NextGreaterElement_I_496;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 496. Next Greater Element I
 * https://leetcode.com/problems/next-greater-element-i/
 *
 * You are given two arrays (without duplicates) nums1 and nums2 where
 * nums1’s elements are subset of nums2. Find all the next greater
 * numbers for nums1's elements in the corresponding places of nums2.
 *
 * The Next Greater Number of a number x in nums1 is the first greater
 * number to its right in nums2. If it does not exist, output -1 for this number.
 *
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 *     For number 4 in the first array, you cannot find the next greater
 *     number for it in the second array, so output -1.
 *     For number 1 in the first array, the next greater number for it
 *     in the second array is 3.
 *     For number 2 in the first array, there is no next greater number
 *     for it in the second array, so output -1.
 *
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 *     For number 2 in the first array, the next greater number for it
 *     in the second array is 3.
 *     For number 4 in the first array, there is no next greater number
 *     for it in the second array, so output -1.
 *
 * Note:
 * All elements in nums1 and nums2 are unique.
 * The length of both nums1 and nums2 would not exceed 1000.
 */
public class Solution {
    /*
        1. init stack, go from right side in nums and
            while stack is not empty poll from stack index in case it's value is smaller than cur
                put to map: {cur value, polled}
            put to the stack cur index
        2. find for each num in nums1 it's greter value or -1
    */
    // tc O(m + n), sc O(m + n) for space complexity we need m if we consider result array
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[] {};
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peekFirst()]) {
                stack.pollFirst();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : nums2[stack.peekFirst()]);
            stack.addFirst(i);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
