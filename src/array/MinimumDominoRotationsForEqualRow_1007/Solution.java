package array.MinimumDominoRotationsForEqualRow_1007;

/**
 * 1007. Minimum Domino Rotations For Equal Row
 * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 *
 * In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.
 * (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
 *
 * We may rotate the i-th domino, so that A[i] and B[i] swap values.
 *
 * Return the minimum number of rotations so that all the values in A are the same, or all the
 * values in B are the same.
 *
 * If it cannot be done, return -1.
 *
 * Example 1:
 * Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
 * Output: 2
 * Explanation:
 * The first figure represents the dominoes as given by A and B: before we do any rotations.
 * If we rotate the second and fourth dominoes, we can make every value in the top row equal to
 * 2, as indicated by the second figure.
 *
 * Example 2:
 * Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
 * Output: -1
 * Explanation:
 * In this case, it is not possible to rotate the dominoes to make one row of values equal.
 *
 * Note:
 * 1 <= A[i], B[i] <= 6
 * 2 <= A.length == B.length <= 20000
 */
public class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int[][] arr = new int[6][4];
        for (int i = 0; i < A.length; i++) {
            arr[A[i] - 1][0]++;
            arr[B[i] - 1][0]++;
            if (A[i] == B[i]) arr[B[i] - 1][1]++;
            arr[A[i] - 1][2]++;
            arr[B[i] - 1][3]++;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] >= A.length) {
                int n = arr[i][0] - A.length - arr[i][1];
                if (n >= 0) {
                    int value = arr[i][2] <= arr[i][3] ? arr[i][2] - arr[i][1] : arr[i][3] - arr[i][1];
                    min = Math.min(min, value);
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
