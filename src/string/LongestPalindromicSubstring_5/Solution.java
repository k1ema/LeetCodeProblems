package string.LongestPalindromicSubstring_5;

/**
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the
 * maximum length of s is 1000.
 *
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 */
public class Solution {
    // tc O(n^2), sc O(1)
    // 5 ms, faster than 96.63%; 35.7 MB, less than 100.00%
    private int lo, maxLen;
    String longestPalindrome2(String s) {
        lo = 0; maxLen = 0;
        if (s == null || s.length() < 2) return s;
        for (int i = 0; i < s.length() - 1; i++) {
            expandPalindrome(s, i, i);
            expandPalindrome(s, i, i + 1);
        }
        return s.substring(lo, lo + maxLen);
    }

    private void expandPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        if (r - l - 1 > maxLen) {
            lo = l + 1;
            maxLen = r - l - 1;
        }
    }

    // same but without global variables
    String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    // Manacher's algorithm - O(n)
    // http://e-maxx.ru/algo/palindromes_count
    // Most of the people in Leetcode use O(n^2) solution
    String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        int left = 0, right = -1;
        int[] oddPalindromeMaxLen = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            // int symmetricIndex = left + right - i; - so we can use this data. For instance:
            // symmetricIndex is 'a' in 'bab' - so it oddPalindromeMaxLen[symmetricIndex]=3,
            // so k is the center of 'bab' as well, and oddPalindromeMaxLen[k] should be at least 3, or greater.
            // If symmetricIndex is 'b' in 'abc' - oddPalindromeMaxLen[symmetricIndex]=1. =>
            // oddPalindromeMaxLen[k] = 1;
            // right-i - to cut the palindrome if we are close to the right edge.
            int len = (i > right ? 0 : Math.min(oddPalindromeMaxLen[left + right - i], right - i)) + 1;
            // int localLeft = i-currLen, localRight = i+currLen;
            while (i - len >= 0 && i + len < s.length() && s.charAt(i - len) == s.charAt(i + len)) {
                len++;
            }
            oddPalindromeMaxLen[i] = len;
            len--;

            // We should keep the left & right of the most right palindrome.
            if (i + len > right) {
                right = i + len;
                left = i - len;
            }
        }

        int index = 0;
        // find longest palindrome
        for (int i = 0; i < oddPalindromeMaxLen.length; i++) {
            if (oddPalindromeMaxLen[i] > oddPalindromeMaxLen[index]) {
                index = i;
            }
        }
        int start = index - oddPalindromeMaxLen[index] + 1;
        int end = index + oddPalindromeMaxLen[index];
        String s1 = s.substring(start, end);

        left = 0;
        right = -1;
        int[] evenPalindromeMaxLen = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int len = (i > right ? 0 : Math.min(evenPalindromeMaxLen[left + right - i + 1], right - i + 1)) + 1;
            while (i - len >= 0 && i + len - 1 < s.length() && s.charAt(i - len) == s.charAt(i + len - 1)) {
                len++;
            }
            len--;
            evenPalindromeMaxLen[i] = len;

            // We should keep the left & right of the most right palindrome.
            if (i + len - 1 > right) {
                right = i + len - 1;
                left = i - len;
            }
        }

        index = 0;
        // find longest palindrome
        for (int i = 0; i < evenPalindromeMaxLen.length; i++) {
            if (evenPalindromeMaxLen[i] > evenPalindromeMaxLen[index]) {
                index = i;
            }
        }
        start = index - evenPalindromeMaxLen[index];
        end = index + evenPalindromeMaxLen[index];
        String s2 = s.substring(start, end);
        return s1.length() > s2.length() ? s1 : s2;
    }
}
