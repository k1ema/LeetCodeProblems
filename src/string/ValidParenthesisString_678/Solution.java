package string.ValidParenthesisString_678;

import java.util.ArrayList;
import java.util.List;

/**
 * 678. Valid Parenthesis String
 * https://leetcode.com/problems/valid-parenthesis-string/
 *
 * Given a string containing only three types of characters: '(', ')' and '*', write a function
 * to check whether this string is valid. We define the validity of a string by these rules:
 *
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '('
 * or an empty string.
 *
 * An empty string is also valid.
 *
 * Example 1:
 * Input: "()"
 * Output: True
 *
 * Example 2:
 * Input: "(*)"
 * Output: True
 *
 * Example 3:
 * Input: "(*))"
 * Output: True
 *
 * Note:
 * The string size will be in the range [1, 100].
 */
public class Solution {
    // tc O(n); sc O(1)
    // 0 ms, faster than 100.00%; 36.9 MB, less than 5.00%
    // lo and hi stands for a range with min and max number of possible open brackets
    // if we meet '(' - both lo and hi should be incremented
    // https://leetcode.com/problems/valid-parenthesis-string/discuss/107577/Short-Java-O(n)-time-O(1)-space-one-pass
    public boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                lo++;
                hi++;
            } else if (c == ')') {
                if (lo > 0) lo--;
                hi--;
            } else {
                if (lo > 0) lo--;
                hi++;
            }
            if (hi < 0) return false;
        }
        return lo == 0;
    }

    // brute force, TLE
    // tc O(n * 3^k), sc O(n), n = s.length, k = number of stars
    public boolean checkValidString2(String s) {
        if (s == null || s.length() == 0) return true;
        if (!s.contains("*")) {
            return checkString(s);
        }

        List<Integer> starIndexes = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') starIndexes.add(i);
        }

        return bt(s, starIndexes, 0);
    }

    private boolean bt(String s, List<Integer> starIndexes, int ind) {
        if (ind == starIndexes.size()) return checkString(s);
        int sInd = starIndexes.get(ind);
        String s1 = s.substring(0, sInd) + " " + s.substring(sInd + 1);
        String s2 = s.substring(0, sInd) + "(" + s.substring(sInd + 1);
        String s3 = s.substring(0, sInd) + ")" + s.substring(sInd + 1);
        boolean b = bt(s1, starIndexes, ind + 1);
        b |= bt(s2, starIndexes, ind + 1);
        b |= bt(s3, starIndexes, ind + 1);
        return b;
    }

    private boolean checkString(String s) {
        int open = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') continue;
            if (c == '(') {
                open++;
            } else {
                open--;
                if (open < 0) return false;
            }
        }
        return open == 0;
    }
}
