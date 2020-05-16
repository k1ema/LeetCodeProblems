package string.ConsecutiveCharacters_1446;

/**
 * 1446. Consecutive Characters
 * https://leetcode.com/problems/consecutive-characters/
 *
 * Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one unique character.
 *
 * Return the power of the string.
 *
 * Example 1:
 * Input: s = "leetcode"
 * Output: 2
 * Explanation: The substring "ee" is of length 2 with the character 'e' only.
 *
 * Example 2:
 * Input: s = "abbcccddddeeeeedcba"
 * Output: 5
 * Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
 *
 * Example 3:
 * Input: s = "triplepillooooow"
 * Output: 5
 *
 * Example 4:
 * Input: s = "hooraaaaaaaaaaay"
 * Output: 11
 *
 * Example 5:
 * Input: s = "tourist"
 * Output: 1
 *
 * Constraints:
 * 1 <= s.length <= 500
 * s contains only lowercase English letters.
 */
public class Solution {
    public int maxPower(String s) {
        if (s.length() == 1) return 1;
        int count = 1;
        int max = 1;
        char cur = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == cur) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
                cur = s.charAt(i);
            }
        }
        return Math.max(max, count);
    }
}
