package array.SortArrayByParity_905;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 905. Sort Array By Parity
 * https://leetcode.com/problems/sort-array-by-parity/
 *
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 *
 *
 *
 * Example 1:
 *
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 *
 *
 * Note:
 *
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 */
public class Solution {
    // tc O(n), sc O(1)
    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length < 2) return A;
        int n = A.length;
        int i = 0, j = n - 1;
        while (i < j) {
            while (i < n && A[i] % 2 == 0) i++;
            while (j >= 0 && A[j] % 2 == 1) j--;
            if (i < j) swap(A, i, j);
            i++; j--;
        }
        return A;
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    // tc O(n), sc O(n)
    public int[] sortArrayByParity1(int[] A) {
        Queue<Integer> even = new LinkedList<>();
        Queue<Integer> odd = new LinkedList<>();
        for (int a : A) {
            if (a % 2 == 0) even.add(a);
            else odd.add(a);
        }
        int i = 0;
        while (!even.isEmpty()) {
            A[i++] = even.poll();
        }
        while (!odd.isEmpty()) {
            A[i++] = odd.poll();
        }
        return A;
    }
}
