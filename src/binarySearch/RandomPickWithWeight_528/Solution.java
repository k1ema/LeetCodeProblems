package binarySearch.RandomPickWithWeight_528;

/**
 * 528. Random Pick with Weight
 * https://leetcode.com/problems/random-pick-with-weight/
 *
 * Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which
 * randomly picks an index in proportion to its weight.
 *
 * Note:
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex will be called at most 10000 times.
 *
 * Example 1:
 * Input:
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * Output: [null,0]
 *
 * Example 2:
 * Input:
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * Output: [null,0,1,1,1,0]
 *
 * Explanation of Input Syntax:
 * The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w.
 * pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.
 */
public class Solution {
    private int[] indexes;
    private int indSum;

    public Solution(int[] w) {
        indSum = 0;
        indexes = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            indSum += w[i];
            indexes[i] = indSum;
        }
    }

    public int pickIndex() {
        double target = Math.random() * indSum;
        int lo = 0, hi = indexes.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (target > indexes[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }
}
