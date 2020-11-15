package dynamic.CountingBits_338;

/**
 * 338. Counting Bits
 * https://leetcode.com/problems/counting-bits/
 *
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num
 * calculate the number of 1's in their binary representation and return them as an array.
 *
 * Example 1:
 * Input: 2
 * Output: [0,1,1]
 *
 * Example 2:
 * Input: 5
 * Output: [0,1,1,2,1,2]
 *
 * Follow up:
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)).
 * But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount
 * in c++ or in any other language.
 */
public class Solution {
    // tc O(n), sc O(n)
    // 1 ms, faster than 99.78%; 43.4 MB, less than 29.79%
    // f[i] = f[i / 2] + i % 2.
    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            f[i] = f[i >> 1] + (i & 1);
        }
        return f;
    }

    // tc O(n), sc O(n)
    // 2 ms, faster than 34.83%; 43.4 MB, less than 39.20%
    public int[] countBits1(int num) {
        int[] dp = new int[num + 1];
        if (num == 0) return dp;
        for (int i = 1; i <= num; i++) {
            int x = lsb(i);
            dp[i] = ((i & (i - 1)) == 0) ? 1 : 1 + dp[i - (1 << x)];
        }
        return dp;
    }

    private int lsb(int num) {
        int x = 0;
        while (num > 0) {
            num >>= 1;
            x++;
        }
        return x > 0 ? x - 1 : 0;
    }

    // DFS!
    // tc O(n), sc O(n)
    // Runtime: 0 ms, faster than 100.00%
    public int[] countBits2(int num) {
        int[] result = new int[num + 1];
        dfs(result, num, 1, 1);
        return result;
    }

    private void dfs(int[] result, int num, int count, int val) {
        if (val > num) return;
        result[val] = count;
        dfs(result, num, count, val * 2);
        dfs(result, num, count + 1, val * 2 + 1);
    }

    // tc O(n * sizeof(int)), sc O(n)
    // 1ms, faster than 99.74%; 38.4 MB
    public int[] countBits3(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int tmp = i;
            int count = 0;
            while (tmp != 0) {
                tmp = tmp & (tmp - 1);
                count++;
            }
            result[i] = count;
        }
        return result;
    }
}
