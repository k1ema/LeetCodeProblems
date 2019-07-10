package array.ThreeSumClosest_16;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 * https://leetcode.com/problems/3sum-closest/
 *
 * Given an array nums of n integers and an integer target, find three integers in
 * nums such that the sum is closest to target. Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 *
 * Example:
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Solution {
    // https://leetcode.com/problems/3sum-closest/discuss/7872/Java-solution-with-O(n2)-for-reference
    // tc O(n^2), sc O(1)
    int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int middle = i + 1;
            int end = nums.length - 1;
            while (middle < end) {
                int sum = nums[i] + nums[middle] + nums[end];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    middle++;
                } else {
                    end--;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }

    // brute force
    // tc O(A(n, 3)) = O(n^3), sc O(1)
    int threeSumClosest1(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                for (int k = 0; k < nums.length; k++) {
                    if (i == j || j == k || i == k) {
                        continue;
                    }
                    int s = nums[i] + nums[j] + nums[k];
                    if (Math.abs(s - target) < diff) {
                        diff = Math.abs(s - target);
                        sum = s;
                    }
                }
            }
        }
        return sum;
    }
}
