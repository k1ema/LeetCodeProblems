package string.OneEditDistance_161;

/**
 * 161. One Edit Distance
 * https://leetcode.com/problems/one-edit-distance/
 *
 * Given two strings s and t, return true if they are both one edit distance apart, otherwise return false.
 *
 * A string s is said to be one distance apart from a string t if you can:
 *
 * Insert exactly one character into s to get t.
 * Delete exactly one character from s to get t.
 * Replace exactly one character of s with a different character to get t.
 *
 *
 * Example 1:
 * Input: s = "ab", t = "acb"
 * Output: true
 * Explanation: We can insert 'c' into s to get t.
 *
 * Example 2:
 * Input: s = "", t = ""
 * Output: false
 * Explanation: We cannot get t from s by only one step.
 *
 * Example 3:
 * Input: s = "a", t = ""
 * Output: true
 *
 * Example 4:
 * Input: s = "", t = "A"
 * Output: true
 *
 * Constraints:
 * 0 <= s.length <= 104
 * 0 <= t.length <= 104
 * s and t consist of lower-case letters, upper-case letters and/or digits.
 */
public class Solution {
    // tc O(n), sc O(n)
    // https://leetcode.com/problems/one-edit-distance/discuss/50098/My-CLEAR-JAVA-solution-with-explanation
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        for (int i = 0; i < Math.min(m, n); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (m == n) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else if (m < n) {
                    return s.substring(i).equals(t.substring(i + 1));
                } else {
                    return s.substring(i + 1).equals(t.substring(i));
                }
            }
        }
        return Math.abs(m - n) == 1;
    }

    // my solution
    // tc O(n), sc O(n)
    public boolean isOneEditDistance1(String s, String t) {
        int m = s.length(), n = t.length();
        if (Math.abs(m - n) > 1) return false;
        if (m == n) {
            if (s.equals(t)) return false;
            boolean alreadyReplaced = false;
            for (int i = 0; i < m; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (alreadyReplaced) {
                        return false;
                    } else {
                        alreadyReplaced = true;
                    }
                }
            }
            return true;
        }
        if (m > n) {
            String tmp = s;
            s = t;
            t = tmp;
        }
        boolean alreadyInserted = false;
        int i = 0, j = 0;
        while (i < s.length()) {
            if (s.charAt(i++) != t.charAt(j++)) {
                if (alreadyInserted) {
                    return false;
                } else {
                    alreadyInserted = true;
                    i--;
                }
            }
        }

        return alreadyInserted || i == j;
    }
}
