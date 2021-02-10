package greedy.FindPermutation_484;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 484. Find Permutation
 * https://leetcode.com/problems/find-permutation/
 *
 * By now, you are given a secret signature consisting of character 'D' and 'I'. 'D' represents a decreasing
 * relationship between two numbers, 'I' represents an increasing relationship between two numbers. And our
 * secret signature was constructed by a special integer array, which contains uniquely all the different
 * number from 1 to n (n is the length of the secret signature plus 1). For example, the secret signature
 * "DI" can be constructed by array [2,1,3] or [3,1,2], but won't be constructed by array [3,2,4] or [2,1,3,4],
 * which are both illegal constructing special string that can't represent the "DI" secret signature.
 *
 * On the other hand, now your job is to find the lexicographically smallest permutation of [1, 2, ... n] could
 * refer to the given secret signature in the input.
 *
 * Example 1:
 * Input: "I"
 * Output: [1,2]
 * Explanation: [1,2] is the only legal initial spectial string can construct secret signature "I", where the
 * number 1 and 2 construct an increasing relationship.
 *
 * Example 2:
 * Input: "DI"
 * Output: [2,1,3]
 * Explanation: Both [2,1,3] and [3,1,2] can construct the secret signature "DI",
 * but since we want to find the one with the smallest lexicographical permutation, you need to output [2,1,3]
 *
 * Note:
 * The input string will only contain the character 'D' and 'I'.
 * The length of input string is a positive integer and will not exceed 10,000
 */
public class Solution {
    // tc O(n), sc O(1)
    // 2 ms, faster than 88.69%; 41 MB, less than 88.69%
    public int[] findPermutation(String s) {
        int n = s.length() + 1;
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        int countD = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'D') {
                countD++;
            } else {
                if (countD > 0) {
                    reverse(nums, countD, i);
                    countD = 0;
                }
            }
        }
        if (countD > 0) {
            reverse(nums, countD, n - 1);
        }
        return nums;
    }

    private void reverse(int[] nums, int countD, int tillInd) {
        int l = tillInd - countD, r = tillInd;
        while (l < r) {
            nums[l] ^= nums[r];
            nums[r] ^= nums[l];
            nums[l] ^= nums[r];
            l++; r--;
        }
    }

    // tc O(2^n)), sc O(2^n), where n = s.length() + 1, TLE
    public int[] findPermutation1(String s) {
        int n = s.length() + 1;
        Set<int[]> set = new HashSet<>();
        for (int val = 1; val <= n; val++) {
            int[] nums = new int[n];
            nums[0] = val;
            boolean[] visited = new boolean[n + 1];
            bt(s, 0, val, set, nums, visited);
        }

        return set.stream().min((a, b) -> {
            for (int i = 0; i < a.length; i++) {
                if (a[i] < b[i]) {
                    return -1;
                } else if (a[i] > b[i]) {
                    return 1;
                }
            }
            return 0;
        }).get();
    }

    private void bt(String s, int sInd, int val, Set<int[]> set, int[] nums, boolean[] visited) {
        if (visited[val]) return;
        if (sInd == s.length()) {
            set.add(Arrays.copyOf(nums, nums.length));
            return;
        }
        visited[val] = true;
        boolean increase = s.charAt(sInd) == 'I';
        if (increase) {
            for (int newVal = val + 1; newVal <= nums.length; newVal++) {
                nums[sInd + 1] = newVal;
                bt(s, sInd + 1, newVal, set, nums, visited);
            }
        } else {
            for (int newVal = val - 1; newVal > 0; newVal--) {
                nums[sInd + 1] = newVal;
                bt(s, sInd + 1, newVal, set, nums, visited);
            }
        }
        visited[val] = false;
    }
}
