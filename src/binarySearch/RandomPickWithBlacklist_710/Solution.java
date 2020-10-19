package binarySearch.RandomPickWithBlacklist_710;

import java.util.Arrays;
import java.util.Random;

/**
 * 710. Random Pick with Blacklist
 * https://leetcode.com/problems/random-pick-with-blacklist/
 *
 * Given a blacklist B containing unique integers from [0, N), write a function to
 * return a uniform random integer from [0, N) which is NOT in B.
 *
 * Optimize it such that it minimizes the call to system’s Math.random().
 *
 * Note:
 * 1 <= N <= 1000000000
 * 0 <= B.length < min(100000, N)
 * [0, N) does NOT include N. See interval notation.
 *
 * Example 1:
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[1,[]],[],[],[]]
 * Output: [null,0,0,0]
 *
 * Example 2:
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[2,[]],[],[],[]]
 * Output: [null,1,1,1]
 *
 * Example 3:
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[3,[1]],[],[],[]]
 * Output: [null,0,0,2]
 *
 * Example 4:
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[4,[2]],[],[],[]]
 * Output: [null,1,3,1]
 * Explanation of Input Syntax:
 *
 * The input is two lists: the subroutines called and their arguments. Solution's
 * constructor has two arguments, N and the blacklist B. pick has no arguments.
 * Arguments are always wrapped with a list, even if there aren't any.
 */
public class Solution {
    private Random rnd;
    private int N;
    private int[] blacklist;

    // tc O(blogb), sc O(1)
    public Solution(int N, int[] blacklist) {
        this.N = N;
        Arrays.sort(blacklist);
        this.blacklist = blacklist;
        rnd = new Random();
    }

    // tc O(logb)
    public int pick() {
        int b_len = blacklist.length;
        int num = rnd.nextInt(N - b_len);
        int l = -1, r = b_len;
        while (r - l > 1) {
            int m = (l + r) >>> 1;
            if (blacklist[m] - m <= num) {
                l = m;
            } else {
                r = m;
            }
        }
        return num + r;
    }
}
