package dynamic.TrappingRainWater_42;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * Given n non-negative integers representing an elevation map where the width of each bar
 * is 1, compute how much water it is able to trap after raining.
 *
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case,
 * 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing
 * this image!
 *
 * Example:
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class Solution {
    // dynamic programming, prefix sum
    // tc O(n), sc O(n)
    // 1 ms, faster than 94.21%; 39.2 MB, less than 27.40%
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        for (int i = 0; i < height.length; i++) {
            leftMax[i] = i == 0 ? height[i] : Math.max(height[i], leftMax[i - 1]);
        }
        for (int i = n - 1; i >= 0; i--) {
            rightMax[i] = i == n - 1 ? height[i] : Math.max(height[i], rightMax[i + 1]);
        }
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            if (height[i] < leftMax[i - 1] && height[i] < rightMax[i + 1]) {
                res += Math.min(leftMax[i - 1], rightMax[i + 1]) - height[i];
            }
        }
        return res;
    }

    // two pointers
    // tc O(n), sc O(1)
    // 1 ms, faster than 94.21%; 38.7 MB, less than 62.33%
    // https://leetcode.com/problems/trapping-rain-water/discuss/17391/Share-my-short-solution.
    // https://leetcode.com/problems/trapping-rain-water/discuss/17357/Sharing-my-simple-c%2B%2B-code%3A-O(n)-time-O(1)-space
    public int trap1(int[] height) {
        if (height == null || height.length <= 1) return 0;
        int leftMax = 0, rightMax = 0;
        int left = 0, right = height.length - 1, ans = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }

    // stack
    // https://leetcode.com/problems/trapping-rain-water/discuss/17414/A-stack-based-solution-for-reference-inspired-by-Histogram
    public int trap2(int[] height) {
        if (height == null || height.length < 2) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int water = 0, i = 0;
        while (i < height.length) {
            if (stack.isEmpty() || height[i] <= height[stack.peek()]) {
                stack.push(i++);
            } else {
                int pre = stack.pop();
                if (!stack.isEmpty()) {
                    // find the smaller height between the two sides
                    int minHeight = Math.min(height[stack.peek()], height[i]);
                    // calculate the area
                    water += (minHeight - height[pre]) * (i - stack.peek() - 1);
                }
            }
        }
        return water;
    }

    // my solution, using deque
    // tc O(n), sc O(n)
    public int trap3(int[] height) {
        Deque<Integer> deque = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            if (!deque.isEmpty() && height[i] >= height[deque.peekFirst()]) {
                int j = deque.pollFirst();
                int water = (i - j - 1) * height[j]; // calc the total square
                while (!deque.isEmpty()) {
                    water -= height[deque.poll()]; // then remove inner heights
                }
                res += water;
            }
            if (height[i] != 0) deque.addLast(i);
        }
        if (!deque.isEmpty()) {
            int i = deque.pollLast();
            while (!deque.isEmpty()) {
                while (!deque.isEmpty() && height[deque.peekLast()] < height[i]) {
                    deque.pollLast();
                }
                if (!deque.isEmpty()) {
                    int j = deque.pollLast();
                    int water = (i - j - 1) * Math.min(height[i], height[j]);
                    for (int k = j + 1; k < i; k++) {
                        water -= height[k];
                    }
                    res += water;
                    i = j;
                }
            }
        }
        return res;
    }

    // brute force
    // tc O(n^2), sc O(1)
    // 64 ms, faster than 5.80%; 38.8 MB, less than 52.74%
    public int trap4(int[] height) {
        if (height == null) return 0;
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            int j = i - 1;
            int leftMax = 0;
            while (j >= 0) {
                leftMax = Math.max(leftMax, height[j]);
                j--;
            }
            j = i + 1;
            int rightMax = 0;
            while (j < height.length) {
                rightMax = Math.max(rightMax, height[j]);
                j++;
            }
            ans += Math.max(0, Math.min(leftMax, rightMax) - height[i]);
        }
        return ans;
    }
}
