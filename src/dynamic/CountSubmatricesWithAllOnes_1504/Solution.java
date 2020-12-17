package dynamic.CountSubmatricesWithAllOnes_1504;

import java.util.Arrays;

/**
 * 1504. Count Submatrices With All Ones
 * https://leetcode.com/problems/count-submatrices-with-all-ones/
 *
 * Given a rows * columns matrix mat of ones and zeros, return how many submatrices have all ones.
 *
 * Example 1:
 * Input: mat = [[1,0,1],
 *               [1,1,0],
 *               [1,1,0]]
 * Output: 13
 * Explanation:
 * There are 6 rectangles of side 1x1.
 * There are 2 rectangles of side 1x2.
 * There are 3 rectangles of side 2x1.
 * There is 1 rectangle of side 2x2.
 * There is 1 rectangle of side 3x1.
 * Total number of rectangles = 6 + 2 + 3 + 1 + 1 = 13.
 *
 * Example 2:
 * Input: mat = [[0,1,1,0],
 *               [0,1,1,1],
 *               [1,1,1,0]]
 * Output: 24
 * Explanation:
 * There are 8 rectangles of side 1x1.
 * There are 5 rectangles of side 1x2.
 * There are 2 rectangles of side 1x3.
 * There are 4 rectangles of side 2x1.
 * There are 2 rectangles of side 2x2.
 * There are 2 rectangles of side 3x1.
 * There is 1 rectangle of side 3x2.
 * Total number of rectangles = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24.
 *
 * Example 3:
 * Input: mat = [[1,1,1,1,1,1]]
 * Output: 21
 *
 * Example 4:
 * Input: mat = [[1,0,1],[0,1,0],[1,0,1]]
 * Output: 5
 *
 * Constraints:
 * 1 <= rows <= 150
 * 1 <= columns <= 150
 * 0 <= mat[i][j] <= 1
 */
public class Solution {
    /*
        [[1,0,1],
         [1,1,0],
         [1,1,0]]

        [[1,0,1],
         [1,1,0],
         [1,1,0]]

         up=2
         down=2
         h=[1,1,0]
         res=2+1+1+3+3+3=13
    */
    // tc O(mmn), sc O(m)
    // https://leetcode.com/problems/count-submatrices-with-all-ones/discuss/720265/Java-Detailed-Explanation-From-O(MNM)-to-O(MN)-by-using-Stack
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int res = 0;
        for (int up = 0; up < m; up++) {
            int[] h = new int[n];
            Arrays.fill(h, 1);
            for (int down = up; down < m; down++) {
                for (int k = 0; k < n; k++) h[k] &= mat[down][k];
                res += countOneRow(h);
            }
        }
        return res;
    }

    private int countOneRow(int[] nums) {
        int res = 0, length = 0;
        for (int i = 0; i < nums.length; i++) {
            length = nums[i] == 0 ? 0 : length + 1;
            res += length;
        }
        return res;
    }
}
