package binarySearch.KthSmallestElementInASortedMatrix_378;

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
    // tc O(min(K,N) + KlogN), sc O(N)
    // 16 ms, faster than 42.18%; 43.9 MB, less than 78.38%
    int kthSmallest1(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> matrix[n1.i][n1.j] - matrix[n2.i][n2.j]);
        for (int j = 0; j < n && j < k; j++) {
            pq.offer(new Node(0, j));
        }
        for (int i = 0; i < k - 1; i++) {
            Node t = pq.poll();
            if (t.i == n - 1) continue;
            pq.offer(new Node(t.i + 1, t.j));
        }
        Node node = pq.poll();
        return matrix[node.i][node.j];
    }

    private class Node {
        int i, j;
        Node(int i, int j) {
            this.i = i;
            this.j = j;
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
            int lessThanEqualMid = countLessEqual(matrix, mid, smallLargePair);
            if (lessThanEqualMid < k) {
                lo = smallLargePair[1];
            } else if (lessThanEqualMid > k) {
                hi = smallLargePair[0];
            } else {
                return smallLargePair[0];
            }
        }
        return lo;
    }

    private int countLessEqual(int[][] matrix, int mid, int[] smallLargePair) {
        int count = 0;
        int n = matrix.length;
        int row = n - 1;
        int col = 0;
        while (row >= 0 && col < n) {
            if (matrix[row][col] > mid) {
                smallLargePair[1] = Math.min(smallLargePair[1], matrix[row][col]);
                row--;
            } else {
                smallLargePair[0] = Math.max(smallLargePair[0], matrix[row][col]);
                count += row + 1;
                col++;
            }
        }
        return count;
    }

    // my straight forward solution
    // tc O(n^2*log(n^2))
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
