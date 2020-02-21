package array.SquaresOfASortedArray_977;

/**
 * 977. Squares of a Sorted Array
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 *
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each
 * number, also in sorted non-decreasing order.
 *
 * Example 1:
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 *
 * Example 2:
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 * Note:
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A is sorted in non-decreasing order.
 */
public class Solution {
    // tc O(n), sc O(n)
    // 1 ms, faster than 100.00%; 42.3 MB, less than 68.90%
    int[] sortedSquares(int[] A) {
        if (A.length == 1) return new int[] {A[0] * A[0]};

        // an index where negative integers stop
        int negativeStop = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) negativeStop = i;
        }

        int[] result = new int[A.length];
        int i = negativeStop, j = negativeStop + 1, k = 0;
        while (i >= 0 || j < A.length) {
            if (j == A.length || i >= 0 && -A[i] < A[j]) {
                result[k] = A[i] * A[i];
                i--;
            } else {
                result[k] = A[j] * A[j];
                j++;
            }
            k++;
        }
        return result;
    }
}
