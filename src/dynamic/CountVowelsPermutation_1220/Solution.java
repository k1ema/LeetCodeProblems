package dynamic.CountVowelsPermutation_1220;

import java.util.HashMap;
import java.util.Map;

/**
 * 1220. Count Vowels Permutation
 * https://leetcode.com/problems/count-vowels-permutation/
 *
 * Given an integer n, your task is to count how many strings of length n can be formed under the following rules:
 *
 * Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
 * Each vowel 'a' may only be followed by an 'e'.
 * Each vowel 'e' may only be followed by an 'a' or an 'i'.
 * Each vowel 'i' may not be followed by another 'i'.
 * Each vowel 'o' may only be followed by an 'i' or a 'u'.
 * Each vowel 'u' may only be followed by an 'a'.
 * Since the answer may be too large, return it modulo 10^9 + 7.
 *
 * Example 1:
 * Input: n = 1
 * Output: 5
 * Explanation: All possible strings are: "a", "e", "i" , "o" and "u".
 *
 * Example 2:
 * Input: n = 2
 * Output: 10
 * Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".
 *
 * Example 3:
 * Input: n = 5
 * Output: 68
 *
 * Constraints:
 * 1 <= n <= 2 * 10^4
 */
public class Solution {
    // Problem is the same as 935. Knight Dialer
    // https://leetcode.com/problems/knight-dialer/
    // tc O(n), sc O(n)
    public int countVowelPermutation(int n) {
        Map<Integer, int[]> map = new HashMap<>();
        map.put(0, new int[] {1});
        map.put(1, new int[] {0, 2});
        map.put(2, new int[] {0, 1, 3, 4});
        map.put(3, new int[] {2, 4});
        map.put(4, new int[] {0});
        int mod = (int) 1e9 + 7;
        int res = 0;
        for (int i = 0; i < map.size(); i++) {
            res = (res + dp(n - 1, i, map, new Integer[n + 1][map.size()])) % mod;
        }
        return res;
    }

    private int dp(int n, int i, Map<Integer, int[]> options, Integer[][] memo) {
        if (n == 0) return 1;
        if (memo[n][i] != null) return memo[n][i];
        int res = 0;
        int mod = (int) 1e9 + 7;
        for (int newI : options.get(i)) {
            res = (res + dp(n - 1, newI, options, memo)) % mod;
        }
        memo[n][i] = res;
        return res;
    }
}
