package string.PalindromicSubstrings_647;

/**
 * 647. Palindromic Substrings
 * https://leetcode.com/problems/palindromic-substrings/
 *
 * Given a string, your task is to count how many palindromic substrings in this string.
 *
 * The substrings with different start indexes or end indexes are counted as different
 * substrings even they consist of same characters.
 *
 * Example 1:
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 * Example 2:
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 * Note:
 * The input string length won't exceed 1000.
 */
public class Solution {
    // tc O(n^2)
    // 1 ms, faster than 99.97%; 34.3 MB, less than 100.00%
    int countSubstrings(String s) {
        if (s == null || s.isEmpty()) return 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countPalindroms(s, i, i) + countPalindroms(s, i, i + 1);
        }
        return count;
    }

    // tc O(n)
    private int countPalindroms(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++;
            l--;
            r++;
        }
        return count;
    }
}
