package stack.NextGreaterElement_II_503;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 503. Next Greater Element II
 * https://leetcode.com/problems/next-greater-element-ii/
 *
 * Given a circular array (the next element of the last element is the first
 * element of the array), print the Next Greater Number for every element.
 * The Next Greater Number of a number x is the first greater number to its
 * traversing-order next in the array, which means you could search circularly
 * to find its next greater number. If it doesn't exist, output -1 for this number.
 *
 * Example 1:
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number;
 * The second 1's next greater number needs to search circularly, which is also 2.
 *
 * Note: The length of given array won't exceed 10000.
 */
public class Solution {
    // tc O(n), sc O(n), right-to-left
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) return new int[] {};
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i % n]) {
                stack.poll();
            }
            res[i % n] = stack.isEmpty() ? -1 : nums[stack.peek()];
            stack.push(i % n);
        }
        return res;
    }

    // tc O(n), sc O(n), left-to-right
    public int[] nextGreaterElements1(int[] nums) {
        if (nums == null || nums.length == 0) return new int[] {};
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                res[stack.poll()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return res;
    }
}