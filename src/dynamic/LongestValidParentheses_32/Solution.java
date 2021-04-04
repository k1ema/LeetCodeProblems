package dynamic.LongestValidParentheses_32;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 32. Longest Valid Parentheses
 * https://leetcode.com/problems/longest-valid-parentheses/
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed)
 * parentheses substring.
 *
 * Example 1:
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 *
 * Example 2:
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */
public class Solution {
    // dp, tc O(n), sc O(n)
    // 1 ms, faster than 100.00%; 39.1 MB, less than 32.13%
    // https://leetcode.com/problems/longest-valid-parentheses/discuss/1139982/Python-short-dp-explained
    /*
        Let's define dp[i] as a length of the longest valid substring ending at ith index. We have several cases now:
            1. if s[i] = (, answer is 0, because no valid parantheses can end with (
            2. case with s[i] = (. Let us look at the previous element. If it is equal to (, then we have () as two last elements
                and we can return dp(i-2) + 2.
            3. Now consider the case, when s[i-1] = ), it means, that we have the following situation: ...)). If we want to find the longest
                valid parentheses for i, first we need to deal with i-1. Define P = i - dp(i-1) - 1. Then we have the following situation:
                ...((.....))
                ...P.......i
                String from P + 1 to i - 1 indices including is the longest valid parentheses ending with i-1 place. What we can say about place P.
                If we have ) element on this place, then we need to return 0.
                In the case, when we have ...((.....)), answer is dp(i-1) + dp(P-1) + 2.
     */
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i > 1 ? dp[i - 2] : 0) + 2;
                } else {
                    int P = i - dp[i - 1] - 1;
                    if (P >= 0 && s.charAt(P) == '(') {
                        dp[i] = (P > 0 ? dp[P - 1] : 0) + dp[i - 1] + 2;
                    }
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // stack solution
    // tc O(n), sc O(n)
    // 2 ms, faster than 68.47%; 38.9 MB, less than 56.64%
    public int longestValidParentheses1(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }

    // TLE brute force, tc O(n^3), sc O(n)
    public int longestValidParentheses2(String s) {
        int res = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isValid(s.substring(i, j))) {
                    res = Math.max(res, j - i);
                }
            }
        }
        return res;
    }

    private boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
