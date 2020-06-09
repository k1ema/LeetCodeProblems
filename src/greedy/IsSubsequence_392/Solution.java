package greedy.IsSubsequence_392;

/**
 * 392. Is Subsequence
 * https://leetcode.com/problems/is-subsequence/
 *
 * Given a string s and a string t, check if s is subsequence of t.
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some
 * (can be none) of the characters without disturbing the relative positions of the remaining characters.
 * (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one
 * to see if T has its subsequence. In this scenario, how would you change your code?
 *
 * Credits:
 * Special thanks to @pbrother for adding this problem and creating all test cases.
 *
 * Example 1:
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 *
 * Example 2:
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 *
 * Constraints:
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * Both strings consists only of lowercase characters.
 */
public class Solution {
    // tc O(T), where T = t.length(), sc O(1)
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) return false;
        if (s.isEmpty() || t.isEmpty()) return s.isEmpty();
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    // recursive
    // tc O(T), sc O(T), where T = t.length()
    public boolean isSubsequence1(String s, String t) {
        if (s == null || t == null) return false;
        if (s.isEmpty() || t.isEmpty()) return s.isEmpty();
        return bt(s, t, 0, 0);
    }

    private boolean bt(String s, String t, int i, int j) {
        if (i == s.length() || j == t.length()) return i == s.length();
        boolean b;
        if (s.charAt(i) == t.charAt(j)) {
            b = bt(s, t, i + 1, j + 1);
        } else {
            b = bt(s, t, i, j + 1);
        }
        return b;
    }
}
