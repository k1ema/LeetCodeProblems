package array.ContainerWithMostWater_11;

/**
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains
 * the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area
 * of water (blue section) the container can contain is 49.
 *
 * Example:
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */
public class Solution {
    // tc O(n), sc O(1)
    // https://leetcode.com/problems/container-with-most-water/discuss/6100/Simple-and-clear-proofexplanation
    int maxArea(int[] height) {
        int lo = 0, hi = height.length - 1;
        int maxArea = 0;
        while (lo < hi) {
            maxArea = Math.max(maxArea, Math.min(height[lo], height[hi]) * (hi - lo));
            if (height[lo] < height[hi]) {
                lo++;
            } else {
                hi--;
            }
        }
        return maxArea;
    }

    // tc O(n^2), sc O(1), Brute force
    int maxArea1(int[] height) {
        int maxArea = 0;
        int n = height.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }
}
