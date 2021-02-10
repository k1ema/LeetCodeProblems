package hashtable.KDiffPairsInAnArray_532;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * 532. K-diff Pairs in an Array
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/
 *
 * Given an array of integers nums and an integer k, return the number of unique
 * k-diff pairs in the array.
 *
 * A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
 *
 * 0 <= i, j < nums.length
 * i != j
 * a <= b
 * b - a == k
 *
 * Example 1:
 * Input: nums = [3,1,4,1,5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 *
 * Example 2:
 * Input: nums = [1,2,3,4,5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 *
 * Example 3:
 * Input: nums = [1,3,1,5,4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 *
 * Example 4:
 * Input: nums = [1,2,4,4,3,3,0,9,2,3], k = 3
 * Output: 2
 *
 * Example 5:
 * Input: nums = [-1,-2,-3], k = 1
 * Output: 2
 *
 * Constraints:
 * 1 <= nums.length <= 104
 * -107 <= nums[i] <= 107
 * 0 <= k <= 107
 */
public class Solution {
    // tc O(n), sc O(n)
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num + k)) {
                map.put(num, num + k);
            }
            if (map.containsKey(num - k)) {
                map.put(num - k, num);
            }
            map.putIfAbsent(num, null);
        }
        return (int) map.values().stream().filter(Objects::nonNull).count();
    }

    // tc O(nlogn), sc O(n)
    public int findPairs1(int[] nums, int k) {
        Set<Pair<Integer, Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (k != 0 && find(nums, nums[i] + k) || k == 0 && existSameNumber(nums, i)) {
                set.add(new Pair<>(nums[i], nums[i] + k));
            }
        }
        // System.out.println(set);
        return set.size();
    }

    private boolean existSameNumber(int[] nums, int i) {
        int n = nums.length;
        if (n == 1) return false;
        if (i == 0) return nums[i] == nums[i + 1];
        if (i == n - 1) return nums[i] == nums[i - 1];
        return nums[i] == nums[i + 1] || nums[i] == nums[i - 1];
    }

    private boolean find(int[] nums, int val) {
        int l = -1, r = nums.length;
        while (r - l > 1) {
            int m = (l + r) >>> 1;
            if (nums[m] < val) {
                l = m;
            } else {
                r = m;
            }
        }
        return r != nums.length && nums[r] == val;
    }
}
