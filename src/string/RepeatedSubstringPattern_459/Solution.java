package string.RepeatedSubstringPattern_459;

import java.util.ArrayList;
import java.util.List;

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
    // tc O(n); sc O(1)
    // Rabin-Karp
    // 6 ms, faster than 92.43%; 40 MB, less than 72.71%
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() < 2) return false;
        if (s.length() == 2) return s.charAt(0) == s.charAt(1);
        int n = s.length();
        for (int i = (int) Math.sqrt(n); i > 0; i--) {
            if (n % i == 0) {
                List<Integer> divisors = new ArrayList<>();
                divisors.add(i);
                if (i != 1) {
                    divisors.add(n / i);
                }

                for (int l : divisors) {
                    String str = s.substring(0, l);
                    int startHash = str.hashCode();
                    int curHash = startHash;
                    int start = l;
                    while (start != n && curHash == startHash) {
                        curHash = s.substring(start, start + l).hashCode();
                        start += l;
                    }
                    if (start == n && curHash == startHash) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // tc O(?); sc O(1)
    // 15 ms, faster than 66.60%; 39.6 MB, less than 14.29%
    public boolean repeatedSubstringPattern3(String s) {
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

    // tc O(n^2), sc O(n)
    // 70 ms, faster than 31.18%; 39.9 MB, less than 9.52%
    public boolean repeatedSubstringPattern1(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

    // tc O(n^2), sc O(1)
    // 127 ms, faster than 16.66%; 39.6 MB, less than 14.29%
    public boolean repeatedSubstringPattern2(String s) {
        if (s == null || s.length() < 2) return false;
        int n = s.length();

        for (int i = 1; i <= n / 2; i++) {
            String substr = s.substring(0, i);
            for (int j = i; j + i <= n; j += i) {
                String substr2 = s.substring(j, j + i);
                if (!substr.equals(substr2)) break;
                if (j + i == n) return true;
            }
        }

        return false;
    }
}
