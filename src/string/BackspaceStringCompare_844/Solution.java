package string.BackspaceStringCompare_844;

import java.util.Stack;

/**
 * 844. Backspace String Compare
 * https://leetcode.com/problems/backspace-string-compare/
 *
 * Given two strings S and T, return if they are equal when both are typed into empty
 * text editors. # means a backspace character.
 *
 * Example 1:
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 *
 * Example 2:
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 *
 * Example 3:
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 *
 * Example 4:
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 *
 * Note:
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 * Follow up:
 *
 * Can you solve it in O(N) time and O(1) space?
 */
public class Solution {
    // tc O(max(m, n)), sc O(1)
    // 0 ms, faster than 100.00%; 37.6 MB, less than 6.06%
    public boolean backspaceCompare2(String S, String T) {
        int sharpCountS = 0, sharpCountT = 0;
        int i = S.length() - 1, j = T.length() - 1;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    sharpCountS++;
                    i--;
                } else if (sharpCountS > 0) {
                    sharpCountS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    sharpCountT++;
                    j--;
                } else if (sharpCountT > 0) {
                    sharpCountT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) return false;
            } else {
                return i < 0 && j < 0;
            }
            i--; j--;
        }
        return true;
    }

    // using stack
    // tc O(m + n), sc O(m + n)
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    private String build(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        return stack.toString();
    }
}
