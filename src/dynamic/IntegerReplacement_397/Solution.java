package dynamic.IntegerReplacement_397;

import java.util.HashMap;
import java.util.Map;

/**
 * 397. Integer Replacement
 * https://leetcode.com/problems/integer-replacement/
 *
 * Given a positive integer n and you can do operations as follow:
 *
 * If n is even, replace n with n/2.
 * If n is odd, you can replace n with either n + 1 or n - 1.
 * What is the minimum number of replacements needed for n to become 1?
 *
 * Example 1:
 * Input:
 * 8
 * Output:
 * 3
 *
 * Explanation:
 * 8 -> 4 -> 2 -> 1
 *
 * Example 2:
 * Input:
 * 7
 * Output:
 * 4
 *
 * Explanation:
 * 7 -> 8 -> 4 -> 2 -> 1
 * or
 * 7 -> 6 -> 3 -> 2 -> 1
 */
public class Solution {
    public int integerReplacement(int n) {
        return bt(n, new HashMap<>());
    }

    private int bt(int n, Map<Integer, Integer> memo) {
        if (n == 1) return 0;
        if (memo.containsKey(n)) return memo.get(n);
        int v = 0;
        if (n % 2 == 0) {
            v = 1 + bt(n / 2, memo);
        } else {
            v = (n == Integer.MAX_VALUE) ? bt(n - 1, memo) : 1 + Math.min(bt(n - 1, memo), bt(n + 1, memo));
        }
        memo.put(n, v);
        return v;
    }
}
