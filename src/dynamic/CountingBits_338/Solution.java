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
    // 1 ms, faster than 99.74%; 37.6 MB, less than 5.88%
    //  f[i] = f[i / 2] + i % 2.
    int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) {
            f[i] = f[i >> 1] + (i & 1);
        }
        return f;
    }

    // tc O(n), sc O(n)
    // 1ms, faster than 99.74%; 38.4 MB
    int[] countBits2(int num) {
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

    // tc O(n), sc O(n)
    // 2ms, faster than 28.97%; 38.6 MB, less than 5.88%
    int[] countBits1(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int count = 0;
            int tmp = i;
            while (tmp != 0) {
                if ((tmp & 1) == 1) {
                    count++;
                }
                tmp >>>= 1;
            }
            result[i] = count;
        }
        return result;
    }
}
