package twoPointers.ThreeSumWithMultiplicity_923;

import java.util.Arrays;

/**
 * 923. 3Sum With Multiplicity
 * https://leetcode.com/problems/3sum-with-multiplicity/
 *
 * Given an integer array arr, and an integer target, return the number of tuples i, j, k
 * such that i < j < k and arr[i] + arr[j] + arr[k] == target.
 *
 * As the answer can be very large, return it modulo 109 + 7.
 *
 * Example 1:
 * Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
 * Output: 20
 * Explanation:
 * Enumerating by the values (arr[i], arr[j], arr[k]):
 * (1, 2, 5) occurs 8 times;
 * (1, 3, 4) occurs 8 times;
 * (2, 2, 4) occurs 2 times;
 * (2, 3, 3) occurs 2 times.
 *
 * Example 2:
 * Input: arr = [1,1,2,2,2,2], target = 5
 * Output: 12
 * Explanation:
 * arr[i] = 1, arr[j] = arr[k] = 2 occurs 12 times:
 * We choose one 1 from [1,1] in 2 ways,
 * and two 2s from [2,2,2,2] in 6 ways.
 *
 * Constraints:
 * 3 <= arr.length <= 3000
 * 0 <= arr[i] <= 100
 * 0 <= target <= 300
 */
public class Solution {
    // tc O(n^2), sc O(1)
    // 39 ms, faster than 47.50%; 38.7 MB, less than 67.86%
    public int threeSumMulti(int[] arr, int target) {
        int mod = (int) 1e9 + 7;
        Arrays.sort(arr);
        int n = arr.length;
        long res = 0;
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                if (arr[l] + arr[r] < target - arr[i]) {
                    l++;
                } else if (arr[l] + arr[r] > target - arr[i]) {
                    r--;
                } else if (arr[l] != arr[r]) {
                    int left = 1, right = 1;
                    while (l + 1 < r && arr[l + 1] == arr[l]) {
                        l++;
                        left++;
                    }
                    while (l + 1 < r && arr[r - 1] == arr[r]) {
                        r--;
                        right++;
                    }
                    res = (res + left * right) % mod;
                    l++; r--;
                } else {
                    int m = r - l + 1;
                    res = (res + m * (m - 1) / 2) % mod;
                    break;
                }
            }
        }

        return (int) res;
    }

    // TLE
    // tc (n^2 * logn)
    private final static int mod = (int) 1e9 + 7;
    private int res;
    public int threeSumMulti1(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        res = 0;
        helper(arr, 0, n - 1, target, new Integer[n][n]);
        return res;
    }

    private void helper(int[] arr, int i, int j, int target, Integer[][] memo) {
        if (j - i <= 1 || memo[i][j] != null) return;

        int l = i, r = j;
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (arr[m] < target - arr[i] - arr[j]) {
                l = m;
            } else {
                r = m;
            }
        }

        int count = 0;
        if (r < j && arr[i] + arr[j] + arr[r] == target) {
            int start = r;
            l = i; r = j;
            while (r - l > 1) {
                int m = l + (r - l) / 2;
                if (arr[m] <= target - arr[i] - arr[j]) {
                    l = m;
                } else {
                    r = m;
                }
            }
            int end = l;
            count = end - start + 1;
        }

        res = (res + count) % mod;
        memo[i][j] = res;

        helper(arr, i + 1, j, target, memo);
        helper(arr, i, j - 1, target, memo);
    }
}
