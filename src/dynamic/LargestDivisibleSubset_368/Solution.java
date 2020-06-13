package dynamic.LargestDivisibleSubset_368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. Largest Divisible Subset
 * https://leetcode.com/problems/largest-divisible-subset/
 *
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of
 * elements in this subset satisfies:
 *
 * Si % Sj = 0 or Sj % Si = 0.
 *
 * If there are multiple solutions, return any subset is fine.
 *
 * Example 1:
 * Input: [1,2,3]
 * Output: [1,2] (of course, [1,3] will also be ok)
 *
 * Example 2:
 * Input: [1,2,4,8]
 * Output: [1,2,4,8]
 */
public class Solution {
    // tc O(n^2), sc O(n^2)
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        List<Integer>[] list = new ArrayList[nums.length];
        for (int i = 0; i < nums.length; i++) {
            list[i] = new ArrayList<>();
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            List<Integer> maxSubset = new ArrayList<>();

            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && maxSubset.size() < list[j].size()) {
                    maxSubset = list[j];
                }
            }

            list[i].addAll(maxSubset);
            list[i].add(nums[i]);
        }

        int index = -1, count = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i].size() > count) {
                count = list[i].size();
                index = i;
            }
        }
        return list[index];
    }

    // tc O(n^2), sc O(n)
    // https://leetcode.com/problems/largest-divisible-subset/discuss/84006/Classic-DP-solution-similar-to-LIS-O(n2)
    public List<Integer> largestDivisibleSubset2(int[] nums) {
        int n = nums.length;
        int max = 0;
        int index = -1;
        int[] count = new int[n];
        int[] pre = new int[n];
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            count[i] = 1;
            pre[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (1 + count[j] > count[i]) {
                        count[i] = 1 + count[j];
                        pre[i] = j;
                    }
                }
            }
            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while (index != -1) {
            res.add(nums[index]);
            index = pre[index];
        }
        return res;
    }
}
