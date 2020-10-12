package greedy.RemoveDuplicateLetters_316;

/**
 * 316. Remove Duplicate Letters
 * https://leetcode.com/problems/remove-duplicate-letters/
 *
 * Given a string s, remove duplicate letters so that every letter
 * appears once and only once. You must make sure your result is the
 * smallest in lexicographical order among all possible results.
 *
 * Note: This question is the same as 1081:
 * https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 *
 * Example 1:
 * Input: s = "bcabc"
 * Output: "abc"
 *
 * Example 2:
 * Input: s = "cbacdcbc"
 * Output: "acdb"
 *
 * Constraints:
 * 1 <= s.length <= 104
 * s consists of lowercase English letters.
 */
public class Solution {
    // tc O(n*C) = O(n)
    // where C = 26, The number of recursive calls is bounded by a constant (26 letters in the alphabet)
    // sc O(n)
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < s.charAt(pos)) {
                pos = i;
            }
            if (--freq[c - 'a'] == 0) break;
        }
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(
                s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
}
