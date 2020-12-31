package stack.LargestRectangleInHistogram_84;

import java.util.ArrayDeque;
import java.util.Deque;

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
        2. iterate heights
            if stack contains other heights and cur height <= stack.peek:
                res = max(res, heights[stack.pop] * (i - stack.peek() - 1))
            push i to stack
        3. after cycle check values in stack (while stack.peek != -1):
            res = max(res, heights[stack.pop] * (heights.length - stack.peek() - 1))
    */
    // tc O(n), sc O(n)
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int n = heights.length;
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                res = Math.max(res, heights[stack.poll()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            res = Math.max(res, heights[stack.poll()] * (n - stack.peek() - 1));
        }
        return res;
    }

    // divide and conquer
    // tc: Average Case: O(nlogn), Worst Case: O(n^2)
    // If the numbers in the array are sorted, we don't gain the advantage of divide and conquer.
    // sc O(n)
    public int largestRectangleArea1(int[] heights) {
        return calculateArea(heights, 0, heights.length - 1);
    }

    public int calculateArea(int[] heights, int start, int end) {
        if (start > end) return 0;
        int minindex = start;
        for (int i = start; i <= end; i++)
            if (heights[minindex] > heights[i])
                minindex = i;
        return Math.max(heights[minindex] * (end - start + 1),
                Math.max(calculateArea(heights, start, minindex - 1), calculateArea(heights, minindex + 1, end)));
    }

    // brute-force
    // tc O(n^2), sc O(1)
    public int largestRectangleArea2(int[] heights) {
        int res = 0;
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                res = Math.max(res, minHeight * (j - i + 1));
            }
        }
        return res;
    }
}
