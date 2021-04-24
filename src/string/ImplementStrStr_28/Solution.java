package string.ImplementStrStr_28;

/**
 * 28. Implement strStr()
 * https://leetcode.com/problems/implement-strstr/
 *
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent
 * to C's strstr() and Java's indexOf().
 */
public class Solution {
    // Rabin-Karp
    // tc O(haystack.len), sc O(1)
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) return 0;
        if ("".equals(haystack)) return -1;
        if (needle.length() > haystack.length()) return -1;

        final int m = haystack.length(), n = needle.length();
        final int mod = (int) 1e9 + 7;
        final int p = 26;
        long p_pow_n = 1, H = 0, h = 0;
        for (int i = 0; i < n; i++) {
            int c = needle.charAt(i) - 'a';
            H = (H * p + c) % mod;
            p_pow_n = (p * p_pow_n) % mod;

            int d = haystack.charAt(i) - 'a';
            h = (h * p + d) % mod;
        }
        if (h == H) return 0;

        for (int i = n; i < m; i++) {
            int new_char = haystack.charAt(i) - 'a';
            int old_char = haystack.charAt(i - n) - 'a';
            h = (h * p - old_char * p_pow_n + new_char) % mod;
            if (h == H) return i - n + 1;
        }
        return -1;
    }

    // tc O(m*n), sc O(1)
    public int strStr2(String haystack, String needle) {
        if ("".equals(needle)) return 0;
        if ("".equals(haystack)) return -1;
        if (needle.length() > haystack.length()) return -1;
        boolean b = true;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (needle.length() > haystack.substring(i).length()) return -1;
                for (int j = 1; j < needle.length(); j++) {
                    b = b && (haystack.charAt(i + j) == needle.charAt(j));
                    if (!b) break;
                }
                if (b) return i;
                else b = true;
            }
        }
        return -1;
    }

    public int strStr3(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
