package bitManipulation.NumberComplement_476;

/**
 * 476. Number Complement
 * https://leetcode.com/problems/number-complement/
 *
 * Given a positive integer, output its complement number. The complement strategy
 * is to flip the bits of its binary representation.
 *
 * Example 1:
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and
 * its complement is 010. So you need to output 2.
 *
 * Example 2:
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its
 * complement is 0. So you need to output 0.
 *
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 * This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/
 */
public class Solution {
    // tc O(1), sc O(1)
    public int findComplement(int num) {
        if (num == 0) return 1;
        int res = ~num;
        for (int i = 31; i >= 0; i--) {
            if ((res & (1 << i)) != 0) {
                res ^= (1 << i);
            } else {
                break;
            }
        }
        return res;
    }

    public int findComplement1(int num) {
        int todo = num, bit = 1;
        while (todo != 0) {
            // flip current bit
            num = num ^ bit;
            // prepare for the next run
            bit = bit << 1;
            todo = todo >> 1;
        }
        return num;
    }

    public int findComplement2(int num) {
        // n is a length of num in binary representation
        int n = (int)( Math.log(num) / Math.log(2) ) + 1;
        // bitmask has the same length as num and contains only ones 1...1
        int bitmask = (1 << n) - 1;
        // flip all bits
        return bitmask ^ num;
    }
}
