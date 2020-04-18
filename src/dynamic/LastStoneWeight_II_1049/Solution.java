package dynamic.LastStoneWeight_II_1049;

/**
 * 1049. Last Stone Weight II
 * https://leetcode.com/problems/last-stone-weight-ii/
 *
 * We have a collection of rocks, each rock has a positive integer weight.
 *
 * Each turn, we choose any two rocks and smash them together. Suppose the stones have
 * weights x and y with x <= y.  The result of this smash is:
 *
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y
 * has new weight y-x.
 * At the end, there is at most 1 stone left. Return the smallest possible weight of
 * this stone (the weight is 0 if there are no stones left.)
 *
 * Example 1:
 * Input: [2,7,4,1,8,1]
 * Output: 1
 *
 * Explanation:
 * We can combine 2 and 4 to get 2 so the array converts to [2,7,1,8,1] then,
 * we can combine 7 and 8 to get 1 so the array converts to [2,1,1,1] then,
 * we can combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we can combine 1 and 1 to get 0 so the array converts to [1] then that's the optimal value.
 *
 * Note:
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 100
 */
public class Solution {
    /*
        1. calc the sum of all stones.
        2. we have to find out the sum of stones that fit x = sum/2 (knapsack problem)
        2. return sum - 2*x

          0 1 2 3 4 5 6 7 8 9 10 11
        2 0 0 2 2 2 2 2 2 2 2  2  2
        7 0 0 2 2 2 2 2 7 7 9  9  9
        4 0 0 2 2 4 4 6 7 7 9  9 11
        1 0 1 2 3 4 5 6 7 8 9 10 11
        8 0 1 2 3 4 5 6 7 8 9 10 11
        1 0 1 2 3 4 5 6 7 8 9 10 11
     */
    // tc O(m * n) where m = stones.length, n = sum / 2
    // 7 ms, faster than 20.05%; 39.7 MB, less than 100.00%
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int x = sum / 2;
        int n = stones.length;
        int[][] dp = new int[n][x + 1];

        for (int i = stones[0]; i < dp[0].length; i++) {
            dp[0][i] = stones[0];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < stones[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                }
            }
        }

        return sum - 2 * dp[n - 1][x];
    }
}
