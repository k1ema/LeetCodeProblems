package stack.LargestRectangleInHistogram_84;

import java.util.Stack;

/**
 * 84. Largest Rectangle in Histogram
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * Given n non-negative integers representing the histogram's bar height where the width of each
 * bar is 1, find the area of largest rectangle in the histogram.
 *
 *                   6
 *                5  |
 *                |  |
 *                |  |     3
 *          2     |  |  2  |
 *          |  1  |  |  |  |
 *          |__|__|__|__|__|___
 *          0  1  2  3  4  5
 *                      ^
 *
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 *
 * Example:
 * Input: [2,1,5,6,2,3]
 * Output: 10
 */
public class Solution {
    /*
        1. initialize stack and push -1
        2. iterate heights and if stack contains other heights and cur height <= stack.pop:
            res = max(res, heights[stack.pop] * (i - stack.peek() - 1))
        3. push to stack anyway
        4. after cycle check values in stack (while stack.peek != -1):
            res = max(res, heights[stack.pop] * (heights.length - stack.peek() - 1))
    */
    // tc O(n), sc O(n)
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                res = Math.max(res, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            res = Math.max(res, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return res;
    }
}
