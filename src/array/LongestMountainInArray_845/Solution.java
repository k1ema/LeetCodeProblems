package array.LongestMountainInArray_845;

/**
 * 845. Longest Mountain in Array
 * https://leetcode.com/problems/longest-mountain-in-array/
 *
 * Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:
 *  - B.length >= 3
 *  - There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * (Note that B could be any subarray of A, including the entire array A.)
 *
 * Given an array A of integers, return the length of the longest mountain.
 *
 * Return 0 if there is no mountain.
 *
 * Example 1:
 * Input: [2,1,4,7,3,2,5]
 * Output: 5
 * Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
 *
 * Example 2:
 * Input: [2,2,2]
 * Output: 0
 * Explanation: There is no mountain.
 *
 * Note:
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 *
 * Follow up:
 * Can you solve it using only one pass?
 * Can you solve it in O(1) space?
 */
public class Solution {
    // tc O(n), sc O(1), one pass
    // 2 ms, faster than 85.73%; 40.4 MB, less than 30.19%
    public int longestMountain(int[] A) {
        if (A.length < 3) return 0;
        int res = 1, cur = 1;
        int dir = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                if (dir >= 0) {
                    cur++;
                } else {
                    cur = 2;
                }
                dir = 1;
            } else if (A[i] < A[i - 1] && (dir > 0 && cur > 1 || dir < 0)) {
                cur++;
                dir = -1;
            } else {
                cur = 1;
                dir = 0;
            }
            if (dir < 0) {
                res = Math.max(res, cur);
            }
        }
        return res == 1 ? 0 : res;
    }

    // tc O(n), sc O(1)
    // 1ms
    public int longestMountain1(int[] A) {
        if (A.length < 3) return 0;
        int res = 0;
        for (int i = 1; i < A.length - 1; i++) {
            int cur;
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                cur = 3;
                for (int j = i + 2; j < A.length; j++) {
                    if (A[j] < A[j - 1]) {
                        cur++;
                    } else {
                        break;
                    }
                }
                for (int j = i - 2; j >= 0; j--) {
                    if (A[j] < A[j + 1]) {
                        cur++;
                    } else {
                        break;
                    }
                }
                res = Math.max(res, cur);
            }
        }
        return res;
    }
}
