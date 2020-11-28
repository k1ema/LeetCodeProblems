package slidingWindow.SlidingWindowMaximum_239;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 239. Sliding Window Maximum
 * https://leetcode.com/problems/sliding-window-maximum/
 *
 * You are given an array of integers nums, there is a sliding window of size k which is moving
 * from the very left of the array to the very right. You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 * Example 1:
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Example 3:
 * Input: nums = [1,-1], k = 1
 * Output: [1,-1]
 *
 * Example 4:
 * Input: nums = [9,11], k = 2
 * Output: [11]
 *
 * Example 5:
 * Input: nums = [4,-2], k = 2
 * Output: [4]
 *
 * Constraints:
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
public class Solution {
    // tc O(n), sc O(n)
    // 28 ms, faster than 42.86%; 54 MB, less than 47.21%
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        int[] res = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (!q.isEmpty() && q.peekFirst() == i - k) {
                q.pollFirst();
            }
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
                q.pollLast();
            }
            q.addLast(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[q.peekFirst()];
            }
        }
        return res;
    }
}
