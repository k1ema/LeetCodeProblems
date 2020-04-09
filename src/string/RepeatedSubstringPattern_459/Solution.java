package string.RepeatedSubstringPattern_459;

/**
 * 459. Repeated Substring Pattern
 * https://leetcode.com/problems/repeated-substring-pattern/
 *
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending
 * multiple copies of the substring together. You may assume the given string consists of lowercase
 * English letters only and its length will not exceed 10000.
 *
 * Example 1:
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 *
 * Example 2:
 * Input: "aba"
 * Output: False
 *
 * Example 3:
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class Solution {
    // tc O(?); sc O(1)
    // 15 ms, faster than 66.60%; 39.6 MB, less than 14.29%
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = n / 2; i > 0; i--) {
            if (n % i == 0) {
                int m = n / i;
                String str = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                sb.append(str.repeat(m));
                if (sb.toString().equals(s)) return true;
            }
        }
        return false;
    }

    // 70 ms, faster than 31.18%; 39.9 MB, less than 9.52%
    public boolean repeatedSubstringPattern1(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

    /*
       v
    abcabcd
          ^
    for i = 1..n-1
        bool res = true
        find s = substr(0, i)
        store len = substr.len
        int j = i + len
        while j <= s.len
            res &= compare new subtring(i, j) with s
            if (!res || j == s.len) break
            j +=len
        if j == s.length && res return true
     return false
     */
    // tc O(n^2), sc O(1)
    // 127 ms, faster than 16.66%; 39.6 MB, less than 14.29%
    public boolean repeatedSubstringPattern2(String s) {
        for (int i = 1; i < s.length(); i++) {
            boolean res = true;
            String substr = s.substring(0, i);
            int len = substr.length();
            int j = i + len;
            if (j > s.length()) return false;
            while (j <= s.length()) {
                String s2 = s.substring(j - len, j);
                res = substr.equals(s2);
                if (!res || j == s.length()) break;
                j += len;
            }
            if (res && j == s.length()) return true;
        }
        return false;
    }
}
