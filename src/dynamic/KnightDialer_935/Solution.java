package dynamic.KnightDialer_935;

import java.util.HashMap;
import java.util.Map;

/**
 * 935. Knight Dialer
 * https://leetcode.com/problems/knight-dialer/
 *
 * The chess knight has a unique movement, it may move two squares vertically and one square
 * horizontally, or two squares horizontally and one square vertically (with both forming the
 * shape of an L). The possible movements of chess knight are shown in this diagaram:
 *
 * A chess knight can move as indicated in the chess diagram below:
 *
 * We have a chess knight and a phone pad as shown below, the knight can only stand on a numeric cell (i.e. blue cell).
 *
 * Given an integer n, return how many distinct phone numbers of length n we can dial.
 *
 * You are allowed to place the knight on any numeric cell initially and then you should
 * perform n - 1 jumps to dial a number of length n. All jumps should be valid knight jumps.
 *
 * As the answer may be very large, return the answer modulo 109 + 7.
 *
 * Example 1:
 * Input: n = 1
 * Output: 10
 * Explanation: We need to dial a number of length 1, so placing the knight over any numeric cell of the 10 cells is sufficient.
 *
 * Example 2:
 * Input: n = 2
 * Output: 20
 * Explanation: All the valid number we can dial are [04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92, 94]
 *
 * Example 3:
 * Input: n = 3
 * Output: 46
 *
 * Example 4:
 * Input: n = 4
 * Output: 104
 *
 * Example 5:
 * Input: n = 3131
 * Output: 136006598
 * Explanation: Please take care of the mod.
 *
 * Constraints:
 * 1 <= n <= 5000
 */
public class Solution {
    // Problem is the same as 1220. Count Vowels Permutation
    // https://leetcode.com/problems/count-vowels-permutation/
    // tc O(n), sc O(n)
    // https://alexgolec.dev/google-interview-questions-deconstructed-the-knights-dialer/
    // 578 ms, faster than 9.34%; 46.1 MB, less than 15.99%
    public int knightDialer(int n) {
        Map<Integer, int[]> movements = new HashMap<>();
        movements.put(0, new int[] {4, 6});
        movements.put(1, new int[] {6, 8});
        movements.put(2, new int[] {7, 9});
        movements.put(3, new int[] {4, 8});
        movements.put(4, new int[] {0, 3, 9});
        movements.put(5, new int[] {});
        movements.put(6, new int[] {0, 1, 7});
        movements.put(7, new int[] {2, 6});
        movements.put(8, new int[] {1, 3});
        movements.put(9, new int[] {2, 4});
        int mod = (int) 1e9 + 7;
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res = (res + dp(n - 1, i, movements, new Integer[n + 1][10])) % mod;
        }
        return res;
    }

    private int dp(int n, int i, Map<Integer, int[]> movements, Integer[][] memo) {
        if (n == 0) return 1;
        if (memo[n][i] != null) return memo[n][i];
        int res = 0;
        int mod = (int) 1e9 + 7;
        for (int newI : movements.get(i)) {
            res = (res + dp(n - 1, newI, movements, memo)) % mod;
        }
        memo[n][i] = res;
        return res;
    }
}
