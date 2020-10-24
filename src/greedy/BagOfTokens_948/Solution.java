package greedy.BagOfTokens_948;

import java.util.Arrays;

/**
 * 948. Bag of Tokens
 * https://leetcode.com/problems/bag-of-tokens/
 *
 * You have an initial power of P, an initial score of 0, and a bag of tokens
 * where tokens[i] is the value of the ith token (0-indexed).
 *
 * Your goal is to maximize your total score by potentially playing each token
 * in one of two ways:
 *
 * If your current power is at least tokens[i], you may play the ith token
 * face up, losing tokens[i] power and gaining 1 score.
 * If your current score is at least 1, you may play the ith token face down,
 * gaining tokens[i] power and losing 1 score.
 * Each token may be played at most once and in any order. You do not have
 * to play all the tokens.
 *
 * Return the largest possible score you can achieve after playing any number of tokens.
 *
 * Example 1:
 * Input: tokens = [100], P = 50
 * Output: 0
 * Explanation: Playing the only token in the bag is impossible because you
 * either have too little power or too little score.
 *
 * Example 2:
 * Input: tokens = [100,200], P = 150
 * Output: 1
 * Explanation: Play the 0th token (100) face up, your power becomes 50 and score becomes 1.
 * There is no need to play the 1st token since you cannot play it face up to add to your score.
 *
 * Example 3:
 * Input: tokens = [100,200,300,400], P = 200
 * Output: 2
 * Explanation: Play the tokens in this order to get a score of 2:
 * 1. Play the 0th token (100) face up, your power becomes 100 and score becomes 1.
 * 2. Play the 3rd token (400) face down, your power becomes 500 and score becomes 0.
 * 3. Play the 1st token (200) face up, your power becomes 300 and score becomes 1.
 * 4. Play the 2nd token (300) face up, your power becomes 0 and score becomes 2.
 *
 * Constraints:
 * 0 <= tokens.length <= 1000
 * 0 <= tokens[i], P < 10^4
 */
public class Solution {
    // tc O(nlogn), sc O(logn) since for sorting java uses quick sort which has logn space for recursion stack
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int n = tokens.length, l = 0, r = n - 1, curScore = 0, maxScore = 0;
        while (l <= r) {
            if (P >= tokens[l]) {
                P -= tokens[l];
                curScore++;
                l++;
                maxScore = Math.max(maxScore, curScore);
            } else if (curScore > 0) {
                P += tokens[r];
                curScore--;
                r--;
            } else {
                break;
            }
        }
        return maxScore;
    }

    // dynamic approach
    // TLE, sc O(n^n), sc O(n)
    public int bagOfTokensScore1(int[] tokens, int P) {
        return bt(tokens, P, 0);
    }

    private int bt(int[] tokens, int p, int score) {
        int res = score;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == -1) continue;
            int curToken = tokens[i];
            tokens[i] = -1;
            if (p >= curToken) {
                res = Math.max(res, bt(tokens, p - curToken, score + 1));
            }
            if (score > 0) {
                res = Math.max(res, bt(tokens, p + curToken, score - 1));
            }
            tokens[i] = curToken;
        }
        return res;
    }
}
