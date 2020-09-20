package array.MakeSumDivisibleByP_1590;

import java.util.HashMap;
import java.util.Map;

/**
 * 1590. Make Sum Divisible by P
 * https://leetcode.com/problems/make-sum-divisible-by-p/
 *
 * Given an array of positive integers nums, remove the smallest subarray (possibly
 * empty) such that the sum of the remaining elements is divisible by p. It is not
 * allowed to remove the whole array.
 *
 * Return the length of the smallest subarray that you need to remove, or -1 if it's
 * impossible.
 *
 * A subarray is defined as a contiguous block of elements in the array.
 *
 * Example 1:
 * Input: nums = [3,1,4,2], p = 6
 * Output: 1
 * Explanation: The sum of the elements in nums is 10, which is not divisible by 6.
 * We can remove the subarray [4], and the sum of the remaining elements is 6, which
 * is divisible by 6.
 *
 * Example 2:
 * Input: nums = [6,3,5,2], p = 9
 * Output: 2
 * Explanation: We cannot remove a single element to get a sum divisible by 9. The
 * best way is to remove the subarray [5,2], leaving us with [6,3] with sum 9.
 *
 * Example 3:
 * Input: nums = [1,2,3], p = 3
 * Output: 0
 * Explanation: Here the sum is 6. which is already divisible by 3. Thus we do not
 * need to remove anything.
 *
 * Example 4:
 * Input: nums = [1,2,3], p = 7
 * Output: -1
 * Explanation: There is no way to remove a subarray in order to get a sum divisible by 7.
 *
 * Example 5:
 * Input: nums = [1000000000,1000000000,1000000000], p = 3
 * Output: 0
 *
 * Constraints:
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= p <= 109
 */
public class Solution {
    // tc O(n), sc O(n)
    // 30 ms, faster than 100.00%; 61.6 MB, less than 50.00%
    // https://leetcode.com/problems/make-sum-divisible-by-p/discuss/854197/JavaC%2B%2BPython-Prefix-Sum
    public int minSubarray(int[] nums, int p) {
        int n = nums.length, need = 0, res = n, cur = 0;
        for (int num : nums) {
            need = (need + num) % p;
        }
        if (need == 0) return 0;
        Map<Integer, Integer> last = new HashMap<>();
        last.put(0, -1);
        for (int i = 0; i < n; i++) {
            cur = (cur + nums[i]) % p;
            last.put(cur, i);
            int want = (cur - need + p) % p;
            res = Math.min(res, i - last.getOrDefault(want, -n));
        }
        return res == n ? -1 : res;
    }

    // TLE
    public int minSubarray1(int[] nums, int p) {
        int n = nums.length;
        int res = helper(nums, -1, -1, p, new Integer[n][n]);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int helper(int[] nums, int start, int end, int p, Integer[][] memo) {
        if (end == nums.length) return Integer.MAX_VALUE;
        if (start >= 0 && end >= 0 && memo[start][end] != null) return memo[start][end];
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= start && i <= end) continue;
            sum += nums[i];
        }
        if (sum != 0 && sum % p == 0) {
            return start == -1 ? 0 : end - start + 1;
        }
        int res = Integer.MAX_VALUE;
        for (int i = start + 1; i < nums.length; i++) {
            res = Math.min(res, helper(nums, start + 1, i, p, memo));
        }
        if (start > -1) {
            memo[start][end] = res;
        }
        return res;
    }
}
