package array.MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves_1509;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 1509. Minimum Difference Between Largest and Smallest Value in Three Moves
 * https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
 *
 * Given an array nums, you are allowed to choose one element of nums and change it by any value in one move.
 *
 * Return the minimum difference between the largest and smallest value of nums after perfoming at most 3 moves.
 *
 * Example 1:
 * Input: nums = [5,3,2,4]
 * Output: 0
 * Explanation: Change the array [5,3,2,4] to [2,2,2,2].
 * The difference between the maximum and minimum is 2-2 = 0.
 *
 * Example 2:
 * Input: nums = [1,5,0,10,14]
 * Output: 1
 * Explanation: Change the array [1,5,0,10,14] to [1,1,0,1,1].
 * The difference between the maximum and minimum is 1-0 = 1.
 *
 * Example 3:
 * Input: nums = [6,6,0,1,1,4,6]
 * Output: 2
 *
 * Example 4:
 * Input: nums = [1,5,6,14,15]
 * Output: 1
 *
 * Constraints:
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 */
public class Solution {
    public int minDifference(int[] nums) {
        if (nums.length < 5) return 0;
        Arrays.sort(nums);
        return IntStream.of(0, 1, 2, 3).map(i -> nums[nums.length - 1 - i] - nums[3 - i]).min().orElse(-1);
    }

    public int minDifference1(int[] nums) {
        if (nums.length < 5) return 0;
        Arrays.sort(nums);
        int n = nums.length;
        int r1 = Math.min(nums[n - 4] - nums[0], nums[n - 1] - nums[3]);
        int r2 = Math.min(nums[n - 2] - nums[2], nums[n - 3] - nums[1]);
        return Math.min(r1, r2);
    }
}
