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
    // tc O(n*m), sc O(1)
    int strStr(String haystack, String needle) {
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

    int strStr1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
