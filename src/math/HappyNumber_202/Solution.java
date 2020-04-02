package math.HappyNumber_202;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. Happy Number
 * https://leetcode.com/problems/happy-number/
 *
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any
 * positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay), or it
 * loops endlessly in a cycle which does not include 1. Those numbers for which
 * this process ends in 1 are happy numbers.
 *
 * Example:
 * Input: 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class Solution {
    // tc O(logn), sc O(1)
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    Set<Integer> set;
    boolean isHappy1(int n) {
        set = new HashSet<>();
        return bt(n);
    }

    private boolean bt(int n) {
        if (n == 1) return true;
        if (set.contains(n)) return false;
        set.add(n);
        int sum = 0;
        while (n > 0) {
            int v = n % 10;
            n /= 10;
            sum += v * v;
        }
        return bt(sum);
    }
}
