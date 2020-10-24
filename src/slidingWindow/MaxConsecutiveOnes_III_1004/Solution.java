package slidingWindow.MaxConsecutiveOnes_III_1004;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1004. Max Consecutive Ones III
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 *
 * Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
 *
 * Return the length of the longest (contiguous) subarray that contains only 1s.
 *
 * Example 1:
 * Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * Output: 6
 * Explanation:
 * [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 *
 * Example 2:
 * Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * Output: 10
 * Explanation:
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 *
 * Note:
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] is 0 or 1
 */
public class Solution {
    // tc O(n), sc O(1)
    public int longestOnes(int[] A, int K) {
        int i = 0, j;
        for (j = 0; j < A.length; ++j) {
            if (A[j] == 0) K--;
            if (K < 0 && A[i++] == 0) K++;
        }
        return j - i;
    }

    /*
         0,1,2,3,4,5,6,7,8,9,10
                               v
        [0,1,1,1,0,0,0,1,1,1,1,0]
                   ^
         l=5
         r=10
         res=4
         K=1
         q:{5,6}
     */
    // my solution:
    // two cases
    //  1. k=0 -> trivial approach
    //  2. k>0 -> move right pointer
    //                  - while A[r]==0 && queue.size() < K add right ptr to queue
    //                  - while A[r] == 1
    //            if queue.size==K -> l = queue.poolFirst + 1
    // tc O(n), sc O(k)
    public int longestOnes1(int[] A, int K) {
        int res = 0, n = A.length;
        if (K == 0) {
            int cnt = 0;
            for (int a : A) {
                if (a == 1) {
                    cnt++;
                    res = Math.max(res, cnt);
                } else {
                    cnt = 0;
                }
            }
            return res;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        int l = 0, r = 0;
        while (r < n) {
            while (r < n && A[r] == 0 && queue.size() < K) {
                queue.addLast(r++);
            }
            while (r < n && A[r] == 1) r++;
            res = Math.max(res, r - l);

            if (K > 0 && queue.size() == K) {
                int mostLeftInd = queue.removeFirst();
                l = mostLeftInd + 1;
            }
        }

        return res;
    }
}
