package binarySearch.ArrangingCoins_441;

/**
 * 441. Arranging Coins
 * https://leetcode.com/problems/arranging-coins/
 *
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 * Given n, find the total number of full staircase rows that can be formed.
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 *
 * Example 1:
 * n = 5
 *
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * Because the 3rd row is incomplete, we return 2.
 *
 * Example 2:
 * n = 8
 *
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 *
 * Because the 4th row is incomplete, we return 3.
 */
public class Solution {
    // tc O(logn), sc O(1)
    // find max k that k (k + 1) / 2 <= n
    public int arrangeCoins(int n) {
        long l = 1, r = n;
        while (l <= r) {
            long m = (l + r) >>> 1;
            long cur = m * (m + 1) / 2;
            if (cur == n) {
                return (int) m;
            }
            if (cur < n) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return (int) r;
    }

    // tc O(1), sc O(1)
    // n = k (k + 1) / 2 -> k^2 + k - 2n = 0 -> k = Math.sqrt(1 + 8n) / 2 - 0.5
    public int arrangeCoins1(int n) {
        return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
    }

    // naive straightforward O(n)
    public int arrangeCoins2(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n -= count;
        }
        return n == 0 ? count : count - 1;
    }
}
