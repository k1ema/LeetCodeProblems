package hashtable.SubarraySumEqualsK_560;

import java.util.HashMap;

/**
 * 560. Subarray Sum Equals K
 * https://leetcode.com/problems/subarray-sum-equals-k/
 *
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays
 * whose sum equals to k.
 *
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 *
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class Solution {
    // tc O(n), sc O(n)
    // 10 ms, faster than 98.40%; 41.7 MB, less than 5.43%
    // https://leetcode.com/problems/subarray-sum-equals-k/solution/
    // prefix sum
    public int subarraySum(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        var count = 0;
        var sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    // tc O(n^2), sc O(1)
    // 259 ms, faster than 5.36%; 41.5 MB, less than 5.43%
    public int subarraySum1(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int j = i;
            while (j >= 0) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
                j--;
            }
        }
        return count;
    }
}
