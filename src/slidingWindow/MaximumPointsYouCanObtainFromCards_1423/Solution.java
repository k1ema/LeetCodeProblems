package slidingWindow.MaximumPointsYouCanObtainFromCards_1423;

import java.util.HashMap;
import java.util.Map;

/**
 * 1423. Maximum Points You Can Obtain from Cards
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 *
 * There are several cards arranged in a row, and each card has an associated number of points
 * The points are given in the integer array cardPoints.
 *
 * In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
 *
 * Your score is the sum of the points of the cards you have taken.
 *
 * Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
 *
 * Example 1:
 * Input: cardPoints = [1,2,3,4,5,6,1], k = 3
 * Output: 12
 * Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will
 * maximize your total score. The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
 *
 * Example 2:
 * Input: cardPoints = [2,2,2], k = 2
 * Output: 4
 * Explanation: Regardless of which two cards you take, your score will always be 4.
 *
 * Example 3:
 * Input: cardPoints = [9,7,7,9,7,7,9], k = 7
 * Output: 55
 * Explanation: You have to take all the cards. Your score is the sum of points of all cards.
 *
 * Example 4:
 * Input: cardPoints = [1,1000,1], k = 1
 * Output: 1
 * Explanation: You cannot take the card in the middle. Your best score is 1.
 *
 * Example 5:
 * Input: cardPoints = [1,79,80,1,1,1,200,1], k = 3
 * Output: 202
 *
 * Constraints:
 * 1 <= cardPoints.length <= 10^5
 * 1 <= cardPoints[i] <= 10^4
 * 1 <= k <= cardPoints.length
 */
public class Solution {
    // prefix sum
    // tc O(n), sc O(n)
    // 2 ms, faster than 55.08%; 46.5 MB, less than 96.37%
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length, totalSum = 0;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + cardPoints[i];
            totalSum += cardPoints[i];
        }
        int minSum = Integer.MAX_VALUE;
        for (int i = n - k; i <= n; i++) {
            minSum = Math.min(minSum, prefixSum[i] - prefixSum[i - n + k]);
        }
        return totalSum - minSum;
    }

    // dp, TLE
    // tc O(n^2), sc O(n^2)
    public int maxScore1(int[] cardPoints, int k) {
        int n = cardPoints.length;
        return helper(cardPoints, k, 0, n - 1, new HashMap<>());
    }

    private int helper(int[] cardPoints, int k, int i, int j, Map<Long, Integer> memo) {
        if (k == 0 || i > j) {
            return 0;
        }
        int n = cardPoints.length;
        long key = i + (long) n * j + (long) n * n * k;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int res = Math.max(cardPoints[i] + helper(cardPoints, k - 1, i + 1, j, memo), cardPoints[j] + helper(cardPoints, k - 1, i, j - 1, memo));
        memo.put(key, res);
        return res;
    }
}
