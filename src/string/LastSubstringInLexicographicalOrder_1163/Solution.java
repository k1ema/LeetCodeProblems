package string.LastSubstringInLexicographicalOrder_1163;

/**
 * 1163. Last Substring in Lexicographical Order
 * https://leetcode.com/problems/last-substring-in-lexicographical-order/
 *
 * Given a string s, return the last substring of s in lexicographical order.
 *
 * Example 1:
 * Input: s = "abab"
 * Output: "bab"
 * Explanation: The substrings are ["a", "ab", "aba", "abab", "b", "ba", "bab"]. The lexicographically maximum substring is "bab".
 *
 * Example 2:
 * Input: s = "leetcode"
 * Output: "tcode"
 *
 * Constraints:
 * 1 <= s.length <= 4 * 10^5
 * s contains only lowercase English letters.
 */
public class Solution {
    // tc O(n), sc O(1)
    // 8 ms, faster than 90.87%; 41.3 MB, less than 76.93%
    public String lastSubstring(String s) {
        int i = 0, j = 1, k = 0;
        while (j + k < s.length()) {
            char ci = s.charAt(i + k), cj = s.charAt(j + k);
            if (ci == cj) {
                k++;
                continue;
            } else if (ci > cj) {
                j = j + k + 1;
            } else {
                i = Math.max(i + k + 1, j);
                j = i + 1;
            }
            k = 0;
        }
        return s.substring(i);
    }
}
