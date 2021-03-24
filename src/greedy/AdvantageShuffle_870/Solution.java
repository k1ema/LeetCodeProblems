package greedy.AdvantageShuffle_870;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 870. Advantage Shuffle
 * https://leetcode.com/problems/advantage-shuffle/
 *
 * Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].
 *
 * Return any permutation of A that maximizes its advantage with respect to B.
 *
 * Example 1:
 * Input: A = [2,7,11,15], B = [1,10,4,11]
 * Output: [2,11,7,15]
 *
 * Example 2:
 * Input: A = [12,24,8,32], B = [13,25,32,11]
 * Output: [24,32,8,12]
 *
 * Note:
 * 1 <= A.length = B.length <= 10000
 * 0 <= A[i] <= 10^9
 * 0 <= B[i] <= 10^9
 */
public class Solution {
    // tc O(nlogn), sc O(n)
    // 30 ms, faster than 71.57%; 41.3 MB, less than 78.80%
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        int n = A.length;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < n; i++) {
            pq.add(new int[] {B[i], i});
        }
        int[] res = new int[n];
        int l = 0, r = n - 1;
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int num = p[0], ind = p[1];
            res[ind] = A[r] > num ? A[r--] : A[l++];
        }
        return res;
    }

    // tc O(n^2) in worst case, sc O(n)
    // 25 ms; 41.4 MB
    public int[] advantageCount1(int[] A, int[] B) {
        Arrays.sort(A);
        List<Integer> indices = new ArrayList<>();
        int n = A.length;
        boolean[] used = new boolean[n];
        for (int b : B) {
            int l = -1, r = n;
            while (r - l > 1) {
                int m = l + (r - l) / 2;
                if (A[m] <= b) {
                    l = m;
                } else {
                    r = m;
                }
            }
            while (r < n && used[r]) {
                r++;
            }

            if (r == n) {
                for (int i = 0; i < n; i++) {
                    if (used[i]) continue;
                    r = i;
                    break;
                }
            }
            indices.add(r);
            used[r] = true;
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = A[indices.get(i)];
        }
        return res;
    }

    // tc O(n^2), sc O(n)
    // 2303 ms, 40.8 MB
    public int[] advantageCount2(int[] A, int[] B) {
        Arrays.sort(A);
        List<Integer> indices = new ArrayList<>();
        boolean[] used = new boolean[A.length];
        for (int b : B) {
            int cand = Integer.MAX_VALUE, candInd = -1;
            for (int i = 0; i < A.length; i++) {
                if (!used[i] && A[i] > b && A[i] < cand) {
                    cand = A[i];
                    candInd = i;
                }
            }
            if (candInd == -1) {
                for (int i = 0; i < A.length; i++) {
                    if (used[i]) continue;
                    candInd = i;
                    break;
                }
            }
            indices.add(candInd);
            used[candInd] = true;
        }
        int[] res = new int[A.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = A[indices.get(i)];
        }
        return res;
    }
}
