package array.ImageOverlap_835;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 835. Image Overlap
 * https://leetcode.com/problems/image-overlap/
 *
 * Two images A and B are given, represented as binary, square matrices of the same size.
 * (A binary matrix has only 0s and 1s as values.)
 *
 * We translate one image however we choose (sliding it left, right, up, or down any number
 * of units), and place it on top of the other image.  After, the overlap of this
 * translation is the number of positions that have a 1 in both images.
 *
 * (Note also that a translation does not include any kind of rotation.)
 *
 * What is the largest possible overlap?
 *
 * Example 1:
 * Input: A = [[1,1,0],
 *             [0,1,0],
 *             [0,1,0]]
 *        B = [[0,0,0],
 *             [0,1,1],
 *             [0,0,1]]
 * Output: 3
 *
 * Explanation: We slide A to right by 1 unit and down by 1 unit.
 *
 * Notes:
 * 1 <= A.length = A[0].length = B.length = B[0].length <= 30
 * 0 <= A[i][j], B[i][j] <= 1
 */
public class Solution {
    // tc O(n^4), sc O(n^2)
    // https://leetcode.com/problems/image-overlap/discuss/130623/C%2B%2BJavaPython-Straight-Forward
    public int largestOverlap(int[][] A, int[][] B) {
        List<Integer> la = new ArrayList<>();
        List<Integer> lb = new ArrayList<>();
        int n = A.length;
        for (int i = 0; i < n * n; i++) {
            if (A[i / n][i % n] == 1) la.add(i / n * 100 + i % n);
            if (B[i / n][i % n] == 1) lb.add(i / n * 100 + i % n);
        }
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : la) for (int b : lb) {
            count.put(a - b, count.getOrDefault(a - b, 0) + 1);
        }
        int res = 0;
        for (int r : count.values()) {
            res = Math.max(res, r);
        }
        return res;
    }

    /*
        brute force solution O(n^4), n - width/height:
        for each cell i,j translate matrix
            from 0,0 to i,j put top of matrix
            from 0,0 to i,j put bottom of matrix
            and compare it with B
    */
    public int largestOverlap1(int[][] A, int[][] B) {
        int res = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int[][] a = translateTop(A, i, j, n);
                res = Math.max(res, compareMatrices(a, B));
                a = translateBottom(A, i, j, n);
                res = Math.max(res, compareMatrices(a, B));
            }
        }
        return res;
    }

    private int[][] translateTop(int[][] A, int i, int j, int n) {
        if (i == 0 && j == 0) return A;
        int[][] a = new int[n][n];
        for (int k = i; k < n; k++) {
            for (int l = j; l < n; l++) {
                a[k][l] = A[k - i][l - j];
            }
        }
        return a;
    }

    private int[][] translateBottom(int[][] A, int i, int j, int n) {
        if (i == n - 1 && j == n - 1) return A;
        int[][] a = new int[n][n];
        for (int k = i; k >= 0; k--) {
            for (int l = j; l >= 0; l--) {
                a[k][l] = A[n - 1 - i + k][n - 1 - j + l];
            }
        }
        return a;
    }

    private int compareMatrices(int[][] A, int[][] B) {
        int res = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1 && B[i][j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}
