package backtracking.GenerateParentheses_22;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/
 *
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class Solution {
    // tc O(2^2n), sc O(n)
    List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        bt(n, 0, 0, new StringBuilder(), res);
        return res;
    }

    private void bt(int n, int opened, int closed, StringBuilder sb, List<String> res) {
        if (opened < closed || opened > n) return;
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }
        int len = sb.length();
        sb.append("(");
        bt(n, opened + 1, closed, sb, res);
        sb.setLength(len);
        sb.append(")");
        bt(n, opened, closed + 1, sb, res);
    }

    // tc O(4^n/sqrt(n)) - from leetcode solution, sc O(n)
    List<String> generateParenthesis1(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    private void backtrack(List<String> list, String str, int open, int close, int max) {
//        System.out.println(str);
        if (str.length() == max * 2) {
            list.add(str);
            return;
        }
        if (open < max) {
            backtrack(list, str + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(list, str + ")", open, close + 1, max);
        }
    }
}
