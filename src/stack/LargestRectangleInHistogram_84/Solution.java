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
    public int largestRectangleArea2(int[] heights) {
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

    // segment tree
    // tc O(nlogn), sc O(n)
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        SegmentTree st = new SegmentTree(heights);
        return calculateArea(heights, 0, n - 1, st);
    }

    public int calculateArea(int[] heights, int start, int end, SegmentTree st) {
        if (start > end) return 0;
        if (start == end) return heights[start];
        int minInd = st.getMin(start, end);
        int area1 = heights[minInd] * (end - start + 1);
        int area2 = calculateArea(heights, start, minInd - 1, st);
        int area3 = calculateArea(heights, minInd + 1, end, st);
        return Math.max(area1, Math.max(area2, area3));
    }

    private static class SegmentTree {
        private static final int INF = (int) 1e9;
        private int n, offset;
        private int[][] nums;

        SegmentTree(int[] arr) {
            int len = arr.length;
            int k = 0;
            while ((1 << k) < len) {
                k++;
            }
            n = 1 << k;
            this.nums = new int[2 * n - 1][2];
            this.offset = nums.length - n;
            for (int i = offset; i < nums.length; i++) {
                nums[i] = new int[] {i - offset < arr.length ? arr[i - offset] : INF, i - offset};
            }
            for (int i = 0; i < n; i += 2) {
                update(i, nums[offset + i]);
            }
        }

        int getMin(int L, int R) {
            return getMin(0, 0, n - 1, L, R)[1];
        }

        int[] getMin(int i, int l, int r, int L, int R) {
            if (r < L || l > R) return new int[] {INF, -1};
            if (l >= L && r <= R) return nums[i];
            int m = l + (r - l) / 2;
            int[] leftChild = getMin(2 * i + 1, l, m, L, R);
            int[] rightChild = getMin(2 * i + 2, m + 1, r, L, R);
            return leftChild[0] < rightChild[0] ? leftChild : rightChild;
        }

        void update(int i, int[] val) {
            int ind = offset + i;
            nums[ind] = val;
            while (ind > 0) {
                int parentInd = (ind - 1) / 2;
                int leftChildInd = 2 * parentInd + 1;
                int rightChildInd = 2 * parentInd + 2;
                if (nums[leftChildInd][0] < nums[rightChildInd][0]) {
                    nums[parentInd] = nums[leftChildInd];
                } else {
                    nums[parentInd] = nums[rightChildInd];
                }
                ind = parentInd;
            }
        }
    }

    // brute-force
    // tc O(n^2), sc O(1)
    public int largestRectangleArea3(int[] heights) {
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
