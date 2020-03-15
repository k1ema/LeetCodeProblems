package array.TrappingRainWater_42;

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
    // two pointers
    // tc O(n), sc O(1)
    // 1 ms, faster than 94.21%; 38.7 MB, less than 62.33%
    // https://leetcode.com/problems/trapping-rain-water/discuss/17391/Share-my-short-solution.
    // https://leetcode.com/problems/trapping-rain-water/discuss/17357/Sharing-my-simple-c%2B%2B-code%3A-O(n)-time-O(1)-space
    public int trap(int[] height) {
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

    // dynamic programming
    // tc O(n), sc O(n)
    // 1 ms, faster than 94.21%; 39.2 MB, less than 27.40%
    public int trap1(int[] height) {
        if (height == null || height.length <= 1) return 0;
        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < leftMax.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        int[] rightMax = new int[height.length];
        rightMax[rightMax.length - 1] = height[height.length - 1];
        for (int i = rightMax.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            ans += Math.max(0, Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        return ans;
    }

    // brute force
    // tc O(n^2), sc O(1)
    // 64 ms, faster than 5.80%; 38.8 MB, less than 52.74%
    public int trap2(int[] height) {
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
