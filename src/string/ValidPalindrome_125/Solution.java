package string.ValidPalindrome_125;

/**
 * 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric
 * characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 *
 * Example 2:
 * Input: "race a car"
 * Output: false
 */
public class Solution {
    // tc O(n), sc O(1)
    boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.isEmpty()) return true;

        int len = s.length();
        int p1 = 0;
        int p2 = len - 1;
        while (p1 < len && p2 >= 0) {
            char c1 = s.charAt(p1);
            if (!Character.isLetterOrDigit(c1)) {
                p1++;
                continue;
            }
            char c2 = s.charAt(p2);
            if (!Character.isLetterOrDigit(c2)) {
                p2--;
                continue;
            }
            if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                return false;
            }
            p1++;
            p2--;
        }

        return true;
    }
}
