package string.MinimumRemoveToMakeValidParentheses_1249;

import java.util.HashSet;
import java.util.Set;

/**
 * 1249. Minimum Remove to Make Valid Parentheses
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 *
 * Given a string s of '(' , ')' and lowercase English characters.
 *
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the
 * resulting parentheses string is valid and return any valid string.
 *
 * Formally, a parentheses string is valid if and only if:
 *
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 *
 * Example 1:
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 *
 * Example 2:
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 *
 * Example 3:
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 *
 * Example 4:
 * Input: s = "(a(b(c)d)"
 * Output: "a(b(c)d)"
 *
 * Constraints:
 * 1 <= s.length <= 10^5
 * s[i] is one of  '(' , ')' and lowercase English letters.
 */
public class Solution {
    public String minRemoveToMakeValid(String s) {
        int balance = 0;
        Set<Integer> toRemove = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                balance--;
            } else if (c == '(') {
                balance++;
            }
            if (balance < 0) {
                toRemove.add(i);
                balance = 0;
            }
        }
        int j = s.length() - 1;
        while (balance > 0 && j >= 0) {
            char c = s.charAt(j);
            if (c == '(') {
                toRemove.add(j);
                balance--;
            }
            j--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (toRemove.contains(i)) {
                continue;
            }
            sb.append("" + c);
        }

        return sb.toString();
    }
}
