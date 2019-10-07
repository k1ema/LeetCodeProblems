package heap.KthSmallestElementInASortedMatrix_378;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 378. Kth Smallest Element in a Sorted Matrix
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 *
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order,
 * find the kth smallest element in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * Example:
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * return 13.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 */
public class Solution {
    // https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85173/Share-my-thoughts-and-Clean-Java-Code
    // 17 ms 44.1 MB
    int kthSmallest1(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for (int j = 0; j < n; j++) {
            pq.offer(new Tuple(0, j, matrix[0][j]));
        }
        for (int i = 0; i < k - 1; i++) {
            Tuple t = pq.poll();
            if (t.x == n - 1) continue;
            pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }
        return pq.poll().val;
    }

    private class Tuple implements Comparable<Tuple> {
        int x, y, val;
        Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo (Tuple that) {
            return this.val - that.val;
        }
    }

    // binary search
    // https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/301357/Simple-to-understand-solutions-using-Heap-and-Binary-Search-JavaPython
    // 0 ms, faster than 100.00%; 44.1 MB, less than 67.57%
    // tc O(log(max - min)), sc O(1)
    int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[n - 1][n - 1];
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int[] smallLargePair = new int[] {lo, hi};
            int count = 0;
            int row = 0;
            int col = n - 1;
            while (row < n && col >= 0) {
                if (matrix[row][col] > mid) {
                    smallLargePair[1] = Math.min(smallLargePair[1], matrix[row][col]);
                    col--;
                } else {
                    smallLargePair[0] = Math.max(smallLargePair[0], matrix[row][col]);
                    count += col + 1;
                    row++;
                }
            }

            if (count < k) {
                lo = smallLargePair[1];
            } else if (count > k) {
                hi = smallLargePair[0];
            } else {
                return smallLargePair[0];
            }
        }
        return lo;
    }

    // my straight forward solution
    // 9 ms; 44 MB
    int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        int[] result = new int[n * n];
        int z = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[z++] = matrix[i][j];
            }
        }
        Arrays.sort(result);
        return result[k - 1];
    }
}
