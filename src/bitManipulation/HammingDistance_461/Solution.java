package bitManipulation.HammingDistance_461;

/**
 * 461. Hamming Distance
 * https://leetcode.com/problems/hamming-distance/
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 *
 * Note:
 * 0 ≤ x, y < 2^31.
 *
 * Example:
 *
 * Input: x = 1, y = 4
 *
 * Output: 2
 *
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * The above arrows point to positions where the corresponding bits are different.
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((((x >> i) & 1) ^ ((y >> i) & 1)) == 1) {
                count++;
            }
        }
        return count;
    }

    // Integer.bitCount(x ^ y);
    // https://discuss.leetcode.com/topic/72093/java-1-line-solution-d/2
    // https://discuss.leetcode.com/topic/72089/java-3-line-solution
    // tc O(1), sc O(1)
    int hammingDistance1(int x, int y) {
        int count = 0;
        while (x != 0 || y != 0) {
            if ((x & 1) != (y & 1)) {
                count++;
            }
            x = x >> 1;
            y = y >> 1;
        }
        return count;
    }
}
