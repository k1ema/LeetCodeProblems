package heap.SortIntegersByThePowerValue_1387;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1387. Sort Integers by The Power Value
 * https://leetcode.com/problems/sort-integers-by-the-power-value/
 *
 * The power of an integer x is defined as the number of steps needed to transform x into 1
 * using the following steps:
 *
 * if x is even then x = x / 2
 * if x is odd then x = 3 * x + 1
 * For example, the power of x = 3 is 7 because 3 needs 7 steps to become 1
 * (3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1).
 *
 * Given three integers lo, hi and k. The task is to sort all integers in the interval
 * [lo, hi] by the power value in ascending order, if two or more integers have the same
 * power value sort them by ascending order.
 *
 * Return the k-th integer in the range [lo, hi] sorted by the power value.
 *
 * Notice that for any integer x (lo <= x <= hi) it is guaranteed that x will transform
 * into 1 using these steps and that the power of x is will fit in 32 bit signed integer.
 *
 * Example 1:
 * Input: lo = 12, hi = 15, k = 2
 * Output: 13
 * Explanation: The power of 12 is 9 (12 --> 6 --> 3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1)
 * The power of 13 is 9
 * The power of 14 is 17
 * The power of 15 is 17
 * The interval sorted by the power value [12,13,14,15]. For k = 2 answer is the second element which is 13.
 * Notice that 12 and 13 have the same power value and we sorted them in ascending order. Same for 14 and 15.
 *
 * Example 2:
 * Input: lo = 1, hi = 1, k = 1
 * Output: 1
 *
 * Example 3:
 * Input: lo = 7, hi = 11, k = 4
 * Output: 7
 * Explanation: The power array corresponding to the interval [7, 8, 9, 10, 11] is [16, 3, 19, 6, 14].
 * The interval sorted by power is [8, 10, 11, 7, 9].
 * The fourth number in the sorted array is 7.
 *
 * Example 4:
 * Input: lo = 10, hi = 20, k = 5
 * Output: 13
 *
 * Example 5:
 * Input: lo = 1, hi = 1000, k = 777
 * Output: 570
 *
 * Constraints:
 * 1 <= lo <= hi <= 1000
 * 1 <= k <= hi - lo + 1
 */
public class Solution {
    // tc O(max(nlogn, sum(power))), sc O(k); n = lo - hi + 1
    // 52 ms, faster than 42.86%; 39.4 MB, less than 100.00%
    public int getKth(int lo, int hi, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> {
            if (p1.power == p2.power) return p2.val - p1.val;
            else return p2.power - p1.power;
        });

        for (int i = lo; i <= hi; i++) {
            pq.add(new Pair(power(i), i));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll().val;
    }

    private class Pair {
        private int power;
        private int val;

        public Pair(int power, int val) {
            this.power = power;
            this.val = val;
        }
    }

    private int power(int v) {
        int power = 0;
        while (v != 1) {
            if (v % 2 == 0) v = v / 2;
            else v = v * 3 + 1;
            power++;
        }
        return power;
    }

    // tc O(max(nlogn, sum(n))) where sum(n) = sum(a[i]), sc O(n); n = a.length
    // 58 ms, faster than 42.86%; 41 MB, less than 100.00%
    public int getKth1(int lo, int hi, int k) {
        int[] a = new int[hi - lo + 1];
        for (int i = 0; i < a.length; i++) {
            int v = i + lo;
            int count = 0;
            while (v != 1) {
                if (v % 2 == 0) v = v / 2;
                else v = v * 3 + 1;
                count++;
            }
            a[i] = count;
        }

        int[][] res = new int[a.length][2];
        int v = lo;
        for (int i = 0; i < res.length; i++) {
            res[i] = new int[2];
            res[i][0] = v;
            res[i][1] = a[i];
            v++;
        }
        Arrays.sort(res, (c, b) -> {
            if (c[1] == b[1]) return c[0] - b[0];
            else return c[1] - b[1];
        });

        return res[k - 1][0];
    }
}
