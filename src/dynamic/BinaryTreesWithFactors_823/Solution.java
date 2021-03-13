package dynamic.BinaryTreesWithFactors_823;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.LongStream;

/**
 * 823. Binary Trees With Factors
 * https://leetcode.com/problems/binary-trees-with-factors/
 *
 * Given an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.
 *
 * We make a binary tree using these integers, and each number may be used for any number of times.
 * Each non-leaf node's value should be equal to the product of the values of its children.
 *
 * Return the number of binary trees we can make. The answer may be too large so return the answer modulo 109 + 7.
 *
 * Example 1:
 * Input: arr = [2,4]
 * Output: 3
 * Explanation: We can make these trees: [2], [4], [4, 2, 2]
 *
 * Example 2:
 * Input: arr = [2,4,5,10]
 * Output: 7
 * Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 *
 * Constraints:
 * 1 <= arr.length <= 1000
 * 2 <= arr[i] <= 10^9
 */
public class Solution {
    // tc O(n^2), sc O(n)
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        int mod = (int) 1e9 + 7;
        long[] dp = new long[n];
        Arrays.sort(arr);
        Arrays.fill(dp, 1);

        Map<Integer, Integer> indexes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexes.put(arr[i], i);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int right = arr[i] / arr[j];
                    if (indexes.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[indexes.get(right)]) % mod;
                    }
                }
            }
        }

        long res = LongStream.of(dp).sum();
        return (int) (res % mod);
    }
}
