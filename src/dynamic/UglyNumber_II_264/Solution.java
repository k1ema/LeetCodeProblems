package dynamic.UglyNumber_II_264;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 264. Ugly Number II
 * https://leetcode.com/problems/ugly-number-ii/
 *
 * Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Example:
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 *
 * Note:
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 */

class Solution {
    public int nthUglyNumber(int n) {
        Ugly1 u = new Ugly1();
        return u.nums[n - 1];
    }

    // heap
    // Time complexity : O(1) to retrieve preliminary computed ugly number, and more than 12 * 10^6
    // operations for preliminary computations. Let's estimate the number of operations needed for the preliminary computations.
    // For loop here has 1690 steps, and each step performs 1 pop, not more than 3 pushes and 3 contains / in operations for the hashset.
    // Pop and push have logarithmic time complexity and hence much cheaper than the linear search, so let's estimate only the last term.
    // This arithmetic progression is easy to estimate:
    // 1 + 2 + 3 + ... + 1690 * 3 = (1 + 1690 * 3) * 1690 * 3 / 2 > 4.5×1690^2
    // Space complexity : constant space to keep an array of 1690 ugly numbers, the heap of not more than 1690 * 2 elements
    // and the hashset of not more than 1690 * 3 elements.
    class Ugly {
        public int[] nums = new int[1690];

        Ugly() {
            PriorityQueue<Long> pq = new PriorityQueue<>();
            Set<Long> seen = new HashSet<>();
            pq.add(1L);
            long cur, newUgly;
            int[] prime = new int[] {2, 3, 5};
            for (int i = 0; i < 1690; i++) {
                cur = pq.poll();
                nums[i] = (int) cur;
                for (int num : prime) {
                    newUgly = num * cur;
                    if (!seen.contains(newUgly)) {
                        pq.add(newUgly);
                        seen.add(newUgly);
                    }
                }
            }
        }
    }

    // dynamic approach
    // tc O(1) to retrieve preliminary computed ugly number, and about 1690 * 5 = 8450 operations for preliminary computations.
    // sc O(1) = 1690 elements
    class Ugly1 {
        public int[] nums = new int[1690];

        Ugly1() {
            nums[0] = 1;
            int ugly, i2 = 0, i3 = 0, i5 = 0;
            for (int i = 1; i < 1690; i++) {
                ugly = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
                nums[i] = ugly;
                if (ugly == nums[i2] * 2) i2++;
                if (ugly == nums[i3] * 3) i3++;
                if (ugly == nums[i5] * 5) i5++;
            }
        }
    }

    // TLE
    public int nthUglyNumber1(int n) {
        int i = 0, num = 0;
        while (i < n) {
            if (isUgly(++num)) {
                i++;
            }
        }
        return num;
    }

    public boolean isUgly(int num) {
        for (int i = 2; i < 6 && num > 0; i++) {
            while (num % i == 0)
                num /= i;
        }
        return num == 1;
    }
}
