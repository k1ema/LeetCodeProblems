package dynamic.AllocateMailboxes_1478;

import java.util.Arrays;

/**
 * 1478. Allocate Mailboxes
 * https://leetcode.com/problems/allocate-mailboxes/
 *
 * Given the array houses and an integer k. where houses[i] is the location of the ith house along a street,
 * your task is to allocate k mailboxes in the street.
 *
 * Return the minimum total distance between each house and its nearest mailbox.
 *
 * The answer is guaranteed to fit in a 32-bit signed integer.
 *
 * Example 1:
 * Input: houses = [1,4,8,10,20], k = 3
 * Output: 5
 *
 * Explanation: Allocate mailboxes in position 3, 9 and 20.
 * Minimum total distance from each houses to nearest mailboxes is |3-1| + |4-3| + |9-8| + |10-9| + |20-20| = 5
 *
 * Example 2:
 * Input: houses = [2,3,5,12,18], k = 2
 * Output: 9
 *
 * Explanation: Allocate mailboxes in position 3 and 14.
 * Minimum total distance from each houses to nearest mailboxes is |2-3| + |3-3| + |5-3| + |12-14| + |18-14| = 9.
 *
 * Example 3:
 * Input: houses = [7,4,6,1], k = 1
 * Output: 8
 *
 * Example 4:
 * Input: houses = [3,6,14,10], k = 4
 * Output: 0
 *
 * Constraints:
 * n == houses.length
 * 1 <= n <= 100
 * 1 <= houses[i] <= 10^4
 * 1 <= k <= n
 * Array houses contain unique integers.
 */
public class Solution {
    // tc O(n^3 + k*n^2), sc O(n^2)
    // https://leetcode.com/problems/allocate-mailboxes/discuss/685620/JavaC%2B%2BPython-Top-down-DP-Prove-median-mailbox-O(n3)
    // https://leetcode.com/problems/allocate-mailboxes/discuss/685321/Java-or-Heavily-Commented-or-Simple-solution
    private int INF = 1_000_000;
    public int minDistance(int[] houses, int k) {
        int n = houses.length;
        Integer[][] memo = new Integer[n][k + 1];
        int[][] dists = new int[n][n];
        Arrays.sort(houses);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = i; l <= j; l++) {
                    dists[i][j] += Math.abs(houses[(i + j) / 2] - houses[l]);
                }
            }
        }
        return helper(n, 0, k, dists, memo);
    }

    private int helper(int n, int i, int k, int[][] dists, Integer[][] memo) {
        if (i == n && k == 0) return 0;
        if (i == n || k == 0) return INF;
        if (memo[i][k] != null) return memo[i][k];

        int minDist = INF;
        for (int j = i; j < n; j++) {
            minDist = Math.min(minDist, dists[i][j] + helper(n, j + 1, k - 1, dists, memo));
        }

        return memo[i][k] = minDist;
    }

    // tc O(k * n^3), sc O(n*k)
    // There are n * k DP states with each performing n * n operations. O(k * n^3)
    // https://leetcode.com/problems/allocate-mailboxes/discuss/685321/Java-or-Heavily-Commented-or-Simple-solution
    public int minDistance1(int[] houses, int k) {
        int n = houses.length;
        int[][] memo = new int[n][k + 1];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        Arrays.sort(houses);
        return solve(houses, n, 0, k, 0, memo);
    }

    private int solve(int[] houses, int n, int pos, int k, int curK, int[][] memo) {
        if (pos == n && curK == k) return 0;
        if (pos == n || curK == k) return INF;
        if (memo[pos][curK] != -1) return memo[pos][curK];

        int minDist = INF;
        for (int i = pos; i < n; i++) {
            int median = houses[(i + pos) / 2];

            int dist = 0;
            for (int j = pos; j <= i; j++) {
                dist += Math.abs(houses[j] - median);
            }

            minDist = Math.min(minDist, solve(houses, n, i + 1, k, curK + 1, memo) + dist);
        }

        memo[pos][curK] = minDist;
        return minDist;
    }
}
